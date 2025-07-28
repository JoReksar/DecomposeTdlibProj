package com.joreksar.sharedtdlibfeature.content

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joreksar.sharedtdlibfeatureapi.components.SharedTdlibFeatureComponent
import com.joreksar.sharedtdlibfeatureapi.content.SharedTdlibFeatureContent

class TdlibFeatureContent : SharedTdlibFeatureContent {

    @Composable
    override fun invoke(component: SharedTdlibFeatureComponent) {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            Text(text = component.text)
            Button(onClick = { }) {
                Text(text = "I'm button, click me")
            }
        }
    }
}