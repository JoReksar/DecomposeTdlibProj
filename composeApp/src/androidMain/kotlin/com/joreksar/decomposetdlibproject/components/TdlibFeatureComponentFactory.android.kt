package com.joreksar.decomposetdlibproject.components

import com.arkivanov.decompose.ComponentContext
import com.joreksar.sharedtdlibfeatureapi.components.TdlibFeatureComponent

actual fun createTdlibFeatureComponent(context: ComponentContext): TdlibFeatureComponent
    = Class.forName("com.joreksar.sharedtdlibfeature.components.DefaultTdlibFeatureComponent")
        .declaredConstructors
        .first()
        .newInstance(context) as TdlibFeatureComponent