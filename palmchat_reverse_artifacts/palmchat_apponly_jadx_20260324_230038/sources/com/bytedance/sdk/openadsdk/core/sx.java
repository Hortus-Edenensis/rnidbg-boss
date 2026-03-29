package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.g;
import com.qq.gdt.action.ActionUtils;
import defpackage.qr6;
import defpackage.zx6;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class sx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile String f5369a = null;
    private static volatile String b = null;
    private static volatile WifiInfo bc = null;
    private static volatile boolean bf = false;
    private static volatile String bg = null;
    private static volatile boolean c = false;
    private static volatile boolean d = false;
    private static volatile String fx = null;
    private static volatile boolean gi = false;
    private static volatile boolean h = false;
    private static volatile String iz = null;
    private static volatile boolean ja = false;

    /* JADX INFO: renamed from: jp, reason: collision with root package name */
    private static volatile TelephonyManager f5370jp = null;
    private static volatile String k = null;
    private static volatile boolean kj = false;
    private static volatile boolean m = false;
    private static volatile String mv = null;
    private static volatile String my = null;
    private static volatile String nr = "";
    private static volatile String o;
    private static volatile String pb;
    private static volatile String pn;
    private static volatile boolean q;
    private static volatile boolean qq;
    private static volatile boolean rh;
    private static volatile String s;
    private static volatile String sx;
    private static String u;
    private static volatile String x;
    private static volatile long xg;
    private static volatile WifiManager y;
    private static volatile boolean z;
    private static AtomicBoolean n = new AtomicBoolean(false);
    private static volatile String jk = "";
    private static volatile String t = "";
    private static volatile boolean l = true;
    private static volatile String bq = null;
    private static AtomicBoolean dw = new AtomicBoolean(false);
    private static AtomicBoolean wq = new AtomicBoolean(false);

    public static String a() {
        if (!com.bytedance.sdk.openadsdk.core.b.u.n()) {
            return b("02:00:00:00:00:00");
        }
        new com.bytedance.sdk.openadsdk.core.b.nr("device_get_bssid").u(3).nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sx.4
            @Override // java.lang.Runnable
            public void run() {
                String unused = sx.x = sx.b("02:00:00:00:00:00");
            }
        });
        return TextUtils.isEmpty(x) ? "02:00:00:00:00:00" : x;
    }

    public static String b() {
        if (!TextUtils.isEmpty(sx)) {
            return sx;
        }
        String strValueOf = String.valueOf(Build.TIME);
        sx = strValueOf;
        return strValueOf;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    @SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static synchronized String bf() {
        Context context = dw.getContext();
        String string = null;
        if (context == null) {
            return null;
        }
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
            c = true;
        } catch (Exception unused) {
        }
        if (!TextUtils.isEmpty(string)) {
            if (string.length() < 13) {
                string = "";
            }
        }
        return string;
    }

    private static String d() {
        WifiInfo wifiInfoNr;
        if (kj) {
            return iz;
        }
        synchronized (sx.class) {
            if (kj) {
                return iz;
            }
            try {
                wifiInfoNr = nr();
            } catch (Throwable unused) {
            }
            if (wifiInfoNr == null) {
                return iz;
            }
            iz = wifiInfoNr.getSSID();
            kj = true;
            return iz;
        }
    }

    private static String gi() {
        if (gi) {
            return f5369a;
        }
        synchronized (sx.class) {
            if (gi) {
                return f5369a;
            }
            if (qq) {
                return pn;
            }
            TelephonyManager telephonyManagerU = u();
            if (telephonyManagerU == null) {
                return f5369a;
            }
            try {
                f5369a = telephonyManagerU.getSubscriberId();
            } catch (Throwable unused) {
            }
            gi = true;
            return f5369a;
        }
    }

    private static String h() {
        if (z) {
            return x;
        }
        synchronized (sx.class) {
            if (z) {
                return x;
            }
            x = a();
            z = true;
            return x;
        }
    }

    public static String iz() {
        if (!TextUtils.isEmpty(b)) {
            return b;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        if (bVarSx != null && d.fx >= 4600 && !bVarSx.iz()) {
            if (d.fx >= 4900) {
                return bVarSx.s();
            }
            return null;
        }
        if (c) {
            return b;
        }
        if (com.bytedance.sdk.openadsdk.core.b.u.n()) {
            String strX = com.bytedance.sdk.openadsdk.core.fx.b.u().x();
            if (!TextUtils.isEmpty(strX)) {
                b = strX;
                new com.bytedance.sdk.openadsdk.core.b.nr("device_get_android_id").u(5).nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sx.1
                    @Override // java.lang.Runnable
                    public void run() {
                        sx.kj();
                    }
                });
                return b;
            }
        }
        kj();
        return b;
    }

    private static synchronized void ja() {
        String strValueOf;
        String strValueOf2;
        if (m) {
            return;
        }
        if (Build.VERSION.SDK_INT < 22) {
            return;
        }
        synchronized (sx.class) {
            m = true;
            SubscriptionManager subscriptionManagerA = qr6.a(dw.getContext().getSystemService("telephony_subscription_service"));
            if (subscriptionManagerA.getActiveSubscriptionInfoCount() < 2) {
                return;
            }
            List activeSubscriptionInfoList = subscriptionManagerA.getActiveSubscriptionInfoList();
            if (activeSubscriptionInfoList.size() < 2) {
                return;
            }
            for (int i = 0; i < 2; i++) {
                SubscriptionInfo subscriptionInfoA = zx6.a(activeSubscriptionInfoList.get(i));
                if (Build.VERSION.SDK_INT >= 29) {
                    strValueOf = subscriptionInfoA.getMccString();
                    strValueOf2 = subscriptionInfoA.getMncString();
                } else {
                    strValueOf = String.valueOf(subscriptionInfoA.getMcc());
                    strValueOf2 = String.valueOf(subscriptionInfoA.getMnc());
                }
                if (i == 0) {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        mv = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        k = strValueOf2;
                    }
                } else {
                    if (!TextUtils.isEmpty(strValueOf)) {
                        s = strValueOf;
                    }
                    if (!TextUtils.isEmpty(strValueOf2)) {
                        my = strValueOf2;
                    }
                }
            }
        }
    }

    public static void jk() {
        TelephonyManager telephonyManagerU;
        if (qq) {
            return;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        if ((bVarSx == null || bVarSx.fx()) && com.bytedance.sdk.openadsdk.core.h.nr.u(dw.getContext(), g.c) == 0 && (telephonyManagerU = u()) != null) {
            synchronized (sx.class) {
                qq = true;
                if (TextUtils.isEmpty(pn)) {
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            pn = telephonyManagerU.getImei();
                        } else {
                            pn = telephonyManagerU.getDeviceId();
                        }
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.tools.nr.nr(6, pn);
                }
                if (TextUtils.isEmpty(f5369a)) {
                    try {
                        f5369a = telephonyManagerU.getSubscriberId();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    public static String k() {
        rh();
        return k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void kj() {
        synchronized (sx.class) {
            if (c) {
                return;
            }
            b = bf();
            com.bytedance.sdk.openadsdk.tools.nr.nr(9, b);
        }
    }

    public static boolean l() {
        if (h) {
            return l;
        }
        synchronized (sx.class) {
            if (h) {
                return l;
            }
            try {
                int simState = u().getSimState();
                if (1 == simState) {
                    l = false;
                }
                if (simState == 0) {
                    l = false;
                }
                h = true;
            } catch (Throwable unused) {
            }
            return l;
        }
    }

    public static String mv() {
        try {
            rh();
            if (!TextUtils.isEmpty(mv)) {
                return mv;
            }
            if (!u(xg, 60000L)) {
                return pb;
            }
            if (!l()) {
                return null;
            }
            int i = dw.getContext().getResources().getConfiguration().mcc;
            String strValueOf = i != 0 ? String.valueOf(i) : mv;
            pb = strValueOf;
            xg = System.currentTimeMillis();
            return strValueOf;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String my() {
        rh();
        return my;
    }

    public static String n() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        if (bVarSx != null && !bVarSx.fx()) {
            return null;
        }
        if (!TextUtils.isEmpty(bg)) {
            return bg;
        }
        if (ja) {
            return bg;
        }
        synchronized (sx.class) {
            if (ja) {
                return bg;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                try {
                    bg = Build.getSerial();
                } catch (Throwable unused) {
                }
            } else {
                bg = Build.SERIAL;
            }
            ja = true;
            return bg;
        }
    }

    public static String o() {
        rh();
        return o;
    }

    private static String pb() {
        if (bf) {
            return bq;
        }
        synchronized (sx.class) {
            if (bf) {
                return bq;
            }
            bq = xg();
            bf = true;
            return bq;
        }
    }

    public static boolean pn() {
        return c;
    }

    private static WifiManager qq() {
        if (y != null) {
            return y;
        }
        synchronized (sx.class) {
            if (y != null) {
                return y;
            }
            y = (WifiManager) dw.getContext().getApplicationContext().getSystemService("wifi");
            return y;
        }
    }

    private static void rh() {
        String strT;
        String simOperatorName;
        String strSubstring;
        if (rh) {
            return;
        }
        synchronized (sx.class) {
            if (rh) {
                return;
            }
            TelephonyManager telephonyManagerU = u();
            String strSubstring2 = null;
            try {
                strT = telephonyManagerU.getNetworkOperator();
            } catch (Throwable unused) {
                strT = null;
            }
            if (TextUtils.isEmpty(strT) || strT.length() < 5) {
                strT = t();
            }
            try {
                simOperatorName = telephonyManagerU.getSimOperatorName();
            } catch (Throwable unused2) {
                simOperatorName = null;
            }
            if (TextUtils.isEmpty(strT) || strT.length() <= 4) {
                strSubstring = null;
            } else {
                strSubstring2 = strT.substring(0, 3);
                strSubstring = strT.substring(3);
            }
            if (!TextUtils.isEmpty(strSubstring2)) {
                mv = strSubstring2;
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                k = strSubstring;
            }
            if (!TextUtils.isEmpty(simOperatorName)) {
                o = simOperatorName;
            }
            try {
                ja();
            } catch (Throwable unused3) {
            }
            rh = true;
        }
    }

    public static String s() {
        rh();
        return s;
    }

    public static String sx() {
        if (!TextUtils.isEmpty(nr)) {
            return nr;
        }
        String strU = com.bytedance.sdk.component.utils.z.u();
        nr = strU;
        return strU;
    }

    public static String t() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        if (bVarSx != null && !bVarSx.fx()) {
            return "";
        }
        if (!TextUtils.isEmpty(jk)) {
            return jk;
        }
        if (d) {
            return jk;
        }
        synchronized (sx.class) {
            if (d) {
                return jk;
            }
            TelephonyManager telephonyManagerU = u();
            if (telephonyManagerU == null) {
                return jk;
            }
            try {
                jk = telephonyManagerU.getSimOperator();
            } catch (Throwable unused) {
            }
            d = true;
            return jk;
        }
    }

    public static TelephonyManager u() {
        if (f5370jp != null) {
            return f5370jp;
        }
        synchronized (sx.class) {
            if (f5370jp != null) {
                return f5370jp;
            }
            f5370jp = (TelephonyManager) dw.getContext().getSystemService("phone");
            return f5370jp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wq() {
        String strU = com.bytedance.sdk.openadsdk.core.y.sx.u();
        if (TextUtils.isEmpty(strU)) {
            strU = "DU:MM:YA:DD:RE:SS";
        }
        com.bytedance.sdk.openadsdk.core.fx.b.u().b("mac_address", strU);
        com.bytedance.sdk.openadsdk.core.fx.b.u().b("new_mac_address", com.bytedance.sdk.component.utils.u.nr(strU));
        bq = strU;
    }

    public static String x() {
        if (!TextUtils.isEmpty(x) || z) {
            return x;
        }
        if (n.get()) {
            return null;
        }
        n.set(true);
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("") { // from class: com.bytedance.sdk.openadsdk.core.sx.3
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.core.y.jk.a();
                sx.n.set(false);
            }
        });
        return null;
    }

    private static String xg() {
        String strFx = null;
        try {
            String strFx2 = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("new_mac_address", "");
            if (!TextUtils.isEmpty(strFx2)) {
                JSONObject jSONObject = new JSONObject(strFx2);
                long j = jSONObject.getLong("time");
                strFx = com.bytedance.sdk.component.utils.u.fx(jSONObject.getString(ActionUtils.PAYMENT_AMOUNT));
                if (System.currentTimeMillis() - j <= 864000000) {
                    if (!TextUtils.isEmpty(strFx)) {
                        return strFx;
                    }
                }
            }
        } catch (Exception unused) {
        }
        if (com.bytedance.sdk.openadsdk.core.b.u.n()) {
            if (!TextUtils.isEmpty(bq)) {
                strFx = bq;
            }
            if (!TextUtils.isEmpty(strFx)) {
                if (!dw.get()) {
                    new com.bytedance.sdk.openadsdk.core.b.nr("device_get_macaddress").u(5).u(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sx.6
                        @Override // java.lang.Runnable
                        public void run() {
                            sx.dw.set(false);
                        }
                    }).nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sx.5
                        @Override // java.lang.Runnable
                        public void run() {
                            sx.dw.set(false);
                            sx.wq();
                        }
                    });
                }
                dw.set(true);
                return strFx;
            }
        }
        wq();
        return bq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z() {
        synchronized (sx.class) {
            if (q) {
                return;
            }
            if (qq) {
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.h.nr.u(dw.getContext(), g.c) == 0) {
                qq = true;
                TelephonyManager telephonyManagerU = u();
                if (telephonyManagerU == null) {
                    return;
                }
                try {
                    if (Build.VERSION.SDK_INT >= 26) {
                        pn = telephonyManagerU.getImei();
                    } else {
                        pn = telephonyManagerU.getDeviceId();
                    }
                } catch (Throwable unused) {
                }
                q = true;
                com.bytedance.sdk.openadsdk.tools.nr.nr(6, pn);
            }
        }
    }

    public static String fx() {
        if (!TextUtils.isEmpty(fx)) {
            return fx;
        }
        String str = nr.u().get("did", u);
        fx = str;
        return str;
    }

    public static WifiInfo nr() {
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        if (bVarSx != null && (!bVarSx.b() || !bVarSx.u())) {
            return bc;
        }
        if (bc != null) {
            return bc;
        }
        synchronized (sx.class) {
            if (bc != null) {
                return bc;
            }
            WifiManager wifiManagerQq = qq();
            if (wifiManagerQq == null) {
                return bc;
            }
            bc = wifiManagerQq.getConnectionInfo();
            return bc;
        }
    }

    public static String pn(Boolean bool) {
        if (!TextUtils.isEmpty(bq)) {
            return bq;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        if (bool == null) {
            if (bVarSx != null && !bVarSx.b()) {
                return bVarSx.t();
            }
        } else {
            if (bf) {
                return bq;
            }
            if (bVarSx != null && !bool.booleanValue()) {
                return bVarSx.t();
            }
        }
        return pb();
    }

    public static String b(Boolean bool) {
        if (!TextUtils.isEmpty(x)) {
            return x;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
            if (bVarSx != null && (!bVarSx.b() || !bVarSx.u())) {
                return null;
            }
        } else {
            if (z) {
                return x;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return h();
    }

    public static String fx(Boolean bool) {
        if (!TextUtils.isEmpty(iz)) {
            return iz;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
            if (bVarSx != null && (!bVarSx.b() || !bVarSx.u())) {
                return null;
            }
        } else {
            if (kj) {
                return iz;
            }
            if (bool.booleanValue()) {
                return null;
            }
        }
        return d();
    }

    public static void u(String str) {
        if (com.bytedance.sdk.openadsdk.u.u.u.u() != null) {
            com.bytedance.sdk.openadsdk.u.u.u.u().u(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(fx)) {
            return;
        }
        nr.u().put("did", str);
        fx = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        try {
            WifiInfo wifiInfoNr = nr();
            if (wifiInfoNr == null) {
                return str;
            }
            String bssid = wifiInfoNr.getBSSID();
            return TextUtils.isEmpty(bssid) ? str : bssid;
        } catch (Throwable unused) {
            return str;
        }
    }

    public static String u(Boolean bool) {
        if (!TextUtils.isEmpty(pn)) {
            return pn;
        }
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
        if (bool == null) {
            return u(bVarSx, bVarSx != null && bVarSx.fx());
        }
        if (q) {
            return pn;
        }
        return u(bVarSx, bool.booleanValue());
    }

    public static String nr(Boolean bool) {
        if (!TextUtils.isEmpty(f5369a)) {
            return f5369a;
        }
        if (bool == null) {
            com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = n.o().sx();
            if (bVarSx != null && !bVarSx.fx()) {
                return null;
            }
        } else if (!gi && !qq) {
            if (!bool.booleanValue()) {
                return null;
            }
        } else {
            return f5369a;
        }
        return gi();
    }

    private static String u(com.bytedance.sdk.openadsdk.my.fx.fx.b bVar, boolean z2) {
        if (bVar != null && !z2) {
            String strJk = bVar.jk();
            pn = strJk;
            com.bytedance.sdk.openadsdk.tools.nr.nr(6, strJk);
            return strJk;
        }
        if (q) {
            return pn;
        }
        if (com.bytedance.sdk.openadsdk.core.b.u.n()) {
            String strT = TextUtils.isEmpty(pn) ? com.bytedance.sdk.openadsdk.core.fx.b.u().t(null) : pn;
            if (!TextUtils.isEmpty(strT)) {
                new com.bytedance.sdk.openadsdk.core.b.nr("device_get_imei").u(5).nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.sx.2
                    @Override // java.lang.Runnable
                    public void run() {
                        sx.z();
                    }
                });
                return strT;
            }
        }
        z();
        return pn;
    }

    private static boolean u(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }
}
