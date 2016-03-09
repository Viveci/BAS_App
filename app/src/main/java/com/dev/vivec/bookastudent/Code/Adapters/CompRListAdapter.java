package com.dev.vivec.bookastudent.Code.Adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Model.CompanyItem;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 3/9/2016.
 */
public class CompRListAdapter extends RecyclerView.Adapter<CompRListAdapter.JobViewHolder>{

    private ArrayList<CompanyItem> list;

    public CompRListAdapter(ArrayList<CompanyItem> list){
        this.list = list;
    }

    public static class JobViewHolder extends RecyclerView.ViewHolder {
        public CardView cv;
        public TextView JobTitle;
        public TextView JobLocation;
        public TextView JobDesc;
        public TextView JobStart;
        public TextView JobDeadLine;
        public TextView JobType;
        public TextView JobAmmount;
        public TextView JobPosition;
        public ImageView Logo;

        JobViewHolder(View itemView) {
            super(itemView);
            cv = (CardView)itemView.findViewById(R.id.cv);
            JobTitle = (TextView)itemView.findViewById(R.id.list_r_comp_title);
            JobLocation = (TextView)itemView.findViewById(R.id.list_r_comp_location);
            JobDesc = (TextView)itemView.findViewById(R.id.list_r_comp_desc);
            JobStart = (TextView)itemView.findViewById(R.id.list_r_comp_start);
            JobDeadLine = (TextView)itemView.findViewById(R.id.list_r_comp_application);
            JobType = (TextView)itemView.findViewById(R.id.list_r_comp_type);
            JobAmmount = (TextView)itemView.findViewById(R.id.list_r_comp_ammount);
            JobPosition = (TextView)itemView.findViewById(R.id.list_r_comp_position);
            Logo = (ImageView) itemView.findViewById(R.id.list_r_comp_image);
        }
    }

    @Override
    public JobViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_r_comp, viewGroup, false);
        JobViewHolder pvh = new JobViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(JobViewHolder holder, int position) {
        holder.JobTitle.setText(list.get(position).getCompany());
        holder.JobDesc.setText(list.get(position).getDesc());
        holder.JobPosition.setText(list.get(position).getType());
        holder.Logo.setImageResource(list.get(position).getIcon());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
