package com.example.gittestdemo.files;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.gittestdemo.R;
import com.example.gittestdemo.constant.FileConstant;
import com.example.gittestdemo.databinding.ActivityFilePreViewBinding;
import com.tencent.smtt.sdk.WebSettings;

public class FilePreViewActivity extends AppCompatActivity {

    private ActivityFilePreViewBinding mBinding ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_file_pre_view);
        String stringExtra = getIntent().getStringExtra(FileConstant.FILE_LINK);

        initializeWebSetting();

        mBinding.webView.loadUrl(stringExtra);
    }

    /**
     * 初始化webSetting
     */
    private void initializeWebSetting() {
        mBinding.webView.getSettings().setJavaScriptEnabled(true);  // 支持JS
        mBinding.webView.getSettings().setDefaultTextEncodingName("UTF-8");  // 设置编码格式
        mBinding.webView.getSettings().setAllowFileAccess(true); //设置可访问文件
        mBinding.webView.getSettings().setPluginState(WebSettings.PluginState.ON);// 支持插件
        mBinding.webView.getSettings().setLoadsImagesAutomatically(true); // 支持自动加载图片
        mBinding.webView.getSettings().setAppCacheMaxSize(1024 * 1024 * 8);
        // 设置WebView是否可以由JavaScript自动打开窗口，默认为false，通常与JavaScript的window.open()配合使用。
        mBinding.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
        mBinding.webView.getSettings().setUseWideViewPort(true); // 屏幕适配
        mBinding.webView.getSettings().setSupportZoom(true); // 缩放操作
        mBinding.webView.getSettings().setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        mBinding.webView.getSettings().setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        // 设置html页面定位的支持
        // 同时也要在清单文件里设置定位的权限支持：
        // <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
        // <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />　
        mBinding.webView.getSettings().setGeolocationEnabled(true);
        // 支持内容重新布局
        // 1.NARROW_COLUMNS：可能的话使所有列的宽度不超过屏幕宽度
        // 2.NORMAL：正常显示不做任何渲染
        // 3.SINGLE_COLUMN：把所有内容放大webview等宽的一列中
        // 用SINGLE_COLUMN类型可以设置页面居中显示，页面可以放大缩小，但这种方法不怎么好，有时候会让你的页面布局走样而且我测了一下，只能显示中间那一块，超出屏幕的部分都不能显示。
        mBinding.webView.getSettings().setLayoutAlgorithm(com.tencent.smtt.sdk.WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        mBinding.webView.getSettings().setSupportMultipleWindows(true); // 设置WebView是否支持多窗口。
        // 设置缓存模式。通常我们可以根据网络情况将这几种模式结合使用，比如有网的时候使用LOAD_DEFAULT，离线时使用LOAD_CACHE_ONLY、LOAD_CACHE_ELSE_NETWORK，让用户不至于在离线时啥都看不到。
        // 缓存模式有四种：
        // LOAD_DEFAULT：默认的缓存使用模式。在进行页面前进或后退的操作时，如果缓存可用并未过期就优先加载缓存，否则从网络上加载数据。这样可以减少页面的网络请求次数。
        // LOAD_CACHE_ELSE_NETWORK：只要缓存可用就加载缓存，哪怕它们已经过期失效。如果缓存不可用就从网络上加载数据。
        // LOAD_NO_CACHE：不加载缓存，只从网络加载数据。微信H5支付时需要设置。
        // LOAD_CACHE_ONLY：不从网络加载数据，只从缓存加载数据。
        mBinding.webView.getSettings().setCacheMode(com.tencent.smtt.sdk.WebSettings.LOAD_DEFAULT);
        mBinding.webView.getSettings().setDomStorageEnabled(true); // 启用或禁用DOM缓存。
        mBinding.webView.getSettings().setDatabaseEnabled(true); //启用或禁用数据库缓存。
        mBinding.webView.getSettings().setAppCacheEnabled(true);// 启用或禁用应用缓存。
        mBinding.webView.getSettings().setDisplayZoomControls(false); //隐藏原生的缩放控件（wap网页不支持）
    }

    @Override
    protected void onDestroy() {
        //释放资源
        mBinding.webView.destroy();

        super.onDestroy();
    }
}