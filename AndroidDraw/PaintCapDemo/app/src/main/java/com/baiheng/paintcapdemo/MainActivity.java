package com.baiheng.paintcapdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout root = (FrameLayout) findViewById(R.id.root);
        root.addView(new CapView(MainActivity.this));
    }
}
