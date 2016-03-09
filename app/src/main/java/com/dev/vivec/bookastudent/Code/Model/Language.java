package com.dev.vivec.bookastudent.Code.Model;

/**
 * Created by user on 2/17/2016.
 */
public class Language {

    private String language;
    private String level;

    public Language(String language, String level) {
        this.language = language;
        this.level = level;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
