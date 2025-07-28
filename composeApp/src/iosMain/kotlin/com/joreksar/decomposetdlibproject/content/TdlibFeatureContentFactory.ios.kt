package com.joreksar.decomposetdlibproject.content

import com.joreksar.sharedtdlibfeature.content.TdlibFeatureContent
import com.joreksar.sharedtdlibfeatureapi.content.SharedTdlibFeatureContent

actual fun createTdlibFeatureContent() : SharedTdlibFeatureContent = TdlibFeatureContent()