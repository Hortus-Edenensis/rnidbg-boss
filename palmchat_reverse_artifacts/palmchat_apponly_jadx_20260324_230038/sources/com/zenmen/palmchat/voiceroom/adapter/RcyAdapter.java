package com.zenmen.palmchat.voiceroom.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.am2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RcyAdapter<T, VH extends am2> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public Context e;
    public LayoutInflater f;
    public SparseArray<Integer> g = new SparseArray<>();
    public List<T> h = new ArrayList();

    public RcyAdapter(Context context, int... iArr) {
        this.e = context;
        this.f = LayoutInflater.from(context);
        int length = iArr == null ? 0 : iArr.length;
        for (int i = 0; i < length; i++) {
            this.g.put(iArr[i], Integer.valueOf(i));
        }
    }

    public abstract void a(VH vh, T t, int i, int i2);

    public abstract int b(T t, int i);

    public final int c(int i) {
        int size = this.g.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iKeyAt = this.g.keyAt(i2);
            if (this.g.get(iKeyAt).intValue() == i) {
                return iKeyAt;
            }
        }
        return -1;
    }

    public RcyHolder e(ViewGroup viewGroup, int i) {
        return new RcyHolder(this.f.inflate(i, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public RcyHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        int iC = c(i);
        if (iC >= 0) {
            return e(viewGroup, iC);
        }
        throw new IllegalArgumentException("No ViewHolder Setted for ViewType =" + i);
    }

    public synchronized void g(List<T> list, boolean z) {
        if (z) {
            try {
                this.h.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (list != null) {
            this.h.addAll(list);
        }
        notifyDataSetChanged();
    }

    public List<T> getData() {
        return this.h;
    }

    public T getItem(int i) {
        int itemCount = getItemCount();
        if (i < 0 || itemCount == 0 || i >= itemCount) {
            return null;
        }
        return this.h.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.h;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int iB = b(getItem(i), i);
        if (iB == -1) {
            return -1;
        }
        Integer num = this.g.get(iB);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("No ViewType Setted for position =" + i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        T item = getItem(i);
        a((am2) viewHolder, item, i, b(item, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
    }
}
