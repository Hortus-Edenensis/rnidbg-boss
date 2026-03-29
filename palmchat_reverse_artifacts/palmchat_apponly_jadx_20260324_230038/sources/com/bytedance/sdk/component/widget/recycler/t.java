package com.bytedance.sdk.component.widget.recycler;

import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class t extends RecyclerView.iz {
    boolean n = true;

    public final void a(RecyclerView.q qVar) {
        iz(qVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public boolean fx(RecyclerView.q qVar, RecyclerView.iz.nr nrVar, RecyclerView.iz.nr nrVar2) {
        int i = nrVar.u;
        int i2 = nrVar2.u;
        if (i != i2 || nrVar.nr != nrVar2.nr) {
            return u(qVar, i, nrVar.nr, i2, nrVar2.nr);
        }
        a(qVar);
        return false;
    }

    public final void jk(RecyclerView.q qVar) {
        iz(qVar);
    }

    public final void n(RecyclerView.q qVar) {
        iz(qVar);
    }

    public abstract boolean nr(RecyclerView.q qVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public boolean nr(RecyclerView.q qVar, RecyclerView.iz.nr nrVar, RecyclerView.iz.nr nrVar2) {
        int i;
        int i2;
        return (nrVar == null || ((i = nrVar.u) == (i2 = nrVar2.u) && nrVar.nr == nrVar2.nr)) ? nr(qVar) : u(qVar, i, nrVar.nr, i2, nrVar2.nr);
    }

    public abstract boolean u(RecyclerView.q qVar);

    public abstract boolean u(RecyclerView.q qVar, int i, int i2, int i3, int i4);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public boolean u(RecyclerView.q qVar, RecyclerView.iz.nr nrVar, RecyclerView.iz.nr nrVar2) {
        int i = nrVar.u;
        int i2 = nrVar.nr;
        View view = qVar.u;
        int left = nrVar2 == null ? view.getLeft() : nrVar2.u;
        int top = nrVar2 == null ? view.getTop() : nrVar2.nr;
        if (qVar.o() || (i == left && i2 == top)) {
            return u(qVar);
        }
        view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
        return u(qVar, i, i2, left, top);
    }

    public abstract boolean u(RecyclerView.q qVar, RecyclerView.q qVar2, int i, int i2, int i3, int i4);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public boolean x(RecyclerView.q qVar) {
        return !this.n || qVar.s();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.iz
    public boolean u(RecyclerView.q qVar, RecyclerView.q qVar2, RecyclerView.iz.nr nrVar, RecyclerView.iz.nr nrVar2) {
        int i;
        int i2;
        int i3 = nrVar.u;
        int i4 = nrVar.nr;
        if (qVar2.N_()) {
            int i5 = nrVar.u;
            i2 = nrVar.nr;
            i = i5;
        } else {
            i = nrVar2.u;
            i2 = nrVar2.nr;
        }
        return u(qVar, qVar2, i3, i4, i, i2);
    }

    public final void u(RecyclerView.q qVar, boolean z) {
        iz(qVar);
    }
}
