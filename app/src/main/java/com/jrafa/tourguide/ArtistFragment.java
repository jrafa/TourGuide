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
public class ArtistFragment extends Fragment {

    public ArtistFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> artists = addDataArtists();

        PlaceAdapter itemsAdapter = new PlaceAdapter(getActivity(), artists, R.color.colorArtist);
        ListView listView = rootView.findViewById(R.id.place_list);
        listView.setAdapter(itemsAdapter);

        return rootView;
    }

    public ArrayList<Place> addDataArtists() {
        ArrayList<Place> artists = new ArrayList<Place>();

        for (int i = 0; i < getResources().getStringArray(R.array.artists).length; i++) {
            artists.add(new Place(getResources().getStringArray(R.array.artists)[i],
                    getResources().getStringArray(R.array.artists_profession)[i], R.drawable.artist));
        }

        return artists;
    }

}
