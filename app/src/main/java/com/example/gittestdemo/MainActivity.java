package com.example.gittestdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.gittestdemo.adapter.MainRecyclerViewAdapter;
import com.example.gittestdemo.utils.MainItemDecoration;
import com.example.gittestdemo.utils.WebViewUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView postsRecyclerView;
    private PostAdapter postAdapter;
    private RecyclerView mRecyclerView;
    private List<String> operations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 初始化RecyclerView
        initView();
        initData();
        WebViewUtils webViewUtils = new WebViewUtils(this, null, 0);
        webViewUtils.initWebView(new ProgressBar(this,null,0),"https://www.baidu.com/",true);
        addContentView(webViewUtils,new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
//        postsRecyclerView = findViewById(R.id.postsRecyclerView);
//        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

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
        initListData();
        MainRecyclerViewAdapter adapter = new MainRecyclerViewAdapter(operations);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new MainItemDecoration());
        mRecyclerView.setAdapter(adapter);
    }

    private void initListData() {
        operations.add("功能1");
        operations.add("功能2");
        operations.add("功能3");
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recyclerView);

    }
}