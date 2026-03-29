package com.zenmen.palmchat.voiceroom.adapter;

import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.am2;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class RcyHolder extends RecyclerView.ViewHolder implements am2<RcyHolder> {
    public SparseArray<View> d;

    public RcyHolder(View view) {
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
