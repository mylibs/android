package com.demo.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.nineoldandroids.view.ViewPropertyAnimator;

public class Demo1Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView ivBoss;
    RelativeLayout rlContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);

        rlContainer = (RelativeLayout) findViewById(R.id.rl_container);
        Button btnOver = (Button) findViewById(R.id.btn_click);
        Button btnBack = (Button) findViewById(R.id.btn_back);
        btnOver.setOnClickListener(this);
        btnBack.setOnClickListener(this);

        ivBoss = (ImageView) findViewById(R.id.iv_window);
        ViewPropertyAnimator.animate(ivBoss).setDuration(1);
        ViewPropertyAnimator.animate(ivBoss).alpha(0);
    }

    @Override
    public void onClick(View v) {
        ViewPropertyAnimator.animate(ivBoss).setDuration(1);
        ViewPropertyAnimator.animate(ivBoss).alpha(1);
        ViewPropertyAnimator.animate(ivBoss).setDuration(2000);
        //旋转720度
        ViewPropertyAnimator.animate(ivBoss).rotationYBy(720);
        switch (v.getId()){
            case R.id.btn_click:
                ivBoss.setVisibility(View.VISIBLE);
                int xValue = rlContainer.getWidth() - ivBoss.getWidth();
                int yValue = rlContainer.getHeight() - ivBoss.getHeight();
                //移动到的位置--右下角
                ViewPropertyAnimator.animate(ivBoss).x(xValue).y(yValue);
                ivBoss.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ivBoss.setVisibility(View.GONE);
                    }
                },2000);
                break;
            case R.id.btn_back:
                ivBoss.setVisibility(View.VISIBLE);
                int xValue1 = rlContainer.getWidth()/2;
                int yValue1 = rlContainer.getHeight()/2;
                //移动到的位置--屏幕中间
                ViewPropertyAnimator.animate(ivBoss).x(xValue1).y(yValue1);
                ivBoss.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ivBoss.setVisibility(View.GONE);
                    }
                },2000);
                break;
        }
    }
}
