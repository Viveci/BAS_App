package com.dev.vivec.bookastudent.Code.Fragments;

/**
 * Created by Teperics Márton on 2015.11.10..
 */

import android.app.Fragment;

        import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
        import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.vivec.bookastudent.Code.Adapters.SkillsListAdapter;
import com.dev.vivec.bookastudent.Code.Model.SkillsKeys;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;
import java.util.List;

public class Home extends android.support.v4.app.Fragment{

    private Toolbar toolbar;
    private ListView skills;

    public Home(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Profile");

        skills = (ListView) rootView.findViewById(R.id.profile_skillskeys_list);

        ArrayList<SkillsKeys> skillslist = new ArrayList<>();
        skillslist.add(new SkillsKeys("Programing"));
        skillslist.add(new SkillsKeys("Video editing"));
        skillslist.add(new SkillsKeys("Sound editing"));
        skillslist.add(new SkillsKeys("Book a student"));

        SkillsListAdapter adapter = new SkillsListAdapter(getActivity().getApplicationContext(),skillslist);
        skills.setAdapter(adapter);
        skills.setOnTouchListener(new View.OnTouchListener() {
            // Setting on Touch Listener for handling the touch inside ScrollView
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });

        return rootView;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
