package com.bytedance.sdk.openadsdk.core.u;

import android.os.Looper;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.bg;
import com.bytedance.sdk.openadsdk.my.fx.nr.mv;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class x extends com.bytedance.sdk.openadsdk.bq.u.nr.u.pn implements nr {
    private long u;

    public x(Function<SparseArray<Object>, Object> function) {
        super(function);
        this.u = System.currentTimeMillis();
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.pn
    public void u(final int i, final String str) {
        if (str == null) {
            str = "未知异常";
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(i, str);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.x.1
                @Override // java.lang.Runnable
                public void run() {
                    x.super.u(i, str);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.bq.u.nr.u.pn
    public void u(final List<mv> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.u(list);
        } else {
            bg.iz().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.u.x.2
                @Override // java.lang.Runnable
                public void run() {
                    x.super.u(list);
                }
            });
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.u.nr
    public long u() {
        return this.u;
    }
}
