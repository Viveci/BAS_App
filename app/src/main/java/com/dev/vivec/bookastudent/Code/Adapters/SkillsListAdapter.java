package com.dev.vivec.bookastudent.Code.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Model.SkillsKeys;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 1/9/2016.
 */
public class SkillsListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<SkillsKeys> list;

    public SkillsListAdapter(Context context, ArrayList<SkillsKeys> comp){
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
            convertView = mInflater.inflate(R.layout.list_skills, null);
        }

        TextView label = (TextView) convertView.findViewById(R.id.list_skills_label);

        SkillsKeys sr = list.get(position);

        label.setText(sr.getSkill());

        return convertView;
    }
}
