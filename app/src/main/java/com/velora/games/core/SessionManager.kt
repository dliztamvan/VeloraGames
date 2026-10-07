package com.velora.games.core
import android.content.Context
class SessionManager(context: Context) {
    private val p = context.getSharedPreferences("velora_session", Context.MODE_PRIVATE)
    fun save(token: String, userId: String? = null) = p.edit().putString(Constants.SESSION_KEY, token).putString(Constants.USER_KEY, userId).apply()
    fun token(): String? = p.getString(Constants.SESSION_KEY, null)
    fun userId(): String? = p.getString(Constants.USER_KEY, null)
    fun loggedIn() = !token().isNullOrBlank()
    fun clear() = p.edit().clear().apply()
}
