package com.baiheng.basiccustomdrawdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MyView extends View {

    private Context mContext;
    private Paint mPaint = new Paint();

    public MyView(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
        mContext = context;
        init();
    }

    //重写OnDraw（）函数，在每次重绘时自主实现绘图
    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
        canvas.drawRGB(255, 255, 255);
        //画圆
        canvas.drawCircle(190, 200, 150, mPaint);
    }

    private void init() {
        //设置画笔基本属性

        mPaint.setAntiAlias(true);//抗锯齿功能
        mPaint.setColor(Color.RED);  //设置画笔颜色
        mPaint.setStyle(Paint.Style.STROKE);//设置填充样式   Style.FILL/Style.FILL_AND_STROKE/Style.STROKE
        mPaint.setStrokeWidth(5);//设置画笔宽度
        mPaint.setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影
        //设置画布背景颜色
    }
}
