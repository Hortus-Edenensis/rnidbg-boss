package com.zenmen.square.comment.emoji.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.tn;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public abstract class BaseRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerViewHolder> {
    public List<T> e;
    public Context f;
    public b g;
    public int h;
    public float i;
    public float j;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RecyclerViewHolder f16187a;
        public final /* synthetic */ int b;

        public a(RecyclerViewHolder recyclerViewHolder, int i) {
            this.f16187a = recyclerViewHolder;
            this.b = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            BaseRecyclerAdapter.this.g.a(this.f16187a.itemView, this.b);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(View view, int i);
    }

    public BaseRecyclerAdapter(Context context, int i) {
        this(context, i, new ArrayList());
    }

    public abstract void b(RecyclerViewHolder recyclerViewHolder, int i, T t);

    public void c(List<T> list) {
        this.e.clear();
        if (list != null) {
            this.e.addAll(list);
        }
        notifyDataSetChanged();
    }

    public Context d() {
        return this.f;
    }

    public T e(int i) {
        List<T> list = this.e;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i) {
        if (recyclerViewHolder != null) {
            if (this.g != null) {
                recyclerViewHolder.itemView.setOnClickListener(new a(recyclerViewHolder, i));
            }
            b(recyclerViewHolder, i, this.e.get(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return RecyclerViewHolder.l(this.f, viewGroup, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.e.size();
    }

    public void h(b bVar) {
        this.g = bVar;
    }

    public BaseRecyclerAdapter(Context context, int i, List<T> list) {
        this.i = 0.0f;
        this.j = 0.0f;
        this.e = list;
        this.f = context;
        this.h = i;
        float fC = tn.c(context, 24.0f);
        this.j = fC;
        this.i = fC;
    }
}
