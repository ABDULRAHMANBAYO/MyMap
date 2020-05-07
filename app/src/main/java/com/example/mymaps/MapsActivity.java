package com.example.mymaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LatLng mountEverest = new LatLng(27.990203, 86.925232);
    private LatLng olumoRock = new LatLng(7.230583, 3.438459);
//    private  LatLng mountEverest= new LatLng(27.990203, 86.925232);

    private Marker everest;
    private Marker olumo;

    private MarkerOptions everestOptions;
    private  MarkerOptions olumoOptions;

    private ArrayList<Marker> markers;
    private ArrayList<MarkerOptions>markerOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
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
//        mMap.setMapType(GoogleMap.MAP_TYPE_NONE);

        markers = new ArrayList<>();
        markerOptions = new ArrayList<>();

        everestOptions = new MarkerOptions()
                .position(mountEverest)
                .title("Mount Evrest")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        markers.add(everest);
        markerOptions.add(everestOptions);

        olumoOptions = new MarkerOptions()
                .position(olumoRock)
                .title("Olumo rock")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        markers.add(olumo);
        markerOptions.add(olumoOptions);

//        LatLng binga = new LatLng(-19.7766658, 33.0444344);
//        markers.add(everest);

        for (MarkerOptions m:markerOptions)
        {
            LatLng latLng = new LatLng(m.getPosition().latitude,m.getPosition().longitude);
            mMap.addMarker(m);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng,4));
        }
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

//        mMap.addMarker(new MarkerOptions().position(binga).title("Mount binga")
//                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA)));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(markers.get));
    }
}
