package com.amap.api.col.p0002sl;

import android.content.Context;
import android.os.Build;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static WeakReference<ig> f2862a = null;
    private static boolean b = true;
    private static WeakReference<iz> c = null;
    private static WeakReference<iz> d = null;
    private static String[] e = new String[10];
    private static int f = 0;
    private static boolean g = false;
    private static int h;
    private static gd i;

    public static void b(Context context) {
        ix ixVar = new ix(b);
        b = false;
        a(context, ixVar, hb.c);
    }

    public static void c(Context context) {
        WeakReference<iz> weakReference = c;
        if (weakReference == null || weakReference.get() == null) {
            c = new WeakReference<>(new iy(context, 3600000, "hKey", new ja(context)));
        }
        a(context, c.get(), hb.d);
    }

    public static void d(Context context) {
        WeakReference<iz> weakReference = d;
        if (weakReference == null || weakReference.get() == null) {
            d = new WeakReference<>(new iy(context, 3600000, "gKey", new ja(context)));
        }
        a(context, d.get(), hb.b);
    }

    private static boolean a(gd gdVar) {
        return gdVar != null && gdVar.f();
    }

    private static void a(Context context, gd gdVar, int i2, String str, String str2) {
        String str3;
        String strA = im.a();
        String strA2 = im.a(context, gdVar);
        fr.a(context);
        String strA3 = im.a(strA2, strA, i2, str, str2);
        if (strA3 == null || "".equals(strA3)) {
            return;
        }
        String strB = fz.b(str2);
        if (i2 == 1) {
            str3 = hb.b;
        } else if (i2 == 2) {
            str3 = hb.d;
        } else if (i2 != 0) {
            return;
        } else {
            str3 = hb.c;
        }
        String str4 = str3;
        ig igVarA = im.a(f2862a);
        im.a(context, igVarA, str4, 1000, 4096000, "1");
        if (igVarA.e == null) {
            igVarA.e = new ho(new hp(new hr(new hs())));
        }
        try {
            ih.a(strB, ge.a(strA3.replaceAll("\n", "<br/>")), igVarA);
        } catch (Throwable unused) {
        }
    }

    private static String b() {
        StringBuilder sb = new StringBuilder();
        try {
            for (int i2 = f; i2 < 10 && i2 <= 9; i2++) {
                sb.append(e[i2]);
            }
            for (int i3 = 0; i3 < f; i3++) {
                sb.append(e[i3]);
            }
        } catch (Throwable th) {
            hd.c(th, "alg", "gLI");
        }
        return sb.toString();
    }

    public static void a(Context context) {
        String strA;
        gd gdVar;
        List<gd> listA = hb.a();
        if (listA == null || listA.size() == 0 || (strA = a(listA)) == null || "".equals(strA) || (gdVar = i) == null) {
            return;
        }
        a(context, gdVar, 2, "ANR", strA);
    }

    public static void a(Context context, Throwable th, int i2, String str, String str2) {
        String strA = ge.a(th);
        gd gdVarA = a(strA);
        if (a(gdVarA)) {
            String strReplaceAll = strA.replaceAll("\n", "<br/>");
            String string = th.toString();
            if (string == null || "".equals(string)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            if (str != null) {
                sb.append("class:");
                sb.append(str);
            }
            if (str2 != null) {
                sb.append(" method:");
                sb.append(str2);
                sb.append("$<br/>");
            }
            sb.append(strReplaceAll);
            a(context, gdVarA, i2, string, sb.toString());
        }
    }

    public static void a(gd gdVar, Context context, String str, String str2) {
        if (!a(gdVar) || str == null || "".equals(str)) {
            return;
        }
        a(context, gdVar, 1, str, str2);
    }

    private static void a(final Context context, final iz izVar, final String str) {
        jc.a().b(new jd() { // from class: com.amap.api.col.2sl.he.1
            @Override // com.amap.api.col.p0002sl.jd
            public final void a() {
                try {
                    synchronized (he.class) {
                        ig igVarA = im.a(he.f2862a);
                        im.a(context, igVarA, str, 1000, 4096000, "1");
                        igVarA.f = izVar;
                        if (igVarA.g == null) {
                            igVarA.g = new iq(new ip(context, new iu(), new hp(new hr(new hs())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", fr.f(context), fv.k(), fv.p(context), fr.c(context), Build.MODEL, fr.b(context), fr.d(context), Build.VERSION.RELEASE));
                        }
                        igVarA.h = 3600000;
                        ih.a(igVarA);
                    }
                } catch (Throwable th) {
                    hd.c(th, "lg", "pul");
                }
            }
        });
    }

    private static gd a(String str) {
        List<gd> listA = hb.a();
        if (listA == null) {
            listA = new ArrayList();
        }
        if (str != null && !"".equals(str)) {
            for (gd gdVar : listA) {
                if (hb.a(gdVar.g(), str)) {
                    return gdVar;
                }
            }
            if (str.contains("com.amap.api.col")) {
                try {
                    return ge.a();
                } catch (fq e2) {
                    e2.printStackTrace();
                }
            }
            if (str.contains("com.amap.co") || str.contains("com.amap.opensdk.co") || str.contains("com.amap.location")) {
                try {
                    gd gdVarB = ge.b();
                    gdVarB.a(true);
                    return gdVarB;
                } catch (fq e3) {
                    e3.printStackTrace();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0103 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x00f7 -> B:107:0x00fa). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(List<gd> list) {
        hv hvVar;
        FileInputStream fileInputStream;
        File file;
        try {
            try {
                file = new File("/data/anr/traces.txt");
            } catch (Throwable th) {
                hd.c(th, "alg", "getA");
            }
        } catch (FileNotFoundException unused) {
            hvVar = null;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            hvVar = null;
            fileInputStream = null;
        }
        if (!file.exists()) {
            return null;
        }
        fileInputStream = new FileInputStream(file);
        try {
            if (fileInputStream.available() > 1024000) {
                fileInputStream.skip(r3 - 1024000);
            }
            hvVar = new hv(fileInputStream, hu.b);
            boolean z = false;
            while (true) {
                try {
                    String strTrim = hvVar.a().trim();
                    if (strTrim.contains("pid")) {
                        while (!strTrim.startsWith("\"main\"")) {
                            strTrim = hvVar.a();
                        }
                        z = true;
                    }
                    if (!strTrim.equals("") || !z) {
                        if (z) {
                            try {
                                if (f > 9) {
                                    f = 0;
                                }
                                String[] strArr = e;
                                int i2 = f;
                                strArr[i2] = strTrim;
                                f = i2 + 1;
                            } catch (Throwable th3) {
                                hd.c(th3, "alg", "aDa");
                            }
                            int i3 = h;
                            if (i3 == 5) {
                                break;
                            }
                            if (!g) {
                                Iterator<gd> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        gd next = it.next();
                                        boolean zB = hb.b(next.g(), strTrim);
                                        g = zB;
                                        if (zB) {
                                            i = next;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                h = i3 + 1;
                            }
                        }
                    }
                } catch (EOFException unused2) {
                } catch (FileNotFoundException unused3) {
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        hd.c(th, "alg", "getA");
                        if (hvVar != null) {
                            try {
                                hvVar.close();
                            } catch (Throwable th5) {
                                hd.c(th5, "alg", "getA");
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (g) {
                        }
                    } finally {
                    }
                }
            }
            try {
                hvVar.close();
            } catch (Throwable th6) {
                hd.c(th6, "alg", "getA");
            }
            fileInputStream.close();
            break;
        } catch (FileNotFoundException unused4) {
            hvVar = null;
        } catch (Throwable th7) {
            th = th7;
            hvVar = null;
        }
        if (g) {
            return b();
        }
        return null;
        if (hvVar != null) {
            try {
                hvVar.close();
            } catch (Throwable th8) {
                hd.c(th8, "alg", "getA");
            }
        }
        if (fileInputStream != null) {
            fileInputStream.close();
        }
        if (g) {
        }
    }
}
