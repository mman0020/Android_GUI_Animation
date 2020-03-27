package com.baiheng.cavassavelayerdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class SaveLayerView extends View {

    public final static String TAG = "SaveLayerView";
    private Paint mPaint = null;
    public SaveLayerView(Context context) {
        super(context);
        mPaint = new Paint();
    }
    public SaveLayerView(Context context, AttributeSet attrs) {
        super(context);
        mPaint = new Paint();
    }
    public SaveLayerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.GRAY);
        int px = 500;
        int py = 500;
        canvas.drawRect(0,0,px,py,mPaint);
        canvas.save();
        canvas.rotate(90, px / 2, py / 2);
        mPaint.setColor(Color.RED);
        canvas.drawLine(px / 2, 0, 0, py / 2, mPaint);
        canvas.drawLine(px / 2, 0, px, py / 2, mPaint);
        canvas.drawLine(px / 2, 0, px / 2, py / 2, mPaint);
        canvas.restore();
        canvas.drawCircle(px - 100, py - 100, 50, mPaint);
        canvas.save();
        canvas.drawCircle(400,100,100,mPaint);
        canvas.restore();
    }
}
