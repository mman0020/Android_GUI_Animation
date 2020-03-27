package com.example.zhewen.interpolatordemo;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.os.Bundle;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button mLinearBtn;
    private Button mAcceDeceBtn;
    private Button mAcceBtn;
    private Button mDeceBtn;
    private Button mOverBtn;
    private Button mBounceBtn;
    private Button mPathBtn;

    private ImageView mLinearImg;
    private ImageView mAcceDeceImg;
    private ImageView mAcceImg;
    private ImageView mDeceImg;
    private ImageView mOverImg;
    private ImageView mBounceImg;
    private ImageView mPathImg;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainAcitivity", "this is MainActivity");
        initView();
        startAnim();
    }

    private void initView() {
        mLinearBtn = (Button) findViewById(R.id.linear_interpolator);
        mAcceDeceBtn = (Button) findViewById(R.id.accelerate_decelerate_interpolator);
        mAcceBtn = (Button) findViewById(R.id.accelerate_interpolator);
        mDeceBtn = (Button) findViewById(R.id.decelerate_interpolator);
        mOverBtn = (Button) findViewById(R.id.overshoot_interpolator);
        mBounceBtn = (Button) findViewById(R.id.bounce_interpolator);
        mPathBtn = (Button) findViewById(R.id.path_interpolator);

        mLinearImg = (ImageView) findViewById(R.id.img_linear_interpolator);
        mAcceDeceImg = (ImageView) findViewById(R.id.img_accelerate_decelerate_interpolator);
        mAcceImg = (ImageView) findViewById(R.id.img_accelerate_interpolator);
        mDeceImg = (ImageView) findViewById(R.id.img_decelerate_interpolator);
        mOverImg = (ImageView) findViewById(R.id.img_overshoot_interpolator);
        mBounceImg = (ImageView) findViewById(R.id.img_bounce_interpolator);
        mPathImg = (ImageView) findViewById(R.id.img_path_interpolator);
    }

    private void startAnim() {
        mLinearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(mLinearImg, "translationX", 0,500);
                animator.setDuration(2000);
                animator.setInterpolator(new LinearInterpolator());
                animator.start();
            }
        });

        mAcceDeceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(mAcceDeceImg, "translationX", 0,500);
                animator1.setDuration(2000);
                animator1.setInterpolator(new AccelerateDecelerateInterpolator());
                animator1.start();
            }
        });

        mAcceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator2 = ObjectAnimator.ofFloat(mAcceImg, "translationX", 0,500);
                animator2.setDuration(2000);
                animator2.setInterpolator(new AccelerateInterpolator());
                animator2.start();
            }
        });

        mDeceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator3 = ObjectAnimator.ofFloat(mDeceImg, "translationX", 0,500);
                animator3.setDuration(2000);
                animator3.setInterpolator(new DecelerateInterpolator());
                animator3.start();
            }
        });

        mOverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator4 = ObjectAnimator.ofFloat(mOverImg, "translationX", 0,500);
                animator4.setDuration(2000);
                animator4.setInterpolator(new OvershootInterpolator());
                animator4.start();
            }
        });

        mBounceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator5 = ObjectAnimator.ofFloat(mBounceImg, "translationX", 0,500);
                animator5.setDuration(2000);
                animator5.setInterpolator(new BounceInterpolator());
                animator5.start();
            }
        });

        mPathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Path interpolatorPath = new Path();
                interpolatorPath.lineTo(0.25f, 0.25f);
                interpolatorPath.lineTo(0.25f, 1.25f);
                interpolatorPath.lineTo(1f, 1f);
                ObjectAnimator animator6 = ObjectAnimator.ofFloat(mPathImg, "translationX", 0,500);
                animator6.setDuration(2000);
                Interpolator interpolator = PathInterpolatorCompat.create(interpolatorPath);
                animator6.setInterpolator(interpolator);
                animator6.start();
            }
        });
    }

}
