package com.opos.cmn.func.a.b.a;

import com.heytap.nearx.okhttp.extension.HeyConfig;
import com.heytap.okhttp.extension.HeyConfig;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class b {
    public static com.opos.cmn.func.a.b.f a() {
        com.opos.cmn.func.a.b.f bVar;
        try {
            com.opos.cmn.an.f.a.a("HttpImplUtils", new HeyConfig.Builder().toString());
            bVar = new com.opos.cmn.func.a.b.c();
        } catch (Throwable unused) {
            bVar = null;
        }
        if (bVar == null) {
            try {
                com.opos.cmn.an.f.a.a("HttpImplUtils", new HeyConfig.Builder().toString());
                bVar = new com.opos.cmn.func.a.b.b();
            } catch (Throwable unused2) {
            }
        }
        return bVar == null ? new com.opos.cmn.func.a.b.a() : bVar;
    }
}
