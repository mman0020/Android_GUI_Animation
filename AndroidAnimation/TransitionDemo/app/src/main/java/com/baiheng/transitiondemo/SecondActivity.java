package com.baiheng.transitiondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_second);
        mTextView = (TextView) findViewById(R.id.tv_second_activity);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAfterTransition();
                finish();
//                finishAfterTransition();
            }
        });
        setupWindowAnimations();
    }

    private void setupWindowAnimations() {
        // inflate from xml
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        fade.excludeTarget(android.R.id.navigationBarBackground,true);
        fade.excludeTarget(android.R.id.statusBarBackground,true);

        // or create directly
//        Fade fade = new Fade();
//        fade.setDuration(1000);
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
        slide.setSlideEdge(Gravity.LEFT);
        slide.setDuration(2000);
        slide.excludeTarget(android.R.id.navigationBarBackground, true);
        slide.excludeTarget(android.R.id.statusBarBackground,true);
        slide.removeTarget(mTextView);
        getWindow().setEnterTransition(slide);
        getWindow().setReturnTransition(slide);
//        getWindow().setReenterTransition(fade);
//        getWindow().setExitTransition(slide);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAfterTransition();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAfterTransition();
    }
}
