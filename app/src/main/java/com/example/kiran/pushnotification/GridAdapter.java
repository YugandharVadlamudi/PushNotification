package com.example.kiran.pushnotification;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

/**
 * Created by Kiran on 14-03-2016.
 */
public class GridAdapter extends BaseAdapter {
    private static final String TAG = "setOnCheckChangeListnerCalled";
    Context context;
    CheckBox checkBox;
    LayoutInflater layoutInflater;
    boolean[] itemChecked;

    public GridAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        itemChecked = new boolean[Util.name.length];
    }

    @Override
    public int getCount() {
        Log.e("utilLength", "" + Util.name.length);
        return Util.name.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final HolderClass holderClass;
        if (convertView == null) {
            holderClass = new HolderClass();
            convertView = layoutInflater.inflate(R.layout.gridview_items, parent, false);
            holderClass.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            convertView.setTag(holderClass);

        } else {
            holderClass = (HolderClass) convertView.getTag();
            holderClass.checkBox.setFocusableInTouchMode(false);
            /*
            * here is for recycle view so we are making it as false
            * update the view and making it as false
            * */
            if (holderClass.checkBox.isChecked()) {
                holderClass.checkBox.setChecked(false);
            }
            convertView.setTag(holderClass);
        }
        holderClass.checkBox.setText(Util.name[position]);
        /*
        * oncreate view making every check box is
        * false
        * */
        holderClass.checkBox.setChecked(false);

        /*
        * checking with its position wether the checkbox is checked or not
        * */
        if(itemChecked[position])
            holderClass.checkBox.setChecked(true);
        else
            holderClass.checkBox.setChecked(false);
        /*
        * Assigning the Boolean values to the Array for it
        * for checking purpose
        * */
        holderClass.checkBox.setOnClickListener(new View.OnClickListener() {
                                                    @Override
                                                    public void onClick(View v) {
                                                        if (holderClass.checkBox.isChecked())
                                                        {
                                                            itemChecked[position] = true;

                                                        }


                                                        else
                                                            itemChecked[position] = false;
                                                    }
                                                }
        );
        return convertView;
    }

    class HolderClass {
        CheckBox checkBox;
    }
}
