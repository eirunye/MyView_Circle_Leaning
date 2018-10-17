package com.eirunye.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.eirunye.myview.view.CircleScrollView;
import com.eirunye.myview.view.CircleView;
import com.eirunye.myview.view.MyCircleView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    private TextView textView;
    private MyCircleView myCircleView;
    private CircleScrollView circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);

//        circleView();
//        circleScrollView();

        myCircleView();

    }

    private void myCircleView() {
        textView = findViewById(R.id.text);

        myCircleView = findViewById(R.id.myCircleView);

        myCircleView.setValueChange(100, textView);

        myCircleView.setOnClickListener(this::onClickView);
    }

    private void circleView() {
        CircleView circleView = new CircleView(this);
        frameLayout.addView(circleView);
    }

    private void circleScrollView() {
        circleView = new CircleScrollView(this);
        frameLayout.addView(circleView);
//        circleView.startAnimations();
        circleView.setOnClickListener(this::onClickView);
    }

    private void onClickView(View view) {
        if (view instanceof CircleScrollView) {
            circleView.cancelAnimations();
        } else if (view instanceof MyCircleView)
            myCircleView.setValueChange(50, textView);
    }
}
