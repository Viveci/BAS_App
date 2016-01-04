package com.dev.vivec.bookastudent.Code.Fragments;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.13..
 */
public class Contact extends android.support.v4.app.Fragment {

        private Toolbar toolbar;
        private ImageButton facebook;

        public Contact(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

            toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle("Contact us");

            facebook = (ImageButton) rootView.findViewById(R.id.contact_facebook);
            facebook.setColorFilter(Color.parseColor("#FFFFFF"));

            return rootView;
        }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
