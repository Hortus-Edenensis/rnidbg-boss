package com.zenmen.palmchat.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SSpaceItemDecoration1 extends RecyclerView.ItemDecoration {
    public final int b;

    public SSpaceItemDecoration1(Context context, int i) {
        this.b = (int) ((context.getResources().getDisplayMetrics().density * i) + 0.5f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            int itemCount = state.getItemCount();
            int i = this.b;
            rect.left = i;
            rect.right = i;
            rect.top = i;
            rect.bottom = i;
            if (childAdapterPosition == 0) {
                rect.top = 0;
            }
            if (childAdapterPosition == itemCount - 1) {
                rect.bottom = 0;
                return;
            }
            return;
        }
        int spanCount = ((GridLayoutManager) recyclerView.getLayoutManager()).getSpanCount();
        int itemCount2 = state.getItemCount();
        if (spanCount == 0) {
            return;
        }
        int i2 = childAdapterPosition % spanCount;
        int i3 = childAdapterPosition / spanCount;
        int iCeil = (int) Math.ceil(((double) itemCount2) / ((double) spanCount));
        int i4 = this.b;
        rect.left = i4;
        rect.right = i4;
        if (i2 == 0) {
            rect.left = 0;
        }
        if (i2 == spanCount - 1) {
            rect.right = 0;
        }
        rect.top = i4;
        rect.bottom = i4;
        if (i3 == 0) {
            rect.top = 0;
        }
        if (i3 == iCeil - 1) {
            rect.bottom = 0;
        }
    }
}
