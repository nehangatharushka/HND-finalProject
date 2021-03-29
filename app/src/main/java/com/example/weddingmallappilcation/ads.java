package com.example.weddingmallappilcation;

public class ads {

    public ads(String description, String imageUrl, String title) {
        Description = description;
        ImageUrl = imageUrl;
        this.title = title;
    }

    private String Description;
    private String ImageUrl;
    private String title;

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public ads()
    {

    }
}
