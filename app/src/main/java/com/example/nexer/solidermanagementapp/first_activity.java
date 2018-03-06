package com.example.nexer.solidermanagementapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.programmingknowledge.mysqldemo.R;

/*
References:
https://developer.android.com/guide/topics/ui/notifiers/toasts.html <- Message displayed

 */
public class first_activity extends AppCompatActivity {

    private Button button;
    private EditText UsernameET, PasswordET;


    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first_activity);

            UsernameET = (EditText) findViewById(R.id.loginTextBox);
            PasswordET = (EditText) findViewById(R.id.passwordTextBox);
        }catch(Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(),"This shit ain't working yo", Toast.LENGTH_SHORT);
        }
    }

    public void OnLogin(View view){
        String username = UsernameET.getText().toString();//Convert EditText to String so that sql can read it.
        String password = PasswordET.getText().toString();
        String type= "login";

        BackgroundWork backgroundWorker = new BackgroundWork(this); //Use a Background java class to do all the login shit.
        backgroundWorker.execute(type, username, password);
    }
}
