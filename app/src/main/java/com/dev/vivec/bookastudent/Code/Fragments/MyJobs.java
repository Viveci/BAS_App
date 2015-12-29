package com.dev.vivec.bookastudent.Code.Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.vivec.bookastudent.Code.Activities.SlidingTabLayout;
import com.dev.vivec.bookastudent.Code.Adapters.ViewPagerAdapter;
import com.dev.vivec.bookastudent.R;

/**
 * Created by user on 12/20/2015.
 */
public class MyJobs extends android.support.v4.app.Fragment {

    public static SlidingTabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 5 ;
    public int currentItem;
    Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        /**
         *Inflate tab_layout and setup Views.
         */
        currentItem = 0;
        View x =  inflater.inflate(R.layout.fragment_myjobs,null);
        viewPager = (ViewPager) x.findViewById(R.id.view_pager);
        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new ViewPagerAdapter(getChildFragmentManager()));

        tabLayout = (SlidingTabLayout) x.findViewById(R.id.tabs);
        tabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.bcg_hollow));
        tabLayout.setDistributeEvenly(true);
        tabLayout.setViewPager(viewPager);
        tabLayout.setBackgroundColor(Color.parseColor("#EEEEEE"));

        return x;

    }

    public void onPause(){
        super.onPause();
        currentItem = viewPager.getCurrentItem();
        viewPager.getAdapter().destroyItem(viewPager, currentItem, null);
    }

    public void onResume(){
        super.onResume();
        viewPager.getAdapter().finishUpdate(viewPager);
    }

}
