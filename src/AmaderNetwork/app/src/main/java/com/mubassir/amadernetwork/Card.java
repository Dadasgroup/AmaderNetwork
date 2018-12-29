package com.mubassir.amadernetwork;

public class Card {
    String Title;
    int BackgroundImage;
    String URL;

    public Card() {
    }

    public Card(String title, int backgroundImage, String URL) {
        Title = title;
        BackgroundImage = backgroundImage;
        this.URL = URL;
    }

    public String getTitle() {
        return Title;
    }

    public int getBackgroundImage() {
        return BackgroundImage;
    }

    public String getURL() {
        return URL;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setBackgroundImage(int backgroundImage) {
        BackgroundImage = backgroundImage;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }
}
