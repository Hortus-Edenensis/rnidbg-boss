package com.zenmen.square.dynamiclife;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.square.dynamiclife.exception.ViewBinderNotFoundException;
import defpackage.rf6;
import defpackage.sf6;
import defpackage.zu2;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class MultiTypeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public LayoutInflater f;
    public zu2 h;
    public sf6 g = new sf6();
    public List<Object> e = Collections.emptyList();

    public final zu2 a(int i) {
        return i == Integer.MAX_VALUE ? this.h : this.g.get(i).b;
    }

    public void b(@NonNull rf6 rf6Var) {
        rf6Var.b.f22515a = this;
        this.g.add(rf6Var);
    }

    public <T> void c(@NonNull Class<T> cls, @NonNull zu2<T, ?> zu2Var) {
        b(new rf6(cls, zu2Var));
    }

    public void d(@Nullable List<Object> list) {
        this.e.clear();
        if (list == null) {
            this.e = Collections.emptyList();
        } else {
            this.e = list;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long getItemId(int i) {
        int itemViewType = getItemViewType(i);
        return a(itemViewType).a(this.e.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i) {
        Object obj = this.e.get(i);
        int iA = this.g.a(obj.getClass());
        int iA2 = iA != -1 ? this.g.get(iA).c.a(obj, i) : 0;
        if (iA != -1 && iA2 != -1) {
            return iA + iA2;
        }
        if (this.h != null) {
            return Integer.MAX_VALUE;
        }
        throw new ViewBinderNotFoundException(obj.getClass());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder(viewHolder, i, Collections.emptyList());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.f == null) {
            this.f = LayoutInflater.from(viewGroup.getContext());
        }
        return a(i).d(this.f, viewGroup);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final boolean onFailedToRecycleView(RecyclerView.ViewHolder viewHolder) {
        return a(viewHolder.getItemViewType()).e(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        a(viewHolder.getItemViewType()).f(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
        a(viewHolder.getItemViewType()).g(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        a(viewHolder.getItemViewType()).h(viewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List<Object> list) {
        int itemViewType = getItemViewType(i);
        a(itemViewType).c(viewHolder, this.e.get(i), i, list);
    }
}
