package com.example.collegeapp.ui.about;

import android.hardware.lights.LightState;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.collegeapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter branchAdapter;
    private List<BranchModel> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_computer,"Computer Science","At present intake sheet in I-year is 30 student, and in lateral entry is 6."));
        list.add(new BranchModel(R.drawable.ic_mechanical,"Mechanical","At present intake sheet in I-year is 30 student, and in lateral entry is 6."));
        list.add(new BranchModel(R.drawable.ic_agriculture,"Agriculture","At present intake sheet in I-year is 30 student, and in lateral entry is 6."));
        list.add(new BranchModel(R.drawable.ic_civil,"Civil","At present intake sheet in I-year is 30 student, and in lateral entry is 6."));
        list.add(new BranchModel(R.drawable.ic_electrical,"Electrical & Electronics","At present intake sheet in I-year is 30 student, and in lateral entry is 6."));

        branchAdapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(branchAdapter);

        ImageView imageView = view.findViewById(R.id.college_image);


        return view;
    }
}