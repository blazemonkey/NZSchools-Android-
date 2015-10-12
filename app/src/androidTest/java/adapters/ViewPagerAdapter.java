package adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by xzbla on 12/10/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private int _numOfTabs;

    public ViewPagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        _numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int index) {
        return null;
    }

    @Override
    public int getCount() {
        return _numOfTabs;
    }
}
