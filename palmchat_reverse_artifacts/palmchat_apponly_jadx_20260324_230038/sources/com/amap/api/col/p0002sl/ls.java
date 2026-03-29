package com.amap.api.col.p0002sl;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import com.igexin.push.config.c;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class ls {
    static long d;
    static long e;
    static long f;
    public static long g;
    static long h;
    public static HashMap<String, Long> v = new HashMap<>(36);
    public static long w = 0;
    static int x = 0;
    public static long z = 0;
    private ld E;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WifiManager f2978a;
    Context i;
    lq t;
    ArrayList<kr> b = new ArrayList<>();
    ArrayList<kr> c = new ArrayList<>();
    boolean j = false;
    StringBuilder k = null;
    boolean l = true;
    boolean m = true;
    boolean n = true;
    private volatile lr B = null;
    String o = null;
    TreeMap<Integer, kr> p = null;
    public boolean q = true;
    public boolean r = true;
    public boolean s = false;
    private String C = "";
    long u = 0;
    ConnectivityManager y = null;
    private long D = 30000;
    volatile boolean A = false;

    public ls(Context context, WifiManager wifiManager, Handler handler) {
        this.f2978a = wifiManager;
        this.i = context;
        lq lqVar = new lq(context, "wifiAgee", handler);
        this.t = lqVar;
        lqVar.a();
    }

    private void A() {
        int iT;
        try {
            if (this.f2978a == null) {
                return;
            }
            try {
                iT = t();
            } catch (Throwable th) {
                me.a(th, "OPENSDK_WMW", "cwsc");
                iT = 4;
            }
            if (this.b == null) {
                this.b = new ArrayList<>();
            }
            if (iT == 0 || iT == 1 || iT == 4) {
                g();
            }
        } catch (Throwable unused) {
        }
    }

    private void B() {
        try {
            if (mm.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.r = this.f2978a.isWifiEnabled();
            }
        } catch (Throwable unused) {
            mg.b();
        }
    }

    private boolean C() {
        this.q = w();
        B();
        if (!this.q || !this.l) {
            return false;
        }
        if (f != 0) {
            if (mm.b() - f < 4900 || mm.b() - g < c.j) {
                return false;
            }
            mm.b();
        }
        return true;
    }

    public static long b() {
        return ((mm.b() - w) / 1000) + 1;
    }

    public static String q() {
        return String.valueOf(mm.b() - g);
    }

    private List<kr> s() {
        List<ScanResult> scanResults;
        if (this.f2978a != null) {
            try {
                if (mm.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    scanResults = this.f2978a.getScanResults();
                } else {
                    me.a(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    scanResults = null;
                }
                HashMap<String, Long> map = new HashMap<>(36);
                if (scanResults != null) {
                    for (ScanResult scanResult : scanResults) {
                        map.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                }
                if (v.isEmpty() || !v.equals(map)) {
                    v = map;
                    w = mm.b();
                }
                this.o = null;
                ArrayList arrayList = new ArrayList();
                this.C = "";
                this.B = n();
                if (a(this.B)) {
                    this.C = this.B.a();
                }
                if (scanResults != null && scanResults.size() > 0) {
                    int size = scanResults.size();
                    for (int i = 0; i < size; i++) {
                        ScanResult scanResult2 = scanResults.get(i);
                        kr krVar = new kr(!TextUtils.isEmpty(this.C) && this.C.equals(scanResult2.BSSID));
                        krVar.b = scanResult2.SSID;
                        krVar.d = scanResult2.frequency;
                        krVar.e = scanResult2.timestamp;
                        krVar.f2946a = kr.a(scanResult2.BSSID);
                        krVar.c = (short) scanResult2.level;
                        short sElapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        krVar.g = sElapsedRealtime;
                        if (sElapsedRealtime < 0) {
                            krVar.g = (short) 0;
                        }
                        krVar.f = mm.b();
                        arrayList.add(krVar);
                    }
                }
                this.t.a((List) arrayList);
                return arrayList;
            } catch (SecurityException e2) {
                this.o = e2.getMessage();
            } catch (Throwable th) {
                this.o = null;
                me.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private int t() {
        WifiManager wifiManager = this.f2978a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean u() {
        long jB = mm.b() - d;
        if (jB < 4900) {
            return false;
        }
        if (v() && jB < 9900) {
            return false;
        }
        if (x > 1) {
            long jO = this.D;
            if (jO == 30000) {
                jO = md.o() != -1 ? md.o() : 30000L;
            }
            if (Build.VERSION.SDK_INT >= 28 && jB < jO) {
                return false;
            }
        }
        if (this.f2978a != null) {
            d = mm.b();
            int i = x;
            if (i < 2) {
                x = i + 1;
            }
            if (mm.c(this.i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                return this.f2978a.startScan();
            }
            me.a(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
        }
        return false;
    }

    private boolean v() {
        if (this.y == null) {
            this.y = (ConnectivityManager) mm.a(this.i, "connectivity");
        }
        return a(this.y);
    }

    private boolean w() {
        if (this.f2978a == null) {
            return false;
        }
        return mm.g(this.i);
    }

    private void x() {
        if (C()) {
            long jB = mm.b();
            if (jB - e >= 10000) {
                this.b.clear();
                h = g;
            }
            y();
            if (jB - e >= 10000) {
                for (int i = 20; i > 0 && g == h; i--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void y() {
        if (C()) {
            try {
                if (u()) {
                    f = mm.b();
                }
            } catch (Throwable th) {
                me.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void z() {
        List<kr> listS;
        if (h != g) {
            try {
                listS = s();
            } catch (Throwable th) {
                me.a(th, "WifiManager", "updateScanResult");
                listS = null;
            }
            h = g;
            if (listS == null) {
                this.b.clear();
            } else {
                this.b.clear();
                this.b.addAll(listS);
            }
        }
    }

    public final ArrayList<kr> a() {
        if (!this.s) {
            return this.c;
        }
        b(true);
        return this.c;
    }

    public final WifiInfo c() {
        try {
            if (this.f2978a == null) {
                return null;
            }
            if (mm.c(this.i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                return this.f2978a.getConnectionInfo();
            }
            me.a(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
            return null;
        } catch (Throwable th) {
            me.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final String d() {
        return this.o;
    }

    public final ArrayList<kr> e() {
        if (this.b == null) {
            return null;
        }
        ArrayList<kr> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void f() {
        try {
            this.s = true;
            List<kr> listS = s();
            if (listS != null) {
                this.b.clear();
                this.b.addAll(listS);
            }
            d(true);
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        this.B = null;
        this.b.clear();
    }

    public final void h() {
        this.B = null;
    }

    public final void i() {
        z = System.currentTimeMillis();
        ld ldVar = this.E;
        if (ldVar != null) {
            ldVar.b();
        }
    }

    public final void j() {
        if (this.f2978a != null && mm.b() - g > 4900) {
            g = mm.b();
        }
    }

    public final void k() {
        if (this.f2978a == null) {
            return;
        }
        this.A = true;
    }

    public final boolean l() {
        return this.q;
    }

    public final boolean m() {
        return this.r;
    }

    public final lr n() {
        B();
        if (!m()) {
            return null;
        }
        if (this.B == null) {
            this.B = new lr(c());
        }
        return this.B;
    }

    public final boolean o() {
        return this.j;
    }

    public final String p() {
        boolean z2;
        String str;
        StringBuilder sb = this.k;
        if (sb == null) {
            this.k = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.j = false;
        int size = this.b.size();
        int i = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i < size) {
            String strA = kr.a(this.b.get(i).f2946a);
            if (!this.m && !"<unknown ssid>".equals(this.b.get(i).b)) {
                z3 = true;
            }
            if (TextUtils.isEmpty(this.C) || !this.C.equals(strA)) {
                z2 = z4;
                str = "nb";
            } else {
                str = bt.Q;
                z2 = true;
            }
            this.k.append(String.format(Locale.US, "#%s,%s", strA, str));
            i++;
            z4 = z2;
        }
        if (this.b.size() == 0) {
            z3 = true;
        }
        if (!this.m && !z3) {
            this.j = true;
        }
        if (!z4 && !TextUtils.isEmpty(this.C)) {
            StringBuilder sb2 = this.k;
            sb2.append("#");
            sb2.append(this.C);
            this.k.append(",access");
        }
        return this.k.toString();
    }

    public final long r() {
        return this.u;
    }

    private void d(boolean z2) {
        ArrayList<kr> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (mm.b() - g > 3600000) {
            g();
        }
        if (this.p == null) {
            this.p = new TreeMap<>(Collections.reverseOrder());
        }
        this.p.clear();
        if (this.s && z2) {
            try {
                this.c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.b.size();
        this.u = 0L;
        for (int i = 0; i < size; i++) {
            kr krVar = this.b.get(i);
            if (krVar.h) {
                this.u = krVar.f;
            }
            if (mm.a(kr.a(krVar.f2946a)) && (size <= 20 || a(krVar.c))) {
                if (this.s && z2) {
                    this.c.add(krVar);
                }
                if (TextUtils.isEmpty(krVar.b)) {
                    krVar.b = "unkwn";
                } else if (!"<unknown ssid>".equals(krVar.b)) {
                    krVar.b = String.valueOf(i);
                }
                this.p.put(Integer.valueOf((krVar.c * 25) + i), krVar);
            }
        }
        this.b.clear();
        Iterator<kr> it = this.p.values().iterator();
        while (it.hasNext()) {
            this.b.add(it.next());
        }
        this.p.clear();
    }

    public final void b(boolean z2) {
        if (z2) {
            x();
        } else {
            y();
        }
        boolean z3 = false;
        if (this.A) {
            this.A = false;
            A();
        }
        z();
        if (mm.b() - g > 20000) {
            this.b.clear();
        }
        e = mm.b();
        if (this.b.isEmpty()) {
            g = mm.b();
            List<kr> listS = s();
            if (listS != null) {
                this.b.addAll(listS);
                z3 = true;
            }
        }
        d(z3);
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        try {
            if (mm.a(connectivityManager.getActiveNetworkInfo()) == 1) {
                return a(n());
            }
            return false;
        } catch (Throwable th) {
            me.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void c(boolean z2) {
        g();
        this.b.clear();
        this.t.a(z2);
    }

    public final void a(boolean z2) {
        Context context = this.i;
        if (!md.n() || !this.n || this.f2978a == null || context == null || !z2 || mm.c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) mi.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                mi.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            me.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public static boolean a(lr lrVar) {
        if (lrVar == null) {
            return false;
        }
        return lrVar.d();
    }

    public final void a(boolean z2, boolean z3, boolean z4, long j) {
        this.l = z2;
        this.m = z3;
        this.n = z4;
        if (j < 10000) {
            this.D = 10000L;
        } else {
            this.D = j;
        }
    }

    public final void a(ld ldVar) {
        this.E = ldVar;
    }

    private static boolean a(int i) {
        int iCalculateSignalLevel = 20;
        try {
            iCalculateSignalLevel = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e2) {
            me.a(e2, "Aps", "wifiSigFine");
        }
        return iCalculateSignalLevel > 0;
    }
}
