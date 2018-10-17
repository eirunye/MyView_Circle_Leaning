package com.eirunye.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.eirunye.myview.view.CircleScrollView;
import com.eirunye.myview.view.CircleView;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        CircleView circleView = new CircleView(this);
//        CircleScrollView circleView = new CircleScrollView(this);

        frameLayout.addView(circleView);
    }
}
