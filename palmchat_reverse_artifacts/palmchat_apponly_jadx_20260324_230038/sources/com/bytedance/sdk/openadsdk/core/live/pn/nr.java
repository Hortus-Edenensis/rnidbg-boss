package com.bytedance.sdk.openadsdk.core.live.pn;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.bf;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class nr {
    private static com.bytedance.sdk.component.b.nr.fx u;

    public static void b(String str) {
        u();
        nr(str);
    }

    public static boolean fx(String str) {
        nr();
        com.bytedance.sdk.component.b.nr.fx fxVar = u;
        return (fxVar != null ? fxVar.get("live_init_".concat(String.valueOf(str)), 0) : 0) < 5;
    }

    private static void nr() {
        if (u == null) {
            u = bf.u("csj_live");
        }
    }

    public static void u(String str) {
        nr();
        try {
            com.bytedance.sdk.component.b.nr.fx fxVar = u;
            if (fxVar != null) {
                u.put("live_init_".concat(String.valueOf(str)), fxVar.get("live_init_".concat(String.valueOf(str)), 0) + 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static void nr(String str) {
        nr();
        try {
            com.bytedance.sdk.component.b.nr.fx fxVar = u;
            if (fxVar != null) {
                fxVar.put("live_init_".concat(String.valueOf(str)), 0);
            }
        } catch (Throwable unused) {
        }
    }

    public static void u() {
        try {
            Function<SparseArray<Object>, Object> functionIz = n.o().iz(4);
            if (functionIz != null) {
                functionIz.apply(com.bytedance.sdk.openadsdk.my.b.u().u(100).u(Void.class).u(0, "com.byted.live.lite").nr());
            }
        } catch (Throwable unused) {
        }
    }
}
