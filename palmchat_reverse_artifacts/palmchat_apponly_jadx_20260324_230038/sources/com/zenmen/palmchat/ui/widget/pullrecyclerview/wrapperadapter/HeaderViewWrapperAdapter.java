package com.zenmen.palmchat.ui.widget.pullrecyclerview.wrapperadapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import defpackage.cx1;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
public class HeaderViewWrapperAdapter extends RecyclerView.Adapter {
    public static final ArrayList<cx1> j = new ArrayList<>();
    public final RecyclerView.Adapter e;
    public RecyclerView f;
    public final ArrayList<cx1> g;
    public final ArrayList<cx1> h;
    public RecyclerView.AdapterDataObserver i;

    /* JADX INFO: compiled from: SearchBox */
    public static final class HeaderOrFooterViewHolder extends RecyclerView.ViewHolder {
        public HeaderOrFooterViewHolder(View view) {
            super(view);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends RecyclerView.AdapterDataObserver {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onChanged() {
            HeaderViewWrapperAdapter.this.notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeChanged(int i, int i2) {
            HeaderViewWrapperAdapter headerViewWrapperAdapter = HeaderViewWrapperAdapter.this;
            headerViewWrapperAdapter.notifyItemRangeChanged(i + headerViewWrapperAdapter.l(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeInserted(int i, int i2) {
            HeaderViewWrapperAdapter headerViewWrapperAdapter = HeaderViewWrapperAdapter.this;
            headerViewWrapperAdapter.notifyItemRangeInserted(i + headerViewWrapperAdapter.l(), i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeMoved(int i, int i2, int i3) {
            int iL = HeaderViewWrapperAdapter.this.l();
            HeaderViewWrapperAdapter.this.notifyItemRangeChanged(i + iL, i2 + iL + i3);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public void onItemRangeRemoved(int i, int i2) {
            HeaderViewWrapperAdapter headerViewWrapperAdapter = HeaderViewWrapperAdapter.this;
            headerViewWrapperAdapter.notifyItemRangeRemoved(i + headerViewWrapperAdapter.l(), i2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b extends GridLayoutManager.SpanSizeLookup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager f15665a;

        public b(GridLayoutManager gridLayoutManager) {
            this.f15665a = gridLayoutManager;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            if (HeaderViewWrapperAdapter.this.n(i) || HeaderViewWrapperAdapter.this.m(i)) {
                return this.f15665a.getSpanCount();
            }
            return 1;
        }
    }

    public HeaderViewWrapperAdapter(RecyclerView recyclerView, @NonNull RecyclerView.Adapter adapter, ArrayList<cx1> arrayList, ArrayList<cx1> arrayList2) {
        a aVar = new a();
        this.i = aVar;
        this.f = recyclerView;
        this.e = adapter;
        try {
            adapter.registerAdapterDataObserver(aVar);
        } catch (IllegalStateException unused) {
        }
        if (arrayList == null) {
            this.g = j;
        } else {
            this.g = arrayList;
        }
        if (arrayList2 == null) {
            this.h = j;
        } else {
            this.h = arrayList2;
        }
    }

    public final void c(View view) {
        if (view == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(-1, -2)));
        } else if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            layoutParams = this.f.getLayoutManager().generateLayoutParams(layoutParams);
        }
        view.setLayoutParams(layoutParams);
    }

    public int d(View view) {
        if (view == null) {
            return -1;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (this.g.get(i).f16943a == view) {
                return l() + this.e.getItemCount() + i;
            }
        }
        return -1;
    }

    public int e(View view) {
        if (view == null) {
            return -1;
        }
        for (int i = 0; i < this.g.size(); i++) {
            if (this.g.get(i).f16943a == view) {
                return i;
            }
        }
        return -1;
    }

    public final void f(GridLayoutManager gridLayoutManager) {
        gridLayoutManager.setSpanSizeLookup(new b(gridLayoutManager));
    }

    public final void g(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager != null && (layoutManager instanceof GridLayoutManager)) {
            f((GridLayoutManager) layoutManager);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int iL;
        int iJ;
        if (this.e != null) {
            iL = l() + j();
            iJ = this.e.getItemCount();
        } else {
            iL = l();
            iJ = j();
        }
        return iL + iJ;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        int iL = l();
        RecyclerView.Adapter adapter = this.e;
        if (adapter == null) {
            return -1;
        }
        int i2 = i - iL;
        int itemCount = adapter.getItemCount();
        if (i >= iL) {
            if (i2 < itemCount) {
                return this.e.getItemViewType(i2);
            }
        } else if (i < iL) {
            return this.g.get(i).b;
        }
        return this.h.get((i - itemCount) - iL).b;
    }

    public final void h(RecyclerView.ViewHolder viewHolder) {
        ViewGroup.LayoutParams layoutParams;
        int layoutPosition = viewHolder.getLayoutPosition();
        if ((n(layoutPosition) || m(layoutPosition)) && (layoutParams = viewHolder.itemView.getLayoutParams()) != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public final int i(int i) {
        return Math.abs(i) - Math.abs(-99);
    }

    public int j() {
        return this.h.size();
    }

    public final int k(int i) {
        return Math.abs(i) - Math.abs(-2);
    }

    public int l() {
        return this.g.size();
    }

    public final boolean m(int i) {
        return i > (l() + this.e.getItemCount()) - 1;
    }

    public final boolean n(int i) {
        return i < l();
    }

    public final boolean o(int i) {
        return this.h.size() > 0 && i <= -99;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        g(recyclerView.getLayoutManager());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        int i2;
        int iL = l();
        int itemCount = this.e.getItemCount();
        if (i >= iL && i <= (iL + itemCount) - 1 && (i2 = i - iL) < itemCount) {
            this.e.onBindViewHolder(viewHolder, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (p(i)) {
            View view = this.g.get(k(i)).f16943a;
            c(view);
            return new HeaderOrFooterViewHolder(view);
        }
        if (!o(i)) {
            return this.e.onCreateViewHolder(viewGroup, i);
        }
        View view2 = this.h.get(i(i)).f16943a;
        c(view2);
        return new HeaderOrFooterViewHolder(view2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        h(viewHolder);
    }

    public final boolean p(int i) {
        return this.g.size() > 0 && i <= -2 && i > -99;
    }
}
