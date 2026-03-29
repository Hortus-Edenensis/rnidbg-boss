package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ey {
    private static final String Code = "InterstitialGlobalDataShare";
    private static final byte[] I = new byte[0];
    private static ex V;

    public static ex Code() {
        ex exVar;
        synchronized (I) {
            exVar = V;
        }
        return exVar;
    }

    public static void Code(ex exVar) {
        synchronized (I) {
            if (exVar == null) {
                fh.Code(Code, "set interstitial ad null");
                V = null;
            } else {
                V = exVar;
            }
        }
    }
}
