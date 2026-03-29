package com.zenmen.palmchat.widget.adapters;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class EndlessScrollListener extends RecyclerView.OnScrollListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16014a;
    public a d;
    public boolean e;
    public int c = 1;
    public boolean b = true;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        void a(int i);

        void b();

        void c(int i);
    }

    public EndlessScrollListener(a aVar) {
        this.d = aVar;
    }

    public void a() {
        this.b = false;
        this.d.b();
    }

    public void b() {
        this.b = true;
        this.e = false;
    }

    public void c(int i) {
        this.f16014a = true;
        this.e = false;
        this.d.a(i);
    }

    public void d() {
        this.c = 1;
        this.f16014a = false;
        this.b = true;
        this.e = true;
    }

    public void e() {
        this.c = 1;
        this.f16014a = false;
        this.b = true;
        this.e = true;
        this.d.c(1);
    }

    public void f() {
        this.f16014a = false;
        if (this.e) {
            return;
        }
        this.e = true;
        this.d.c(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int childCount = linearLayoutManager.getChildCount();
        if (childCount + linearLayoutManager.findFirstVisibleItemPosition() < linearLayoutManager.getItemCount() || this.f16014a || !this.b || this.e) {
            return;
        }
        this.e = true;
        int i3 = this.c + 1;
        this.c = i3;
        this.d.c(i3);
    }
}
