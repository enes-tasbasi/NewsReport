package com.example.android.newsreport;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import java.util.List;

/**
 * Created by Tasbasi on 1/2/2017.
 */
public class ReportLoader extends AsyncTaskLoader<List<Report>>  {

    private static final String LOG_TAG = ReportLoader.class.getName();

    /** Query URL */
    private String mUrl;

    public ReportLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Override
    public List<Report> loadInBackground() {
        if(mUrl == null) {
            return null;
        }

        List<Report> reports = QueryUtils.fetchReportData(mUrl);
        return reports;
    }
}
