package com.bytedance.sdk.component.panglearmor;

import android.util.Base64;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class a {
    private static AtomicInteger fx = new AtomicInteger(0);
    private static volatile boolean nr = false;
    private static volatile a u;

    private a() {
    }

    public static int fx() {
        return fx.get();
    }

    public static boolean nr() {
        return nr;
    }

    public static a u() {
        if (u == null) {
            synchronized (a.class) {
                if (u == null) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    try {
                        com.bytedance.sdk.openadsdk.gi.iz.u("panglearmor");
                        nr = true;
                        fx.set(1);
                    } catch (Throwable unused) {
                        nr = false;
                        fx.set(2);
                    }
                    u = new a();
                    long jCurrentTimeMillis2 = System.currentTimeMillis();
                    n nVarIz = iz.iz();
                    if (nVarIz != null) {
                        nVarIz.u(jCurrentTimeMillis2 - jCurrentTimeMillis, nr);
                    }
                }
            }
        }
        return u;
    }

    public byte[] nr(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && nr) {
            try {
                return SoftDecTool.bc(1011, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public byte[] u(byte[] bArr) {
        if (bArr != null && bArr.length != 0 && nr) {
            try {
                return SoftDecTool.bc(1010, bArr);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public String u(String str) {
        if (str == null || str.length() == 0 || !nr) {
            return null;
        }
        try {
            byte[] bArrNr = nr(Base64.decode(str, 0));
            if (bArrNr != null) {
                return new String(bArrNr);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
