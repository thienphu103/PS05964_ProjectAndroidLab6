package com.example.a.lab6.Game_Millionaire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a.lab6.R;

public class Millionaire_Layout extends AppCompatActivity {
Button btn;
    EditText etxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_loading_game);
        btn=(Button) findViewById(R.id.btnLoginGame);
        etxt=(EditText) findViewById(R.id.txtUserGame);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Millionaire_Layout.this,MainActivityMillionaire.class);
                intent.putExtra("username", etxt.getText().toString());
                startActivity(intent);
            }
        });
    }
}
