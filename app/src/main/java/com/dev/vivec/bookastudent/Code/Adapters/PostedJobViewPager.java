package com.dev.vivec.bookastudent.Code.Adapters;

/**
 * Created by user on 1/6/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.vivec.bookastudent.Code.Fragments.CompletedJobs;
import com.dev.vivec.bookastudent.Code.Fragments.Invites;
import com.dev.vivec.bookastudent.Code.Fragments.OngoingJobs;
import com.dev.vivec.bookastudent.Code.Fragments.Pending;
import com.dev.vivec.bookastudent.Code.Fragments.RecommendedJobs;

import java.util.Locale;

/**
 * Created by Teperics Márton on 2015.11.25..
 */
public class PostedJobViewPager extends FragmentPagerAdapter {

    public PostedJobViewPager(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Fragment getItem(int position) {
        // Returns a new instance of the fragment
        switch (position) {
            case 0:
                return new OngoingJobs();
            case 1:
                return new RecommendedJobs();
            case 2:
                return new Invites();
            case 3:
                return new Pending();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "Open jobs".toUpperCase(l);
            case 1:
                return "Ongoing jobs".toUpperCase(l);
            case 2:
                return "Closed jobs".toUpperCase(l);
            case 3:
                return "Drafts".toUpperCase(l);
        }
        return null;
    }
}

