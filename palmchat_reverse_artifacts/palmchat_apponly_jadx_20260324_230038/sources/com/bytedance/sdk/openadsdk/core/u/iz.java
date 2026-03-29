package com.bytedance.sdk.openadsdk.core.u;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.my.fx.nr.t;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class iz extends com.bytedance.sdk.openadsdk.bq.u.nr.u.b implements nr {
    private long u;

    public iz(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.u = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.b
    public void nr() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.nr();
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.iz.3
                @Override // java.lang.Runnable
                public void run() {
                    iz.super.nr();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.b
    public void u(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(i, str);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.iz.1
                @Override // java.lang.Runnable
                public void run() {
                    iz.super.u(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.b
    public void nr(final t tVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.nr(tVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.iz.4
                @Override // java.lang.Runnable
                public void run() {
                    iz.super.nr(tVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.b
    public void u(final t tVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(tVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.iz.2
                @Override // java.lang.Runnable
                public void run() {
                    iz.super.u(tVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.nr
    public long u() {
        return this.u;
    }
}
