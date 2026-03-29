package com.zenmen.palmchat.circle.ui.view;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class RecyclerViewItemShowListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13301a = -1;
    public int b = -1;
    public a c;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);
    }

    public RecyclerViewItemShowListener(a aVar) {
        this.c = aVar;
    }

    public final void a(int i, int i2) {
        int i3;
        int i4 = this.f13301a;
        if (i4 < 0 || (i3 = this.b) < 0) {
            for (int i5 = i; i5 <= i2; i5++) {
                this.c.a(i5);
            }
        } else if (i < i4 || i2 > i3) {
            for (int i6 = i; i6 <= i2; i6++) {
                if (i6 < this.f13301a || i6 > this.b) {
                    this.c.a(i6);
                }
            }
        }
        this.f13301a = i;
        this.b = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        if (this.c == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            a(linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition());
        } else if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            a(gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition());
        }
    }
}
