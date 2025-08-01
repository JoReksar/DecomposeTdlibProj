package com.joreksar.sharedtdlibfeature.components

import com.arkivanov.decompose.ComponentContext
import com.joreksar.sharedtdlibfeature.tdlib.tryNativeInvoke

class DefaultTdlibFeatureComponent(
    componentContext: ComponentContext
) : com.joreksar.sharedtdlibfeatureapi.components.SharedTdlibFeatureComponent, ComponentContext by componentContext {

    override val text = tryNativeInvoke() ?: "null"
        //"Hiiiii, i'm text from ${DefaultTdlibFeatureComponent::class.simpleName}"

}