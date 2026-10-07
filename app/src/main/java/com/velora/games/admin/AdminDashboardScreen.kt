package com.velora.games.admin
import androidx.compose.runtime.*
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AdminDashboardScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Ready")};val scope=rememberCoroutineScope();AdminPage("Admin Dashboard",status,onBack){scope.launch{VeloraApi(token).adminStats().onSuccess{status="Stats loaded"}.onFailure{status=it.message?:"Failed"}}}}