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
public class CultureFragment extends Fragment {

    public CultureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> places = addDataCulture();

        PlaceAdapter itemsAdapter = new PlaceAdapter(getActivity(), places, R.color.colorCulture);
        ListView listView = rootView.findViewById(R.id.place_list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

    public ArrayList<Place> addDataCulture() {
        ArrayList<Place> places = new ArrayList<Place>();

        for (int i = 0; i < getResources().getStringArray(R.array.culture).length; i++) {
            places.add(new Place(getResources().getStringArray(R.array.culture)[i],
                    getResources().getStringArray(R.array.culture_addresses)[i], R.drawable.culture));
        }

        return places;
    }

}
