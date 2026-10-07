package com.velora.games.buyer
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.network.*
import com.velora.games.ui.components.*
import kotlinx.coroutines.launch
@Composable fun BuyerMarketplaceScreen(token:String,onDetail:(Product)->Unit,onBack:()->Unit){var list by remember{mutableStateOf<List<Product>>(emptyList())};var error by remember{mutableStateOf("")};val scope=rememberCoroutineScope();LaunchedEffect(Unit){scope.launch{VeloraApi(token).products().onSuccess{list=it.productsList()}.onFailure{error=it.message?:"Gagal memuat produk"}}};Column(Modifier.fillMaxSize().padding(16.dp)){VeloraTopBar("Marketplace",true,onBack);if(error.isNotBlank())Text(error,color=MaterialTheme.colorScheme.error);LazyColumn{items(list){ProductCard(it){onDetail(it)}}}}}
