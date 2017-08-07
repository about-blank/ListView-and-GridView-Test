package com.vishal.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.vishal.listviewtest.adapter.MyCustomListviewAdapter;

public class ListViewStyleTwo extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_style_two);


        listView = (ListView) findViewById(R.id.listViewTwo);
        gridView = (GridView) findViewById(R.id.gridViewTwo);

        int implementationStyle = -1;
        String containerType = null;

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            implementationStyle = bundle.getInt("implementation-style");
            containerType = bundle.getString("container-type");
        }

        if(containerType.equals("LISTVIEW")) {
            listView.setVisibility(View.VISIBLE);
            listView.setOnItemClickListener(this);
        }
        else {
            gridView.setVisibility(View.VISIBLE);
        }

        String[] countryList = getResources().getStringArray(R.array.countries);
        String[] countryCodes = getResources().getStringArray(R.array.country_codes);

        if(implementationStyle == 2) {

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList);
            setTitle(containerType + " style - 2");
            if(containerType.equals("LISTVIEW"))
                listView.setAdapter(adapter);
            else
                gridView.setAdapter(adapter);

        } else if(implementationStyle == 3) {

            setTitle(containerType + " style - 3");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mylistviewstyleone, countryList);
            listView.setAdapter(adapter);
            if(containerType.equals("LISTVIEW"))
                listView.setAdapter(adapter);
            else
                gridView.setAdapter(adapter);

        } else if(implementationStyle == 4) {

            setTitle(containerType + " style - 4");
            MyCustomListviewAdapter adapter = new MyCustomListviewAdapter(this, countryList, countryCodes);
            if(containerType.equals("LISTVIEW"))
                listView.setAdapter(adapter);
            else
                gridView.setAdapter(adapter);
        }

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        if(view.getId() == R.id.listItemContainerSmall)
        { //style-3

            Toast.makeText(this, ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
        }
        else if(view.getId() == R.id.listItemContainerBig)
        { //style-4

            TextView tv = view.findViewById(R.id.textView2);
            Toast.makeText(this, tv.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        else
        { //style-2

            Toast.makeText(this, ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
