package com.bytedance.sdk.component.adexpress.dynamic.interact.u;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz implements View.OnTouchListener {
    private static int fx = 10;
    private boolean b;
    private float nr;
    private com.bytedance.sdk.component.adexpress.dynamic.interact.n pn;
    private float u;

    public iz(com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar) {
        this.pn = nVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = motionEvent.getX();
            this.nr = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.u) >= fx || Math.abs(y - this.nr) >= fx) {
                    this.b = true;
                }
            } else if (action == 3) {
                this.b = false;
            }
        } else {
            if (this.b) {
                this.b = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.u) >= fx || Math.abs(y2 - this.nr) >= fx) {
                this.b = false;
            } else {
                com.bytedance.sdk.component.adexpress.dynamic.interact.n nVar = this.pn;
                if (nVar != null) {
                    nVar.u();
                }
            }
        }
        return true;
    }
}
