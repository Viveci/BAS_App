package com.dev.vivec.bookastudent.Code.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Model.User;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 1/6/2016.
 */
public class UserDBListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<User> list;

    public UserDBListAdapter(Context context, ArrayList<User> comp){
        this.context = context;
        this.list = comp;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_user, null);
        }

        TextView name = (TextView) convertView.findViewById(R.id.user_name);
        TextView cpr = (TextView) convertView.findViewById(R.id.user_cpr);
        TextView email = (TextView) convertView.findViewById(R.id.user_email);
        TextView role = (TextView) convertView.findViewById(R.id.user_role);
        FrameLayout color = (FrameLayout) convertView.findViewById(R.id.user_color);

        User u = list.get(position);

        name.setText(u.getUsername());
        cpr.setText(u.getCPR());
        email.setText(u.getEmail());
        role.setText(u.getRole());

        if(u.getRole().equals("company")){
            color.setBackgroundColor(color.getResources().getColor(R.color.bcg_blue_norm));
            role.setTextColor(color.getResources().getColor(R.color.bcg_blue_norm));
        }
        else if(u.getRole().equals("student")){
            color.setBackgroundColor(color.getResources().getColor(R.color.bcg));
            role.setTextColor(color.getResources().getColor(R.color.bcg));
        }
        else if(u.getRole().equals("admin")){
            color.setBackgroundColor(color.getResources().getColor(R.color.admin));
            role.setTextColor(color.getResources().getColor(R.color.admin));
        }


        return convertView;
    }
}
