package com.joreksar.decomposetdlibproject.content

import com.joreksar.sharedtdlibfeature.content.TdlibFeatureContent
import com.joreksar.sharedtdlibfeatureapi.content.DynamicTdlibFeatureContent

actual fun createTdlibFeatureContent() : DynamicTdlibFeatureContent = TdlibFeatureContent()