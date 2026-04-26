package com.farmtoplay.feature.gamemode

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun GameModeScreen(
    onBackClick: () -> Unit,
    onStartMode: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("Choose Game Mode", style = MaterialTheme.typography.headlineLarge)
        Text(
            "These are placeholders for the future gameplay pillars.",
            style = MaterialTheme.typography.bodyLarge
        )

        ModeCard(
            title = "Harvest Sprint",
            description = "Short arcade run focused on speed and combo collection.",
            onStart = { onStartMode("Harvest Sprint") }
        )
        ModeCard(
            title = "Farm Builder",
            description = "Long-form progression mode with upgrades, crafting and economy.",
            onStart = { onStartMode("Farm Builder") }
        )
        ModeCard(
            title = "Festival Challenge",
            description = "Live-event ready template for limited-time goals and rewards.",
            onStart = { onStartMode("Festival Challenge") }
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
private fun ModeCard(
    title: String,
    description: String,
    onStart: () -> Unit
) {
    Card(shape = RoundedCornerShape(24.dp)) {
        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(title, style = MaterialTheme.typography.headlineMedium)
            Text(description, style = MaterialTheme.typography.bodyLarge)
            Button(onClick = onStart, modifier = Modifier.fillMaxWidth()) {
                Text("Start")
            }
        }
    }
}
