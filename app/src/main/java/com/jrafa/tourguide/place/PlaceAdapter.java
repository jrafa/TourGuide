package com.jrafa.tourguide.place;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jrafa.tourguide.R;

import java.util.ArrayList;

/**
 * Created by jrafa on 13.04.2018.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    private int colorResourceId;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Place place = getItem(position);
        TextView placeNameTextView = listItemView.findViewById(R.id.name_text_view);
        placeNameTextView.setText(place.getName());

        TextView placeAddressTextView = listItemView.findViewById(R.id.address_text_view);
        placeAddressTextView.setText(place.getAddress());

        ImageView imageResourceID = listItemView.findViewById(R.id.image);

        if (place.hasImage()) {
            imageResourceID.setImageResource(place.getImageId());
            imageResourceID.setVisibility(View.VISIBLE);
        } else {
            imageResourceID.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        int color = ContextCompat.getColor(getContext(), colorResourceId);
        textContainer.setBackgroundColor(color);

        return listItemView;
    }

    public PlaceAdapter(@NonNull Context context, ArrayList<Place> places, int colorResourceId) {
        super(context, 0, places);
        this.colorResourceId = colorResourceId;
    }
}
