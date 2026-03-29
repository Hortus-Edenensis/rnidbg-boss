package com.bytedance.sdk.openadsdk.core.u;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.my.fx.nr.k;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a extends com.bytedance.sdk.openadsdk.bq.u.nr.u.x implements nr {
    private long u;

    public a(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.u = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
    public void nr() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.nr();
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.a.3
                @Override // java.lang.Runnable
                public void run() {
                    a.super.nr();
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
    public void u(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(i, str);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.super.u(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
    public void nr(final k kVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.nr(kVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.a.4
                @Override // java.lang.Runnable
                public void run() {
                    a.super.nr(kVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.x
    public void u(final k kVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(kVar);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.a.2
                @Override // java.lang.Runnable
                public void run() {
                    a.super.u(kVar);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.nr
    public long u() {
        return this.u;
    }
}
