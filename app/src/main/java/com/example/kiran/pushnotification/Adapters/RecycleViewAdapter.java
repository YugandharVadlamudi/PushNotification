package com.example.kiran.pushnotification.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;

import com.example.kiran.pushnotification.NameModel;
import com.example.kiran.pushnotification.R;
import com.example.kiran.pushnotification.Util;

import java.util.ArrayList;

/**
 * Created by Kiran on 15-03-2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.RecycleViewHolder>
                                /*implements CompoundButton.OnCheckedChangeListener*/ {
    Context context;
    View view;
    public static ArrayList<NameModel> arrNames;

    public RecycleViewAdapter(Context context) {
        this.context = context;
//        return array list
        arrNames = Util.getNames();
    }

    /*
    * creating the new views for representation
    * */
    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("ViewGroup", "" + parent + "::ViewType::" + viewType);
        view = LayoutInflater.from(context).inflate(R.layout.gridview_items, parent, false);
//        RecycleViewHolder recycleViewHolder = ;
        return new RecycleViewHolder(view, context);
    }

    /*
    * binding the data to views which means updating the view data
    * */
    @Override
    public void onBindViewHolder(final RecycleViewHolder holder, final int position) {
        Log.e("onBindView", "onBindViewHolder::" + holder + "position" + position);
/*
* here accessing the object from object we are accessing the value
* */
        holder.checkBox.setText(arrNames.get(position).name);
        if(arrNames.get(position).isChecked)
            holder.checkBox.setChecked(true);
        else
            holder.checkBox.setChecked(false);
               holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrNames.get(position).isChecked = holder.checkBox.isChecked();
            }
        });

    }

    /*
    * populating the how much data we will populate
    * */
    @Override
    public int getItemCount() {
        return arrNames.size();
    }


    public class RecycleViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public CheckBox checkBox;
        Context context;
        public RecycleViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;
            checkBox = (CheckBox) itemView.findViewById(R.id.checkBox);
        }
    }

}
