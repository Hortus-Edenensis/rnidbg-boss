package com.opos.cmn.g.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.g.a.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f8011a = new byte[0];
    private static volatile boolean b = false;
    private static volatile f.b c;

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f8012a;

        public a(Context context) {
            this.f8012a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                synchronized (e.f8011a) {
                    f.b bVarA = f.a(this.f8012a);
                    if (bVarA != null) {
                        f.b unused = e.c = bVarA;
                        StringBuilder sb = new StringBuilder();
                        sb.append("updateGAID gaid:");
                        sb.append(e.c.a());
                        sb.append(" gaidStatus:");
                        sb.append(!e.c.b());
                        com.opos.cmn.an.f.a.a("GAIDUtils", sb.toString());
                    }
                    if (e.c != null) {
                        if (!TextUtils.isEmpty(e.c.a())) {
                            i.c(this.f8012a, e.c.a());
                        }
                        i.b(this.f8012a, !bVarA.b());
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0027, code lost:
    
        r1 = "";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        try {
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
        }
        String strC = (c == null || TextUtils.isEmpty(c.a())) ? context != null ? i.c(context) : "" : c.a();
        if (!b) {
            b(context);
        }
        return strC != null ? strC : "";
    }

    public static synchronized void b(Context context) {
        if (context != null) {
            try {
                Context applicationContext = context.getApplicationContext();
                b = true;
                new Thread(new a(applicationContext)).start();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("GAIDUtils", "", e);
            }
        }
    }
}
