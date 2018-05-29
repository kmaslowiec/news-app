package com.example.android.news;

public class News {

    private String mSection;
    private String mTitle;
    private String mUrl;
    private String mDate;



    public News(String mSection, String mTitle, String mUrl, String mDate) {

        this.mSection = mSection;
        this.mTitle = mTitle;

        this.mUrl = mUrl;
        this.mDate = mDate;

    }

    public String getmSection() {
        return mSection;
    }

    public String getmTitle() {
        return mTitle;
    }

    public String getmUrl() {
        return mUrl;
    }

    public String getmDate() { return mDate; }

}
