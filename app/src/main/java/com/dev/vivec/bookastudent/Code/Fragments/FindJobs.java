package com.dev.vivec.bookastudent.Code.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.dev.vivec.bookastudent.Code.Activities.JobView;
import com.dev.vivec.bookastudent.Code.Adapters.CompListAdapter;
import com.dev.vivec.bookastudent.Code.Model.CompanyItem;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by Teperics Márton on 2015.11.11..
 */
public class FindJobs extends android.support.v4.app.Fragment {

    private CompanyItem sony;
    private CompanyItem dell;
    private CompanyItem apple;
    private CompanyItem google;

    private ArrayList<CompanyItem> companys;
    private CompListAdapter adapter;
    private ListView list;

    private ImageButton find;
    private EditText search;

    private Context mc;

    private Toolbar toolbar;

    public FindJobs(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_findjobs, container, false);

        mc = this.getActivity().getApplicationContext();

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Find a job");

        sony = new CompanyItem("Sony", "Web dev", "Lorem ipsum dolor sit amet, ius id iudicabit" +
                " liberavisse, has at laboramus intellegat.", R.drawable.sony,"2015/01/01");

        dell = new CompanyItem("Dell","Product designer","MagicKapr used fly",R.drawable.dell,"2015/01/01");
        apple = new CompanyItem("Apple","Layout designer","Graves can't have a f#&@ cigar",R.drawable.apple,"2015/01/01");
        google = new CompanyItem("Google","Android Material Design Inventor","Nonsense nonsense",R.drawable.google,"2015/01/01");

        companys = new ArrayList<CompanyItem>();

        companys.add(sony);
        companys.add(dell);
        companys.add(apple);
        companys.add(google);
        companys.add(sony);
        companys.add(google);
        companys.add(sony);
        companys.add(dell);
        companys.add(apple);
        companys.add(google);
        companys.add(sony);
        companys.add(google);

        list = (ListView) rootView.findViewById(R.id.findajob_list);

        CompListAdapter adapter = new CompListAdapter(this.getActivity().getApplicationContext(),companys);

        list.setAdapter(adapter);

        find = (ImageButton)rootView.findViewById(R.id.findajob_button_find);
        search = (EditText)rootView.findViewById(R.id.findajob_input_search);

        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = search.getText().toString();
                if (!input.isEmpty()) {
                    ArrayList<CompanyItem> nList = new ArrayList<CompanyItem>();
                    for (int i = 0; i < companys.size(); i++) {
                        if (companys.get(i).getCompany().equalsIgnoreCase(input)) {
                            nList.add(companys.get(i));
                        }
                    }
                    CompListAdapter nAdapter = new CompListAdapter(mc, nList);

                    list.setAdapter(nAdapter);
                } else {
                    CompListAdapter adapter = new CompListAdapter(mc, companys);

                    list.setAdapter(adapter);
                }
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity().getApplicationContext(), JobView.class);
                getActivity().startActivity(i);
                getActivity().overridePendingTransition(R.anim.move_right,R.anim.move_left);
            }
        });



        return rootView;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }
}
