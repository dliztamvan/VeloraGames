package com.velora.games

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.velora.games.core.SessionManager
import com.velora.games.ui.navigation.AppNavigation
import com.velora.games.ui.theme.VeloraTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            val session = SessionManager(this)

            setContent {
                VeloraTheme {
                    AppNavigation(session)
                }
            }

        } catch (e: Throwable) {

            setContent {
                CrashScreen(e)
            }
        }
    }
}

@Composable
fun CrashScreen(error: Throwable) {
    Text(
        text = """
            VELORA STARTUP ERROR

            ${error.javaClass.name}

            ${error.message}

            ${error.stackTraceToString()}
        """.trimIndent()
    )
}
