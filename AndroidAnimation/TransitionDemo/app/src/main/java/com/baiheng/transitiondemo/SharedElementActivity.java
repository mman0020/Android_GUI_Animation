package com.baiheng.transitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.ChangeClipBounds;
import android.transition.ChangeImageTransform;
import android.transition.TransitionSet;
import android.view.Window;

public class SharedElementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_shared_element);

        ChangeImageTransform changeImageTransform = new ChangeImageTransform();
        ChangeBounds changeBounds = new ChangeBounds();
        ChangeClipBounds changeClipBounds = new ChangeClipBounds();
        TransitionSet transitionSet=new TransitionSet();


        transitionSet.addTransition(changeImageTransform);
//        transitionSet.addTransition(changeBounds);
        transitionSet.addTransition(changeClipBounds);
        transitionSet.addTarget(R.id.image);
        transitionSet.setDuration(1000);
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementReturnTransition(transitionSet);
    }
}
