package com.velora.games;

import android.Manifest;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends Activity {
    private WebView webView;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);

        createNotificationChannel();

        webView = new WebView(this);
        webView.setWebViewClient(new WebViewClient());

        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setDatabaseEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);

        webView.addJavascriptInterface(new VeloraPushBridge(), "VeloraPush");
        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);

        if (Build.VERSION.SDK_INT >= 33 &&
            ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.POST_NOTIFICATIONS},
                9001
            );
        }

        FirebaseMessaging.getInstance().getToken().addOnSuccessListener(token ->
            getSharedPreferences("velora_push", MODE_PRIVATE)
                .edit().putString("fcm_token", token).apply()
        );
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                "velora_chat",
                "VeloraGames",
                NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Chat and order notifications");
            NotificationManager nm = getSystemService(NotificationManager.class);
            nm.createNotificationChannel(channel);
        }
    }

    public class VeloraPushBridge {
        @JavascriptInterface
        public String getToken() {
            return getSharedPreferences("velora_push", MODE_PRIVATE)
                .getString("fcm_token", "");
        }

        @JavascriptInterface
        public void refreshToken() {
            FirebaseMessaging.getInstance().getToken().addOnSuccessListener(token ->
                getSharedPreferences("velora_push", MODE_PRIVATE)
                    .edit().putString("fcm_token", token).apply()
            );
        }
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
