package com.joreksar.decomposetdlibproject.content

import com.joreksar.sharedtdlibfeatureapi.content.SharedTdlibFeatureContent

actual fun createTdlibFeatureContent(): SharedTdlibFeatureContent =
    Class.forName("com.joreksar.sharedtdlibfeature.content.TdlibFeatureContent")
        .declaredConstructors
        .first()
        .newInstance() as SharedTdlibFeatureContent