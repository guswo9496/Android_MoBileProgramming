package com.example.newmylocationlogger;

import android.location.Location;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import android.os.Parcel;
import android.os.Parcelable;
///**
// * Created by nooyahs on 2016. 10. 31..

public class gps implements Parcelable {
    public LatLng placeLatLng;  // place longitude, latitude.

    public gps() {  }


    public gps(Parcel in) {
        readFromParcel(in);
    }

    public gps(String _title, String _author, String _pub, String _isbn, String _desc, int _price, String _photoUrl) {
        this.title = _title;
        this.author = _author;
        this.publisher = _pub;
        this.isbn = _isbn;
        this.description = _desc;
        this.price = _price;
        this.photoUrl = _photoUrl;
    }


    private void readFromParcel(Parcel in){
        title = in.readString();
        author = in.readString();
        publisher = in.readString();
        isbn = in.readString();
        description = in.readString();
        photoUrl = in.readString();
        price = in.readInt();
    }

    public LatLng getpLatLng() {return placeLatLng;}

    public void setpLatLng (LatLng _pLatLng) {
        this.placeLatLng = _pLatLng;
   }


}