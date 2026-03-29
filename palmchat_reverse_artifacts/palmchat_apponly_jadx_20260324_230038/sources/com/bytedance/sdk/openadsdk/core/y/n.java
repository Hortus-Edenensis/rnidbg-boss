package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class n {
    public static boolean u() {
        try {
            if (com.bytedance.sdk.openadsdk.core.n.o().wi()) {
                return true;
            }
            Context context = com.bytedance.sdk.openadsdk.core.dw.getContext();
            if (context.getApplicationInfo() != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static void u(com.bytedance.sdk.openadsdk.my.fx.fx.u uVar) {
        try {
            if (!uVar.n() || com.bytedance.sdk.component.utils.k.u()) {
                return;
            }
            System.currentTimeMillis();
            if (Boolean.parseBoolean(new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop debug.ttcsj.debugmode").getInputStream())).readLine())) {
                com.bytedance.sdk.component.utils.k.nr();
                com.bykv.vk.openvk.component.video.api.iz.fx.u();
                com.bytedance.sdk.component.a.u.u();
                com.bytedance.sdk.openadsdk.tools.nr.nr();
                com.bytedance.sdk.component.l.nr.u.u(true);
            }
        } catch (Exception unused) {
        }
    }
}
