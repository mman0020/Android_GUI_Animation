package com.baiheng.canvasdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class PoterDuffLoadingView extends View {
    private Resources mResources;
    private Paint mBitPaint;
    private Bitmap mBitmap;

    private int mTotalWidth, mTotalHeight;
    private Bitmap girlBitmap;
    private int girlBitWidth , girlBitHeight;
    private Rect girlSrcRect , girlDesRect;

    public PoterDuffLoadingView(Context context) {
        super(context);
        mResources = getResources();
        initBitmap();
    }

    public PoterDuffLoadingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mResources = getResources();
        initBitmap();
    }

    private void initBitmap() {
        //美女图片的宽和高
        girlBitmap = ((BitmapDrawable)mResources.getDrawable(R.drawable.a1)).getBitmap();
        girlBitWidth = girlBitmap.getWidth();
        girlBitHeight = girlBitmap.getHeight();


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(girlBitmap, girlSrcRect, girlDesRect, null);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        Log.d("xxxxxx", "onSizeChanged , w = "+w+" , h = "+h+" , mBitWidth = "+mBitWidth+" , mBitHeight = "+mBitHeight);
        super.onSizeChanged(w, h, oldw, oldh);
        mTotalWidth = w;
        mTotalHeight = h;

        girlSrcRect = new Rect(0, 0, girlBitWidth, girlBitHeight);
        girlDesRect = new Rect(0, 0, girlBitWidth, girlBitHeight);

    }
}
