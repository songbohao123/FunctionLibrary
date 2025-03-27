package com.example.gittestdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView postsRecyclerView;
    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hudong);
        // 初始化RecyclerView
        postsRecyclerView = findViewById(R.id.postsRecyclerView);
        postsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 加载数据
        List<Post> postList = new ArrayList<>();
        postList.add(new Post("User1", "Hello, this is my first post!"));
        postList.add(new Post("User2", "Having a great day!"));
        postList.add(new Post("User3", "Just finished my project."));

        // 设置Adapter
        postAdapter = new PostAdapter(postList);
        postsRecyclerView.setAdapter(postAdapter);
    }
}