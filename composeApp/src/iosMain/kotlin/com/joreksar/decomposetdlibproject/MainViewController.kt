package com.joreksar.decomposetdlibproject

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.joreksar.decomposetdlibproject.components.RootComponent
import com.joreksar.decomposetdlibproject.content.RootContent
import com.joreksar.decomposetdlibproject.utils.IosFeatureInstaller

fun MainViewController() = ComposeUIViewController {
    val root = RootComponent(DefaultComponentContext(LifecycleRegistry()), IosFeatureInstaller())
    RootContent(root)
}