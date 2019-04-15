package com.vivo.wenruan.xballdemo;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final float BALL_SIZE = 50;  //小球直径
    private static final float FULL_TIME = 1000;    //下落时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout xContainer = (LinearLayout) findViewById(R.id.xcontainer);
        xContainer.addView(new XBallView(this));

    }

    public class XBallView extends View implements ValueAnimator.AnimatorUpdateListener {

        public final ArrayList<XShapeHolder> balls = new ArrayList<>();

        public XBallView(Context context) {
            super(context);
            setBackgroundColor(Color.WHITE);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {

            if (event.getAction() != MotionEvent.ACTION_DOWN && event.getAction() != MotionEvent.ACTION_MOVE) {
                return false;
            }

            XShapeHolder newBall = addBall(event.getX(), event.getY());
            float startY = newBall.getY();
            float endY = getHeight() - BALL_SIZE;
            float h = (float) getHeight();
            float eventY = event.getY();
            //计算动画持续时间
            int duration = (int) (FULL_TIME * ((h - eventY) / h));

            ObjectAnimator fallAni = ObjectAnimator.ofFloat(
                    newBall,
                    "y",
                    startY,
                    endY
            );
            fallAni.setDuration(duration);
            fallAni.setInterpolator(new AccelerateInterpolator());
            fallAni.addUpdateListener(this);

            ObjectAnimator squashshAni1 = ObjectAnimator.ofFloat(
                    newBall,
                    "x",
                    newBall.getX(),
                    newBall.getX() - BALL_SIZE / 2
            );
            squashshAni1.setDuration(duration / 4);
            squashshAni1.setRepeatCount(1);
            squashshAni1.setRepeatMode(ValueAnimator.REVERSE);
            squashshAni1.setInterpolator(new DecelerateInterpolator());
            squashshAni1.addUpdateListener(this);

            ObjectAnimator squashshAni2 = ObjectAnimator.ofFloat(
                    newBall,
                    "width",
                    newBall.getWidth(),
                    newBall.getWidth() + BALL_SIZE);
            squashshAni2.setDuration(duration / 4);
            squashshAni2.setRepeatCount(1);
            squashshAni2.setRepeatMode(ValueAnimator.REVERSE);
            squashshAni2.setInterpolator(new DecelerateInterpolator());
            // 添加addUpdateListener监听器，当ValueAnimator属性值改变时会激发事件监听方法
            squashshAni2.addUpdateListener(this);

            // 定义小球拉伸动画， 控制小球的y坐标下移半个球高度
            ValueAnimator stretchAni1 = ObjectAnimator.ofFloat(
                    newBall,
                    "y",
                    endY,
                    endY + BALL_SIZE / 2);
            stretchAni1.setDuration(duration / 4);
            stretchAni1.setRepeatCount(1);
            stretchAni1.setRepeatMode(ValueAnimator.REVERSE);
            stretchAni1.setInterpolator(new DecelerateInterpolator());
            // 添加addUpdateListener监听器，当ValueAnimator属性值改变时会激发事件监听方法
            stretchAni1.addUpdateListener(this);

            // 定义小球拉伸动画， 控制小球的高度减半
            ValueAnimator stretchAni2 = ObjectAnimator.ofFloat(
                    newBall,
                    "height",
                    newBall.getHeight(),
                    newBall.getHeight() - BALL_SIZE / 2);
            stretchAni2.setDuration(duration / 4);
            stretchAni2.setRepeatCount(1);
            stretchAni2.setRepeatMode(ValueAnimator.REVERSE);
            stretchAni2.setInterpolator(new DecelerateInterpolator());
            // 添加addUpdateListener监听器，当ValueAnimator属性值改变时会激发事件监听方法
            stretchAni2.addUpdateListener(this);

            // 定义小球弹起动画
            ValueAnimator bounceAni = ObjectAnimator.ofFloat(
                    newBall,
                    "y",
                    endY,
                    startY);
            bounceAni.setDuration(duration);
            bounceAni.setInterpolator(new DecelerateInterpolator());
            // 添加addUpdateListener监听器，当ValueAnimator属性值改变时会激发事件监听方法
            bounceAni.addUpdateListener(this);

            // 定义AnimatorSet，按顺序播放[下落、压扁&拉伸、弹起]动画
            AnimatorSet set = new AnimatorSet();
            //在squashshAni1之前播放fallAni
            set.play(fallAni).before(squashshAni1);
            /**
             * 由于小球弹起时压扁，即宽度加倍，x坐标左移，高度减半，y坐标下移
             * 因此播放squashshAni1的同时还要播放squashshAni2，stretchAni1，stretchAni2
             */
            set.play(squashshAni1).with(squashshAni2);
            set.play(squashshAni1).with(stretchAni1);
            set.play(squashshAni1).with(stretchAni2);
            // 在stretchAni2之后播放bounceAni
            set.play(bounceAni).after(stretchAni2);

            // newBall对象的渐隐动画，设置alpha属性值1--->0
            ObjectAnimator fadeAni = ObjectAnimator.ofFloat(
                    newBall,
                    "alpha",
                    1f,
                    0f);
            // 设置动画持续时间
            fadeAni.setDuration(250);
            // 添加addUpdateListener监听器，当ValueAnimator属性值改变时会激发事件监听方法
            fadeAni.addUpdateListener(this);

            // 为fadeAni设置监听
            fadeAni.addListener(new AnimatorListenerAdapter() {
                // 动画结束
                @Override
                public void onAnimationEnd(Animator animation) {
                    // 动画结束时将该动画关联的ShapeHolder删除
                    balls.remove(((ObjectAnimator) (animation)).getTarget());
                }
            });

            // 再次定义一个AnimatorSet动画集合，来组合动画
            AnimatorSet aniSet = new AnimatorSet();
            // 指定在fadeAni之前播放set动画集合
            aniSet.play(set).before(fadeAni);

            // 开始播放动画
            aniSet.start();

            return true;

        }

        @Override
        protected void onDraw(Canvas canvas) {
            for (XShapeHolder xShapeHolder : balls) {
                canvas.save();
                canvas.translate(xShapeHolder.getX(), xShapeHolder.getY());
                xShapeHolder.getShape().draw(canvas);
                canvas.restore();
            }
        }

        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            // 指定重绘界面
            this.invalidate();
        }

        /**
         * 返回XShapeHolder对象，ShapeHolder对象持有小球
         */
        private XShapeHolder addBall(float x, float y) {
            OvalShape circle = new OvalShape();
            circle.resize(BALL_SIZE,BALL_SIZE);
            //将椭圆包装乘Drawable对象
            ShapeDrawable drawable = new ShapeDrawable(circle);
            XShapeHolder holder = new XShapeHolder(drawable);
            holder.setX(x - BALL_SIZE / 2);
            holder.setY(y - BALL_SIZE / 2);

            // 生成随机组合的ARGB颜色
            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255);
            int color = 0xff000000 + red << 16 | green << 8 | blue;
            int darkColor = 0xff000000 | red / 4 << 16 | green / 4 << 8 | blue / 4;

            RadialGradient gradient = new RadialGradient(
                    37.5f,
                    12.5f,
                    BALL_SIZE,
                    color,
                    darkColor,
                    Shader.TileMode.CLAMP);
            Paint paint = drawable.getPaint();
            paint.setShader(gradient);

            holder.setPaint(paint);
            balls.add(holder);
            return holder;
        }
    }
}
