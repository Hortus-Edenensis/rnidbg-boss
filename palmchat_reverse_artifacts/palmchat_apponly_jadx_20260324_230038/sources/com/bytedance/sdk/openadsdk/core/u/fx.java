package com.bytedance.sdk.openadsdk.core.u;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.bg;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx extends com.bytedance.sdk.openadsdk.bq.u.nr.u.u implements nr {
    private long u;

    public fx(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.u = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.u
    public void nr(final com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.nr(nrVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.fx.3
                @Override // java.lang.Runnable
                public void run() {
                    fx.super.nr(nrVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.u
    public void u(final com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar) {
        if (com.bytedance.sdk.openadsdk.core.component.splash.pn.b()) {
            super.u(nrVar);
        } else {
            com.bytedance.sdk.openadsdk.gi.x.u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.fx.1
                @Override // java.lang.Runnable
                public void run() {
                    fx.super.u(nrVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.u
    public void u(final com.bytedance.sdk.openadsdk.my.fx.nr.u uVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(uVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.fx.2
                @Override // java.lang.Runnable
                public void run() {
                    fx.super.u(uVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.u
    public void u(final com.bytedance.sdk.openadsdk.my.fx.nr.nr nrVar, final com.bytedance.sdk.openadsdk.my.fx.nr.u uVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(nrVar, uVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.fx.4
                @Override // java.lang.Runnable
                public void run() {
                    fx.super.u(nrVar, uVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.nr
    public long u() {
        return this.u;
    }
}
