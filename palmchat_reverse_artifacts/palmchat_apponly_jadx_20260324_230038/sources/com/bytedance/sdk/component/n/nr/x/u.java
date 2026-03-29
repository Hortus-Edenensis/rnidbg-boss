package com.bytedance.sdk.component.n.nr.x;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.bytedance.sdk.component.n.u.pn;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static volatile u b = null;
    private static int fx = 3000;
    private volatile Handler nr = null;
    private Looper pn;
    private volatile HandlerThread u;

    private u(pn pnVar) {
        this.u = null;
        this.pn = null;
        if (pnVar != null && pnVar.b() != null && pnVar.b().nr() != null) {
            this.pn = pnVar.b().nr();
        } else {
            this.u = new HandlerThread("csj_ad_log", 10);
            this.u.start();
        }
    }

    public static u u(pn pnVar) {
        if (b == null) {
            synchronized (u.class) {
                if (b == null) {
                    b = new u(pnVar);
                }
            }
        }
        return b;
    }

    public int nr() {
        if (fx <= 0) {
            fx = 3000;
        }
        return fx;
    }

    public Handler u() {
        if (this.pn != null) {
            if (this.nr == null) {
                synchronized (u.class) {
                    if (this.nr == null) {
                        this.nr = new Handler(this.pn);
                    }
                }
            }
        } else if (this.u != null && this.u.isAlive()) {
            if (this.nr == null) {
                synchronized (u.class) {
                    if (this.nr == null) {
                        this.nr = new Handler(this.u.getLooper());
                    }
                }
            }
        } else {
            synchronized (u.class) {
                if (this.u == null || !this.u.isAlive()) {
                    this.u = new HandlerThread("csj_init_handle", -1);
                    this.u.start();
                    this.nr = new Handler(this.u.getLooper());
                }
            }
        }
        return this.nr;
    }
}
