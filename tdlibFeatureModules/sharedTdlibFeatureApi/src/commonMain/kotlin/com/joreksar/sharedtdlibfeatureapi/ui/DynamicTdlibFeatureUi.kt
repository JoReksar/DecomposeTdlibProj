package com.joreksar.sharedtdlibfeatureapi.ui

import androidx.compose.runtime.Composable
import com.joreksar.sharedtdlibfeatureapi.components.TdlibFeatureComponent

interface DynamicTdlibFeatureUi {

    @Composable
    operator fun invoke(component: TdlibFeatureComponent)
}