package com.droidsetter.randomquiz;

import java.util.*;

public class Quiz_Set {
    String[] questionSet;
    String[][] optionsSet;
    int[] answersSet;
    Vector<Integer> money;
//    long[] moneySet;

    Quiz_Set(){
        questionSet= new String[]
                {
                        "How many days do we have in a week?",
                        "Which animal is known as the ‘Ship of the Desert?",
                        "How many letters are there in the English alphabet?",
                        "NAME THE VEGETABLE WHICH IS ALSO KNOWN AS FLOWER?",
                        "WHICH PLANET HAS THE 'GREAT RED SPOT'?",
                        "In which direction does the sun rise?",
                        "What was the Venue Of olympic 2014?",
                        "Credits Cards Are also known as?",
                        "Mostly which gases are found in the planet JUPITER?",
                        "Worlds first hydrogen powered train was launched in which country?",
                        "OxfordDictionaries.com launched in which year?",
                        "who was the founder of brahmo samaj?",
                        "Ruler of Mysor was?",
                        "what is the national reptile of india?",
                        "What is the rank of indian passport at the 20 henley passport index?",
                        "Which of the following corresponds to ‘ek bataa do’",
                        "Harry Potter ends up marrying?",
                        "Which of these is a operating system?",
                        "Bahubali festival is related to?",
                        "What was BLACKPINK’s debut album called?",
                        "BLACKPINK collaborated with Lady Gaga on which track?",
                        "What is the largest big cat?","What is the largest animal on Earth?"
                };

        optionsSet=new String[][]
                {
                        { "Eight","Seven","Three","Five"},
                        {"Dog","Fish","Lion","Camel"},
                        { "25","28","26","21"},
                        { "1.CAULIFLOWER","2.BROCCOLI","3.CABBAGES","4.JALAPENOS"},
                        { "1.JUPITER","2.MERCURY","3.NEPTUNE","4.SATURN"},
                        { "East","West","North","South"},
                        { "1.ATHENS","2.BEIJING","3.INDIA","4.LONDON"},
                        { "1.TRANSACTIONAL MONEY","2.PLASTIC NOTES","3.PLASTIC MONEY","4.EASY MONEY"},
                        { "1.HYDROGEN AND NEON","2.NEON AND HELIUM","3.HELIUM AND ARAGON","4.HYDROGEN AND HELIUM"},
                        { "1.JAPAN","2.GERMANY","3.IRAQ","4.AMERICA"},
                        { "1.1997","2.1992","3.1993","4.1995"},
                        { "1.Raja Ram Mohan Roy","2.Swami Vivekananda","3.Dayand Saraswati","4.Kabir Das"},
                        { "1.Hyder Ali","2.Muhammad Ghori","3.Yaduraya Wodlysr","4.Sunni Islam"},
                        { "1.Anaconda","2.King Cobra","3.Snail","4.Turtle"},
                        { "1.55th","2.86th","3.4th","4.77th"},
                        {"Pura","Sawa","Adha","Pauna"} ,
                        {"hermione","Ron","Gennie","Snape"},
                        {"Doors","Portico","Gates","Windows"},
                        {"Islam","Hinduism","Buddhism","Jainism"},
                        {"Boombayah","Kill This Love","Blackpink In Your Area"," Forever Young"},
                        {"Sour Candy","Love Me Right","Babylon","1000 Doves" },
                        {"Lion", "Tiger", "Cheetah","Leopard"},
                        {"The African elephant","The blue whale", "The sperm whale"," The giant squid"
                        }
                };

        answersSet=new int[]
                {2,4,3,2,1,1,1,3,4,2,2,1,1,2,2,3,3,4,4,1,1,2,2};
//        moneySet=new long[]{1000,2000,3000,5000,10000,20000,40000,80000,160000,320000,640000,1250000,2500000,5000000,10000000};
        money=new Vector<Integer>();
        money.add(100);
        money.add(250);
        money.add(450);
        money.add(700);
        money.add(850);
        money.add(900);
        money.add(1050);
        money.add(1250);
        money.add(1500);
        money.add(2000);
        money.add(2500);
        money.add(3000);
        money.add(4000);
        money.add(6000);
        money.add(10000);
    }
}
