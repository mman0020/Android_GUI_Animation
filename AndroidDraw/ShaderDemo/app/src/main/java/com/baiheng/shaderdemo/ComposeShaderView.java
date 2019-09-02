package com.baiheng.shaderdemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

public class ComposeShaderView extends View {

    private Paint mPaint;
    private Bitmap mBmp1;
    private BitmapShader mBitmapShader;
    private PorterDuffXfermode mPorterDuff;
    private LinearGradient mLinearGradient;

    public ComposeShaderView(Context context) {
        super(context);
        init();
    }

    public ComposeShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ComposeShaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBmp1 = BitmapFactory.decodeResource(getResources(),R.drawable.heart);
        mBitmapShader = new BitmapShader(mBmp1, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPorterDuff = new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY);
        mLinearGradient = new LinearGradient(0,0, mBmp1.getWidth(), mBmp1.getHeight(), Color.GREEN, Color.BLUE, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.saveLayer(0,0,mBmp1.getWidth(),mBmp1.getHeight(), null, Canvas.ALL_SAVE_FLAG);
        mPaint.setShader(mBitmapShader);
        canvas.drawRect(0,0,mBmp1.getWidth(), mBmp1.getHeight(), mPaint);
        mPaint.setXfermode(mPorterDuff);
        mPaint.setShader(mLinearGradient);
        canvas.drawRect(0,0,mBmp1.getWidth(), mBmp1.getHeight(),mPaint);
        canvas.restore();

    }
}
