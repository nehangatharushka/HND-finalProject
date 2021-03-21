package com.example.weddingmallappilcation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signUp extends AppCompatActivity {

    private Button btnHaveAcc , signUp ;

    private EditText txtemail,txtpassword;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txtemail=findViewById(R.id.txtemail);
        txtpassword=findViewById(R.id.txtpassword);


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