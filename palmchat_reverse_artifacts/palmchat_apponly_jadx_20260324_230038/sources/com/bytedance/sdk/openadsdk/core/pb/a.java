package com.bytedance.sdk.openadsdk.core.pb;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.openadsdk.core.dw;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    private static PluginValueSet fx;
    private static com.bytedance.sdk.openadsdk.core.fx nr;
    private static final AtomicInteger u = new AtomicInteger(com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), "sync_switch", 0).getInt("status", 1));

    public static boolean u() {
        return u.get() == 1;
    }

    public static void u(int i) {
        com.bytedance.sdk.openadsdk.core.fx fxVar;
        if (i == 1 || i == 2) {
            com.bytedance.sdk.openadsdk.api.plugin.nr.nr(dw.getContext(), "sync_switch", 0).edit().putInt("status", i).apply();
            AtomicInteger atomicInteger = u;
            int i2 = atomicInteger.get();
            atomicInteger.set(i);
            if (i2 != 2 || i != 1 || (fxVar = nr) == null || fxVar.u()) {
                return;
            }
            try {
                nr.u(dw.getContext(), fx, new com.bytedance.sdk.openadsdk.core.bc.fx((Function) fx.objectValue(15, Function.class)));
                nr = null;
                fx = null;
            } catch (Throwable th) {
                k.u("SdkSwitch", "init sdk error", th);
            }
        }
    }
}
