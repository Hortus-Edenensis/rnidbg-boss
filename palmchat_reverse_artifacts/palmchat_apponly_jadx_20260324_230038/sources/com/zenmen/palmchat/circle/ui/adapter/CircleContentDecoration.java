package com.zenmen.palmchat.circle.ui.adapter;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.a46;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class CircleContentDecoration extends RecyclerView.ItemDecoration {
    public boolean b;

    public CircleContentDecoration(boolean z) {
        this.b = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view) % 3;
        if (childLayoutPosition == 0) {
            rect.left = a46.b(recyclerView.getContext(), 18.0f);
            rect.right = a46.b(recyclerView.getContext(), 6.0f);
        } else if (childLayoutPosition == 1) {
            rect.left = a46.b(recyclerView.getContext(), 12.0f);
            rect.right = a46.b(recyclerView.getContext(), 12.0f);
        } else if (childLayoutPosition == 2) {
            rect.left = a46.b(recyclerView.getContext(), 6.0f);
            rect.right = a46.b(recyclerView.getContext(), 18.0f);
        }
        if (this.b) {
            int itemCount = recyclerView.getLayoutManager().getItemCount();
            Log.d("last_position", "count:" + recyclerView.getChildCount());
            int i = itemCount % 3 == 0 ? (itemCount / 3) - 1 : itemCount / 3;
            if (recyclerView.getChildLayoutPosition(view) >= i * 3) {
                Log.d("last_position", "position:" + recyclerView.getChildLayoutPosition(view) + "  line:" + i);
                rect.bottom = a46.b(recyclerView.getContext(), 30.0f);
            }
        }
    }
}
