package com.vishal.listviewtest.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.vishal.listviewtest.ListViewStyleTwo;
import com.vishal.listviewtest.R;

/**
 * Created by Vishal Aroor on 07-Aug-17.
 */

public class MyCustomListviewAdapter extends BaseAdapter {

    private String[] data;
    private ListViewStyleTwo activity;
    public MyCustomListviewAdapter() {}

    public MyCustomListviewAdapter(Activity activity, String[] data) {
        this.data = data;
        this.activity = (ListViewStyleTwo)activity;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            view = inflater.inflate(R.layout.mylistviewstyleone, viewGroup, false);
        }
        ((TextView)view.findViewById(R.id.textView)).setText(data[i]+"*");

        return view;
    }
}
