package com.joreksar.decomposetdlibproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.joreksar.decomposetdlibproject.components.RootComponent
import com.joreksar.decomposetdlibproject.content.ButtonScreenContent
import com.joreksar.decomposetdlibproject.content.createTdlibFeatureContent
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(rootComponent: RootComponent) {
    MaterialTheme {
        Children(
            stack = rootComponent.childStack,
            modifier = Modifier.fillMaxSize()
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.ButtonScreen -> ButtonScreenContent(instance.buttonScreenComponent)
                is RootComponent.Child.TdlibFeature -> {
                    val tdlibContent = remember({ createTdlibFeatureContent() })
                    tdlibContent(instance.tdlibFeatureComponent)
                }
            }
        }
    }
}