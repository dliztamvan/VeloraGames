package com.velora.games.ui.navigation
import androidx.compose.runtime.*
import com.velora.games.seller.*
import com.velora.games.network.Product
@Composable fun SellerNav(token:String,onBack:()->Unit){var page by remember{mutableStateOf(0)};var product by remember{mutableStateOf<Product?>(null)};when(page){0->SellerDashboardScreen(onBack,{page=1},{page=4},{page=2},{page=6});1->SellerListingsScreen(token,{page=3},{product=it;page=5},{page=0});2->SellerPaymentScreen(token,{page=0});3->AddProductScreen(token,{page=1},{page=0});4->SellerOrdersScreen(token,{page=0});5->product?.let{EditProductScreen(token,it,{page=1},{page=1})};6->SellerChatScreen{page=0}}}
