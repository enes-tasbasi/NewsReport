package com.example.android.newsreport;

/**
 * Created by Tasbasi on 12/19/2016.
 */
public class Report {

    private String mTitle;

    private String mSectionName;

    private String mUrl;

    public Report(String title, String sectionName, String url) {
        mTitle = title;
        mSectionName = sectionName;
        mUrl = url;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSectionName() {
        return mSectionName;
    }

    public String getUrl() {
        return mUrl;
    }
}
