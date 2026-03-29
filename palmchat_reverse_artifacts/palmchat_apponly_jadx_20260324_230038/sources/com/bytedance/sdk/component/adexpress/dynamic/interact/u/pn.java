package com.bytedance.sdk.component.adexpress.dynamic.interact.u;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn implements View.OnTouchListener {
    private com.bytedance.sdk.component.adexpress.dynamic.interact.n b;
    private boolean fx;
    private float nr;
    private int pn;
    private float u;

    public pn(com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar, int i) {
        this.b = nVar;
        this.pn = i;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float y = motionEvent.getY();
                this.nr = y;
                if (Math.abs(y - this.u) > 10.0f) {
                    this.fx = true;
                }
            }
        } else {
            if (!this.fx) {
                return false;
            }
            int iNr = com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), Math.abs(this.nr - this.u));
            if (this.nr - this.u < 0.0f && iNr > this.pn && (nVar = this.b) != null) {
                nVar.u();
                this.u = 0.0f;
                this.nr = 0.0f;
                this.fx = false;
            }
        }
        return true;
    }
}
