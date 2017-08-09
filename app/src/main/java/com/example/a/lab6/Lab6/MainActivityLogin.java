package com.example.a.lab6.Lab6;


import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.a.lab6.R;


public class MainActivityLogin extends AppCompatActivity {

    public EditText txt1;
    public EditText txt2;
    public Button btn1;
    public TextView txts1;
    public TextView txts2;
    public TextView txts3;
    public CheckBox checkbox;
    String filename = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);
        txt1 = (EditText) findViewById(R.id.txtUser);
        txt2 = (EditText) findViewById(R.id.txtPass);
        txts1 = (TextView) findViewById(R.id.txtTest1);
        txts2 = (TextView) findViewById(R.id.txtTest2);
        txts3 = (Button) findViewById(R.id.txtTest3);
        btn1 = (Button) findViewById(R.id.btnLogin);
        checkbox = (CheckBox) findViewById(R.id.checkInfo);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = txt1.getText().toString();
                String pass = txt2.getText().toString();
                if (text.equals("")) {
                    txt1.setError("Enter User. Please!!!");

                } else {
                    txts1.setText("User Ok");
                    txts1.setTextColor(Color.GREEN);
                }
                if (pass.equals("")) {
                    txt2.setError("Enter Password. Please!!!");

                }  else {
                    txts2.setText("Password Ok");
                    txts2.setTextColor(Color.GREEN);
                }
                if (!(text.equalsIgnoreCase("")) && (!(pass.equalsIgnoreCase("")))) {
                    Toast.makeText(MainActivityLogin.this, "Login Ok", Toast.LENGTH_LONG).show();
                    IntentNext(view);
                }

            }
        });
    }

    public void IntentNext(View view) {
        finish();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("username", txt1.getText().toString());
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        savingPre();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restoringPre();

    }

    private void restoringPre() {
        SharedPreferences sharedPreferences = getSharedPreferences(filename, MODE_PRIVATE);
        boolean check = sharedPreferences.getBoolean("savestatus", false);
        if (check) {
            String user = sharedPreferences.getString("username", "");
            String pass = sharedPreferences.getString("password", "");
            txt1.setText(user);
            txt2.setText(pass);

        }
        checkbox.setChecked(check);
    }

    private void savingPre() {
        SharedPreferences sharedPreferences = getSharedPreferences(filename, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String user = txt1.getText().toString();
        String pass = txt2.getText().toString();
        boolean check = checkbox.isChecked();
        if (!check) {
            editor.clear();

        } else {
            editor.putString("username", user);
            editor.putString("password", pass);
            editor.putBoolean("savestatus", check);
            Toast.makeText(getApplicationContext(),"Saving",Toast.LENGTH_SHORT).show();

        }
        editor.commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}


//    public void OnClick() {
//        txt1 = (EditText) findViewById(R.id.txtUser);
//        txt2 = (EditText) findViewById(R.id.txtPass);
//        txts1 = (TextView) findViewById(R.id.txtTest1);
//        txts2 = (TextView) findViewById(R.id.txtTest2);
//        txts3 = (Button) findViewById(R.id.txtTest3);
//        btn1 = (Button) findViewById(R.id.btnLogin);
//        txts3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivityLogin.this, MainActivityRegister.class);
//                startActivity(intent);
//            }
//        });
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String text = txt1.getText().toString();
//                String pass = txt2.getText().toString();
//                if (text.equals("")) {
//                    txt1.setError("Enter User. Please!!!");
//
//                } else if (!text.equalsIgnoreCase("admin")) {
//
//                    txt1.setError("User is invalid.");
//
//
//                } else {
//                    txts1.setText("User Ok");
//                    txts1.setTextColor(Color.GREEN);
//                }
//                if (pass.equals("")) {
//                    txt2.setError("Enter Password. Please!!!");
//
//                } else if (!pass.equalsIgnoreCase("123456")) {
//
//                    txt2.setError("Wrong Password.");
//
//
//                } else {
//                    txts2.setText("Password Ok");
//                    txts2.setTextColor(Color.GREEN);
//                }
//                if (text.equalsIgnoreCase("admin") && (pass.equalsIgnoreCase("123456"))) {
//                    Toast.makeText(MainActivityLogin.this, "Login Ok", Toast.LENGTH_LONG).show();
//                    Intent intent =new Intent(MainActivityLogin.this,MainActivity.class);
//                    startActivity(intent);
//                }else{
//
//                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivityLogin.this);
//
//                    alertDialogBuilder.setMessage("You want to log in as guest");
//                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface arg0, int arg1) {
//                            Intent intent =new Intent(MainActivityLogin.this,MainActivity.class);
//                            startActivity(intent);
//
//                        }
//                    });
//
//                    alertDialogBuilder.setNegativeButton("Try Again", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//
//                        }
//                    });
//
//                    AlertDialog alertDialog = alertDialogBuilder.create();
//                    alertDialog.show();
//                }
//
//            }
//
//        });
//        /**/
//
//    }

