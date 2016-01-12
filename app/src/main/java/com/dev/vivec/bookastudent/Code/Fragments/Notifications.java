package com.dev.vivec.bookastudent.Code.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dev.vivec.bookastudent.Code.Adapters.NotificationAdapter;
import com.dev.vivec.bookastudent.Code.Model.Notification;
import com.dev.vivec.bookastudent.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Teperics Márton on 2015.12.26..
 */
public class Notifications extends Fragment {

    private Toolbar toolbar;
    private ListView list;
    private ArrayList<Notification> notifications;
    private NotificationAdapter adapter;

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

        notifications = new ArrayList<>();

        Notification n = new Notification("New job","2015/01/03","Dell","Lorem ipsum dolor sit amet," +
                " ius id iudicabit liberavisse, has at laboramus intellegat. Et m",true);
        Notification m = new Notification("New job","2015/01/03","Dell","Lorem ipsum dolor sit amet," +
                " ius id iudicabit liberavisse, has at laboramus intellegat. Et m",false);
        notifications.add(n);
        notifications.add(m);
        notifications.add(n);
        notifications.add(m);
        notifications.add(n);
        notifications.add(m);
        notifications.add(n);

        adapter = new NotificationAdapter(this.getActivity().getApplicationContext(),notifications);
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
