package com.example.collegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

public class FullImageView extends AppCompatActivity {
    private ImageView imageView;

//    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image_view);

        imageView = findViewById(R.id.imageView);

        String image = getIntent().getStringExtra("image");

        Picasso.get().load(image).into(imageView);



    }
}