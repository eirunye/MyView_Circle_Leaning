package com.eirunye.myview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.eirunye.myview.R;

/**
 * Author Eirunye
 * Created by on 2018/10/17.
 * Describe
 */
public class MyCircleView extends View {


    private Paint paint;
    private int inner_circle_radius;//内圆半径
    private int inner_circle_color;//内圆颜色
    private int ring_size;//圆环大小
    private int outer_circle_radius;//外圆半径
    private int outer_circle_color;//外圆颜色
    private int ring_color;//圆环颜色
    private RectF rectF;

    ValueAnimator valueAnimator;

    private int max_value;
    private int num_value;
    private int circle_center_x;//
    private int circle_center_y;//

    private final Matrix matrix;
    private Shader shader;

    private int[] colors = new int[]{
            Color.argb(30, 0, 0, 233),
            Color.argb(30, 0, 0, 233),
            Color.argb(100, 0, 0, 233),
            Color.argb(255, 0, 0, 233),
    };
    private int sweepAngle = 30;


    public MyCircleView(Context context) {
        this(context, null);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCircleView, defStyleAttr, 0);

        inner_circle_radius = typedArray.getInt(R.styleable.MyCircleView_inner_circle_radius, 300);
        inner_circle_color = typedArray.getColor(R.styleable.MyCircleView_inner_circle_color, Color.RED);
        ring_size = typedArray.getInt(R.styleable.MyCircleView_ring_size, 50);
        ring_color = typedArray.getColor(R.styleable.MyCircleView_ring_color, Color.GRAY);
        outer_circle_radius = typedArray.getInt(R.styleable.MyCircleView_outer_circle_radius, 350);
        outer_circle_color = typedArray.getColor(R.styleable.MyCircleView_outer_circle_color, Color.BLUE);

        max_value = typedArray.getInt(R.styleable.MyCircleView_max_value, 100);
        num_value = typedArray.getInt(R.styleable.MyCircleView_num_value, 0);
        typedArray.recycle();

//        rectF = new RectF(200, 200, 500, 500);

        paint = new Paint();
        shader = new SweepGradient(circle_center_x, circle_center_y, colors, null);
        matrix = new Matrix();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        paint.reset();
//        paint.setColor(inner_circle_color);
////        paint.setStyle(Paint.Style.STROKE);
//        paint.setAntiAlias(true);
//        canvas.drawCircle(circle_center_x, circle_center_y, inner_circle_radius, paint);

        paint.reset();
        paint.setStrokeWidth(ring_size);
        paint.setColor(ring_color);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        canvas.drawArc(rectF, 0, 360, false, paint);


        paint.reset();
        paint.setStrokeWidth(ring_size);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

//        matrix.setRotate(180, circle_center_x, circle_center_y);
//        shader.setLocalMatrix(matrix);
        paint.setShader(new SweepGradient(circle_center_x, circle_center_x, colors, null));

        canvas.rotate(270, circle_center_x, circle_center_y);
        canvas.drawArc(rectF, 360, sweepAngle, false, paint);


    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();

        circle_center_x = measuredWidth / 2;
        circle_center_y = measuredHeight / 2;


        rectF = new RectF(circle_center_x - inner_circle_radius - ring_size / 2, circle_center_y - inner_circle_radius - ring_size / 2, circle_center_x + inner_circle_radius + ring_size / 2, circle_center_y + inner_circle_radius + ring_size / 2);

    }

    public void setValueChange(int valueChange, TextView textView) {
        if (valueChange > max_value) valueChange = max_value;

        int start = 0;
        int end = valueChange;
        startAnimations(start, end, textView);

    }

    private void startAnimations(int start, int end, TextView textView) {

        valueAnimator = ValueAnimator.ofInt(start, end);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(valueAnimator -> {
            int ii = Integer.parseInt(String.valueOf(valueAnimator.getAnimatedValue()));
            textView.setText(ii + "");
            sweepAngle = (int) (360 * (ii / 100f));
            invalidate();
        });

        valueAnimator.start();
    }

}
