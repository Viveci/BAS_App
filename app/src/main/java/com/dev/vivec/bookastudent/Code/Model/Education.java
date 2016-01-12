package com.dev.vivec.bookastudent.Code.Model;

/**
 * Created by Teperics on 1/11/2016.
 */
public class Education {

    private String title;
    private String level;
    private String date;

    public Education(String title, String level, String date) {
        this.title = title;
        this.level = level;
        this.date = date;
    }

    public Education(String title){
        this.title = title;
        level = "";
        date = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
