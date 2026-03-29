package com.amap.api.col.p0002sl;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kuaishou.weapon.p0.g;
import java.util.ArrayList;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@SuppressLint({"NewApi"})
public final class lc {
    static int A = -1;
    private static boolean K = false;
    boolean F;
    private Handler N;
    private lo O;
    private String P;
    private ld R;
    public static String[] D = {g.h, g.g};
    public static String E = "android.permission.ACCESS_BACKGROUND_LOCATION";
    private static volatile boolean Q = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Context f2955a = null;
    ConnectivityManager b = null;
    ls c = null;
    lm d = null;
    lu e = null;
    mb f = null;
    ArrayList<kr> g = new ArrayList<>();
    a h = null;
    AMapLocationClientOption i = new AMapLocationClientOption();
    lh j = null;
    long k = 0;
    private int I = 0;
    mc l = null;
    boolean m = false;
    private String J = null;
    lz n = null;
    StringBuilder o = new StringBuilder();
    boolean p = true;
    boolean q = true;
    AMapLocationClientOption.GeoLanguage r = AMapLocationClientOption.GeoLanguage.DEFAULT;
    boolean s = true;
    boolean t = false;
    private String L = null;
    StringBuilder u = null;
    boolean v = false;
    public boolean w = false;
    int x = 12;
    private boolean M = true;
    lj y = null;
    boolean z = false;
    lg B = null;
    String C = null;
    IntentFilter G = null;
    LocationManager H = null;

    /* JADX INFO: renamed from: com.amap.api.col.2sl.lc$1, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2956a;

        static {
            int[] iArr = new int[AMapLocationClientOption.GeoLanguage.values().length];
            f2956a = iArr;
            try {
                iArr[AMapLocationClientOption.GeoLanguage.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2956a[AMapLocationClientOption.GeoLanguage.ZH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2956a[AMapLocationClientOption.GeoLanguage.EN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            ls lsVar;
            ls lsVar2;
            if (context == null || intent == null) {
                return;
            }
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                    ls lsVar3 = lc.this.c;
                    if (lsVar3 != null) {
                        lsVar3.j();
                    }
                    try {
                        if (intent.getExtras() == null || !intent.getExtras().getBoolean("resultsUpdated", true) || (lsVar2 = lc.this.c) == null) {
                            return;
                        }
                        lsVar2.i();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                    ls lsVar4 = lc.this.c;
                    if (lsVar4 != null) {
                        lsVar4.k();
                        return;
                    }
                    return;
                }
                if (!action.equals("android.net.wifi.STATE_CHANGE") || (lsVar = lc.this.c) == null) {
                    return;
                }
                lsVar.h();
            } catch (Throwable th) {
                me.a(th, "Aps", "onReceive");
            }
        }
    }

    public lc(boolean z) {
        this.F = z;
    }

    private void i() {
        if (this.n != null) {
            try {
                if (this.i == null) {
                    this.i = new AMapLocationClientOption();
                }
                this.n.a(this.i.getHttpTimeOut(), this.i.getLocationProtocol().equals(AMapLocationClientOption.AMapLocationProtocol.HTTPS), j());
            } catch (Throwable unused) {
            }
        }
    }

    private int j() {
        int i;
        if (this.i.getGeoLanguage() == null || (i = AnonymousClass1.f2956a[this.i.getGeoLanguage().ordinal()]) == 1) {
            return 0;
        }
        if (i != 2) {
            return i != 3 ? 0 : 2;
        }
        return 1;
    }

    private void k() {
        boolean zIsNeedAddress;
        boolean z;
        boolean zIsOffset;
        boolean zIsLocationCacheEnable;
        AMapLocationClientOption.GeoLanguage geoLanguage = AMapLocationClientOption.GeoLanguage.DEFAULT;
        boolean z2 = true;
        try {
            geoLanguage = this.i.getGeoLanguage();
            zIsNeedAddress = this.i.isNeedAddress();
            try {
                zIsOffset = this.i.isOffset();
                try {
                    zIsLocationCacheEnable = this.i.isLocationCacheEnable();
                } catch (Throwable unused) {
                    z2 = zIsOffset;
                    z = true;
                    boolean z3 = z;
                    zIsOffset = z2;
                    zIsLocationCacheEnable = z3;
                    this.q = zIsOffset;
                    this.p = zIsNeedAddress;
                    this.s = zIsLocationCacheEnable;
                    this.r = geoLanguage;
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable unused3) {
            zIsNeedAddress = true;
        }
        try {
            this.t = this.i.isOnceLocationLatest();
            this.z = this.i.isSensorEnable();
            if (zIsOffset != this.q || zIsNeedAddress != this.p || zIsLocationCacheEnable != this.s || geoLanguage != this.r) {
                s();
            }
        } catch (Throwable unused4) {
            z = zIsLocationCacheEnable;
            z2 = zIsOffset;
            boolean z32 = z;
            zIsOffset = z2;
            zIsLocationCacheEnable = z32;
        }
        this.q = zIsOffset;
        this.p = zIsNeedAddress;
        this.s = zIsLocationCacheEnable;
        this.r = geoLanguage;
    }

    private void l() {
        a aVar;
        try {
            Context context = this.f2955a;
            if (context != null && (aVar = this.h) != null) {
                context.unregisterReceiver(aVar);
            }
        } finally {
            try {
            } finally {
            }
        }
        lm lmVar = this.d;
        if (lmVar != null) {
            lmVar.a(this.F);
        }
        ls lsVar = this.c;
        if (lsVar != null) {
            lsVar.c(this.F);
        }
    }

    private void m() {
        try {
            if (this.h == null) {
                this.h = new a();
            }
            if (this.G == null) {
                IntentFilter intentFilter = new IntentFilter();
                this.G = intentFilter;
                intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
                this.G.addAction("android.net.wifi.SCAN_RESULTS");
                this.G.addAction("android.net.wifi.STATE_CHANGE");
            }
            this.f2955a.registerReceiver(this.h, this.G);
        } catch (Throwable th) {
            me.a(th, "Aps", "initBroadcastListener");
        }
    }

    private byte[] n() throws Throwable {
        if (this.l == null) {
            this.l = new mc();
        }
        if (this.i == null) {
            this.i = new AMapLocationClientOption();
        }
        if (this.d != null && this.c != null) {
            this.l.a(this.f2955a, this.i.isNeedAddress(), this.i.isOffset(), this.d, this.c, this.b, this.C, this.O);
        }
        return this.l.a();
    }

    private boolean o() {
        return this.k == 0 || mm.b() - this.k > 20000;
    }

    private void p() {
        ls lsVar = this.c;
        if (lsVar == null) {
            return;
        }
        lsVar.a(this.m);
    }

    private boolean q() {
        ls lsVar = this.c;
        if (lsVar != null) {
            this.g = lsVar.e();
        }
        ArrayList<kr> arrayList = this.g;
        return arrayList == null || arrayList.size() <= 0;
    }

    private void r() {
        if (this.L != null) {
            this.L = null;
        }
        StringBuilder sb = this.u;
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    private void s() {
        try {
            lu luVar = this.e;
            if (luVar != null) {
                luVar.a();
            }
            d(null);
            this.M = false;
            lg lgVar = this.B;
            if (lgVar != null) {
                lgVar.a();
            }
        } catch (Throwable th) {
            me.a(th, "Aps", "cleanCache");
        }
    }

    public final void a(Handler handler) {
        this.N = handler;
    }

    public final void b() {
        this.n = lz.a(this.f2955a);
        i();
        if (this.b == null) {
            this.b = (ConnectivityManager) mm.a(this.f2955a, "connectivity");
        }
        if (this.l == null) {
            this.l = new mc();
        }
    }

    public final void c() {
        if (this.y == null) {
            this.y = new lj(this.f2955a);
        }
        m();
        ls lsVar = this.c;
        if (lsVar != null) {
            lsVar.b(false);
            this.g = this.c.e();
        }
        lm lmVar = this.d;
        if (lmVar != null) {
            lmVar.a(false, q());
        }
        this.e.a(this.f2955a);
        b(this.f2955a);
        this.w = true;
    }

    public final void d() {
        if (this.o.length() > 0) {
            StringBuilder sb = this.o;
            sb.delete(0, sb.length());
        }
    }

    @SuppressLint({"NewApi"})
    public final void e() {
        this.C = null;
        this.v = false;
        this.w = false;
        lu luVar = this.e;
        if (luVar != null) {
            luVar.b(this.f2955a);
        }
        lg lgVar = this.B;
        if (lgVar != null) {
            lgVar.a();
        }
        if (this.f != null) {
            this.f = null;
        }
        lo loVar = this.O;
        if (loVar != null) {
            loVar.a(this.F);
        }
        l();
        ArrayList<kr> arrayList = this.g;
        if (arrayList != null) {
            arrayList.clear();
        }
        lj ljVar = this.y;
        if (ljVar != null) {
            ljVar.f();
        }
        this.j = null;
        this.f2955a = null;
        this.u = null;
        this.H = null;
    }

    public final void f() {
        ld ldVar = this.R;
        if (ldVar != null) {
            ldVar.d();
        }
    }

    public final void g() {
        ls lsVar;
        try {
            if (this.f2955a == null) {
                return;
            }
            if (this.R == null) {
                this.R = new ld(this.f2955a);
            }
            lm lmVar = this.d;
            if (lmVar == null || (lsVar = this.c) == null) {
                return;
            }
            this.R.a(lmVar, lsVar, this.N);
        } catch (Throwable th) {
            hd.c(th, "as", "stc");
        }
    }

    public final void h() {
        ld ldVar = this.R;
        if (ldVar != null) {
            ldVar.a();
        }
    }

    public final void a(Context context) {
        try {
            if (this.f2955a != null) {
                return;
            }
            this.B = new lg();
            Context applicationContext = context.getApplicationContext();
            this.f2955a = applicationContext;
            mm.b(applicationContext);
            if (this.c == null) {
                this.c = new ls(this.f2955a, (WifiManager) mm.a(this.f2955a, "wifi"), this.N);
            }
            if (this.d == null) {
                this.d = new lm(this.f2955a, this.N);
            }
            this.O = new lo(context, this.N);
            if (this.e == null) {
                this.e = new lu();
            }
            if (this.f == null) {
                this.f = new mb();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            me.a(th, "Aps", "initBase");
        }
    }

    private void d(lh lhVar) {
        if (lhVar != null) {
            this.j = lhVar;
        }
    }

    @SuppressLint({"NewApi"})
    private lh b(boolean z, lb lbVar) {
        String str;
        try {
            if (TextUtils.isEmpty(this.P)) {
                this.P = ge.b(fv.a(this.f2955a) + "," + fv.f(this.f2955a));
            }
            StringBuilder sb = this.o;
            sb.append("#id:");
            sb.append(this.P);
        } catch (Throwable unused) {
        }
        lh lhVar = new lh("");
        try {
            byte[] bArrN = n();
            long jB = mm.b();
            this.k = jB;
            lbVar.a(jB);
            try {
                me.c(this.f2955a);
                ma maVarA = this.n.a(this.f2955a, bArrN, me.a(), me.b(), z);
                maVarA.f();
                String strB_ = maVarA.b_();
                fs.a(this.f2955a);
                boolean z2 = !TextUtils.isEmpty(strB_) && strB_.contains("dualstack");
                int i = lx.f2983a;
                if (fs.a() && fs.c() && z2) {
                    i = lx.b;
                }
                String strA = fs.b() ? null : lx.a(this.f2955a).a(maVarA, i);
                lbVar.a(i == lx.b ? "v6" : "v4");
                ie ieVarA = this.n.a(maVarA);
                long jB2 = mm.b();
                if (!TextUtils.isEmpty(strA)) {
                    if (!ieVarA.f) {
                        lx.a(this.f2955a).a(true, i);
                    } else {
                        lx.a(this.f2955a).a(false, i);
                        lx.a(this.f2955a).a(i);
                    }
                }
                if (ieVarA != null && !TextUtils.isEmpty(strA)) {
                    if (!ieVarA.f) {
                        lbVar.b(strA);
                        lbVar.c("SUCCESS");
                    } else {
                        lbVar.b(strA);
                        lbVar.c("FAIL");
                        lbVar.d("SUCCESS");
                    }
                } else {
                    lbVar.d("SUCCESS");
                }
                ld ldVar = this.R;
                if (ldVar != null) {
                    ldVar.d();
                }
                lbVar.b(jB2);
                if (ieVarA != null) {
                    if (!TextUtils.isEmpty(ieVarA.c)) {
                        this.o.append("#csid:" + ieVarA.c);
                    }
                    str = ieVarA.d;
                    lhVar.h(this.u.toString());
                } else {
                    str = "";
                }
                lh lhVarA = a(lhVar, ieVarA, lbVar);
                if (lhVarA != null) {
                    return lhVarA;
                }
                byte[] bArrB = lt.b(ieVarA.f2902a);
                if (bArrB == null) {
                    lhVar.setErrorCode(5);
                    lbVar.f("#0503");
                    this.o.append("解密数据失败#0503");
                    lhVar.setLocationDetail(this.o.toString());
                    mk.a(str, 2053);
                    return lhVar;
                }
                lh lhVarA2 = this.f.a(lhVar, bArrB, lbVar);
                if (!mm.a(lhVarA2)) {
                    String strB = lhVarA2.b();
                    this.J = strB;
                    if (!TextUtils.isEmpty(strB)) {
                        mk.a(str, 2062);
                    } else {
                        mk.a(str, 2061);
                    }
                    lhVarA2.setErrorCode(6);
                    lbVar.f("#0601");
                    StringBuilder sb2 = this.o;
                    StringBuilder sb3 = new StringBuilder("location faile retype:");
                    sb3.append(lhVarA2.d());
                    sb3.append(" rdesc:");
                    sb3.append(TextUtils.isEmpty(this.J) ? "" : this.J);
                    sb3.append("#0601");
                    sb2.append(sb3.toString());
                    lhVarA2.h(this.u.toString());
                    lhVarA2.setLocationDetail(this.o.toString());
                    return lhVarA2;
                }
                c(lhVarA2);
                lhVarA2.setOffset(this.q);
                lhVarA2.a(this.p);
                lhVarA2.f(String.valueOf(this.r));
                lhVarA2.e("new");
                lhVarA2.setLocationDetail(this.o.toString());
                this.C = lhVarA2.a();
                return lhVarA2;
            } catch (Throwable th) {
                mm.b();
                lbVar.d("FAIL");
                lx.a(this.f2955a).a(false, lx.f2983a);
                me.a(th, "Aps", "getApsLoc req");
                mk.a("/mobile/binary", th);
                if (!mm.d(this.f2955a)) {
                    lbVar.f("#0401");
                    this.o.append("网络异常，未连接到网络，请连接网络#0401");
                } else if (th instanceof fq) {
                    fq fqVar = th;
                    if (fqVar.a().contains("网络异常状态码")) {
                        lbVar.f("#0404");
                        StringBuilder sb4 = this.o;
                        sb4.append("网络异常，状态码错误#0404");
                        sb4.append(fqVar.f());
                    } else if (fqVar.f() != 23 && Math.abs((mm.b() - this.k) - this.i.getHttpTimeOut()) >= 500) {
                        lbVar.f("#0403," + th.getMessage());
                        this.o.append("网络异常,请求异常#0403");
                    } else {
                        lbVar.f("#0402");
                        this.o.append("网络异常，连接超时#0402");
                    }
                } else {
                    lbVar.f("#0403," + th.getMessage());
                    this.o.append("网络异常,请求异常#0403");
                }
                lh lhVarA3 = a(4, this.o.toString());
                lhVarA3.h(this.u.toString());
                return lhVarA3;
            }
        } catch (Throwable th2) {
            lbVar.f("#0301");
            this.o.append("get parames error:" + th2.getMessage() + "#0301");
            mk.a((String) null, 2031);
            lh lhVarA4 = a(3, this.o.toString());
            lhVarA4.h(this.u.toString());
            return lhVarA4;
        }
    }

    private String c(lb lbVar) {
        lm lmVar = this.d;
        String string = "";
        if (lmVar == null || this.c == null) {
            return "";
        }
        int iH = lmVar.h();
        ll llVarE = this.d.e();
        ll llVarF = this.d.f();
        ArrayList<kr> arrayList = this.g;
        boolean z = arrayList == null || arrayList.isEmpty();
        if (llVarE == null && llVarF == null && z) {
            if (this.b == null) {
                this.b = (ConnectivityManager) mm.a(this.f2955a, "connectivity");
            }
            if (mm.c() >= 31) {
                if (mm.a(this.f2955a) && !this.c.m()) {
                    this.x = 18;
                    this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1802");
                    mk.a((String) null, 2132);
                    lbVar.f("#1802");
                    return "";
                }
            } else if (mm.a(this.f2955a) && !this.c.l()) {
                this.x = 18;
                this.o.append("飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关#1801");
                mk.a((String) null, 2132);
                lbVar.f("#1801");
                return "";
            }
            if (mm.c() >= 28) {
                if (this.H == null) {
                    this.H = (LocationManager) this.f2955a.getApplicationContext().getSystemService("location");
                }
                if (!((Boolean) mi.a(this.H, "isLocationEnabled", new Object[0])).booleanValue()) {
                    this.x = 12;
                    this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                    lbVar.f("#1206");
                    mk.a((String) null, 2121);
                    return "";
                }
            }
            if (!mm.e(this.f2955a)) {
                this.x = 12;
                this.o.append("定位权限被禁用,请授予应用定位权限#1201");
                lbVar.f("#1201");
                mk.a((String) null, 2121);
                return "";
            }
            if (mm.c() >= 24 && mm.c() < 28 && Settings.Secure.getInt(this.f2955a.getContentResolver(), "location_mode", 0) == 0) {
                this.x = 12;
                lbVar.f("#1206");
                this.o.append("定位服务没有开启，请在设置中打开定位服务开关#1206");
                mk.a((String) null, 2121);
                return "";
            }
            String strK = this.d.k();
            String strD = this.c.d();
            if (this.c.a(this.b) && strD != null) {
                this.x = 12;
                lbVar.f("#1202");
                this.o.append("获取基站与获取WIFI的权限都被禁用，请在安全软件中打开应用的定位权限#1202");
                mk.a((String) null, 2121);
                return "";
            }
            if (strK != null) {
                this.x = 12;
                if (!this.c.l()) {
                    lbVar.f("#1204");
                    this.o.append("WIFI开关关闭，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限或者打开WIFI开关#1204");
                } else {
                    lbVar.f("#1205");
                    this.o.append("获取的WIFI列表为空，并且获取基站权限被禁用，请在安全软件中打开应用的定位权限#1205");
                }
                mk.a((String) null, 2121);
                return "";
            }
            if (!this.c.l() && !this.d.n()) {
                this.x = 19;
                lbVar.f("#1901");
                this.o.append("没有检查到SIM卡，并且WIFI开关关闭，请打开WIFI开关或者插入SIM卡#1901");
                mk.a((String) null, 2133);
                return "";
            }
            if (!this.c.l()) {
                lbVar.f("#1301");
                this.o.append("获取到的基站为空，并且关闭了WIFI开关，请您打开WIFI开关再发起定位#1301");
            } else {
                lbVar.f("#1302");
                if (this.c.c() != null) {
                    this.o.append("获取到的基站和WIFI信息均为空，请检查是否授予APP定位权限");
                    if (!mm.f(this.f2955a)) {
                        this.o.append("或后台运行没有后台定位权限");
                    }
                    this.o.append("#1302");
                } else {
                    this.o.append("获取到的基站和WIFI信息均为空，请移动到有WIFI的区域，若确定当前区域有WIFI，请检查是否授予APP定位权限");
                    if (!mm.f(this.f2955a)) {
                        this.o.append("或后台运行没有后台定位权限");
                    }
                    this.o.append("#1302");
                }
            }
            this.x = 13;
            mk.a((String) null, 2131);
            return "";
        }
        boolean zA = ls.a(this.c.n());
        if (iH == 0) {
            boolean z2 = !this.g.isEmpty() || zA;
            boolean z3 = llVarF != null;
            if (!z3) {
                if (zA && this.g.isEmpty()) {
                    this.x = 2;
                    lbVar.f("#0201");
                    this.o.append("当前基站为伪基站，并且WIFI权限被禁用，请在安全软件中打开应用的定位权限#0201");
                    mk.a((String) null, 2021);
                    return "";
                }
                if (this.g.size() == 1) {
                    this.x = 2;
                    if (!zA) {
                        lbVar.f("#0202");
                        this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        mk.a((String) null, 2022);
                        return "";
                    }
                    if (this.g.get(0).h) {
                        lbVar.f("#0202");
                        this.o.append("当前基站为伪基站，并且搜到的WIFI数量不足，请移动到WIFI比较丰富的区域#0202");
                        mk.a((String) null, 2021);
                        return "";
                    }
                }
            }
            String str = String.format(Locale.US, "#%s#", "network");
            if (z3) {
                StringBuilder sb = new StringBuilder();
                sb.append(llVarF.b());
                String str2 = (!this.g.isEmpty() || zA) ? "cgiwifi" : "cgi";
                sb.append("network");
                sb.append("#");
                sb.append(str2);
                string = sb.toString();
            } else if (z2) {
                string = str + "wifi";
            } else {
                this.x = 2;
                if (!this.c.l()) {
                    lbVar.f("#0203");
                    this.o.append("当前基站为伪基站,并且关闭了WIFI开关，请在设置中打开WIFI开关#0203");
                } else {
                    lbVar.f("#0204");
                    this.o.append("当前基站为伪基站,并且没有搜索到WIFI，请移动到WIFI比较丰富的区域#0204");
                }
                mk.a((String) null, 2022);
            }
        } else if (iH != 1) {
            if (iH != 2) {
                this.x = 11;
                mk.a((String) null, 2111);
                lbVar.f("#1101");
                this.o.append("get cgi failure#1101");
            } else if (llVarE != null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(llVarE.f2970a);
                sb2.append("#");
                sb2.append(llVarE.b);
                sb2.append("#");
                sb2.append(llVarE.h);
                sb2.append("#");
                sb2.append(llVarE.i);
                sb2.append("#");
                sb2.append(llVarE.j);
                sb2.append("#");
                sb2.append("network");
                sb2.append("#");
                sb2.append((!this.g.isEmpty() || zA) ? "cgiwifi" : "cgi");
                string = sb2.toString();
            }
        } else if (llVarE != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(llVarE.f2970a);
            sb3.append("#");
            sb3.append(llVarE.b);
            sb3.append("#");
            sb3.append(llVarE.c);
            sb3.append("#");
            sb3.append(llVarE.d);
            sb3.append("#");
            sb3.append("network");
            sb3.append("#");
            sb3.append((!this.g.isEmpty() || zA) ? "cgiwifi" : "cgi");
            string = sb3.toString();
        }
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        if (!string.startsWith("#")) {
            string = "#" + string;
        }
        return mm.e() + string;
    }

    public final void a() {
        lm lmVar = this.d;
        if (lmVar != null) {
            lmVar.b();
        }
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        this.i = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.i = new AMapLocationClientOption();
        }
        ls lsVar = this.c;
        if (lsVar != null) {
            this.i.isWifiActiveScan();
            lsVar.a(this.i.isWifiScan(), this.i.isMockEnable(), AMapLocationClientOption.isOpenAlwaysScanWifi(), aMapLocationClientOption.getScanWifiInterval());
        }
        i();
        lu luVar = this.e;
        if (luVar != null) {
            luVar.a(this.i);
        }
        mb mbVar = this.f;
        if (mbVar != null) {
            mbVar.a(this.i);
        }
        lm lmVar = this.d;
        if (lmVar != null) {
            lmVar.c(this.i.isNoLocReqCgiEnable());
        }
        k();
    }

    public final lh a(lb lbVar) throws Throwable {
        ls lsVar;
        lj ljVar;
        ls lsVar2;
        d();
        lbVar.e("conitue");
        if (this.f2955a == null) {
            lbVar.f("#0101");
            this.o.append("context is null#0101");
            return a(1, this.o.toString());
        }
        int i = this.I + 1;
        this.I = i;
        if (i == 1) {
            p();
        }
        if (a(this.k) && mm.a(this.j)) {
            if (this.s && md.a(this.j.getTime())) {
                this.j.setLocationType(2);
            }
            return this.j;
        }
        lj ljVar2 = this.y;
        if (ljVar2 != null) {
            if (this.z) {
                ljVar2.a();
            } else {
                ljVar2.b();
            }
        }
        try {
            boolean z = this.i.isOnceLocationLatest() || !this.i.isOnceLocation();
            ls lsVar3 = this.c;
            if (lsVar3 != null) {
                lsVar3.b(z);
                this.g = this.c.e();
            }
        } catch (Throwable th) {
            me.a(th, "Aps", "getLocation getScanResultsParam");
        }
        try {
            lm lmVar = this.d;
            if (lmVar != null) {
                lmVar.a(false, q());
            }
        } catch (Throwable th2) {
            me.a(th2, "Aps", "getLocation getCgiListParam");
        }
        String strC = c(lbVar);
        this.L = strC;
        if (TextUtils.isEmpty(strC)) {
            return a(this.x, this.o.toString());
        }
        this.u = a(this.u);
        ls lsVar4 = this.c;
        if (lsVar4 != null && lsVar4.o()) {
            lh lhVarA = a(15, "networkLocation has been mocked!#1502");
            lbVar.f("#1502");
            lhVarA.setMock(true);
            lhVarA.setTrustedLevel(4);
            return lhVarA;
        }
        boolean zO = o();
        lm lmVar2 = this.d;
        lh lhVarA2 = null;
        lh lhVarA3 = (lmVar2 == null || (lsVar2 = this.c) == null) ? null : this.e.a(lmVar2, zO, this.j, lsVar2, this.u, this.L, this.f2955a, false);
        if (mm.a(lhVarA3)) {
            lhVarA3.setTrustedLevel(2);
            d(lhVarA3);
        } else {
            lhVarA3 = b(true, lbVar);
            if (mm.a(lhVarA3)) {
                lhVarA3.e("new");
                this.e.a(this.u.toString());
                lm lmVar3 = this.d;
                if (lmVar3 != null) {
                    this.e.a(lmVar3.e());
                }
                d(lhVarA3);
            } else {
                lm lmVar4 = this.d;
                if (lmVar4 != null && (lsVar = this.c) != null) {
                    lhVarA2 = this.e.a(lmVar4, false, this.j, lsVar, this.u, this.L, this.f2955a, true);
                }
                if (mm.a(lhVarA2)) {
                    lbVar.f("#0001");
                    lhVarA2.setTrustedLevel(2);
                    d(lhVarA2);
                    lhVarA3 = lhVarA2;
                }
            }
        }
        try {
            if (this.c != null && lhVarA3 != null) {
                long jB = ls.b();
                if (jB <= 15) {
                    lhVarA3.setTrustedLevel(1);
                } else if (jB <= 120) {
                    lhVarA3.setTrustedLevel(2);
                } else if (jB <= 600) {
                    lhVarA3.setTrustedLevel(3);
                } else {
                    lhVarA3.setTrustedLevel(4);
                }
            }
        } catch (Throwable unused) {
        }
        this.e.a(this.L, this.u, lhVarA3, this.f2955a, true);
        mm.a(lhVarA3);
        StringBuilder sb = this.u;
        sb.delete(0, sb.length());
        if (lhVarA3 != null) {
            if (this.z && (ljVar = this.y) != null) {
                lhVarA3.setAltitude(ljVar.c());
                lhVarA3.setBearing(this.y.d());
                lhVarA3.setSpeed((float) this.y.e());
            } else {
                lhVarA3.setAltitude(0.0d);
                lhVarA3.setBearing(0.0f);
                lhVarA3.setSpeed(0.0f);
            }
        }
        d(lhVarA3);
        return this.j;
    }

    private void b(Context context) {
        try {
            if (context.checkCallingOrSelfPermission(ge.c("EYW5kcm9pZC5wZXJtaXNzaW9uLldSSVRFX1NFQ1VSRV9TRVRUSU5HUw==")) == 0) {
                this.m = true;
            }
        } catch (Throwable unused) {
        }
    }

    public final void b(lb lbVar) {
        try {
            if (this.v) {
                return;
            }
            r();
            if (this.t) {
                m();
            }
            ls lsVar = this.c;
            if (lsVar != null) {
                lsVar.b(this.t);
                this.g = this.c.e();
            }
            lm lmVar = this.d;
            if (lmVar != null) {
                lmVar.a(true, q());
            }
            String strC = c(lbVar);
            this.L = strC;
            if (!TextUtils.isEmpty(strC)) {
                this.u = a(this.u);
            }
        } catch (Throwable th) {
            me.a(th, "Aps", "initFirstLocateParam");
        }
        this.v = true;
    }

    public final lh a(lh lhVar) {
        this.B.a(this.s);
        return this.B.a(lhVar);
    }

    public final void a(boolean z) {
        lm lmVar = this.d;
        if (lmVar != null) {
            lmVar.b(z);
        }
    }

    private boolean a(long j) {
        if (!this.M) {
            this.M = true;
            return false;
        }
        if (mm.b() - j < 800) {
            if ((mm.a(this.j) ? mm.a() - this.j.getTime() : 0L) <= 10000) {
                return true;
            }
        }
        return false;
    }

    private StringBuilder a(StringBuilder sb) {
        if (sb == null) {
            sb = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        lm lmVar = this.d;
        if (lmVar != null && this.c != null) {
            sb.append(lmVar.m());
            sb.append(this.c.p());
        }
        return sb;
    }

    public final lh b(boolean z) {
        ls lsVar = this.c;
        if (lsVar != null && lsVar.o()) {
            return a(15, "networkLocation has been mocked!#1502");
        }
        if (TextUtils.isEmpty(this.L)) {
            return a(this.x, this.o.toString());
        }
        lh lhVarA = this.e.a(this.f2955a, this.L, this.u, true, z);
        if (mm.a(lhVarA)) {
            d(lhVarA);
        }
        return lhVarA;
    }

    private lh a(lh lhVar, ie ieVar, lb lbVar) {
        if (ieVar != null) {
            try {
                byte[] bArr = ieVar.f2902a;
                if (bArr != null && bArr.length != 0) {
                    mb mbVar = new mb();
                    String str = new String(ieVar.f2902a, "UTF-8");
                    if (str.contains("\"status\":\"0\"")) {
                        lh lhVarA = mbVar.a(str, this.f2955a, ieVar, lbVar);
                        lhVarA.h(this.u.toString());
                        return lhVarA;
                    }
                    if (!str.contains("</body></html>")) {
                        return null;
                    }
                    lhVar.setErrorCode(5);
                    ls lsVar = this.c;
                    if (lsVar != null && lsVar.a(this.b)) {
                        lbVar.f("#0501");
                        this.o.append("您连接的是一个需要登录的网络，请确认已经登入网络#0501");
                        mk.a((String) null, 2051);
                    } else {
                        lbVar.f("#0502");
                        this.o.append("请求可能被劫持了#0502");
                        mk.a((String) null, 2052);
                    }
                    lhVar.setLocationDetail(this.o.toString());
                    return lhVar;
                }
            } catch (Throwable th) {
                lhVar.setErrorCode(4);
                me.a(th, "Aps", "checkResponseEntity");
                lbVar.f("#0403");
                this.o.append("check response exception ex is" + th.getMessage() + "#0403");
                lhVar.setLocationDetail(this.o.toString());
                return lhVar;
            }
        }
        lhVar.setErrorCode(4);
        this.o.append("网络异常,请求异常#0403");
        lbVar.f("#0403");
        lhVar.h(this.u.toString());
        lhVar.setLocationDetail(this.o.toString());
        if (ieVar != null) {
            mk.a(ieVar.d, 2041);
        }
        return lhVar;
    }

    public final void b(lh lhVar) {
        if (mm.a(lhVar)) {
            this.e.a(this.L, this.u, lhVar, this.f2955a, true);
        }
    }

    private static void c(lh lhVar) {
        if (lhVar.getErrorCode() == 0 && lhVar.getLocationType() == 0) {
            if (!"-5".equals(lhVar.d()) && !"1".equals(lhVar.d()) && !"2".equals(lhVar.d()) && !BaseWrapper.ENTER_ID_AD_SDK.equals(lhVar.d()) && !"24".equals(lhVar.d()) && !"-1".equals(lhVar.d())) {
                lhVar.setLocationType(6);
            } else {
                lhVar.setLocationType(5);
            }
        }
    }

    public final lh a(boolean z, lb lbVar) {
        if (z) {
            lbVar.e("statics");
        } else {
            lbVar.e("first");
        }
        if (this.f2955a == null) {
            lbVar.f("#0101");
            this.o.append("context is null#0101");
            mk.a((String) null, 2011);
            return a(1, this.o.toString());
        }
        ls lsVar = this.c;
        if (lsVar != null && lsVar.o()) {
            lbVar.f("#1502");
            return a(15, "networkLocation has been mocked!#1502");
        }
        b();
        if (TextUtils.isEmpty(this.L)) {
            return a(this.x, this.o.toString());
        }
        lh lhVarB = b(z, lbVar);
        if (mm.a(lhVarB) && !Q) {
            this.e.a(this.u.toString());
            lm lmVar = this.d;
            if (lmVar != null) {
                this.e.a(lmVar.e());
            }
            d(lhVarB);
        }
        Q = true;
        return lhVarB;
    }

    public final lh a(double d, double d2) {
        try {
            String strA = this.n.a(this.f2955a, d, d2);
            if (!strA.contains("\"status\":\"1\"")) {
                return null;
            }
            lh lhVarA = this.f.a(strA);
            lhVarA.setLatitude(d);
            lhVarA.setLongitude(d2);
            return lhVarA;
        } catch (Throwable unused) {
            return null;
        }
    }

    public final void a(AMapLocation aMapLocation) {
        if (aMapLocation != null && aMapLocation.getErrorCode() == 0) {
            ln lnVar = new ln();
            lnVar.f2974a = aMapLocation.getLocationType();
            lnVar.d = aMapLocation.getTime();
            lnVar.e = (int) aMapLocation.getAccuracy();
            lnVar.b = aMapLocation.getLatitude();
            lnVar.c = aMapLocation.getLongitude();
            if (aMapLocation.getLocationType() == 1) {
                this.O.a(lnVar);
            }
            if (aMapLocation.getLocationType() == 12) {
                this.O.b(lnVar);
            }
        }
    }

    public final void a(lh lhVar, int i) {
        if (lhVar != null && lhVar.getErrorCode() == 0) {
            ln lnVar = new ln();
            lnVar.d = lhVar.getTime();
            lnVar.e = (int) lhVar.getAccuracy();
            lnVar.b = lhVar.getLatitude();
            lnVar.c = lhVar.getLongitude();
            lnVar.f2974a = i;
            lnVar.g = Integer.parseInt(lhVar.d());
            lnVar.h = lhVar.l();
            this.O.c(lnVar);
        }
    }

    private static lh a(int i, String str) {
        lh lhVar = new lh("");
        lhVar.setErrorCode(i);
        lhVar.setLocationDetail(str);
        if (i == 15) {
            mk.a((String) null, 2151);
        }
        return lhVar;
    }
}
