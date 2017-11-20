package com.example.ivanchow.portablepc;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class adapter extends ArrayAdapter<NewsStory> {
    public adapter(Context context, ArrayList<NewsStory> foods) {
        super(context, R.layout.custom_row ,foods);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.custom_row,parent,false);
        NewsStory story = getItem(position);
        TextView text = (TextView) customView.findViewById(R.id.storyTitle);
        text.setText(story.getTitle());
        ImageView image =(ImageView) customView.findViewById(R.id.storyImage);
        image.setImageBitmap(story.getTitleImage());

        return customView;
    }
}
