package com.example.weddingmallappilcation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button getStart_btn , btnSignUp;

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getStart_btn=(Button)findViewById(R.id.getStart_btn);
        btnSignUp=(Button) findViewById(R.id.btnsinUp);

        getStart_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClick();
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClickSignUp();
            }
        });


    }

    private void afterClickSignUp() {
       Intent intent = new Intent(this,signUp.class);
        startActivity(intent);
    }

    public void afterClick()
    {
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
}