package com.example.hilman.wisatalombok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.example.hilman.wisatalombok.Pembayaran;

/**
 * Created by HILMAN on 6/29/2015.
 */
public class TabsPagerAdapter extends FragmentPagerAdapter{



    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                // Top Rated fragment activity
                return new Pembayaran();
            case 1:
                // Games fragment activity
                return new Pembayaran();
            case 2:
                // Movies fragment activity
                return new Pembayaran();
            case 3:
                // Movies fragment activity
                return new Pembayaran();
            case 4:
                // Movies fragment activity
                return new Pembayaran();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 5;
    }
}
