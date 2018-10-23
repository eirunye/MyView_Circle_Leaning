package com.eirunye.myview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.eirunye.myview.view.CircleScrollView;
import com.eirunye.myview.view.CircleView;
import com.eirunye.myview.view.MyCircleView;
import com.eirunye.myview.view.MyRoundView;

public class MainActivity extends AppCompatActivity {


    Button myRoundView, myCircleView, circleScrollView, circleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myRoundView = findViewById(R.id.myRoundView);
        myCircleView = findViewById(R.id.myCircleView);
        circleScrollView = findViewById(R.id.circleScrollView);
        circleView = findViewById(R.id.circleView);

        myRoundView.setOnClickListener(this::onClickView);
        myCircleView.setOnClickListener(this::onClickView);
        circleScrollView.setOnClickListener(this::onClickView);
        circleView.setOnClickListener(this::onClickView);

    }

    private void onClickView(View view) {
        switch (view.getId()) {
            case R.id.myRoundView:
                startActivity(new Intent(MainActivity.this,MyRoundViewActivity.class));
                break;
            case R.id.myCircleView:
                startActivity(new Intent(MainActivity.this,MyCircleViewActivity.class));
                break;
            case R.id.circleScrollView:
                startActivity(new Intent(MainActivity.this,CircleScrollViewActivity.class));
                break;
            case R.id.circleView:
                startActivity(new Intent(MainActivity.this,CircleViewActivity.class));
                break;

        }
    }


}
