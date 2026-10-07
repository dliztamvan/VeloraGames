package com.velora.games.auth
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.velora.games.network.VeloraApi
import kotlinx.coroutines.launch
@Composable fun RegisterScreen(onRegistered:()->Unit,onBack:()->Unit){var name by remember{mutableStateOf("")};var email by remember{mutableStateOf("")};var pass by remember{mutableStateOf("")};var loading by remember{mutableStateOf(false)};var error by remember{mutableStateOf("")};val scope=rememberCoroutineScope();Column(Modifier.fillMaxSize().padding(24.dp),verticalArrangement=Arrangement.Center){Text("Create Account",style=MaterialTheme.typography.headlineMedium);Spacer(Modifier.height(20.dp));OutlinedTextField(name,{name=it},Modifier.fillMaxWidth(),label={Text("Name")},singleLine=true);Spacer(Modifier.height(10.dp));OutlinedTextField(email,{email=it},Modifier.fillMaxWidth(),label={Text("Email")},singleLine=true);Spacer(Modifier.height(10.dp));OutlinedTextField(pass,{pass=it},Modifier.fillMaxWidth(),label={Text("Password")},visualTransformation=PasswordVisualTransformation(),singleLine=true);if(error.isNotBlank())Text(error,color=MaterialTheme.colorScheme.error);Spacer(Modifier.height(18.dp));Button({scope.launch{loading=true;val r=VeloraApi().register(name,email,pass);loading=false;r.onSuccess{onRegistered()}.onFailure{error=it.message?:"Register gagal"}}},Modifier.fillMaxWidth().height(52.dp),enabled=!loading){if(loading)CircularProgressIndicator(strokeWidth=2.dp)else Text("Create Account")};TextButton(onBack,Modifier.fillMaxWidth()){Text("Already have an account? Sign In")}}
}
