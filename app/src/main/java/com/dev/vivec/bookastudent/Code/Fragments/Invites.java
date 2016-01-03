package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.vivec.bookastudent.Code.Adapters.CompListAdapter;
import com.dev.vivec.bookastudent.Code.Model.CompanyItem;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by Teperics Márton on 2015.12.26..
 */
public class Invites extends Fragment {

    private CompanyItem sony;
    private CompanyItem dell;
    private CompanyItem apple;
    private CompanyItem google;

    private ArrayList<CompanyItem> companys;
    private CompListAdapter adapter;
    private ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View x = inflater.inflate(R.layout.fragment_inv, container, false);

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

        list = (ListView) x.findViewById(R.id.invites_list);

        adapter = new CompListAdapter(this.getActivity().getApplicationContext(),companys);

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
