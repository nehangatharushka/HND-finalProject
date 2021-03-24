package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

//    Button postAdd , add2;
    ImageView newsfeed ,sponsor ,accInfo ,category_1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

//        postAdd=findViewById(R.id.postAddBtn);
        newsfeed=findViewById(R.id.imgnewsfeed);
        sponsor=findViewById(R.id.imgSponsered);
//        chat=findViewById(R.id.imgChat);
        accInfo=findViewById(R.id.imgAccinfo);
        category_1=findViewById(R.id.imgviewCamera);

//        postAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickplusbtn();
//            }
//        });
//
        newsfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickNewsFeed();
            }
        });
//
        sponsor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicksponserFeed();
            }
        });

        category_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCategoryOne();
            }
        });
//        chat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clickChat();
//            }
//        });
//
        accInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAccInfo();
            }
        });
//
//
//        add2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                click();
//            }
//        });

    }

    private void clickCategoryOne() {
        Intent intent = new Intent(this,afterClickCategory.class);
        startActivity(intent);
    }

    private void clickAccInfo() {
        Intent intent = new Intent(this,AccInfo.class);
        startActivity(intent);
    }

    private void clicksponserFeed() {
        Intent intent = new Intent(this,SponsorsHome.class);
        startActivity(intent);
    }

    private void clickNewsFeed() {
        Intent intent = new Intent(this,newsFeed.class);
        startActivity(intent);
    }

//    private void clickAccInfo() {
//        Intent intent = new Intent(this,SponsorsHome.class);
//        startActivity(intent);
//    }
//
//    private void clickChat() {
//        Intent intent = new Intent(this,SponsorsHome.class);
//        startActivity(intent);
//    }
//
//    private void clicksponserFeed() {
//        Intent intent = new Intent(this,SponsorsHome.class);
//        startActivity(intent);
//    }
//
//    private void clickNewsFeed() {
//        Intent intent = new Intent(this,newsFeed.class);
//        startActivity(intent);
//    }
//
//    private void click() {
//        Intent intent = new Intent(this,ProfileActivity.class);
//        startActivity(intent);
//    }
//
//    private void clickplusbtn() {
//        Intent intent = new Intent(this,newsFeed.class);
//        startActivity(intent);
//    }
}