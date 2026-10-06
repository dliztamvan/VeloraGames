package com.velora.games;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class VeloraFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token) {
        getSharedPreferences("velora_push", MODE_PRIVATE)
            .edit().putString("fcm_token", token).apply();
    }

    @Override
    public void onMessageReceived(RemoteMessage message) {
        String title = "VeloraGames";
        String body = "Ada aktivitas baru.";

        if (message.getNotification() != null) {
            if (message.getNotification().getTitle() != null)
                title = message.getNotification().getTitle();
            if (message.getNotification().getBody() != null)
                body = message.getNotification().getBody();
        }

        if (message.getData().get("title") != null)
            title = message.getData().get("title");
        if (message.getData().get("body") != null)
            body = message.getData().get("body");

        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent pi = PendingIntent.getActivity(
            this,
            1001,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE
        );

        NotificationCompat.Builder n = new NotificationCompat.Builder(this, "velora_chat")
            .setSmallIcon(android.R.drawable.ic_dialog_email)
            .setContentTitle(title)
            .setContentText(body)
            .setStyle(new NotificationCompat.BigTextStyle().bigText(body))
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .setContentIntent(pi);

        NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        nm.notify((int)(System.currentTimeMillis() & 0x7fffffff), n.build());
    }
}
