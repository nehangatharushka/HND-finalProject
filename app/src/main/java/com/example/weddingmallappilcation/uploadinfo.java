package com.example.weddingmallappilcation;

public class uploadinfo {

    public String sponsorname;
    public String imageURL;
    public uploadinfo(){}

    public uploadinfo(String name, String url) {

        this.sponsorname = name;
        this.imageURL = url;
    }





    public String getSponsorname() {
        return sponsorname;
    }
    public String getImageURL() {
        return imageURL;
    }
}

