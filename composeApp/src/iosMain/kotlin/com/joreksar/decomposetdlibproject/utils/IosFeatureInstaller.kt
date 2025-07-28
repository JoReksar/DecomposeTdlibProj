package com.joreksar.decomposetdlibproject.utils

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred

class IosFeatureInstaller : FeatureInstaller {

    override suspend fun install(moduleName: String): Deferred<FeatureInstaller.Result> =
        CompletableDeferred(FeatureInstaller.Result.Installed)
}