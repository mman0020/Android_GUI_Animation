package com.vivo.wenruan.argbtypeevaluatordemo;

import android.animation.TypeEvaluator;
import android.graphics.Point;
import android.util.Log;

public class PositionEvaluator implements TypeEvaluator {

    private static final String TAG = "PositionEvaluator";

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {

        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;

        Point resultPoint = new Point();
        resultPoint.x = (int) (startPoint.x * (1.f - fraction) + endPoint.x * fraction);
        resultPoint.y = (int) (startPoint.y * (1.f - fraction) + endPoint.y * fraction);

        Log.d(TAG, "test gradient color evaluate startPoint: " + startPoint
                + ", endPoint: " + endPoint + ", resultPoint: " + resultPoint);


        return resultPoint;
    }
}
