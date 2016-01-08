package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import com.dev.vivec.bookastudent.R;

/**
 * Created by user on 1/6/2016.
 */
public class Company_PostaJob extends Fragment {


    private Toolbar toolbar;
    private Spinner spinner;

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

        spinner = (Spinner) x.findViewById(R.id.comp_paj_details_spiner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.payment, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

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