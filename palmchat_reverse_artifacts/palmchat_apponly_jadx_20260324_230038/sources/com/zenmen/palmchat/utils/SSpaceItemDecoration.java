package com.zenmen.palmchat.utils;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SSpaceItemDecoration extends RecyclerView.ItemDecoration {
    public final int b;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = state.getItemCount();
        rect.left = 0;
        rect.right = 0;
        int i = this.b;
        rect.top = i / 2;
        rect.bottom = i / 2;
        if (childAdapterPosition == 0) {
            rect.top = 0;
        }
        if (childAdapterPosition == itemCount - 1) {
            rect.bottom = 0;
        }
    }
}
