package com.mubassir.amadernetwork;

public class Card {
    String Title;
    int BackgroundImage;
    String URL;
    //for grid layout
    int LayoutBackgroundColor;
    int TextBackgroundColor;

    public Card() {
    }

    public Card(String title, int backgroundImage, String URL) {
        Title = title;
        BackgroundImage = backgroundImage;
        this.URL = URL;
    }

    public Card(String title, int backgroundImage, String URL, int layoutBackgroundColor, int textBackgroundColor) {
        Title = title;
        BackgroundImage = backgroundImage;
        this.URL = URL;
        LayoutBackgroundColor = layoutBackgroundColor;
        TextBackgroundColor = textBackgroundColor;
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

    //Grid layout background
    public int getLayoutBackgroundColor() {
        return LayoutBackgroundColor;
    }

    public void setLayoutBackgroundColor(int layoutBackgroundColor) {
        LayoutBackgroundColor = layoutBackgroundColor;
    }

    public int getTextBackgroundColor() {
        return TextBackgroundColor;
    }

    public void setTextBackgroundColor(int textBackgroundColor) {
        TextBackgroundColor = textBackgroundColor;
    }
}
