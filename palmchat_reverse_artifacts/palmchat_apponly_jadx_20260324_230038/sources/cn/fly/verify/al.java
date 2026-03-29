package cn.fly.verify;

import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import cn.fly.verify.fq;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f2069a;
    private static String b;
    private static String c;
    private static String d;
    private static String e;
    private static String f;
    private static String g;
    private static String h;
    private static String i;
    private static String j;
    private static int k;
    private static String l;
    private static PackageInfo m;
    private static String n;
    private static String o;

    public static String b() {
        return o;
    }

    public static int c() {
        return k;
    }

    public static String d() {
        return b;
    }

    public static String e() {
        return c;
    }

    public static String f() {
        return d;
    }

    public static String g() {
        return e;
    }

    public static String h() {
        return f;
    }

    public static String i() {
        return g;
    }

    public static String j() {
        return j;
    }

    public static String k() {
        return n;
    }

    public static String l() {
        String simOperator = null;
        try {
            simOperator = ((TelephonyManager) ax.g().getSystemService("phone")).getSimOperator();
            f.a().a("==== getCarrierImpl");
        } catch (Throwable unused) {
        }
        return TextUtils.isEmpty(simOperator) ? "-1" : simOperator;
    }

    public static String m() {
        Object objA;
        NetworkInfo activeNetworkInfo;
        try {
            if (!fq.d.b(com.kuaishou.weapon.p0.g.b) || (objA = fq.d.a("connectivity")) == null || (activeNetworkInfo = ((ConnectivityManager) objA).getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return "none";
            }
            int type = activeNetworkInfo.getType();
            return type != 0 ? type != 1 ? String.valueOf(type) : "wifi" : "cell";
        } catch (Throwable th) {
            en.a().b(th);
            return "none";
        }
    }

    public static String a() {
        if (TextUtils.isEmpty(f2069a)) {
            f2069a = as.e();
        }
        return f2069a;
    }

    public static void a(final ar arVar, final boolean z, final e eVar) {
        fq.c cVarG;
        try {
            f.a().b("[FlyVerify] ==>%s", "DH request");
            final long jUptimeMillis = SystemClock.uptimeMillis();
            if (TextUtils.isEmpty(f2069a)) {
                cVarG = (z ? fq.a(ax.g()).b(true).a(true) : fq.a(ax.g()).b(true)).g();
            } else {
                cVarG = z ? fq.a(ax.g()).b(true).a(true) : fq.a(ax.g()).b(true);
            }
            if (cVarG != null) {
                cVarG.a(new fq.a() { // from class: cn.fly.verify.al.1
                    @Override // cn.fly.verify.fq.a
                    public void a(fq.b bVar) {
                        try {
                            f.a().b("[FlyVerify] ==>%s", "DH response");
                            if (TextUtils.isEmpty(al.f2069a)) {
                                String unused = al.f2069a = bVar.g();
                            }
                            String unused2 = al.j = bVar.c(new int[0]);
                            if (z) {
                                String unused3 = al.b = bVar.b(new int[0]);
                            }
                            e eVar2 = eVar;
                            if (eVar2 != null) {
                                eVar2.a((String) null, (String) null, "dh", String.valueOf(SystemClock.uptimeMillis() - jUptimeMillis));
                            }
                            ar arVar2 = arVar;
                            if (arVar2 != null) {
                                arVar2.run();
                            }
                        } catch (Throwable th) {
                            f.a().b("[FlyVerify] ==>%s", th.getMessage());
                            ar arVar3 = arVar;
                            if (arVar3 != null) {
                                arVar3.a(th);
                            }
                        }
                    }
                });
            }
        } catch (Throwable th) {
            if ((th instanceof ClassNotFoundException) || (th instanceof NoClassDefFoundError) || (th instanceof NoSuchMethodException) || (th instanceof NoSuchMethodError)) {
                Log.e("[FlyVerify] ==>%s", "本产品进行了架构升级优化，为保证正常使用SDK，请确保相关架包升级到了最新版本，或者可至官网联系技术支持");
            }
            f.a().b("[FlyVerify] ==>%s", th.getMessage());
            if (arVar != null) {
                arVar.a(th);
            }
        }
        as.b(true);
        as.c(true);
        as.d(true);
        try {
            fq.c cVarB = fq.a(ax.g()).x().m().i().r().f().j().A().b().y().a(fq.d.c(), 128).B();
            if (TextUtils.isEmpty(o)) {
                cVarB = cVarB.e(true);
            }
            cVarB.a(new fq.a() { // from class: cn.fly.verify.al.2
                @Override // cn.fly.verify.fq.a
                public void a(fq.b bVar) {
                    try {
                        if (TextUtils.isEmpty(al.o)) {
                            String unused = al.o = bVar.L();
                        }
                        int unused2 = al.k = bVar.x();
                        String unused3 = al.c = bVar.m();
                        String unused4 = al.d = bVar.i();
                        String unused5 = al.e = bVar.r();
                        String unused6 = al.f = bVar.f();
                        String unused7 = al.g = bVar.j();
                        String unused8 = al.h = bVar.z();
                        String unused9 = al.i = bVar.b();
                        String unused10 = al.l = bVar.y();
                        PackageInfo unused11 = al.m = bVar.h(new int[0]);
                        String unused12 = al.n = bVar.A();
                    } catch (Throwable th2) {
                        f.a().b("[FlyVerify] ==>%s", th2.getMessage());
                    }
                }
            });
        } catch (Throwable th2) {
            f.a().b("[FlyVerify] ==>%s", th2.getMessage());
        }
    }
}
