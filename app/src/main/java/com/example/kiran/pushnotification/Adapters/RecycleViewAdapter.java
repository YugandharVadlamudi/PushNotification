package com.example.kiran.pushnotification.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kiran.pushnotification.NameModel;
import com.example.kiran.pushnotification.R;
import com.example.kiran.pushnotification.RecycleViewHolder;
import com.example.kiran.pushnotification.Util;

import java.util.ArrayList;

/**
 * Created by Kiran on 15-03-2016.
 */
public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewHolder> {
Context context;
    View view;
    public static ArrayList<NameModel> arrNames;
    public RecycleViewAdapter(Context context) {
        this.context=context;
        arrNames = Util.getNames();
    }
    /*
    * creating the new views for representation
    * */
    @Override
    public RecycleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("ViewGroup",""+parent+"::ViewType::"+viewType);
        view= LayoutInflater.from(context).inflate(R.layout.gridview_items,parent,false);
        RecycleViewHolder recycleViewHolder=new RecycleViewHolder(view,context);
        return recycleViewHolder;
    }
    /*
    * binding the data to views which means updateing the view data
    * */
    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        Log.e("onBindView", "onBindViewHolder::"+holder+"position"+position);
//        holder.checkBox.setChecked(true);
//        if(holder.checkBoxState==true)
//        {
//            holder.checkBox.setChecked(true);
//        }
//        else {
//            holder.checkBox.setChecked(false);
//        }
        holder.checkBox.setText(arrNames.get(position).name);
        if(arrNames.get(position).isChecked){
            holder.checkBox.setChecked(true);
        }
        holder.checkBox.setTag(position);
    }
    /*
    * populating the how much data we will populate
    * */
    @Override
    public int getItemCount() {
        return arrNames.size();
    }
}
