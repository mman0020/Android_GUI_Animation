package com.vivo.wenruan.circleprogress;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mPoint_1;
    private LinearLayout mPoint_2;
    private LinearLayout mPoint_3;
    private LinearLayout mPoint_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPoint_1 = (LinearLayout) findViewById(R.id.ll_point_circle_1);
        mPoint_2 = (LinearLayout) findViewById(R.id.ll_point_circle_2);
        mPoint_3 = (LinearLayout) findViewById(R.id.ll_point_circle_3);
        mPoint_4 = (LinearLayout) findViewById(R.id.ll_point_circle_4);

        Button startAni = (Button) findViewById(R.id.start_ani_2);
        startAni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beginPropertyAni();
            }
        });
    }

    private void beginPropertyAni() {
        ObjectAnimator animator_1 = ObjectAnimator.ofFloat(mPoint_1, "rotation", 0, 360) ;
        animator_1.setDuration(2000);
        animator_1.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator animator_2 = ObjectAnimator.ofFloat(mPoint_2, "rotation", 0, 360);
        animator_2.setStartDelay(150);
        animator_2.setDuration(2000 + 150);
        animator_2.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator animator_3 = ObjectAnimator.ofFloat(mPoint_3, "rotation", 0, 360);
        animator_3.setStartDelay(2 * 150);
        animator_3.setDuration(2000 + 2 * 150);
        animator_3.setInterpolator(new AccelerateDecelerateInterpolator());

        ObjectAnimator animator_4 = ObjectAnimator.ofFloat(mPoint_4, "rotation", 0, 360);
        animator_4.setStartDelay(3 * 150);
        animator_4.setDuration(2000 + 3 * 150);
        animator_4.setInterpolator(new AccelerateDecelerateInterpolator());

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator_1).with(animator_2).with(animator_3).with(animator_4);
        animatorSet.start();
    }
}
