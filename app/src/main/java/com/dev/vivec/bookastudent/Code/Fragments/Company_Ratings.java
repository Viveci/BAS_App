package com.dev.vivec.bookastudent.Code.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dev.vivec.bookastudent.Code.Activities.JobView;
import com.dev.vivec.bookastudent.Code.Adapters.StudentRatingListAdatper;
import com.dev.vivec.bookastudent.Code.Model.StudentRating;
import com.dev.vivec.bookastudent.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 12/31/2015.
 */
public class Company_Ratings extends Fragment {

    private Toolbar toolbar;
    private TextView sub;
    private ListView list;
    private StudentRatingListAdatper adapter;
    private ArrayList<StudentRating> ratings;

    public Company_Ratings(){};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.fragment_company_ratings, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Ratings");

        double rating = 4.5;
        ratings = new ArrayList<>();

        sub = (TextView) x.findViewById(R.id.comp_ratings_myrating_sub);
        sub.setText("100 feedback");

        //Stars
        ArrayList<ImageView> stars = new ArrayList<>();
        stars.add((ImageView)x.findViewById(R.id.comp_ratings_star1));
        stars.add((ImageView)x.findViewById(R.id.comp_ratings_star2));
        stars.add((ImageView)x.findViewById(R.id.comp_ratings_star3));
        stars.add((ImageView)x.findViewById(R.id.comp_ratings_star4));
        stars.add((ImageView)x.findViewById(R.id.comp_ratings_star5));


        for(int i = 1; i < (stars.size()+1); i++){
            if(i<=rating){
                stars.get(i-1).setImageResource(R.drawable.ic_star_fulln);
                stars.get(i-1).setColorFilter(Color.parseColor("#016699"));
            }
            else if(rating+0.5 == (i)){
                stars.get(i-1).setImageResource(R.drawable.ic_star_halfn);
                stars.get(i-1).setColorFilter(Color.parseColor("#016699"));
            }
            else if( rating < i){
                stars.get(i-1).setImageResource(R.drawable.ic_star_emptyn);
                stars.get(i-1).setColorFilter(Color.parseColor("#016699"));
            }
        }

        StudentRating one = new StudentRating("John",75);
        StudentRating two = new StudentRating("Matt",85);
        StudentRating three = new StudentRating("Peter",100);

        ratings.add(one);
        ratings.add(two);
        ratings.add(three);
        ratings.add(two);
        ratings.add(one);
        ratings.add(one);
        ratings.add(two);
        ratings.add(three);
        ratings.add(two);
        ratings.add(one);

        list = (ListView) x.findViewById(R.id.comp_ratings_myratings_list);
        adapter = new StudentRatingListAdatper(getActivity().getApplicationContext(),ratings);
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
