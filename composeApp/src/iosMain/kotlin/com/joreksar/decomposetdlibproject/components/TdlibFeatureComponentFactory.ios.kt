package com.joreksar.decomposetdlibproject.components

import com.arkivanov.decompose.ComponentContext
import com.joreksar.sharedtdlibfeature.components.DefaultTdlibFeatureComponent
import com.joreksar.sharedtdlibfeatureapi.components.SharedTdlibFeatureComponent

actual fun createTdlibFeatureComponent(context: ComponentContext): SharedTdlibFeatureComponent
    = DefaultTdlibFeatureComponent(context)