package com.vishal.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vishal.listviewtest.adapter.MyCustomListviewAdapter;

public class ListViewStyleTwo extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_style_two);


        listView = (ListView) findViewById(R.id.listViewTwo);

        int implementationStyle = -1;
        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            implementationStyle = bundle.getInt("implementation-style");
        }

        String[] countryList = getResources().getStringArray(R.array.countries);

        if(implementationStyle == 2) {

            setTitle("ListView style - 2");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList);
            listView.setAdapter(adapter);

        } else if(implementationStyle == 3) {

            setTitle("ListView style - 3");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mylistviewstyleone, countryList);
            listView.setAdapter(adapter);
        } else if(implementationStyle == 4) {

            setTitle("ListView style - 4");
            MyCustomListviewAdapter adapter = new MyCustomListviewAdapter(this, countryList);
            listView.setAdapter(adapter);
        }

    }
}
