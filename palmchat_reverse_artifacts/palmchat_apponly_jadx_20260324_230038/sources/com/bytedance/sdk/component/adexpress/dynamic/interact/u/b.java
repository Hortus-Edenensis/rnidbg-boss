package com.bytedance.sdk.component.adexpress.dynamic.interact.u;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.sdk.component.adexpress.dynamic.interact.n f5091a;
    private float b;
    private float fx;
    private float iz;
    private int jk;
    private boolean n;
    private float nr;
    private boolean pn = true;
    private boolean t;
    private float u;
    private float x;

    public b(com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar, int i, boolean z) {
        this.f5091a = nVar;
        this.jk = i;
        this.t = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar2;
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar3;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = motionEvent.getX();
            this.nr = motionEvent.getY();
            this.iz = motionEvent.getY();
            this.pn = true;
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.x = y;
                if (Math.abs(y - this.iz) > 10.0f) {
                    this.n = true;
                }
                this.b = motionEvent.getX();
                this.fx = motionEvent.getY();
                if (Math.abs(this.b - this.u) > 8.0f || Math.abs(this.fx - this.nr) > 8.0f) {
                    this.pn = false;
                }
            }
        } else {
            if (!this.n && !this.pn) {
                return false;
            }
            if (this.t || (nVar3 = this.f5091a) == null) {
                int iNr = com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), Math.abs(this.x - this.iz));
                if (this.x - this.iz < 0.0f && iNr > this.jk && (nVar2 = this.f5091a) != null) {
                    nVar2.u();
                } else if (this.pn && (nVar = this.f5091a) != null) {
                    nVar.u();
                }
            } else {
                nVar3.u();
            }
        }
        return true;
    }
}
