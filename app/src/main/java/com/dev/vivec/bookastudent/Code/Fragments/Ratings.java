package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Adapters.CompRatingListAdapter;
import com.dev.vivec.bookastudent.Code.Model.CompanyRating;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by Teperics Márton on 2015.12.26..
 */
public class Ratings extends Fragment {

    private Toolbar toolbar;

    private ProgressBar ratingbar;
    private TextView ratingLabel;
    private Button details;
    private ListView list;

    private ArrayList<CompanyRating> ratings;

    private int i = 75;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View x = inflater.inflate(R.layout.fragment_ratings,container,false);



        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Ratings");

        ratingbar = (ProgressBar) x.findViewById(R.id.ratings_myrating_progres);
        ratingbar.setProgress(i);

        ratingLabel = (TextView) x.findViewById(R.id.ratings_myrating_progreslabel);
        ratingLabel.setText(""+i+"/100");

        details = (Button) x.findViewById(R.id.ratings_myrating_details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 100){
                    i = 0;
                    ratingbar.setProgress(i);
                    ratingLabel.setText("" + i + "/100");
                }
                else{
                    i+=25;
                    ratingbar.setProgress(i);
                    ratingLabel.setText(""+i+"/100");
                }
            }
        });

        list = (ListView) x.findViewById(R.id.ratings_myratings_list);

        ratings = new ArrayList<>();

        CompanyRating two = new CompanyRating("Dell",2.5);
        CompanyRating three = new CompanyRating("Apple",3);
        CompanyRating four = new CompanyRating("Google",4);
        CompanyRating five = new CompanyRating("Dell",5);


        ratings.add(three);
        ratings.add(four);
        ratings.add(five);
        ratings.add(two);

        CompRatingListAdapter adapter = new CompRatingListAdapter(this.getActivity().getApplicationContext(),ratings);

        list.setAdapter(adapter);

        return x;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
