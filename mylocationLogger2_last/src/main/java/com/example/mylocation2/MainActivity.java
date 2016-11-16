package com.example.mylocation2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.mylocation2.Location.MyLocationManager;
import com.example.mylocation2.Maps.MapsActivity;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    MyLocationManager locationManager = new MyLocationManager(this);
    locationManager.repeatRequestLocation();
  }

  public void onClick(View view) {
    if(view.getId() == R.id.StartView) {
      Intent intent = new Intent(this, MapsActivity.class);
      startActivity(intent);
    }else if (view.getId()==R.id.all_close){
      moveTaskToBack(true);
      finish();
      android.os.Process.killProcess(android.os.Process.myPid());
    }
  }
}
