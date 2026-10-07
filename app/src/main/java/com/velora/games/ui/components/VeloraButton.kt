package com.velora.games.ui.components
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.velora.games.ui.theme.VeloraPurple
@Composable fun VeloraButton(text:String,modifier:Modifier=Modifier,enabled:Boolean=true,loading:Boolean=false,onClick:()->Unit){Button(onClick,modifier.fillMaxWidth().height(52.dp),enabled=enabled&&!loading,shape=RoundedCornerShape(16.dp),colors=ButtonDefaults.buttonColors(containerColor=VeloraPurple)){if(loading)CircularProgressIndicator(strokeWidth=2.dp,color=MaterialTheme.colorScheme.onPrimary,modifier=Modifier.size(20.dp))else Text(text)}}
