package com.nasuapps.nzschools_android_;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import adapters.MainViewPagerAdapter;
import helpers.DatabaseHelper;
import helpers.JsonHelper;
import helpers.TaskHelper;
import models.Directory;
import models.Region;

public class MainActivity extends AppCompatActivity {
    public final static String SEARCH_MESSAGE = "com.nasuapps.nzschools_android_.SEARCH_MESSAGE";

    private DatabaseHelper _db;
    private TabLayout _tabLayout;
    private ArrayList<Directory> _directories;
    private ArrayList<Region> _regions;
    private HashMap<String, ArrayList<String>> _cities;
    private HashMap<String, ArrayList<String>> _suburbs;
    private ArrayList<String> _genders;
    private ArrayList<String> _schoolTypes;
    private ArrayList<String> _deciles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.search));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.nearby));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.favourites));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        _tabLayout = tabLayout;

        _db = new DatabaseHelper(this);

        if (_db.getDirectoriesCount() == 0)
        {
            String directories = JsonHelper.loadJsonFromAsset(this, "directories.json");
            new TaskHelper(this).execute(directories);
        }
        else
        {
            onTaskComplete();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onTaskComplete()
    {
        _directories = _db.getAllDirectories();
        _regions = new ArrayList<>();
        _cities = new HashMap<>();
        _suburbs = new HashMap<>();
        _genders = new ArrayList<>();
        _schoolTypes = new ArrayList<>();
        _deciles = new ArrayList<>();

        _regions.addAll(Region.GetRegionList());
        for (Directory directory : _directories)
        {
            if(!_cities.containsKey(directory.getRegion())){
                ArrayList<String> listCity = new ArrayList<>();
                ArrayList<String> listSuburb = new ArrayList<>();
                listCity.add(directory.getCity());
                listSuburb.add(directory.getCity());
                _cities.put(directory.getRegion(), listCity);
                _suburbs.put(directory.getRegion() + "-All Cities", listSuburb);
            }
            else {
                if (!_cities.get(directory.getRegion()).contains(directory.getCity())) {
                    _cities.get(directory.getRegion()).add(directory.getCity());
                }
            }

            if (!_suburbs.containsKey(directory.getRegion() + "-" + directory.getCity())) {
                ArrayList<String> list = new ArrayList<>();
                list.add(directory.getSuburb());
                _suburbs.put(directory.getRegion() + "-" + directory.getCity(), list);

                if (!directory.getSuburb().equals("")) {
                    _suburbs.get(directory.getRegion() + "-All Cities").add(directory.getSuburb());
                }
            } else {
                if (!_suburbs.get(directory.getRegion() + "-" + directory.getCity()).contains(directory.getSuburb())) {
                    _suburbs.get(directory.getRegion() + "-" + directory.getCity()).add(directory.getSuburb());

                    if (!directory.getSuburb().equals("")) {
                        _suburbs.get(directory.getRegion() + "-All Cities").add(directory.getSuburb());
                    }
                }
            }


            if (!_genders.contains(directory.getGenderOfStudents()))
                _genders.add(directory.getGenderOfStudents());

            if (!_schoolTypes.contains(directory.getSchoolType()))
                _schoolTypes.add(directory.getSchoolType());

            if (!_deciles.contains(directory.getDecile() + ""))
                _deciles.add(directory.getDecile() + "");
        }

        Collections.sort(_genders);
        Collections.sort(_schoolTypes);
        Collections.sort(_deciles);
        _genders.add(0, "All Genders");
        _schoolTypes.add(0, "All School Types");
        _deciles.add(0, "All Deciles");

        for (ArrayList<String> list : _cities.values()) {
            Collections.sort(list);
            list.add(0, "All Cities");
        }

        for (ArrayList<String> list : _suburbs.values()) {
            Collections.sort(list);
            list.add(0, "All Suburbs");
            for (int i = list.size() - 1; i >= 0; i--)
            {
                if (list.get(i).equals(""))
                {
                    list.remove(i);
                }
            }
        }

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapterFrag = new MainViewPagerAdapter
                (getSupportFragmentManager(), _tabLayout.getTabCount());
        viewPager.setAdapter(adapterFrag);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(_tabLayout));
        _tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public ArrayList<Region> getRegions()
    {
        return _regions;
    }

    public HashMap<String, ArrayList<String>> getCities()
    {
        return _cities;
    }

    public HashMap<String, ArrayList<String>> getSuburbs()
    {
        return _suburbs;
    }

    public ArrayList<String> getGenders()
    {
        return _genders;
    }

    public ArrayList<String> getSchoolTypes()
    {
        return _schoolTypes;
    }

    public ArrayList<String> getDeciles()
    {
        return _deciles;
    }
}
