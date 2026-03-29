package com.zenmen.square.dynamiclife;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class DynamicLifeSpaceItem extends RecyclerView.ItemDecoration {
    public int b;

    public DynamicLifeSpaceItem(int i) {
        this.b = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i = this.b;
        rect.right = i;
        rect.bottom = i;
    }
}
