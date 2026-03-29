package com.zenmen.palmchat.square;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SBaseViewHolder<T, VB extends ViewBinding> extends RecyclerView.ViewHolder {
    public VB d;

    public SBaseViewHolder(@NonNull VB vb) {
        super(vb.getRoot());
        this.d = vb;
    }

    public abstract void l(SBaseViewHolder<T, VB> sBaseViewHolder, T t, int i);
}
