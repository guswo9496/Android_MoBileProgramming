package com.example.mylocation2.Maps;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import android.util.Log;
import android.widget.TextView;
import com.example.mylocation2.Location.MyLocation;
import com.example.mylocation2.Location.MyLocationManager;
import com.example.mylocation2.Main2Activity;
import com.example.mylocation2.R;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import org.w3c.dom.Text;

import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
  private MapsActivity activity = this;
  private GoogleMap mMap;
  private ObjectInputStream reader;
  private List<MyLocation> locationList;
  int count = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_maps);
    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
      .findFragmentById(R.id.map);
    mapFragment.getMapAsync(this);
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    mMap.setOnMarkerClickListener(makeMarkerClickListener());
    PolylineOptions polylineOptions = new PolylineOptions().visible(true);
    setLocationList();
    Iterator<MyLocation> iterator = locationList.iterator();
    while(iterator.hasNext()) {
      MyLocation location = iterator.next();
      LatLng latLng = new LatLng(location.lat, location.lng);
      mMap.addMarker(
        new MarkerOptions()
          .position(latLng)
          .draggable(true)
          .visible(true)
          .title(count++ + ""));
      mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
      polylineOptions.add(latLng);
      Log.e("Location", location.lat + ", " + location.lng);
    }
    mMap.addPolyline(polylineOptions);
  }

  private ObjectInputStream getReader() throws IOException{
    return new ObjectInputStream(openFileInput("data.txt"));
  }

  private void setLocationList(){
    try {
      reader = getReader();
      locationList = (LinkedList<MyLocation>)reader.readObject();
      reader.close();
    } catch (ClassNotFoundException e) {
      Log.e("MYLOG", "File input error");
    } catch (IOException e) {
      Log.e("MYLOG", "File input error");
    }
  }

  private GoogleMap.OnMarkerClickListener makeMarkerClickListener() {
    return new GoogleMap.OnMarkerClickListener() {
      @Override
      public boolean onMarkerClick(Marker marker) {
        Intent intent = new Intent(activity, Main2Activity.class);
        intent.putExtra("MyLocation", getLocation(marker));
        startActivity(intent);
        return false;
      }
      private MyLocation getLocation(Marker marker) {
        int index = Integer.parseInt(marker.getTitle());
        return locationList.get(index);
      }
    };
  }
}
