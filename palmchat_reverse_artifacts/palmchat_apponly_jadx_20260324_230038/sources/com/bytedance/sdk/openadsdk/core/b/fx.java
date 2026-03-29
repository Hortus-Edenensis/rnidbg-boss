package com.bytedance.sdk.openadsdk.core.b;

import com.bytedance.sdk.component.adexpress.pn.pn;
import com.bytedance.sdk.component.utils.jk;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.y.kj;
import com.bytedance.sdk.openadsdk.core.y.t;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class fx {
    public static void u() {
        com.bytedance.sdk.component.b.u uVarNr;
        jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.fx.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.o().a("img_service");
                    if (!n.o().a("img_service")) {
                        com.bytedance.sdk.openadsdk.n.nr.nr().clearMemoryCache(0.0d);
                    }
                    fx.unregisterReceiver();
                    pn.u().nr();
                } catch (Throwable unused) {
                }
            }
        }, 20000L);
        n.o().a("armor_service");
        n.o().a("device_info");
        if (n.o().a("device_info") || (uVarNr = kj.nr()) == null) {
            return;
        }
        uVarNr.pglArmorCallApiCancelListener();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void unregisterReceiver() {
        t.pn();
        t.a();
        t.n();
    }
}
