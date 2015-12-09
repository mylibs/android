package com.demo.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Demo3Activity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo32);
        findViewById(R.id.btn_listview).setOnClickListener(this);
        findViewById(R.id.btn_gradeview).setOnClickListener(this);
        findViewById(R.id.btn_pb).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_listview:
                Intent intent = new Intent(this,Demo3ListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_gradeview:

                Intent intent2 = new Intent(this,Demo3GrideViewActivity.class);
                startActivity(intent2);
                break;

            case R.id.btn_pb:
                Intent intent3 = new Intent(this,Demo3StaggeredActivity.class);
                startActivity(intent3);

                break;
            default:
                break;


        }
    }
}
