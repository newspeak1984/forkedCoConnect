package com.example.ivanchow.portablepc;

/**
 * Created by Russell on 2017-06-13.
 */
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class List_View extends ListFragment{
    String[] list_items;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.list, container, false);
        String[] list_items = {"apple", "raspberry","pizza"};
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list_items));

        return rootView;
    }

}
