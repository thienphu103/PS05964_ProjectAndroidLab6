package com.example.a.lab6.Game_Ramdom_Number;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.lab6.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Game_Ramdom_Math extends AppCompatActivity {
    private TextView mScoreView;
    private TextView mNameView;
    private TextView mNumView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    int index = 0;
    int a = 0;
    int b = 0;
    int solve = 0;
    String question = "";
    public ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_millionaire);
        mNumView = (TextView) findViewById(R.id.num);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        mScoreView = (TextView) findViewById(R.id.score_text);
        mNameView = (TextView) findViewById(R.id.TextViewName);
        Question();
        updateQuestion();
        Intent intent = getIntent();
        mNameView.setText("Name: " + intent.getStringExtra("username"));
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Integer.parseInt(mButtonChoice1.getText().toString()) == solve) {
                    mScore = mScore + 1;
                    updateQuestion();
                    updateScore(mScore);
                    Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();
                    Question();

                } else {
                    Toast.makeText(getApplication(), "wrong", Toast.LENGTH_SHORT).show();
                    Lose();
                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (Integer.parseInt(mButtonChoice2.getText().toString()) == solve) {
                    mScore = mScore + 1;
                    updateQuestion();
                    updateScore(mScore);
                    Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();
                    Question();

                } else {
                    Toast.makeText(getApplication(), "wrong, You Can Score: " + mScore + "", Toast.LENGTH_SHORT).show();
                    Lose();
                }
            }
        });


        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(mButtonChoice3.getText().toString()) == solve) {
                    mScore = mScore + 1;
                    updateQuestion();
                    updateScore(mScore);
                    Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();
                    Question();
                } else {
                    Toast.makeText(getApplication(), "wrong, You Can Score: " + mScore + "", Toast.LENGTH_SHORT).show();
                    Lose();
                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Integer.parseInt(mButtonChoice4.getText().toString()) == solve) {
                    mScore = mScore + 1;
                    updateQuestion();
                    updateScore(mScore);
                    Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();
                    Question();
                } else {
                    Toast.makeText(getApplication(), "Wrong, You Can Score: " + mScore + "", Toast.LENGTH_SHORT).show();
                    Lose();
                }
            }
        });

    }

    public int Index() {
        int min = 0;
        int max = 1000;
        Random r = new Random();
        index = r.nextInt(max - min + 1) + min;
        return index;
    }

    public String Question() {
        list = new ArrayList<>();
        a = Index();
        b = Index();
        question = a + "+" + b + "= ?";
        solve = a + b;
        mQuestionView.setText(question);
        list.add(solve);
        list.add(Index());
        list.add(Index());
        list.add(Index());
        CheckRamdom(list.get(0).toString(), list.get(1).toString(), list.get(2).toString(), list.get(3).toString());
        mButtonChoice1.setText(list.get(0).toString());
        mButtonChoice2.setText(list.get(1).toString());
        mButtonChoice3.setText(list.get(2).toString());
        mButtonChoice4.setText(list.get(3).toString());
        return question;
    }
    private void updateQuestion() {
        mNumView.setText("Question: " + (1 + mQuestionNumber++));

        if((mQuestionNumber)>14){
            Intent intent=new Intent(getApplicationContext(),Win_Game.class);
            intent.putExtra("username",mNameView .getText().toString());
            intent.putExtra("score",mScoreView .getText().toString());
            startActivity(intent);
        }



    }

    public void CheckRamdom(String a, String b, String c, String d) {
        if (a.equals(b) || a.equals(c) || a.equals(d)) {
            Log.d("key", "Re");
            Question();
            Collections.shuffle(list);
        }

        if (b.equals(a) || b.equals(c) || b.equals(d)) {
            Log.d("key", "Re");
            Question();
            Collections.shuffle(list);
        }
        if (c.equals(a) || c.equals(b) || c.equals(d)) {
            Log.d("key", "Re");
            Question();
            Collections.shuffle(list);
        }
        if (d.equals(b) || d.equals(c) || d.equals(a)) {
            Log.d("key", "Re");
            Question();
            Collections.shuffle(list);
        }

    }
    public void Lose(){
        Intent intent=new Intent(Game_Ramdom_Math.this,Loser_Game.class);
        intent.putExtra("username", mNameView.getText().toString());
        intent.putExtra("score", mScoreView.getText().toString());
        startActivity(intent);
    }
    private void updateScore(int point) {

        mScoreView.setText("Score: " + mScore);

    }
}

