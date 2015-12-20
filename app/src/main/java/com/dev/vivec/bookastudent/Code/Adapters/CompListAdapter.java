package com.dev.vivec.bookastudent.Code.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Model.CompanyItem;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by Teperics Márton on 2015.11.13..
 */
public class CompListAdapter  extends BaseAdapter {

        private Context context;
        private ArrayList<CompanyItem> companylist;

        public CompListAdapter(Context context, ArrayList<CompanyItem> comp){
            this.context = context;
            this.companylist = comp;
        }

        @Override
        public int getCount() {
            return companylist.size();
        }

        @Override
        public Object getItem(int position) {
            return companylist.get(position);
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
                convertView = mInflater.inflate(R.layout.list_comp, null);
            }

            ImageView imgIcon = (ImageView) convertView.findViewById(R.id.list_comp_img);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.list_comp_title);
            TextView txttype = (TextView) convertView.findViewById(R.id.list_comp_type);
            TextView txtdesc = (TextView) convertView.findViewById(R.id.list_comp_desc);

            imgIcon.setImageResource(companylist.get(position).getIcon());
            txtTitle.setText(companylist.get(position).getCompany());
            txttype.setText(companylist.get(position).getType());
            txtdesc.setText(companylist.get(position).getDesc());

            return convertView;
        }

    }
