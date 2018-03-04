package com.example.nexer.solidermanagementapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.nexer.solidermanagementapp.R.id.loginTextBox;
import static com.example.nexer.solidermanagementapp.R.id.passwordTextBox;

public class first_activity extends AppCompatActivity {

    SQLiteDatabase LoginDatabase = openOrCreateDatabase("LoginDatabase",MODE_PRIVATE,null);

    private Button button;

    private void createDatabase(){
        LoginDatabase.execSQL("CREATE TABLE IF NOT EXISTS Logins(Username VARCHAR,Password VARCHAR);");
        LoginDatabase.execSQL("INSERT INTO Logins VALUES('admin','admin');");
    }

    private boolean fetchData(String usernameInput, String passwordInput){
        Cursor resultSet;
        boolean testresult = true;
        resultSet = LoginDatabase.rawQuery("Select username from Logins where username = " + usernameInput + " and password = " + passwordInput + ";",null);
        resultSet.moveToFirst();
        String username = resultSet.getString(0);
        String password = resultSet.getString(1);
        if(username == null || username != usernameInput)
        {
            testresult = false;
        }else if(password == null || password != passwordInput){
            testresult = false;
        }
        else{
            return testresult;
        }

        return testresult;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);

        DatabaseHelperClass myDB = new DatabaseHelperClass(this);

        button = findViewById(R.id.LoginButton);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNavigation();
            }
        });
    }

    public void openNavigation(){
        EditText LoginInfo;
        EditText PasswordInfo;

        LoginInfo = (EditText)findViewById(loginTextBox);
        PasswordInfo = (EditText)findViewById(passwordTextBox);

        String userLogin = String.valueOf(LoginInfo);
        String userPass = String.valueOf(PasswordInfo);


        boolean results = fetchData(userLogin, userPass);

        if(results = true){
            Intent intent = new Intent(this, navigation_activity.class);
            startActivity(intent);
        }else{

        }
    }
}
