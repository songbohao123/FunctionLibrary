package com.example.gittestdemo;

import static com.tencent.tbs.reader.TbsFileInterfaceImpl.initEngineAsync;
import static com.tencent.tbs.reader.TbsFileInterfaceImpl.setLicenseKey;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.tbs.reader.ITbsReaderCallback;

import java.util.HashMap;


public class App extends Application {
    private static final String LicenseKey =  "PfJMj9s+GZXVNEIUlxm04KgUJqIyBKjkKQN4Txl7u5615sBQ697LmHjvCk9F5JF6";
    public static Context context;
    public static String TAG = "FunctionLibrary";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        context = base;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("FunctionLibrary", "onCreate: ");
        initTBSSDK(this);
    }

    private void initTBSSDK(Context context) {
        setLicenseKey(LicenseKey);
        initEngineAsync(context, (integer, o, o1) -> {
          //  0：加载 SDK 成功 非0：加载 SDK 失败
            Log.i(TAG, "initTBSSDK: "+o);
        });
        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Log.d(TAG, "X5 内核初始化完成");
                // 尝试设置无缓存模式（部分版本支持）
            }
            @Override
            public void onViewInitFinished(boolean isSuccess) {
                Log.d(TAG, "X5 视图初始化: " + isSuccess);
            }
        });

    }
}
