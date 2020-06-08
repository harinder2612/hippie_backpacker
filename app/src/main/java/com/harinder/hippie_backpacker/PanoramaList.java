package com.harinder.hippie_backpacker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PanoramaList extends AppCompatActivity {

    private RecyclerView recyclerView;
    //Initiating data arrays which will be passed to recyclerview adapter as parameters
    private int[] images = {R.drawable.beach,R.drawable.mcg, R.drawable.eureka, R.drawable.aquarium, R.drawable.memorial, R.drawable.dandenongranges, R.drawable.beach2, R.drawable.museum, R.drawable.loonapark, R.drawable.lake };
    private String[] names = {"St. Kilda", "MCG", "Eureka Tower","Aquarium","Memorial Shrine","Puffing Billy","Mordialloc","Museum","Loona Park","Lysterfield Lake"};
    private String[] latlngs = {"-37.864205,144.964448", "-37.8199037,144.9805093", "-37.8213298,144.9625095","-37.8207836,144.9561307","-37.8305121,144.9712432","-37.9182715,145.3731153","-37.9979852,145.0482345","-37.8030487,144.9698313","-37.8676749,144.9746777","-37.9618016,145.2901909"};
    //initiating layout manager
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panorama_list);

        //setting up title of action bar
        getSupportActionBar().setTitle("Tourist Attractions Near You");

        recyclerView = findViewById(R.id.listOfPanormas);
        //setting up Gridlayout manager to our layoutmanager instance
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //creating recyclerview adapter by passing data arrays and context of the activity which will later help implement onClick Listener
        adapter = new RecyclerAdapter(images,names,latlngs,this);
        //setting the newly created adapter to the recyclerview
        recyclerView.setAdapter(adapter);

    }
}
