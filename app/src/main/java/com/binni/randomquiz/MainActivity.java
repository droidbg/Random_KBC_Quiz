package com.binni.randomquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
    TextView lifelineYesNotextView;

    //variables
    ArrayList<String> questionsList=new ArrayList<String>();
    int nooflifeline;
    String[] questions;
    String options[][];
    int answers[];
    Random rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTextView=findViewById(R.id.questionTextView);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        goButton=findViewById(R.id.goButton);
        yesButton=findViewById(R.id.yesButton);
        noButton=findViewById(R.id.noButton);
        lifelineYesNotextView=findViewById(R.id.lifelineYesNotextView);
        initialize();
        questionGenerate();
        rand=new Random();

    }
    void initialize(){
        nooflifeline=3;

        questions= new String[]
                {
                        "What is the full form of URL?",
                        "Which Indian Institue of Technology is known as Mother of all IIt's?",
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
                        { "1.JUPITER","2.MERCURY","3.NEPTUNE","4.STAURN"},
                        { "1.RICE","2.WHEAT","3.PULSES","4.VEGETABLES AND FRUITS"},
                        { "1.ATHENS","2.BEIJING","3.INDIA","4.LONDON"},
                        { "1.TRANSACTIONABLE MONEY","2.PLASTIC NOTES","3.PLASTIC MONEY","4.EASY MONEY"},
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
}
void questionGenerate(){
    int randIndex= rand.nextInt(15);
    while(questions[randIndex].equals(" ")){
        randIndex= rand.nextInt(15);
    }
    questionTextView.setText(questions[randIndex]);
    questions[randIndex]=" ";

    button0.setText(options[randIndex][0]);
    button1.setText(options[randIndex][1]);
    button2.setText(options[randIndex][2]);
    button3.setText(options[randIndex][3]);



    }
    void start(View view)
    {
        goButton.setVisibility(view.INVISIBLE);
    }
    public void chooseAnswer(View view) {
    }
    public void lifelineYesNo(View view) {
       if(view.getTag().toString().equals("no")){
           Toast.makeText(this, "Ohkay Smarty!!", Toast.LENGTH_SHORT).show();
           if(nooflifeline>0)
           {
               Toast.makeText(this, "You Still have "+nooflifeline+" Remaining", Toast.LENGTH_LONG).show();

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