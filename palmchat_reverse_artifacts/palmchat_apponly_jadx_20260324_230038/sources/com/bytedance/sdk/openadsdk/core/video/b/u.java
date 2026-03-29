package com.bytedance.sdk.openadsdk.core.video.b;

import com.bytedance.sdk.openadsdk.my.fx.nr.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    static final Map<Integer, WeakReference<s>> u = new HashMap();

    public static void u(Integer num, s sVar) {
        u.put(num, new WeakReference<>(sVar));
    }

    public static s u(Integer num) {
        WeakReference<s> weakReference = u.get(num);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }
}
