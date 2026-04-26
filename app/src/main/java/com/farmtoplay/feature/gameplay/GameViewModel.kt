package com.farmtoplay.feature.gameplay

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

data class GameUiState(
    val modeName: String = "Harvest Sprint",
    val score: Int = 0,
    val combo: Int = 0,
    val energy: Int = 5,
    val objective: String = "Collect 25 crops before energy runs out."
)

class GameViewModel : ViewModel() {
    var uiState by mutableStateOf(GameUiState())
        private set

    fun startNewRun(modeName: String) {
        uiState = GameUiState(
            modeName = modeName,
            objective = when (modeName) {
                "Farm Builder" -> "Collect resources to unlock building systems."
                "Festival Challenge" -> "Gather event tokens for limited-time rewards."
                else -> "Collect 25 crops before energy runs out."
            }
        )
    }

    fun collectCrop() {
        if (uiState.energy <= 0) return

        val nextCombo = uiState.combo + 1
        uiState = uiState.copy(
            score = uiState.score + 5 + nextCombo,
            combo = nextCombo,
            energy = uiState.energy - 1
        )
    }

    fun resetRun() {
        startNewRun(modeName = uiState.modeName)
    }
}
