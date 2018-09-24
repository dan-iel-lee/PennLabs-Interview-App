package com.example.daniellee.food_trucks_buildings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    // newInstance, no need for arguments
    public static FoodFragment newInstance() {
        FoodFragment fragment = new FoodFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_food, container, false);
        RecyclerView recyclerView = (RecyclerView) view;

        // we're not adding or deleting any items, so do this to help speed
        recyclerView.setHasFixedSize(true);

        // set Layout Manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        // set adapter
        RecyclerView.Adapter adapter = new FoodAdapter(recyclerView, getContext());
        recyclerView.setAdapter(adapter);
        return view;
    }
}
