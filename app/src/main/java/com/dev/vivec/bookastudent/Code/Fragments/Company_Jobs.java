package com.dev.vivec.bookastudent.Code.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;

/**
 * Created by user on 12/30/2015.
 */

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.dev.vivec.bookastudent.Code.Activities.SlidingTabLayout;
import com.dev.vivec.bookastudent.Code.Adapters.CompListAdapter;
import com.dev.vivec.bookastudent.Code.Adapters.PostedJobViewPager;
import com.dev.vivec.bookastudent.Code.Adapters.ViewPagerAdapter;
import com.dev.vivec.bookastudent.Code.Model.CompanyItem;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by Teperics Márton on 2015.11.16..
 */
public class Company_Jobs extends Fragment {

    private CompanyItem sony;
    private CompanyItem dell;
    private CompanyItem apple;
    private CompanyItem google;

    private ArrayList<CompanyItem> companys;
    private CompListAdapter adapter;
    private ListView list;

    private Context mc;

    private Toolbar toolbar;
    private static SlidingTabLayout tabLayout;
    private static ViewPager viewPager;
    private static int int_items = 5 ;
    private int currentItem;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x = inflater.inflate(R.layout.fragment_postedjobs, container, false);

        mc = this.getActivity().getApplicationContext();

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("My jobs");

        /*sony = new CompanyItem("Sony", "Web dev", "Lorem ipsum dolor sit amet, ius id iudicabit" +
                " liberavisse, has at laboramus intellegat.", R.drawable.sony,"2015/01/01");

        dell = new CompanyItem("Dell","Product designer","MagicKapr used fly",R.drawable.dell,"2015/01/01");
        apple = new CompanyItem("Apple","Layout designer","Graves can't have a f#&@ cigar",R.drawable.apple,"2015/01/01");
        google = new CompanyItem("Google","Android Material Design Inventor","Nonsense nonsense",R.drawable.google,"2015/01/01");

        companys = new ArrayList<CompanyItem>();

        companys.add(sony);
        companys.add(dell);
        companys.add(apple);
        companys.add(google);
        companys.add(sony);
        companys.add(google);
        companys.add(sony);
        companys.add(dell);
        companys.add(apple);
        companys.add(google);
        companys.add(sony);
        companys.add(google);

        list = (ListView) x.findViewById(R.id.comp_postedjobs_list);


        CompListAdapter adapter = new CompListAdapter(this.getActivity().getApplicationContext(),companys);

        list.setAdapter(adapter);
        */

        currentItem = 0;
        viewPager = (ViewPager) x.findViewById(R.id.view_pager_comp);
        /**
         *Set an Apater for the View Pager
         */
        viewPager.setAdapter(new PostedJobViewPager(getChildFragmentManager()));

        tabLayout = (SlidingTabLayout) x.findViewById(R.id.tabs);
        tabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.bcg_hollow));
        tabLayout.setDistributeEvenly(true);
        tabLayout.setViewPager(viewPager);
        tabLayout.setBackgroundColor(Color.parseColor("#EEEEEE"));

        return x;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
