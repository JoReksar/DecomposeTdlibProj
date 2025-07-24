package com.joreksar.sharedtdlibfeature.components

import com.arkivanov.decompose.ComponentContext

class TdlibFeatureComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    val text = "Hiiiii, i'm text from ${TdlibFeatureComponent::class.simpleName}"

}