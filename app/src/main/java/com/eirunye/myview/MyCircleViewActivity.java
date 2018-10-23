package com.eirunye.myview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.eirunye.myview.view.MyCircleView;

public class MyCircleViewActivity extends AppCompatActivity {


    private TextView textView;
    private MyCircleView myCircleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_circle_view);

        myCircleView();
    }

    private void myCircleView() {
        textView = findViewById(R.id.text);

        myCircleView = findViewById(R.id.myCircleView);

        myCircleView.setValueChange(100, textView);

        myCircleView.setOnClickListener(this::onClickView);
    }

    private void onClickView(View view) {

    }
}
