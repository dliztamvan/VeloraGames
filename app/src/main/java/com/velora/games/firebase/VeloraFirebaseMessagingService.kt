package com.velora.games.firebase
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.velora.games.R
class VeloraFirebaseMessagingService:FirebaseMessagingService(){override fun onMessageReceived(m:RemoteMessage){val channel="velora_general";if(Build.VERSION.SDK_INT>=26)getSystemService(NotificationManager::class.java).createNotificationChannel(NotificationChannel(channel,"Velora Games",NotificationManager.IMPORTANCE_DEFAULT));val n=NotificationCompat.Builder(this,channel).setSmallIcon(R.mipmap.ic_launcher).setContentTitle(m.notification?.title?:"Velora Games").setContentText(m.notification?.body?:"New notification").setAutoCancel(true).build();getSystemService(NotificationManager::class.java).notify((System.currentTimeMillis()%100000).toInt(),n)}override fun onNewToken(token:String){getSharedPreferences("velora_fcm",0).edit().putString("token",token).apply()}}
