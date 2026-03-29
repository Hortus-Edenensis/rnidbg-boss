package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.y.jp;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    public static void u(final String str, final String str2, final bc bcVar) {
        final long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        com.bytedance.sdk.openadsdk.core.qq.s.u().u(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.1
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                com.bytedance.sdk.openadsdk.core.qq.u.nr nrVarU = com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(a.u(str)).fx(str2).iz(jp.k(bcVar)).u("dynamic_backup_render_new");
                nrVarU.u(jCurrentTimeMillis);
                return nrVarU;
            }
        }, "dynamic_backup_render_new");
    }

    public static void u(final int i, final String str, final String str2, final bc bcVar) {
        com.bytedance.sdk.openadsdk.core.qq.s.u().pn(new com.bytedance.sdk.openadsdk.t.u.u() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.a.2
            @Override // com.bytedance.sdk.openadsdk.t.u.u
            public com.bytedance.sdk.openadsdk.core.qq.u.u u() throws Exception {
                return com.bytedance.sdk.openadsdk.core.qq.u.nr.nr().u(a.u(str)).fx(str2).iz(jp.k(bcVar)).nr(i).x(com.bytedance.sdk.openadsdk.core.x.u(i));
            }
        });
    }

    public static int u(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5;
        }
        str.hashCode();
        switch (str) {
        }
        return 5;
    }
}
