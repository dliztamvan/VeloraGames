package com.velora.games.buyer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.core.Utils
import com.velora.games.network.*
import com.velora.games.ui.components.*
import kotlinx.coroutines.launch
@Composable fun BuyerProductDetailScreen(token:String,product:Product,onBack:()->Unit,onOrdered:()->Unit){var busy by remember{mutableStateOf(false)};var msg by remember{mutableStateOf("")};val scope=rememberCoroutineScope();Column(Modifier.fillMaxSize().padding(16.dp)){VeloraTopBar(product.title?:"Product",true,onBack);VeloraCard{Text(product.title?:"Untitled",style=MaterialTheme.typography.headlineSmall);Text(product.game?:"Game");Spacer(Modifier.height(10.dp));Text(Utils.rupiah(product.price),style=MaterialTheme.typography.titleLarge);Spacer(Modifier.height(10.dp));Text(product.description?:"No description");Spacer(Modifier.height(20.dp));Button({scope.launch{busy=true;VeloraApi(token).createOrder(product.id.orEmpty()).onSuccess{msg="Order dibuat";onOrdered()}.onFailure{msg=it.message?:"Gagal membuat order"};busy=false}},Modifier.fillMaxWidth(),enabled=!busy){Text(if(busy)"Processing…" else "Buy Now")};if(msg.isNotBlank())Text(msg)}}}
