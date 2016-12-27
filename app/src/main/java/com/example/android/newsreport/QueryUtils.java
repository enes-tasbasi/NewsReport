package com.example.android.newsreport;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tasbasi on 12/20/2016.
 */
public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {

    }

    public static List<Report> extractFeatureFromJson(String reportJson){
//        if(TextUtils.isEmpty(reportJson)) {
//            return null;
//        }

        List<Report> reports = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(reportJson);

            JSONObject responseObject = baseJsonResponse.getJSONObject("response");

            JSONArray reportArray = responseObject.getJSONArray("results");

            for(int i = 0; i < reportArray.length(); i++) {

                JSONObject currentReport = reportArray.getJSONObject(i);

                String sectionName = currentReport.getString("sectionName");

                String title = currentReport.getString("webTitle");

                String url = currentReport.getString("webUrl");

                Report report = new Report(sectionName, title, url);

                reports.add(report);
            }


        } catch (JSONException e) {
            Log.e(LOG_TAG, "Error Parsing");
        }

        return reports;
    }
}
