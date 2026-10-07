package com.velora.games.seller
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable fun SellerHomeScreen(onDashboard:()->Unit){Column(Modifier.fillMaxSize().padding(20.dp)){Text("Seller Center",style=MaterialTheme.typography.headlineMedium);Spacer(Modifier.height(18.dp));Button(onDashboard,Modifier.fillMaxWidth()){Text("Open Dashboard")}}}
