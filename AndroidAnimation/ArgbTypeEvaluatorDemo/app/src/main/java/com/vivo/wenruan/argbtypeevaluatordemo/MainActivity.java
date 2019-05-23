package com.vivo.wenruan.argbtypeevaluatordemo;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final int GRADIENT_ANIM_DURATION = 2000;

    private TextView mEffectView;
    private Button mTypicalColorButton;
    private Button mCustomColorButton;
    private Button mCustomPositionButton;
    private Button mResetStateButton;

    private ValueAnimator mGradientAnimator = null;
    private ValueAnimator mTranslateAnimator = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initClick();
    }

    private void initData() {
        mEffectView = (TextView) findViewById(R.id.effectview);
        mTypicalColorButton = (Button) findViewById(R.id.typical_color_btn);
        mCustomColorButton = (Button) findViewById(R.id.custom_color_btn);
        mCustomPositionButton = (Button) findViewById(R.id.custom_position_btn);
        mResetStateButton = (Button) findViewById(R.id.reset_btn);
    }

    private void initClick() {
        mEffectView.setOnClickListener(mClickListener);
        mTypicalColorButton.setOnClickListener(mClickListener);
        mCustomColorButton.setOnClickListener(mClickListener);
        mCustomPositionButton.setOnClickListener(mClickListener);
        mResetStateButton.setOnClickListener(mClickListener);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = v.getId();

            switch (id) {
                case R.id.typical_color_btn:
                    if (mGradientAnimator != null && mGradientAnimator.isRunning()) {
                        break;
                    }
                    final int startColor = Color.WHITE;
                    final int endColor = Color.RED;

                    mGradientAnimator = ValueAnimator.ofObject(new ArgbEvaluator(),
                            startColor, endColor);
                    mGradientAnimator.setInterpolator(new LinearInterpolator());
                    mGradientAnimator.setDuration(GRADIENT_ANIM_DURATION);
                    mGradientAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            Integer colorObj = (Integer) animation.getAnimatedValue();
                            int color = startColor;
                            if (colorObj != null) {
                                color = colorObj.intValue();
                            }

                            Log.d(TAG, "test gradient color typical color: "
                                    + Integer.toHexString(color));
                            if (mEffectView != null) {
                                mEffectView.setTextColor(color);
                            }
                        }
                    });
                    mGradientAnimator.start();
                    break;
                case R.id.custom_color_btn:
                    if (mGradientAnimator != null && mGradientAnimator.isRunning()) {
                        break;
                    }
                    final int customStartColor = Color.RED;
                    final int customEndColor = Color.WHITE;
                    mGradientAnimator = ValueAnimator.ofObject(
                            ColorEvaluator.getInstance(), customStartColor, customEndColor);
                    mGradientAnimator.setInterpolator(new LinearInterpolator());
                    mGradientAnimator.setDuration(GRADIENT_ANIM_DURATION);
                    mGradientAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            Integer colorObj = (Integer) (animation
                                    .getAnimatedValue());
                            int color = customStartColor;
                            if (colorObj != null) {
                                color = colorObj.intValue();
                            }

                            Log.d(TAG, "test gradient color custom color: "
                                    + Integer.toHexString(color));

                            if (mEffectView != null) {
                                mEffectView.setTextColor(color);
                            }
                        }
                    });
                    mGradientAnimator.start();
                    break;
                case R.id.custom_position_btn:
                    if ((mGradientAnimator != null && mGradientAnimator.isRunning())
                            || (mTranslateAnimator != null && mTranslateAnimator
                            .isRunning())) {
                        break;
                    }
                    final int xOffset = 100;
                    final int yOffset = 100;
                    final Point startPoint = new Point(0, 0);

                    final Point endPoint = new Point();
                    endPoint.x = startPoint.x + xOffset;
                    endPoint.y = startPoint.y + yOffset;

                    mTranslateAnimator = ValueAnimator.ofObject(
                            new PositionEvaluator(), startPoint, endPoint);
                    mTranslateAnimator.setInterpolator(new LinearInterpolator());
                    mTranslateAnimator.setDuration(GRADIENT_ANIM_DURATION);
                    mTranslateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animation) {
                            Point currPoint = (Point) (animation
                                    .getAnimatedValue());
                            int translateX = startPoint.x;
                            int translateY = startPoint.y;
                            if (currPoint != null) {
                                translateX = currPoint.x;
                                translateY = currPoint.y;
                            }

                            Log.d(TAG, "test gradient color custom translateX: " + translateX + ", translateY: " + translateY);

                            if (mEffectView != null) {
                                mEffectView.setTranslationX(translateX);
                                mEffectView.setTranslationY(translateY);
                            }
                        }
                    });
                    mTranslateAnimator.start();
                    break;
                case R.id.reset_btn:
                    if (mEffectView != null) {
                        mEffectView.setTranslationX(0);
                        mEffectView.setTranslationY(0);
                        mEffectView.setTextColor(0xffffffff);
                    }
                    break;
                default:
                    break;

            }
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mGradientAnimator != null) {
            mGradientAnimator.cancel();
        }
        if (mTranslateAnimator != null) {
            mTranslateAnimator.cancel();
        }
    }
}
