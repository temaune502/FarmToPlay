package com.farmtoplay.feature.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.farmtoplay.core.designsystem.theme.FieldGreen
import com.farmtoplay.core.designsystem.theme.Hay
import com.farmtoplay.core.designsystem.theme.LeafGreen
import com.farmtoplay.core.designsystem.theme.MossGreen
import com.farmtoplay.core.designsystem.theme.Pond

@Composable
fun MainMenuScreen(
    onPlayClick: () -> Unit,
    onSettingsClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(Pond, LeafGreen, FieldGreen, MossGreen)
                )
            )
            .padding(24.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(28.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "FarmToPlay",
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = "Prototype mobile game starter with room for quests, economy, live ops and events.",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }

        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth(),
            shape = RoundedCornerShape(32.dp),
            tonalElevation = 4.dp,
            color = Hay.copy(alpha = 0.96f)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Button(
                    onClick = onPlayClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Play")
                }
                Button(
                    onClick = onSettingsClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Settings")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Inventory Placeholder")
                }
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Live Events Placeholder")
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Menu skeleton: ready for profile, daily rewards, monetization and social hubs.",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MossGreen
                )
            }
        }
    }
}
