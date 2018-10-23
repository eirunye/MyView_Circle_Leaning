package com.eirunye.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.eirunye.myview.R;
import com.eirunye.myview.view.MyRoundView;

public class MyRoundViewActivity extends AppCompatActivity {

    private MyRoundView myRoundView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bound_view);

        myRoundView();
    }

    private void myRoundView() {
        myRoundView = findViewById(R.id.myRoundView);
        myRoundView.startAnimations();
    }
}
