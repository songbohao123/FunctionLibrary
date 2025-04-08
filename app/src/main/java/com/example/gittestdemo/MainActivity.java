package com.example.gittestdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.gittestdemo.adapter.MainRecyclerViewAdapter;
import com.example.gittestdemo.files.FileMainActivity;
import com.example.gittestdemo.utils.MainItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 主界面
 */
public class MainActivity extends AppCompatActivity {
    private RecyclerView postsRecyclerView;
    private PostAdapter postAdapter;
    private RecyclerView mRecyclerView; //首页条目
    private List<Constant> operations = new ArrayList<>(); //首页功能集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化RecyclerView
        initView();
        initData();

//        WebViewUtils webViewUtils = new WebViewUtils(this, null, 0);
//        webViewUtils.initWebView(new ProgressBar(this,null,0),"https://docs.qq.com/doc/DZElWZFhVVGZwQWl5?u=cc390812d3104e609ee3cffb8a79ff67",true);
//        addContentView(webViewUtils,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        postsRecyclerView = findViewById(R.id.postsRecyclerView);
//        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
//
//        // 加载数据
//        List<Post> postList = new ArrayList<>();
//        postList.add(new Post("User1", "Hello, this is my first post!"));
//        postList.add(new Post("User2", "Having a great day!"));
//        postList.add(new Post("User3", "Just finished my project."));
//
//        // 设置Adapter
//        postAdapter = new PostAdapter(postList);
//        postsRecyclerView.setAdapter(postAdapter);
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
        adapter.setOnItemClickListener((type,position) -> {
            Toast.makeText(this, "点击了: " + type, Toast.LENGTH_SHORT).show();
            jumpToActivity(type,position);
        });
    }

    private void initListData() {
        operations.add(Constant.document);
        operations.add(Constant.movie);
        operations.add(Constant.kotlin);
        operations.add(Constant.animation);
        operations.add(Constant.particle);
    }


    /**
     * 通过枚举类型跳转到不同Activity
     * @param type
     * @param pos
     */
   private void jumpToActivity(Constant type,int pos){
        switch (type){
            case document:
                startActivity(new Intent(this, FileMainActivity.class));
                break;
        }
   }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);

    }
}