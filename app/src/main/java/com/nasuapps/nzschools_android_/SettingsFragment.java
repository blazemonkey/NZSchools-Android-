package com.nasuapps.nzschools_android_;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import models.Region;

import java.util.Collections;
import java.util.List;

/**
 * Created by xzbla on 13/10/2015.
 */
public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);

        List<Region> regionList = Region.GetRegionList();
        Collections.sort(regionList);
        ListPreference lp = (ListPreference)findPreference("region");

        CharSequence[] entries = new CharSequence[regionList.size()];
        CharSequence[] entryValues = new CharSequence[regionList.size()];

        for (int i = 0; i < regionList.size(); i++)
        {
            entries[i] = regionList.get(i).getName();
            entryValues[i] = regionList.get(i).getId() + "";
        }

        lp.setEntries(entries);
        lp.setEntryValues(entryValues);
        lp.setDefaultValue("0");
    }
}
