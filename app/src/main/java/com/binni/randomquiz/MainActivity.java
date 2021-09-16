package com.binni.randomquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button goButton;
int nooflifeline=3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goButton=findViewById(R.id.goButton);
    }
    void start(View view)
    {
        goButton.setVisibility(view.INVISIBLE);
    }
    public void chooseAnswer(View view) {
    }
    public void lifelineYesNo(View view) {
       if(view.getTag().toString().equals("no")){
           Toast.makeText(this, "OK!! Your choice./n But Hey!! You have Still "+nooflifeline+" Remaining", Toast.LENGTH_SHORT).show();
       }
    }
}