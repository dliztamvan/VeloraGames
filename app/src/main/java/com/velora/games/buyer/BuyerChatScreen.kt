package com.velora.games.buyer
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.network.VeloraApi
import com.velora.games.ui.components.VeloraTopBar
import kotlinx.coroutines.launch
@Composable fun BuyerChatScreen(token:String,onBack:()->Unit){var message by remember{mutableStateOf("Loading chats…")};val scope=rememberCoroutineScope();LaunchedEffect(Unit){scope.launch{VeloraApi(token).chats().onSuccess{message="Chats ready"}.onFailure{message=it.message?:"Chat unavailable"}}};Column(Modifier.fillMaxSize().padding(16.dp)){VeloraTopBar("Chat",true,onBack);Text(message);Spacer(Modifier.height(16.dp));Text("Conversation UI can be expanded here.")}}
