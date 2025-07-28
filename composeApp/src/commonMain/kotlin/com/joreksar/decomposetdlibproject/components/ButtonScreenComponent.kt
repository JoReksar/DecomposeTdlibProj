package com.joreksar.decomposetdlibproject.components

import com.arkivanov.decompose.ComponentContext

class ButtonScreenComponent(
    context: ComponentContext,
    private val onOpenTdlib : () -> Unit
) : ComponentContext by context {

    fun openTdlib() {
        onOpenTdlib()
    }

}