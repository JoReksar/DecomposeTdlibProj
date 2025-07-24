package com.joreksar.decomposetdlibproject.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import com.joreksar.sharedtdlibfeatureapi.components.TdlibFeatureComponent
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
            Config.ButtonScreen -> Child.ButtonScreen(ButtonScreenComponent(componentContext) {
                stackNavigation.pushNew(
                    Config.TdlibFeature
                )
            })
            Config.TdlibFeature -> Child.TdlibFeature(createTdlibFeatureComponent(componentContext))
        }


    sealed class Child {
        data class ButtonScreen(val buttonScreenComponent: ButtonScreenComponent) : Child()
        data class TdlibFeature(val tdlibFeatureComponent: TdlibFeatureComponent) : Child()
    }

    @Serializable
    sealed interface Config {
        @Serializable
        data object ButtonScreen : Config
        @Serializable
        data object TdlibFeature : Config
    }
}