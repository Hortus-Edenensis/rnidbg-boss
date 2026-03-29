package com.bytedance.sdk.component.adexpress.dynamic.interact.u;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f5092a;
    private float b;
    private float fx;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.n iz;
    private boolean n;
    private float nr;
    private boolean pn;
    private float u;
    private int x;

    public fx(com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar) {
        this(nVar, 5);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar3;
        if (this.f5092a) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = motionEvent.getX();
            this.nr = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                this.b = motionEvent.getX();
                this.fx = motionEvent.getY();
                if (Math.abs(this.b - this.u) > 10.0f) {
                    this.pn = true;
                }
                if (Math.abs(this.b - this.u) > 8.0f || Math.abs(this.fx - this.nr) > 8.0f) {
                    this.n = false;
                }
                int iNr = com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), Math.abs(this.b - this.u));
                if (this.b > this.u && iNr > this.x && (nVar3 = this.iz) != null) {
                    nVar3.u();
                    this.f5092a = true;
                }
            }
        } else {
            if (!this.pn && !this.n) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int iNr2 = com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), Math.abs(this.b - this.u));
            if (this.b > this.u && iNr2 > this.x && (nVar2 = this.iz) != null) {
                nVar2.u();
                this.f5092a = true;
            }
            float fAbs = Math.abs(x - this.u);
            float fAbs2 = Math.abs(y - this.nr);
            if ((fAbs < 8.0f || fAbs2 < 8.0f) && (nVar = this.iz) != null) {
                nVar.nr();
                this.f5092a = true;
            }
        }
        return true;
    }

    public fx(com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar, int i) {
        this.x = 5;
        this.n = true;
        this.iz = nVar;
        if (i > 0) {
            this.x = i;
        }
    }
}
