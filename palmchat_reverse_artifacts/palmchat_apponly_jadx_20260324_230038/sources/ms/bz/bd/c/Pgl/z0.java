package ms.bz.bd.c.Pgl;

import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Method;
import ms.bz.bd.c.Pgl.pblz;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public final class z0 {

    /* JADX INFO: compiled from: SearchBox */
    public class pblb extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            d1.b(pblw.b().a());
            return null;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pblc extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return d1.b(pblw.b().a()).a();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pbld extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return m1.a(pblw.b().a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pble extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return l1.a(pblw.b().a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pblf extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pblg extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return "np";
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pblh extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return k1.b(pblw.b().a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pbli extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return k1.a(pblw.b().a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pblj extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return ms.bz.bd.c.Pgl.pblh.c();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pblk extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return n1.a(pblw.b().a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pbll extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            String str2;
            String str3;
            StringBuilder sb;
            String strTrim = "0";
            String strTrim2 = com.igexin.push.core.b.m;
            try {
                WifiInfo connectionInfo = ((WifiManager) pblw.b().a().getSystemService("wifi")).getConnectionInfo();
                Class<?> cls = connectionInfo.getClass();
                Method declaredMethod = cls.getDeclaredMethod(new String(pblr.a("6765744253534944")), new Class[0]);
                declaredMethod.setAccessible(true);
                str2 = (String) declaredMethod.invoke(connectionInfo, new Object[0]);
                try {
                    Method declaredMethod2 = cls.getDeclaredMethod(new String(pblr.a("67657453534944")), new Class[0]);
                    declaredMethod2.setAccessible(true);
                    str3 = (String) declaredMethod2.invoke(connectionInfo, new Object[0]);
                    try {
                        Method declaredMethod3 = cls.getDeclaredMethod(new String(pblr.a("676574497041646472657373")), new Class[0]);
                        declaredMethod3.setAccessible(true);
                        String string = Integer.toString(((Integer) declaredMethod3.invoke(connectionInfo, new Object[0])).intValue());
                        String strA = v1.a(str3);
                        String strA2 = v1.a(str2);
                        String strA3 = v1.a(string);
                        sb = new StringBuilder();
                        sb.append((strA2 == null || strA2.length() <= 0) ? com.igexin.push.core.b.m : strA2.trim());
                        sb.append("[<!>]");
                        if (strA != null && strA.length() > 0) {
                            strTrim2 = strA.trim();
                        }
                        sb.append(strTrim2);
                        sb.append("[<!>]");
                        if (strA3 != null && strA3.length() > 0) {
                            strTrim = strA3.trim();
                        }
                    } catch (Throwable unused) {
                        String strA4 = v1.a(str3);
                        String strA5 = v1.a(str2);
                        String strA6 = v1.a(null);
                        sb = new StringBuilder();
                        sb.append((strA5 == null || strA5.length() <= 0) ? com.igexin.push.core.b.m : strA5.trim());
                        sb.append("[<!>]");
                        if (strA4 != null && strA4.length() > 0) {
                            strTrim2 = strA4.trim();
                        }
                        sb.append(strTrim2);
                        sb.append("[<!>]");
                        if (strA6 != null && strA6.length() > 0) {
                            strTrim = strA6.trim();
                        }
                    }
                } catch (Throwable unused2) {
                    str3 = null;
                }
            } catch (Throwable unused3) {
                str2 = null;
                str3 = null;
            }
            sb.append(strTrim);
            sb.append("[<!>]");
            return sb.toString().trim();
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pblm extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return m1.b(pblw.b().a());
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class pgla extends pblz.pgla {
        @Override // ms.bz.bd.c.Pgl.pblz.pgla
        public final Object b(long j, String str, Object obj) throws Throwable {
            return null;
        }
    }

    public static void a() {
        pblz.b(268435457, new pble());
        pblz.b(268435458, new pblf());
        pblz.b(268435459, new pblg());
        pblz.b(268435460, new pblh());
        pblz.b(268435461, new pbli());
        pblz.b(268435462, new pblj());
        pblz.b(268435463, new pblk());
        pblz.b(268435464, new pbll());
        pblz.b(268435465, new pblm());
        pblz.b(268435466, new pgla());
        pblz.b(268435467, new pblb());
        pblz.b(268435468, new pblc());
        pblz.b(268435469, new pbld());
    }
}
