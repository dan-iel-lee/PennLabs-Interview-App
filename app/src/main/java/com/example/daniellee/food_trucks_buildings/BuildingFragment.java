package com.example.daniellee.food_trucks_buildings;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BuildingFragment extends Fragment {

    public BuildingFragment() {
        // Required empty public constructor
    }

    public static BuildingFragment newInstance() {
        BuildingFragment fragment = new BuildingFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_building, container, false);
        // Implement actual stuff
        TextView tView = (TextView) view;
        tView.setText("I didn't have time to get to buildings, had a busy weekend :((((");
        return view;
    }
}
