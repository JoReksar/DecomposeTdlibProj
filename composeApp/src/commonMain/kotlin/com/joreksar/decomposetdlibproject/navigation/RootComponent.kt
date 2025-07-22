package com.joreksar.decomposetdlibproject.navigation

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable

class RootComponent(
    context: ComponentContext
) : ComponentContext by context {

    private val stackNavigation = StackNavigation<Config>()

    val childStack = childStack(
        source = stackNavigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.ButtonScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    fun createChild(config: Config, componentContext: ComponentContext) : Child =
        when (config) {
            Config.ButtonScreen -> Child.ButtonScreen(ButtonScreenComponent(componentContext, { stackNavigation.pushNew(Config.DynamicTdLib) }))
            Config.DynamicTdLib -> Child.DynamicToLib(DynamicTdLibComponent(componentContext, { stackNavigation.pop() }))
        }


    sealed class Child {
        data class ButtonScreen(val buttonScreenComponent: ButtonScreenComponent) : Child()
        data class DynamicToLib(val dynamicTdLibComponent: DynamicTdLibComponent) : Child()
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object ButtonScreen : Config
        @Serializable
        data object DynamicTdLib : Config
    }
}