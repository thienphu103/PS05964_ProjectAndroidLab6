package com.example.a.lab6.Lab6;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a.lab6.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Read_Write_File extends Activity implements OnClickListener {

    Button btnread, btnwrite;
    EditText editdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_file);
        btnread = (Button) findViewById(R.id.btnreaddata);
        btnwrite = (Button) findViewById(R.id.btnwritedata);
        editdata = (EditText) findViewById(R.id.editdata);
        btnread.setOnClickListener(this);
        btnwrite.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v.getId() == R.id.btnreaddata) {
            readData();
        } else if (v.getId() == R.id.btnwritedata) {
            writeData();
        }
    }

    public void readData() {
        try {
            FileInputStream in = openFileInput("myfile.txt");
            BufferedReader reader = new
                    BufferedReader(new InputStreamReader(in));
            String data = "";
            StringBuilder builder = new StringBuilder();
            while ((data = reader.readLine()) != null) {
                builder.append(data);
                builder.append("\n");
            }
            in.close();
            editdata.setText(builder.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeData() {
        try {
            FileOutputStream out =
                    openFileOutput("myfile.txt", 0);
            OutputStreamWriter writer =
                    new OutputStreamWriter(out);
            writer.write(editdata.getText().toString());
            Toast.makeText(getApplicationContext(),"Saving...",Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),"Saving OK",Toast.LENGTH_LONG).show();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}