package com.example.collegeapp.ui.gallery;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.collegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView convRecycler,independenceRecycler,sportsRecycler,otherEventsRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

//    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);
        convRecycler = view.findViewById(R.id.convRecycler);
        independenceRecycler = view.findViewById(R.id.independenceRecycler);
        sportsRecycler = view.findViewById(R.id.sportsRecycler);
        otherEventsRecycler = view.findViewById(R.id.otherEventsRecycler);


        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");

        getConvoImage();
        getIndependenceImage();
        getAnnualImage();
        getOtherImage();

        return view;
    }

    private void getAnnualImage() {
        reference.child("Annual Sports").addValueEventListener(new ValueEventListener() {
            List<String> imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                sportsRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));

                sportsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {
            List<String> imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) dataSnapshot.getValue();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                otherEventsRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                otherEventsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getIndependenceImage() {
        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {
            List<String> imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data =snapshot.getValue().toString();
                    imageList.add(data);

                }
                adapter = new GalleryAdapter(getContext(), imageList);
                independenceRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                independenceRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void getConvoImage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {
            List<String> imageList =new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = snapshot.getValue().toString();
                    imageList.add(data);
                }
                adapter = new GalleryAdapter(getContext(), imageList);
                convRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                convRecycler.setHasFixedSize(true);
                convRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
}