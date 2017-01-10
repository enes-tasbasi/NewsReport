package com.example.android.newsreport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tasbasi on 12/20/2016.
 */
public final class QueryUtils {

    private static final String LOG_TAG = QueryUtils.class.getSimpleName();

    private QueryUtils() {

    }

    public static List<Report> fetchReportData(String requestUrl) {
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        String jsonResponse = null;
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem making the Http request");
        }

        List<Report> report = extractFeatureFromJson(jsonResponse);

        return report;
    }

    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        //If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestMethod("GET");
            Log.i("RESPONSE_CODE", String.valueOf(urlConnection));
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                Log.i("RESPONSE_CODE", "SUCCESS!");
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("RESPONSE_CODE", "Problem retrieving results.");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        }

        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }

        return output.toString();
    }

    public static List<Report> extractFeatureFromJson(String reportJson) {
//        if(TextUtils.isEmpty(reportJson)) {
//            return null;
//        }

        List<Report> reports = new ArrayList<>();

        try {
            JSONObject baseJsonResponse = new JSONObject(reportJson);

            JSONObject responseObject = baseJsonResponse.getJSONObject("response");

            JSONArray reportArray = responseObject.getJSONArray("results");

            for (int i = 0; i < reportArray.length(); i++) {

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
