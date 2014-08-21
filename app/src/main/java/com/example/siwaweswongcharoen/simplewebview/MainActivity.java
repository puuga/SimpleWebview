package com.example.siwaweswongcharoen.simplewebview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebView;


public class MainActivity extends Activity {

    //private String webURL = "http://www.google.com";
    private String webURL = "file:///android_asset/web.html";
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidget();
    }

    private void bindWidget() {
        webView = (WebView) findViewById(R.id.webView);
        configWebView();
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void configWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new MyWebClient(getApplicationContext()));
        webView.addJavascriptInterface((this), "Android");
        webView.loadUrl(webURL);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @JavascriptInterface
    public void showNotification(String title, String content) {
        //Log.d("show noti", "show noti:" + title + "," + content);
        NotificationCompat.Builder mBuilder;
        mBuilder = new NotificationCompat.Builder(this).setSmallIcon(R.drawable.ic_launcher).setContentTitle(title).setContentText(content);
        Notification notification = mBuilder.build();
        notification.defaults = Notification.DEFAULT_ALL;
        int mNotificationId = 1;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(mNotificationId, notification);
    }

}
