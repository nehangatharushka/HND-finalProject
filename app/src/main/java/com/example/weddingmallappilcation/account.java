package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class account extends AppCompatActivity {

    private Button profile,myads,help,aboutus,staysafe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        profile=(Button)findViewById(R.id.btnprofiles);
        myads=(Button)findViewById(R.id.myAds);
        help=(Button)findViewById(R.id.btnhelp);
        aboutus=(Button)findViewById(R.id.btnaboutUs);
        staysafe=(Button)findViewById(R.id.btnstaySafe);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(account.this,accountInfo.class);
                startActivity(intent);
            }
        });

        myads.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(account.this,myAds.class);
                startActivity(intent);
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(account.this,help.class);
                startActivity(intent);
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(account.this,aboutUs.class);
                startActivity(intent);
            }
        });

        staysafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(account.this,staysafe.class);
                startActivity(intent);
            }
        });


    }
}