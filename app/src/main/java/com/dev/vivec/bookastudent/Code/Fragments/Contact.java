package com.dev.vivec.bookastudent.Code.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.dev.vivec.bookastudent.R;

/**
 * Created by Teperics Márton on 2015.11.13..
 */
public class Contact extends android.support.v4.app.Fragment {

        private Toolbar toolbar;
        private ImageButton facebook;
        private ImageButton instagram;
        private ImageButton twitter;
        private ImageButton linkedin;
        private Button email;

        public Contact(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_contact, container, false);

            toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
            toolbar.setTitle("Contact us");

            email = (Button) rootView.findViewById(R.id.contact_email_button);
            linkedin = (ImageButton) rootView.findViewById(R.id.contact_linked);
            twitter = (ImageButton) rootView.findViewById(R.id.contact_twitter);
            instagram = (ImageButton) rootView.findViewById(R.id.contact_insta);
            facebook = (ImageButton) rootView.findViewById(R.id.contact_facebook);

            /*email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.CATEGORY_APP_EMAIL);
                    intent.setType("plain/text");
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "some@email.address" });
                    intent.putExtra(Intent.EXTRA_SUBJECT, "subject");
                    intent.putExtra(Intent.EXTRA_TEXT, "mail body");
                    startActivity(Intent.createChooser(intent, ""));
                }
            });*/

            return rootView;
        }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
