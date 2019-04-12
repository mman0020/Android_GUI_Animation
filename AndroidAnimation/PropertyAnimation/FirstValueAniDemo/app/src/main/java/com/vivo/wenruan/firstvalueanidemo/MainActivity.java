package com.vivo.wenruan.firstvalueanidemo;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn_start_ani);
        textView = (TextView) findViewById(R.id.tv_hello_today);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator animator = ValueAnimator.ofInt(0, 400);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue =(int) animation.getAnimatedValue();
                        textView.layout(curValue,curValue,curValue + textView.getWidth(), curValue + textView.getHeight());
                    }
                });
                animator.setDuration(3000);
                animator.setInterpolator(new AccelerateDecelerateInterpolator());
                animator.start();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked me", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
