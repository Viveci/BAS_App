package com.dev.vivec.bookastudent.Code.Model;

/**
 * Created by user on 1/3/2016.
 */
public class CompanyRating {

    private String title;
    private double rating;

    public CompanyRating(){};

    public CompanyRating(String title, double rating){
        this.title = title;
        this.rating = rating;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
