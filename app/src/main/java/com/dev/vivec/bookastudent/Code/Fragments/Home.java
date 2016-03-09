package com.dev.vivec.bookastudent.Code.Fragments;

/**
 * Created by Teperics Márton on 2015.11.10..
 */

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
        import android.view.ViewGroup;
import android.widget.AbsoluteLayout;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.dev.vivec.bookastudent.Code.Adapters.EducationListAdapter;
import com.dev.vivec.bookastudent.Code.Adapters.LanguageListAdapter;
import com.dev.vivec.bookastudent.Code.Adapters.SkillsListAdapter;
import com.dev.vivec.bookastudent.Code.Model.Education;
import com.dev.vivec.bookastudent.Code.Model.Language;
import com.dev.vivec.bookastudent.Code.Model.SkillsKeys;
import com.dev.vivec.bookastudent.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Home extends android.support.v4.app.Fragment{

    private Toolbar toolbar;
    private ListView skills;
    private ListView languages;
    private ListView edu;
    private TextView name;

    private String nameT;

    public Home(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        toolbar.setTitle("Profile");

        nameT = "Default";

        //Connecting TextViews
        name = (TextView) rootView.findViewById(R.id.profile_userName);





        //Fetching Bundle
        if(this.getArguments()!=null) {
            Bundle bundle = this.getArguments();
            String nameT = bundle.getString("NAME");
        }


        //Filling up TextViews
        name.setText(nameT);


        //ListViews
        skills = (ListView) rootView.findViewById(R.id.profile_skillskeys_list);

        ArrayList<SkillsKeys> skillslist = new ArrayList<>();
        skillslist.add(new SkillsKeys("Video editing"));
        skillslist.add(new SkillsKeys("Sound editing"));
        skillslist.add(new SkillsKeys("Book a student"));

        SkillsListAdapter adapter = new SkillsListAdapter(getActivity().getApplicationContext(),skillslist);
        skills.setAdapter(adapter);
        setListViewHeightBasedOnChildren(skills);

        edu = (ListView) rootView.findViewById(R.id.profile_edu_list);

        final ArrayList<Education> eduList = new ArrayList<>();
        eduList.add(new Education("Via"));
        eduList.add(new Education("Bme"));
        eduList.add(new Education("DTK"));

        EducationListAdapter eduAdapter = new EducationListAdapter((getActivity().getApplicationContext()),eduList);
        edu.setAdapter(eduAdapter);
        edu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity().getApplicationContext(), eduList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        setListViewHeightBasedOnChildren(edu);

        languages = (ListView) rootView.findViewById(R.id.profile_language_list);

        ArrayList<Language> langList = new ArrayList<>();
        langList.add(new Language("Hungarian","Proficient"));
        langList.add(new Language("English","Proficient"));
        langList.add(new Language("German","Noob"));

        LanguageListAdapter langAdapter = new LanguageListAdapter(getActivity().getApplicationContext(),langList);
        languages.setAdapter(langAdapter);
        setListViewHeightBasedOnChildren(languages);

        return rootView;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }

    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, AbsoluteLayout.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
