package com.baiheng.paintcapdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CapView extends View {

    private Paint mPaint = new Paint();

    public CapView(Context context) {
        super(context);
        init();
    }

    private void init() {
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(100);
        mPaint.setColor(Color.parseColor("#00ff00"));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // BUTT
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(100,100,400,100,mPaint);

        //ROUND
        mPaint.setColor(Color.parseColor("#ff0000"));
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(100,300,400,300,mPaint);

        //SQUARE
        mPaint.setColor(Color.parseColor("#0000ff"));
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(100,600,400,600,mPaint);

    }
}
