package com.example.android.news;


        /*
         * Copyright (C) 2016 The Android Open Source Project
         *
         * Licensed under the Apache License, Version 2.0 (the "License");
         * you may not use this file except in compliance with the License.
         * You may obtain a copy of the License at
         *
         *      http://www.apache.org/licenses/LICENSE-2.0
         *
         * Unless required by applicable law or agreed to in writing, software
         * distributed under the License is distributed on an "AS IS" BASIS,
         * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
         * See the License for the specific language governing permissions and
         * limitations under the License.
         */

        import android.app.Activity;
        import android.graphics.drawable.GradientDrawable;
        import android.support.v4.content.ContextCompat;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.TextView;

        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Date;

/*
 * {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link AndroidFlavor} objects.
 * */
public class NewsAdapter extends ArrayAdapter<News> {

    private static final String LOG_TAG = NewsAdapter.class.getSimpleName();
    private static final String SEPERATOR = " of ";
    String primaryLocation;
    String locationOffset;

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param earthquakes A List of Earthquake objects to display in a list
     */
    public NewsAdapter(Activity context, ArrayList<News> earthquakes) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, earthquakes);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        News currentEarthQuakeItem = getItem(position);



        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView magTextView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView

        double magNum = currentEarthQuakeItem.getmMag();



        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(magNum);

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        magTextView.setText(Double.toString(magNum));

        //Get String from Earthquake object

        String place = currentEarthQuakeItem.getmPlace();

        if (place.contains(SEPERATOR)) {
            String[] parts = place.split(SEPERATOR);
            locationOffset = parts[0] + SEPERATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = place;
        }

        // LOCATION OFFSET TextView

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView offsetTextView = (TextView) listItemView.findViewById(R.id.location_offset);
        // Get the version number from the current Earthquake object and

        // set this text on the number TextView
        offsetTextView.setText(locationOffset);

        // PRIMARY LOCATION TextView

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.primary_location);
        // Get the version number from the current Earthquake object and

        // set this text on the number TextView
        locationTextView.setText(primaryLocation);


        // SETS DATE TextView

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView

        // gets time in long
        Long timeUnix = currentEarthQuakeItem.getmDate();
        // gets date object
        Date dateObject = new Date(timeUnix);
        //sets the format of the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("DD MM, yyyy");
        //add date to the String
        String stringDate = dateFormat.format(dateObject);

        dateTextView.setText(stringDate);

        // SETS TIME TextView

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView

        // gets date object
        Date timeObject = new Date(timeUnix);
        //sets the format of the date
        SimpleDateFormat timeFormat = new SimpleDateFormat("kk:mm");
        //add date to the String
        String stringTime = timeFormat.format(timeObject);


        timeTextView.setText(stringTime);

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        //ImageView iconView = (ImageView) listItemView.findViewById(R.id.list_item_icon);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView
        //iconView.setImageResource(currentEarthQuakeItem.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }

    private int getMagnitudeColor(double magnitude){

        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);

    }

    // MY WAY TO SPLIT THE STRING

    /*static String[] splitter(String s){

            String[] array = s.split(SEPERATOR);

        if(s.contains(SEPERATOR)) {
            *//*int numOf = s.indexOf("of");

            int length1 = s.length();*//*

            String firstText = s.substring(0, numOf+3);

            String secondText = s.substring(numOf+3, length1);

            array[0] = firstText;
            array[1] = secondText;
        }else {
            array[0] = "Near of";
            array[1] = s;
        }


        return array;

    }*/

}

