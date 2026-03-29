package com.bytedance.adsdk.ugeno.pn.fx;

import android.content.Context;
import android.view.MotionEvent;
import com.bytedance.adsdk.ugeno.pn.mv;
import com.bytedance.adsdk.ugeno.pn.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn extends nr {
    private float l;
    private boolean mv;
    private mv s;
    private float t;

    public pn(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.pn.fx.nr
    public boolean u(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return false;
        }
        MotionEvent motionEvent = (MotionEvent) objArr[0];
        mv mvVar = this.s;
        return mvVar != null ? mvVar.u(this.nr, motionEvent, this.u, this) : u(this.nr, motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean u(com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.t = motionEvent.getRawX();
            this.l = motionEvent.getRawY();
        } else if (action == 1) {
            if (!this.mv) {
                this.mv = false;
                this.t = 0.0f;
                this.l = 0.0f;
                return false;
            }
            float rawX = motionEvent.getRawX();
            float rawY = motionEvent.getRawY();
            if (Math.abs(rawX - this.t) < 15.0f && Math.abs(rawY - this.l) < 15.0f) {
                t tVar = this.u;
                if (tVar != null) {
                    tVar.u(fxVar, this.iz, this.fx.nr());
                    this.t = 0.0f;
                    this.l = 0.0f;
                    return true;
                }
            } else {
                this.mv = false;
                return false;
            }
        } else if (action == 2) {
            float rawX2 = motionEvent.getRawX();
            float rawY2 = motionEvent.getRawY();
            if (Math.abs(rawX2 - this.t) >= 15.0f || Math.abs(rawY2 - this.l) >= 15.0f) {
                this.mv = true;
            }
        } else if (action == 3) {
            this.mv = false;
            if (!this.mv) {
            }
        }
        return true;
    }

    public void u(mv mvVar) {
        this.s = mvVar;
    }
}
