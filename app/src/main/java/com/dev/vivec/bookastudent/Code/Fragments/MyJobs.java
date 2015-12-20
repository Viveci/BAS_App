package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.vivec.bookastudent.Code.Activities.SlidingTabLayout;
import com.dev.vivec.bookastudent.Code.Adapters.ViewPagerAdapter;
import com.dev.vivec.bookastudent.R;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by user on 12/20/2015.
 */
public class MyJobs extends android.support.v4.app.Fragment {

    public static SlidingTabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 3 ;
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        View x =  inflater.inflate(R.layout.fragment_myjobs,null);
        viewPager = (ViewPager) x.findViewById(R.id.view_pager);

        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new ViewPagerAdapter(getActivity().getSupportFragmentManager()));
        SlidingTabLayout mSlidingTabLayout = (SlidingTabLayout) x.findViewById(R.id.tabs);
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.bcg_norm));
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setViewPager(viewPager);



        return x;

    }

}
