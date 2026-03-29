package com.bytedance.adsdk.ugeno.fx.nr;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.beizi.fusion.widget.ScrollClickView;
import com.bytedance.adsdk.ugeno.fx.my;
import com.bytedance.adsdk.ugeno.fx.sx;
import com.bytedance.adsdk.ugeno.iz.n;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class pn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5030a;
    private Context jk;
    private boolean l;
    private u mv;
    private my n;
    private boolean t;
    private my x;
    private float u = Float.MIN_VALUE;
    private float nr = Float.MIN_VALUE;
    private int fx = 0;
    private int b = Integer.MAX_VALUE;
    private int pn = Integer.MAX_VALUE;
    private AtomicBoolean iz = new AtomicBoolean(true);

    public pn(Context context, my myVar, boolean z, boolean z2) {
        this.jk = context;
        this.x = myVar;
        this.t = z;
        this.l = z2;
        fx();
    }

    private void fx() {
        if (this.l) {
            this.mv = new u();
        }
        my myVar = this.x;
        if (myVar == null) {
            return;
        }
        this.fx = myVar.fx().optInt("slideThreshold");
        this.f5030a = this.x.fx().optString("slideDirection");
        this.b = this.x.fx().optInt("frequency", Integer.MAX_VALUE);
        this.pn = this.x.fx().optInt("effectiveDuration", Integer.MAX_VALUE);
        this.iz.get();
    }

    public void nr() {
        this.u = Float.MIN_VALUE;
        this.nr = Float.MIN_VALUE;
    }

    public void u() {
        if (this.pn == Integer.MAX_VALUE) {
            return;
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.adsdk.ugeno.fx.nr.pn.1
            @Override // java.lang.Runnable
            public void run() {
                pn.this.iz.set(false);
            }
        }, this.pn);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean u(sx sxVar, com.bytedance.adsdk.ugeno.nr.fx fxVar, MotionEvent motionEvent, boolean z) {
        float x;
        float y;
        int iNr;
        u uVar = this.mv;
        if (uVar != null) {
            if (uVar.u(motionEvent)) {
                return false;
            }
            this.mv.u(fxVar, motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.u = motionEvent.getX();
            this.nr = motionEvent.getY();
        } else if (action == 1) {
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (!this.t && Math.abs(x - this.u) <= 10.0f && Math.abs(y - this.nr) <= 10.0f && sxVar != null) {
                nr();
                sxVar.u(this.n, fxVar, fxVar);
                return true;
            }
            if (this.fx != 0 && sxVar != null) {
                nr();
                u(sxVar, this.x, fxVar);
                return true;
            }
            iNr = n.nr(this.jk, x - this.u);
            int iNr2 = n.nr(this.jk, y - this.nr);
            if (!TextUtils.equals(this.f5030a, "up")) {
                iNr = -iNr2;
            } else if (TextUtils.equals(this.f5030a, ScrollClickView.DIR_DOWN)) {
                iNr = iNr2;
            } else if (TextUtils.equals(this.f5030a, "left")) {
                iNr = -iNr;
            } else if (!TextUtils.equals(this.f5030a, "right")) {
                iNr = (int) Math.abs(Math.sqrt(Math.pow(iNr, 2.0d) + Math.pow(iNr2, 2.0d)));
            }
            if (iNr >= this.fx) {
                nr();
                u(fxVar);
                return false;
            }
            if (sxVar != null) {
                nr();
                u(sxVar, this.x, fxVar);
                return true;
            }
            nr();
        } else if (action == 3) {
            if (this.u == Float.MIN_VALUE || this.nr == Float.MIN_VALUE) {
                return false;
            }
            x = motionEvent.getX();
            y = motionEvent.getY();
            if (!this.t) {
            }
            if (this.fx != 0) {
            }
            iNr = n.nr(this.jk, x - this.u);
            int iNr22 = n.nr(this.jk, y - this.nr);
            if (!TextUtils.equals(this.f5030a, "up")) {
            }
            if (iNr >= this.fx) {
            }
        }
        return true;
    }

    public pn(Context context, my myVar, my myVar2, boolean z, boolean z2) {
        this.jk = context;
        this.x = myVar;
        this.n = myVar2;
        this.t = z;
        this.l = z2;
        fx();
    }

    private void u(com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        u uVar = this.mv;
        if (uVar != null) {
            uVar.u(fxVar);
        }
    }

    private void u(sx sxVar, my myVar, com.bytedance.adsdk.ugeno.nr.fx fxVar) {
        if (this.b <= 0) {
            u(fxVar);
            return;
        }
        if (!this.iz.get()) {
            u(fxVar);
            return;
        }
        sxVar.u(myVar, fxVar, fxVar);
        int i = this.b;
        if (i != Integer.MAX_VALUE) {
            this.b = i - 1;
        }
    }
}
