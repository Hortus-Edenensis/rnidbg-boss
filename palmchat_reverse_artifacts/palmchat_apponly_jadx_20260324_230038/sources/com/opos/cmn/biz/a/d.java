package com.opos.cmn.biz.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f7821a = "";

    public static String a(Context context) {
        if (!com.opos.cmn.an.d.b.a(f7821a)) {
            return f7821a;
        }
        if (context != null) {
            f7821a = f.b(context);
        }
        if (com.opos.cmn.an.d.b.a(f7821a)) {
            f7821a = com.opos.cmn.an.c.d.d();
            if (com.opos.cmn.an.d.b.a(f7821a)) {
                f7821a = "CN";
            }
        }
        return f7821a;
    }

    public static synchronized void a(Context context, String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            com.opos.cmn.an.f.a.c("RegionTool", "init, setRegion= null");
            return;
        }
        try {
            String upperCase = str.toUpperCase();
            if (!com.opos.cmn.an.d.b.a(upperCase) && !upperCase.contentEquals(f7821a)) {
                f7821a = upperCase;
                if (context != null) {
                    final Context applicationContext = context.getApplicationContext();
                    new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.d.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.b(applicationContext, d.f7821a);
                        }
                    }).start();
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RegionTool", "setRegion", e);
        }
        com.opos.cmn.an.f.a.a("RegionTool", "init, setRegion=" + str);
    }
}
