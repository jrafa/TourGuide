package com.jrafa.tourguide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jrafa.tourguide.place.Place;
import com.jrafa.tourguide.place.PlaceAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmbassyFragment extends Fragment {


    public EmbassyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = addDataEmbassy();

        PlaceAdapter itemsAdapter = new PlaceAdapter(getActivity(), places, R.color.colorEmbassy);
        ListView listView = rootView.findViewById(R.id.place_list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

    public ArrayList<Place> addDataEmbassy() {
        ArrayList<Place> places = new ArrayList<Place>();

        for (int i = 0; i < getResources().getStringArray(R.array.embassies).length; i++) {
            places.add(new Place(getResources().getStringArray(R.array.embassies)[i],
                    getResources().getStringArray(R.array.embassies_addresses)[i], -1));
        }

        return places;
    }
}
