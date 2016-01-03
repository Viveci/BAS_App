package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.12.26..
 */
public class Notifications extends Fragment {

    private Toolbar toolbar;
    private ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x = inflater.inflate(R.layout.fragment_notifications, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Notifications");

        list = (ListView) x.findViewById(R.id.notifications_list);



        return x;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
