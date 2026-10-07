package com.velora.games.seller
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.network.*
import com.velora.games.ui.components.*
import kotlinx.coroutines.launch
@Composable fun SellerListingsScreen(token:String,onAdd:()->Unit,onEdit:(Product)->Unit,onBack:()->Unit){var list by remember{mutableStateOf<List<Product>>(emptyList())};val scope=rememberCoroutineScope();LaunchedEffect(Unit){scope.launch{VeloraApi(token).sellerListings().onSuccess{list=it.productsList()}}};Column(Modifier.fillMaxSize().padding(16.dp)){VeloraTopBar("My Listings",true,onBack);Button(onAdd,Modifier.fillMaxWidth()){Text("Add Product")};LazyColumn{items(list){ProductCard(it){onEdit(it)}}}}}
