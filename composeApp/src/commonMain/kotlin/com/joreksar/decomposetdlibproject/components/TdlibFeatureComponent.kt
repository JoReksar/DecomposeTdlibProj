package com.joreksar.decomposetdlibproject.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceCurrent
import com.arkivanov.essenty.lifecycle.doOnDestroy
import com.joreksar.decomposetdlibproject.utils.FeatureInstaller
import com.joreksar.sharedtdlibfeatureapi.components.SharedTdlibFeatureComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable

class TdlibFeatureComponent(
    componentContext: ComponentContext,
    private val featureInstaller: FeatureInstaller,
    private val onBack: () -> Unit
) : ComponentContext by componentContext {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val stackNavigation = StackNavigation<Config>()

    val childStack = childStack(
        source = stackNavigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Installing,
        handleBackButton = true,
        childFactory = ::createChild
    )

    init {
        lifecycle.doOnDestroy {
            coroutineScope.cancel()
        }
    }

    fun close() = onBack()

    private fun createChild(config: Config, componentContext: ComponentContext) : Child {

        return when (config) {
            Config.Failure -> Child.FailureChild()
            Config.Installing -> beginInstallFeature()
            Config.TdlibFeature -> Child.TdlibFeatureChild(
                createTdlibFeatureComponent(
                    componentContext
                )
            )
        }
    }

    private fun beginInstallFeature() : Child.InstallingChild {

        coroutineScope.launch {

            val installResult = featureInstaller
                .install("messengerDynamicFeature")
                .await()

            withContext(Dispatchers.Main) {

                when (installResult) {
                    FeatureInstaller.Result.Installed -> stackNavigation.replaceCurrent(Config.TdlibFeature)
                    FeatureInstaller.Result.Cancelled -> stackNavigation.replaceCurrent(Config.Failure)
                    FeatureInstaller.Result.Failed -> stackNavigation.replaceCurrent(Config.Failure)
                }
            }
        }

        return Child.InstallingChild()
    }


    sealed class Child {

        class InstallingChild() : Child()

        class TdlibFeatureChild(val sharedTdlibFeatureComponent: SharedTdlibFeatureComponent) : Child()

        class FailureChild() : Child()
    }

    @Serializable
    sealed interface Config {

        @Serializable
        data object Installing : Config

        @Serializable
        data object TdlibFeature : Config

        @Serializable
        data object Failure : Config
    }
}
