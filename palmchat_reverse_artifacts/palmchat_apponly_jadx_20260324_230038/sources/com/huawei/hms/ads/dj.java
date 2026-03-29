package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class dj {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.i V;

    public static com.huawei.openalliance.ad.inter.data.i Code() {
        com.huawei.openalliance.ad.inter.data.i iVar;
        synchronized (I) {
            iVar = V;
        }
        return iVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.i iVar) {
        synchronized (I) {
            if (iVar == null) {
                fh.Code("GlobalDataShare", "set reward ad null");
                V = null;
            } else {
                V = iVar;
            }
        }
    }
}
