package com.droidsetter.randomquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import droidsetter.randomquiz.R;


public class PrivacyActivity extends AppCompatActivity {
    WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        web =(WebView)findViewById(R.id.webView);
        web.loadUrl("https://droidbg.github.io/Privacy-Policy/RandomQuiz.html");

    }
}