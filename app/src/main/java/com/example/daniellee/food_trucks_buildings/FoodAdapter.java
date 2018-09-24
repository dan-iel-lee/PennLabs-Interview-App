package com.example.daniellee.food_trucks_buildings;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {


    // key for intent message to TruckActivity
    public static final String TRUCK_MESSAGE = "com.example.daniellee.foock.TRUCK_MESSAGE";

    // context to use to start new activity
    Context context;

    // RecyclerView to get position in onClick
    RecyclerView mRecyclerView;

    // arrays with truck data
    private String[] names;
    private double[] ratings;
    private String[] streetLocations;
    private String[] types;
    private double[][] coordinates;
    private String[] phones;

    // listener for clicking an item
    private final ItemClickListener mClickListener;

    // ViewHolder that stores the layout for this list item
    public static class FoodViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout itemView;
        public FoodViewHolder(LinearLayout item) {
            super(item);
            itemView = item;
        }
    }

    // constructor
    public FoodAdapter(RecyclerView  rv, Context c) {
        // get data on the trucks
        names = TruckData.names;
        ratings = TruckData.ratings;
        streetLocations = TruckData.streetLocations;
        types = TruckData.types;
        coordinates = TruckData.coordinates;
        phones = TruckData.phones;

        // save recycler view to use later to get position of view in OnClick
        mRecyclerView = rv;

        // store context to use to start new activity
        context = c;

        // store instance of ItemClickListener
        mClickListener = new ItemClickListener();
    }

    @Override
    // create a viewholder with a new layout
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LinearLayout itemView = (LinearLayout) LayoutInflater.from
                (parent.getContext()).inflate(R.layout.food_list_item, parent, false);
        // set on click listener for item
        itemView.setOnClickListener(mClickListener);
        return new FoodViewHolder(itemView);
    }

    @Override
    // assign data to this viewholder
    public void onBindViewHolder(@NonNull FoodAdapter.FoodViewHolder holder, int position) {
        // get this layout from the ViewHolder
        LinearLayout item = holder.itemView;

        // get all the Views from the layout
        TextView nameView = item.findViewById(R.id.name_view);
        TextView locationView = item.findViewById(R.id.location_view);
        TextView typeView = item.findViewById(R.id.type_view);
        RatingBar ratingBar = item.findViewById(R.id.rating_bar);


        // set data for the views
        nameView.setText(names[position]);
        locationView.setText(streetLocations[position]);
        typeView.setText(types[position]);
        ratingBar.setRating((float)ratings[position]);
    }

    @Override
    public int getItemCount() {
        return names.length;
    }

    class ItemClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            TextView nameView = view.findViewById(R.id.name_view);
            int p = positionOfTruck(names, (String) nameView.getText());

            // make a Truck out of this data
            Truck truck = new Truck(names[p], ratings[p], streetLocations[p], types[p], coordinates[p], phones[p]);

            // start activity for truck details
            Intent intent = new Intent(context, TruckActivity.class);
            intent.putExtra(TRUCK_MESSAGE, truck);
            context.startActivity(intent);
        }
    }

    // get position of this truck in the list to pass to TruckActivity later
    private static int positionOfTruck(String[] names, String name) {
        for (int ii = 0; ii < names.length; ii++) {
            if (names[ii] == name) {
                return ii;
            }
        }
        return -1;
    }
}
