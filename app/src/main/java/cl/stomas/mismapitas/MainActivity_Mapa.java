package cl.stomas.mismapitas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity_Mapa extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {

    double lat1, lat2, lat3, lng1, lng2, lng3;
    GoogleMap mMap;
    FusedLocationProviderClient fusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mapa);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        lat1 = getIntent().getDoubleExtra("Latitud 1",0);
        lat2 = getIntent().getDoubleExtra("Latitud 2",0);
        lat3 = getIntent().getDoubleExtra("Latitud 3",0);

        lng1 = getIntent().getDoubleExtra("Longitud 1",0);
        lng2 = getIntent().getDoubleExtra("Longitud 2",0);
        lng3 = getIntent().getDoubleExtra("Longitud 3",0);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        if(lat2 != 0.0 && lng2 != 0.0){
            if(lat3 != 0.0 && lng3 != 0.0){
                LatLng direccion3 = new LatLng(lat3, lng3);
                googleMap.addMarker(new MarkerOptions().position(direccion3).title("Direccion 3"));
            }
            LatLng direccion2 = new LatLng(lat2, lng2);
            googleMap.addMarker(new MarkerOptions().position(direccion2).title("Direccion 2"));
        }
        LatLng direccion1 = new LatLng(lat1, lng1);
        googleMap.addMarker(new MarkerOptions().position(direccion1).title("Direccion 1"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(direccion1));

    }

    @Override
    public void onMapClick(@NonNull LatLng latLng) {

    }

    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {

    }
}