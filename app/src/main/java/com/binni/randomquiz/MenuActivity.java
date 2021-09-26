package com.binni.randomquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        startBackgroundAnimate();
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
    public void startBackgroundAnimate(){
        ConstraintLayout constraintLayout = findViewById(R.id.menuConstrain);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
}