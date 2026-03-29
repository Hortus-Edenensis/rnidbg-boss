package com.zenmen.square.tag.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.palmchat.framework.R$layout;
import com.zenmen.square.tag.bean.SquareTagBean;
import com.zenmen.square.tag.viewholder.SquareTagViewHolder;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class SquareTagAdapter extends RecyclerView.Adapter<SquareTagViewHolder> {
    public Context e;
    public List<a> f;
    public LayoutInflater g;
    public b h;
    public int i = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16484a;
        public SquareTagBean b;
        public boolean c;

        public SquareTagBean b() {
            return this.b;
        }

        public int c() {
            return this.f16484a;
        }

        public boolean d() {
            return this.c;
        }

        public void e(SquareTagBean squareTagBean) {
            this.b = squareTagBean;
        }

        public void f(boolean z) {
            this.c = z;
        }

        public void g(int i) {
            this.f16484a = i;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface b {
        void a(a aVar, View view);
    }

    public SquareTagAdapter(@NonNull Context context, List<a> list) {
        this.e = context;
        this.f = list;
        if (list != null) {
            this.f = new ArrayList(list);
        } else {
            this.f = new ArrayList();
        }
        this.g = LayoutInflater.from(context);
    }

    public List<a> a() {
        return this.f;
    }

    public int b(int i) {
        if (i == 0) {
            return R$layout.square_layout_item_tag_small;
        }
        if (i == 1) {
            return R$layout.square_layout_item_tag_large;
        }
        if (i == 100) {
            return R$layout.square_layout_item_tag_total;
        }
        if (i == 101) {
            return com.zenmen.square.R$layout.square_layout_item_tag_dialog;
        }
        return 0;
    }

    public ArrayList<SquareTagBean> c() {
        ArrayList<SquareTagBean> arrayList = new ArrayList<>();
        for (a aVar : this.f) {
            if (aVar.d()) {
                arrayList.add(aVar.b);
            }
        }
        return arrayList;
    }

    public a d(SquareTagBean squareTagBean) {
        a aVar = new a();
        aVar.g(101);
        aVar.e(squareTagBean);
        return aVar;
    }

    public a e(SquareTagBean squareTagBean) {
        a aVar = new a();
        aVar.g(1);
        aVar.e(squareTagBean);
        return aVar;
    }

    public a f(SquareTagBean squareTagBean) {
        a aVar = new a();
        aVar.g(0);
        aVar.e(squareTagBean);
        return aVar;
    }

    public a g() {
        a aVar = new a();
        aVar.g(100);
        return aVar;
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
        if (i < 0 || i >= this.f.size()) {
            return 0;
        }
        return this.f.get(i).c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(SquareTagViewHolder squareTagViewHolder, int i) {
        if (i < 0 || i >= this.f.size()) {
            return;
        }
        squareTagViewHolder.p(this.f.get(i), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public SquareTagViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        SquareTagViewHolder squareTagViewHolder = new SquareTagViewHolder(this.g.inflate(b(i), viewGroup, false), i);
        squareTagViewHolder.q(this.h);
        return squareTagViewHolder;
    }

    public boolean j(int i) {
        int i2 = this.i;
        boolean z = false;
        if (i2 == 1) {
            boolean z2 = false;
            for (a aVar : this.f) {
                if (aVar.b() == null || aVar.b().getId() != i) {
                    aVar.f(false);
                } else {
                    aVar.f(true);
                    z2 = true;
                }
            }
            z = z2;
        } else if (i2 > 1) {
            int size = c().size();
            for (a aVar2 : this.f) {
                if (aVar2.b() != null && aVar2.b().getId() == i) {
                    if (aVar2.d()) {
                        aVar2.f(false);
                    } else {
                        if (size >= this.i) {
                            return false;
                        }
                        aVar2.f(true);
                    }
                    z = true;
                }
            }
        } else {
            for (a aVar3 : this.f) {
                if (aVar3.b() != null && aVar3.b().getId() == i) {
                    if (aVar3.d()) {
                        aVar3.f(false);
                    } else {
                        aVar3.f(true);
                    }
                    z = true;
                }
            }
        }
        notifyDataSetChanged();
        return z;
    }

    public void k(b bVar) {
        this.h = bVar;
    }

    public void l(int i) {
        this.i = i;
    }

    public void m(List<a> list) {
        List<a> list2 = this.f;
        if (list2 != null) {
            list2.clear();
            this.f.addAll(list);
        } else {
            this.f = list;
        }
        notifyDataSetChanged();
    }
}
