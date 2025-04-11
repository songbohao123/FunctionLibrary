package com.example.gittestdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import com.example.gittestdemo.App;
import com.tencent.tbs.reader.ITbsReaderCallback;
import com.tencent.tbs.reader.TbsFileInterfaceImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * 文档工具类
 */
public class FileUtils {
    /**
     * 将 assets 中的文件复制到本地存储
     * @param assetFileName assets 中的文件名（如 "test.pdf"）
     * @return 复制后的文件绝对路径，失败返回 null
     */
    public static String copyAssetToLocal(String assetFileName, Context context) {
        try {
            // 目标路径：内部存储私有目录（无需权限）
            File outFile = new File(context.getFilesDir(), assetFileName);
            if (outFile.exists()) {
                return outFile.getAbsolutePath(); // 已存在则直接返回
            }

            // 从 assets 读取文件流
            AssetManager assetManager = context.getAssets();
            InputStream inputStream = assetManager.open(assetFileName);

            // 写入本地文件
            FileOutputStream outputStream = new FileOutputStream(outFile);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            outputStream.close();
            inputStream.close();

            return outFile.getAbsolutePath();
        } catch (Exception e) {
            Log.e(App.TAG, "复制文件失败", e);
            return null;
        }
    }

    public static int openFileReader(String fileName, String extName, String filePath, Context context){
        Bundle param = new Bundle();
        param.putString("filePath",filePath);
        param.putString("fileExt",extName);
        param.putString("tempPath",context.getExternalFilesDir("temp").getAbsolutePath());
        if(TbsFileInterfaceImpl.canOpenFileExt(extName)){
            TbsFileInterfaceImpl.getInstance().openFileReader(context, param, new ITbsReaderCallback() {
                @Override
                public void onCallBackAction(Integer integer, Object o, Object o1) {


                }
            }, null);
        }else {
            Log.i(App.TAG, "openFileReader: 不支持");
        }
        return 0;
    }
}
