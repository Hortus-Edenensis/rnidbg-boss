package com.bytedance.sdk.openadsdk.core.y;

import com.bytedance.sdk.openadsdk.core.kj.ay;
import com.bytedance.sdk.openadsdk.core.kj.wi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class q {
    public static boolean b(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return bcVar != null && n(bcVar) == 4;
    }

    public static boolean fx(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null || wi.u(bcVar) || n(bcVar) != 3) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.core.kj.bg.u(bcVar);
    }

    public static int iz(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return -1;
        }
        if (n(bcVar) != 3) {
            return 0;
        }
        return com.bytedance.sdk.openadsdk.core.kj.bg.jk(bcVar);
    }

    private static int n(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (com.bytedance.sdk.openadsdk.core.kj.bg.u(bcVar)) {
            return 3;
        }
        return ay.u(bcVar) ? 4 : 0;
    }

    public static boolean nr(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return (bcVar == null || n(bcVar) == 0) ? false : true;
    }

    public static int pn(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar != null && n(bcVar) == 3) {
            return com.bytedance.sdk.openadsdk.core.kj.bg.a(bcVar);
        }
        return 0;
    }

    public static String u(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return "";
        }
        int iN = n(bcVar);
        return iN != 3 ? iN != 4 ? "" : ay.pn(bcVar) : com.bytedance.sdk.openadsdk.core.kj.bg.iz(bcVar);
    }

    public static boolean x(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return n(bcVar) == 3;
    }
}
