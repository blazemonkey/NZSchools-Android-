package com.nasuapps.nzschools_android_;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import adapters.CustomSpinnerAdapter;
import models.Region;
import models.Result;

/**
 * Created by xzbla on 18/10/2015.
 */
public class SearchFragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private View _rootView;
    private Region _selectedRegion;
    private String _selectedCity;
    private String _selectedSuburb;
    private String _selectedGender;
    private String _selectedSchoolType;
    private String _selectedDecile;

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
        genderSpinner.setOnItemSelectedListener(this);

        Spinner schoolTypeSpinner = (Spinner)rootView.findViewById(R.id.spinner_school_type);
        CustomSpinnerAdapter<String> schoolTypeAdapter = new CustomSpinnerAdapter<>(getContext(), _schoolTypes);
        schoolTypeSpinner.setAdapter(schoolTypeAdapter);
        schoolTypeSpinner.setOnItemSelectedListener(this);

        Spinner decileSpinner = (Spinner)rootView.findViewById(R.id.spinner_decile);
        CustomSpinnerAdapter<String> decileAdapter = new CustomSpinnerAdapter<>(getContext(), _deciles);
        decileSpinner.setAdapter(decileAdapter);
        decileSpinner.setOnItemSelectedListener(this);

        Button searchButton = (Button) rootView.findViewById(R.id.button_search);
        searchButton.setOnClickListener(this);

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
                _selectedCity = selectedCity;

                ArrayList<String> suburbs = _suburbs.get(_selectedRegion.getName() + " Region-" + selectedCity);
                if (suburbs == null)
                    return;

                CustomSpinnerAdapter<String> suburbAdapter = new CustomSpinnerAdapter<>(getContext(),
                        suburbs);
                _suburbSpinner.setAdapter(suburbAdapter);

                break;
            }
            case R.id.spinner_suburb:
            {
                String selectedSuburb = (String)parent.getItemAtPosition(position);
                _selectedSuburb = selectedSuburb;
                break;
            }
            case R.id.spinner_gender:
            {
                String selectedGender = (String)parent.getItemAtPosition(position);
                _selectedGender = selectedGender;
                break;
            }
            case R.id.spinner_school_type:
            {
                String selectedSchoolType = (String)parent.getItemAtPosition(position);
                _selectedSchoolType = selectedSchoolType;
                break;
            }
            case R.id.spinner_decile:
            {
                String selectedDecile = (String)parent.getItemAtPosition(position);
                _selectedDecile = selectedDecile;
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

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.button_search:
            {
                Intent intent = new Intent(getContext(), SearchActivity.class);
                Result result = new Result(_selectedRegion.getName(),
                        _selectedCity,
                        _selectedSuburb,
                        _selectedGender,
                        _selectedSchoolType,
                        _selectedDecile);
                intent.putExtra(MainActivity.SEARCH_MESSAGE, result);

                startActivity(intent);
            }
        }
    }
}
