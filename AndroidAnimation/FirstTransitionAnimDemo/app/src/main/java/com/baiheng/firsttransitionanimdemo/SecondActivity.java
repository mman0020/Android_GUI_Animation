package com.baiheng.firsttransitionanimdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.view.Window;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_second);
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        // inflate from xml
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        // or create directly
//        Fade fade = new Fade();
//        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);
    }
}
