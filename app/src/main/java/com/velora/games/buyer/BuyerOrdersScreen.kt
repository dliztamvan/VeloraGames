package com.velora.games.buyer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.core.Utils
import com.velora.games.network.*
import com.velora.games.ui.components.*
import kotlinx.coroutines.launch
@Composable fun BuyerOrdersScreen(token:String,onBack:()->Unit){var text by remember{mutableStateOf("Loading…")};val scope=rememberCoroutineScope();LaunchedEffect(Unit){scope.launch{VeloraApi(token).orders().onSuccess{text=it.optJSONArray("orders")?.let{"Orders loaded"}?:"No orders"}.onFailure{text=it.message?:"Failed"}}};Column(Modifier.fillMaxSize().padding(16.dp)){VeloraTopBar("My Orders",true,onBack);VeloraCard{Text(text)}}}
