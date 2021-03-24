package com.example.weddingmallappilcation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;

public class SponsorsHome extends AppCompatActivity {

    EditText inputSearch;
    RecyclerView recyclerView;
    FloatingActionButton floatingbtn;
//    FirebaseRecyclerOptions<Car> options;
//    FirebaseRecyclerAdapter<Car,MyViewHolder>adapter;
    DatabaseReference Dataref;
    private Object bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors_home);


//        Dataref= FirebaseDatabase.getInstance().getReference().child("Car");
//        inputSearch=findViewById(R.id.inputSearch);
//        recyclerView=findViewById(R.id.recylerView);
        floatingbtn=findViewById(R.id.floatingbtn);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        recyclerView.setHasFixedSize(true);
        floatingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SponsorsUploadPost.class));
            }
        });
//
//        LoadData("");
//
//        inputSearch.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                if (s.toString()!=null)
//                {
//                    LoadData(s.toString());
//                }
//                else
//                {
//                    LoadData("");
//                }
//
//            }
//        });
    }

//    private void LoadData(String data) {
//        Query query=Dataref.orderByChild("CarName").startAt(data).endAt(data+"\uf8ff");
//
//        options=new FirebaseRecyclerOptions.Builder<Car>().setQuery(query,Car.class).build();
//        adapter=new FirebaseRecyclerAdapter<Car, MyViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull MyViewHolder holder, final int position, @NonNull Car model) {
//                holder.textView.setText(model.getCarName());
//                Picasso.get().load(model.getImageUrl()).into(holder.imageView);
//
//
//            }
//
//            @NonNull
//            @Override
//            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//                View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.single_view,parent,false);
//                return new MyViewHolder(v);
//            }
//        };
//        adapter.startListening();
//        recyclerView.setAdapter(adapter);
//
//    }



}