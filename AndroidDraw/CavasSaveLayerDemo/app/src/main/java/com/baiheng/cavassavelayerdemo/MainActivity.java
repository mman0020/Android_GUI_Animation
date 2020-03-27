package com.baiheng.cavassavelayerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(new SampleView(this));
    }

    private static class SampleView extends View {

        private Paint mPaint;
        public SampleView(Context context) {
            super(context);
            setFocusable(true);
            mPaint = new Paint();
            mPaint.setAntiAlias(true);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            canvas.drawColor(Color.WHITE);
            canvas.translate(10, 10);
            mPaint.setColor(Color.RED);
            canvas.drawCircle(75, 75, 75, mPaint);
            canvas.saveLayerAlpha(0, 0, 200, 200, 0x88, Canvas.ALL_SAVE_FLAG);
            mPaint.setColor(Color.BLUE);
            canvas.drawCircle(125, 125, 75, mPaint);
            canvas.restore();
        }
    }
}
