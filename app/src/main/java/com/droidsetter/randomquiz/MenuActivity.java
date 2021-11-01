package com.droidsetter.randomquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import droidsetter.randomquiz.R;

public class MenuActivity extends AppCompatActivity {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

    }

    public void play(View view) {
        intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void privacy(View view) {
        intent=new Intent(this,PrivacyActivity.class);
        startActivity(intent);
    }

    public void credits(View view) {
        intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void gameRules(View view) {
        intent=new Intent(this,GameRuleActivity.class);
        startActivity(intent);
    }

}