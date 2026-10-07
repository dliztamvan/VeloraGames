package com.velora.games.buyer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.network.User
@Composable fun BuyerProfileScreen(user:User?,onSeller:()->Unit,onLogout:()->Unit,onBack:()->Unit){Column(Modifier.fillMaxSize().padding(20.dp)){Text("Profile",style=MaterialTheme.typography.headlineMedium);Spacer(Modifier.height(16.dp));Text(user?.name?:user?.username?:"User");Text(user?.email?:"");Spacer(Modifier.height(24.dp));if(user?.is_seller==1)Button(onSeller,Modifier.fillMaxWidth()){Text("Seller Center")};Spacer(Modifier.height(10.dp));OutlinedButton(onLogout,Modifier.fillMaxWidth()){Text("Sign Out")}}}
