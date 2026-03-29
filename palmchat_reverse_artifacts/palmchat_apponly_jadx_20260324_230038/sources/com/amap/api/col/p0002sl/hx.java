package com.amap.api.col.p0002sl;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.p0002sl.id;
import com.amap.api.maps2d.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class hx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f2880a = 0;
    public static String b = "";
    public static HashMap<String, String> c;
    public static HashMap<String, String> d;
    public static HashMap<String, String> e;
    private static hx f;

    /* JADX INFO: compiled from: SearchBox */
    public interface a {
        URLConnection a();
    }

    public hx() {
        fs.e();
    }

    public static hx a() {
        if (f == null) {
            f = new hx();
        }
        return f;
    }

    public static ie c(id idVar) throws fq {
        return a(idVar, idVar.u());
    }

    public static boolean d(id idVar) throws fq {
        f(idVar);
        try {
            String strB_ = idVar.b_();
            if (TextUtils.isEmpty(strB_)) {
                return false;
            }
            String host = new URL(strB_).getHost();
            if (!TextUtils.isEmpty(idVar.j())) {
                host = idVar.j();
            }
            return fs.g(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean e(id idVar) throws fq {
        f(idVar);
        try {
            if (!d(idVar)) {
                return true;
            }
            if (idVar.f().equals(idVar.b_()) || idVar.r() == id.a.SINGLE) {
                return false;
            }
            if (!fs.h) {
                return false;
            }
        } catch (Throwable unused) {
        }
        return true;
    }

    public static void f(id idVar) throws fq {
        if (idVar == null) {
            throw new fq("requeust is null");
        }
        if (idVar.f() == null || "".equals(idVar.f())) {
            throw new fq("request url is empty");
        }
    }

    @Deprecated
    public byte[] b(id idVar) throws fq {
        try {
            ie ieVarA = a(idVar, false);
            if (ieVarA != null) {
                return ieVarA.f2902a;
            }
            return null;
        } catch (fq e2) {
            throw e2;
        } catch (Throwable th) {
            ha.a(th, "bm", "msp");
            throw new fq(AMapException.ERROR_UNKNOWN);
        }
    }

    public static id.b c(id idVar, boolean z) {
        return idVar.r() == id.a.FIX ? z ? id.b.FIX_DEGRADE_BYERROR : id.b.FIX_DEGRADE_ONLY : z ? id.b.DEGRADE_BYERROR : id.b.DEGRADE_ONLY;
    }

    @Deprecated
    public static byte[] a(id idVar) throws fq {
        try {
            ie ieVarA = a(idVar, true);
            if (ieVarA != null) {
                return ieVarA.f2902a;
            }
            return null;
        } catch (fq e2) {
            throw e2;
        }
    }

    public static id.b b(id idVar, boolean z) {
        if (idVar.r() == id.a.FIX) {
            return id.b.FIX_NONDEGRADE;
        }
        if (idVar.r() == id.a.SINGLE) {
            return id.b.NEVER_GRADE;
        }
        return z ? id.b.FIRST_NONDEGRADE : id.b.NEVER_GRADE;
    }

    @Deprecated
    public static ie a(id idVar, boolean z) throws fq {
        byte[] bArr;
        f(idVar);
        idVar.a(z ? id.c.HTTPS : id.c.HTTP);
        ie ieVarA = null;
        long jElapsedRealtime = 0;
        boolean z2 = false;
        if (d(idVar)) {
            boolean zE = e(idVar);
            try {
                jElapsedRealtime = SystemClock.elapsedRealtime();
                ieVarA = a(idVar, b(idVar, zE), d(idVar, zE));
            } catch (fq e2) {
                if ((e2.f() == 21 && idVar.r() == id.a.INTERRUPT_IO) || !zE) {
                    throw e2;
                }
                z2 = true;
            }
        }
        return (ieVarA == null || (bArr = ieVarA.f2902a) == null || bArr.length <= 0) ? a(idVar, c(idVar, z2), a(idVar, jElapsedRealtime)) : ieVarA;
    }

    public static int d(id idVar, boolean z) {
        try {
            f(idVar);
            int iP = idVar.p();
            int i = fs.e;
            if (idVar.r() != id.a.FIX) {
                if (idVar.r() != id.a.SINGLE && iP >= i && z) {
                    return i;
                }
            }
            return iP;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    private static ie a(id idVar, id.b bVar, int i) throws fq {
        try {
            f(idVar);
            idVar.a(bVar);
            idVar.c(i);
            return new ia().b(idVar);
        } catch (fq e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new fq(AMapException.ERROR_UNKNOWN);
        }
    }

    public static int a(id idVar, long j) {
        try {
            f(idVar);
            long jElapsedRealtime = 0;
            if (j != 0) {
                jElapsedRealtime = SystemClock.elapsedRealtime() - j;
            }
            int iP = idVar.p();
            if (idVar.r() != id.a.FIX && idVar.r() != id.a.SINGLE) {
                long j2 = iP;
                if (jElapsedRealtime < j2) {
                    long j3 = j2 - jElapsedRealtime;
                    if (j3 >= 1000) {
                        return (int) j3;
                    }
                }
                return Math.min(1000, idVar.p());
            }
            return iP;
        } catch (Throwable unused) {
            return 5000;
        }
    }
}
