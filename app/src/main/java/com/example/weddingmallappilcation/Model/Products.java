package com.example.weddingmallappilcation.Model;

public class Products
{
    private String title,Description,ImageUrl ;

    public Products()
    {

    }

    public Products(String title, String description, String imageUrl) {
        this.title = title;
        Description = description;
        ImageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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
}
