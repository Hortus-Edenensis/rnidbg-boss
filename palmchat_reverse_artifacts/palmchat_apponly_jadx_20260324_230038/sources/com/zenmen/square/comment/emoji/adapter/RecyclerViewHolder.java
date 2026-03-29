package com.zenmen.square.comment.emoji.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    public final SparseArray<View> d;
    public Context e;

    public RecyclerViewHolder(Context context, View view) {
        super(view);
        this.e = context;
        this.d = new SparseArray<>();
    }

    public static RecyclerViewHolder l(Context context, ViewGroup viewGroup, int i) {
        return new RecyclerViewHolder(context, LayoutInflater.from(context).inflate(i, viewGroup, false));
    }

    public <T extends View> T m(int i) {
        T t = (T) this.d.get(i);
        if (t != null) {
            return t;
        }
        T t2 = (T) this.itemView.findViewById(i);
        this.d.put(i, t2);
        return t2;
    }

    public RecyclerViewHolder n(int i, int i2) {
        ((ImageView) m(i)).setImageResource(i2);
        return this;
    }
}
