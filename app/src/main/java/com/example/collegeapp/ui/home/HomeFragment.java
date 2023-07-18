package com.example.collegeapp.ui.home;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.collegeapp.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private ImageView map;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.slider);
        map = view.findViewById(R.id.map);


        ArrayList<SlideModel> arrayList = new ArrayList<>();

        arrayList.add(new SlideModel(R.drawable.silder1, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider3, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider2, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider4, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider5, ScaleTypes.FIT));
//        arrayList.add(new SlideModel(R.drawable.slider6, ScaleTypes.FIT));
        arrayList.add(new SlideModel(R.drawable.slider7, ScaleTypes.FIT));

        imageSlider.setImageList(arrayList, ScaleTypes.FIT);


        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opneMap();
            }
        });

        return view;
    }

    private void opneMap() {
        Uri uri = null;
        try {
            uri = Uri.parse("geo:0,0?q=MG Polytechnic Hathras");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//        intent.setPackage("com.google.android.app.maps");
        startActivity(intent);

    }

}