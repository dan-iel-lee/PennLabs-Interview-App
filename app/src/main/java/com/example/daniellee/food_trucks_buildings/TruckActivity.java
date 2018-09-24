package com.example.daniellee.food_trucks_buildings;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class TruckActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    // object holding truck data
    Truck mTruck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_truck);

        // get data for this Truck from intent
        Intent intent = getIntent();
        mTruck = (Truck) intent.getSerializableExtra(FoodAdapter.TRUCK_MESSAGE);

        // initialize views
        TextView nameView = findViewById(R.id.name_view);
        TextView streetLocationView = findViewById(R.id.location_view);
        TextView typeView = findViewById(R.id.type_view);
        TextView phoneView = findViewById(R.id.phone_view);
        RatingBar ratingBar = findViewById(R.id.rating_bar);

        // put data in views
        nameView.setText(mTruck.getName());
        streetLocationView.setText(mTruck.getStreets());
        typeView.setText(mTruck.getType());
        if (mTruck.getPhone() != null) {
            phoneView.setText(mTruck.getPhone());
        } else {
            // there's no phone number provided, so get rid of the text view
            phoneView.setVisibility(View.GONE);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in at this truck and move camera
        double[] coordinates = mTruck.getCoordinates();
        LatLng latLng = new LatLng(coordinates[0], coordinates[1]);
        mMap.addMarker(new MarkerOptions().position(latLng).title(mTruck.getName()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        // set zoom level
        mMap.setMinZoomPreference(16);
    }
}
