package com.dev.vivec.bookastudent.Code.Fragments;

/**
 * Created by Teperics Márton on 2015.11.10..
 */

import android.app.Fragment;

        import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

import com.dev.vivec.bookastudent.R;

public class Home extends android.support.v4.app.Fragment{

    ActionBar ab;

    public Home(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        return rootView;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
