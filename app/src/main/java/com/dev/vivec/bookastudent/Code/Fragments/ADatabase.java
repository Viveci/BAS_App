package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dev.vivec.bookastudent.Code.Adapters.UserDBListAdapter;
import com.dev.vivec.bookastudent.Code.Model.User;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 12/31/2015.
 */
public class ADatabase extends Fragment {

    private RadioButton student;
    private RadioButton company;
    private RadioButton admin;

    private ImageButton button;
    private EditText search;

    private ListView list;

    private UserDBListAdapter adpater;
    private ArrayList<User> users;

    public ADatabase(){};

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View x = inflater.inflate(R.layout.fragment_admin_database, container, false);

        //Do stuff here

        student = (RadioButton) x.findViewById(R.id.admin_db_student);
        student.setChecked(false);
        company = (RadioButton) x.findViewById(R.id.admin_db_company);
        company.setChecked(false);
        admin = (RadioButton) x.findViewById(R.id.admin_db_admin);
        admin.setChecked(false);

        button = (ImageButton) x.findViewById(R.id.admin_db_search);
        search = (EditText) x.findViewById(R.id.admin_db_searchtext);

        list = (ListView) x.findViewById(R.id.admin_db_userlist);

        users = new ArrayList<>();
        users.add(new User("Márton","123345-12","asd@gmail.com","student"));
        users.add(new User("Fruzsina","123345-12","asd@gmail.com","student"));
        users.add(new User("Peter","123345-12","asd@gmail.com","student"));
        users.add(new User("Dell","123345-12","asd@gmail.com","company"));
        users.add(new User("Martin","123345-12","asd@gmail.com","student"));
        users.add(new User("Neculai","123345-12","asd@gmail.com","admin"));
        users.add(new User("Harry","123345-12","asd@gmail.com","admin"));
        users.add(new User("Dell","123345-12","asd@gmail.com","company"));
        users.add(new User("Apple","123345-12","asd@gmail.com","company"));
        users.add(new User("BookAStudent","123345-12","asd@gmail.com","company"));

        adpater = new UserDBListAdapter(getActivity().getApplicationContext(),users);
        list.setAdapter(adpater);

        student.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ArrayList<User> nlist = new ArrayList<>();
                for (User u : users) {
                    if (u.getRole().equals("student")) {
                        nlist.add(u);
                    }
                }
                adpater = new UserDBListAdapter(getActivity().getApplicationContext(), nlist);
                list.setAdapter(adpater);
            }
        });

        company.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ArrayList<User> nlist = new ArrayList<>();
                for(User u : users){
                    if(u.getRole().equals("company")){
                        nlist.add(u);
                    }
                }
                adpater = new UserDBListAdapter(getActivity().getApplicationContext(),nlist);
                list.setAdapter(adpater);
            }
        });

        admin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ArrayList<User> nlist = new ArrayList<>();
                for (User u : users) {
                    if (u.getRole().equals("admin")) {
                        nlist.add(u);
                    }
                }
                adpater = new UserDBListAdapter(getActivity().getApplicationContext(), nlist);
                list.setAdapter(adpater);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!search.getText().toString().isEmpty()){
                    ArrayList<User> nlist = new ArrayList<>();
                    for (User u : users) {
                        if (u.getUsername().equals(search.getText().toString())) {
                            nlist.add(u);
                        }
                    }
                    adpater = new UserDBListAdapter(getActivity().getApplicationContext(), nlist);
                    list.setAdapter(adpater);
                }
                else{
                    adpater = new UserDBListAdapter(getActivity().getApplicationContext(),users);
                    list.setAdapter(adpater);
                }
            }
        });

        return x;
    }

    public void onPause(){
        super.onPause();
    }

    public void onResume(){
        super.onResume();
    }

}
