package com.baiheng.transitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;

public class CustomVisibilityActivity extends AppCompatActivity {

    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_custom_visibility);
        mImage = (ImageView) findViewById(R.id.image_fab);

        TransitionSet cotentTransition=new TransitionSet();
        Slide slide=new Slide(Gravity.LEFT);
        slide.setDuration(500);
        FABTransition fabTransition=new FABTransition(mImage,this);
        fabTransition.addTarget(R.id.image_fab);
        fabTransition.setDuration(500);
        cotentTransition.addTransition(fabTransition);
        getWindow().setEnterTransition(cotentTransition);
    }
}
