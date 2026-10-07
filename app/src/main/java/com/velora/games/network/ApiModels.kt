package com.velora.games.network
data class User(val id:String?=null,val username:String?=null,val email:String?=null,val name:String?=null,val is_admin:Int=0,val is_seller:Int=0)
data class Product(val id:String?=null,val title:String?=null,val description:String?=null,val price:Long=0,val category:String?=null,val game:String?=null,val image:String?=null,val seller_id:String?=null,val seller_name:String?=null,val status:String?=null)
data class Order(val id:String?=null,val product_id:String?=null,val buyer_id:String?=null,val seller_id:String?=null,val amount:Long=0,val total:Long=0,val status:String?=null,val created_at:String?=null)
data class LoginData(val token:String?=null,val session:String?=null,val user:User?=null)
data class ApiResponse<T>(val ok:Boolean=false,val message:String?=null,val data:T?=null)
