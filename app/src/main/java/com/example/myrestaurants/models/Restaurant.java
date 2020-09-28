package com.example.myrestaurants.models;

import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Restaurant {
    String name, website, imageUrl, phone;
    double rating, latitude, longitude;
    List<String> address = new ArrayList<>();
    List<String> categories = new ArrayList<>();
    private String pushId;
    String index;

    public Restaurant() {
    }

    public Restaurant(String name, String phone, String website,
                      double rating, double latitude, double longitude, String imageUrl, ArrayList<String> address, ArrayList<String> categories) {
        this.name = name;
        this.phone = phone;
        this.website = website;
        this.rating = rating;
        this.imageUrl = getLargeImageUrl(imageUrl);
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.categories = categories;
        this.index = "not_specified";

    }

    public String getLargeImageUrl(String imageUrl) {
        return imageUrl.substring(0, imageUrl.length() - 5).concat("o.jpg");
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getAddress() {
        return address;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public List<String> getCategories() {
        return categories;
    }

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
