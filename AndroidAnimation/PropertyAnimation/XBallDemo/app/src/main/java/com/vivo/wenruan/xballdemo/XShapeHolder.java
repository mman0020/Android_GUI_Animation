package com.vivo.wenruan.xballdemo;

import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.Shape;

public class XShapeHolder {

    private float x = 0, y = 0;
    private ShapeDrawable mShape;
    private int mColor;
    private RadialGradient mGradient;
    private  float mAlpha = 1f;
    private Paint mPaint;

    public XShapeHolder(ShapeDrawable shapeDrawable) {
        this.mShape = shapeDrawable;
    }

    public float getWidth() {
        return mShape.getShape().getWidth();
    }

    public void setWidth(float width) {
        Shape s = mShape.getShape();
        s.resize(width, s.getHeight());
    }

    public float getHeight() {
        return mShape.getShape().getHeight();
    }

    public void setHeight(float height) {
        Shape s = mShape.getShape();
        s.resize(s.getWidth(), height);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ShapeDrawable getShape() {
        return mShape;
    }

    public void setShape(ShapeDrawable mShape) {
        this.mShape = mShape;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        this.mColor = color;
    }

    public RadialGradient getGradient() {
        return mGradient;
    }

    public void setGradient(RadialGradient gradient) {
        this.mGradient = gradient;
    }

    public float getAlpha() {
        return mAlpha;
    }

    public void setAlpha(float alpha) {
        this.mAlpha = alpha;
    }

    public Paint getPaint() {
        return mPaint;
    }

    public void setPaint(Paint paint) {
        this.mPaint = paint;
    }
}
