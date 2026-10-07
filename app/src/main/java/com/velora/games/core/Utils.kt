package com.velora.games.core
import android.content.Context
import android.widget.Toast
import java.text.NumberFormat
import java.util.Locale
object Utils {
    fun toast(c: Context, s: String) = Toast.makeText(c, s, Toast.LENGTH_SHORT).show()
    fun rupiah(n: Number?): String = NumberFormat.getCurrencyInstance(Locale("id","ID")).apply { maximumFractionDigits=0 }.format(n ?: 0).replace("IDR", "Rp").replace("Rp ", "Rp")
}
