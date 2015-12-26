package com.dev.vivec.bookastudent.Code.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.dev.vivec.bookastudent.Code.Fragments.CompletedJobs;
import com.dev.vivec.bookastudent.Code.Fragments.FindJobs;
import com.dev.vivec.bookastudent.Code.Fragments.Home;
import com.dev.vivec.bookastudent.Code.Fragments.Invites;
import com.dev.vivec.bookastudent.Code.Fragments.OneFragment;
import com.dev.vivec.bookastudent.Code.Fragments.OngoingJobs;
import com.dev.vivec.bookastudent.Code.Fragments.Pending;
import com.dev.vivec.bookastudent.Code.Fragments.RecommendedJobs;

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
        return 5;
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
            case 4:
                return new CompletedJobs();
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return "Ongoing jobs".toUpperCase(l);
            case 1:
                return "Recommended jobs".toUpperCase(l);
            case 2:
                return "Invites".toUpperCase(l);
            case 3:
                return "Pending jobs".toUpperCase(l);
            case 4:
                return "Completed jobs".toUpperCase(l);
        }
        return null;
    }
}
