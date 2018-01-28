package ojass.in.ojass_18.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import ojass.in.ojass_18.Fragments.EventsFragment;
import ojass.in.ojass_18.Fragments.HomeFragment;
import ojass.in.ojass_18.Fragments.ItinaryFragment;
import ojass.in.ojass_18.Fragments.ProfileFragment;


public class BottomNavigationAdapter extends FragmentPagerAdapter {
    public BottomNavigationAdapter(FragmentManager supportFragmentManager) {
        super(supportFragmentManager);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                return new HomeFragment();
            case 1:
                return new EventsFragment();
            case 2:
                return new ItinaryFragment();
            case 3:
                return new ProfileFragment();


        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }
}
