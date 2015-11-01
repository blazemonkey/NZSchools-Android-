package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nasuapps.nzschools_android_.ResultsFragment;
import com.nasuapps.nzschools_android_.SearchFragment;

/**
 * Created by xzbla on 31/10/2015.
 */
public class SearchViewPagerAdapter  extends FragmentStatePagerAdapter {
    private int _numOfTabs;

    public SearchViewPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        _numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new ResultsFragment();
            case 1:
                return new ResultsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return _numOfTabs;
    }
}
