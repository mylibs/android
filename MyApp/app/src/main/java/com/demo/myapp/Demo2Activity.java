package com.demo.myapp;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pager.ImageSlidePanel;

public class Demo2Activity extends AppCompatActivity {

    private ImageSlidePanel imageSlidePanel;
    private Handler handler;
    TextView view1;
    private boolean scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo2);
        imageSlidePanel = (ImageSlidePanel) findViewById(R.id.image_slide_panel);
        TextView view2 = (TextView) findViewById(R.id.view2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroll=false;
            }
        });
        view1 = (TextView)findViewById(R.id.view1);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scroll = true;
                autoScroll(-1);
            }
        });


        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                imageSlidePanel.startInAnim();

            }
        };
//        delayShowSlidePanel();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(1);

            }
        }, 1000);

    }
    private void autoScroll(final int i) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                imageSlidePanel.onClickFade(i);
                if(scroll){

                    handler.postDelayed(this,2000);
                }
            }
        },1000);
    }
}
