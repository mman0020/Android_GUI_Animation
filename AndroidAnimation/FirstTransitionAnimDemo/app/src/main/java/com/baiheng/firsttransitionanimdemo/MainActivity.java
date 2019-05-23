package com.baiheng.firsttransitionanimdemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);
        setupWindowAnimations();
        final TextView textView = (TextView) findViewById(R.id.start_activity);
        final TextView textView1 = (TextView) findViewById(R.id.start_shared_activity);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//                startActivity(intent);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this).toBundle());
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SharedElementActivity.class);
                Pair<View, String> p1 = Pair.create((View)textView1, "profile");
                Pair<View, String> p2 = Pair.create((View)textView, "test");

                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,p1,p2).toBundle());
            }
        });
    }





    private void setupWindowAnimations() {
        // inflate from xml
        Slide slide = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
        // or create directly
//        Slide slide = new Slide();
//        slide.setDuration(1000);

        slide.setSlideEdge(Gravity.LEFT);
        getWindow().setAllowEnterTransitionOverlap(true);
        getWindow().setAllowReturnTransitionOverlap(true);
        getWindow().setExitTransition(slide);
        getWindow().setReenterTransition(slide);
    }
}
