package com.velora.games.admin
import androidx.compose.runtime.*
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AdminProductsScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Ready")};val scope=rememberCoroutineScope();AdminPage("Products",status,onBack){scope.launch{VeloraApi(token).adminProducts().onSuccess{status="Products loaded"}.onFailure{status=it.message?:"Failed"}}}}