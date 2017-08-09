package com.example.a.lab6.Lab6;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.a.lab6.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivityReadFile extends AppCompatActivity {
Button btn;
    EditText editdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read_file);
        btn =(Button) findViewById(R.id.btnreaddata);
editdata =(EditText) findViewById(R.id.editdata) ;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                readData();
            }
        });
    }
    public void readData()
    {
        String data;
        InputStream in= getResources().openRawResource(R.raw.myfile);
        InputStreamReader inreader=new InputStreamReader(in);
        BufferedReader bufreader=new BufferedReader(inreader);
        StringBuilder builder=new StringBuilder();
        if(in!=null)
        {
            try
            {
                while((data=bufreader.readLine())!=null)
                {
                    builder.append(data);
                    builder.append("\n");
                }
                in.close();
                editdata.setText(builder.toString());
            }
            catch(IOException ex){
                Log.e("ERROR", ex.getMessage());
            }
        }
    }

}
