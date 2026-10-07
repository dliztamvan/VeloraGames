package com.velora.games.admin
import androidx.compose.runtime.*
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AdminUsersScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Ready")};val scope=rememberCoroutineScope();AdminPage("Users",status,onBack){scope.launch{VeloraApi(token).adminUsers().onSuccess{status="Users loaded"}.onFailure{status=it.message?:"Failed"}}}}