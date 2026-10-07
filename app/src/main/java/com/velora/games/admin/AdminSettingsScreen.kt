package com.velora.games.admin
import androidx.compose.runtime.*
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AdminSettingsScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Ready")};val scope=rememberCoroutineScope();AdminPage("Settings",status,onBack){scope.launch{VeloraApi(token).adminSettings().onSuccess{status="Settings loaded"}.onFailure{status=it.message?:"Failed"}}}}