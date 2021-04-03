package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class myAds extends AppCompatActivity {

    Button plusbtn;
    private RecyclerView mAdslist;
    private DatabaseReference mDatabase;
    FirebaseAuth auth;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ads);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid()).child("Advertistment");
        mDatabase.keepSynced(true);

        mAdslist=(RecyclerView)findViewById(R.id.myrecycleview);
        mAdslist.setHasFixedSize(true);
        mAdslist.setLayoutManager(new LinearLayoutManager(this));


        plusbtn=(Button)findViewById(R.id.ad_adver);

        plusbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(myAds.this,SponsorsUploadPost.class);
                startActivity(intent);
            }
        });


    }

    //@Override
  //  protected void onStart() {
//        super.onStart();
//        FirebaseRecyclerAdapter<ads,AdsViewHolder> firebaseRecylerAdapter=new FirebaseRecyclerAdapter<ads, AdsViewHolder>
//                (ads.class,R.layout.myads,AdsViewHolder.class,mDatabase) {
//            @Override
//            protected void populateViewHolder(AdsViewHolder adsViewHolder, ads ads, int i) {
//                adsViewHolder.setTitle(ads.getTitle());
//                adsViewHolder.setDes(ads.getTitle());
//                adsViewHolder.setImage(getApplicationContext(),ads.getImageUrl());
//            }
//        };
//        mAdslist.setAdapter(firebaseRecylerAdapter);
    }

//    public static class AdsViewHolder extends RecyclerView.ViewHolder {
//        View mView;
//        public AdsViewHolder(View itemview)
//        {
//            super(itemview);
//            mView=itemview;
//        }
//        public void setTitle(String title)
//        {
//            TextView post_title=(TextView)mView.findViewById(R.id.post_title);
//            post_title.setText(title);
//        }
//        public void setDes(String description)
//        {
//            TextView post_description=(TextView)mView.findViewById(R.id.post_des);
//            post_description.setText(description);
//        }
//        public void setImage(Context ctx ,String img)
//        {
//            ImageView post_image=(ImageView)mView.findViewById(R.id.post_image);
//        //    Picasso.with(ctx).load(img).into(post_image);
//
//        }
//    }
