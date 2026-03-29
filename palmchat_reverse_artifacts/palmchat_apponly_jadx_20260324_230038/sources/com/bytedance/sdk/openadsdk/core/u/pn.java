package com.bytedance.sdk.openadsdk.core.u;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.my.fx.nr.jk;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class pn extends com.bytedance.sdk.openadsdk.bq.u.nr.u.fx implements nr {
    private long u;

    public pn(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.u = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.fx
    public void u(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(i, str);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.pn.1
                @Override // java.lang.Runnable
                public void run() {
                    pn.super.u(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.fx
    public void u(final List<jk> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(list);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.pn.2
                @Override // java.lang.Runnable
                public void run() {
                    pn.super.u(list);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.nr
    public long u() {
        return this.u;
    }
}
