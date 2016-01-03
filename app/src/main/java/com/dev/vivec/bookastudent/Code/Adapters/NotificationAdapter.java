package com.dev.vivec.bookastudent.Code.Adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.dev.vivec.bookastudent.Code.Model.Notification;
import com.dev.vivec.bookastudent.R;

import java.util.ArrayList;

/**
 * Created by user on 1/3/2016.
 */
public class NotificationAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Notification> list;

    public NotificationAdapter (Context c, ArrayList<Notification> list){
        this.context = c;
        this.list = list;
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
            convertView = mInflater.inflate(R.layout.list_notification, null);
        }

        TextView title = (TextView) convertView.findViewById(R.id.notification_list_title);
        TextView date = (TextView) convertView.findViewById(R.id.notification_list_date);
        TextView content = (TextView) convertView.findViewById(R.id.notification_list_content);
        TextView sender = (TextView) convertView.findViewById(R.id.notification_list_sender);

        title.setText(list.get(position).getTitle());
        date.setText(list.get(position).getDate());
        content.setText(list.get(position).getContent());
        sender.setText(list.get(position).getSender());

        if(list.get(position).getIsNew()) {
            title.setTypeface(null, Typeface.BOLD);
            date.setTypeface(null, Typeface.BOLD);
            content.setTypeface(null, Typeface.BOLD);
            sender.setTypeface(null, Typeface.BOLD);
        }

        return convertView;
    }
}
