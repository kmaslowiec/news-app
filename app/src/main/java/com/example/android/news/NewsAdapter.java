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
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link AndroidFlavor} objects.
 * */
public class NewsAdapter extends ArrayAdapter<News> {

    //private static final String LOG_TAG = NewsAdapter.class.getSimpleName(); // left for testing purposes

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param news    A List of Earthquake objects to display in a list
     */
    public NewsAdapter(Activity context, ArrayList<News> news) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, news);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link News} object located at this position in the list
        News currentNewsItem = getItem(position);

        //get String from News Object

        String section = currentNewsItem.getmSection();
        String title = currentNewsItem.getmTitle();
        String date = currentNewsItem.getmDate();

        // SECTION TextView

        // Find the TextView in the list_item.menu layout with the ID version_number
        TextView sectionTextView = (TextView) listItemView.findViewById(R.id.section_name);

        // set this text on the section_name TextView
        sectionTextView.setText(section);

        // TITLE TextView

        // Find the TextView in the list_item.menu layout with the ID version_number
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.title);

        // set this text on the title TextView
        locationTextView.setText(title);

        // DATE & TIME TextViews

        // date

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date);
        String onlyDate = date.substring(0, 10);
        dateTextView.setText(onlyDate);

        // time

        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time);
        String onlyTime = date.substring(11, 19);
        timeTextView.setText(onlyTime);

        return listItemView;
    }

}

