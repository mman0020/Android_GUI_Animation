package com.example.zhewen.interpolatordemo;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;


public class SportsView extends View {

    private float mProgress = 0;

    public SportsView(Context context) {
        super(context);
    }

    public SportsView(Context context, AttributeSet attr) {
        super(context, attr);
    }

    public SportsView(Context context, AttributeSet attr, int defStyleAttr) {
        super(context, attr,defStyleAttr);
    }

    public float getProgress() {
        return mProgress;
    }

    public void setProgress(float progress) {
        mProgress = progress;
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawArc();
    }


}
