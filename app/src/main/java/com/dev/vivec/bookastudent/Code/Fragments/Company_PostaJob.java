package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.vivec.bookastudent.R;

/**
 * Created by user on 1/6/2016.
 */
public class Company_PostaJob extends Fragment {


    private Toolbar toolbar;

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



        return x;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}