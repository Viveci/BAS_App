package com.dev.vivec.bookastudent.Code.Model;

/**
 * Created by Teperics Márton on 2015.11.13..
 */
public class CompanyItem {

    private String Company;
    private String Type;
    private String Desc;
    private int icon;
    private String date;
    private String deadline;
    private String location;
    private String paymentType;

    public CompanyItem(){}


    public CompanyItem(String company, String type, String desc, int icon, String date,String deadline, String location,String paymentType) {
        Company = company;
        Type = type;
        Desc = desc;
        this.icon = icon;
        this.date = date;
        this.deadline = deadline;
        this.location = location;
        this.paymentType = paymentType;
    }

    public CompanyItem(String company, String type, String desc, int icon, String date){
        Company = company;
        Type = type;
        Desc = desc;
        this.icon = icon;
        this.date = date;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}
