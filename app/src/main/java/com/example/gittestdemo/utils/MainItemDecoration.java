package com.example.gittestdemo.utils;

import android.graphics.Rect;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainItemDecoration extends RecyclerView.ItemDecoration {
    @Override
    public void getItemOffsets(@NonNull Rect outRect, int itemPosition, @NonNull RecyclerView parent) {
        super.getItemOffsets(outRect, itemPosition, parent);
        outRect.bottom = 20;

    }
}
