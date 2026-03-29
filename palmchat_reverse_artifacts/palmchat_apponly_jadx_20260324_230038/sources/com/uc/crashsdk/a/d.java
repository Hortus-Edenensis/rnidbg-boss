package com.uc.crashsdk.a;

import android.os.Process;
import com.huawei.hms.ads.ex;
import com.huawei.hms.framework.common.ContainerUtils;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.Locale;
import org.apache.http.HttpHost;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f10811a = true;
    private static boolean b = true;
    private static boolean d = false;
    private static String e = "hsdk";
    private static String f = "alid ";
    private static String g;
    private static String i;
    private static final Object c = new Object();
    private static final Object h = new Object();

    public static void a() {
        f.a(0, new e(500), com.uc.crashsdk.b.H() ? 900000L : 90000L);
    }

    public static String b() {
        try {
            return "inv" + f + "cras" + e;
        } catch (Throwable th) {
            g.b(th);
            return "";
        }
    }

    public static void c() {
        synchronized (h) {
            i = null;
        }
    }

    public static byte[] d() {
        return new byte[]{6, 0, 23, 8};
    }

    public static boolean e() {
        if (!com.uc.crashsdk.e.F() && !com.uc.crashsdk.b.L()) {
            a(true);
            return b;
        }
        return true;
    }

    private static String f() {
        String strA = i;
        if (g.a(strA)) {
            synchronized (h) {
                strA = g.a(com.uc.crashsdk.b.j(), (com.uc.crashsdk.g.S() ? "https://errlogos.umeng.com" : "https://errlog.umeng.com") + "/api/crashsdk/validate", true);
                i = strA;
            }
        }
        return strA;
    }

    private static String g() {
        byte[] bArrA;
        String strF;
        byte[] bArrA2;
        byte[] bArrA3;
        StringBuilder sb = new StringBuilder();
        a(sb, "platform", com.uc.crashsdk.g.e());
        a(sb, "pkgname", com.uc.crashsdk.a.f10808a);
        a(sb, "process", com.uc.crashsdk.e.h());
        a(sb, "version", com.uc.crashsdk.a.a());
        a(sb, "cver", "3.3.2.2");
        a(sb, "ctag", BaseConstants.CATEGORY_UMENG);
        a(sb, "inter", com.uc.crashsdk.g.S() ? ex.Code : ex.V);
        a(sb, "os", "android");
        String string = sb.toString();
        byte[] bArr = new byte[16];
        c.a(bArr, 0, h.j());
        c.a(bArr, 4, c.a());
        c.a(bArr, 8, d());
        c.a(bArr, 12, com.uc.crashsdk.a.f());
        try {
            bArrA = c.a(string.getBytes(), bArr, true);
        } catch (Throwable th) {
            g.a(th);
            bArrA = null;
        }
        if (bArrA == null || (strF = f()) == null || (bArrA2 = c.a(strF, bArrA)) == null) {
            return null;
        }
        try {
            bArrA3 = c.a(bArrA2, bArr, false);
        } catch (Throwable th2) {
            g.a(th2);
            bArrA3 = null;
        }
        if (bArrA3 != null) {
            return new String(bArrA3);
        }
        return null;
    }

    public static void a(int i2) {
        if (i2 != 500) {
            if (!f10811a) {
                throw new AssertionError();
            }
            return;
        }
        synchronized (c) {
            g = null;
            a(!com.uc.crashsdk.b.F());
            if (g.b(g)) {
                h.a(g);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean a(boolean z) throws Throwable {
        String str;
        long jC;
        int iC;
        boolean z2;
        String str2;
        if (d) {
            return false;
        }
        d = !z;
        if ((com.uc.crashsdk.a.b.equals("2.0") && com.uc.crashsdk.b.c(536870912)) || !com.uc.crashsdk.b.A()) {
            return false;
        }
        String strN = com.uc.crashsdk.b.n();
        String strA = b.a(strN);
        if (g.b(strA)) {
            String[] strArrSplit = strA.split(" ", 4);
            if (strArrSplit.length == 3) {
                str = strArrSplit[0];
                jC = g.c(strArrSplit[1]);
                iC = (int) g.c(strArrSplit[2]);
            } else {
                str = null;
                jC = 0;
                iC = 0;
            }
        }
        b = true;
        if (System.currentTimeMillis() - jC >= 259200000) {
            z2 = true;
        } else {
            if (!"o".equals(str)) {
                if ("2".equals(str)) {
                    b = false;
                } else {
                    if ("1".equals(str)) {
                        b = false;
                    }
                    z2 = true;
                }
            }
            z2 = false;
        }
        if (!z2 || z) {
            return true;
        }
        if (iC == Process.myPid()) {
            return false;
        }
        g = "per";
        String strG = g();
        if (strG == null || !strG.contains("retcode=")) {
            if (strG == null) {
                g = "ner";
            } else {
                g = "ser";
            }
            return false;
        }
        if (strG.contains("retcode=0")) {
            b = true;
            str2 = "o";
            g = "aus";
        } else {
            b = false;
            if ("1".equals(str)) {
                str2 = "2";
                g = "auf2";
            } else {
                str2 = "1";
                g = "auf1";
            }
        }
        b.a(strN, String.format(Locale.US, "%s %d %d", str2, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(Process.myPid())));
        if (g.b(strG)) {
            for (String str3 : strG.split("`", 30)) {
                String[] strArrSplit2 = str3.split(ContainerUtils.KEY_VALUE_DELIMITER, 2);
                if (strArrSplit2.length == 2) {
                    String strTrim = strArrSplit2[0].trim();
                    String strTrim2 = strArrSplit2[1].trim();
                    boolean z3 = g.b(strTrim2) && strTrim2.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
                    if ("logurl".equals(strTrim)) {
                        if (z3) {
                            com.uc.crashsdk.e.b(strTrim2);
                        }
                    } else if ("staturl".equals(strTrim)) {
                        if (z3) {
                            h.b(strTrim2);
                        }
                    } else if ("policyurl".equals(strTrim)) {
                        if (z3) {
                            synchronized (h) {
                                i = strTrim2;
                                b.a(com.uc.crashsdk.b.j(), strTrim2 + "\n");
                            }
                        } else {
                            continue;
                        }
                    } else if ("logpolicy".equals(strTrim)) {
                        com.uc.crashsdk.e.c(strTrim2);
                    }
                }
            }
        }
        return true;
    }

    private static StringBuilder a(StringBuilder sb, String str, String str2) {
        if (sb.length() > 0) {
            sb.append("`");
        }
        sb.append(str);
        sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
        sb.append(str2);
        return sb;
    }
}
