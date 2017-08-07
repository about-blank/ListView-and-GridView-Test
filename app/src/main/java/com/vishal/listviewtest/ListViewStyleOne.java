package com.vishal.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListViewStyleOne extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_style_one);

        listView = (ListView)findViewById(R.id.listViewOne);

        listView.setOnItemClickListener(this);
        setTitle("ListView style - 1");
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(this, ((TextView)view).getText().toString(), Toast.LENGTH_SHORT).show();
    }
}
