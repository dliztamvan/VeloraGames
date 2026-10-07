package com.velora.games.auth

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    onLoggedIn: (String, String?, Boolean, Boolean) -> Unit,
    onRegister: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    var loading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf("") }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            "Velora Games",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(Modifier.height(8.dp))

        Text(
            "Sign In",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(Modifier.height(20.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Email") },
            singleLine = true
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            singleLine = true
        )

        if (error.isNotBlank()) {
            Spacer(Modifier.height(8.dp))

            Text(
                error,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(Modifier.height(18.dp))

        Button(
            onClick = {
                scope.launch {
                    loading = true
                    error = ""

                    val r = VeloraApi().login(
                        email.trim(),
                        pass
                    )

                    loading = false

                    r.onSuccess { o ->
                        val d = o.optJSONObject("data") ?: o
                        val u = d.optJSONObject("user")

                        val token = d.optString(
                            "token",
                            d.optString("session")
                        )

                        if (token.isBlank()) {
                            error = o.optString(
                                "message",
                                "Login gagal"
                            )
                        } else {
                            onLoggedIn(
                                token,
                                u?.optString("id"),
                                u?.optInt("is_admin", 0) == 1,
                                u?.optInt("is_seller", 0) == 1
                            )
                        }
                    }

                    r.onFailure {
                        error = it.message ?: "Login gagal"
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            enabled = !loading
        ) {
            if (loading) {
                CircularProgressIndicator(
                    strokeWidth = 2.dp
                )
            } else {
                Text("Sign In")
            }
        }

        Spacer(Modifier.height(14.dp))

        TextButton(
            onClick = onRegister,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Don’t have an account? Sign Up")
        }
    }
}
