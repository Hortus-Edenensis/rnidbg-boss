package cn.fly.verify;

import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes.dex */
public class fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ThreadLocal<Boolean> f2347a = new ThreadLocal<>();
    public static ThreadLocal<Boolean> b = new ThreadLocal<>();
    public static ThreadLocal<Boolean> c = new ThreadLocal<>();
    private static volatile String e = null;
    private static final List<String> d = Arrays.asList("bgmdl", "gmnft", "gbrd", "govsit", "govsnm", "golgu", "gocnty", "galgu", "gtmne", "gsnmd", "gpgnm", "gpnmmt", "gpvsnm", "gpvsme", "cinmnps", "ckpmsi", "gaplcn", "gpgif", "gpgiffist", "gcrtpcnm", "gscpt", "cird", "cknavbl", "ipgist", "ckua", "ubenbl", "dvenbl", "vnmt", "iwpxy", "cx", "degb", "gdtlnktpfs", "gpgiffcin", "gpgifstrg", "gtaif", "gtaifprm", "rsaciy", "gsnmdfp", "gcrie", "gcriefce", "gdvk", "gdvkfc", "godhm", "godm", "gmpfis");

    private static ep a() {
        return es.c() ? er.a(ax.g()).e() : er.a(ax.g()).c();
    }

    private static Object b(String str, ArrayList<Object> arrayList) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ep epVarA = a(str);
        if ("gmpfis".equals(str)) {
            if (arrayList != null && arrayList.size() == 4) {
                return epVarA.b(((Boolean) arrayList.get(0)).booleanValue(), ((Integer) arrayList.get(1)).intValue(), (String) arrayList.get(2), ((Integer) arrayList.get(3)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("cird".equals(str)) {
            return Boolean.valueOf(epVarA.a());
        }
        if ("cx".equals(str)) {
            return Boolean.valueOf(epVarA.b());
        }
        if ("ckpd".equals(str)) {
            return Boolean.valueOf(epVarA.c());
        }
        if ("degb".equals(str)) {
            return Boolean.valueOf(epVarA.d());
        }
        if ("vnmt".equals(str)) {
            return Boolean.valueOf(epVarA.e());
        }
        if ("ckua".equals(str)) {
            return Boolean.valueOf(epVarA.f());
        }
        if ("dvenbl".equals(str)) {
            return Boolean.valueOf(epVarA.g());
        }
        if ("ubenbl".equals(str)) {
            return Boolean.valueOf(epVarA.h());
        }
        if ("iwpxy".equals(str)) {
            return Boolean.valueOf(epVarA.i());
        }
        if ("gavti".equals(str)) {
            return epVarA.j();
        }
        if ("gsimt".equals(str)) {
            return epVarA.a(false);
        }
        if ("gsimtfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.a(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gbsi".equals(str)) {
            return epVarA.b(false);
        }
        if ("gbsifce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.b(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gcrie".equals(str)) {
            return epVarA.c(false);
        }
        if ("gcriefce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.c(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gcrnmfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.d(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gcrnm".equals(str)) {
            return epVarA.d(false);
        }
        if ("gmivsn".equals(str)) {
            return epVarA.k();
        }
        if ("bgmdl".equals(str)) {
            return epVarA.l();
        }
        if ("gmnft".equals(str)) {
            return epVarA.m();
        }
        if ("gbrd".equals(str)) {
            return epVarA.n();
        }
        if ("gdvtp".equals(str)) {
            return epVarA.o();
        }
        if ("gtecloc".equals(str)) {
            return epVarA.p();
        }
        if ("gnbclin".equals(str)) {
            return epVarA.q();
        }
        if ("wmcwi".equals(str)) {
            return epVarA.e(false);
        }
        if ("wmcwifce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.e(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("govsit".equals(str)) {
            return Integer.valueOf(epVarA.s());
        }
        if ("govsnm".equals(str)) {
            return epVarA.t();
        }
        if ("golgu".equals(str)) {
            return epVarA.u();
        }
        if ("gocnty".equals(str)) {
            return epVarA.v();
        }
        if ("gcuin".equals(str)) {
            return epVarA.w();
        }
        if ("gtydvin".equals(str)) {
            return epVarA.x();
        }
        if ("gqmkn".equals(str)) {
            return epVarA.y();
        }
        if ("gszin".equals(str)) {
            return epVarA.z();
        }
        if ("gmrin".equals(str)) {
            return epVarA.A();
        }
        if ("galgu".equals(str)) {
            return epVarA.B();
        }
        if ("gscsz".equals(str)) {
            return epVarA.C();
        }
        if ("gneyp".equals(str)) {
            return epVarA.f(false);
        }
        if ("gneypnw".equals(str)) {
            return epVarA.D();
        }
        if ("gneypfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.f(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gnktpfs".equals(str)) {
            return epVarA.E();
        }
        if ("gdtlnktpfs".equals(str)) {
            return epVarA.F();
        }
        if ("cknavbl".equals(str)) {
            return Boolean.valueOf(epVarA.G());
        }
        if ("gdntp".equals(str)) {
            return Integer.valueOf(epVarA.H());
        }
        if ("gtmne".equals(str)) {
            return epVarA.I();
        }
        if ("gflv".equals(str)) {
            return epVarA.J();
        }
        if ("gbsbd".equals(str)) {
            return epVarA.K();
        }
        if ("gbfspy".equals(str)) {
            return epVarA.L();
        }
        if ("gbplfo".equals(str)) {
            return epVarA.M();
        }
        if ("giads".equals(str)) {
            return epVarA.N();
        }
        if ("gia".equals(str)) {
            if (!by.a(ec.b("003cff")) || bv.a().i() == 42) {
                return new ArrayList();
            }
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.a(((Boolean) arrayList.get(0)).booleanValue(), false);
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("giafce".equals(str)) {
            if (!by.a(ec.b("003cff")) || bv.a().i() == 42) {
                return new ArrayList();
            }
            if (arrayList != null && arrayList.size() == 2) {
                return epVarA.a(((Boolean) arrayList.get(0)).booleanValue(), ((Boolean) arrayList.get(1)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gal".equals(str)) {
            return (!by.a(ec.b("003cff")) || bv.a().i() == 42) ? new ArrayList() : epVarA.O();
        }
        if ("gsl".equals(str)) {
            return (!by.a(ec.b("003cff")) || bv.a().i() == 42) ? new ArrayList() : epVarA.P();
        }
        if ("glctn".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return epVarA.a(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Boolean) arrayList.get(2)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gstmpts".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.a((String) arrayList.get(0));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gdvk".equals(str)) {
            return epVarA.Q();
        }
        if ("gdvkfc".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.g(((Boolean) arrayList.get(0)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("ipgist".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return Boolean.valueOf(epVarA.b((String) arrayList.get(0)));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gscpt".equals(str)) {
            return epVarA.R();
        }
        if ("gsnmd".equals(str)) {
            return epVarA.S();
        }
        if ("gsnmdfp".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.c((String) arrayList.get(0));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgnm".equals(str)) {
            return epVarA.T();
        }
        if ("gpnmmt".equals(str)) {
            return epVarA.U();
        }
        if ("gpnmfp".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return epVarA.d((String) arrayList.get(0));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpvsnm".equals(str)) {
            return Integer.valueOf(epVarA.V());
        }
        if ("gpvsme".equals(str)) {
            return epVarA.W();
        }
        if ("cinmnps".equals(str)) {
            return Boolean.valueOf(epVarA.X());
        }
        if ("gcrtpcnm".equals(str)) {
            return epVarA.Y();
        }
        if ("ciafgd".equals(str)) {
            return Boolean.valueOf(epVarA.Z());
        }
        if ("ckpmsi".equals(str)) {
            if (arrayList != null && arrayList.size() == 1) {
                return Boolean.valueOf(epVarA.e((String) arrayList.get(0)));
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gaplcn".equals(str)) {
            return epVarA.aa();
        }
        if ("qritsvc".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return epVarA.a((Intent) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("rsaciy".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return epVarA.b((Intent) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgif".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return epVarA.a(false, 0, (String) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgiffcin".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return epVarA.a(((Boolean) arrayList.get(0)).booleanValue(), 0, (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgifstrg".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return epVarA.a(false, ((Integer) arrayList.get(0)).intValue(), (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gpgiffist".equals(str)) {
            if (arrayList != null && arrayList.size() == 4) {
                return epVarA.a(((Boolean) arrayList.get(0)).booleanValue(), ((Integer) arrayList.get(1)).intValue(), (String) arrayList.get(2), ((Integer) arrayList.get(3)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gdvda".equals(str)) {
            return epVarA.ab();
        }
        if ("gdvdtnas".equals(str)) {
            return epVarA.ac();
        }
        if ("galtut".equals(str)) {
            return Long.valueOf(epVarA.ad());
        }
        if ("gcrup".equals(str)) {
            return epVarA.af();
        }
        if ("gcifm".equals(str)) {
            return epVarA.ag();
        }
        if ("godm".equals(str)) {
            String strAh = epVarA.ah();
            if (TextUtils.isEmpty(e)) {
                e = bv.a().b("key_ched_od", (String) null);
            }
            if (TextUtils.isEmpty(strAh) || az.a().b().a()) {
                return TextUtils.isEmpty(e) ? strAh : e;
            }
            if (TextUtils.equals(e, strAh)) {
                return strAh;
            }
            e = strAh;
            bv.a().a("key_ched_od", strAh);
            return strAh;
        }
        if ("godhm".equals(str)) {
            return epVarA.ai();
        }
        if ("galdm".equals(str)) {
            return epVarA.aj();
        }
        if ("gtaif".equals(str)) {
            return epVarA.ak();
        }
        if ("gtaifok".equals(str)) {
            return epVarA.al();
        }
        if ("gtaifprm".equals(str)) {
            if (arrayList != null && arrayList.size() == 2) {
                return epVarA.a((String) arrayList.get(0), ((Integer) arrayList.get(1)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gtaifprmfce".equals(str)) {
            if (arrayList != null && arrayList.size() == 3) {
                return epVarA.a(((Boolean) arrayList.get(0)).booleanValue(), (String) arrayList.get(1), ((Integer) arrayList.get(2)).intValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if ("gtbdt".equals(str)) {
            return Long.valueOf(epVarA.am());
        }
        if ("gtscnin".equals(str)) {
            return Double.valueOf(epVarA.an());
        }
        if ("gtscnppi".equals(str)) {
            return Integer.valueOf(epVarA.ao());
        }
        if ("ishmos".equals(str)) {
            return Boolean.valueOf(epVarA.ap());
        }
        if ("gthmosv".equals(str)) {
            return epVarA.aq();
        }
        if ("gthmosdtlv".equals(str)) {
            return epVarA.ar();
        }
        if ("gthmpmst".equals(str)) {
            return Integer.valueOf(epVarA.as());
        }
        if ("gthmepmst".equals(str)) {
            return Integer.valueOf(epVarA.at());
        }
        if ("gtinnerlangmt".equals(str)) {
            return epVarA.au();
        }
        if ("gtgramgendt".equals(str)) {
            return Integer.valueOf(epVarA.av());
        }
        if ("ctedebbing".equals(str)) {
            return Boolean.valueOf(epVarA.aw());
        }
        if ("gtelcmefce".equals(str)) {
            if (arrayList != null && arrayList.size() == 4) {
                return epVarA.a(((Integer) arrayList.get(0)).intValue(), ((Integer) arrayList.get(1)).intValue(), ((Boolean) arrayList.get(2)).booleanValue(), ((Boolean) arrayList.get(3)).booleanValue());
            }
            throw new Throwable("array illegal: " + arrayList);
        }
        if (!"gtdm".equals(str)) {
            en.a().a("Not found: " + str, new Object[0]);
            return null;
        }
        if (arrayList != null && arrayList.size() == 1) {
            return epVarA.h(((Boolean) arrayList.get(0)).booleanValue());
        }
        throw new Throwable("array illegal: " + arrayList);
    }

    private static ep a(String str) {
        CountDownLatch countDownLatchD;
        CountDownLatch countDownLatchD2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            en.a().b("WARNING: Call in main: key = " + str);
            b();
        }
        try {
            if (f2347a.get() == null ? false : f2347a.get().booleanValue()) {
                boolean zBooleanValue = b.get() == null ? false : b.get().booleanValue();
                boolean zBooleanValue2 = c.get() == null ? false : c.get().booleanValue();
                if (zBooleanValue) {
                    en.a().a("isGCFThread true", new Object[0]);
                }
                if (!zBooleanValue && !zBooleanValue2 && !es.c() && (countDownLatchD = es.a(ax.g()).d()) != null) {
                    en.a().a("dhs_ivkr_new k: " + str + ", cdl: " + countDownLatchD, new Object[0]);
                    countDownLatchD.await(3500L, TimeUnit.MILLISECONDS);
                }
            } else if (!d.contains(str) && !es.c() && (countDownLatchD2 = es.a(ax.g()).d()) != null) {
                en.a().a("dhs_ivkr k: " + str + ", cdl: " + countDownLatchD2, new Object[0]);
                countDownLatchD2.await(3500L, TimeUnit.MILLISECONDS);
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
        return a();
    }

    private static void b() {
        try {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            if (stackTrace != null) {
                String str = "";
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if (stackTraceElement != null) {
                        str = str + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + "(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ")\n";
                    }
                }
                en.a().a(str, new Object[0]);
            }
        } catch (Throwable th) {
            en.a().a(th);
        }
    }

    @fc
    public static Object a(String str, ArrayList<Object> arrayList) {
        try {
            return b(str, arrayList);
        } catch (Throwable th) {
            en.a().a(th);
            return null;
        }
    }
}
