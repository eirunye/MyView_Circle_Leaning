package com.eirunye.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.eirunye.myview.view.CircleScrollView;
import com.eirunye.myview.view.CircleView;
import com.eirunye.myview.view.MyCircleView;
import com.eirunye.myview.view.MyRoundView;

public class CircleViewActivity extends AppCompatActivity {

    private FrameLayout frameLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_view);
        circleView();
    }

    private void circleView() {

        frameLayout = findViewById(R.id.frameLayout);
        CircleView circleView = new CircleView(this);
        frameLayout.addView(circleView);
    }



    private void onClickView(View view) {

    }
}
