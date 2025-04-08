package com.example.gittestdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gittestdemo.R;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {
    private final List<String> titles;

    public MainRecyclerViewAdapter(List<String> titles) {
        this.titles = titles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_recycle_view_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String title = titles.get(position);
        holder.title.setText(title);

        // 根据标题设置对应的图标
        switch (title) {
            case "文档":
                holder.icon.setImageResource(R.mipmap.word);
                break;
            case "kotlin":
                holder.icon.setImageResource(R.mipmap.kotlin);
                break;
            case "影视":
                holder.icon.setImageResource(R.mipmap.televison);
                break;
            default:
                // 设置默认图标或保持为空
                holder.icon.setImageResource(R.mipmap.ic_launcher);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.main_title_text);
            icon = itemView.findViewById(R.id.im_icon1);
        }
    }
}