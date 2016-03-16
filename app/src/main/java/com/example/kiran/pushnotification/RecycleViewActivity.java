package com.example.kiran.pushnotification;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kiran.pushnotification.Adapters.RecycleViewAdapter;

/*
 *Created by Kiran on 15-03-2016.
*/

public class RecycleViewActivity extends Activity {
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycleview);
        recycleViewInitilization();
        layoutMangerInitilization();
    }

    private void layoutMangerInitilization() {
    }

    private void recycleViewInitilization() {
        recyclerView = (RecyclerView) findViewById(R.id.recycleView);
        /*
        * @param Context getApplicationContext
        * @param span in no columns should be displayed
        * */
        layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        RecycleViewAdapter recycleViewAdapter=new RecycleViewAdapter(getApplicationContext());
        recyclerView.setAdapter(recycleViewAdapter);
    }
}
