package com.joreksar.decomposetdlibproject.components

import com.arkivanov.decompose.ComponentContext
import com.joreksar.sharedtdlibfeatureapi.components.SharedTdlibFeatureComponent

actual fun createTdlibFeatureComponent(context: ComponentContext): SharedTdlibFeatureComponent
    = Class.forName("com.joreksar.sharedtdlibfeature.components.DefaultTdlibFeatureComponent")
        .declaredConstructors
        .first()
        .newInstance(context) as SharedTdlibFeatureComponent