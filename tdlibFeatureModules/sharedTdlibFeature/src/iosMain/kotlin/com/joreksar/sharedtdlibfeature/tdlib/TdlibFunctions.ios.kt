package com.joreksar.sharedtdlibfeature.tdlib

import kotlinx.cinterop.ExperimentalForeignApi
import tdlibwrapper.td_json_client_create

@OptIn(ExperimentalForeignApi::class)
actual fun tryNativeInvoke(): String? {
    return td_json_client_create().toString()
}