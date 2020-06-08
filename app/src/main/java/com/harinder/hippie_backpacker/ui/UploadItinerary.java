package com.harinder.hippie_backpacker.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.harinder.hippie_backpacker.CreateItinerary;
import com.harinder.hippie_backpacker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UploadItinerary extends Fragment {

    public UploadItinerary() {
        // Required empty public constructor
    }

    private ImageView create;
    TextView createText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_upload_itinerary, container, false);

        //Setting up layout Ids
        create = root.findViewById(R.id.newUpload);
        createText = root.findViewById(R.id.createText);

        //Onclick event to move to Create Itinerary activity
        createText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateItinerary.class);
                startActivity(intent);
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateItinerary.class);
                startActivity(intent);
            }
        });

        return root;
    }
}
