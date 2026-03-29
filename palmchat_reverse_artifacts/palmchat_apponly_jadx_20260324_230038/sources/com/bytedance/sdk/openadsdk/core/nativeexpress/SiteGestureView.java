package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.kj.eh;
import com.bytedance.sdk.openadsdk.core.kj.q;
import com.bytedance.sdk.openadsdk.core.y.y;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class SiteGestureView extends View {
    private float b;
    private float fx;
    private float iz;
    private eh nr;
    private float pn;
    private dw u;
    private long x;

    public SiteGestureView(Context context, eh ehVar, dw dwVar) {
        super(context);
        this.nr = ehVar;
        this.u = dwVar;
        setTag(2097610717, "click");
    }

    private void nr(int i, MotionEvent motionEvent) {
        int[] iArrU = y.u(this);
        com.bytedance.sdk.openadsdk.core.kj.q qVarU = new q.u().u("express_gesture_view").b(this.pn).fx(this.iz).nr(motionEvent.getRawX()).u(motionEvent.getRawY()).nr(this.x).fx(getWidth()).b(getHeight()).u(iArrU == null ? 0 : iArrU[0]).nr(iArrU != null ? iArrU[1] : 0).u(true).u(System.currentTimeMillis()).u();
        this.nr.u(i);
        this.u.u(this, 1, qVarU, this.nr);
    }

    private boolean u(int i, MotionEvent motionEvent) {
        if (this.nr.u() == 1 && this.u.u()) {
            this.u.u(motionEvent);
            return false;
        }
        nr(i, motionEvent);
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.fx = y.b(getContext(), motionEvent.getX());
            this.b = y.b(getContext(), motionEvent.getY());
            this.pn = motionEvent.getRawX();
            this.iz = motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            this.u.u(motionEvent);
            if (this.nr.nr() == -1 || !this.u.fx()) {
                return false;
            }
        } else if (action == 1) {
            this.u.nr();
            float fB = y.b(getContext(), motionEvent.getX());
            float fB2 = y.b(getContext(), motionEvent.getY());
            if (this.nr.fx() == 0.0d) {
                nr(-1, motionEvent);
                return true;
            }
            float f = fB - this.fx;
            float f2 = fB2 - this.b;
            float fAbs = Math.abs(f);
            float fAbs2 = Math.abs(f2);
            if (fAbs <= 3.0f && fAbs2 <= 3.0f) {
                this.u.u(motionEvent);
                return true;
            }
            double dFx = this.nr.fx();
            int iB = this.nr.b();
            if (fAbs > fAbs2) {
                if (fAbs > dFx) {
                    long j = iB;
                    if (com.bytedance.sdk.openadsdk.core.c.nr.u(j, 2L) && f < 0.0f) {
                        return u(2, motionEvent);
                    }
                    if (com.bytedance.sdk.openadsdk.core.c.nr.u(j, 4L) && f > 0.0f) {
                        return u(4, motionEvent);
                    }
                }
            } else if (fAbs2 > dFx) {
                long j2 = iB;
                if (com.bytedance.sdk.openadsdk.core.c.nr.u(j2, 8L) && f2 < 0.0f) {
                    return u(8, motionEvent);
                }
                if (com.bytedance.sdk.openadsdk.core.c.nr.u(j2, 16L) && f2 > 0.0f) {
                    return u(16, motionEvent);
                }
            }
            return false;
        }
        return true;
    }
}
