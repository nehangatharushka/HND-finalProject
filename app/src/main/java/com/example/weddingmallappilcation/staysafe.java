package com.example.weddingmallappilcation;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class staysafe extends AppCompatActivity {

    private ImageButton back;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staysafe);

        back=(ImageButton) findViewById(R.id.backbtnhelp);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(staysafe.this,account.class);
                startActivity(intent);
            }
        });

    }
}