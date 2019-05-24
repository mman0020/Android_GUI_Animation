package com.baiheng.firsttransitionanimdemo;

import android.os.CpuUsageInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class CustomTransitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_custom_transition);
        executeTransition();
    }

    public void executeTransition() {
        ColorTransition transition = new ColorTransition(0xff000000,0xffffcc22);
        transition.setDuration(3000);
        transition.addTarget("img");
        getWindow().setSharedElementEnterTransition(transition);

    }
}
