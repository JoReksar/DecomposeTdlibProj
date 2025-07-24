package com.joreksar.sharedtdlibfeature.components

import com.arkivanov.decompose.ComponentContext

class DefaultTdlibFeatureComponent(
    componentContext: ComponentContext
) : com.joreksar.sharedtdlibfeatureapi.components.TdlibFeatureComponent, ComponentContext by componentContext {

    override val text = "Hiiiii, i'm text from ${DefaultTdlibFeatureComponent::class.simpleName}"

}