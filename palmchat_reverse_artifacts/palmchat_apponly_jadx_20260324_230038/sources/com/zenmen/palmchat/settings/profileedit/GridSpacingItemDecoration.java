package com.zenmen.palmchat.settings.profileedit;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
    public int b;

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.left = 0;
        int i = this.b;
        rect.right = i;
        rect.bottom = i;
        rect.top = 0;
    }
}
