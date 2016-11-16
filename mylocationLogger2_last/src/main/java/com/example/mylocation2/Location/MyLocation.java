package com.example.mylocation2.Location;

import java.io.Serializable;

/**
 * Created by acoustically on 16. 11. 11.
 */
public class MyLocation implements Serializable{
  public double lat;
  public double lng;
  public String category = "";
  public String title = "";
  public String content = "";

  public MyLocation(double lat, double lng) {
    this.lat = lat;
    this.lng = lng;
  }
}
