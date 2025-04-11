package com.example.gittestdemo.ui.activity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.webkit.WebView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.gittestdemo.R;
import com.example.gittestdemo.adapter.CommonAdapter;
import com.example.gittestdemo.databinding.ActivityMainFileLayoutBinding;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tbs.reader.ITbsReader;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

/**
 * 文档主界面
 */
public class FileMainActivity extends AppCompatActivity {

    private ActivityMainFileLayoutBinding mBinding;
    private CommonAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData(){

    }




    private void initView() {
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_file_layout);
        adapter = new CommonAdapter(this);
        mBinding.documentRecycleView.setAdapter(adapter);
        mBinding.documentRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.documentRecycleView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter.setData(initList());
    }

    private List<String> initList() {
        return List.of("ADB的一些操作","文档二","文档三");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lzd", "onDestroy: 销毁");
        QbSdk.clearAllWebViewCache(this,true);
        TbsFileInterfaceImpl.getInstance().closeFileReader();
        QbSdk.clear(this);
        QbSdk.closeNetLogAndSavaToLocal();
        QbSdk.disableAutoCreateX5Webview();

    }
}
