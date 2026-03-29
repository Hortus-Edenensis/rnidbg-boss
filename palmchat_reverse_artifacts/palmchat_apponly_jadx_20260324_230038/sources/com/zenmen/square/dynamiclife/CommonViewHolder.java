package com.zenmen.square.dynamiclife;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class CommonViewHolder extends RecyclerView.ViewHolder {
    public SparseArray<View> d;
    public RecyclerView e;
    public int f;

    public CommonViewHolder(View view, ViewGroup viewGroup, int i) {
        super(view);
        this.f = i <= 4 ? 8 : i;
        this.e = (RecyclerView) viewGroup;
    }

    public <T extends View> T l(@IdRes int i) {
        if (this.d == null) {
            this.d = new SparseArray<>(this.f);
        }
        T t = (T) this.d.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i);
        this.d.put(i, t2);
        return t2;
    }

    public Context m() {
        return this.itemView.getContext();
    }

    public CommonViewHolder n(@IdRes int i, String str) {
        ((TextView) l(i)).setText(str);
        return this;
    }
}
