package com.zenmen.palmchat.ui.itemdecoration;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GridItemDecoration extends RecyclerView.ItemDecoration {
    public int b;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.b;
        rect.left = i;
        rect.right = i;
        rect.bottom = i;
        rect.top = i;
    }
}
