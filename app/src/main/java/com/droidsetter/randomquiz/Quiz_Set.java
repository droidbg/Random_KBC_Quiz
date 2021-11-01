package com.droidsetter.randomquiz;

import java.util.*;
//MAKING Code More Readable
public class Quiz_Set {

    void addOptions(String A, String B, String C, String D){
        Vector<String> tempVector=new Vector<String>();
        tempVector.add(A);
        tempVector.add(B);
        tempVector.add(C);
        tempVector.add(D);
        optionsSet.add(tempVector);
    }
    void addQuestion(String question)
    {
        questionSet.add(question);
    }
    void addAnswerIndex(int i)
    {
        answersIndexSet.add(i);
    }
    void moneyInBag(){
        moneySet.add(100);
        moneySet.add(250);
        moneySet.add(450);
        moneySet.add(700);
        moneySet.add(850);
        moneySet.add(900);
        moneySet.add(1050);
        moneySet.add(1250);
        moneySet.add(1500);
        moneySet.add(2000);
        moneySet.add(2500);
        moneySet.add(3000);
        moneySet.add(4000);
        moneySet.add(6000);
        moneySet.add(10000);
    }
    void initialiseQuizSet(){
        moneyInBag(); //Total Money Initialized

        //1. Add Questions with Options and their Correct Option:
        addQuestion("How many days do we have in a week?");
        addOptions("Eight","Seven","Three","Five");
        addAnswerIndex(2);

        //2. Add Questions with Options and their Correct Option:
        addQuestion("Which animal is known as the ‘Ship of the Desert?");
        addOptions("Dog","Fish","Lion","Camel");
        addAnswerIndex(4);

        //3. Add Questions with Options and their Correct Option:
        addQuestion("How many letters are there in the English alphabet?");
        addOptions("25","28","26","21");
        addAnswerIndex(3);

        //4. Add Questions with Options and their Correct Option:
        addQuestion("How many sides are there in a triangle?");
        addOptions("Five","Ten","Four","Three");
        addAnswerIndex(4);


        //5.Add Questions with Options and their Correct Option:
        addQuestion("In which direction does the sun rise");
        addOptions("East","West","North","South");
        addAnswerIndex(1);


        //6. Add Questions with Options and their Correct Option:
        addQuestion("Which animal is called King of Jungle?");
        addOptions("Goat","Cheetah","Penguin","Lion");
        addAnswerIndex(4);


        //7. Add Questions with Options and their Correct Option:
        addQuestion("How many days are there in the month of February in a leap year?");
        addOptions("27","29","28","30");
        addAnswerIndex(2);


        //8. Add Questions with Options and their Correct Option:
        addQuestion("Which is the largest animal in the world?");
        addOptions("Elephant","Dinosaurs","Blue Whale","Lion");
        addAnswerIndex(3);


        //9. Add Questions with Options and their Correct Option:
        addQuestion("Which festival is known as the festival of colors?");
        addOptions("Eid","Diwali","Christmas","Holi");
        addAnswerIndex(4);

        //10. Add Questions with Options and their Correct Option:
        addQuestion("What is the top color in a rainbow?");
        addOptions("Violet","Blue","Yellow","Red");
        addAnswerIndex(4);

        //11. Add Questions with Options and their Correct Option:
        addQuestion(" How many zeros are there in one hundred thousand?");
        addOptions("Four","Five","Six","Hundred");
        addAnswerIndex(2);

        //12. Add Questions with Options and their Correct Option:
        addQuestion("How many months of the year have 31 days?");
        addOptions("6","7","8","9");
        addAnswerIndex(2);

        //13. Add Questions with Options and their Correct Option:
        addQuestion(" How many hours are there in two days?");
        addOptions("24","36","48","60");
        addAnswerIndex(3);

        //14. Add Questions with Options and their Correct Option:
        addQuestion("Which is the principal source of energy for earth?");
        addOptions("Sun","Moon","Mars","Jupiter");
        addAnswerIndex(1);


        //15. Add Questions with Options and their Correct Option:
        addQuestion("Which is the fastest animal on the land?");
        addOptions("Rat","Horse","Cat","Cheetah");
        addAnswerIndex(4);


        //16. Add Questions with Options and their Correct Option:
        addQuestion(" Which is the largest ocean in the world?");
        addOptions("Pacific Ocean","American Ocean","Bay of Bengal","Indian Ocean");
        addAnswerIndex(4);

        //17. Add Questions with Options and their Correct Option:
        addQuestion("How many years are there in a century?");
        addOptions("1000","10000","100","100000");
        addAnswerIndex(3);

        //18. Add Questions with Options and their Correct Option:
        addQuestion("What color symbolizes peace?");
        addOptions("Red","White","Yellow","Pink");
        addAnswerIndex(2);

        //19. Add Questions with Options and their Correct Option:
        addQuestion("What is 0*3+5-2");
        addOptions("3","2","5","0");
        addAnswerIndex(1);

        //20. Add Questions with Options and their Correct Option:
        addQuestion("What is 100*(5-2)*0");
        addOptions("100","5","3","0");
        addAnswerIndex(4);

//
//        //21. Add Questions with Options and their Correct Option:
//        addQuestion("");
//        addOptions("A","B","C","D");
//        addAnswerIndex(1);


    }

    Quiz_Set(){
        initialiseQuizSet();

    }

    Vector<String> questionSet= new Vector<String>();
    Vector<Vector<String>> optionsSet=new Vector<Vector<String>>();
    Vector<Integer> answersIndexSet=new Vector<Integer>();
    Vector<Integer> moneySet=new Vector<Integer>();

}
