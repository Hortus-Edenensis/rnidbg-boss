package com.bytedance.sdk.component.adexpress.dynamic.interact.u;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n implements View.OnTouchListener {
    private float b;
    private final int fx = 10;
    private float iz;
    private final boolean nr;
    private float pn;
    private final com.bytedance.sdk.component.adexpress.dynamic.interact.n u;
    private float x;

    public n(com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar, boolean z) {
        this.u = nVar;
        this.nr = z;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar;
        com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar2;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = motionEvent.getX();
            this.pn = motionEvent.getY();
            new StringBuilder(", mStartY: ").append(this.pn);
        } else if (action == 1) {
            this.iz = motionEvent.getX();
            this.x = motionEvent.getY();
            new StringBuilder(", mEndY: ").append(this.x);
            if (this.nr || (nVar2 = this.u) == null) {
                float f = this.iz - this.b;
                float f2 = this.x - this.pn;
                if (com.bytedance.sdk.component.adexpress.b.n.nr(com.bytedance.sdk.component.adexpress.b.getContext(), Math.abs((float) Math.sqrt((f * f) + (f2 * f2)))) > 10.0f && (nVar = this.u) != null) {
                    nVar.u();
                }
            } else {
                nVar2.u();
            }
        }
        return true;
    }
}
