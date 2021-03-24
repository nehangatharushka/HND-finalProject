package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class newsFeed extends AppCompatActivity {

    Button postAdd ;
//    private FirebaseAuth firebaseAuth;
//    private FirebaseFirestore firestore;
//    private RecyclerView mRecyclerView;
//    private FloatingActionButton fab;
//    private PostAdapter adapter;
//    private List<Post> list;
//    private Query query;
//    private ListenerRegistration listenerRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        postAdd=findViewById(R.id.postAddBtn);

        postAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickplusbtn();
            }
       });
//        firebaseAuth = firebaseAuth.getInstance();
//        firestore = FirebaseFirestore.getInstance();
//
////        mRecyclerView = findViewById(R.id.recyclerview);
//        mRecyclerView.setHasFixedSize(true);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(newsFeed.this));
//        list = new ArrayList<>();
//        adapter = new PostAdapter(newsFeed.this, list);
//        mRecyclerView.setAdapter(adapter);
//
////        fab = findViewById(R.id.fab_btn);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(newsFeed.this, ProfileActivity.class));
//            }
//        });
//
//        if (firebaseAuth.getCurrentUser() != null) {
//            mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//                @Override
//                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                    super.onScrolled(recyclerView, dx, dy);
//                    Boolean isBottom= !mRecyclerView.canScrollVertically(1);
//                    if(isBottom)
//                        Toast.makeText(newsFeed.this, "Reached Bottom", Toast.LENGTH_SHORT).show();
//                }
//            });
//            query = firestore.collection("Posts").orderBy("time", Query.Direction.DESCENDING);
//            listenerRegistration = query.addSnapshotListener(newsFeed.this, new EventListener<QuerySnapshot>() {
//                @Override
//                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
//                    for (DocumentChange doc : value.getDocumentChanges()) {
//                        if (doc.getType() == DocumentChange.Type.ADDED) {
//                            Post post = doc.getDocument().toObject(Post.class);
//                            list.add(post);
//                            adapter.notifyDataSetChanged();
//                        } else {
//                            adapter.notifyDataSetChanged();
//                        }
//                    }
//                    listenerRegistration.remove();
//                }
//            });
//
//        }
    }

    private void clickplusbtn() {
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}