package com.farmtoplay.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farmtoplay.feature.gameplay.GameScreen
import com.farmtoplay.feature.gameplay.GameViewModel
import com.farmtoplay.feature.gamemode.GameModeScreen
import com.farmtoplay.feature.menu.MainMenuScreen
import com.farmtoplay.feature.settings.SettingsScreen

@Composable
fun FarmToPlayApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    val gameViewModel: GameViewModel = viewModel()

    NavHost(
        navController = navController,
        startDestination = FarmDestination.MainMenu.route,
        modifier = modifier
    ) {
        composable(FarmDestination.MainMenu.route) {
            MainMenuScreen(
                onPlayClick = { navController.navigate(FarmDestination.ModeSelect.route) },
                onSettingsClick = { navController.navigate(FarmDestination.Settings.route) }
            )
        }
        composable(FarmDestination.ModeSelect.route) {
            GameModeScreen(
                onBackClick = { navController.popBackStack() },
                onStartMode = {
                    gameViewModel.startNewRun(modeName = it)
                    navController.navigate(FarmDestination.Gameplay.route)
                }
            )
        }
        composable(FarmDestination.Settings.route) {
            SettingsScreen(onBackClick = { navController.popBackStack() })
        }
        composable(FarmDestination.Gameplay.route) {
            GameScreen(
                state = gameViewModel.uiState,
                onCollect = gameViewModel::collectCrop,
                onReset = gameViewModel::resetRun,
                onExit = { navController.popBackStack(FarmDestination.MainMenu.route, false) }
            )
        }
    }
}
