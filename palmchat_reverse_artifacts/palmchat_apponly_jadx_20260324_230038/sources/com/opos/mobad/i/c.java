package com.opos.mobad.i;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile d f8932a;
    private static final byte[] b = new byte[0];

    public static b a(Context context, a aVar) {
        b bVarA;
        if (context == null || aVar == null) {
            bVarA = null;
        } else {
            a();
            try {
                bVarA = f8932a.a(context.getApplicationContext(), aVar);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("DownloadTool", "download", (Throwable) e);
                bVarA = null;
            }
        }
        com.opos.cmn.an.f.a.b("DownloadTool", "download request=", aVar, "response=", bVarA);
        return bVarA;
    }

    private static void a() {
        if (f8932a == null) {
            synchronized (b) {
                if (f8932a == null) {
                    f8932a = new com.opos.mobad.i.a.a();
                }
            }
        }
    }
}
