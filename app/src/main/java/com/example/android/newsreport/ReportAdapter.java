package com.example.android.newsreport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tasbasi on 12/19/2016.
 */
public class ReportAdapter extends ArrayAdapter<Report>  {

    public ReportAdapter(Context context, List<Report> reports) {
        super(context, 0, reports);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list_item, parent, false);
        }

        Report currentReport = getItem(position);

        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentReport.getTitle());

        TextView sectionNameView = (TextView) listItemView.findViewById(R.id.section_name);
        sectionNameView.setText(currentReport.getSectionName());

        return listItemView;
    }
}
