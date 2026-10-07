package com.velora.games.admin
import androidx.compose.runtime.*
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AdminChatScreen(onBack:()->Unit){var status by remember{mutableStateOf("Ready")};val scope=rememberCoroutineScope();AdminPage("Admin Chat", "Chat management", onBack)}
