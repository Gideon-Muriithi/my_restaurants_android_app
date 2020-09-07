package com.example.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;

@Parcel
public class Restaurant {
    String mName, mWebsite, mImageUrl, mPhone;
    double mRating, mLatitude, mLongitude;
    ArrayList<String> mAddress = new ArrayList<>();
    ArrayList<String> mCategories = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String name, String phone, String website,
                      double rating, double latitude, double longitude, String imageUrl, ArrayList<String> address, ArrayList<String> categories) {
        this.mName = name;
        this.mPhone = phone;
        this.mWebsite = website;
        this.mRating = rating;
        mImageUrl = getLargeImageUrl(imageUrl);
        this.mAddress = address;
        this.mLatitude = latitude;
        this.mLongitude = longitude;
        this.mCategories = categories;
    }

    public String getLargeImageUrl(String imageUrl) {
        return imageUrl.substring(0, imageUrl.length() - 5).concat("o.jpg");
    }

    public String getName() {
        return mName;
    }

    public String getPhone() {
        return mPhone;
    }

    public String getWebsite() {
        return  mWebsite;
    }

    public double getRating() {
        return mRating;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public ArrayList<String> getAddress() {
        return mAddress;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public ArrayList<String> getCategories() {
        return mCategories;
    }
}
