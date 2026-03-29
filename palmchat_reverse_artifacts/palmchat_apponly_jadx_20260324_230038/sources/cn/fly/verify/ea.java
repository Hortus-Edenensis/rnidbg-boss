package cn.fly.verify;

import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f2213a;
    public static final String b;
    public static final String c;
    public static final String d;
    public static final String e;
    public static final String f;
    public static final String g;
    public static final String h;
    public static final Object i;
    public static final Object j;
    private static final String k;

    static {
        String strA = ba.a("011e)gffhfh>niFgfLeQfnhj]n");
        k = strA;
        f2213a = strA + ".mrlock";
        b = strA + ba.a("007!hffeKji6gf!e<fn");
        c = strA + ba.a("011NhfggWiUgfhg7fiBhegf@eDfn");
        d = strA + ba.a("008Thffefmfj[i5gfCeJfn");
        e = strA + ba.a("008]hffehjfj_iCgfQeSfn");
        f = strA + ".cl_lock";
        g = strA + ".gcf_lock";
        h = strA + ".mp_lock";
        i = new Object();
        j = new Object();
    }

    public static synchronized File a(String str) {
        return fz.a(ax.g(), str, true);
    }

    private static String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            String str2 = c;
            if (str.endsWith(str2)) {
                return str2;
            }
            String str3 = b;
            if (str.endsWith(str3)) {
                return str3;
            }
            String str4 = d;
            if (str.endsWith(str4)) {
                return str4;
            }
            String str5 = e;
            if (str.endsWith(str5)) {
                return str5;
            }
            String str6 = f;
            if (str.endsWith(str6)) {
                return str6;
            }
            String str7 = g;
            if (str.endsWith(str7)) {
                return str7;
            }
        }
        return str;
    }

    public static boolean a(File file, dz dzVar) {
        return a(file, true, dzVar);
    }

    public static boolean a(File file, boolean z, dz dzVar) {
        try {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            String absolutePath = file.getAbsolutePath();
            synchronized (b(absolutePath)) {
                fs fsVar = new fs();
                fsVar.a(absolutePath);
                if (!fsVar.a(z)) {
                    return false;
                }
                try {
                    if (!dzVar.a(fsVar)) {
                        fsVar.b();
                    }
                } catch (Throwable unused) {
                    fsVar.b();
                }
                return true;
            }
        } catch (Throwable th) {
            en.a().b(th);
            return true;
        }
    }
}
