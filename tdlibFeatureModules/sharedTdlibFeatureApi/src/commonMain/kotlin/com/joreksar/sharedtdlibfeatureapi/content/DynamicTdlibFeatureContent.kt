package com.joreksar.sharedtdlibfeatureapi.content

import androidx.compose.runtime.Composable
import com.joreksar.sharedtdlibfeatureapi.components.TdlibFeatureComponent

interface DynamicTdlibFeatureContent {

    @Composable
    operator fun invoke(component: TdlibFeatureComponent)
}