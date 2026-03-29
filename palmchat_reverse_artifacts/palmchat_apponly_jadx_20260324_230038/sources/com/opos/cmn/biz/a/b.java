package com.opos.cmn.biz.a;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f7818a = "";

    public static String a(Context context) {
        if (a(f7818a)) {
            return f7818a;
        }
        if (context != null) {
            f7818a = f.a(context);
        }
        if (!a(f7818a)) {
            f7818a = com.opos.cmn.an.c.c.d();
            if (!a(f7818a)) {
                f7818a = a.c;
            }
        }
        return f7818a;
    }

    public static synchronized void a(Context context, String str) {
        if (com.opos.cmn.an.d.b.a(str)) {
            com.opos.cmn.an.f.a.c("BrandTool", "init, set Brand = null");
            return;
        }
        try {
            String upperCase = str.toUpperCase();
            if (a(upperCase) && !upperCase.contentEquals(f7818a)) {
                f7818a = upperCase;
                if (context != null) {
                    final Context applicationContext = context.getApplicationContext();
                    new Thread(new Runnable() { // from class: com.opos.cmn.biz.a.b.1
                        @Override // java.lang.Runnable
                        public void run() {
                            f.a(applicationContext, b.f7818a);
                        }
                    }).start();
                }
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("BrandTool", "setBrand", e);
        }
        com.opos.cmn.an.f.a.a("BrandTool", "init, set Brand = " + str);
    }

    private static boolean a(String str) {
        Boolean bool = Boolean.TRUE;
        if (com.opos.cmn.an.d.b.a(str) || (!a.c.equalsIgnoreCase(str) && !a.f7817a.equalsIgnoreCase(str) && !a.b.equalsIgnoreCase(str))) {
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }
}
