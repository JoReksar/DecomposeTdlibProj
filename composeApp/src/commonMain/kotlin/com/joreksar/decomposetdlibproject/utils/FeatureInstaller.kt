package com.joreksar.decomposetdlibproject.utils

import kotlinx.coroutines.Deferred

interface FeatureInstaller {

    suspend fun install(moduleName: String) : Deferred<Result>

    enum class Result {
        Installed,
        Cancelled,
        Failed
    }
}