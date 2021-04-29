package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.FragmentActivity;
import androidx.appcompat.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    ArrayList<LatLng>arrayList= new ArrayList<LatLng>();
    LatLng sydney = new LatLng(51.89901606483931, -8.475587836589327);
    LatLng Brisbane = new LatLng(53.351461538466346, -6.247102704955862);

    ArrayList<String> title = new ArrayList<String>();
  ArrayList<String> desc = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(sydney);
        arrayList.add(Brisbane);

        title.add("Cork");
        title.add("Dublin");

       desc.add("selling honey");
        desc.add("");

       // ActionBar actionBar = getSupportActionBar();
       // actionBar.setTitle("BeeApp");
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
    public void onMapReady(final GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(false);
        mMap.setMinZoomPreference(6.0f);
        mMap.setMaxZoomPreference(10.0f);

        for(int i = 0; i< arrayList.size();i++){
          //  for(int j = 0;j<title.size();j++){
                mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(title.get(i))));
           // mMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(desc.get(1))));
           // }
            mMap.moveCamera(CameraUpdateFactory.newLatLng(arrayList.get(i)));

        }
        boolean success = mMap.setMapStyle(new MapStyleOptions(getResources()
                .getString(R.string.style_json)));
        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markertitle = marker.getTitle();
                String markerdesc = "";

                Intent i = new Intent(MapsActivity.this,DetailsActivity.class);
                i.putExtra("title", markertitle);

              /*  if(markertitle.equals("Dublin")){
                    markerdesc = "Dublin Honey";
                } else if(markertitle.equals("Cork")){
                    markerdesc = "Cork Honey";
                }
                i.putExtra("desc", markerdesc);*/
                startActivity(i);
                return false;
            }
        });
    }
}