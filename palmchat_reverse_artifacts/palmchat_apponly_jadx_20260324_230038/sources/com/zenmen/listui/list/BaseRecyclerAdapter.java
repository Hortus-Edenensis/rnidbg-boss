package com.zenmen.listui.list;

import androidx.recyclerview.widget.RecyclerView;
import com.zenmen.listui.list.BaseBean;
import com.zenmen.listui.list.BaseViewHolder;
import defpackage.lm2;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public abstract class BaseRecyclerAdapter<H extends BaseViewHolder, B extends BaseBean, P extends lm2> extends RecyclerView.Adapter<H> {
    public List<B> e;
    public P f;

    public List<B> a() {
        return this.e;
    }

    public void b(List<B> list, int i, int i2) {
        this.e = list;
        notifyItemRangeInserted(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(H h, int i) {
        h.l(this.e.get(i), i);
    }

    public void d(List<B> list) {
        this.e = list;
        notifyDataSetChanged();
    }

    public void e(P p) {
        this.f = p;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<B> list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }
}
