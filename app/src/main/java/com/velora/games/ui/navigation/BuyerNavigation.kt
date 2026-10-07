package com.velora.games.ui.navigation
import androidx.compose.runtime.*
import com.velora.games.buyer.*
import com.velora.games.network.Product
@Composable fun BuyerNav(token:String,onSelect:(Product)->Unit,onSeller:()->Unit,onLogout:()->Unit){var page by remember{mutableStateOf(0)};var product by remember{mutableStateOf<Product?>(null)};when(page){0->BuyerHomeScreen({page=1},{page=2},{page=5},{page=4});1->BuyerMarketplaceScreen(token,{product=it;page=3},{page=0});2->BuyerOrdersScreen(token,{page=0});3->product?.let{BuyerProductDetailScreen(token,it,{page=1},{page=2})};4->BuyerProfileScreen(null,onSeller,onLogout,{page=0});5->BuyerChatScreen(token,{page=0})}}
