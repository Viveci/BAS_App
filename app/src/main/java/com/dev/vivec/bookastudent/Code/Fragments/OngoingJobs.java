package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.dev.vivec.bookastudent.Code.Adapters.CompListAdapter;
import com.dev.vivec.bookastudent.Code.Adapters.CompRListAdapter;
import com.dev.vivec.bookastudent.Code.Model.CompanyItem;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by Teperics Márton on 2015.12.26..
 */
public class OngoingJobs extends Fragment {

    private CompanyItem marlane;
    private CompanyItem Magic;
    private CompanyItem Arizone;
    private CompanyItem Creative;
    private ArrayList<CompanyItem> companys;

    private RecyclerView rv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x = inflater.inflate(R.layout.fragment_ongoing, container, false);

        marlane = new CompanyItem("Marlene’s clothing", "Advertising management internship",
                "Promotional activities on social media channels with development of SEO", R.drawable.threed,"2016/04/01","2016/03/15","Horsens","Hourly");

        Magic = new CompanyItem("3D Magic","Graphics designer","Graphic design work for promotional materials.",R.drawable.threed,"2016/03/10","2016/04/10","Copenhagen","per assignment");
        Arizone = new CompanyItem("Arizon Packages","Process engineer",
                "Assistant for the operation of production line and solving process problems for quality assurance.",R.drawable.face,"2015/03/20","2016/04/20","Aalborg","Hourly");
        Creative = new CompanyItem("Creative Media Lab","Android developer","Do you enjoy working in a creative environment? Are you good with computer graphics? Do you enjoy designing minimal and user friendly content? Are you good friends with the Adobe Creative Cloud package?",
                R.drawable.creative,"2015/01/01","2016/05/01","Aarhus","per assignment");

        companys = new ArrayList<CompanyItem>();

        companys.add(Creative);
        companys.add(Magic);
        companys.add(Arizone);
        companys.add(marlane);
        companys.add(marlane);
        companys.add(Magic);
        companys.add(Arizone);
        companys.add(Creative);
        companys.add(marlane);
        companys.add(Creative);

        //Recycle view
        rv = (RecyclerView)x.findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity().getApplicationContext());
        rv.setLayoutManager(llm);

        CompRListAdapter adapter = new CompRListAdapter(companys);
        rv.setAdapter(adapter);


        return x;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
