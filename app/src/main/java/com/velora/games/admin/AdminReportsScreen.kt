package com.velora.games.admin
import androidx.compose.runtime.*
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AdminReportsScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Ready")};val scope=rememberCoroutineScope();AdminPage("Reports",status,onBack){scope.launch{VeloraApi(token).adminReports().onSuccess{status="Reports loaded"}.onFailure{status=it.message?:"Failed"}}}}