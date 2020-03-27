package com.baiheng.canvasdemo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;

public class CustomView extends View {

    private Paint mPaint = new Paint();
    private Resources mResources = getResources();
    private RectF mRectF = new RectF(20,20,420,420);
    private Rect mRect = new Rect(20,20,420,420);
    private Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    private float []mPts = new float[]{0,100,200,300, 0,200,200,400};
    private CharSequence mCharSequence="Canvas学习";
    private Path mPath = new Path();
    private Paint mPaint1 = new Paint();
    private Matrix mMatrix = new Matrix();
    private Bitmap girlBitmap;


    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        girlBitmap = ((BitmapDrawable)mResources.getDrawable(R.drawable.a1)).getBitmap();
//        girlBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
    }


    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mPaint.setAntiAlias(true);
//        mPaint.setColor(Color.RED);
//        canvas.translate(200,0);
//        canvas.rotate(50);
//        canvas.drawRect(0,0,200,200,mPaint);
        canvas.drawColor(Color.RED);

        //保存当前画布大小即整屏
        canvas.save();

        canvas.clipRect(new Rect(100, 100, 800, 800));
        canvas.drawColor(Color.GREEN);

        //恢复整屏画布
        canvas.restore();

//        canvas.drawColor(Color.BLUE);


//        mMatrix.postTranslate(100,0);
//        mMatrix.postRotate(45);
//        canvas.drawBitmap(girlBitmap,mRect,mRectF,mPaint);
//        canvas.drawBitmap(girlBitmap,mMatrix,mPaint);
//        mPaint1.setAntiAlias(true);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPath.rMoveTo(10, 10); //设定起始点
//        mPath.rLineTo(0, 90);//第一条直线的终点，也是第二条直线的起点
//        mPath.rLineTo(290, 0);//画第二条直线
//        mPath.rLineTo(200, 0);//第三条直线
//        mPath.close();//闭环
//
//        canvas.drawPath(mPath, mPaint);


//        canvas.drawArc(mRectF, -45,135,false,mPaint);
//
//        canvas.drawCircle(300,100,100,mPaint);

//        canvas.drawBitmap(mBitmap, 0,0,mPaint1);
//        canvas.drawColor(Color.BLUE);
//        canvas.drawColor(Color.GREEN, PorterDuff.Mode.OVERLAY);
//        canvas.drawRGB(255, 200, 100);

//        canvas.drawLine(0,0,200,200, mPaint);
//        canvas.drawLines(mPts,mPaint);

//        canvas.drawRect(mRectF,mPaint);

//        canvas.drawOval(mRectF,mPaint);

//        canvas.drawPaint(mPaint);

//        canvas.drawPoint(100,100,mPaint);

//        canvas.drawRoundRect(mRectF,20,20,mPaint);

//        canvas.drawText("哈喽", 400, 400, mPaint);
//        canvas.drawText(mCharSequence,0,mCharSequence.length(), 30,50,mPaint);

//        mPath.addCircle(200,200,100,Path.Direction.CCW);
//        canvas.drawPath(mPath, mPaint);

//        mPath.addCircle(200,200,100,Path.Direction.CCW);
//        canvas.clipPath(mPath);
//        canvas.drawColor(Color.RED);

//        canvas.drawColor(Color.BLUE);
//        canvas.drawRect(mRectF, mPaint);
//        canvas.drawCircle(120, 70, 50, mPaint);
//        canvas.clipRect(mRectF);
//        mPath.addCircle(120, 70, 50, Path.Direction.CCW);
//        canvas.clipPath(mPath, Region.Op.INTERSECT);
//        canvas.drawColor(Color.GREEN);

//        canvas.drawColor(Color.BLUE);
//        canvas.translate(100,100);
//        canvas.drawCircle(0,0,50,mPaint);

//        canvas.drawColor(Color.BLUE);
//        canvas.save();
//        canvas.scale(0.5f,0.5f);//x,y均缩小一半
//        canvas.drawCircle(100,100,50,mPaint);
//        canvas.restore();
//        mPaint.setColor(Color.WHITE);
//        canvas.drawCircle(100,100,50,mPaint);


//        canvas.drawColor(Color.BLUE);
//        mPaint.setColor(Color.WHITE);
//        canvas.drawCircle(100,100,50,mPaint);
//        canvas.save();
//        canvas.scale(0.5f,0.5f,100,100);
//        mPaint.setColor(Color.RED);
//        canvas.drawCircle(100,100,50,mPaint);
//        canvas.restore();

//        canvas.drawColor(Color.BLUE);
//        mPaint.setColor(Color.WHITE);
//        canvas.drawRect(mRectF,mPaint);
//        canvas.save();
//        canvas.rotate(45);
//        //canvas.rotate(45,200,200);
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(mRectF,mPaint);
//        canvas.restore();


//        canvas.drawColor(Color.BLUE);
//        mPaint.setColor(Color.WHITE);
//        canvas.drawRect(mRectF,mPaint);
//        canvas.save();
//        canvas.skew(1,0);//画布X轴倾斜45度
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(mRectF,mPaint);
//        canvas.restore();


//        Paint paint=new Paint();
//        paint.setColor(Color.RED);  //设置画笔颜色
//        paint.setStyle(Paint.Style.FILL);//设置填充样式
//        paint.setStrokeWidth(5);//设置画笔宽度
//
//        canvas.drawLine(100, 100, 200, 200, paint);

    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }

//    @Override
//    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
//        super.onSizeChanged(w, h, oldw, oldh);
//        int girlBitWidth = girlBitmap.getWidth();
//        int girlBitHeight = girlBitmap.getHeight();
//        mRectF = new RectF(0,0,girlBitWidth,girlBitHeight);
//        mRect = new Rect(0,0,girlBitWidth,girlBitHeight);
//    }
}
