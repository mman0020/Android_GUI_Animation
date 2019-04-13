package com.vivo.wenruan.customevaluator;

import android.animation.TypeEvaluator;

public class PositionEvaluator implements TypeEvaluator<PositionView.PositionPoint> {

    @Override
    public PositionView.PositionPoint evaluate(float fraction, PositionView.PositionPoint startValue, PositionView.PositionPoint endValue) {

        PositionView.PositionPoint point_1= (PositionView.PositionPoint) startValue;
        float currentY = point_1.getY();

        float x = forCurrentX(fraction);
        float y = forCurrentY(fraction, currentY);

        point_1.setX(x);
        point_1.setY(y);
        return point_1;
    }

    private float forCurrentY(float fraction, float currentY) {
        float resultY = currentY;
        if (fraction != 0f) {
            resultY = fraction * 800f + 20f;
        }
        return resultY;
    }

    private float forCurrentX(float fraction) {
        float range = 400f;
        float resultX = 400f + (float) Math.sin((6 * fraction) * Math.PI) * range;
        return resultX;
    }
}
