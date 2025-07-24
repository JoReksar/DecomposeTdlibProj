package com.joreksar.decomposetdlibproject.components

import com.arkivanov.decompose.ComponentContext

class DynamicTdLibComponent(
    context: ComponentContext,
    private val onGoBack: () -> Unit
) : ComponentContext by context {


    fun goBack() {
        onGoBack()
    }
}