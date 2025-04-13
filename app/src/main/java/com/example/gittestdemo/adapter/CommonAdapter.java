package com.example.gittestdemo.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gittestdemo.R;
import com.example.gittestdemo.constant.FileConstant;
import com.example.gittestdemo.files.FilePreViewActivity;
import com.example.gittestdemo.model.FileModel;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 公用适配器，暂时只使用一个title ，后期可根据需求自行添加字段
 */
public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.ViewHolder>{
    WeakReference<Activity> mActivity;
    List<FileModel> fileModels ;

    //打开文件需要使用到Activity
    public CommonAdapter(Activity activity){
        this.mActivity = new WeakReference<Activity>(activity);
    }
    public CommonAdapter(){}

    public void setData(List<FileModel> t){
        if(t == null){
            fileModels = new ArrayList<>();
            return;
        }
        fileModels = t;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.common_recycle_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        FileModel fileModel = fileModels.get(position);
        holder.title.setText(fileModel.getTitle());
        holder.itemView.setOnClickListener((v)->{
            if(!fileModel.getUrl().isBlank()){
//                FileUtils.openFileReader("document_1.docx","docx",FileUtils.copyAssetToLocal("document_1.docx",mActivity.get()),mActivity.get());
                Intent intent = new Intent(mActivity.get(), FilePreViewActivity.class);
                intent.putExtra(FileConstant.FILE_NAME,fileModel.getTitle());
                intent.putExtra(FileConstant.FILE_LINK,fileModel.getUrl());
                mActivity.get().startActivity(intent);
            } else {
                Toast.makeText(v.getContext(), "敬请期待。。。",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return fileModels == null ? 0 : fileModels.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.common_title);
        }
    }

}
