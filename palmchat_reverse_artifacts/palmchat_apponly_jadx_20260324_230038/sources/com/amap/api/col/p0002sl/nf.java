package com.amap.api.col.p0002sl;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import com.igexin.push.config.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public final class nf {
    static long c;
    static long d;
    static long e;
    static long f;
    static long g;
    public static HashMap<String, Long> q = new HashMap<>(36);
    public static long r = 0;
    static int s = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    WifiManager f3032a;
    Context h;
    ArrayList<ScanResult> b = new ArrayList<>();
    boolean i = false;
    StringBuilder j = null;
    boolean k = true;
    boolean l = true;
    boolean m = true;
    private volatile WifiInfo v = null;
    String n = null;
    TreeMap<Integer, ScanResult> o = null;
    public boolean p = true;
    ConnectivityManager t = null;
    private long w = 30000;
    volatile boolean u = false;

    public nf(Context context, WifiManager wifiManager) {
        this.f3032a = wifiManager;
        this.h = context;
    }

    public static String i() {
        return String.valueOf(np.b() - f);
    }

    private List<ScanResult> j() {
        WifiManager wifiManager = this.f3032a;
        if (wifiManager != null) {
            try {
                List<ScanResult> scanResults = wifiManager.getScanResults();
                HashMap<String, Long> map = new HashMap<>(36);
                for (ScanResult scanResult : scanResults) {
                    map.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                }
                if (q.isEmpty() || !q.equals(map)) {
                    q = map;
                    r = np.b();
                }
                this.n = null;
                return scanResults;
            } catch (SecurityException e2) {
                this.n = e2.getMessage();
            } catch (Throwable th) {
                this.n = null;
                nl.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private WifiInfo k() {
        try {
            WifiManager wifiManager = this.f3032a;
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
            return null;
        } catch (Throwable th) {
            nl.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    private int l() {
        WifiManager wifiManager = this.f3032a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean m() {
        long jB = np.b() - c;
        if (jB < 4900) {
            return false;
        }
        if (n() && jB < 9900) {
            return false;
        }
        if (s > 1) {
            long jB2 = this.w;
            if (jB2 == 30000) {
                jB2 = nk.b() != -1 ? nk.b() : 30000L;
            }
            if (Build.VERSION.SDK_INT >= 28 && jB < jB2) {
                return false;
            }
        }
        if (this.f3032a == null) {
            return false;
        }
        c = np.b();
        int i = s;
        if (i < 2) {
            s = i + 1;
        }
        return this.f3032a.startScan();
    }

    private boolean n() {
        if (this.t == null) {
            this.t = (ConnectivityManager) np.a(this.h, "connectivity");
        }
        return a(this.t);
    }

    private boolean o() {
        if (this.f3032a == null) {
            return false;
        }
        return np.c(this.h);
    }

    private void p() {
        String strValueOf;
        ArrayList<ScanResult> arrayList = this.b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (np.b() - f > 3600000) {
            b();
        }
        if (this.o == null) {
            this.o = new TreeMap<>(Collections.reverseOrder());
        }
        this.o.clear();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            ScanResult scanResult = this.b.get(i);
            if (np.a(scanResult != null ? scanResult.BSSID : "") && (size <= 20 || a(scanResult.level))) {
                if (!TextUtils.isEmpty(scanResult.SSID)) {
                    strValueOf = "<unknown ssid>".equals(scanResult.SSID) ? "unkwn" : String.valueOf(i);
                    this.o.put(Integer.valueOf((scanResult.level * 25) + i), scanResult);
                }
                scanResult.SSID = strValueOf;
                this.o.put(Integer.valueOf((scanResult.level * 25) + i), scanResult);
            }
        }
        this.b.clear();
        Iterator<ScanResult> it = this.o.values().iterator();
        while (it.hasNext()) {
            this.b.add(it.next());
        }
        this.o.clear();
    }

    private void q() {
        if (t()) {
            long jB = np.b();
            if (jB - d >= 10000) {
                this.b.clear();
                g = f;
            }
            r();
            if (jB - d >= 10000) {
                for (int i = 20; i > 0 && f == g; i--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void r() {
        if (t()) {
            try {
                if (m()) {
                    e = np.b();
                }
            } catch (Throwable th) {
                nl.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void s() {
        List<ScanResult> listJ;
        if (g != f) {
            try {
                listJ = j();
            } catch (Throwable th) {
                nl.a(th, "WifiManager", "updateScanResult");
                listJ = null;
            }
            g = f;
            if (listJ == null) {
                this.b.clear();
            } else {
                this.b.clear();
                this.b.addAll(listJ);
            }
        }
    }

    private boolean t() {
        boolean zO = o();
        this.p = zO;
        if (!zO || !this.k) {
            return false;
        }
        if (e != 0) {
            if (np.b() - e < 4900 || np.b() - f < c.j) {
                return false;
            }
            np.b();
        }
        return true;
    }

    public final ArrayList<ScanResult> a() {
        if (this.b == null) {
            return null;
        }
        ArrayList<ScanResult> arrayList = new ArrayList<>();
        if (!this.b.isEmpty()) {
            arrayList.addAll(this.b);
        }
        return arrayList;
    }

    public final void b() {
        this.v = null;
        this.b.clear();
    }

    public final void c() {
        if (this.f3032a != null && np.b() - f > 4900) {
            f = np.b();
        }
    }

    public final void d() {
        int iL;
        if (this.f3032a == null) {
            return;
        }
        try {
            iL = l();
        } catch (Throwable th) {
            nl.a(th, "Aps", "onReceive part");
            iL = 4;
        }
        if (this.b == null) {
            this.b = new ArrayList<>();
        }
        if (iL == 0 || iL == 1 || iL == 4) {
            this.u = true;
        }
    }

    public final boolean e() {
        return this.p;
    }

    public final WifiInfo f() {
        this.v = k();
        return this.v;
    }

    public final boolean g() {
        return this.i;
    }

    public final void h() {
        b();
        this.b.clear();
    }

    private void d(boolean z) {
        this.k = z;
        this.l = true;
        this.m = true;
        this.w = 30000L;
    }

    public final void a(boolean z) {
        Context context = this.h;
        if (!nk.a() || !this.m || this.f3032a == null || context == null || !z || np.c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) nn.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, (Class<?>[]) new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                nn.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, (Class<?>[]) new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            nl.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final void b(boolean z) {
        if (z) {
            q();
        } else {
            r();
        }
        if (this.u) {
            this.u = false;
            b();
        }
        s();
        if (np.b() - f > 20000) {
            this.b.clear();
        }
        d = np.b();
        if (this.b.isEmpty()) {
            f = np.b();
            List<ScanResult> listJ = j();
            if (listJ != null) {
                this.b.addAll(listJ);
            }
        }
        p();
    }

    public final void c(boolean z) {
        d(z);
    }

    private static boolean a(int i) {
        int iCalculateSignalLevel = 20;
        try {
            iCalculateSignalLevel = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e2) {
            nl.a(e2, "Aps", "wifiSigFine");
        }
        return iCalculateSignalLevel > 0;
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        WifiManager wifiManager = this.f3032a;
        if (wifiManager == null) {
            return false;
        }
        try {
            if (np.a(connectivityManager.getActiveNetworkInfo()) == 1) {
                return a(wifiManager.getConnectionInfo());
            }
            return false;
        } catch (Throwable th) {
            nl.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public static boolean a(WifiInfo wifiInfo) {
        return (wifiInfo == null || TextUtils.isEmpty(wifiInfo.getSSID()) || !np.a(wifiInfo.getBSSID())) ? false : true;
    }
}
