package com.velora.games.seller
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun AddProductScreen(token:String,onDone:()->Unit,onBack:()->Unit){var game by remember{mutableStateOf("")};var title by remember{mutableStateOf("")};var price by remember{mutableStateOf("")};var desc by remember{mutableStateOf("")};var error by remember{mutableStateOf("")};val scope=rememberCoroutineScope();Column(Modifier.fillMaxSize().padding(20.dp)){Text("Add Product",style=MaterialTheme.typography.headlineSmall);listOf("Game" to game,"Title" to title,"Price" to price,"Description" to desc).forEach{(l,v)->OutlinedTextField(v,{nv->when(l){"Game"->game=nv;"Title"->title=nv;"Price"->price=nv;else->desc=nv}},Modifier.fillMaxWidth().padding(vertical=4.dp),label={Text(l)})};if(error.isNotBlank())Text(error,color=MaterialTheme.colorScheme.error);Button({scope.launch{VeloraApi(token).addProduct(game,title,price.toLongOrNull()?:0,desc).onSuccess{onDone()}.onFailure{error=it.message?:"Failed"}}},Modifier.fillMaxWidth()){Text("Publish Product")};TextButton(onBack,Modifier.fillMaxWidth()){Text("Cancel")}}}
