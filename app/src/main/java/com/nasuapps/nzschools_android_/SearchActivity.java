package com.nasuapps.nzschools_android_;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;

import adapters.MainViewPagerAdapter;
import adapters.SearchViewPagerAdapter;
import helpers.DatabaseHelper;
import models.Directory;
import models.Result;

/**
 * Created by xzbla on 31/10/2015.
 */
public class SearchActivity extends AppCompatActivity {
    private DatabaseHelper _db;
    private TabLayout _tabLayout;
    private ArrayList<Directory> _schools;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.results));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.map));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        _tabLayout = tabLayout;

        Intent intent = getIntent();
        Result result = intent.getParcelableExtra(MainActivity.SEARCH_MESSAGE);

        _db = new DatabaseHelper(this);
        _schools = _db.getDirectories(result.getRegion(),
                result.getCity(), result.getSuburb(), result.getGenderOfStudents(),
                result.getSchoolType(), result.getDecile());
        Collections.sort(_schools);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapterFrag = new SearchViewPagerAdapter
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ArrayList<Directory> getSchools() { return _schools; }
}
