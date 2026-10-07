package com.velora.games.ui.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.velora.games.ui.theme.VeloraSurface
@Composable fun VeloraCard(modifier:Modifier=Modifier,content:@Composable ColumnScope.()->Unit){Column(modifier.fillMaxWidth().shadow(3.dp,RoundedCornerShape(20.dp)).background(VeloraSurface,RoundedCornerShape(20.dp)).padding(16.dp),content=content)}
