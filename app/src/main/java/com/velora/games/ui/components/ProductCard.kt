package com.velora.games.ui.components
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.velora.games.core.Utils
import com.velora.games.network.Product
@Composable fun ProductCard(product:Product,onClick:()->Unit){VeloraCard(Modifier.padding(vertical=6.dp).clickable(onClick=onClick)){Text(product.title ?: "Untitled",fontWeight=FontWeight.Bold,fontSize=17.sp);Spacer(Modifier.height(6.dp));Text(product.game ?: product.category ?: "Game");Spacer(Modifier.height(8.dp));Text(Utils.rupiah(product.price),fontWeight=FontWeight.Bold)}}
