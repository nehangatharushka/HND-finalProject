package com.example.weddingmallappilcation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.weddingmallappilcation.Adapter.PostAdapter;
import com.example.weddingmallappilcation.Model.Post;

import java.util.ArrayList;
import java.util.List;

public class newsfeed extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PostAdapter postAdapter;
    private List<Post> postLists;

    private List<String> followingList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsfeed);


        //  checkFollowing();




    }

}