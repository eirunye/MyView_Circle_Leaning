package com.eirunye.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;

import com.eirunye.myview.view.CircleScrollView;
import com.eirunye.myview.view.MyCircleView;

public class CircleScrollViewActivity extends AppCompatActivity {

    private CircleScrollView circleView;
    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_scroll_view);

        circleScrollView();
    }

    private void circleScrollView() {
        frameLayout = findViewById(R.id.frameLayout);
        circleView = new CircleScrollView(this);
        frameLayout.addView(circleView);
//        circleView.startAnimations();
        circleView.setOnClickListener(this::onClickView);
    }

    private void onClickView(View view) {
        circleView.cancelAnimations();
    }
}
