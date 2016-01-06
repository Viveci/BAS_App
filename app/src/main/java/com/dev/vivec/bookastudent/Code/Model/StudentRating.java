package com.dev.vivec.bookastudent.Code.Model;

/**
 * Created by user on 1/6/2016.
 */
public class StudentRating {

    private String label;
    private int rating;

    public StudentRating(String label, int rating) {
        this.label = label;
        this.rating = rating;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
