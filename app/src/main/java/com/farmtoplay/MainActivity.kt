package com.farmtoplay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.farmtoplay.core.designsystem.theme.FarmToPlayTheme
import com.farmtoplay.core.navigation.FarmToPlayApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarmToPlayTheme {
                FarmToPlayApp()
            }
        }
    }
}
