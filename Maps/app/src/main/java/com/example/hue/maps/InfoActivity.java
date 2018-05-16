package com.example.hue.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class InfoActivity extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        webView = (WebView) findViewById(R.id.wevViewInfo);

        Intent intent = getIntent();

        String link = intent.getStringExtra("linkdiadiem");

        webView.loadUrl(link);

        webView.setWebViewClient(new WebViewClient());
    }
}
