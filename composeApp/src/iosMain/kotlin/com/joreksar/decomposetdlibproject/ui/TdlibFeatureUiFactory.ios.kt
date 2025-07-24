package com.joreksar.decomposetdlibproject.ui

import com.joreksar.sharedtdlibfeature.ui.TdlibFeatureUi
import com.joreksar.sharedtdlibfeatureapi.ui.DynamicTdlibFeatureUi

actual fun createTdlibFeatureUi() : DynamicTdlibFeatureUi = TdlibFeatureUi()