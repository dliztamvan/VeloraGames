package com.velora.games

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.velora.games.core.SessionManager
import com.velora.games.ui.navigation.AppNavigation
import com.velora.games.ui.theme.VeloraTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val session = SessionManager(this)

        setContent {
            VeloraTheme {
                AppNavigation(session)
            }
        }
    }
}
