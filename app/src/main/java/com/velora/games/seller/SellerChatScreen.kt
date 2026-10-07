package com.velora.games.seller
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable fun SellerChatScreen(onBack:()->Unit){Column(Modifier.fillMaxSize().padding(20.dp)){Text("Seller Chat",style=MaterialTheme.typography.headlineMedium);Text("Conversation UI");TextButton(onBack,Modifier.fillMaxWidth()){Text("Back")}}}
