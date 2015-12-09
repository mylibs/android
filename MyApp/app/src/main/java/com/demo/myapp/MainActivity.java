package com.demo.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_demo1).setOnClickListener(this);
        findViewById(R.id.btn_demo2).setOnClickListener(this);
        findViewById(R.id.btn_demo3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_demo1:
                Intent intent = new Intent(this,Demo1Activity.class);
                startActivity(intent);
                break;
            case R.id.btn_demo2:
                Intent intent2 = new Intent(this,Demo2Activity.class);
                startActivity(intent2);
                break;
            case R.id.btn_demo3:
            Intent intent3 = new Intent(this,Demo3Activity.class);
            startActivity(intent3);
                break;
            default:
                break;

        }

    }
}
