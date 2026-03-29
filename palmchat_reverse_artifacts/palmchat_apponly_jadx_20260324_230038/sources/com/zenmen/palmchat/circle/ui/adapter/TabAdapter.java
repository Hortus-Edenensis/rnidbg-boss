package com.zenmen.palmchat.circle.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.circle.ui.view.TabViewHolder;
import defpackage.dp2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public abstract class TabAdapter<T> extends RecyclerView.Adapter<TabViewHolder> implements dp2<T, TabViewHolder> {
    public List<T> e = new ArrayList();
    public int f = 0;
    public int g = 0;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TabViewHolder f13260a;

        public a(TabViewHolder tabViewHolder) {
            this.f13260a = tabViewHolder;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int adapterPosition = this.f13260a.getAdapterPosition();
            if (TabAdapter.this.f != adapterPosition) {
                TabAdapter.this.g = adapterPosition;
                TabAdapter tabAdapter = TabAdapter.this;
                tabAdapter.notifyItemChanged(tabAdapter.g);
                TabAdapter tabAdapter2 = TabAdapter.this;
                tabAdapter2.notifyItemChanged(tabAdapter2.f);
                TabAdapter.this.f = adapterPosition;
            }
            TabAdapter tabAdapter3 = TabAdapter.this;
            tabAdapter3.m(this.f13260a, adapterPosition, tabAdapter3.e.get(adapterPosition));
        }
    }

    public <W extends dp2> W f(List<T> list) {
        g(list);
        notifyItemRangeInserted(this.e.size() - list.size(), list.size());
        return this;
    }

    public <W extends dp2> W g(List<T> list) {
        this.e.addAll(list);
        return this;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i(i, this.e.get(i));
    }

    public abstract void h(TabViewHolder tabViewHolder, int i, T t, boolean z);

    public abstract int i(int i, T t);

    public void j(TabViewHolder tabViewHolder) {
        tabViewHolder.itemView.setOnClickListener(new a(tabViewHolder));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull TabViewHolder tabViewHolder, int i) {
        j(tabViewHolder);
        h(tabViewHolder, i, this.e.get(i), i == this.g);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public TabViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new TabViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(i, viewGroup, false));
    }

    public abstract void m(TabViewHolder tabViewHolder, int i, T t);

    public void n(int i) {
        if (this.f != i) {
            this.g = i;
            notifyItemChanged(i);
            notifyItemChanged(this.f);
            this.f = i;
        }
    }
}
