package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.widget.recycler.RecyclerView;
import com.bytedance.sdk.component.widget.recycler.a;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.sdk.component.widget.recycler.pn {
    private final a bg;
    private int bq;
    private boolean c;
    private int dw;
    private final RecyclerView.t kj;
    private int q;
    private u qq;
    public boolean sx;

    /* JADX INFO: compiled from: SearchBox */
    public interface u {
        void u();

        void u(boolean z, int i);

        void u(boolean z, int i, boolean z2);
    }

    public fx(Context context, int i, boolean z) {
        super(context, i, z);
        this.c = false;
        this.sx = true;
        this.kj = new RecyclerView.t() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.fx.1
            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
            public void nr(View view) {
                if (fx.this.qq != null) {
                    fx.this.qq.u(fx.this.bq >= 0, fx.this.b(view));
                }
            }

            @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.t
            public void u(View view) {
                if (fx.this.qq == null || fx.this.bg() != 1) {
                    return;
                }
                fx.this.qq.u();
            }
        };
        this.bg = new a();
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void fx(RecyclerView recyclerView) {
        super.fx(recyclerView);
        this.bg.u(recyclerView);
        recyclerView.u(this.kj);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void t(int i) {
        boolean z;
        u uVar;
        this.dw = i;
        if (i == 0) {
            View viewU = this.bg.u(this);
            if (viewU != null) {
                int iB = b(viewU);
                z = this.q == iB;
                this.q = iB;
            } else {
                z = true;
            }
            if (this.c) {
                this.c = false;
                if (!z && (uVar = this.qq) != null) {
                    boolean z2 = this.bq >= 0;
                    int i2 = this.q;
                    uVar.u(z2, i2, i2 == h() - 1);
                }
            }
        }
        if (i == 2) {
            this.c = true;
        }
    }

    public void nr(boolean z) {
        this.sx = z;
    }

    @Override // com.bytedance.sdk.component.widget.recycler.pn, com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public void u(RecyclerView recyclerView, RecyclerView.my myVar) {
        super.u(recyclerView, myVar);
        try {
            pn pnVar = (pn) recyclerView.fx(this.q);
            if (pnVar != null) {
                pnVar.h();
            }
        } catch (Exception e) {
            k.u("cubic detached exception:" + e.getMessage());
        }
    }

    @Override // com.bytedance.sdk.component.widget.recycler.pn, com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int nr(int i, RecyclerView.my myVar, RecyclerView.bq bqVar) {
        this.bq = i;
        return super.nr(i, myVar, bqVar);
    }

    @Override // com.bytedance.sdk.component.widget.recycler.pn, com.bytedance.sdk.component.widget.recycler.RecyclerView.a
    public int u(int i, RecyclerView.my myVar, RecyclerView.bq bqVar) {
        this.bq = i;
        return super.u(i, myVar, bqVar);
    }

    public void u(u uVar) {
        this.qq = uVar;
    }
}
