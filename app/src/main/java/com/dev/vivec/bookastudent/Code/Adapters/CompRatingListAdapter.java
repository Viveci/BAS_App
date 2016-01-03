package com.dev.vivec.bookastudent.Code.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Model.CompanyRating;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 1/3/2016.
 */
public class CompRatingListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<CompanyRating> list;

    public CompRatingListAdapter(Context context, ArrayList<CompanyRating> comp){
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
            convertView = mInflater.inflate(R.layout.list_comp_rating, null);
        }

        TextView label = (TextView) convertView.findViewById(R.id.list_comp_rating_label);

        ArrayList<ImageView> stars = new ArrayList<>();
        stars.add((ImageView)convertView.findViewById(R.id.list_comp_rating_star1));
        stars.add((ImageView)convertView.findViewById(R.id.list_comp_rating_star2));
        stars.add((ImageView)convertView.findViewById(R.id.list_comp_rating_star3));
        stars.add((ImageView)convertView.findViewById(R.id.list_comp_rating_star4));
        stars.add((ImageView) convertView.findViewById(R.id.list_comp_rating_star5));

        label.setText(list.get(position).getTitle());
        double rating = list.get(position).getRating();
        for(int i = 1; i < (stars.size()+1); i++){
            if(i<=rating){
                stars.get(i-1).setImageResource(R.drawable.ic_star_full);
            }
            else if(rating+0.5 == (i)){
                stars.get(i-1).setImageResource(R.drawable.ic_star_half);
            }
            else if( rating < i){
                stars.get(i-1).setImageResource(R.drawable.ic_star_empty);
            }
        }

        return convertView;
    }
}
