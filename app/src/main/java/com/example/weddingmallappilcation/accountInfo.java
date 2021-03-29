package com.example.weddingmallappilcation;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class accountInfo extends AppCompatActivity {

    FirebaseAuth auth;
    FirebaseUser user;
    TextView email,fname,lname,tage,pw;
    DatabaseReference reference;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_info);
        auth = FirebaseAuth.getInstance();
        email = (TextView) findViewById(R.id.txtEmail);
        fname = (TextView) findViewById(R.id.txt_fname);
        lname = (TextView) findViewById(R.id.txtLname);
        tage = (TextView) findViewById(R.id.txtAge);
        pw = (TextView) findViewById(R.id.txtPassword);

        user = auth.getCurrentUser();

        email.setText(user.getEmail());
        reference = FirebaseDatabase.getInstance().getReference().child("Users").child("User_Details").child(user.getUid());

        btnEdit = (Button) findViewById(R.id.btnEdit);


        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String firstname=dataSnapshot.child("firstname").getValue().toString();
                String lastname=dataSnapshot.child("lastname").getValue().toString();
                String age=dataSnapshot.child("age").getValue().toString();
                String password=dataSnapshot.child("password").getValue().toString();

                fname.setText(firstname);
                lname.setText(lastname);
                tage.setText(age);
                pw.setText(password);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}