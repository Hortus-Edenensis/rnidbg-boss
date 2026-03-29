package com.zenmen.palmchat.square;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.square.SMultRecycleAdapter.ViewHolder;
import defpackage.b05;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SMultRecycleAdapter<T, VH extends ViewHolder<T>> extends RecyclerView.Adapter<VH> {
    public List<T> e = new ArrayList();
    public HashMap<Class<?>, Integer> f = new HashMap<>();
    public HashMap<Integer, a> g = new HashMap<>();

    /* JADX INFO: compiled from: SearchBox */
    public static abstract class ViewHolder<T> extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View view) {
            super(view);
        }

        public abstract void l(T t, int i);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface a<VH extends ViewHolder> {
        VH a(ViewGroup viewGroup);
    }

    public <F> void a(Class<? extends F> cls, a<? extends ViewHolder<? extends F>> aVar) {
        int size = this.g.size();
        this.f.put(cls, Integer.valueOf(size));
        this.g.put(Integer.valueOf(size), aVar);
    }

    public List<T> b() {
        return this.e;
    }

    public int c(Class<?> cls) {
        if (this.f.size() > 0) {
            while (cls != Object.class) {
                if (this.f.containsKey(cls)) {
                    return this.f.get(cls).intValue();
                }
                cls = cls.getSuperclass();
            }
        }
        return Integer.MIN_VALUE;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull VH vh, int i) {
        vh.l(this.e.get(i), i);
    }

    public VH e(ViewGroup viewGroup) {
        b05.a("onCreateViewHolder(ViewGroup, int) is not implemented.");
        throw new RuntimeException("onCreateViewHolder(ViewGroup, int) is not implemented.");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return this.g.size() > 0 ? (VH) this.g.get(Integer.valueOf(i)).a(viewGroup) : (VH) e(viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<T> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        T t = this.e.get(i);
        if (this.f.size() <= 0) {
            return c(t.getClass());
        }
        int iC = c(t.getClass());
        return iC != Integer.MIN_VALUE ? iC : c(t.getClass());
    }
}
