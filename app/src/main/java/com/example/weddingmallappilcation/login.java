package com.example.weddingmallappilcation;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class login extends AppCompatActivity {

    EditText email,password;
    Button login,createAcc;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.textemail);
        password=findViewById(R.id.textpw);
        login=findViewById(R.id.btnLogin);
        createAcc = (Button) findViewById(R.id.btncreateAcc);

        auth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog pd=new ProgressDialog(login.this);
                pd.setMessage("Please wait...");
                pd.show();

                String emailaddress=email.getText().toString();
                String pw=password.getText().toString();

                if (TextUtils.isEmpty(emailaddress) || TextUtils.isEmpty(pw)){
                    Toast.makeText(login.this, "All fields are required...", Toast.LENGTH_SHORT).show();
                }else {
                    auth.signInWithEmailAndPassword(emailaddress,pw)
                            .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("Users")
                                                .child(auth.getCurrentUser().getUid());

                                        reference.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                                pd.dismiss();
                                                Intent intent=new Intent(login.this,PostActivity.class);
                                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                startActivity(intent);
                                                finish();
                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError error) {
                                                pd.dismiss();

                                            }
                                        });
                                    }else {
                                        pd.dismiss();
                                        Toast.makeText(login.this, "AUTHENTICATION FAILED.....", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });


        createAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                afterClickCreateAccount();
            }
        });


    }



    private void afterClickCreateAccount() {
        Intent intent = new Intent(this, signUp.class);
        startActivity(intent);
    }


}