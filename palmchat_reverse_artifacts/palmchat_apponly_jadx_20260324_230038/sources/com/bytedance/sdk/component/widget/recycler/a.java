package com.bytedance.sdk.component.widget.recycler;

import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends l {
    private n fx;
    private n nr;

    private n b(RecyclerView.a aVar) {
        n nVar = this.nr;
        if (nVar == null || nVar.u != aVar) {
            this.nr = n.nr(aVar);
        }
        return this.nr;
    }

    private n pn(RecyclerView.a aVar) {
        n nVar = this.fx;
        if (nVar == null || nVar.u != aVar) {
            this.fx = n.u(aVar);
        }
        return this.fx;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.l
    public iz nr(RecyclerView.a aVar) {
        if (aVar instanceof RecyclerView.bg.nr) {
            return new iz(this.u.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.a.1
                @Override // com.bytedance.sdk.component.widget.recycler.iz
                public int nr(int i) {
                    return Math.min(100, super.nr(i));
                }

                @Override // com.bytedance.sdk.component.widget.recycler.iz, com.bytedance.sdk.component.widget.recycler.RecyclerView.bg
                public void u(View view, RecyclerView.bq bqVar, RecyclerView.bg.u uVar) {
                    a aVar2 = a.this;
                    int[] iArrU = aVar2.u(aVar2.u.getLayoutManager(), view);
                    int i = iArrU[0];
                    int i2 = iArrU[1];
                    int iU = u(Math.max(Math.abs(i), Math.abs(i2)));
                    if (iU > 0) {
                        uVar.update(i, i2, iU, ((iz) this).nr);
                    }
                }

                @Override // com.bytedance.sdk.component.widget.recycler.iz
                public float u(DisplayMetrics displayMetrics) {
                    return 100.0f / displayMetrics.densityDpi;
                }
            };
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.l
    public int[] u(RecyclerView.a aVar, View view) {
        int[] iArr = new int[2];
        if (aVar.fx()) {
            iArr[0] = u(aVar, view, pn(aVar));
        } else {
            iArr[0] = 0;
        }
        if (aVar.b()) {
            iArr[1] = u(aVar, view, b(aVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    private View nr(RecyclerView.a aVar, n nVar) {
        int iBg = aVar.bg();
        View view = null;
        if (iBg == 0) {
            return null;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iBg; i2++) {
            View viewN = aVar.n(i2);
            int iU = nVar.u(viewN);
            if (iU < i) {
                view = viewN;
                i = iU;
            }
        }
        return view;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.l
    public View u(RecyclerView.a aVar) {
        if (aVar.b()) {
            return u(aVar, b(aVar));
        }
        if (aVar.fx()) {
            return u(aVar, pn(aVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.widget.recycler.l
    public int u(RecyclerView.a aVar, int i, int i2) {
        View viewNr;
        int iB;
        PointF pointFFx;
        int iH = aVar.h();
        if (iH == 0) {
            return -1;
        }
        if (aVar.b()) {
            viewNr = nr(aVar, b(aVar));
        } else {
            viewNr = aVar.fx() ? nr(aVar, pn(aVar)) : null;
        }
        if (viewNr == null || (iB = aVar.b(viewNr)) == -1) {
            return -1;
        }
        boolean z = false;
        boolean z2 = !aVar.fx() ? i2 <= 0 : i <= 0;
        if ((aVar instanceof RecyclerView.bg.nr) && (pointFFx = ((RecyclerView.bg.nr) aVar).fx(iH - 1)) != null && (pointFFx.x < 0.0f || pointFFx.y < 0.0f)) {
            z = true;
        }
        return z ? z2 ? iB - 1 : iB : z2 ? iB + 1 : iB;
    }

    private int u(RecyclerView.a aVar, View view, n nVar) {
        int iPn;
        int iU = nVar.u(view) + (nVar.pn(view) / 2);
        if (aVar.k()) {
            iPn = nVar.fx() + (nVar.iz() / 2);
        } else {
            iPn = nVar.pn() / 2;
        }
        return iU - iPn;
    }

    private View u(RecyclerView.a aVar, n nVar) {
        int iPn;
        int iBg = aVar.bg();
        View view = null;
        if (iBg == 0) {
            return null;
        }
        if (aVar.k()) {
            iPn = nVar.fx() + (nVar.iz() / 2);
        } else {
            iPn = nVar.pn() / 2;
        }
        int i = Integer.MAX_VALUE;
        for (int i2 = 0; i2 < iBg; i2++) {
            View viewN = aVar.n(i2);
            int iAbs = Math.abs((nVar.u(viewN) + (nVar.pn(viewN) / 2)) - iPn);
            if (iAbs < i) {
                view = viewN;
                i = iAbs;
            }
        }
        return view;
    }
}
