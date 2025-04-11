package com.example.gittestdemo.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gittestdemo.R;
import com.example.gittestdemo.utils.FileUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/**
 * 公用适配器，暂时只使用一个title ，后期可根据需求自行添加字段
 */
public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.ViewHolder>{
    WeakReference<Activity> mActivity;
    List<String> titles ;

    //打开文件需要使用到Activity
    public CommonAdapter(Activity activity){
        this.mActivity = new WeakReference<Activity>(activity);
    }
    public CommonAdapter(){}

    public void setData(List<String> t){
        if(t == null){
            titles = new ArrayList<>();
            return;
        }
        titles = t;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.common_recycle_view_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.itemView.setOnClickListener((v)->{
            if(position == 0){
                FileUtils.openFileReader("document_1.docx","docx",FileUtils.copyAssetToLocal("document_1.docx",mActivity.get()),mActivity.get());
            } else {
                Toast.makeText(v.getContext(), "敬请期待。。。",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles == null ? 0 : titles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.common_title);
        }
    }

}
