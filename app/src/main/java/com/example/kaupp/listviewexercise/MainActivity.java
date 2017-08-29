package com.example.kaupp.listviewexercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        String[] phones = new String []{
                "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu",
                "Android", "iPhone", "WindowsMobile", "Blackberry", "WebOS", "Ubuntu"
        };

        final ArrayList<String> list = new ArrayList<String>();

        for(int i = 0; i < phones.length; i++){
            list.add(phones[i]);
        }

        PhoneArrayAdapter adapter = new PhoneArrayAdapter(this, list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // get list row data (now String as a phone name)
                String phone = list.get(position);
                // create an explicit intent
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                // add data to intent
                intent.putExtra("phone",phone);
                // start a new activity
                startActivity(intent);
            }
        });
    }
}
