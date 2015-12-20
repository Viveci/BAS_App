package com.dev.vivec.bookastudent.Code.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.13..
 */
public class Contact extends android.support.v4.app.Fragment {

        ActionBar ab;

        public Contact(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

            return rootView;
        }
}
