package com.vivo.wenruan.customevaluator;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

public class PositionView extends View {

    public static final float RADIUS = 20f;
    private PositionPoint currentPoint;
    private Paint mPaint;

    public PositionView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (currentPoint == null) {
            currentPoint = new PositionPoint(RADIUS, RADIUS);
            drawCircle(canvas);
            startPropertyAni();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = currentPoint.getX();
        float y = currentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }

    public void startPropertyAni() {
        ValueAnimator animator = ValueAnimator.ofObject(new PositionEvaluator(), createPoint(RADIUS, RADIUS),
                createPoint(getWidth() - RADIUS, getHeight() - RADIUS));
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (PositionPoint) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(10 * 1000);
        animator.start();
    }

    public PositionPoint createPoint(float x, float y) {
        return new PositionPoint(x, y);
    }

    class PositionPoint {

        private float x;
        private float y;

        public PositionPoint(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public void setX(float x) {
            this.x = x;
        }

        public void setY(float y) {
            this.y = y;
        }
    }
}
