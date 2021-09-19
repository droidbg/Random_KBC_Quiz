package com.binni.randomquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Views Declarations
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button goButton;
    Button noButton;
    Button yesButton;
    TextView questionTextView;
    TextView scoreTextView;
    TextView gamelabelTextView;
    TextView timerTextView;
    TextView lifelineYesNotextView;
    LinearLayout lifelineLayout;
    ConstraintLayout gameLayout;
    CountDownTimer countDownTimer=null;

    //variables
    int nooflifeline;
    String[] questions;
    String options[][];
    int answers[];
    int randIndex;
    long money[];
    int moneyIndex;
    boolean doubleDipOn;
    final String RupeeSign="₹";
    boolean gameWin,gameOver;
    int CorrectIndex;

    Random rand=new Random();
    public void initializeGame(){
        nooflifeline=3;
        gameOver=false;
        moneyIndex=0;
        doubleDipOn=false;
        gameWin=false;
        countDownTimer=null;
        gamelabelTextView.setText("Game Started");
        button0.setClickable(true);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);

        questions= new String[]
                {
                        "What is the full form of URL?",
                        "Which Indian Institute of Technology is known as Mother of all IIT's?",
                        "How many players are there in hockey?",
                        "NAME THE VEGETABLE WHICH IS ALSO KNOWN AS FLOWER?",
                        "WHICH PLANET HAS THE 'GREAT RED SPOT'?",
                        "WHAT IS THE STAPLE OOD OF 1/3rd Population of the world?",
                        "What was the Venue Of olympic 2014?",
                        "Credits Cards Are also known as?",
                        "Mostly which gases are found in the planet JUPITRER?",
                        "Worlds first hydrogen powered train was launched in which country?",
                        "OxfordDictionaries.com launched in which year?",
                        "who was the founder of brahmo samaj?",
                        "Ruler of Mysor was?",
                        "what is the national reptile of india?",
                        "What is the rank of indian passport at the 20 henley passport index?"
                };
        options=new String[][]
                {
                        { "Universal Resource Locator","Uniform Resource Locator","Uniform Research Locator","United Resource Locator"},
                        {"1.IIT DELHI","2.IIT BOMBAY","3.IIT KANPUR","4.IIT KHARAGPUR"},
                        { "1. FOUR","2.FIVE","3.SIX","4.ELEVEN"},
                        { "1.CAULIFLOWER","2.BROCCOLI","3.CABOAGE","4.JALIPINOES"},
                        { "1.JUPITER","2.MERCURY","3.NEPTUNE","4.SATURN"},
                        { "1.RICE","2.WHEAT","3.PULSES","4.VEGETABLES AND FRUITS"},
                        { "1.ATHENS","2.BEIJING","3.INDIA","4.LONDON"},
                        { "1.TRANSACTIONAL MONEY","2.PLASTIC NOTES","3.PLASTIC MONEY","4.EASY MONEY"},
                        { "1.HYDROGEN AND NEON","2.NEON AND HELIUM","3.HELIUM AND ARAGON","4.HYDROGEN AND HELIUM"},
                        { "1.JAPAN","2.GERMANY","3.IRAQ","4.AMERICA"},
                        { "1.1997","2.1992","3.1993","4.1995"},
                        { "1.Raja Ram Mohan Roy","2.Swami Vivekananda","3.Dayand Saraswati","4.Kabir Das"},
                        { "1.Hyder Ali","2.Muhammad Ghori","3.Yaduraya Wodlysr","4.Sunni Islam"},
                        { "1.Anaconda","2.King Cobra","3.Snail","4.Turtle"},
                        { "1.55th","2.86th","3.4th","4.77th"},


                };

        answers =new int[]
                {2,4,3,2,1,1,1,3,4,2,2,1,1,2,2};
        money=new long[]{1000,2000,3000,5000,10000,20000,40000,80000,160000,320000,640000,1250000,2500000,5000000,10000000};
    }

    public void startBackgroundAnimate(){
        ConstraintLayout constraintLayout = findViewById(R.id.conslayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBackgroundAnimate();


        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        goButton=findViewById(R.id.goButton);
        yesButton=findViewById(R.id.yesButton);
        noButton=findViewById(R.id.noButton);
        gameLayout=findViewById(R.id.gameLayout);
        lifelineLayout=findViewById(R.id.lifelineLayout);
        timerTextView=findViewById(R.id.timerTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        gamelabelTextView=findViewById(R.id.gamelabelTextView);
        questionTextView=findViewById(R.id.questionTextView);
        lifelineYesNotextView=findViewById(R.id.lifelineYesNotextView);
        gameLayout.setVisibility(View.INVISIBLE);
        goButton.setVisibility(View.VISIBLE);
        lifelineLayout.setVisibility(View.INVISIBLE);


    }
    public void start(View view)
    {
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        initializeGame();
        questionGenerate();
    }


    public void questionGenerate(){
        buttoninit();
        cancelTimer();
    randIndex= rand.nextInt(15);
    while(questions[randIndex].equals(" ")){
        randIndex= rand.nextInt(15);
    }
    questionTextView.setText(questions[randIndex]);
    questions[randIndex]=" ";

    button0.setText(options[randIndex][0]);
    button1.setText(options[randIndex][1]);
    button2.setText(options[randIndex][2]);
    button3.setText(options[randIndex][3]);
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
        CorrectIndex=answers[randIndex]-1;
        if(CorrectIndex==chosenIndex){
            gamelabelTextView.setText("Correct Answer!!\n"+"Congratulations You have won "+RupeeSign+money[moneyIndex]);
//            Toast.makeText(this, "Correct Answer!!\n"+"Congratulations You have won "+RupeeSign+money[moneyIndex], Toast.LENGTH_SHORT).show();
            scoreTextView.setText(RupeeSign+""+money[moneyIndex]);
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
        }
        cancelTimer();
        button0.setClickable(false);
        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);

    }

    public void lifelineYesNo(View view) {
        if(gameOver)
            return;
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


    public void lifelineSelect(View view) {
    view.setVisibility(View.INVISIBLE);
    view.setClickable(false);
        int tagVal=Integer.parseInt(view.getTag().toString());
        switch (tagVal)
        {
            case 0://Flip The Question
                Toast.makeText(this, "Flipping the Question", Toast.LENGTH_SHORT).show();
                questionGenerate();
                break;
            case 1://50:50
//                CorrectIndex
                int rind=rand.nextInt(4);
                while(rind==CorrectIndex)
                {
                    rind=rand.nextInt(4);
                }
                hideIndex(rind);
                hideIndex(CorrectIndex);

                break;
            case 2:
                //Double Dip
                doubleDipOn=true;
                break;
        }
        nooflifeline--;
        lifelineLayout.setVisibility(View.INVISIBLE);
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

}