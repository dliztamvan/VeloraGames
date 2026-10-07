package com.velora.games.network
import com.velora.games.core.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

class VeloraApi(private val token:String?=null) {
    private val client=OkHttpClient()
    private val json="application/json; charset=utf-8".toMediaType()
    private suspend fun call(path:String,method:String="GET",body:JSONObject?=null): Result<JSONObject> = withContext(Dispatchers.IO) {
        try { val b=body?.toString()?.toRequestBody(json); val req=Request.Builder().url(Constants.BASE_URL+path).apply { if(!token.isNullOrBlank()) addHeader("Authorization","Bearer $token"); when(method){"POST"->post(b!!);"PUT"->put(b!!);"DELETE"->delete(b)} }.build(); client.newCall(req).execute().use { r -> val text=r.body?.string().orEmpty(); val o=if(text.isBlank()) JSONObject() else JSONObject(text); if(r.isSuccessful) Result.success(o) else Result.failure(Exception(o.optString("message","Request failed (${r.code})"))) } } catch(e:Exception){ Result.failure(e) }
    }
    suspend fun health()=call("/health")
    suspend fun login(email:String,password:String)=call("/auth/login","POST",JSONObject().put("email",email).put("password",password))
    suspend fun register(name:String,email:String,password:String)=call("/auth/register","POST",JSONObject().put("name",name).put("email",email).put("password",password))
    suspend fun logout()=call("/auth/logout","POST",JSONObject())
    suspend fun me()=call("/me")
    suspend fun products()=call("/products")
    suspend fun sellerStatus()=call("/seller/status")
    suspend fun sellerListings()=call("/seller/listings")
    suspend fun addProduct(game:String,title:String,price:Long,description:String,photos:JSONArray=JSONArray())=call("/seller/listings","POST",JSONObject().put("game",game).put("title",title).put("price",price).put("description",description).put("photos",photos))
    suspend fun updateProduct(id:String,game:String,title:String,price:Long,description:String)=call("/seller/listings/$id","PUT",JSONObject().put("game",game).put("title",title).put("price",price).put("description",description))
    suspend fun orders()=call("/orders")
    suspend fun createOrder(productId:String)=call("/orders","POST",JSONObject().put("productId",productId))
    suspend fun chats()=call("/chats")
    suspend fun adminStats()=call("/admin/stats")
    suspend fun adminUsers()=call("/admin/users")
    suspend fun adminProducts()=call("/admin/products")
    suspend fun adminOrders()=call("/admin/orders")
    suspend fun adminWithdrawals()=call("/admin/withdrawals")
    suspend fun adminReports()=call("/admin/reports")
    suspend fun adminSettings()=call("/admin/settings")
}
fun JSONObject.user():User=User(optString("id",null),optString("username",null),optString("email",null),optString("name",null),optInt("is_admin",0),optInt("is_seller",0))
fun JSONObject.productsList():List<Product>{ val a=optJSONArray("products")?:optJSONArray("data")?:JSONArray(); return (0 until a.length()).mapNotNull{a.optJSONObject(it)?.let{p->Product(p.optString("id",null),p.optString("title",null),p.optString("description",null),p.optLong("price",0),p.optString("category",null),p.optString("game",null),p.optString("image",null),p.optString("seller_id",null),p.optString("seller_name",null),p.optString("status",null))} } }
