package com.example.hue.rss_vnexpress;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class detailNewfeed extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_newfeed);
        webView = (WebView) findViewById(R.id.webViewTinTuc);

        Intent intent = getIntent();
        String link = intent.getStringExtra("linkTinTuc");

       webView.loadUrl(link);
       webView.setWebViewClient(new WebViewClient());
    }
}
