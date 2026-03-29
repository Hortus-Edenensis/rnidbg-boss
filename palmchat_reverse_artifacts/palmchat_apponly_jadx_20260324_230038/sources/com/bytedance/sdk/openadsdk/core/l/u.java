package com.bytedance.sdk.openadsdk.core.l;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.l.fx.jk;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static final LruCache<String, com.bytedance.sdk.openadsdk.core.kj.b> u = new LruCache<>(10);

    public static void u(String str, com.bytedance.sdk.openadsdk.core.kj.b bVar) {
        if (dw.nr().az() && !TextUtils.isEmpty(str) && bVar != null && bVar.pn()) {
            u.put(str, bVar);
        }
    }

    public static com.bytedance.sdk.openadsdk.core.kj.b u(String str) {
        com.bytedance.sdk.openadsdk.core.kj.b bVar;
        if (dw.nr().az() && (bVar = u.get(str)) != null && bVar.pn()) {
            return bVar;
        }
        return null;
    }

    public static void u(final bc bcVar) {
        if (dw.nr().az() && bcVar != null) {
            final String strNr = bcVar.pu() != null ? bcVar.pu().nr() : "";
            if (!TextUtils.isEmpty(strNr) && bcVar.qf() == 4 && TextUtils.isEmpty(bcVar.kd())) {
                if ((bcVar.wj() == null || bcVar.wj().nr() == 0) && jk.u(bcVar) == 2) {
                    com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("preloadAppInfo") { // from class: com.bytedance.sdk.openadsdk.core.l.u.1
                        @Override // java.lang.Runnable
                        public void run() {
                            dw.u().u(bcVar, strNr);
                        }
                    });
                }
            }
        }
    }
}
