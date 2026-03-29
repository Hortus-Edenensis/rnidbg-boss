package com.zenmen.palmchat.circle.ui.view;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class LinearItemDecoration extends RecyclerView.ItemDecoration {
    public int b;
    public int c;
    public RecyclerView.Adapter d;

    public LinearItemDecoration(RecyclerView.Adapter adapter) {
        this.d = adapter;
    }

    public int a() {
        return this.c;
    }

    public LinearItemDecoration b(int i) {
        this.c = i;
        return this;
    }

    public LinearItemDecoration c(int i) {
        this.b = i;
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int adapterPosition = recyclerView.getChildViewHolder(view).getAdapterPosition();
        rect.left = this.c;
        rect.top = this.b;
        rect.right = adapterPosition == this.d.getItemCount() + (-1) ? this.c : 0;
        rect.bottom = this.b;
    }
}
