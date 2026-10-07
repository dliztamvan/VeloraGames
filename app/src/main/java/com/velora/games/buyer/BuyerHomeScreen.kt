package com.velora.games.buyer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable fun BuyerHomeScreen(onMarketplace:()->Unit,onOrders:()->Unit,onChat:()->Unit,onProfile:()->Unit){Column(Modifier.fillMaxSize().padding(20.dp)){Text("Welcome to Velora",style=MaterialTheme.typography.headlineMedium);Spacer(Modifier.height(8.dp));Text("Marketplace akun game yang simpel dan aman.");Spacer(Modifier.height(22.dp));Button(onMarketplace,Modifier.fillMaxWidth()){Text("Browse Marketplace")};Spacer(Modifier.height(8.dp));OutlinedButton(onOrders,Modifier.fillMaxWidth()){Text("My Orders")};Spacer(Modifier.height(8.dp));OutlinedButton(onChat,Modifier.fillMaxWidth()){Text("Chat")};Spacer(Modifier.height(8.dp));OutlinedButton(onProfile,Modifier.fillMaxWidth()){Text("Profile")}}}
