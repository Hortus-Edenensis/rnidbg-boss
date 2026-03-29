package com.amap.api.col.p0002sl;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.igexin.push.core.b;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class gc {
    public static Proxy a(Context context) {
        try {
            return a(context, new URI("http://restsdk.amap.com"));
        } catch (Throwable th) {
            hd.c(th, "pu", "gp");
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x015c A[Catch: all -> 0x0158, TRY_LEAVE, TryCatch #10 {all -> 0x0158, blocks: (B:108:0x014d, B:115:0x015c), top: B:130:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0142 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x014d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00d4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a8 A[PHI: r11
      0x00a8: PHI (r11v31 java.lang.String) = (r11v27 java.lang.String), (r11v36 java.lang.String) binds: [B:48:0x00a6, B:29:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ab A[PHI: r10 r11
      0x00ab: PHI (r10v11 int) = (r10v10 int), (r10v13 int) binds: [B:48:0x00a6, B:29:0x0074] A[DONT_GENERATE, DONT_INLINE]
      0x00ab: PHI (r11v32 java.lang.String) = (r11v27 java.lang.String), (r11v36 java.lang.String) binds: [B:48:0x00a6, B:29:0x0074] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef A[Catch: all -> 0x0171, TryCatch #8 {all -> 0x0171, blocks: (B:66:0x00ca, B:75:0x00e4, B:77:0x00ef, B:79:0x0103, B:81:0x0109, B:86:0x0115, B:89:0x011e, B:91:0x0124, B:93:0x012a, B:98:0x0136), top: B:129:0x0028 }] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4 */
    /* JADX WARN: Type inference failed for: r10v7, types: [int] */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r18v10 */
    /* JADX WARN: Type inference failed for: r18v11 */
    /* JADX WARN: Type inference failed for: r18v2 */
    /* JADX WARN: Type inference failed for: r18v3 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r18v5 */
    /* JADX WARN: Type inference failed for: r18v6 */
    /* JADX WARN: Type inference failed for: r18v7 */
    /* JADX WARN: Type inference failed for: r18v8 */
    /* JADX WARN: Type inference failed for: r18v9 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Proxy b(Context context) {
        Cursor cursorQuery;
        ?? r10;
        String strL;
        ?? r18;
        Throwable th;
        boolean z;
        boolean z2;
        ?? r102;
        int iB;
        boolean z3;
        boolean z4;
        if (c(context)) {
            Uri uri = Uri.parse("content://telephony/carriers/preferapn");
            String strA = null;
            boolean z5 = false;
            try {
                try {
                    cursorQuery = context.getContentResolver().query(uri, null, null, null, null);
                } finally {
                }
            } catch (SecurityException e) {
                e = e;
                cursorQuery = null;
                strA = null;
            } catch (Throwable th2) {
                th = th2;
                cursorQuery = null;
                strA = null;
            }
            if (cursorQuery != null) {
                try {
                } catch (SecurityException e2) {
                    e = e2;
                    strA = null;
                    r10 = -1;
                    hd.c(e, "pu", "ghp");
                    strL = fv.l(context);
                    if (strL != null) {
                    }
                    if (cursorQuery != null) {
                    }
                    r102 = r18;
                    if (strA != null) {
                    }
                    if (z5) {
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    strA = null;
                    r10 = -1;
                    hd.c(th, "pu", "gPx1");
                    th.printStackTrace();
                    r102 = r10;
                    if (cursorQuery != null) {
                    }
                    if (strA != null) {
                    }
                    if (z5) {
                    }
                    return null;
                }
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("apn"));
                    String lowerCase = string;
                    r10 = uri;
                    if (string != null) {
                        Locale locale = Locale.US;
                        lowerCase = string.toLowerCase(locale);
                        r10 = locale;
                    }
                    try {
                        try {
                            if (lowerCase == null || !lowerCase.contains("ctwap")) {
                                if (lowerCase != null && lowerCase.contains("wap")) {
                                    String strA2 = a();
                                    iB = b();
                                    if (TextUtils.isEmpty(strA2) || strA2.equals(b.m)) {
                                        strA = null;
                                        z3 = false;
                                    } else {
                                        strA = strA2;
                                        z3 = true;
                                    }
                                    if (!z3) {
                                        strA = a("QMTAuMC4wLjE3Mg==");
                                    }
                                    r18 = iB == -1 ? 80 : iB;
                                }
                                strA = null;
                                r18 = -1;
                            } else {
                                String strA3 = a();
                                iB = b();
                                if (TextUtils.isEmpty(strA3) || strA3.equals(b.m)) {
                                    strA = null;
                                    z4 = false;
                                } else {
                                    strA = strA3;
                                    z4 = true;
                                }
                                if (!z4) {
                                    strA = a("QMTAuMC4wLjIwMA==");
                                }
                                if (iB == -1) {
                                }
                            }
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                } catch (Throwable th4) {
                                    th = th4;
                                    r18 = r18;
                                    hd.c(th, "pu", "gPx2");
                                }
                            }
                        } catch (SecurityException e3) {
                            e = e3;
                            strA = null;
                            hd.c(e, "pu", "ghp");
                            strL = fv.l(context);
                            if (strL != null) {
                                String lowerCase2 = strL.toLowerCase(Locale.US);
                                String strA4 = a();
                                int iB2 = b();
                                if (lowerCase2.indexOf("ctwap") != -1) {
                                    if (TextUtils.isEmpty(strA4) || strA4.equals(b.m)) {
                                        z2 = false;
                                    } else {
                                        strA = strA4;
                                        z2 = true;
                                    }
                                    if (!z2) {
                                        strA = a("QMTAuMC4wLjIwMA==");
                                    }
                                    r18 = iB2 == -1 ? 80 : iB2;
                                } else {
                                    if (lowerCase2.indexOf("wap") != -1) {
                                        if (TextUtils.isEmpty(strA4) || strA4.equals(b.m)) {
                                            z = false;
                                        } else {
                                            strA = strA4;
                                            z = true;
                                        }
                                        if (!z) {
                                            strA = a("QMTAuMC4wLjE3Mg==");
                                        }
                                    }
                                }
                            } else {
                                r18 = r10;
                            }
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    r18 = r18;
                                    hd.c(th, "pu", "gPx2");
                                }
                            }
                            r102 = r18;
                            if (strA != null) {
                            }
                            if (z5) {
                            }
                            return null;
                        } catch (Throwable th6) {
                            th = th6;
                            strA = null;
                            hd.c(th, "pu", "gPx1");
                            th.printStackTrace();
                            r102 = r10;
                            if (cursorQuery != null) {
                                try {
                                    cursorQuery.close();
                                    r102 = r10;
                                } catch (Throwable th7) {
                                    hd.c(th7, "pu", "gPx2");
                                    r102 = r10;
                                }
                            }
                            if (strA != null) {
                            }
                            if (z5) {
                            }
                            return null;
                        }
                    } catch (SecurityException e4) {
                        e = e4;
                        hd.c(e, "pu", "ghp");
                        strL = fv.l(context);
                        if (strL != null) {
                        }
                        if (cursorQuery != null) {
                        }
                        r102 = r18;
                        if (strA != null) {
                        }
                        if (z5) {
                        }
                        return null;
                    } catch (Throwable th8) {
                        th = th8;
                        hd.c(th, "pu", "gPx1");
                        th.printStackTrace();
                        r102 = r10;
                        if (cursorQuery != null) {
                        }
                        if (strA != null) {
                        }
                        if (z5) {
                        }
                        return null;
                    }
                    r102 = r18;
                    if (strA != null) {
                        try {
                            if (strA.length() > 0 && r102 != -1) {
                                z5 = true;
                            }
                        } catch (Throwable th9) {
                            ha.a(th9, "pu", "gp2");
                            th9.printStackTrace();
                        }
                    }
                    if (z5) {
                        return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(strA, r102));
                    }
                } else {
                    strA = null;
                    r18 = -1;
                    if (cursorQuery != null) {
                    }
                    r102 = r18;
                    if (strA != null) {
                    }
                    if (z5) {
                    }
                }
            }
        }
        return null;
    }

    private static boolean c(Context context) {
        return fv.j(context) == 0;
    }

    private static String a(String str) {
        return ge.c(str);
    }

    private static String a() {
        String defaultHost;
        try {
            defaultHost = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            hd.c(th, "pu", "gdh");
            defaultHost = null;
        }
        return defaultHost == null ? b.m : defaultHost;
    }

    private static Proxy a(Context context, URI uri) {
        Proxy proxy;
        if (c(context)) {
            try {
                List<Proxy> listSelect = ProxySelector.getDefault().select(uri);
                if (listSelect == null || listSelect.isEmpty() || (proxy = listSelect.get(0)) == null) {
                    return null;
                }
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                hd.c(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            hd.c(th, "pu", "gdp");
            return -1;
        }
    }
}
