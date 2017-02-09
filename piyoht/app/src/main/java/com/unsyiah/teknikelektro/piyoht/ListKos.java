package com.unsyiah.teknikelektro.piyoht;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Muhammad Yussuf on 1/26/2017.
 */

public class ListKos extends AppCompatActivity implements OnMapReadyCallback {
    TextView lokasi1, lokasi2;
    GoogleMap gMaps;

    private GoogleApiClient client;
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.liskos);

        lokasi1 = (TextView)findViewById(R.id.lokasi1);
        lokasi2 = (TextView)findViewById(R.id.lokasi2);

// i.getExtras()/getString = Digunakan untuk menerima pesan yang dikirim saat pindah halaman.
        Intent i = getIntent();
        lokasi1.setText(i.getExtras().getString("PilihKota"));
        lokasi2.setText(i.getExtras().getString("PilihKecamatan"));

        TextView kostcari5=(TextView)findViewById(R.id.kostcari5);
        kostcari5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent a =new Intent(getApplicationContext(),ProfilKos.class);
               startActivity(a);



            }

        });


        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapslbs1);
        mapFragment.getMapAsync(this);
        try {
            initializeMaps();
            gMaps.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ROSE))
                    .position(new LatLng(5.570280, 95.373415))
                    .visible(true)
                    .title("test"));

            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            gMaps.setMyLocationEnabled(true);
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(5.570280, 95.373415)).zoom(12).build();


            gMaps.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), 100, null);


        } catch (Exception e) {

        }
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)

    private void initializeMaps() {
        if (gMaps == null) {
            gMaps = ((MapFragment) getFragmentManager().findFragmentById(R.id.mapslbs1)).getMap();

            if (gMaps == null) {
                Toast.makeText(getApplicationContext(), "Unable to create maps", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {

    }



    public void onClickgo(View v){
        Intent hasilIntent = new Intent(ListKos.this, MainActivity.class);
        startActivity(hasilIntent);

    }


}

