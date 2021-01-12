package com.example.flipapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flipapplication.R;


import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class FlipViewAdapter extends BaseAdapter {

    private AppCompatActivity appCompatActivity;
    private List<String> strings;
    private int[] drawableIds = {R.drawable.wedding3,R.drawable.wedding5,R.drawable.wedding1,R.drawable.wedding3
           };

    public FlipViewAdapter(AppCompatActivity appCompatActivity,List<String> strings) {
        super();
        this.strings = strings;
        this.appCompatActivity = appCompatActivity;
    }

    @Override
    public int getCount() {
        return strings.size();
    }

    @Override
    public String getItem(int position) {
        return strings.get(position);
    }

    @Override
    public long getItemId(int position) {
        return strings.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) appCompatActivity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.item_page, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }

       // holder.textView.setText(getItem(position));
        holder.imageView.setImageResource(drawableIds[position]);

        return convertView;
    }

    private static class ViewHolder {
      //  private TextView textView;
        private ImageView imageView;

        public ViewHolder(View v) {
            imageView = (ImageView)v.findViewById(R.id.image);
          //  textView = (TextView) v.findViewById(R.id.text);
        }
    }
}