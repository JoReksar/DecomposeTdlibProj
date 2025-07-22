package com.joreksar.decomposetdlibproject.navigation

import com.arkivanov.decompose.ComponentContext

class ButtonScreenComponent(
    context: ComponentContext,
    private val onButtonClicked : () -> Unit
) : ComponentContext by context {

    fun goToTdLib() {
        onButtonClicked()
    }

}