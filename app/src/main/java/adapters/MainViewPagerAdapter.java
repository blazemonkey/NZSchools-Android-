package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.nasuapps.nzschools_android_.SearchFragment;

/**
 * Created by xzbla on 12/10/2015.
 */
public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
    private int _numOfTabs;

    public MainViewPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        _numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new SearchFragment();
            case 1:
                return new SearchFragment();
            case 2:
                return new SearchFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return _numOfTabs;
    }
}
