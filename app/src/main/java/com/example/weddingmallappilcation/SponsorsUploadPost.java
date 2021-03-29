package com.example.weddingmallappilcation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SponsorsUploadPost extends AppCompatActivity {

    private Spinner category;
    private TextView catetext;
    private static final int REQUEST_CODE_IMAGE = 101;
    private ImageView imageViewAdd;
    private EditText inputImageName, description;
    private TextView textViewProgress;
    private ProgressBar progressBar;
    private Button btnUpload;
    private String categoryselect;
    FirebaseAuth auth;
    FirebaseUser user;
    Uri imageUri;
    boolean isImageAdded = false;

    DatabaseReference Dataref;
    StorageReference StorageRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors_upload_post);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        imageViewAdd = findViewById(R.id.imageVIewAdd);
        inputImageName = findViewById(R.id.inputImageName);
        description = findViewById(R.id.des);
        textViewProgress = findViewById(R.id.textViewProgress);
        progressBar = findViewById(R.id.progressBar);
        btnUpload = findViewById(R.id.btnUpload);

        //spiner
        category = (Spinner) findViewById(R.id.category);
        catetext = (TextView) findViewById(R.id.txtCategory);

        List<String> categorylist = new ArrayList<>();
        categorylist.add("- Choose Category -");
        categorylist.add("Photography");
        categorylist.add("Hotels");
        categorylist.add("Catering");
        categorylist.add("Dj");
        categorylist.add("Car Rent");
        categorylist.add("Band");

        final ArrayAdapter<String> categoryAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categorylist);
        categoryAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        category.setAdapter(categoryAdapter);

        category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                  categoryselect = category.getSelectedItem().toString();
                if (!categoryselect.equals("- Choose Category -")) {
                    catetext.setText("You Choose " + categoryselect);
                } else {
                    catetext.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        textViewProgress.setVisibility(View.GONE);
        progressBar.setVisibility(View.GONE);

        Dataref = FirebaseDatabase.getInstance().getReference().child("Users").child(user.getUid()).child("Advertistment");
        StorageRef = FirebaseStorage.getInstance().getReference().child("Advertistment");


        imageViewAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, REQUEST_CODE_IMAGE);
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String imageName = inputImageName.getText().toString();
                final String descrip = description.getText().toString();
                final String category = categoryselect.toString();
                if (isImageAdded != false && imageName != null) {
                    uploadImage(imageName,descrip,category);
//                    uploadImage(descrip);
//                    uploadImage(category);
                }
            }
        });

    }

    private void uploadImage(final String imageName, final String descrip,final String category) {
        textViewProgress.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);

        final String key = Dataref.push().getKey();
        StorageRef.child(key + ".jpg").putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                StorageRef.child(key + ".jpg").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("title", imageName);
                        hashMap.put("Description", descrip);
                        hashMap.put("Category", category);
                        hashMap.put("ImageUrl", uri.toString());

                        Dataref.child(key).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                startActivity(new Intent(getApplicationContext(), myAds.class));
                                //Toast.makeText(MainActivity.this, "Data Successfully Uploaded!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                });

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (taskSnapshot.getBytesTransferred() * 100) / taskSnapshot.getTotalByteCount();
                progressBar.setProgress((int) progress);
                textViewProgress.setText(progress + " %");
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_IMAGE && data != null) {
            imageUri = data.getData();
            isImageAdded = true;
            imageViewAdd.setImageURI(imageUri);
        }
    }
}