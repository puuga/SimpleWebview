package com.example.siwaweswongcharoen.simplewebview;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by siwaweswongcharoen on 8/21/14 AD.
 */
public class MyWebClient extends WebViewClient {

    private Context context;

    public MyWebClient(Context context) {
        this.context = context;
    }
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("tel:")) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
            return true;
        }

        view.loadUrl(url);
        return true;

    }

}
