package com.velora.games.seller
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.network.VeloraApi
import com.velora.games.ui.components.VeloraTopBar
import kotlinx.coroutines.launch
@Composable fun SellerPaymentScreen(token:String,onBack:()->Unit){var status by remember{mutableStateOf("Checking seller status…")};val scope=rememberCoroutineScope();LaunchedEffect(Unit){scope.launch{VeloraApi(token).sellerStatus().onSuccess{status="Seller status loaded"}.onFailure{status=it.message?:"Failed"}}};Column(Modifier.fillMaxSize().padding(16.dp)){VeloraTopBar("Seller Payment",true,onBack);Text(status);Spacer(Modifier.height(12.dp));Text("Payment verification is handled by the backend." )}}
