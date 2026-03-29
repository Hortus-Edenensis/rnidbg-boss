package com.zenmen.palmchat.friendcircle.base.view.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRecyclerViewHolder<T> extends RecyclerView.ViewHolder {
    public int d;
    public ViewDataBinding e;

    public BaseRecyclerViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(LayoutInflater.from(context).inflate(i, viewGroup, false));
    }

    public final View l(int i) {
        View view;
        if (i <= 0 || (view = this.itemView) == null) {
            return null;
        }
        return view.findViewById(i);
    }

    public Context m() {
        return this.itemView.getContext();
    }

    public int n() {
        return this.d;
    }

    public abstract void o(T t, int i);

    public BaseRecyclerViewHolder(Context context, int i) {
        this(context, null, i);
    }

    public BaseRecyclerViewHolder(View view, int i) {
        super(view);
        this.d = i;
    }

    public BaseRecyclerViewHolder(ViewDataBinding viewDataBinding) {
        super(viewDataBinding.getRoot());
        this.e = viewDataBinding;
    }

    public void p(T t, int i, List<Object> list) {
    }
}
