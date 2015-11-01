package com.nasuapps.nzschools_android_;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import adapters.DirectoryAdapter;
import models.Directory;

/**
 * Created by xzbla on 31/10/2015.
 */
public class ResultsFragment extends Fragment {
    private View _rootView;
    private DirectoryAdapter _adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_results, container, false);
        _rootView = rootView;

        ArrayList<Directory> array = ((SearchActivity)getActivity()).getSchools();

        DirectoryAdapter adapter = new DirectoryAdapter(getContext(),
                android.R.layout.simple_list_item_1, array);
        _adapter = adapter;

        ListView listView = (ListView) rootView.findViewById(R.id.schoolsList);
        listView.setAdapter(adapter);

        return _rootView;
    }
}
