package manukj.manu.final_bnm;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


import static manukj.manu.final_bnm.TabFragment.int_items;


/**
 * Created by nihaarika on 26/4/18.
 */

public class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm)
    {
        super(fm);
    }
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AboutFragment();
            case 1:
                return new EventsFragment();
            case 2:
                return new SponsorsFragment();
            case 3:
                return new PhotosFragment();


        }
        return null;
    }

    @Override
    public int getCount() {


        return int_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "ABOUT";
            case 1:
                return "EVENTS";
            case 2:
                return "SPONSORS";
            case 3:
                return "PHOTOS";
        }

        return null;
    }
}
