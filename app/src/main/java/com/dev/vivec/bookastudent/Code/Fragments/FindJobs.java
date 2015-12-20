package com.dev.vivec.bookastudent.Code.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

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

    public FindJobs(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_findjobs, container, false);

        mc = this.getActivity().getApplicationContext();

        sony = new CompanyItem("Sony", "Web dev", "Lorem ipsum dolor sit amet, ius id iudicabit" +
                " liberavisse, has at laboramus intellegat.", R.drawable.sony);

        dell = new CompanyItem("Dell","Product designer","MagicKapr used fly",R.drawable.dell);
        apple = new CompanyItem("Apple","Layout designer","Graves can't have a f#&@ cigar",R.drawable.apple);
        google = new CompanyItem("Google","Android Material Design Inventor","Nonsense nonsense",R.drawable.google);

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
                if(!input.isEmpty()){
                ArrayList<CompanyItem> nList = new ArrayList<CompanyItem>();
                for(int i = 0; i < companys.size();i++){
                    if(companys.get(i).getCompany().equalsIgnoreCase(input)){
                        nList.add(companys.get(i));
                    }
                }
                CompListAdapter nAdapter = new CompListAdapter(mc,nList);

                list.setAdapter(nAdapter);
                }
                else{
                    CompListAdapter adapter = new CompListAdapter(mc,companys);

                    list.setAdapter(adapter);
                }
            }
        });

        return rootView;
    }
}
