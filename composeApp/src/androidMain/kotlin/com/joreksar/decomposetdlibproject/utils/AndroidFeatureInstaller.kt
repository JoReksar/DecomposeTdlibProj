package com.joreksar.decomposetdlibproject.utils

import android.content.Context
import com.google.android.play.core.ktx.sessionId
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallSessionState
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.job
import kotlin.coroutines.cancellation.CancellationException
import kotlin.coroutines.coroutineContext

class AndroidFeatureInstaller(context: Context) : FeatureInstaller {

    private val manager = SplitInstallManagerFactory.create(context)

    override suspend fun install(moduleName: String) : Deferred<FeatureInstaller.Result> {

        if (moduleName in manager.installedModules)
            return CompletableDeferred(FeatureInstaller.Result.Installed)

        var localSessionId = -1
        val deferred = CompletableDeferred<FeatureInstaller.Result>()
        coroutineContext.job.invokeOnCompletion { throwable ->

            if (throwable is CancellationException &&
                !deferred.isCompleted) {

                manager.cancelInstall(localSessionId)
            }
        }

        val listener = object : SplitInstallStateUpdatedListener {

            override fun onStateUpdate(state: SplitInstallSessionState) {

                if (localSessionId != state.sessionId)
                    return

                when (state.status()) {

                    SplitInstallSessionStatus.INSTALLED -> complete(FeatureInstaller.Result.Installed)
                    SplitInstallSessionStatus.CANCELED -> complete(FeatureInstaller.Result.Cancelled)
                    SplitInstallSessionStatus.FAILED -> complete(FeatureInstaller.Result.Failed)
                    else -> {}
                }
            }

            private fun complete(result: FeatureInstaller.Result) {
                deferred.complete(result)
                manager.unregisterListener(this)
            }
        }

        manager.registerListener(listener)

        val request = SplitInstallRequest
            .newBuilder()
            .addModule(moduleName)
            .build()

        manager
            .startInstall(request)
            .addOnSuccessListener { sessionId -> localSessionId = sessionId }
            .addOnFailureListener {
                deferred.complete(FeatureInstaller.Result.Failed)
                manager.unregisterListener(listener)
            }

        return deferred
    }
}



