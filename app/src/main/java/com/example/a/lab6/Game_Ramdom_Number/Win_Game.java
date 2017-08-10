package com.example.a.lab6.Game_Ramdom_Number;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.a.lab6.R;

public class Win_Game extends AppCompatActivity {
TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation__game);
        txt=(TextView) findViewById(R.id.textViewWin);
        Intent intent = getIntent();
        txt.setText(intent.getStringExtra("username")+"&"+intent.getStringExtra("score"));
    }
}
