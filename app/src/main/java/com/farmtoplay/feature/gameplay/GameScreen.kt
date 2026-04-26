package com.farmtoplay.feature.gameplay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.farmtoplay.core.designsystem.theme.FieldGreen
import com.farmtoplay.core.designsystem.theme.Hay
import com.farmtoplay.core.designsystem.theme.LeafGreen
import com.farmtoplay.core.designsystem.theme.Pond
import com.farmtoplay.core.designsystem.theme.Soil
import com.farmtoplay.core.designsystem.theme.Sunset

@Composable
fun GameScreen(
    state: GameUiState,
    onCollect: () -> Unit,
    onReset: () -> Unit,
    onExit: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Pond, LeafGreen, FieldGreen, Soil)
                )
            )
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Card(shape = RoundedCornerShape(24.dp)) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(state.modeName, style = MaterialTheme.typography.headlineLarge)
                Text(state.objective, style = MaterialTheme.typography.bodyLarge)
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            StatCard(label = "Score", value = state.score.toString(), modifier = Modifier.weight(1f))
            StatCard(label = "Combo", value = state.combo.toString(), modifier = Modifier.weight(1f))
            StatCard(label = "Energy", value = state.energy.toString(), modifier = Modifier.weight(1f))
        }

        Surface(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            color = Hay.copy(alpha = 0.20f)
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = onCollect,
                    shape = CircleShape,
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(Sunset)
                        .padding(24.dp)
                ) {
                    Text(if (state.energy > 0) "Collect Crop" else "Out of Energy")
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(onClick = onReset, modifier = Modifier.weight(1f)) {
                Text("Restart")
            }
            Button(onClick = onExit, modifier = Modifier.weight(1f)) {
                Text("Main Menu")
            }
        }
    }
}

@Composable
private fun StatCard(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier, shape = RoundedCornerShape(20.dp)) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(label, style = MaterialTheme.typography.bodyMedium)
            Text(value, style = MaterialTheme.typography.headlineMedium)
        }
    }
}
