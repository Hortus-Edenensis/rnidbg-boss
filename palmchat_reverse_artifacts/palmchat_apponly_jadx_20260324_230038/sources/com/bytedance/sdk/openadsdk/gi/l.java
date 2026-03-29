package com.bytedance.sdk.openadsdk.gi;

import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.pangle.Zeus;
import com.bytedance.sdk.openadsdk.core.d;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    private static Map<String, Field> u = new HashMap();

    public static int b(String str) {
        return TextUtils.equals("com.byted.pangle", str) ? d.fx : u(str, 102);
    }

    public static int fx(String str) {
        if (TextUtils.equals("com.byted.pangle", str)) {
            return 7232;
        }
        return u(str, 103);
    }

    private static void iz(String str) {
        try {
            int i = Zeus.f5065a;
            Zeus.class.getDeclaredMethod("unInstallPlugin", String.class).invoke(null, str);
        } catch (Throwable unused) {
        }
    }

    public static int nr(String str) {
        return TextUtils.equals("com.byted.pangle", str) ? d.fx : u(str, 101);
    }

    public static boolean pn(String str) {
        Object objApply;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Function<SparseArray<Object>, Object> functionIz = com.bytedance.sdk.openadsdk.core.n.o().iz(4);
            if (functionIz != null && (objApply = functionIz.apply(com.bytedance.sdk.openadsdk.my.b.u().u(105).u(Boolean.class).u(0, str).nr())) != null) {
                return ((Boolean) objApply).booleanValue();
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static void u(String str) {
        try {
            if (d.fx < 5500) {
                iz(str);
                return;
            }
            Function<SparseArray<Object>, Object> functionIz = com.bytedance.sdk.openadsdk.core.n.o().iz(4);
            if (functionIz != null) {
                functionIz.apply(com.bytedance.sdk.openadsdk.my.b.u().u(100).u(Void.class).u(0, str).nr());
            }
        } catch (Throwable unused) {
        }
    }

    public static int u(String str, int i) {
        Object objApply;
        try {
            Function<SparseArray<Object>, Object> functionIz = com.bytedance.sdk.openadsdk.core.n.o().iz(4);
            if (functionIz != null && (objApply = functionIz.apply(com.bytedance.sdk.openadsdk.my.b.u().u(i).u(Integer.class).u(0, str).nr())) != null) {
                return ((Integer) objApply).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }
}
