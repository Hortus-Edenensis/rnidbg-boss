package com.bytedance.sdk.component.adexpress.dynamic.interact.u;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.component.adexpress.dynamic.interact.InteractViewContainer;
import com.igexin.push.config.c;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr implements View.OnTouchListener {
    private boolean b;
    private long fx;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.n iz;
    private float nr;
    private InteractViewContainer pn;
    private float u;

    public nr(InteractViewContainer interactViewContainer, com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar) {
        this.pn = interactViewContainer;
        this.iz = nVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.fx = System.currentTimeMillis();
            this.u = motionEvent.getX();
            this.nr = motionEvent.getY();
            this.pn.pn();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.u) >= com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), 10.0f) || Math.abs(y - this.nr) >= com.bytedance.sdk.component.adexpress.b.n.u(com.bytedance.sdk.component.adexpress.b.getContext(), 10.0f)) {
                    this.b = true;
                    this.pn.iz();
                }
            }
        } else {
            if (this.b) {
                return false;
            }
            if (System.currentTimeMillis() - this.fx >= c.j) {
                com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar = this.iz;
                if (nVar != null) {
                    nVar.u();
                }
            } else {
                this.pn.iz();
            }
        }
        return true;
    }
}
