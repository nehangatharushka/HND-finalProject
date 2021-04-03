package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {


private ImageButton newsFeed,account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        newsFeed=(ImageButton) findViewById(R.id.btnNewsFeed);
        account=(ImageButton) findViewById(R.id.btnprofile);

        account.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(home.this,account.class);
                startActivity(intent);
            }
        });



    }



}
