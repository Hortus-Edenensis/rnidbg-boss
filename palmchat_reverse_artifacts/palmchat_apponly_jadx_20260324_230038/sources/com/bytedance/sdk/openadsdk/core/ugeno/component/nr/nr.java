package com.bytedance.sdk.openadsdk.core.ugeno.component.nr;

import android.graphics.Rect;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class nr extends RecyclerView.s {
    private int fx;
    private u nr;
    private boolean u = false;

    public nr(u uVar) {
        this.nr = uVar;
    }

    public abstract void nr(RecyclerView recyclerView, int i);

    public abstract void u();

    public abstract void u(int i, int i2);

    public abstract void u(int i, View view);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.s
    public void u(RecyclerView recyclerView, int i) {
        super.u(recyclerView, i);
        com.bytedance.sdk.component.widget.recycler.pn pnVar = (com.bytedance.sdk.component.widget.recycler.pn) recyclerView.getLayoutManager();
        if (i == 0) {
            int iT = pnVar.t();
            if (!u(pnVar.nr(iT), 50)) {
                iT--;
            }
            int iMax = Math.max(0, Math.max(iT, this.fx));
            for (int iMin = Math.min(this.fx, iT); iMin <= iMax; iMin++) {
                u(iMin, pnVar.nr(iMin));
            }
            this.fx = iT;
            int iH = pnVar.h();
            this.nr.u(recyclerView);
            if ((iT == iH - 1 && this.u) || iH == 1) {
                u();
            }
        }
        nr(recyclerView, i);
    }

    private int u(View view) {
        Rect rect = new Rect();
        if (!view.getLocalVisibleRect(rect) || view.getMeasuredHeight() <= 0) {
            return -1;
        }
        return (rect.height() * 100) / view.getMeasuredHeight();
    }

    private boolean u(View view, int i) {
        return view != null && view.getLocalVisibleRect(new Rect()) && view.getVisibility() == 0 && u(view) >= i;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.s
    public void u(RecyclerView recyclerView, int i, int i2) {
        super.u(recyclerView, i, i2);
        if (i2 == 0) {
            com.bytedance.sdk.component.widget.recycler.pn pnVar = (com.bytedance.sdk.component.widget.recycler.pn) recyclerView.getLayoutManager();
            this.fx = pnVar.jk();
            int iT = pnVar.t();
            if (!u(pnVar.nr(iT), 50)) {
                iT--;
            }
            int iMax = Math.max(0, Math.max(iT, this.fx));
            for (int i3 = this.fx; i3 <= iMax; i3++) {
                u(i3, pnVar.nr(i3));
            }
        }
        this.u = i2 > 0;
        this.nr.u();
        u(i, i2);
    }
}
