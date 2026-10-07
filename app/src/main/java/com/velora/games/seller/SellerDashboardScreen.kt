package com.velora.games.seller
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable fun SellerDashboardScreen(onBack:()->Unit,onListings:()->Unit,onOrders:()->Unit,onPayment:()->Unit,onChat:()->Unit){Column(Modifier.fillMaxSize().padding(20.dp)){Text("Seller Dashboard",style=MaterialTheme.typography.headlineMedium);Spacer(Modifier.height(18.dp));Button(onListings,Modifier.fillMaxWidth()){Text("My Listings")};Spacer(Modifier.height(10.dp));Button(onOrders,Modifier.fillMaxWidth()){Text("Seller Orders")};Spacer(Modifier.height(10.dp));Button(onPayment,Modifier.fillMaxWidth()){Text("Seller Payment")};Spacer(Modifier.height(10.dp));Button(onChat,Modifier.fillMaxWidth()){Text("Seller Chat")};Spacer(Modifier.height(10.dp));OutlinedButton(onBack,Modifier.fillMaxWidth()){Text("Back to Buyer")}}}
