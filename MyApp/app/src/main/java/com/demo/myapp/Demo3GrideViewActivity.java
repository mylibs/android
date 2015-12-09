package com.demo.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import weixiao.java.DividerGridItemDecoration;
import weixiao.java.DividerItemDecoration;
import weixiao.java.MyAdapter;

public class Demo3GrideViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> mData;
    private MyAdapter simpleAdapterp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo3_gride_view);
        initData();
        initUI();

    }
    private void initUI() {
        recyclerView = (RecyclerView) findViewById(R.id.rv_recycleview_gride);
        simpleAdapterp = new MyAdapter(this,mData);
        recyclerView.setAdapter(simpleAdapterp);
//        LinearLayoutManager mlinearManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        //修改此处
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,4);
        recyclerView.setLayoutManager(gridLayoutManager);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST);
        //修改此处
        DividerGridItemDecoration dividerItemDecoration = new DividerGridItemDecoration(this);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void initData() {
        mData = new ArrayList<>();
        for(int i= 'A' ;i<= 'z';i++){
            mData.add(""+(char)i);
        }

    }
}
