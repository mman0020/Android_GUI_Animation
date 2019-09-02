package com.baiheng.shaderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class BitmapShaderView extends View {
    private Paint mPaint;
    private Bitmap mBmp;
    public BitmapShaderView(Context context) {
        super(context);
        init();
    }

    public BitmapShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BitmapShaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBmp = BitmapFactory.decodeResource(getResources(),R.drawable.music);
        mPaint.setShader(new BitmapShader(mBmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawRect(0,0,mBmp.getWidth() * 2, mBmp.getHeight() * 2, mPaint);
        canvas.drawCircle(50,50,50, mPaint);
    }
}
