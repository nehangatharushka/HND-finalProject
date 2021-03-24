package com.example.weddingmallappilcation.Adapter;

import android.app.Activity;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weddingmallappilcation.Model.Post;
import com.example.weddingmallappilcation.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> mList;
    private Activity context;
    private FirebaseFirestore firestore;

    public PostAdapter(Activity context , List<Post> mList ){
        this.context = context;
        this.mList = mList;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.each_post , parent , false);
        firestore=FirebaseFirestore.getInstance();
        return new PostViewHolder(v) ;
    }

    @Override
    public void onBindViewHolder(@NonNull final PostAdapter.PostViewHolder holder, int position) {
        Post post=mList.get(position);
        holder.setPostPic(post.getImage());
        holder.setPostCaption(post.getCaption());

        long milliseconds=post.getTime().getTime();
//        String date= DateFormat.format("MM/dd/yyyy",new Date(milliseconds).toString();
//        String date = DateFormat.format("MM/dd/yyyy" , new Date(milliseconds)).toString();
            String date= DateFormat.format("MM/dd/yyyy",new Date(milliseconds)).toString();
        holder.setPostDate(date);

        String userId=post.getUser();
        firestore.collection("Users").document(userId).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    String username= task.getResult().getString("name");
                    String image= task.getResult().getString("image");

                    holder.setProfilePic(image);
                    holder.setPostUsername(username);

                }else {
                    Toast.makeText(context,task.getException().toString(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        ImageView postPic , commentsPic , likePic ;
      CircleImageView profilePic;
        TextView postUsername , postDate , postCaption , postLikes;
        View mView;
        public PostViewHolder(@NonNull View itemView){
            super(itemView);
            mView=itemView;
        }
        public void setPostPic(String urlPost){
            postPic=mView.findViewById(R.id.user_post);
            Glide.with(context).load(urlPost).into(postPic);
        }
        public void setProfilePic(String urlProfile)
        {
//            profilePic=mView.findViewById(R.id.profile_pic);
//            Glide.with(context).load().into(profilePic);
        }
        public void setPostUsername(String username)
        {
//            postUsername=mView.findViewById(R.id.username_tv);
//            postUsername.setText(username);
        }
        public void setPostDate(String date){
            postDate=mView.findViewById(R.id.date_tv);
            postDate.setText(date);
        }
        public void setPostCaption(String caption){
            postCaption=mView.findViewById(R.id.caption_tv);
            postCaption.setText(caption);
        }
    }

}
