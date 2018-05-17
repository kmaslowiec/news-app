package com.example.android.news;

public class News {

    private double mMag;
    private String mPlace;
    private Long mDate;
    private String mUrl;



    public News(String mPlace, String mUrl) {
       // this.mMag = mMag;
        this.mPlace = mPlace;
        //this.mDate = mDate;
        this.mUrl = mUrl;

    }

    public double getmMag() {
        return mMag;
    }


    public String getmPlace() {
        return mPlace;
    }

    public Long getmDate() {
        return mDate;
    }

    public String getmUrl() {
        return mUrl;
    }

}
