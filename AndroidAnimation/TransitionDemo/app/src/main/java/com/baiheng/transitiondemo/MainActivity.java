package com.baiheng.transitiondemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeImageTransform;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.regex.Matcher;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mTextView;
    private TextView mTextView1;
    private TextView mTextView2;
    private TextView mTextView3;
    private ImageView mImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.tv_start_second_activity);
        mTextView1 = (TextView) findViewById(R.id.tv_start_shared_element_activity);
        mTextView2 = (TextView) findViewById(R.id.tv_start_custom_transition_activity);
        mTextView3 = (TextView) findViewById(R.id.tv_start_custom_visibility_activity);
        mImage = (ImageView) findViewById(R.id.image);
        mTextView.setOnClickListener(this);
        mTextView1.setOnClickListener(this);
        mTextView2.setOnClickListener(this);
        mTextView3.setOnClickListener(this);
        setupWindowAnimations();
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.tv_start_second_activity:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
//                ActivityOptions compat = ActivityOptions.makeScaleUpAnimation(mImage, 0, -300,0,0);
//                ActivityCompat.startActivity(MainActivity.this, new Intent(MainActivity.this, SecondActivity.class), compat.toBundle());
//                ActivityOptions compat = ActivityOptions.makeThumbnailScaleUpAnimation(mTextView,BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher),0,0);
//                startActivity( new Intent(MainActivity.this, SecondActivity.class), compat.toBundle());
                break;
            case R.id.tv_start_shared_element_activity:
                Intent intent1 = new Intent(MainActivity.this, SharedElementActivity.class);
                startActivity(intent1, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,mImage,"image").toBundle());
                break;
            case R.id.tv_start_custom_transition_activity:
                Intent intent2 = new Intent(MainActivity.this, CustomTransitionActivity.class);
                startActivity(intent2, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this, mImage,mImage.getTransitionName()).toBundle());
                break;
            case R.id.tv_start_custom_visibility_activity:
                Intent intent3 = new Intent(MainActivity.this, CustomVisibilityActivity.class);
                startActivity(intent3, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
                break;
        }
    }

    private void setupWindowAnimations() {
        // inflate from xml
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
        Fade fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
        // or create directly
//        Slide slide = new Slide();
//        slide.setDuration(1000);
        slide.setSlideEdge(Gravity.LEFT);
//        getWindow().setAllowEnterTransitionOverlap(true);
//        getWindow().setAllowReturnTransitionOverlap(true);
        getWindow().setExitTransition(slide);
        getWindow().setReenterTransition(fade);


//        ChangeImageTransform changeImageTransform = new ChangeImageTransform();
//        getWindow().setSharedElementExitTransition(changeImageTransform);
    }
}
