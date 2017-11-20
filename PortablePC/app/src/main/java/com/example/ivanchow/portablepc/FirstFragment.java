package com.example.ivanchow.portablepc;


import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    DBHandler dbHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_first, container, false);
        Bundle b = getArguments();
        dbHandler = new DBHandler(getActivity(), null, null, 8);

        ArrayList<NewsStory> test = new ArrayList<>();

        ArrayList<NewsStory> strings = dbHandler.databaseStories(b.getString("msg"));
        ListView list =(ListView) v.findViewById(R.id.list);
        ListAdapter listAdapter= new adapter(getActivity(),strings);
        list.setAdapter(listAdapter);

        list.setOnItemClickListener( new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String story =  (((NewsStory)parent.getItemAtPosition(position)).getTitle());
                Intent I = new Intent(getActivity(), StoryPage.class);
                I.putExtra("ARTICLE", story);

                startActivity(I);
            }
        });




        return v;
    }

    public static FirstFragment newInstance(String text) {

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }
}