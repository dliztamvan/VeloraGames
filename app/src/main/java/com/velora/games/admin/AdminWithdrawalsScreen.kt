package com.velora.games.admin
import androidx.compose.runtime.*
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AdminWithdrawalsScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Ready")};val scope=rememberCoroutineScope();AdminPage("Withdrawals",status,onBack){scope.launch{VeloraApi(token).adminWithdrawals().onSuccess{status="Withdrawals loaded"}.onFailure{status=it.message?:"Failed"}}}}