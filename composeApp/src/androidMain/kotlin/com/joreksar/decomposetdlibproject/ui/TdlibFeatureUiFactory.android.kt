package com.joreksar.decomposetdlibproject.ui

import com.joreksar.sharedtdlibfeatureapi.ui.DynamicTdlibFeatureUi

actual fun createTdlibFeatureUi(): DynamicTdlibFeatureUi =
    Class.forName("com.joreksar.sharedtdlibfeature.ui.TdlibFeatureUi")
        .declaredConstructors
        .first()
        .newInstance() as DynamicTdlibFeatureUi