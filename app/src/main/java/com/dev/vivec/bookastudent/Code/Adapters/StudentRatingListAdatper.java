package com.dev.vivec.bookastudent.Code.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Model.CompanyRating;
import com.dev.vivec.bookastudent.Code.Model.StudentRating;
import com.dev.vivec.bookastudent.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by user on 1/6/2016.
 */
public class StudentRatingListAdatper extends BaseAdapter {

    private Context context;
    private ArrayList<StudentRating> list;

    public StudentRatingListAdatper(Context context, ArrayList<StudentRating> comp){
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
            convertView = mInflater.inflate(R.layout.list_student_rating, null);
        }

        TextView label = (TextView) convertView.findViewById(R.id.student_list_label);
        TextView rating = (TextView) convertView.findViewById(R.id.student_list_rating);
        ProgressBar bar = (ProgressBar) convertView.findViewById(R.id.student_rating_progres);

        StudentRating sr = list.get(position);

        label.setText(sr.getLabel());
        rating.setText(""+sr.getRating());
        bar.setProgress(sr.getRating());



        return convertView;
    }
}
