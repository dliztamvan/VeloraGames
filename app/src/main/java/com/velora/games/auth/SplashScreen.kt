package com.velora.games.auth
import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
@Composable fun SplashScreen(onDone:()->Unit){var show by remember{mutableStateOf(false)};LaunchedEffect(Unit){show=true;delay(1700);onDone()};Box(Modifier.fillMaxSize(),contentAlignment=Alignment.Center){AnimatedVisibility(show,enter=fadeIn()){Row(verticalAlignment=Alignment.CenterVertically){Text("V",fontSize=72.sp,fontWeight=FontWeight.Bold);Spacer(Modifier.width(12.dp));Column{Text("Welcome",fontSize=14.sp);Text("Velora Games",fontSize=24.sp,fontWeight=FontWeight.Bold);Text("Marketplace akun game",fontSize=13.sp)}}}}}
