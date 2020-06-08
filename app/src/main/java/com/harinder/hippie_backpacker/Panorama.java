package com.harinder.hippie_backpacker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;

public class Panorama extends AppCompatActivity implements OnStreetViewPanoramaReadyCallback {

    private StreetViewPanoramaFragment streetViewPanoramaFragment;
    double latitude;
    double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panorama);

        //Setting up Title in action bar
        getSupportActionBar().setTitle("Panorama View");

        //Getting LatLng values of the location selected by User in previous activity
        Bundle extras = getIntent().getExtras();

        Log.e("Value of latlng", extras.getString("LatLngString"));

        //Converting String of Latlng to 2 double values
        String[] latlong =  extras.getString("LatLngString").split(",");
        latitude = Double.parseDouble(latlong[0]);
        longitude = Double.parseDouble(latlong[1]);

        streetViewPanoramaFragment = (StreetViewPanoramaFragment) getFragmentManager()
                .findFragmentById(R.id.googleMapStreetView);
        //calling the getStreetViewPanoramaAsync task to put panorama view in the layout
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);

    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        //setting up position in by passing right Latitude and Longitude value
        streetViewPanorama.setPosition(new LatLng(latitude,longitude));
    }
}
