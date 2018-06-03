package com.example.android.news;

public class News {

    private String mSection;
    private String mTitle;
    private String mUrl;
    private String mDate;
    private String mAuthor;




    public News(String mSection, String mTitle, String mUrl, String mDate, String mAuthor) {

        this.mSection = mSection;
        this.mTitle = mTitle;
        this.mUrl = mUrl;
        this.mDate = mDate;
        this.mAuthor = mAuthor;


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

    public String getmDate() {
        return mDate;
    }

    public String getmAuthor() { return mAuthor; }
}
