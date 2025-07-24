package com.joreksar.decomposetdlibproject.components

import com.arkivanov.decompose.ComponentContext
import com.joreksar.sharedtdlibfeature.components.DefaultTdlibFeatureComponent
import com.joreksar.sharedtdlibfeatureapi.components.TdlibFeatureComponent

actual fun createTdlibFeatureComponent(context: ComponentContext): TdlibFeatureComponent
    = DefaultTdlibFeatureComponent(context)