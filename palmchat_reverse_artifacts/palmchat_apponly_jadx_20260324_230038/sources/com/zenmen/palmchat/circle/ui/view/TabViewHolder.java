package com.zenmen.palmchat.circle.ui.view;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.lp2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class TabViewHolder extends RecyclerView.ViewHolder implements lp2 {
    public SparseArray<View> d;

    public TabViewHolder(View view) {
        super(view);
        this.d = new SparseArray<>();
    }

    public <T extends View> T l(int i) {
        T t = (T) this.d.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i);
        this.d.put(i, t2);
        return t2;
    }
}
