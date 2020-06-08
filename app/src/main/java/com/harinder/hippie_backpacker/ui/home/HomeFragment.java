package com.harinder.hippie_backpacker.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.harinder.hippie_backpacker.CreateItinerary;
import com.harinder.hippie_backpacker.Panorama;
import com.harinder.hippie_backpacker.PanoramaList;
import com.harinder.hippie_backpacker.R;

public class HomeFragment extends Fragment {

    ImageView newSearch;
    TextView textNewSearch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflating the layout
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //Setting up layout IDs
        newSearch = root.findViewById(R.id.newSearch);
        textNewSearch = root.findViewById(R.id.textNewSearch);

        //Intent to navigate to Panorama Activity
        newSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PanoramaList.class);
                startActivity(intent);
            }
        });

        textNewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), PanoramaList.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
