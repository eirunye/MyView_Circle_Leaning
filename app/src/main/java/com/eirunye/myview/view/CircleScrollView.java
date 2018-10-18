package com.eirunye.myview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author Eirunye
 * Created by on 2018/10/17.
 * Describe
 */
public class CircleScrollView extends View {

    private Paint paint;
    private int sAngle = 360;
    private int sSpeed = 10; //滚动速度大小
    Shader shader;
    RectF rectF;
    Matrix matrix;


    private int[] colors = new int[]{
            Color.argb(30, 0, 0, 233),
            Color.argb(30, 0, 0, 233),
            Color.argb(255, 0, 0, 233),
    };
    private float cx;
    private float cy;
    private ValueAnimator valueAnimator;

    public CircleScrollView(Context context) {
        this(context, null);
    }

    public CircleScrollView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setLayerType(LAYER_TYPE_SOFTWARE,null);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        rectF = new RectF(200, 200, 400, 400);

        shader = new SweepGradient(300, 300, colors, null);
        matrix = new Matrix();

        Rect rect = new Rect();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.reset();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
        matrix.setRotate(sAngle, 300, 300);

        shader.setLocalMatrix(matrix);

        paint.setShader(shader);

        canvas.drawArc(rectF, 0, 360, false, paint);
        //绘制圆环开头的小圆点
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.argb(255, 0, 0, 233));

        cx = 300 + (int) (100 * Math.cos((double) sAngle / 180 * Math.PI));
        cy = 300 + (int) (100 * Math.sin((double) sAngle / 180 * Math.PI));
        canvas.drawCircle(cx, cy, 30 / 2, paint);


        //滚动
        sAngle += sSpeed;
        if (sAngle == 360)
            sAngle = 0;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        invalidate();
    }

    //或者下面动画滚动
    public void startAnimations() {

        valueAnimator = ValueAnimator.ofInt(0, sAngle);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(this::onAnimation);
        valueAnimator.start();
    }

    private void onAnimation(ValueAnimator valueAnimator) {

        sAngle = Integer.valueOf(String.valueOf(valueAnimator.getAnimatedValue()));
        invalidate();
    }

    public void cancelAnimations() {

        if (valueAnimator != null) valueAnimator.cancel();
    }
}
