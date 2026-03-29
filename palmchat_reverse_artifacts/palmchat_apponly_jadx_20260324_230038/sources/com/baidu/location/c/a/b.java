package com.baidu.location.c.a;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.DhcpInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.location.c.e;
import com.baidu.location.c.g;
import com.baidu.location.c.k;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.openalliance.ad.constant.x;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public class b implements com.baidu.location.c.b.a {
    private Context h;
    private boolean b = false;
    private WifiManager e = null;
    private C0064b f = null;
    private k g = null;
    private AtomicInteger i = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3480a = 0;
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private WifiInfo n = null;
    private String o = null;
    private final Object p = new Object();
    private final Object q = new Object();
    private Handler r = null;
    private String s = null;

    /* JADX INFO: compiled from: SearchBox */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static b f3481a = new b();
    }

    /* JADX INFO: renamed from: com.baidu.location.c.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SearchBox */
    public class C0064b extends BroadcastReceiver {
        private C0064b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            if ((!com.baidu.location.c.b.a.d || g.i().a(intent)) && intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                b.this.f3480a = System.currentTimeMillis() / 1000;
                b.this.r.post(new Runnable() { // from class: com.baidu.location.c.a.b.b.1
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.j();
                        synchronized (b.this.p) {
                            b.this.p.notifyAll();
                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                g.i().a("WifiScan finished, in callback.");
                            }
                        }
                    }
                });
            }
        }
    }

    public static b a() {
        return a.f3481a;
    }

    private synchronized WifiInfo g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.l > 5000) {
            WifiManager wifiManager = this.e;
            if (wifiManager != null) {
                this.n = wifiManager.getConnectionInfo();
            }
            this.l = jCurrentTimeMillis;
        }
        return this.n;
    }

    private void h() {
        int i;
        try {
            if (this.e.isWifiEnabled() || this.e.isScanAlwaysAvailable()) {
                this.e.startScan();
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.i().a("wifimanager start scan ...");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.j = System.currentTimeMillis();
        synchronized (this.p) {
            try {
                i = this.i.get();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (i != 0) {
                this.p.wait(i);
            }
        }
    }

    private String i() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.e;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return b(dhcpInfo.gateway);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        WifiManager wifiManager = this.e;
        if (wifiManager == null) {
            return;
        }
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (scanResults != null && scanResults.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    long j = 0;
                    for (int i = 0; i < scanResults.size(); i++) {
                        if (i == 0) {
                            try {
                                j = (jCurrentTimeMillis - scanResults.get(0).timestamp) / 1000000;
                            } catch (Exception e) {
                                e.printStackTrace();
                                j = 0;
                            }
                            sb.append(scanResults.get(0).BSSID + x.aQ + Math.abs(scanResults.get(0).level) + x.aQ + scanResults.get(0).SSID.trim() + x.aQ + scanResults.get(0).frequency + x.aQ + j + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        }
                        sb.append(scanResults.get(i).BSSID + x.aQ + Math.abs(scanResults.get(i).level) + x.aQ + scanResults.get(i).SSID.trim() + x.aQ + scanResults.get(i).frequency + x.aQ + (((jCurrentTimeMillis - scanResults.get(i).timestamp) / 1000000) - j) + HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    }
                    sb.append("\t");
                    sb.append(simpleDateFormat.format(new Date(jCurrentTimeMillis)));
                    sb.append("\t");
                    sb.append(jCurrentTimeMillis);
                    sb.append("\tnull\n");
                    g.i().a(sb.toString());
                }
            }
            if (scanResults != null) {
                k kVar = new k(scanResults, System.currentTimeMillis());
                synchronized (this.q) {
                    k kVar2 = this.g;
                    if (kVar2 == null || !a(kVar, kVar2)) {
                        this.g = kVar;
                    }
                }
            }
        } catch (Exception e2) {
            if (com.baidu.location.c.b.a.c) {
                e2.printStackTrace();
            }
        }
    }

    public long c() {
        return this.j;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0030 -> B:22:0x0035). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0032 -> B:22:0x0035). Please report as a decompilation issue!!! */
    public k d() {
        k kVarA;
        synchronized (this.q) {
            kVarA = a(this.g);
        }
        if (kVarA == null || !kVarA.b()) {
            try {
                WifiManager wifiManager = this.e;
                kVarA = wifiManager != null ? new k(wifiManager.getScanResults(), this.j) : new k(null, 0L);
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
            }
        }
        return kVarA;
    }

    public String e() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo wifiInfoF = a().f();
        String strA = a(wifiInfoF, (String) null);
        if (wifiInfoF == null || strA == null) {
            return null;
        }
        String strReplace = strA.replace(":", "");
        int rssi = wifiInfoF.getRssi();
        String strI = a().i();
        if (rssi < 0) {
            rssi = -rssi;
        }
        if (strReplace == null || rssi >= 100 || "020000000000".equals(strReplace)) {
            return null;
        }
        stringBuffer.append("&wf=");
        stringBuffer.append(strReplace);
        stringBuffer.append(x.aQ);
        stringBuffer.append("" + rssi + x.aQ);
        String ssid = wifiInfoF.getSSID();
        if (ssid != null && (ssid.contains(ContainerUtils.FIELD_DELIMITER) || ssid.contains(x.aQ))) {
            ssid = ssid.replace(ContainerUtils.FIELD_DELIMITER, "_");
        }
        stringBuffer.append(ssid);
        stringBuffer.append("&wf_n=1");
        if (strI != null) {
            stringBuffer.append("&wf_gw=");
            stringBuffer.append(strI);
        }
        return stringBuffer.toString();
    }

    public WifiInfo f() {
        try {
            WifiInfo wifiInfoG = g();
            String strA = a(wifiInfoG, (String) null);
            if (wifiInfoG != null && strA != null && wifiInfoG.getRssi() > -100) {
                String strReplace = strA.replace(":", "");
                if (!"000000000000".equals(strReplace) && !"".equals(strReplace)) {
                    if (!"020000000000".equals(strReplace)) {
                        return wifiInfoG;
                    }
                }
            }
        } catch (Error | Exception unused) {
        }
        return null;
    }

    private String b(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public k a(long j) {
        e eVarI;
        String str;
        if (this.e != null && j < 2147483647L) {
            boolean z = com.baidu.location.c.b.a.c;
            if (z && com.baidu.location.c.b.a.d) {
                g.i().a("Wi-Fi diffTime = " + j + "mLastDiffTime = " + this.k);
            }
            if (j == this.k) {
                if (z && com.baidu.location.c.b.a.d) {
                    g.i().a("System.currentTimeMillis() = " + System.currentTimeMillis() + "wifi diffTime = " + j + ", mScanTime = " + this.j);
                }
                if (System.currentTimeMillis() - this.j > j) {
                    if (z && com.baidu.location.c.b.a.d) {
                        eVarI = g.i();
                        str = "time is over";
                        eVarI.a(str);
                    }
                    h();
                }
            } else {
                if (z && com.baidu.location.c.b.a.d) {
                    eVarI = g.i();
                    str = "diffTime is changed";
                    eVarI.a(str);
                }
                h();
            }
        }
        this.k = j;
        return this.g;
    }

    private k a(k kVar) {
        if (kVar != null) {
            return new k(kVar.f3506a, kVar.b);
        }
        return null;
    }

    private String b(String str) {
        return str != null ? (str.contains(ContainerUtils.FIELD_DELIMITER) || str.contains(x.aQ)) ? str.replace(ContainerUtils.FIELD_DELIMITER, "_").replace(x.aQ, "_") : str : str;
    }

    /* JADX WARN: Removed duplicated region for block: B:133:0x02ae A[Catch: Exception -> 0x04e2, Error -> 0x04e4, TryCatch #9 {Error -> 0x04e4, blocks: (B:100:0x01f4, B:107:0x020c, B:109:0x0212, B:111:0x021e, B:113:0x022e, B:149:0x031c, B:131:0x02aa, B:133:0x02ae, B:121:0x0263, B:123:0x0269, B:125:0x0275, B:127:0x0285, B:136:0x02b7, B:138:0x02bf, B:140:0x02c3, B:141:0x02e5, B:150:0x0328, B:152:0x0335, B:154:0x0339, B:157:0x0358, B:159:0x0360, B:161:0x036b, B:165:0x037a, B:167:0x0384, B:169:0x0390, B:172:0x03a4, B:179:0x03c8, B:166:0x0381, B:181:0x03d0, B:183:0x03e8, B:187:0x03fb, B:190:0x0415, B:192:0x041b, B:194:0x042a, B:195:0x0442, B:197:0x0448, B:199:0x0450, B:203:0x046c, B:200:0x0459, B:202:0x0466, B:204:0x0470, B:206:0x0474, B:208:0x0478, B:209:0x0494, B:211:0x049d, B:213:0x04bd, B:217:0x04cc, B:219:0x04d1, B:220:0x04db), top: B:253:0x01f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02b3 A[PHI: r6 r7
      0x02b3: PHI (r6v50 char) = (r6v48 char), (r6v48 char), (r6v48 char), (r6v48 char), (r6v54 char) binds: [B:119:0x025f, B:122:0x0267, B:124:0x0273, B:126:0x0283, B:115:0x0252] A[DONT_GENERATE, DONT_INLINE]
      0x02b3: PHI (r7v22 java.util.Random) = 
      (r7v20 java.util.Random)
      (r7v20 java.util.Random)
      (r7v20 java.util.Random)
      (r7v20 java.util.Random)
      (r7v24 java.util.Random)
     binds: [B:119:0x025f, B:122:0x0267, B:124:0x0273, B:126:0x0283, B:115:0x0252] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x03d0 A[Catch: Exception -> 0x04e2, Error -> 0x04e4, TryCatch #9 {Error -> 0x04e4, blocks: (B:100:0x01f4, B:107:0x020c, B:109:0x0212, B:111:0x021e, B:113:0x022e, B:149:0x031c, B:131:0x02aa, B:133:0x02ae, B:121:0x0263, B:123:0x0269, B:125:0x0275, B:127:0x0285, B:136:0x02b7, B:138:0x02bf, B:140:0x02c3, B:141:0x02e5, B:150:0x0328, B:152:0x0335, B:154:0x0339, B:157:0x0358, B:159:0x0360, B:161:0x036b, B:165:0x037a, B:167:0x0384, B:169:0x0390, B:172:0x03a4, B:179:0x03c8, B:166:0x0381, B:181:0x03d0, B:183:0x03e8, B:187:0x03fb, B:190:0x0415, B:192:0x041b, B:194:0x042a, B:195:0x0442, B:197:0x0448, B:199:0x0450, B:203:0x046c, B:200:0x0459, B:202:0x0466, B:204:0x0470, B:206:0x0474, B:208:0x0478, B:209:0x0494, B:211:0x049d, B:213:0x04bd, B:217:0x04cc, B:219:0x04d1, B:220:0x04db), top: B:253:0x01f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x04e0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:234:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0328 A[EDGE_INSN: B:257:0x0328->B:150:0x0328 BREAK  A[LOOP:0: B:41:0x00c9->B:149:0x031c], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:268:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d1  */
    @SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(int i, boolean z, k kVar, int i2) {
        Random random;
        StringBuffer stringBuffer;
        StringBuilder sb;
        ArrayList<Long> arrayList;
        String str;
        int rssi;
        String strReplace;
        long jElapsedRealtimeNanos;
        boolean z2;
        int size;
        boolean z3;
        int i3;
        boolean z4;
        String str2;
        boolean z5;
        b bVar;
        String str3;
        boolean z6;
        b bVar2;
        Random random2;
        char c;
        boolean z7;
        long j;
        Random random3;
        char c2;
        boolean z8;
        Exception exc;
        b bVar3 = this;
        int i4 = i;
        if (kVar == null || kVar.a() < 1) {
            return null;
        }
        try {
            try {
                random = new Random();
                stringBuffer = new StringBuffer(512);
                sb = new StringBuilder();
                arrayList = new ArrayList();
                WifiInfo wifiInfoF = f();
                String strA = bVar3.a(wifiInfoF, (String) null);
                if (wifiInfoF == null || strA == null) {
                    str = null;
                    rssi = -1;
                    strReplace = null;
                } else {
                    strReplace = strA.replace(":", "");
                    rssi = wifiInfoF.getRssi();
                    String strI = a().i();
                    if (rssi < 0) {
                        rssi = -rssi;
                    }
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.i().a("wifi connected mac = " + strReplace);
                        g.i().a("wifi connected mac rssi= " + rssi);
                    }
                    str = strI;
                }
                try {
                    jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
                } catch (Error unused) {
                    jElapsedRealtimeNanos = 0;
                }
                z2 = jElapsedRealtimeNanos > 0;
                if (z2) {
                    z2 = z2 && z;
                }
                size = kVar.f3506a.size();
            } catch (Error e) {
                e = e;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (size > i4) {
            z3 = i4 < i2;
            String str4 = str;
            int i5 = rssi;
            long j2 = 0;
            i3 = 0;
            char c3 = 0;
            int i6 = 0;
            int i7 = 0;
            StringBuffer stringBuffer2 = null;
            int i8 = 0;
            z4 = true;
            while (true) {
                str2 = ";%d;";
                z5 = z3;
                if (i3 < i4) {
                    break;
                }
                i6++;
                int i9 = i4;
                if (kVar.f3506a.get(i3) == null || kVar.f3506a.get(i3).level == 0) {
                    bVar2 = bVar3;
                    random2 = random;
                    c = c3;
                    z7 = z2;
                } else {
                    if (z2) {
                        try {
                            try {
                                j = (jElapsedRealtimeNanos - kVar.f3506a.get(i3).timestamp) / 1000000;
                            } catch (Error e3) {
                                e = e3;
                                Throwable th = e;
                                if (com.baidu.location.c.b.a.c) {
                                }
                            }
                        } catch (Exception e4) {
                            if (com.baidu.location.c.b.a.c) {
                                e4.printStackTrace();
                            }
                            j = 0;
                        }
                        try {
                            boolean z9 = com.baidu.location.c.b.a.c;
                            if (z9 && com.baidu.location.c.b.a.d) {
                                z7 = z2;
                                e eVarI = g.i();
                                random3 = random;
                                StringBuilder sb2 = new StringBuilder();
                                c2 = c3;
                                sb2.append("wifi noUpdateTime = ");
                                sb2.append(j);
                                eVarI.a(sb2.toString());
                            } else {
                                random3 = random;
                                c2 = c3;
                                z7 = z2;
                            }
                            arrayList.add(Long.valueOf(j));
                            if (j > j2) {
                                if (z9) {
                                    g.i().a("wifi maxScanTime = " + j);
                                }
                                j2 = j;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            Throwable th2 = e;
                            if (com.baidu.location.c.b.a.c) {
                            }
                        }
                    } else {
                        random3 = random;
                        c2 = c3;
                        z7 = z2;
                    }
                    if (Build.VERSION.SDK_INT >= 23) {
                        try {
                            if (kVar.f3506a.get(i3).is80211mcResponder()) {
                                StringBuffer stringBuffer3 = stringBuffer2 == null ? new StringBuffer() : stringBuffer2;
                                try {
                                    stringBuffer3.append(i3);
                                    stringBuffer3.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                                    stringBuffer2 = stringBuffer3;
                                } catch (Throwable th3) {
                                    th = th3;
                                    stringBuffer2 = stringBuffer3;
                                    th.printStackTrace();
                                }
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    }
                    if (z4) {
                        stringBuffer.append("&wf=");
                        z4 = false;
                    } else {
                        stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                    }
                    String str5 = kVar.f3506a.get(i3).BSSID;
                    if (str5 != null) {
                        String strReplace2 = str5.replace(":", "");
                        stringBuffer.append(strReplace2);
                        sb.append(strReplace2);
                        int i10 = kVar.f3506a.get(i3).level;
                        if (i10 < 0) {
                            i10 = -i10;
                        }
                        String str6 = String.format(Locale.CHINA, ";%d;", Integer.valueOf(i10));
                        stringBuffer.append(str6);
                        sb.append(str6);
                        i7++;
                        if (strReplace == null || !strReplace.equals(strReplace2)) {
                            bVar2 = this;
                            z8 = false;
                        } else {
                            bVar2 = this;
                            try {
                                try {
                                    kVar.e = bVar2.a(kVar.f3506a.get(i3).capabilities);
                                    i8 = i7;
                                    z8 = true;
                                } catch (Error e6) {
                                    e = e6;
                                }
                            } catch (Exception e7) {
                                e = e7;
                            }
                        }
                        if (z8) {
                            random2 = random3;
                            c = c2;
                            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                                g.i().a("wifi str add connected ssid = " + kVar.f3506a.get(i3).SSID);
                            }
                            stringBuffer.append(bVar2.b(kVar.f3506a.get(i3).SSID));
                            sb.append(bVar2.b(kVar.f3506a.get(i3).SSID));
                        } else {
                            char c4 = 2;
                            if (c2 == 0) {
                                random2 = random3;
                                try {
                                    if (random2.nextInt(10) != 2 || kVar.f3506a.get(i3).SSID == null || kVar.f3506a.get(i3).SSID.length() >= 30) {
                                        c = c2;
                                        c4 = c;
                                        c3 = c4;
                                    } else {
                                        stringBuffer.append(bVar2.b(kVar.f3506a.get(i3).SSID));
                                        sb.append(bVar2.b(kVar.f3506a.get(i3).SSID));
                                        c4 = 1;
                                        c3 = c4;
                                    }
                                } catch (Exception e8) {
                                    exc = e8;
                                    c = c2;
                                    if (com.baidu.location.c.b.a.c) {
                                    }
                                    c3 = c;
                                }
                            } else {
                                random2 = random3;
                                c = c2;
                                if (c == 1) {
                                    try {
                                        if (random2.nextInt(20) != 1 || kVar.f3506a.get(i3).SSID == null || kVar.f3506a.get(i3).SSID.length() >= 30) {
                                            c4 = c;
                                        } else {
                                            stringBuffer.append(bVar2.b(kVar.f3506a.get(i3).SSID));
                                            sb.append(bVar2.b(kVar.f3506a.get(i3).SSID));
                                        }
                                        c3 = c4;
                                    } catch (Exception e9) {
                                        exc = e9;
                                        if (com.baidu.location.c.b.a.c) {
                                            exc.printStackTrace();
                                        }
                                        c3 = c;
                                    }
                                }
                            }
                            i3++;
                            bVar3 = bVar2;
                            random = random2;
                            z2 = z7;
                            z3 = z5;
                            i4 = i9;
                        }
                    } else {
                        bVar2 = this;
                        random2 = random3;
                        c = c2;
                    }
                }
                c3 = c;
                i3++;
                bVar3 = bVar2;
                random = random2;
                z2 = z7;
                z3 = z5;
                i4 = i9;
                Throwable th22 = e;
                if (com.baidu.location.c.b.a.c) {
                    return null;
                }
                th22.printStackTrace();
                return null;
            }
            int i11 = i4;
            bVar = bVar3;
            bVar.s = sb.toString();
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("last wifi str = " + bVar.s);
            }
            if (z5) {
                int i12 = i11;
                boolean z10 = true;
                while (i12 < kVar.f3506a.size()) {
                    int i13 = i6 + 1;
                    if (kVar.f3506a.get(i12) == null || kVar.f3506a.get(i12).level == 0) {
                        str3 = str2;
                    } else {
                        if (z10) {
                            stringBuffer.append("&wf2=");
                            z10 = false;
                        } else {
                            stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                        }
                        String str7 = kVar.f3506a.get(i12).BSSID;
                        if (str7 != null) {
                            stringBuffer.append(str7.replace(":", ""));
                            int i14 = kVar.f3506a.get(i12).level;
                            if (i14 < 0) {
                                i14 = -i14;
                            }
                            z6 = z10;
                            stringBuffer.append(String.format(Locale.CHINA, str2, Integer.valueOf(i14)));
                        } else {
                            z6 = z10;
                        }
                        str3 = str2;
                        if (i13 >= i2) {
                            break;
                        }
                        z10 = z6;
                    }
                    i12++;
                    str2 = str3;
                    i6 = i13;
                }
            }
            if (!z4) {
                return null;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("&wf_n=");
            int i15 = i8;
            sb3.append(i15);
            stringBuffer.append(sb3.toString());
            if (stringBuffer2 != null) {
                stringBuffer.append("&wf_mc=");
                stringBuffer.append(stringBuffer2.toString());
            }
            if (strReplace != null && i5 != -1) {
                stringBuffer.append("&wf_rs=" + i5);
            }
            if (j2 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                StringBuffer stringBuffer4 = new StringBuffer(128);
                stringBuffer4.append("&wf_ut=");
                Long l = (Long) arrayList.get(0);
                boolean z11 = true;
                for (Long l2 : arrayList) {
                    if (z11) {
                        stringBuffer4.append(l2.longValue());
                        z11 = false;
                    } else {
                        long jLongValue = l2.longValue() - l.longValue();
                        if (jLongValue != 0) {
                            stringBuffer4.append("");
                            stringBuffer4.append(jLongValue);
                        }
                    }
                    stringBuffer4.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.i().a("wifi scantime list str = " + stringBuffer4.toString());
                }
                stringBuffer.append(stringBuffer4.toString());
            }
            stringBuffer.append("&wf_st=");
            stringBuffer.append(kVar.b);
            stringBuffer.append("&wf_et=");
            stringBuffer.append(kVar.c);
            stringBuffer.append("&wf_vt=");
            stringBuffer.append(bVar.f3480a);
            if (i15 > 0) {
                kVar.d = true;
                stringBuffer.append("&wf_en=");
                stringBuffer.append(kVar.e ? 1 : 0);
            }
            if (str4 != null) {
                stringBuffer.append("&wf_gw=");
                stringBuffer.append(str4);
            }
            return stringBuffer.toString();
        }
        i4 = size;
        String str42 = str;
        int i52 = rssi;
        long j22 = 0;
        i3 = 0;
        char c32 = 0;
        int i62 = 0;
        int i72 = 0;
        StringBuffer stringBuffer22 = null;
        int i82 = 0;
        z4 = true;
        while (true) {
            str2 = ";%d;";
            z5 = z3;
            if (i3 < i4) {
            }
            Throwable th222 = e;
            if (com.baidu.location.c.b.a.c) {
            }
            i3++;
            bVar3 = bVar2;
            random = random2;
            z2 = z7;
            z3 = z5;
            i4 = i9;
        }
        int i112 = i4;
        bVar = bVar3;
        bVar.s = sb.toString();
        if (com.baidu.location.c.b.a.c) {
            g.i().a("last wifi str = " + bVar.s);
        }
        if (z5) {
        }
        if (!z4) {
        }
    }

    public void b() {
        if (this.b) {
            try {
                this.h.unregisterReceiver(this.f);
                this.f3480a = 0L;
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
            }
            this.f = null;
            this.e = null;
            this.b = false;
            if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                g.i().a("wifimanager stop ...");
            }
        }
    }

    public synchronized String a(WifiInfo wifiInfo, String str) {
        if (wifiInfo == null && str == null) {
            return null;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.m > 1000) {
            if (wifiInfo != null) {
                this.o = wifiInfo.getBSSID();
            } else {
                this.o = str;
            }
            this.m = jCurrentTimeMillis;
        }
        return this.o;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x01bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String a(k kVar, int i, String str, boolean z, int i2) {
        long jElapsedRealtimeNanos;
        String str2;
        String str3;
        int i3;
        int i4;
        int i5;
        String str4;
        boolean z2;
        long j;
        long j2;
        String str5 = str;
        if (kVar.a() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z3 = jElapsedRealtimeNanos > 0;
        StringBuffer stringBuffer = new StringBuffer(512);
        int size = kVar.f3506a.size();
        long j3 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z4 = true;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            if (i7 >= size) {
                str2 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                str3 = ";%d;";
                i3 = size;
                i4 = i8;
                i5 = i9;
                break;
            }
            i3 = size;
            if (kVar.f3506a.get(i7) == null || kVar.f3506a.get(i7).level == 0) {
                j = jElapsedRealtimeNanos;
            } else {
                int i10 = i6 + 1;
                if (z4) {
                    stringBuffer.append("&wf=");
                    z4 = false;
                } else {
                    stringBuffer.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
                }
                String strReplace = kVar.f3506a.get(i7).BSSID.replace(":", "");
                stringBuffer.append(strReplace);
                if (str5 != null && strReplace.equals(str5)) {
                    i9 = i10;
                }
                int i11 = kVar.f3506a.get(i7).level;
                if (i11 < 0) {
                    i11 = -i11;
                }
                Locale locale = Locale.CHINA;
                str2 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
                boolean z5 = z4;
                stringBuffer.append(String.format(locale, ";%d;", Integer.valueOf(i11)));
                i4 = i8 + 1;
                if (z3) {
                    try {
                        str3 = ";%d;";
                        try {
                            j2 = (jElapsedRealtimeNanos - kVar.f3506a.get(i7).timestamp) / 1000000;
                        } catch (Throwable th) {
                            th = th;
                            if (com.baidu.location.c.b.a.c) {
                                th.printStackTrace();
                            }
                            j2 = 0;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        str3 = ";%d;";
                    }
                    boolean z6 = com.baidu.location.c.b.a.c;
                    if (z6 && com.baidu.location.c.b.a.d) {
                        j = jElapsedRealtimeNanos;
                        g.i().a("wifi noUpdateTime = " + j2);
                    } else {
                        j = jElapsedRealtimeNanos;
                    }
                    arrayList.add(Long.valueOf(j2));
                    if (j2 > j3) {
                        if (z6 && com.baidu.location.c.b.a.d) {
                            g.i().a("wifi maxScanTime = " + j2);
                        }
                        j3 = j2;
                    }
                } else {
                    str3 = ";%d;";
                    j = jElapsedRealtimeNanos;
                }
                if (i4 > i) {
                    i5 = i9;
                    z4 = z5;
                    break;
                }
                i8 = i4;
                i6 = i10;
                z4 = z5;
            }
            i7++;
            str5 = str;
            size = i3;
            jElapsedRealtimeNanos = j;
        }
        if (z) {
            return stringBuffer.toString();
        }
        if (i5 > 0) {
            stringBuffer.append("&wf_n=");
            stringBuffer.append(i5);
        }
        if (i4 > i) {
            str4 = str2;
            if (i2 > i + 1) {
                int i12 = i4;
                int i13 = i3;
                while (i12 < i13) {
                    if (i12 == i4) {
                        stringBuffer.append("&wf2=");
                    } else {
                        stringBuffer.append(str4);
                    }
                    stringBuffer.append(kVar.f3506a.get(i12).BSSID.replace(":", ""));
                    int i14 = kVar.f3506a.get(i12).level;
                    if (i14 < 0) {
                        i14 = -i14;
                    }
                    Locale locale2 = Locale.CHINA;
                    z2 = true;
                    Object[] objArr = {Integer.valueOf(i14)};
                    String str6 = str3;
                    stringBuffer.append(String.format(locale2, str6, objArr));
                    if (i12 >= i2) {
                        break;
                    }
                    i12++;
                    str3 = str6;
                }
            }
            if (!z4) {
                return null;
            }
            if (j3 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                StringBuffer stringBuffer2 = new StringBuffer(128);
                stringBuffer2.append("&wf_ut=");
                Long l = (Long) arrayList.get(0);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    if (z2) {
                        stringBuffer2.append(jLongValue);
                        z2 = false;
                    } else {
                        long jLongValue2 = jLongValue - l.longValue();
                        if (jLongValue2 != 0) {
                            stringBuffer2.append("" + jLongValue2);
                        }
                    }
                    stringBuffer2.append(str4);
                }
                if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                    g.i().a("wifi scantime list str = " + stringBuffer2.toString());
                }
                stringBuffer.append(stringBuffer2.toString());
            }
            return stringBuffer.toString();
        }
        str4 = str2;
        z2 = true;
        if (!z4) {
        }
    }

    public void a(int i) {
        this.i.set(i);
    }

    public void a(Context context, List<String> list) {
        if (this.b) {
            return;
        }
        this.h = context;
        this.e = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        this.f = new C0064b();
        if (this.r == null) {
            this.r = new Handler(Looper.getMainLooper());
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        if (!list.contains("android.net.wifi.SCAN_RESULTS")) {
            list.add("android.net.wifi.SCAN_RESULTS");
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                this.h.registerReceiver(this.f, new IntentFilter(it.next()));
            }
        } catch (Exception e) {
            if (com.baidu.location.c.b.a.c) {
                e.printStackTrace();
            }
        }
        this.b = true;
        if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
            g.i().a("wifimanager start ...");
        }
    }

    public boolean a(k kVar, k kVar2) {
        List<ScanResult> list = kVar.f3506a;
        if (list == null || kVar2 == null || kVar2.f3506a == null) {
            return false;
        }
        int iMin = Math.min(list.size(), kVar2.f3506a.size());
        for (int i = 0; i < iMin; i++) {
            try {
                if (kVar.f3506a.get(i) != null) {
                    String str = kVar.f3506a.get(i).BSSID;
                    String str2 = kVar2.f3506a.get(i).BSSID;
                    if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                        return false;
                    }
                }
            } catch (Exception e) {
                if (com.baidu.location.c.b.a.c) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return true;
    }

    public static boolean a(k kVar, k kVar2, float f) {
        if (kVar != null && kVar2 != null) {
            List<ScanResult> list = kVar.f3506a;
            List<ScanResult> list2 = kVar2.f3506a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = list.get(i2) != null ? list.get(i2).BSSID : null;
                        if (str != null) {
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    break;
                                }
                                String str2 = list2.get(i3) != null ? list2.get(i3).BSSID : null;
                                if (str2 != null && str.equals(str2)) {
                                    i++;
                                    break;
                                }
                                i3++;
                            }
                        }
                    }
                    if (com.baidu.location.c.b.a.c && com.baidu.location.c.b.a.d) {
                        g.i().a("wifi same!" + (i / size));
                    }
                    if (i >= size * f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }
}
