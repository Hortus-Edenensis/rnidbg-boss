package com.beizi.ad.internal.e;

import android.content.Context;
import android.os.Build;
import android.system.Os;
import android.system.StructStat;
import android.system.StructTimespec;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.beizi.ad.model.f;
import com.beizi.fusion.model.DevInfo;
import com.beizi.fusion.model.RequestInfo;
import com.beizi.fusion.tool.ac;
import com.wifi.adsdk.utils.BLPlatform;
import com.wifi.adsdk.utils.LxAdOSUtils;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class a {
    private static a J = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f4407a = "SDK_UID_KEY";
    public static String b = "SDK_UID_KEY_NEW";
    private String A;
    private String B;
    private String C;
    private long D;
    private long E;
    private String F;
    private Context G;
    private String H;
    private String I;
    private RequestInfo K;
    private DevInfo L;
    private String e;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private boolean n;
    private String o;
    private String p;
    private boolean q;
    private boolean r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;
    private String d = null;
    public boolean c = false;
    private f.b f = f.b.DEVICE_OTHER;
    private String g = null;
    private String h = null;

    private a() {
        Context contextE = com.beizi.fusion.c.b.a().e();
        this.G = contextE;
        if (contextE == null) {
            return;
        }
        RequestInfo requestInfo = RequestInfo.getInstance(contextE);
        this.K = requestInfo;
        if (requestInfo == null) {
            return;
        }
        if (!requestInfo.isInit) {
            requestInfo.init();
        }
        this.L = this.K.getDevInfo();
    }

    private void F() {
        try {
            WindowManager windowManager = (WindowManager) com.beizi.ad.internal.c.a().j.getSystemService("window");
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            this.g = displayMetrics.widthPixels + "_" + displayMetrics.heightPixels;
            float f = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
            float f2 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
            double dSqrt = Math.sqrt((double) ((f2 * f2) + (f * f)));
            this.h = String.format("%.2f", Double.valueOf(Math.round(dSqrt * r2) / Math.pow(10.0d, 2.0d)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean G() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    private String H() {
        try {
            int i = Build.VERSION.SDK_INT;
            StructStat structStatStat = Os.stat("/data/data");
            if (structStatStat == null) {
                return "";
            }
            if (i < 27) {
                return structStatStat.st_atime + ".0";
            }
            StructTimespec structTimespec = structStatStat.st_atim;
            return structTimespec.tv_sec + "." + structTimespec.tv_nsec;
        } catch (Throwable unused) {
            return "";
        }
    }

    private boolean I() {
        return Build.MANUFACTURER.equalsIgnoreCase(LxAdOSUtils.ROM_VIVO) || Build.BRAND.equalsIgnoreCase(LxAdOSUtils.ROM_VIVO);
    }

    private boolean J() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("OPPO")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("OPPO") && !str.equalsIgnoreCase("REALME")) {
                return false;
            }
        }
        return true;
    }

    private boolean K() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("XIAOMI") && !str.equalsIgnoreCase("REDMI")) {
                return false;
            }
        }
        return true;
    }

    public static synchronized a a() {
        if (J == null) {
            synchronized (a.class) {
                if (J == null) {
                    J = new a();
                }
            }
        }
        return J;
    }

    public long A() {
        RequestInfo requestInfo;
        if (this.D == 0 && (requestInfo = this.K) != null) {
            try {
                this.D = Long.parseLong(requestInfo.getInstallTime());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return this.D;
    }

    public long B() {
        RequestInfo requestInfo;
        if (this.E == 0 && (requestInfo = this.K) != null) {
            try {
                this.E = Long.parseLong(requestInfo.getUpdateTime());
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return this.E;
    }

    public String C() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.F) && (requestInfo = this.K) != null) {
            this.F = requestInfo.getPackageName();
        }
        return this.F;
    }

    public String D() {
        if (TextUtils.isEmpty(this.H)) {
            try {
                if (com.beizi.fusion.c.b.a().p()) {
                    this.H = com.beizi.ad.lance.a.q.k(com.beizi.fusion.c.b.a().e());
                } else {
                    this.H = com.beizi.fusion.c.b.a().q();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return this.H;
    }

    public String E() {
        try {
            if (TextUtils.isEmpty(this.I)) {
                if (I()) {
                    this.I = com.beizi.ad.lance.a.q.b(com.beizi.ad.internal.c.a().j, BLPlatform.VIVO_APPSTORE_PN);
                } else if (J()) {
                    this.I = com.beizi.ad.lance.a.q.b(com.beizi.ad.internal.c.a().j, "com.heytap.market");
                } else if (K()) {
                    this.I = com.beizi.ad.lance.a.q.b(com.beizi.ad.internal.c.a().j, "com.xiaomi.market");
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return this.I;
    }

    public String b() {
        if (TextUtils.isEmpty(this.j)) {
            this.j = H();
        }
        return this.j;
    }

    public String c() {
        if (TextUtils.isEmpty(this.p)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.p = devInfo.getRomVersion();
            } else {
                try {
                    ac acVarA = ac.a();
                    acVarA.b();
                    this.p = acVarA.c();
                } catch (Throwable unused) {
                }
            }
        }
        return this.p;
    }

    public String d() {
        if (TextUtils.isEmpty(this.d)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.d = devInfo.getSdkUID();
            } else {
                this.d = (String) l.b(com.beizi.ad.internal.c.a().j, b, "");
            }
        }
        return this.d;
    }

    public String e() {
        if (TextUtils.isEmpty(this.i)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.i = devInfo.getDensity();
            } else {
                try {
                    if (TextUtils.isEmpty(this.i)) {
                        this.i = com.beizi.ad.internal.c.a().j.getResources().getDisplayMetrics().density + "";
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this.i;
    }

    public String f() {
        if (TextUtils.isEmpty(this.e)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.e = devInfo.getRoot();
            } else {
                this.e = com.beizi.ad.lance.a.q.a();
            }
        }
        return this.e;
    }

    public String g() {
        if (TextUtils.isEmpty(this.g)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.g = devInfo.getResolution();
            } else {
                F();
            }
        }
        return this.g;
    }

    public String h() {
        if (TextUtils.isEmpty(this.h)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.h = devInfo.getScreenSize();
            } else {
                F();
            }
        }
        return this.h;
    }

    public String i() {
        if (TextUtils.isEmpty(this.k)) {
            com.beizi.ad.lance.a.q.j(com.beizi.ad.internal.c.a().j);
        }
        return this.k;
    }

    public String j() {
        if (TextUtils.isEmpty(this.l)) {
            this.l = com.beizi.ad.lance.a.q.b();
        }
        return this.l;
    }

    public String k() {
        if (G() && TextUtils.isEmpty(this.m)) {
            this.m = com.beizi.ad.lance.a.q.b(com.beizi.ad.internal.c.a().j);
        }
        return this.m;
    }

    public String l() {
        if (G() && TextUtils.isEmpty(this.o)) {
            this.o = com.beizi.ad.lance.a.q.a(com.beizi.ad.internal.c.a().j, "com.huawei.hwid");
        }
        return this.o;
    }

    public boolean m() {
        if (!this.n) {
            this.n = com.beizi.ad.lance.a.h.a(com.beizi.ad.internal.c.a().j, "com.tencent.mm");
        }
        return this.n;
    }

    public f.b n() {
        f.b bVar = this.f;
        f.b bVar2 = f.b.DEVICE_OTHER;
        if (bVar == bVar2) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                String devType = devInfo.getDevType();
                if ("1".equals(devType)) {
                    this.f = f.b.DEVICE_PHONE;
                } else if ("2".equals(devType)) {
                    this.f = f.b.DEVICE_FLAT;
                }
            } else if (bVar == bVar2) {
                try {
                    try {
                        if (((TelephonyManager) com.beizi.ad.internal.c.a().j.getSystemService("phone")).getPhoneType() != 0) {
                            this.f = f.b.DEVICE_PHONE;
                        } else {
                            this.f = f.b.DEVICE_FLAT;
                        }
                    } catch (Throwable unused) {
                        int i = com.beizi.ad.internal.c.a().j.getResources().getConfiguration().screenLayout & 15;
                        if (i == 4 || i == 3) {
                            this.f = f.b.DEVICE_FLAT;
                        } else {
                            this.f = f.b.DEVICE_PHONE;
                        }
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        return this.f;
    }

    public String o() {
        if (this.q) {
            return this.s;
        }
        this.q = true;
        String strD = com.beizi.ad.lance.a.r.d();
        this.s = strD;
        return strD;
    }

    public String p() {
        if (this.r) {
            return this.t;
        }
        this.r = true;
        String strC = com.beizi.ad.lance.a.r.c();
        this.t = strC;
        return strC;
    }

    public String q() {
        return com.beizi.ad.lance.a.r.b();
    }

    public String r() {
        if (TextUtils.isEmpty(this.u)) {
            this.u = Build.VERSION.SDK_INT + " (" + Build.VERSION.RELEASE + ")";
        }
        return this.u;
    }

    public String s() {
        if (TextUtils.isEmpty(this.v)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.v = devInfo.getBrand();
            } else {
                this.v = Build.BRAND;
            }
        }
        return this.v;
    }

    public String t() {
        if (TextUtils.isEmpty(this.w)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.w = devInfo.getModel();
            } else {
                this.w = Build.MODEL;
            }
        }
        return this.w;
    }

    public String u() {
        if (TextUtils.isEmpty(this.x)) {
            this.x = com.beizi.fusion.tool.p.d();
        }
        return this.x;
    }

    public String v() {
        if (TextUtils.isEmpty(this.y)) {
            DevInfo devInfo = this.L;
            if (devInfo != null) {
                this.y = devInfo.getLanguage();
            } else {
                this.y = Locale.getDefault().getLanguage();
            }
        }
        return this.y;
    }

    public String w() {
        if (TextUtils.isEmpty(this.z)) {
            this.z = com.beizi.ad.lance.a.n.a(this.G);
        }
        return this.z;
    }

    public String x() {
        if (TextUtils.isEmpty(this.A)) {
            this.A = com.beizi.ad.lance.a.n.b(this.G);
        }
        return this.A;
    }

    public String y() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.B) && (requestInfo = this.K) != null) {
            this.B = requestInfo.getAppVersion();
        }
        return this.B;
    }

    public String z() {
        RequestInfo requestInfo;
        if (TextUtils.isEmpty(this.C) && (requestInfo = this.K) != null) {
            this.C = requestInfo.getSdkVersion();
        }
        return this.C;
    }
}
