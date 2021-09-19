package com.binni.randomquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
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
    final String RupeeSign="₹";
    boolean gameWin;

    Random rand=new Random();
   public void startBackgroundAnimate(){
        ScrollView scrollView = findViewById(R.id.scrolllayout);
        AnimationDrawable animationDrawable = (AnimationDrawable) scrollView.getBackground();
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
        timerTextView=findViewById(R.id.timerTextView);
        scoreTextView=findViewById(R.id.scoreTextView);
        gamelabelTextView=findViewById(R.id.gamelabelTextView);
        questionTextView=findViewById(R.id.questionTextView);
        lifelineYesNotextView=findViewById(R.id.lifelineYesNotextView);
        gameLayout.setVisibility(View.INVISIBLE);
        goButton.setVisibility(View.VISIBLE);


    }
    public void start(View view)
    {
        goButton.setVisibility(View.INVISIBLE);
        gameLayout.setVisibility(View.VISIBLE);
        initializeGame();
        questionGenerate();
    }

    public void initializeGame(){
        nooflifeline=3;
        moneyIndex=0;
        gameWin=false;
        countDownTimer=null;
        gamelabelTextView.setText("Game Started");
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

    public void questionGenerate(){
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
                    timerTextView.setText("0:"+String.valueOf(millisUntilFinished/1000));
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
        String timerDisplay=String.valueOf(minutes) + ":" + String.valueOf(seconds);
        if(seconds==0&&minutes==0)
        {
            timerDisplay=timerDisplay+"0";
        }
        timerTextView.setText(timerDisplay);
    }


    public void chooseAnswer(View view) {
        int chosenIndex=Integer.parseInt(view.getTag().toString());
        if((answers[randIndex]-1)==chosenIndex){
            gamelabelTextView.setText("Correct Answer!!\n"+"Congratulations You have won "+RupeeSign+money[moneyIndex]);
//            Toast.makeText(this, "Correct Answer!!\n"+"Congratulations You have won "+RupeeSign+money[moneyIndex], Toast.LENGTH_SHORT).show();
            scoreTextView.setText(RupeeSign+""+money[moneyIndex]);
            moneyIndex++;
            cancelTimer();
            if(moneyIndex<=14)
            questionGenerate();
            else{
                gamelabelTextView.setText("WON THE GAME, THIS MONEY IS ALL YOURS!!");
                gameWin=true;
                finishGame();
            }
        }
        else{
            gamelabelTextView.setText("Incorrect Answer!!\n Want to Use a Lifeline??");
           // Toast.makeText(this, "Incorrect Answer!!\n Want to Use a Lifeline??", Toast.LENGTH_SHORT).show();

        }

    }
public void cancelTimer(){
    if(moneyIndex<=8 && countDownTimer!=null)
        countDownTimer.cancel();
}
    private void finishGame() {
        if(gameWin!=true)
        gamelabelTextView.setText("Game Over!!");
        cancelTimer();
        button0.setClickable(false);
        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);

    }

    public void lifelineYesNo(View view) {
       if(view.getTag().toString().equals("no")){
           Toast.makeText(this, "Okay Smarty!!", Toast.LENGTH_SHORT).show();
           if(nooflifeline>0) {
               Toast.makeText(this, "You Still have " + nooflifeline + " Lifelines Remaining", Toast.LENGTH_SHORT).show();

           }
       }
       else{
           if(nooflifeline<=0)
           {
               Toast.makeText(this, "Sorry!! No LifeLine Remaining.\n", Toast.LENGTH_SHORT).show();
           }
           else {

//               lifelineYesNotextView.setVisibility(view.INVISIBLE);
//               yesButton.setVisibility(view.INVISIBLE);
//               noButton.setVisibility(view.INVISIBLE);

           }
       }
    }


}