package com.harinder.hippie_backpacker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListOfPackingItems extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_packing_items);

        //Setting up action bar title
        getSupportActionBar().setTitle("Necessary Items");

        //Rerieve String array from bundle recieved in intent extras
        Bundle b=this.getIntent().getExtras();
        String[] items = b.getStringArray("ItemValues");

        listView = findViewById(R.id.listOfItems);

        //Put the string array data in ListView of necessasry packing Items
        listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,items);
        //setup adapter
        listView.setAdapter(listAdapter);


    }
}
