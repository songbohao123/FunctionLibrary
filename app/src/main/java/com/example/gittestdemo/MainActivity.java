package com.example.gittestdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.gittestdemo.adapter.MainRecyclerViewAdapter;
import com.example.gittestdemo.adapter.PostAdapter;
import com.example.gittestdemo.constant.HomeConstant;
import com.example.gittestdemo.ui.activity.FileMainActivity;
import com.example.gittestdemo.utils.MainItemDecoration;
import com.example.gittestdemo.video.VideoMp4Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView postsRecyclerView;
    private PostAdapter postAdapter;
    private RecyclerView mRecyclerView; //首页条目
    private List<HomeConstant> operations = new ArrayList<>(); //首页功能集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化RecyclerView
        initView();
        initData();

    }

    private void initData() {
        //初始化首页功能集合
        initListData();
        //初始化首页列表适配器
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(operations);
        //纵向展示
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加首页列表底部边距
        mRecyclerView.addItemDecoration(new MainItemDecoration());
        mRecyclerView.setAdapter(adapter);
        //首页列表条目点击
        adapter.setOnItemClickListener((type, position) -> {
            jumpToActivity(type, position);
        });
    }

    private void initListData() {
        operations.add(HomeConstant.document);
        operations.add(HomeConstant.movie);
        operations.add(HomeConstant.kotlin);
        operations.add(HomeConstant.animation);
        operations.add(HomeConstant.particle);
    }


    /**
     * 通过枚举类型跳转到不同Activity
     * @param type
     * @param pos
     */
   private void jumpToActivity(HomeConstant type, int pos){
        switch (type){
            case document:
                startActivity(new Intent(this, FileMainActivity.class));
                break;
            case movie:
                startActivity(new Intent(this, VideoMp4Activity.class));
                break;
        }
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);

    }
}