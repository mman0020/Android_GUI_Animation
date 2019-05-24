package com.baiheng.transitiondemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        getWindow().setSharedElementEnterTransition(changeImageTransform);

    }
}
