package com.vishal.listviewtest.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.vishal.listviewtest.ListViewStyleTwo;
import com.vishal.listviewtest.R;

/**
 * Created by Vishal Aroor on 07-Aug-17.
 */

public class MyCustomListviewAdapter extends BaseAdapter {

    private String[] countryList;
    private String[] countryCodes;
    private ListViewStyleTwo activity;
    public MyCustomListviewAdapter() {}

    public MyCustomListviewAdapter(Activity activity, String[] data, String[] codes) {
        this.countryList = data;
        this.countryCodes = codes;
        this.activity = (ListViewStyleTwo)activity;
    }

    @Override
    public int getCount() {
        return countryList.length;
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
            view = inflater.inflate(R.layout.mylistviewstyletwo, viewGroup, false);
        }

        String url = countryCodes[i];
        ((TextView)view.findViewById(R.id.textView2)).setText(countryList[i]);
        ImageView imageView = view.findViewById(R.id.imageView);
        Picasso.with(activity).load(url).into(imageView);

        return view;
    }
}
