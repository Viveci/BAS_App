package com.dev.vivec.bookastudent.Code.Model;

/**
 * Created by user on 1/3/2016.
 */
public class Notification {

    private String title;
    private String date;
    private String sender;
    private String content;
    private int type;
    private Boolean isNew;

    public Notification(String title, String date, String sender, String content, Boolean isNew) {
        this.title = title;
        this.date = date;
        this.sender = sender;
        this.content = content;
        this.isNew = isNew;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
