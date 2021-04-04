package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weddingmallappilcation.Model.Products;
import com.example.weddingmallappilcation.ViewHolder.ProductViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class myAds extends AppCompatActivity {

    Button plusbtn;
    private RecyclerView mAdslist;
    private DatabaseReference mDatabase;
    FirebaseAuth auth;
    FirebaseUser user;
    private DatabaseReference ProdRef;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ads);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
//        mDatabase = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid()).child("Advertistment");
//        mDatabase.keepSynced(true);

        mAdslist = (RecyclerView) findViewById(R.id.myrecycleview);
        mAdslist.setHasFixedSize(true);
        mAdslist.setLayoutManager(new LinearLayoutManager(this));


        ProdRef= FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid()).child("Advertistment");

        recyclerView=findViewById(R.id.myrecycleview);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        plusbtn = (Button) findViewById(R.id.ad_adver);

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(myAds.this, SponsorsUploadPost.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Products> options = new FirebaseRecyclerOptions.Builder<Products>()
                .setQuery(ProdRef, Products.class).build();

        FirebaseRecyclerAdapter<Products, ProductViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductViewHolder productViewHolder, int i, @NonNull Products products) {
                        productViewHolder.txtProductTitle.setText(products.getTitle());
                        Picasso.get().load(products.getImageUrl()).into(productViewHolder.imageView);
                    }

                    @NonNull
                    @Override
                    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_items_layout, parent, false);
                        ProductViewHolder holder = new ProductViewHolder(view);
                        return holder;

                    }
                };
        recyclerView.setAdapter(adapter);
        adapter.startListening();
    }
}
