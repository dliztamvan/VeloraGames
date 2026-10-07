package com.velora.games.ui.navigation
import androidx.compose.runtime.*
import com.velora.games.admin.*
@Composable fun AdminNav(token:String,onLogout:()->Unit){var page by remember{mutableStateOf(0)};when(page){0->AdminHomeScreen({page=1},{page=2},{page=3},{page=4},{page=5},{page=6},{page=7},{page=8});1->AdminDashboardScreen(token,{page=0});2->AdminUsersScreen(token,{page=0});3->AdminProductsScreen(token,{page=0});4->AdminOrdersScreen(token,{page=0});5->AdminWithdrawalsScreen(token,{page=0});6->AdminReportsScreen(token,{page=0});7->AdminSettingsScreen(token,{page=0});8->AdminChatScreen{page=0}}}
