package com.example.mylocation2.Location;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.HandlerThread;
import android.util.Log;

/**
 * Created by acoustically on 16. 11. 11.
 */
public class MyLocationManager {
  private LocationManager locationManager;
  private LocationListener locationListener;

  public MyLocationManager(Context context) {
    this.locationManager =
      (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
    this.locationListener = new MyLocationListener(context);
  }
  public void requestLocation() {
    try {
      locationManager.requestSingleUpdate(
        LocationManager.NETWORK_PROVIDER
        , locationListener
        , null);
    } catch (SecurityException e) {
      Log.e("MYLOG", "RequestLocation error");
    }
  }
  public void repeatRequestLocation() {
    HandlerThread handlerThread = new HandlerThread("request");
    try {
      locationManager.requestLocationUpdates(
        LocationManager.NETWORK_PROVIDER
        , 1000
        , -1
        , locationListener, handlerThread.getLooper());
    } catch (SecurityException e) {
      Log.e("MYLOG", "RequestLocation error");
    }
  }
}
