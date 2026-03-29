package com.bytedance.adsdk.ugeno.fx.nr;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class fx {
    private Context b;
    private my fx;
    private final int iz;
    private float nr;
    private boolean pn;
    private float u;

    public fx(Context context, my myVar) {
        this.b = context;
        this.fx = myVar;
        this.iz = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public boolean u(sx sxVar, com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = motionEvent.getX();
            this.nr = motionEvent.getY();
        } else if (action != 1) {
            if (action == 2) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (Math.abs(x - this.u) >= this.iz || Math.abs(y - this.nr) >= this.iz) {
                    this.pn = true;
                }
            } else if (action == 3) {
                this.pn = false;
            }
        } else {
            if (this.pn) {
                this.pn = false;
                return false;
            }
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (Math.abs(x2 - this.u) >= this.iz || Math.abs(y2 - this.nr) >= this.iz) {
                this.pn = false;
            } else if (sxVar != null) {
                sxVar.u(this.fx, fxVar, fxVar);
                return true;
            }
        }
        return true;
    }
}
