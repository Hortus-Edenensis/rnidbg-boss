package com.bytedance.sdk.openadsdk.core.bc.u;

import com.bytedance.sdk.openadsdk.TTAdLoadType;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class b {
    private static Boolean u;

    private static boolean u() {
        if (u == null) {
            try {
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
                u = Boolean.TRUE;
            } catch (Throwable unused) {
                u = Boolean.FALSE;
            }
        }
        return u.booleanValue();
    }

    public static int u(Object obj) {
        if (obj == null) {
            return -1;
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (u()) {
            try {
                if (TTAdLoadType.LOAD == obj) {
                    return 3;
                }
                if (TTAdLoadType.PRELOAD == obj) {
                    return 1;
                }
                TTAdLoadType tTAdLoadType = TTAdLoadType.UNKNOWN;
            } catch (Throwable unused) {
            }
        }
        return -1;
    }
}
