package com.harinder.hippie_backpacker.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.harinder.hippie_backpacker.CreateItinerary;
import com.harinder.hippie_backpacker.Itinerary;
import com.harinder.hippie_backpacker.R;
import com.harinder.hippie_backpacker.ShowItinerary;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExploreFragment extends Fragment {

    public ExploreFragment() {
        // Required empty public constructor
    }

    DatabaseReference databaseReference;
    ListView itList;
    ArrayAdapter<String> listAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //Inflating Layout
        View root = inflater.inflate(R.layout.fragment_explore, container, false);

        itList = root.findViewById(R.id.itList);

        //Establishing firebase connection by getInstance()
        databaseReference = FirebaseDatabase.getInstance().getReference().child("itineraries");

        //Event listener to read data from firebase at start and whenevr any data is changed
        ValueEventListener ItineraryListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Itinerary object and use the values to update the UI

                final List<Itinerary> itineraries = new ArrayList<>();
                List<String> itinerariesNames = new ArrayList<>();

                int count = 1;
                for (DataSnapshot dataValues : dataSnapshot.getChildren()){
                    Itinerary itinerary = dataValues.getValue(Itinerary.class);
                    itinerariesNames.add("Location "+count+": "+itinerary.getLocationName());
                    itineraries.add(itinerary);
                    count++;
                }

                //Updating ListView after retrieveing data from firebase

                try{
                    listAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1,itinerariesNames);
                    itList.setAdapter(listAdapter);

                    //setting up on item click listener for list items, when clicked will navigate to ShowItinerary activity
                    itList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(getActivity(), ShowItinerary.class);
                            intent.putExtra("locName",itineraries.get(position).getLocationName());
                            intent.putExtra("locType",itineraries.get(position).getLocationType());
                            intent.putExtra("locHours",itineraries.get(position).getLocationHours());
                            intent.putExtra("locItems",itineraries.get(position).getLocationItems());
                            intent.putExtra("locExperience",itineraries.get(position).getLocationExperience());
                            startActivity(intent);
                        }
                    });
                }catch (Exception e)
                {
                    e.printStackTrace();
                }


            //    Log.e("Iti1 value:>>", itineraries.get(0).getLocationName());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(">>>>>", "loadItinerary:onCancelled", databaseError.toException());
                // [START_EXCLUDE]
                Toast.makeText(getActivity(), "Failed to load post.",
                        Toast.LENGTH_SHORT).show();
                // [END_EXCLUDE]
            }
        };
        databaseReference.addValueEventListener(ItineraryListener);

        return root;
    }

}
