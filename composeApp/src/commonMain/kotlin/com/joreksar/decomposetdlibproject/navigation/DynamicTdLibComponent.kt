package com.joreksar.decomposetdlibproject.navigation

import com.arkivanov.decompose.ComponentContext

class DynamicTdLibComponent(
    context: ComponentContext,
    private val onGoBack: () -> Unit
) : ComponentContext by context {


    fun goBack() {
        onGoBack()
    }
}