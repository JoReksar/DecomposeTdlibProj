package com.joreksar.sharedtdlibfeature.tdlib

import com.joreksar.tdlibfeatureandroid.TdlibFeatureNativeJ

actual fun tryNativeInvoke(): String? {
    return TdlibFeatureNativeJ.tdJsonClientCreate().toString()
}