package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class signUp extends AppCompatActivity {

    private Button btnHaveAcc ,signUp ;

    private EditText txtemail,txtpassword,txtfname,txtlname,txtage;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtemail=findViewById(R.id.txtemail);
        txtpassword=findViewById(R.id.txtpassword);
        txtfname=findViewById(R.id.txtfname);
        txtlname=findViewById(R.id.txtlname);
        txtage=findViewById(R.id.txtage);


        btnHaveAcc=(Button)findViewById(R.id.btnHaveAcc);


        btnHaveAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClick();
            }
        });

        signUp=findViewById(R.id.btnSignUp);

        mAuth=FirebaseAuth.getInstance();

       signUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               registerUser();

           }
       });

    }

    private void registerUser(){
        final String email=txtemail.getText().toString().trim();
        final String password=txtpassword.getText().toString().trim();
        final String firstname=txtfname.getText().toString().trim();
        final String lastname=txtlname.getText().toString().trim();
        final String age=txtage.getText().toString().trim();

        if (firstname.isEmpty()){
            txtfname.setError("First Name is Required");
            txtfname.requestFocus();
            return;
        }
        if (lastname.isEmpty()){
            txtlname.setError("Last Name is Required");
            txtlname.requestFocus();
            return;
        }
        if (age.isEmpty()){
            txtage.setError("Age is Required");
            txtage.requestFocus();
            return;
        }
        if (email.isEmpty()){
            txtemail.setError("Email is Required");
            txtemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            txtemail.setError("Please provide valid email");
            txtemail.requestFocus();
            return;
        }
        if (password.isEmpty()){
            txtpassword.setError("Password is Required");
            txtpassword.requestFocus();
            return;
        }
        if (password.length() < 6){
            txtpassword.setError("Password lenght should be more than 6 characters");
            txtpassword.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            User user=new User(firstname,lastname,age,email,password);
                            FirebaseDatabase.getInstance().getReference("Users").child("User_Details").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(signUp.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(signUp.this, "Failed to register", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });



                        }else{
                            Toast.makeText(signUp.this, "Failed to register", Toast.LENGTH_SHORT).show();

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