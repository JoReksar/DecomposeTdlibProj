package com.joreksar.sharedtdlibfeatureapi.content

import androidx.compose.runtime.Composable
import com.joreksar.sharedtdlibfeatureapi.components.SharedTdlibFeatureComponent

interface SharedTdlibFeatureContent {

    @Composable
    operator fun invoke(component: SharedTdlibFeatureComponent)
}