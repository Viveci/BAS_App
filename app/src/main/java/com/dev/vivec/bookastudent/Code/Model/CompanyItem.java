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

        public CompanyItem(){}


        public CompanyItem(String company, String type, String desc, int icon, String date) {
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
}
