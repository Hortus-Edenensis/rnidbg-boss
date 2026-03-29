package com.opos.cmn.g.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {
    public static String a(Context context) {
        String strA;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (context != null) {
            try {
                strA = com.opos.cmn.an.a.a.a.a(context);
            } catch (Throwable th) {
                com.opos.cmn.an.f.a.c("ImeiTool", "getImei", th);
                strA = "";
            }
            com.opos.cmn.an.f.a.a("ImeiTool", "getImei result:" + strA + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
            return strA;
        }
        com.opos.cmn.an.f.a.c("ImeiTool", "getImei failed, context is null");
        strA = "";
        com.opos.cmn.an.f.a.a("ImeiTool", "getImei result:" + strA + " costTime:" + (System.currentTimeMillis() - jCurrentTimeMillis));
        return strA;
    }

    @Deprecated
    public static String b(Context context) {
        return "";
    }
}
