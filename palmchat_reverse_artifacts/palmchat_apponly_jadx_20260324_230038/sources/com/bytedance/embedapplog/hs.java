package com.bytedance.embedapplog;

import android.os.SystemProperties;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class hs {
    private static volatile Object u;

    private Object u() {
        if (u == null) {
            synchronized (hs.class) {
                if (u == null) {
                    try {
                        u = Class.forName("android.os.SystemProperties").newInstance();
                    } catch (Throwable unused) {
                    }
                }
            }
        }
        return u;
    }

    public String u(String str) {
        try {
            return SystemProperties.get(str);
        } catch (Throwable th) {
            ti.u(th);
            try {
                Object objU = u();
                return (String) objU.getClass().getMethod("get", String.class).invoke(objU, str);
            } catch (Throwable th2) {
                ti.u(th2);
                return "";
            }
        }
    }
}
