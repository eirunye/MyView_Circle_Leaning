package com.eirunye.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Author Eirunye
 * Created by on 2018/10/17.
 * Describe
 */
public class CircleView extends View {

    private Paint paint;
    private int startAngle = 360;
    private int angleSpeed = 10;
    Shader shader;
    RectF rectF;
    RectF rectF1;
    Matrix matrix;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(30);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLUE);
        rectF = new RectF(200, 200, 400, 400);
        rectF1 = new RectF(500, 500, 700, 700);

        shader = new SweepGradient(300, 300, changeColors, null);
        matrix = new Matrix();
    }

    private int[] changeColors = new int[]{
            Color.argb(30, 230, 0, 0),
            Color.argb(30, 230, 0, 0),
            Color.argb(255, 230, 0, 0),
//            Color.TRANSPARENT,
    };


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setAlpha(255);
        canvas.drawArc(rectF, 360, 90, false, paint);
        canvas.drawArc(rectF, 360 + 180, 90, false, paint);
        paint.setAlpha(100);
        canvas.drawArc(rectF, 360 + 90, 90, false, paint);
        canvas.drawArc(rectF, 360 + 270, 90, false, paint);

        paint.setColor(Color.GREEN);
        canvas.drawCircle(300, 800, 100, paint);


        paint.setColor(Color.YELLOW);
        canvas.drawArc(rectF1, 0, 360, false, paint);



    }
}
