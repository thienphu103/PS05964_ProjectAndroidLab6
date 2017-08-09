package com.example.a.lab6.Game_Millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.lab6.R;

public class MainActivityMillionaire extends AppCompatActivity {

    private QuestionLibrary mQuestionLibrary = new QuestionLibrary();

    private TextView mScoreView;
    private TextView mNameView;
    private TextView mNumView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

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
        mScoreView =(TextView) findViewById(R.id.score_text);
        mNameView =(TextView) findViewById(R.id.TextViewName);
        Intent intent = getIntent();
        mNameView.setText("Name: " + intent.getStringExtra("username"));
        updateQuestion();
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mButtonChoice1.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplication(), "wrong", Toast.LENGTH_SHORT).show();
                    Lose();

                }
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mButtonChoice2.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplication(), "wrong, You Can Score: "+mScore+"", Toast.LENGTH_SHORT).show();
                    Lose();

                }
            }
        });


        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mButtonChoice3.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplication(), "wrong, You Can Score: "+mScore+"", Toast.LENGTH_SHORT).show();
                    Lose();

                }
            }
        });
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mButtonChoice4.getText() == mAnswer) {
                    mScore = mScore + 1;
                    updateScore(mScore);
                    updateQuestion();
                    Toast.makeText(getApplication(), "correct", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplication(), "Wrong, You Can Score: "+mScore+"", Toast.LENGTH_SHORT).show();
                    Lose();

                }
            }
        });


    }
    public void Lose(){
        Intent intent=new Intent(MainActivityMillionaire.this,Lose_Game.class);
        intent.putExtra("username", mNameView.getText().toString());
        intent.putExtra("score", mScoreView.getText().toString());
        startActivity(intent);
    }
    private void updateQuestion() {
        mQuestionLibrary.setIndex(mQuestionLibrary.Index());
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
        if((mQuestionNumber)>14){
            Intent intent=new Intent(MainActivityMillionaire.this,Congratulation_Game.class);
            intent.putExtra("username",mNameView .getText().toString());
            intent.putExtra("score",mScoreView .getText().toString());
            startActivity(intent);
        }
            mButtonChoice1.setText(mQuestionLibrary.getChoice1(mQuestionNumber));
            mButtonChoice2.setText(mQuestionLibrary.getChoice2(mQuestionNumber));
            mButtonChoice3.setText(mQuestionLibrary.getChoice3(mQuestionNumber));
            mButtonChoice4.setText(mQuestionLibrary.getChoice4(mQuestionNumber));
            mAnswer = mQuestionLibrary.getCorrectAnswer(mQuestionNumber);
            mNumView.setText("Question: " + (1 + mQuestionNumber++));

    }


    private void updateScore(int point) {

        mScoreView.setText("Score: " + mScore);

    }
}

