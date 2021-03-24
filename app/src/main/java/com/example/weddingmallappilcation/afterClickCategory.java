package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class afterClickCategory extends AppCompatActivity {

    ImageView cate1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_click_category);

        cate1=findViewById(R.id.imgbtn1);

        cate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCategoryOne();
            }
        });
    }

    private void clickCategoryOne() {
        Intent intent = new Intent(this,after_click_service.class);
        startActivity(intent);
    }
}