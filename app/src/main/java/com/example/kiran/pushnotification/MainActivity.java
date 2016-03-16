package com.example.kiran.pushnotification;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    TextView tv;
    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initilization();
        gridViewAdapterSet();
    }

    private void gridViewAdapterSet() {
        GridAdapter gridAdapter = new GridAdapter(getApplicationContext());
        gridView.setAdapter(gridAdapter);

    }

    private void initilization() {
        gridView = (GridView) findViewById(R.id.gv_image_check);
        tv=(TextView)findViewById(R.id.tv_display_check_Box);
    }
}
