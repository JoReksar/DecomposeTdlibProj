package com.joreksar.decomposetdlibproject.content

import com.joreksar.sharedtdlibfeatureapi.content.DynamicTdlibFeatureContent

actual fun createTdlibFeatureContent(): DynamicTdlibFeatureContent =
    Class.forName("com.joreksar.sharedtdlibfeature.content.TdlibFeatureContent")
        .declaredConstructors
        .first()
        .newInstance() as DynamicTdlibFeatureContent