package com.joreksar.decomposetdlibproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.joreksar.decomposetdlibproject.components.RootComponent
import com.joreksar.decomposetdlibproject.content.RootContent
import com.joreksar.decomposetdlibproject.utils.AndroidFeatureInstaller

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        val root = RootComponent(defaultComponentContext(), AndroidFeatureInstaller(this))

        setContent {
            RootContent(root)
        }
    }
}