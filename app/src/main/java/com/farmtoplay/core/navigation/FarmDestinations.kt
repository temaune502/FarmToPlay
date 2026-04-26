package com.farmtoplay.core.navigation

sealed interface FarmDestination {
    val route: String

    data object MainMenu : FarmDestination {
        override val route: String = "main_menu"
    }

    data object ModeSelect : FarmDestination {
        override val route: String = "mode_select"
    }

    data object Settings : FarmDestination {
        override val route: String = "settings"
    }

    data object Gameplay : FarmDestination {
        override val route: String = "gameplay"
    }
}
