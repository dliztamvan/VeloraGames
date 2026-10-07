package com.velora.games.seller
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun SellerOrdersScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Loading…")};val scope=rememberCoroutineScope();LaunchedEffect(Unit){scope.launch{VeloraApi(token).orders().onSuccess{status="Orders loaded"}.onFailure{status=it.message?:"Failed"}}};Column(Modifier.fillMaxSize().padding(20.dp)){Text("Seller Orders",style=MaterialTheme.typography.headlineMedium);Spacer(Modifier.height(16.dp));Text(status);TextButton(onBack,Modifier.fillMaxWidth()){Text("Back")}}}
