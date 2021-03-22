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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {

    private Button signIn , createAcc;
    private EditText editTextEmail,editTextPassword;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail=(EditText)findViewById(R.id.textemail);
        editTextPassword=(EditText)findViewById(R.id.textpw);

        signIn=(Button)findViewById(R.id.btnLogin);
        createAcc=(Button)findViewById(R.id.btncreateAcc);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               userLogin();
            }
        });
        mAuth=FirebaseAuth.getInstance();

        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClickCreateAccount();
            }
        });


    }

    private void userLogin(){
        String email=editTextEmail.getText().toString().trim();
        String password=editTextPassword.getText().toString().trim();

        if (email.isEmpty()){
            editTextEmail.setError("Email is Required");
            editTextEmail.requestFocus();
            return;
        }
        /*if (Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextEmail.setError("Please enter valid email");
            editTextEmail.requestFocus();
            return;
        }*/
        if (password.isEmpty()){
            editTextPassword.setError("Password is Required");
            editTextPassword.requestFocus();
            return;
        }
        if (password.length() <6){
            editTextPassword.setError("Password should be minimun 6 characters");
            editTextPassword.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
                    if (user.isEmailVerified()){
                        startActivity(new Intent(login.this,ProfileActivity.class));
                    }else{
                        user.sendEmailVerification();
                        Toast.makeText(login.this, "Check your email to verify you7r account", Toast.LENGTH_SHORT).show();
                    }



                }else{
                    Toast.makeText(login.this, "Failed to Login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void afterClickCreateAccount() {
        Intent intent = new Intent(this,signUp.class);
        startActivity(intent);
    }



    }