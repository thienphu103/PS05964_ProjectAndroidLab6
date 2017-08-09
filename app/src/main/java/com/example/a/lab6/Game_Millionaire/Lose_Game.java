package com.example.a.lab6.Game_Millionaire;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a.lab6.R;

public class Lose_Game extends AppCompatActivity {
ImageView imgv;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose__game);
        imgv=(ImageView) findViewById(R.id.imageViewLose);
        txt=(TextView) findViewById(R.id.textViewLose);
        Intent intent = getIntent();
        txt.setText(intent.getStringExtra("username")+"&"+intent.getStringExtra("score"));
        imgv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Lose_Game.this,Millionaire_Layout.class);
                startActivity(intent);
            }
        });

    }
}
