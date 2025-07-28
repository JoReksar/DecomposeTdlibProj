package com.joreksar.decomposetdlibproject.content

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.joreksar.decomposetdlibproject.components.RootComponent

@Composable
fun RootContent(rootComponent: RootComponent) {
    MaterialTheme {
        Children(
            stack = rootComponent.childStack,
            modifier = Modifier.fillMaxSize()
        ) {
            when (val instance = it.instance) {
                is RootComponent.Child.ButtonScreen -> ButtonScreenContent(instance.buttonScreenComponent)
                is RootComponent.Child.TdlibFeature -> TdlibFeatureContent(instance.tdlibFeatureComponent)
            }
        }
    }
}