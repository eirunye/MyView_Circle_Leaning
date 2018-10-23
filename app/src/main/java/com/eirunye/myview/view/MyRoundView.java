package com.eirunye.myview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.eirunye.myview.R;

/**
 * Author Eirunye
 * Created by on 2018/10/23.
 * Describe 一个圆点随着圆滚动
 */
public class MyRoundView extends View {


    private int roundRadius; //圆环半径
    private int roundColor; //圆环颜色
    private int roundWidth; //圆环宽度
    private int roundx;   //圆心X坐标
    private int roundy;  //圆心Y坐标
    private int pointRadius; //实心圆半径
    private int pointColor;  //实心圆颜色
    private int pointWidth;
    private int delay;     //动画时长
    Paint paint, paintC;
    private int sAngle = 360;
    private int cx;
    private int cy;
    private ValueAnimator valueAnimator;


    public MyRoundView(Context context) {
        this(context, null);
    }

    public MyRoundView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyRoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyRoundView, defStyleAttr, 0);

        roundRadius = typedArray.getInt(R.styleable.MyRoundView_roundRadius, -1);

        roundColor = typedArray.getColor(R.styleable.MyRoundView_roundColor, Color.RED);

        roundx = typedArray.getInt(R.styleable.MyRoundView_cx, -1);

        roundy = typedArray.getInt(R.styleable.MyRoundView_cy, -1);

        roundWidth = typedArray.getInt(R.styleable.MyRoundView_roundWidth, 5);

        delay = typedArray.getInt(R.styleable.MyRoundView_delay, 2000);

        pointRadius = typedArray.getInt(R.styleable.MyRoundView_pointRadius, 10);

        pointColor = typedArray.getColor(R.styleable.MyRoundView_pointColor, Color.BLUE);

        pointWidth = typedArray.getInt(R.styleable.MyRoundView_pointWidth, 5);

        typedArray.recycle();


        paint = new Paint();
        paint.setColor(roundColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(roundWidth);

        paintC = new Paint();

        paintC.setAntiAlias(true);
        paintC.setStyle(Paint.Style.FILL);
        paintC.setStrokeWidth(pointWidth);
        paintC.setColor(pointColor);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(roundx, roundy, roundRadius, paint);

        int cx = roundx + (int) (roundRadius * Math.cos((double) sAngle / 180 * Math.PI));
        int cy = roundy + (int) (roundRadius * Math.sin((double) sAngle / 180 * Math.PI));
        canvas.drawCircle(cx, cy, pointRadius, paintC);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //或者下面动画滚动
    public void startAnimations() {

        valueAnimator = ValueAnimator.ofInt(0, sAngle);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(delay);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(this::onAnimation);
        valueAnimator.start();
    }

    private void onAnimation(ValueAnimator valueAnimator) {

        sAngle = Integer.valueOf(String.valueOf(valueAnimator.getAnimatedValue()));
        System.out.println("myRoundView:" + sAngle);
        invalidate();
    }

    public void onStop() {
        if (valueAnimator != null && valueAnimator.isRunning()) valueAnimator.cancel();
    }
}
