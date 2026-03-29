package com.bytedance.embedapplog;

import android.content.Context;
import android.os.Build;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
final class j {
    public static ky u(Context context) {
        if (a.bg()) {
            return new qb(new t());
        }
        if (a.bq() && t.u()) {
            return new t();
        }
        if (jf.u()) {
            return new jf(context);
        }
        if (a.mv() && a.s()) {
            return new hm();
        }
        if (a.mv() && !a.s()) {
            return new zn();
        }
        if (a.u(context) || a.mv()) {
            return new hm();
        }
        if (a.q()) {
            return new qb();
        }
        if (a.c()) {
            return new uk();
        }
        if (Build.VERSION.SDK_INT <= 28) {
            if (a.k() || !hm.fx(context)) {
                return null;
            }
            return new hm();
        }
        if (a.qq()) {
            return new bl();
        }
        if (a.z()) {
            return new jn();
        }
        if (a.kj()) {
            return new r();
        }
        if (a.gi()) {
            return new m();
        }
        wj wjVar = new wj(context);
        return wjVar.u(context) ? wjVar : new iq();
    }
}
