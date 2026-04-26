package com.farmtoplay.feature.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val musicEnabled = remember { mutableStateOf(true) }
    val vibrationEnabled = remember { mutableStateOf(true) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Settings", style = MaterialTheme.typography.headlineLarge)
        Text(
            "Temporary settings screen to anchor future audio, accessibility and account options.",
            style = MaterialTheme.typography.bodyLarge
        )

        SettingCard(
            title = "Music",
            summary = "Global soundtrack toggle.",
            enabled = musicEnabled.value,
            onEnabledChange = { musicEnabled.value = it }
        )
        SettingCard(
            title = "Vibration",
            summary = "Haptics for taps and reward feedback.",
            enabled = vibrationEnabled.value,
            onEnabledChange = { vibrationEnabled.value = it }
        )

        Button(
            onClick = onBackClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}

@Composable
private fun SettingCard(
    title: String,
    summary: String,
    enabled: Boolean,
    onEnabledChange: (Boolean) -> Unit
) {
    Card {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(title, style = MaterialTheme.typography.headlineMedium)
            Text(summary, style = MaterialTheme.typography.bodyMedium)
            Switch(
                checked = enabled,
                onCheckedChange = onEnabledChange
            )
        }
    }
}
