package com.example.weddingmallappilcation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class login extends AppCompatActivity {

    private Button btnlogin , createAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnlogin=(Button)findViewById(R.id.btnLogin);
        createAcc=(Button)findViewById(R.id.btncreateAcc);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClick();
            }
        });

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClickCreateAccount();
            }
        });

    }

    private void afterClickCreateAccount() {
        Intent intent = new Intent(this,signUp.class);
        startActivity(intent);
    }

    public void afterClick()
    {
        Intent intent = new Intent(this,home.class);
        startActivity(intent);
    }

    }