package com.example.listapaises;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCountry extends BaseAdapter {
    protected Activity activity;

    protected ArrayList<Country> items;

    public AdapterCountry (Activity activity, ArrayList<Country> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if(convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.items_list, null);
        }

        Country country = items.get(position);
        ImageView flag = (ImageView) v.findViewById(R.id.imageView_flag);
        flag.setImageDrawable(country.getFlag());
        TextView name = (TextView) v.findViewById(R.id.textView_name);
        name.setText(country.getName());

        return v;
    }
}
