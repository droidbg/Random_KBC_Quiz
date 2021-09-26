package com.binni.randomquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class PrivacyActivity extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);

        web =(WebView)findViewById(R.id.webView);
        web.loadUrl("https://droidbg.github.io/Privacy-Policy/RandomQuiz.html");

    }
}