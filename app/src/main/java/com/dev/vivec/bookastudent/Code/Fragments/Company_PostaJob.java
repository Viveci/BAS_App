package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.dev.vivec.bookastudent.Code.Adapters.SkillsListAdapter;
import com.dev.vivec.bookastudent.Code.Model.SkillsKeys;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 1/6/2016.
 */
public class Company_PostaJob extends Fragment {


    private Toolbar toolbar;
    private Spinner spinner;
    private ListView skills;

    private Button post;
    private Button draft;

    public Company_PostaJob(){};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.fragment_company_postajob, container, false);
        //Do stuff here

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Post a jobs");

        skills = (ListView) x.findViewById(R.id.comp_paj_skills_list);

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

        //Spinner
        spinner = (Spinner) x.findViewById(R.id.comp_paj_details_spiner);
        String[] objects = { "Payed per assignment","Hourly payment" };
        ArrayAdapter sadapter = new ArrayAdapter(
                getActivity().getApplicationContext(),android.R.layout.simple_list_item_1 ,objects);
        spinner.setAdapter(sadapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int pos,
                                       long id) {
                spinner.setSelection(pos);
                Toast.makeText(getActivity().getApplicationContext(),
                        spinner.getItemAtPosition(pos).toString(), Toast.LENGTH_LONG)
                        .show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        post = (Button) x.findViewById(R.id.comp_paj_post);
        draft = (Button) x.findViewById(R.id.comp_paj_buttons_draft);



        return x;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}