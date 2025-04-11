package com.example.gittestdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gittestdemo.R;
import com.example.gittestdemo.constant.HomeConstant;

import java.util.List;

public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder> {
    private final List<HomeConstant> titles;
    public interface OnItemClickListener {
        void onItemClick(HomeConstant type, int position);
    }

    private static OnItemClickListener mListener;

    // 设置监听方法
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }


    public MainRecyclerViewAdapter(List<HomeConstant> titles) {
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
        HomeConstant type  = titles.get(position);
        holder.title.setText(type.mName);
        // 根据标题设置对应的图标
        switch (type) {
            case document:
                holder.icon.setImageResource(R.mipmap.word);
                break;
            case kotlin:
                holder.icon.setImageResource(R.mipmap.kotlin);
                break;
            case movie:
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

     class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.main_title_text);
            icon = itemView.findViewById(R.id.im_icon1);
            itemView.setOnClickListener(v -> {
                if (mListener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        mListener.onItemClick(titles.get(position),position);
                    }
                }
            });
        }
    }
}