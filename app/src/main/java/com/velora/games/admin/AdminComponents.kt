package com.velora.games.admin
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable fun AdminPage(title:String,status:String,onBack:()->Unit,onRefresh:()->Unit={}){Column(Modifier.fillMaxSize().padding(18.dp)){Text(title,style=MaterialTheme.typography.headlineSmall);Spacer(Modifier.height(14.dp));Text(status);Spacer(Modifier.height(20.dp));Button(onRefresh,Modifier.fillMaxWidth()){Text("Refresh")};TextButton(onBack,Modifier.fillMaxWidth()){Text("Back")}}}
