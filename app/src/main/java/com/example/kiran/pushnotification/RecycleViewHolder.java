package com.example.kiran.pushnotification;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kiran.pushnotification.Adapters.RecycleViewAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
//        checkBoxState=true;
    }
}
