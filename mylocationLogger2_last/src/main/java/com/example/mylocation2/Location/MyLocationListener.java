package com.example.mylocation2.Location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by acoustically on 16. 11. 11.
 */
public class MyLocationListener implements LocationListener {
  private List<MyLocation> list = new LinkedList<>();
  private Context context;
  int count = 0;

  public MyLocationListener(Context context) {
    this.context = context;
  }
  private ObjectOutputStream getWriter() {
    try {
      return new ObjectOutputStream(
        context.openFileOutput("data.txt", Context.MODE_PRIVATE));
    } catch (Exception e) {
      Log.e("MYLOG", "Output file open error");
      return null;
    }
  }
  private MyLocation getLocation(Location location) {
    return new MyLocation(location.getLatitude(), location.getLongitude());
  }

  @Override
  public void onLocationChanged(Location location) {
    Toast.makeText(context, count++ +"", Toast.LENGTH_SHORT).show();
    list.add(getLocation(location));
    try {
      ObjectOutputStream writer = getWriter();
      writer.writeObject(list);
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void onStatusChanged(String provider, int status, Bundle extras) {

  }

  @Override
  public void onProviderEnabled(String provider) {

  }

  @Override
  public void onProviderDisabled(String provider) {

  }
}
