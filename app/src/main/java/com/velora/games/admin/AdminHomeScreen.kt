package com.velora.games.admin
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@Composable fun AdminHomeScreen(onDashboard:()->Unit,onUsers:()->Unit,onProducts:()->Unit,onOrders:()->Unit,onWithdrawals:()->Unit,onReports:()->Unit,onSettings:()->Unit,onChat:()->Unit){Column(Modifier.fillMaxSize().padding(20.dp)){Text("Admin Panel",style=MaterialTheme.typography.headlineMedium);Spacer(Modifier.height(16.dp));listOf("Dashboard" to onDashboard,"Users" to onUsers,"Products" to onProducts,"Orders" to onOrders,"Withdrawals" to onWithdrawals,"Reports" to onReports,"Settings" to onSettings,"Chat" to onChat).forEach{(label,action)->Button(action,Modifier.fillMaxWidth().padding(vertical=3.dp)){Text(label)}}}}
