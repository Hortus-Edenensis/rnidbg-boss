package com.bytedance.sdk.component.widget.recycler;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public abstract class l extends RecyclerView.l {
    private final RecyclerView.s fx = new RecyclerView.s() { // from class: com.bytedance.sdk.component.widget.recycler.l.1
        boolean u = false;

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.s
        public void u(RecyclerView recyclerView, int i) {
            super.u(recyclerView, i);
            if (i == 0 && this.u) {
                this.u = false;
                l.this.u();
            }
        }

        @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.s
        public void u(RecyclerView recyclerView, int i, int i2) {
            if (i == 0 && i2 == 0) {
                return;
            }
            this.u = true;
        }
    };
    private Scroller nr;
    RecyclerView u;

    private void fx() {
        this.u.nr(this.fx);
        this.u.setOnFlingListener(null);
    }

    private void nr() throws IllegalStateException {
        if (this.u.getOnFlingListener() != null) {
            throw new IllegalStateException("An instance of OnFlingListener already set.");
        }
        this.u.u(this.fx);
        this.u.setOnFlingListener(this);
    }

    public abstract int u(RecyclerView.a aVar, int i, int i2);

    public abstract View u(RecyclerView.a aVar);

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.l
    public boolean u(int i, int i2) {
        RecyclerView.a layoutManager = this.u.getLayoutManager();
        if (layoutManager == null || this.u.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.u.getMinFlingVelocity();
        return (Math.abs(i2) > minFlingVelocity || Math.abs(i) > minFlingVelocity) && nr(layoutManager, i, i2);
    }

    public abstract int[] u(RecyclerView.a aVar, View view);

    public RecyclerView.bg fx(RecyclerView.a aVar) {
        return nr(aVar);
    }

    private boolean nr(RecyclerView.a aVar, int i, int i2) {
        RecyclerView.bg bgVarFx;
        int iU;
        if (!(aVar instanceof RecyclerView.bg.nr) || (bgVarFx = fx(aVar)) == null || (iU = u(aVar, i, i2)) == -1) {
            return false;
        }
        bgVarFx.fx(iU);
        aVar.u(bgVarFx);
        return true;
    }

    public void u(RecyclerView recyclerView) throws IllegalStateException {
        RecyclerView recyclerView2 = this.u;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                fx();
            }
            this.u = recyclerView;
            if (recyclerView != null) {
                nr();
                this.nr = new Scroller(this.u.getContext(), new DecelerateInterpolator());
                u();
            }
        }
    }

    @Deprecated
    public iz nr(RecyclerView.a aVar) {
        if (aVar instanceof RecyclerView.bg.nr) {
            return new iz(this.u.getContext()) { // from class: com.bytedance.sdk.component.widget.recycler.l.2
                @Override // com.bytedance.sdk.component.widget.recycler.iz, com.bytedance.sdk.component.widget.recycler.RecyclerView.bg
                public void u(View view, RecyclerView.bq bqVar, RecyclerView.bg.u uVar) {
                    l lVar = l.this;
                    RecyclerView recyclerView = lVar.u;
                    if (recyclerView != null) {
                        int[] iArrU = lVar.u(recyclerView.getLayoutManager(), view);
                        int i = iArrU[0];
                        int i2 = iArrU[1];
                        int iU = u(Math.max(Math.abs(i), Math.abs(i2)));
                        if (iU > 0) {
                            uVar.update(i, i2, iU, ((iz) this).nr);
                        }
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

    public void u() {
        RecyclerView.a layoutManager;
        View viewU;
        RecyclerView recyclerView = this.u;
        if (recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null || (viewU = u(layoutManager)) == null) {
            return;
        }
        int[] iArrU = u(layoutManager, viewU);
        int i = iArrU[0];
        if (i == 0 && iArrU[1] == 0) {
            return;
        }
        this.u.u(i, iArrU[1]);
    }
}
