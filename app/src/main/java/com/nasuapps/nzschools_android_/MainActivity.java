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

import java.util.ArrayList;

import adapters.ViewPagerAdapter;
import helpers.DatabaseHelper;
import helpers.JsonHelper;
import helpers.TaskHelper;
import models.Directory;

public class MainActivity extends AppCompatActivity {
    private DatabaseHelper _db;
    private TabLayout _tabLayout;
    private ArrayList<Directory> _directories;

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

        _directories = new ArrayList<>();
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
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter adapterFrag = new ViewPagerAdapter
                (getSupportFragmentManager(), _tabLayout.getTabCount());
        viewPager.setAdapter(adapterFrag);
    }
}
