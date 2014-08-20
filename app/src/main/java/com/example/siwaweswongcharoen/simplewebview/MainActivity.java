package com.example.siwaweswongcharoen.simplewebview;

import android.app.Activity;
import android.os.Bundle;
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

    private void configWebView() {
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new MyWebClient(getApplicationContext()));
        webView.loadUrl(webURL);
    }

    @Override
    public void onBackPressed() {
        if(webView.canGoBack() == true){
            webView.goBack();
        }else{
            super.onBackPressed();
        }
    }

}
