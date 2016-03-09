package com.dev.vivec.bookastudent.Code.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Model.Education;
import com.dev.vivec.bookastudent.Code.Model.Language;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 2/17/2016.
 */
public class LanguageListAdapter extends BaseAdapter  {

        private Context context;
        private ArrayList<Language> list;

        public LanguageListAdapter(Context context, ArrayList<Language> lang){
            this.context = context;
            this.list = lang;
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
                convertView = mInflater.inflate(R.layout.list_language, null);
            }

            TextView label = (TextView) convertView.findViewById(R.id.language_list_language);
            TextView level = (TextView) convertView.findViewById(R.id.language_list_level);

            Language sr = list.get(position);

            label.setText(sr.getLanguage());
            level.setText(sr.getLevel());

            return convertView;
        }
}
