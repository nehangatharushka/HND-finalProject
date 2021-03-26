package com.example.weddingmallappilcation;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class home extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mframe;
    private HomeFragment homeFragment;
    private NewsFeedFragment newsFeedFragment;
    private AccountFragment accountFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mMainNav=findViewById(R.id.main_nav);
        mframe=findViewById(R.id.main_frame);

        homeFragment=new HomeFragment();
        newsFeedFragment=new NewsFeedFragment();
        accountFragment=new AccountFragment();

        setFragment(homeFragment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.home_nav:
                        mMainNav.setItemBackgroundResource(R.color.white);
                        setFragment(homeFragment);
                        return true;

                    case R.id.newsFeed_nav:
                    mMainNav.setItemBackgroundResource(R.color.white);
                        setFragment(newsFeedFragment);
                    return true;

                    case R.id.account_nav:
                    mMainNav.setItemBackgroundResource(R.color.white);
                        setFragment(accountFragment);
                    return true;

                    default:
                        return false;
                }
            }
        });

    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();


    }


}