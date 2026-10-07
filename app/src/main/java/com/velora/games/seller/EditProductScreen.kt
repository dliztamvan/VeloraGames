package com.velora.games.seller
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.network.*
import kotlinx.coroutines.launch
@Composable fun EditProductScreen(token:String,product:Product,onDone:()->Unit,onBack:()->Unit){var game by remember{mutableStateOf(product.game.orEmpty())};var title by remember{mutableStateOf(product.title.orEmpty())};var price by remember{mutableStateOf(product.price.toString())};var desc by remember{mutableStateOf(product.description.orEmpty())};var error by remember{mutableStateOf("")};val scope=rememberCoroutineScope();Column(Modifier.fillMaxSize().padding(20.dp)){Text("Edit Product",style=MaterialTheme.typography.headlineSmall);OutlinedTextField(game,{game=it},Modifier.fillMaxWidth(),label={Text("Game")});OutlinedTextField(title,{title=it},Modifier.fillMaxWidth(),label={Text("Title")});OutlinedTextField(price,{price=it},Modifier.fillMaxWidth(),label={Text("Price")});OutlinedTextField(desc,{desc=it},Modifier.fillMaxWidth(),label={Text("Description")});if(error.isNotBlank())Text(error,color=MaterialTheme.colorScheme.error);Button({scope.launch{VeloraApi(token).updateProduct(product.id.orEmpty(),game,title,price.toLongOrNull()?:0,desc).onSuccess{onDone()}.onFailure{error=it.message?:"Failed"}}},Modifier.fillMaxWidth()){Text("Save Changes")};TextButton(onBack,Modifier.fillMaxWidth()){Text("Cancel")}}}
