package com.example.nexer.solidermanagementapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class first_activity extends AppCompatActivity {

    private Button button;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_activity);

        DatabaseHelperClass myDB = new DatabaseHelperClass(this);

        button = (Button) findViewById(R.id.LoginButton);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNavigation();
            }
        });
    };

    public void openNavigation(){
        Intent intent = new Intent(this, navigation_activity.class);
                startActivity(intent);
    };
}
