package com.harinder.hippie_backpacker.ui;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.harinder.hippie_backpacker.CreateItinerary;
import com.harinder.hippie_backpacker.ListOfPackingItems;
import com.harinder.hippie_backpacker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PackingGuide extends Fragment {

    public PackingGuide() {
        // Required empty public constructor
    }

    //Initializing the data strings
    ImageView beach, mountains, snowy, city, loona, museum;
    String[] beachI = {"Sun cream","Swimming Shorts","Shovel", "Towel","Camera","Water","Shampoo"};
    String[] mountainsI = {"Water","Umbrella","Car","Camera","GPS"};
    String[] snowyI = {"Snow Boats","Jackets","Drone","Ski gloves","Ski equipment","Black Googles"};
    String[] cityI = {"Shades","Umbrella","Water","Phone","Camera","Shoes","Battery pack"};
    String[] loonaI = {"Water","Camera","Slippers","Swimming costume","Medicines","Umbrella"};
    String[] museumI = {"Specs","Water","Umbrella","Magnifying Glass"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_packing_guide, container, false);

        //setting up layout IDs
        beach = root.findViewById(R.id.packBeach);
        mountains = root.findViewById(R.id.packMountains);
        snowy = root.findViewById(R.id.packSnow);
        city = root.findViewById(R.id.packCIty);
        loona = root.findViewById(R.id.packLoona);
        museum = root.findViewById(R.id.packMuseum);

        //Passing String arrays in bundle to show list of packing items in ListOfPackingItems activity
        beach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putStringArray("ItemValues", beachI);
                Intent intent = new Intent(getActivity(), ListOfPackingItems.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        mountains.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putStringArray("ItemValues", mountainsI);
                Intent intent = new Intent(getActivity(), ListOfPackingItems.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        snowy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putStringArray("ItemValues", snowyI);
                Intent intent = new Intent(getActivity(), ListOfPackingItems.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        city.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putStringArray("ItemValues", cityI);
                Intent intent = new Intent(getActivity(), ListOfPackingItems.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        loona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putStringArray("ItemValues", loonaI);
                Intent intent = new Intent(getActivity(), ListOfPackingItems.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

        museum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b=new Bundle();
                b.putStringArray("ItemValues", museumI);
                Intent intent = new Intent(getActivity(), ListOfPackingItems.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });



        return root;
    }
}
