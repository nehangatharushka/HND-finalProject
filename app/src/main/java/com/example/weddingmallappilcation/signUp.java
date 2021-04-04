package com.example.weddingmallappilcation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class signUp extends AppCompatActivity {



    EditText uname,fname,lname,email,password;
    TextView login;
    Button register,btnHaveAcc;
    FirebaseAuth auth;
    DatabaseReference reference;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        email=findViewById(R.id.txtemail);
        password=findViewById(R.id.txtpassword);
        fname=findViewById(R.id.txtfname);
        lname=findViewById(R.id.txtlname);
        uname=findViewById(R.id.edtuname);


        btnHaveAcc=(Button)findViewById(R.id.btnHaveAcc);


        btnHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClick();
            }
        });

        register=findViewById(R.id.btnSignUp);

        auth=FirebaseAuth.getInstance();

       register.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               pd=new ProgressDialog(signUp.this);
               pd.setMessage("Please wait......");
               pd.show();

               String username=uname.getText().toString();
               String frname=fname.getText().toString();
               String lsname=lname.getText().toString();
               String emailaddress=email.getText().toString();
               String pw=password.getText().toString();

               if (TextUtils.isEmpty(username) || TextUtils.isEmpty(frname)  || TextUtils.isEmpty(lsname) || TextUtils.isEmpty(emailaddress) || TextUtils.isEmpty(pw))
               {
                   Toast.makeText(signUp.this, "All field are required...", Toast.LENGTH_SHORT).show();
               }else if (pw.length() < 6){
                   Toast.makeText(signUp.this, "Pw must have 6 characters...", Toast.LENGTH_SHORT).show();
               }else {
                   register(username,frname,lsname,emailaddress,pw);


               }

           }
       });

    }

    private void register(final String username, final String fname, final String lname, String emailaddress, String pw){
        auth.createUserWithEmailAndPassword(emailaddress,pw)
                .addOnCompleteListener(signUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser firebaseUser=auth.getCurrentUser();
                            String userid=firebaseUser.getUid();
                            reference= FirebaseDatabase.getInstance().getReference().child("Users").child(userid);

                            HashMap<String, Object> hashMap=new HashMap<>();
                            hashMap.put("id", userid);
                            hashMap.put("username", username.toLowerCase());
                            hashMap.put("firstname", fname);
                            hashMap.put("lastname", lname);
                            hashMap.put("bio", "");
                            hashMap.put("imageUrl", "gs://wedding-mall-application.appspot.com/user-avatar-png-images-vector-and-psd-files-free-download-on-male-png-360_360.png");

                            reference.setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        pd.dismiss();
                                        Intent intent=new Intent(signUp.this,login.class);
                                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                    }
                                }
                            });

                        }else {
                            pd.dismiss();
                            Toast.makeText(signUp.this, "You can't register", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }







   private void afterClickSignUp() {
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }

    private void afterClick() {
        Intent intent = new Intent(this,login.class);
        startActivity(intent);
    }
}