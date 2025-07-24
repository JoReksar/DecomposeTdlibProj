package com.joreksar.sharedtdlibfeature.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.joreksar.sharedtdlibfeature.components.TdlibFeatureComponent

@Composable
fun TdlibFeatureUi(tdlibFeatureComponent: TdlibFeatureComponent) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text(text = tdlibFeatureComponent.text)
        Button(onClick = { }) {
            Text(text = "I'm button, click me")
        }
    }
}