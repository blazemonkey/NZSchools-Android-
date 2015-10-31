package com.nasuapps.nzschools_android_;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import adapters.CustomSpinnerAdapter;
import models.Region;

/**
 * Created by xzbla on 18/10/2015.
 */
public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private View _rootView;
    private Region _selectedRegion;
    private HashMap<String, ArrayList<String>> _cities;
    private HashMap<String, ArrayList<String>> _suburbs;

    private Spinner _citySpinner;
    private Spinner _suburbSpinner;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_search, container, false);
        _rootView = rootView;

        MainActivity mainActivity = ((MainActivity)getActivity());

        ArrayList<Region> _regions = mainActivity.getRegions();
        _cities = mainActivity.getCities();
        _suburbs = mainActivity.getSuburbs();
        ArrayList<String> _genders = mainActivity.getGenders();
        ArrayList<String> _schoolTypes = mainActivity.getSchoolTypes();
        ArrayList<String> _deciles = mainActivity.getDeciles();

        Spinner regionSpinner = (Spinner)rootView.findViewById(R.id.spinner_region);
        CustomSpinnerAdapter<Region> regionAdapter = new CustomSpinnerAdapter<>(getContext(), _regions);
        regionSpinner.setAdapter(regionAdapter);
        regionSpinner.setOnItemSelectedListener(this);

        _citySpinner = (Spinner)_rootView.findViewById(R.id.spinner_city);
        _citySpinner.setOnItemSelectedListener(this);

        _suburbSpinner = (Spinner)_rootView.findViewById(R.id.spinner_suburb);
        _suburbSpinner.setOnItemSelectedListener(this);

        Spinner genderSpinner = (Spinner)rootView.findViewById(R.id.spinner_gender);
        CustomSpinnerAdapter<String> genderAdapter = new CustomSpinnerAdapter<>(getContext(), _genders);
        genderSpinner.setAdapter(genderAdapter);

        Spinner schoolTypeSpinner = (Spinner)rootView.findViewById(R.id.spinner_school_type);
        CustomSpinnerAdapter<String> schoolTypeAdapter = new CustomSpinnerAdapter<>(getContext(), _schoolTypes);
        schoolTypeSpinner.setAdapter(schoolTypeAdapter);

        Spinner decileSpinner = (Spinner)rootView.findViewById(R.id.spinner_decile);
        CustomSpinnerAdapter<String> decileAdapter = new CustomSpinnerAdapter<>(getContext(), _deciles);
        decileSpinner.setAdapter(decileAdapter);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(rootView.getContext());
        String region = preferences.getString("region", "1");
        regionSpinner.setSelection(Integer.parseInt(region) - 1);

        return rootView;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (parent.getId())
        {
            case R.id.spinner_region:
            {
                Region selectedRegion = (Region)parent.getItemAtPosition(position);
                _selectedRegion = selectedRegion;
                setImage(_selectedRegion);

                ArrayList<String> cities = _cities.get(_selectedRegion.getName() + " Region");
                if (cities == null)
                    return;

                CustomSpinnerAdapter<String> cityAdapter = new CustomSpinnerAdapter<>(getContext(),
                        cities);
                _citySpinner.setAdapter(cityAdapter);

                break;
            }
            case R.id.spinner_city:
            {
                String selectedCity = (String)parent.getItemAtPosition(position);

                ArrayList<String> suburbs = _suburbs.get(_selectedRegion.getName() + " Region-" + selectedCity);
                if (suburbs == null)
                    return;

                CustomSpinnerAdapter<String> suburbAdapter = new CustomSpinnerAdapter<>(getContext(),
                        suburbs);
                _suburbSpinner.setAdapter(suburbAdapter);

                break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private void setImage(Region region)
    {
        ImageView imageView = (ImageView) _rootView.findViewById(R.id.nearby_image);

        int res = getResources().getIdentifier(region.getImagePath().substring(0, region.getImagePath().length() - 4),
                "drawable", getContext().getPackageName());
        imageView.setImageResource(res);
    }
}
