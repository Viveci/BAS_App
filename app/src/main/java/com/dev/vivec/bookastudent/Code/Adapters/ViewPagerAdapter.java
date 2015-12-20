package com.dev.vivec.bookastudent.Code.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.vivec.bookastudent.Code.Fragments.Contact;
import com.dev.vivec.bookastudent.Code.Fragments.FindJobs;
import com.dev.vivec.bookastudent.Code.Fragments.Home;

import java.util.Locale;

/**
 * Created by Teperics Márton on 2015.11.25..
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        // Returns the number of tabs
        return 5;
    }

    @Override
    public Fragment getItem(int position) {
        // Returns a new instance of the fragment
        switch (position) {
            case 0:
                Home h = new Home();
                return h;
            case 1:
                return new FindJobs();
            case 2:
                return new Contact();
            case 3:
                return new FindJobs();
            case 4:
                return new Home();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "Profile".toUpperCase(l);
            case 1:
                return "Find a job".toUpperCase(l);
            case 2:
                return "Tralalalal".toUpperCase(l);
            case 3:
                return "Tralala".toUpperCase(l);
            case 4:
                return "Tralalalal".toUpperCase(l);
        }
        return null;
    }
}
