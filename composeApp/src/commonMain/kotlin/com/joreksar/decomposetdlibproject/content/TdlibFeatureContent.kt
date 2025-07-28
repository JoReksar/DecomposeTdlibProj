package com.joreksar.decomposetdlibproject.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.joreksar.decomposetdlibproject.components.TdlibFeatureComponent

@Composable
fun TdlibFeatureContent(tdlibFeatureComponent: TdlibFeatureComponent) {
    Children(
        stack = tdlibFeatureComponent.childStack,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Button(
                onClick = tdlibFeatureComponent::close,
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text("Закрыть экран")
            }

            when (val child = it.instance) {
                is TdlibFeatureComponent.Child.InstallingChild -> InstallingContent()
                is TdlibFeatureComponent.Child.TdlibFeatureChild -> {
                    createTdlibFeatureContent().invoke(child.sharedTdlibFeatureComponent)
                }
                is TdlibFeatureComponent.Child.FailureChild -> FailureContent()
            }
        }
    }
}

@Composable
fun InstallingContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .height(48.dp)
                .width(48.dp)
        )
    }
}

@Composable
fun FailureContent() {
    Text(
        textAlign = TextAlign.Center,
        fontSize = 32.sp,
        text = "Произошла ошибка"
    )
}