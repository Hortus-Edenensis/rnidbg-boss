package com.zenmen.palmchat.utils;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class SDecoration extends RecyclerView.ItemDecoration {
    public final int b;
    public final int c;
    public final float d;

    public SDecoration(Context context, int i, int i2) {
        this.d = context.getResources().getDisplayMetrics().density;
        this.b = a(i);
        this.c = a(i2);
    }

    public final int a(int i) {
        return (int) ((this.d * i) + 0.5f);
    }

    public final void b(Rect rect, int i, GridLayoutManager gridLayoutManager, int i2) {
        int spanCount = gridLayoutManager.getSpanCount();
        if (spanCount == 0) {
            return;
        }
        int i3 = i % spanCount;
        int i4 = i / spanCount;
        int iCeil = (int) Math.ceil(((double) i2) / ((double) spanCount));
        int i5 = this.b;
        rect.left = (i3 * i5) / spanCount;
        rect.right = i5 - (((i3 + 1) * i5) / spanCount);
        int i6 = this.c;
        rect.top = (i4 * i6) / iCeil;
        rect.bottom = i6 - (((i4 + 1) * i6) / iCeil);
    }

    public final void c(Rect rect, int i, int i2) {
        rect.left = 0;
        rect.right = 0;
        if (i == 0) {
            rect.top = 0;
        } else {
            rect.top = this.c;
        }
        rect.bottom = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int itemCount = state.getItemCount();
        if (layoutManager instanceof GridLayoutManager) {
            b(rect, childAdapterPosition, (GridLayoutManager) layoutManager, itemCount);
        } else {
            c(rect, childAdapterPosition, itemCount);
        }
    }
}
