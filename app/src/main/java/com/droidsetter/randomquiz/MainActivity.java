package com.droidsetter.randomquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

import droidsetter.randomquiz.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        goButton=findViewById(R.id.goButton);
        yesButton=findViewById(R.id.yesButton);
        noButton=findViewById(R.id.noButton);
        resetButton=findViewById(R.id.resetButton);
        gameLayout=findViewById(R.id.gameLayout);
        lifelineLayout=findViewById(R.id.lifelineLayout);
        timerTextView=findViewById(R.id.timerTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        gamelabelTextView=findViewById(R.id.gamelabelTextView);
        questionTextView=findViewById(R.id.questionTextView);
        resetTextView=findViewById(R.id.resetTextView);
        lifelineYesNotextView=findViewById(R.id.lifelineYesNotextView);
//        gameLayout.setVisibility(View.INVISIBLE);
//        goButton.setVisibility(View.VISIBLE);
        lifelineLayout.setVisibility(View.INVISIBLE);
        //removing Go button and directly opening the game;
        start(findViewById(R.id.button0));

    }

    public void initializeGame()
    {
        doubleDipOn=false;
        nooflifeline=3;
        gameOver=false;
        lifelineAlreadyTaken=0;
        moneyIndex=0;
        doubleDipOn=false;
        gameWin=false;

        countDownTimer=null;
        lifelineLayout.setClickable(true);

        gamelabelTextView.setText("Game Started");
        button0.setClickable(true);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        gameLayout.setClickable(true);
        visibleLifelines();
        Quiz_Set quiz=new Quiz_Set();
        questions=quiz.questionSet;
        options=quiz.optionsSet;
        answers =quiz.answersIndexSet;
        money=quiz.moneySet;
//        money=quiz.moneySet;
        lastindex = answers.size();
    }



    public void start(View view)
    {
//        goButton.setVisibility(View.INVISIBLE);
        resetButton.setVisibility(View.INVISIBLE);
        resetTextView.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        scoreTextView.setText("₹0");
        initializeGame();
        questionGenerate();
    }


    public void questionGenerate(){
        doubleDipOn=false;
        lifelineAlreadyTaken=0;
        buttoninit();
        cancelTimer();
        randIndex= rand.nextInt(lastindex);
        while(questions.get(randIndex).equals(" ")){
            randIndex= rand.nextInt(lastindex);
        }
        questionTextView.setText(questions.get(randIndex));
        questions.set(randIndex," ");

        button0.setText(options.get(randIndex).get(0));
        button1.setText(options.get(randIndex).get(1));
        button2.setText(options.get(randIndex).get(2));
        button3.setText(options.get(randIndex).get(3));
        if(moneyIndex<=7) {
            SetTimer();
        }
        else {
            Toast.makeText(this, "No Time Limit For This Question", Toast.LENGTH_SHORT).show();
            timerTextView.setText("∞");
        }


    }

    public int timeLimit(int ind)
    {
        int timerSeconds=0;
        if(ind>=0 && ind<=1)
            timerSeconds=30;
        else if(ind>=2 && ind<=7)
            timerSeconds=45;
        else
            timerSeconds=0;

        return timerSeconds;
    }

    private void SetTimer() {
        int timerSeconds=timeLimit(moneyIndex);
        int milliseconds=(timerSeconds*1000)+100;

        countDownTimer=  new CountDownTimer(milliseconds,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int)millisUntilFinished/1000);
//                    timerTextView.setText("0:"+String.valueOf(millisUntilFinished/1000));
            }

            @Override
            public void onFinish() {
                finishGame();
            }
        }.start();




    }

    public void updateTimer(int secondsLeft){
        int minutes=secondsLeft/60;
        int seconds=secondsLeft%60;
//      int seconds=secondsLeft-(minutes*60);
        String timerDisplay=String.valueOf(minutes) + ":";
        if(seconds<=9)
        {
            timerDisplay+="0";
        }
        timerDisplay+=String.valueOf(seconds);
        timerTextView.setText(timerDisplay);
    }


    public void chooseAnswer(View view) {
        int chosenIndex=Integer.parseInt(view.getTag().toString());
        CorrectIndex=answers.get(randIndex)-1;
        if(CorrectIndex==chosenIndex){
            gamelabelTextView.setText("Correct Answer!!\n"+"Congratulations You have won "+RupeeSign+money.get(moneyIndex));
//            Toast.makeText(this, "Correct Answer!!\n"+"Congratulations You have won "+RupeeSign+money[moneyIndex], Toast.LENGTH_SHORT).show();
            scoreTextView.setText(RupeeSign+""+money.get(moneyIndex));
//            scoreTextView.setText(RupeeSign+""+money[moneyIndex]);
            moneyIndex++;
            cancelTimer();
            if(moneyIndex<=14)
                questionGenerate();
            else{
                gamelabelTextView.setText("You are a real Champ,\n Congrats for Winning.\nTHIS MONEY IS ALL YOURS!!");
                gameWin=true;
                finishGame();
            }
        }
        else{
            gamelabelTextView.setText("Incorrect Answer!!");
            if(doubleDipOn)
            {
                doubleDipOn=false;

            }
            else {
                finishGame();
            }
            // Toast.makeText(this, "Incorrect Answer!!\n Want to Use a Lifeline??", Toast.LENGTH_SHORT).show();

        }

    }

    public void cancelTimer(){
        if(moneyIndex<=8 && countDownTimer!=null)
            countDownTimer.cancel();
    }

    private void finishGame() {
        if(gameWin!=true) {
            gameOver=true;
            gamelabelTextView.setText("Game Over!!\nYou are OUT");
            gameLayout.setVisibility(View.INVISIBLE);
            gameoverDisplay();
        }
        else{
            gameLayout.setClickable(false);
            lifelineLayout.setClickable(false);


        }
        lifelineLayout.setVisibility(View.INVISIBLE);
        cancelTimer();
        button0.setClickable(false);
        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);

    }

    public void lifelineYesNo(View view) {

        if(view.getTag().toString().equals("no")){
            Toast.makeText(this, "Okay Smarty!!", Toast.LENGTH_SHORT).show();
            lifelineLayout.setVisibility(View.INVISIBLE);

            if(nooflifeline>0) {
                Toast.makeText(this, "You Still have " + nooflifeline + " Lifelines Remaining", Toast.LENGTH_SHORT).show();
            }
        }
        else{ //if click on yes button
            if(nooflifeline<=0) //no lifeline left
            {
                gamelabelTextView.setText("NO Lifeline Left\nJust make a guess if you have Some guts..");
                Toast.makeText(this, "Sorry!! No LifeLine Remaining.\n", Toast.LENGTH_SHORT).show();
            }
            else { //lifelines is there

                lifelineLayout.setVisibility(View.VISIBLE);


            }
        }
    }

    public void gameoverDisplay(){
        resetButton.setVisibility(View.VISIBLE);
        resetTextView.setVisibility(View.VISIBLE);
        if(moneyIndex!=0)
            resetTextView.setText("Game Over!! Won: ₹"+ money.get(moneyIndex-1));
        else
            resetTextView.setText("Game Over!! Won: ₹0.");

    }

    public void lifelineSelect(View view) {
        if(lifelineAlreadyTaken!=0)
            return;
        if(gameOver || gameWin)
            return;
        lifelineAlreadyTaken++;
        view.setVisibility(View.INVISIBLE);

        int tagVal=Integer.parseInt(view.getTag().toString());
        nooflifeline--;
        lifelineLayout.setVisibility(View.INVISIBLE);
        switch (tagVal)
        {
            case 0://Flip The Question
                Toast.makeText(this, "Flipping the Question", Toast.LENGTH_SHORT).show();
                questionGenerate();
                break;
            case 1://50:50
                int hide=-1;
                CorrectIndex=answers.get(randIndex)-1;
                hide= hideWrongIndex(CorrectIndex);
                hideWrongIndex(hide);

                break;
            case 2:
                //Double Dip
                doubleDipOn=true;
                break;
        }

    }

    public int hideWrongIndex(int hide){

        int rind=rand.nextInt(4);
        while(rind==CorrectIndex || rind==hide )
        {
            rind=rand.nextInt(4);
        }
        hideIndex(rind);
        return rind;
    }

    private void hideIndex(int i) {
        switch (i)
        {
            case 0:
                button0.setVisibility(View.INVISIBLE);
                break;
            case 1:
                button1.setVisibility(View.INVISIBLE);
                break;
            case 2:
                button2.setVisibility(View.INVISIBLE);
                break;
            case 3:
                button3.setVisibility(View.INVISIBLE);
                break;
        }

    }

    void buttoninit(){
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
        button0.setClickable(true);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);

    }

    public void visibleLifelines(){
        Button lifeline1=findViewById(R.id.lifeline1);
        Button lifeline2=findViewById(R.id.lifeline2);
        Button lifeline3=findViewById(R.id.lifeline3);
        lifeline1.setVisibility(View.VISIBLE);
        lifeline2.setVisibility(View.VISIBLE);
        lifeline3.setVisibility(View.VISIBLE);

    }


    //Views Declarations
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button goButton;
    Button noButton;
    Button yesButton;
    Button resetButton;
    TextView questionTextView;
    TextView scoreTextView;
    TextView resetTextView;
    TextView gamelabelTextView;
    TextView timerTextView;
    TextView lifelineYesNotextView;
    LinearLayout lifelineLayout;
    ConstraintLayout gameLayout;
    CountDownTimer countDownTimer=null;

    //variables
    int nooflifeline;
//    String[] questions;

//    int answers[];
    int randIndex;

//    long money[];
    int moneyIndex;
    boolean doubleDipOn;
    final String RupeeSign="₹";
    boolean gameWin,gameOver;
    int lifelineAlreadyTaken=0;
    int CorrectIndex;
    int lastindex=0;
    Random rand=new Random();

    Vector<Integer> money;
    Vector<String> questions;
    Vector<Vector<String>> options;
    Vector<Integer> answers;
}