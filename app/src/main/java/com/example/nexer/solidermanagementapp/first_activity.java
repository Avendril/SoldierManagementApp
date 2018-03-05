package com.example.nexer.solidermanagementapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.programmingknowledge.mysqldemo.R;

public class first_activity extends AppCompatActivity {

    private Button button;
    private EditText UsernameET, PasswordET;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);

        UsernameET = (EditText)findViewById(R.id.loginTextBox);
        PasswordET = (EditText)findViewById(R.id.passwordTextBox);
    }

    public void OnLogin(View view){
        String username = UsernameET.getText().toString();//Convert EditText to String so that sql can read it.
        String password = PasswordET.getText().toString();
        String type= "login";

        BackgroundWork backgroundWorker = new BackgroundWork(this); //Use a Background java class to do all the login shit.
        backgroundWorker.execute(type, username, password);
    }
}
