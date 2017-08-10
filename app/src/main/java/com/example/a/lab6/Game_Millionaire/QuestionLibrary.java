package com.example.a.lab6.Game_Millionaire;


import java.util.ArrayList;
import java.util.Random;

public class QuestionLibrary {
int index=0;

    public int getIndex() {
        return index;
    }

    private ArrayList<String[]> listQuestion;

    public void setIndex(int index) {
        this.index = index;
    }

    private String mQuestions [] = {
            "2+2=",
            "3*5=",
            "8-4=",
            "10+12",
            "120*1",

            "900-1",
            "15/3",
            "1+2*3",
            "4+4*4",
            "1+2*3/6",

            "x+5=8,x=?",
            "5x-20=0,x=?",
            "120+x=200,x=?",
            "3x=15,x=?",
            "1+1=???",
            ""

    };

    private String mChoices [][] = {
            {"1", "5", "4","0"},
            {"7", "9", "15","8"},
            {"10", "4", "9","6"},
            {"10", "22", "9","6"},
            {"900", "355", "120","126"},
            ///
            {"0", "1000", "899","900"},
            {"5", "2", "9","1"},
            {"8", "7", "20","9"},
            {"8", "7", "20","9"},
            {"2", "3", "0","11"},
            ///
            {"8", "3", "9","13"},
            {"2", "4", "3","100"},
            {"60", "70", "80","10"},
            {"2", "3", "5","8"},
            {"22222", "222", "22","2"},
            {"","","",""}
    };

    private String mCorrectAnswers[] =
            {"4", "15", "4", "22","120",
                    ///
            "899","5","7","20","2",
                    ///
            "3","4","80","5","2",""};

public int Index(){
    int min = 0;
    int max = 14;
    Random r = new Random();
    index = r.nextInt(max - min + 1) + min;
    return index;
}
    public String getQuestion(int a) {
        String question= mQuestions[index];
        listQuestion = new ArrayList<>();
        return question;
    }

    public String getChoice1(int a) {

        String choice0 = mChoices[index][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[index][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[index][2];
        return choice2;
    }
    public String getChoice4(int a) {
        String choice3 = mChoices[index][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[index];
        return answer;
    }


}
