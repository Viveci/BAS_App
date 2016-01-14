package com.dev.vivec.bookastudent.Code.Fragments;

/**
 * Created by Teperics Márton on 2015.11.10..
 */

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
        import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dev.vivec.bookastudent.Code.Adapters.EducationListAdapter;
import com.dev.vivec.bookastudent.Code.Adapters.SkillsListAdapter;
import com.dev.vivec.bookastudent.Code.Model.Education;
import com.dev.vivec.bookastudent.Code.Model.SkillsKeys;
import com.dev.vivec.bookastudent.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home extends android.support.v4.app.Fragment{

    private Toolbar toolbar;
    private ListView skills;
    private ListView edu;
    private TextView name;

    private String nameT;

    public Home(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Profile");

        nameT = "Default";

        //Connecting TextViews
        name = (TextView) rootView.findViewById(R.id.profile_userName);





        //Fetching Bundle
        if(this.getArguments()!=null) {
            Bundle bundle = this.getArguments();
            String nameT = bundle.getString("NAME");
        }


        //Filling up TextViews
        name.setText(nameT);


        //ListViews
        skills = (ListView) rootView.findViewById(R.id.profile_skillskeys_list);

        ArrayList<SkillsKeys> skillslist = new ArrayList<>();
        skillslist.add(new SkillsKeys("Programing"));
        skillslist.add(new SkillsKeys("Video editing"));
        skillslist.add(new SkillsKeys("Sound editing"));
        skillslist.add(new SkillsKeys("Book a student"));
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

        edu = (ListView) rootView.findViewById(R.id.profile_edu_list);

        ArrayList<Education> eduList = new ArrayList<>();
        eduList.add(new Education("Via"));
        eduList.add(new Education("Bme"));
        eduList.add(new Education("DTK"));
        eduList.add(new Education("Via"));
        eduList.add(new Education("Bme"));
        eduList.add(new Education("DTK"));

        EducationListAdapter eduAdapter = new EducationListAdapter((getActivity().getApplicationContext()),eduList);
        edu.setAdapter(eduAdapter);
        edu.setOnTouchListener(new View.OnTouchListener() {
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
