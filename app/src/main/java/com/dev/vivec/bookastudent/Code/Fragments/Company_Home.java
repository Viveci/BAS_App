package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.vivec.bookastudent.Code.Adapters.EducationListAdapter;
import com.dev.vivec.bookastudent.Code.Model.Education;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 12/31/2015.
 */
public class Company_Home extends Fragment {

    private Toolbar toolbar;
    private ListView card;

    public Company_Home(){};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.fragment_company_home, container, false);

        //Do stuff here
        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Profile");

        card = (ListView) x.findViewById(R.id.comp_home_card_list);

        ArrayList<Education> eduList = new ArrayList<>();
        eduList.add(new Education("Master Card"));
        eduList.add(new Education("Visa"));

        EducationListAdapter eduAdapter = new EducationListAdapter((getActivity().getApplicationContext()),eduList);
        card.setAdapter(eduAdapter);
        card.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        return x;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
