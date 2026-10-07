package com.velora.games.admin
import androidx.compose.runtime.*
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AdminOrdersScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Ready")};val scope=rememberCoroutineScope();AdminPage("Orders",status,onBack){scope.launch{VeloraApi(token).adminOrders().onSuccess{status="Orders loaded"}.onFailure{status=it.message?:"Failed"}}}}