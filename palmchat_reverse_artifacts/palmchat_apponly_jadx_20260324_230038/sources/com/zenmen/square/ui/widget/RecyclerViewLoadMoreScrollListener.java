package com.zenmen.square.ui.widget;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class RecyclerViewLoadMoreScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16553a;
    public boolean b;
    public int c;
    public boolean d;

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager.getChildCount() + linearLayoutManager.findFirstVisibleItemPosition() < linearLayoutManager.getItemCount() || this.f16553a || !this.b || this.d) {
            return;
        }
        this.d = true;
        this.c++;
        throw null;
    }
}
