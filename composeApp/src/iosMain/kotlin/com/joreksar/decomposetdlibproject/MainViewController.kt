package com.joreksar.decomposetdlibproject

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.joreksar.decomposetdlibproject.components.RootComponent

fun MainViewController() = ComposeUIViewController {
    val root = RootComponent(DefaultComponentContext(LifecycleRegistry()))
    App(root)
}