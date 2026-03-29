package com.huawei.hms.ads;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class dk {
    private static final byte[] I = new byte[0];
    private static com.huawei.openalliance.ad.inter.data.l V;

    public static com.huawei.openalliance.ad.inter.data.l Code() {
        com.huawei.openalliance.ad.inter.data.l lVar;
        synchronized (I) {
            lVar = V;
        }
        return lVar;
    }

    public static void Code(com.huawei.openalliance.ad.inter.data.l lVar) {
        synchronized (I) {
            if (lVar == null) {
                fh.Code("GlobalDataShare", "set native ad null");
                V = null;
            } else {
                V = lVar;
            }
        }
    }
}
