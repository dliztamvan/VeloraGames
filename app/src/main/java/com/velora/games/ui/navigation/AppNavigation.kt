package com.velora.games.ui.navigation
import androidx.compose.runtime.*
import com.velora.games.auth.*
import com.velora.games.buyer.*
import com.velora.games.seller.*
import com.velora.games.admin.*
import com.velora.games.core.SessionManager
import com.velora.games.network.Product

enum class AppArea { AUTH, BUYER, SELLER, ADMIN }
@Composable fun AppNavigation(session:SessionManager){
    var splash by remember{mutableStateOf(true)}
    var area by remember{mutableStateOf(if(session.loggedIn()) AppArea.BUYER else AppArea.AUTH)}
    var authPage by remember{mutableStateOf(0)}
    var token by remember{mutableStateOf(session.token().orEmpty())}
    var selected by remember{mutableStateOf<Product?>(null)}
    if(splash){SplashScreen{ splash=false };return}
    if(area==AppArea.AUTH){
        if(authPage==0) LoginScreen({t,id,admin,seller->token=t;session.save(t,id);area=when{admin->AppArea.ADMIN;seller->AppArea.BUYER;else->AppArea.BUYER}},{authPage=1})
        else RegisterScreen({authPage=0},{authPage=0})
        return
    }
    when(area){
        AppArea.BUYER->BuyerNav(token,{selected=it},{area=AppArea.SELLER},{session.clear();token="";area=AppArea.AUTH})
        AppArea.SELLER->SellerNav(token,{area=AppArea.BUYER})
        AppArea.ADMIN->AdminNav(token,{session.clear();token="";area=AppArea.AUTH})
        else->{area=AppArea.AUTH}
    }
}
