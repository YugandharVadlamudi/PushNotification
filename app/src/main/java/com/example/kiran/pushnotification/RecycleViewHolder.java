package com.example.kiran.pushnotification;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kiran.pushnotification.Adapters.RecycleViewAdapter;

/**
 * Created by Kiran on 16-03-2016.
 */
/*
* This view holder class is for the Recycle view
* items which we are going to display
* */
public class RecycleViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{
    public ImageView imageView;
    public CheckBox checkBox;
//    public boolean checkBoxState;
    Context context;
    public RecycleViewHolder(View itemView,Context context) {
        super(itemView);
        this.context=context;
        checkBox=(CheckBox)itemView.findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                int position = (int) buttonView.getTag();
                NameModel nameModel = RecycleViewAdapter.arrNames.get(position);
                nameModel.isChecked = isChecked;
                RecycleViewAdapter.arrNames.set(position, nameModel);
            }
        });
        Log.e("View", "RecycleViewHolder:"+itemView);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, ""+checkBox.getText(), Toast.LENGTH_SHORT).show();
        int position=(int)v.getTag();
        NameModel nameModel=RecycleViewAdapter.arrNames.get(position);
        nameModel.isChecked=true;
        RecycleViewAdapter.arrNames.set(position,nameModel);
//        checkBoxState=true;
    }
}
