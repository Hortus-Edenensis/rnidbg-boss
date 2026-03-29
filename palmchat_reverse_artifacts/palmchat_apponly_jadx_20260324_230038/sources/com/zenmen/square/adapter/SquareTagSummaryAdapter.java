package com.zenmen.square.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.square.mvp.holder.SquareTagSummaryViewHolder;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.ui.widget.SquareTagSummaryHelper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagSummaryAdapter extends RecyclerView.Adapter<SquareTagSummaryViewHolder> {
    public Context e;
    public List<a> f;
    public LayoutInflater g;
    public b h;
    public int i = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public SquareTagBean f16182a;
        public SquareTagSummaryHelper.Scene b;

        public SquareTagBean a() {
            return this.f16182a;
        }

        public void b(SquareTagBean squareTagBean) {
            this.f16182a = squareTagBean;
        }

        public void c(SquareTagSummaryHelper.Scene scene) {
            this.b = scene;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(a aVar, View view);
    }

    public SquareTagSummaryAdapter(@NonNull Context context, List<a> list) {
        this.e = context;
        this.f = list;
        if (list != null) {
            this.f = new ArrayList(list);
        } else {
            this.f = new ArrayList();
        }
        this.g = LayoutInflater.from(context);
    }

    public int a(int i) {
        return R$layout.square_layout_item_tag_summary;
    }

    public a b(SquareTagBean squareTagBean, SquareTagSummaryHelper.Scene scene) {
        a aVar = new a();
        aVar.b(squareTagBean);
        aVar.c(scene);
        return aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(SquareTagSummaryViewHolder squareTagSummaryViewHolder, int i) {
        squareTagSummaryViewHolder.o(this.f.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public SquareTagSummaryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SquareTagSummaryViewHolder squareTagSummaryViewHolder = new SquareTagSummaryViewHolder(this.g.inflate(a(i), viewGroup, false), i);
        squareTagSummaryViewHolder.p(this.h);
        return squareTagSummaryViewHolder;
    }

    public void f(b bVar) {
        this.h = bVar;
    }

    public void g(List<a> list) {
        List<a> list2 = this.f;
        if (list2 != null) {
            list2.clear();
            this.f.addAll(list);
        } else {
            this.f = list;
        }
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<a> list = this.f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return 0;
    }
}
