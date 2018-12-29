package com.mubassir.amadernetwork;

public class ListViewModel {
    String Title,Url,Description;
    int Image;
    double Latitude, Longitude;

    public ListViewModel() {
    }



    public ListViewModel(String title, String url, int image) {
        Title = title;
        Url = url;
        Image = image;

    }

    //For contactus and Office location activity
    public ListViewModel(String title, String description, int image, double lat, double longitude) {
        Title = title;
        Description = description;
        Image = image;
        Latitude=lat;
        Longitude = longitude;

    }

    //For Router Tips
    public ListViewModel(String title, int image,String description) {
        Title = title;
        Description = description;
        Image = image;
    }



    public ListViewModel(String title, String url, String description, int image) {
        Title = title;
        Url = url;
        Description = description;
        Image = image;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }
}
