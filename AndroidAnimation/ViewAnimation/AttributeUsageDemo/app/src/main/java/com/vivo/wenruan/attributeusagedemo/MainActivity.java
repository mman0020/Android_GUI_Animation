package com.vivo.wenruan.attributeusagedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button scaleBtn;
    private Animation scaleAnimation;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);
        scaleBtn = (Button) findViewById(R.id.btn_animation);
        tv = (TextView) findViewById(R.id.tv);
        scaleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.startAnimation(scaleAnimation);
            }
        });
    }
}
