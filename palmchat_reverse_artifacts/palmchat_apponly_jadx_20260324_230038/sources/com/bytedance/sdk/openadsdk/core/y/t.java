package com.bytedance.sdk.openadsdk.core.y;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.wifi.WifiInfo;
import android.os.Build;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.sdk.component.utils.gi;
import com.bytedance.sdk.openadsdk.core.k.u.u.u;
import com.igexin.sdk.PushConsts;
import com.wifi.adsdk.utils.BLPlatform;
import defpackage.ht6;
import defpackage.tg7;
import defpackage.ts6;
import defpackage.ug7;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class t {
    private static volatile boolean b = false;
    private static volatile long bq = 0;
    private static String fx = null;
    private static volatile boolean iz = false;
    private static volatile long k = 0;
    private static volatile nr kj = null;
    private static volatile long my = 0;
    private static volatile boolean pn = false;
    private static volatile b qq;
    private static volatile long sx;
    private static volatile com.bytedance.sdk.openadsdk.core.k.u.u.u z;
    private static AtomicBoolean x = new AtomicBoolean(false);
    private static AtomicInteger n = new AtomicInteger(-1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile boolean f5414a = true;
    private static long jk = 0;
    private static volatile int t = -1;
    private static volatile int l = -1;
    private static volatile String mv = null;
    private static volatile String s = null;
    private static volatile float o = -2.0f;
    private static volatile int bg = -1;
    private static volatile long dw = -1;
    private static volatile long c = System.currentTimeMillis();
    public static final AtomicLong u = new AtomicLong();
    private static volatile int q = -1;
    public static int nr = -1;
    private static long gi = 0;
    private static long d = 0;

    /* JADX INFO: compiled from: SearchBox */
    public static class b extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            com.bytedance.sdk.component.utils.jk.nr().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.t.b.1
                @Override // java.lang.Runnable
                public void run() {
                    b.this.u(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(final Intent intent) {
            if ("android.intent.action.SCREEN_ON".equals(intent.getAction())) {
                boolean unused = t.f5414a = true;
                return;
            }
            if (!"android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                if (PushConsts.ACTION_BROADCAST_USER_PRESENT.equals(intent.getAction())) {
                    long unused2 = t.c = System.currentTimeMillis();
                }
            } else {
                boolean unused3 = t.f5414a = false;
                if (com.bytedance.sdk.openadsdk.core.n.o().ja()) {
                    return;
                }
                com.bytedance.sdk.openadsdk.gi.x.u(new com.bytedance.sdk.component.jk.a("updateScreenStatus") { // from class: com.bytedance.sdk.openadsdk.core.y.t.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.sdk.component.b.u uVarNr = kj.nr();
                        if (uVarNr != null) {
                            uVarNr.updateScreenStatus(intent.getAction());
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class fx implements gi.u {
        @Override // com.bytedance.sdk.component.utils.gi.u
        public void u(Context context, Intent intent, boolean z, int i) {
            if (t.n.get() == i) {
                return;
            }
            t.n.set(i);
            sx.u.set(true);
            sx.nr.set(true);
            t.x.set(true);
            com.bytedance.sdk.component.b.u uVarNr = kj.nr();
            if (com.bytedance.sdk.openadsdk.core.n.o().ja() || uVarNr == null) {
                return;
            }
            uVarNr.updateNetworkStatus(i);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class nr extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, final Intent intent) {
            if (intent == null) {
                return;
            }
            com.bytedance.sdk.component.utils.jk.fx().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.t.nr.1
                @Override // java.lang.Runnable
                public void run() {
                    nr.this.u(intent);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(Intent intent) {
            int intExtra = -1;
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                boolean booleanExtra = intent.getBooleanExtra("present", false);
                if (booleanExtra) {
                    int intExtra2 = intent.getIntExtra("status", -1);
                    if (intExtra2 == -1) {
                        u.u = intExtra2;
                    } else if (intExtra2 == 2) {
                        u.u = 1;
                    } else {
                        u.u = 0;
                    }
                } else {
                    u.u = 2;
                }
                u.nr = (intent.getIntExtra("level", -1) * 100) / intent.getIntExtra("scale", -1);
                if (!com.bytedance.sdk.openadsdk.core.n.o().ja()) {
                    com.bytedance.sdk.openadsdk.u.nr.nr.u(booleanExtra);
                }
            }
            try {
                intExtra = intent.getIntExtra("android.media.EXTRA_VOLUME_STREAM_TYPE", -1);
            } catch (Exception unused) {
            }
            if (com.huawei.openalliance.ad.constant.x.cm.equals(intent.getAction()) && intExtra == 3) {
                com.bytedance.sdk.component.utils.jk.u().post(new com.bytedance.sdk.component.jk.a("tt_vol") { // from class: com.bytedance.sdk.openadsdk.core.y.t.nr.2
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.dw.getContext().getSystemService("audio");
                            if (audioManager == null) {
                                return;
                            }
                            int streamVolume = audioManager.getStreamVolume(3);
                            if (streamVolume != t.q) {
                                com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(streamVolume);
                            }
                            if (t.q != -1) {
                                int i = streamVolume == 0 ? 0 : streamVolume - t.q > 0 ? 2 : 1;
                                long jCurrentTimeMillis = System.currentTimeMillis();
                                if (jCurrentTimeMillis - t.d > 1000) {
                                    com.bytedance.sdk.openadsdk.core.qq.s.u(i, -1);
                                }
                                long unused2 = t.d = jCurrentTimeMillis;
                            }
                            int unused3 = t.q = streamVolume;
                        } catch (Exception unused4) {
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class u {
        static float nr = 0.0f;
        static int u = -1;

        public static float nr(Context context) {
            com.bytedance.sdk.openadsdk.u.nr.nr.nr(context);
            return nr;
        }

        public static int u(Context context) {
            com.bytedance.sdk.openadsdk.u.nr.nr.u(context);
            return u;
        }
    }

    public static void a() {
        try {
            if (pn && kj != null) {
                com.bytedance.sdk.openadsdk.core.dw.getContext().getApplicationContext().unregisterReceiver(kj);
            }
        } catch (Throwable unused) {
        }
    }

    public static String iz() {
        String languageTag = Locale.getDefault().toLanguageTag();
        return !TextUtils.isEmpty(languageTag) ? languageTag : "";
    }

    public static int jk() {
        if (bg != -1 && !u(bq, 60000L)) {
            return bg;
        }
        AccessibilityManager accessibilityManager = (AccessibilityManager) com.bytedance.sdk.openadsdk.core.dw.getContext().getSystemService("accessibility");
        if (accessibilityManager == null) {
            return -1;
        }
        bg = accessibilityManager.isEnabled() ? 1 : 0;
        bq = System.currentTimeMillis();
        return bg;
    }

    public static int l() {
        return (int) (com.bytedance.sdk.openadsdk.core.dw.getContext().getResources().getConfiguration().fontScale * 16.0f);
    }

    public static long mv() {
        return dw != -1 ? dw : com.bytedance.sdk.openadsdk.core.fx.b.u().nr("dev19", -1L);
    }

    public static void n() {
        if (iz && z != null) {
            z.nr();
        }
    }

    public static void pn() {
        try {
            if (b && qq != null) {
                com.bytedance.sdk.openadsdk.core.dw.getContext().getApplicationContext().unregisterReceiver(qq);
            }
        } catch (Throwable unused) {
        }
    }

    public static int s() {
        if (q >= 0) {
            return q;
        }
        try {
            AudioManager audioManager = (AudioManager) com.bytedance.sdk.openadsdk.core.dw.getContext().getSystemService("audio");
            if (audioManager == null) {
                return 0;
            }
            int streamVolume = audioManager.getStreamVolume(3);
            com.bytedance.sdk.openadsdk.core.k.u.fx.u().nr(streamVolume);
            q = streamVolume;
            return q;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void t() {
        Context context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        if (context != null) {
            int iMv = jp.mv();
            com.bytedance.sdk.openadsdk.core.fx.b.u().u("cpu_cnt", iMv);
            jp.u = iMv;
            int iFx = jp.fx(jp.mv());
            com.bytedance.sdk.openadsdk.core.fx.b.u().u("cpu_max_freq", iFx);
            jp.nr = iFx;
            int iB = jp.b(jp.mv());
            com.bytedance.sdk.openadsdk.core.fx.b.u().u("cpu_min_freq", iB);
            jp.fx = iB;
            String strB = jp.b(context, BLPlatform.MEMTOTAL);
            if (strB != null) {
                com.bytedance.sdk.openadsdk.core.fx.b.u().nr("total_memory", strB);
                jp.b = strB;
            }
            long jSx = jp.sx();
            com.bytedance.sdk.openadsdk.core.fx.b.u().u("internal_storage", jSx);
            jp.pn = jSx;
            long jU = com.bytedance.sdk.component.utils.my.u();
            com.bytedance.sdk.openadsdk.core.fx.b.u().u("free_storage", jU);
            jp.iz = jU;
            long jDw = jp.dw();
            com.bytedance.sdk.openadsdk.core.fx.b.u().u("sdcard_storage", jDw);
            jp.x = jDw;
            boolean zQ = jp.q();
            com.bytedance.sdk.openadsdk.core.fx.b.u().u("is_root", zQ ? 1 : 0);
            jp.n = zQ ? 1 : 0;
        }
    }

    public static float x() {
        if (o != -2.0f && !u(sx, 30000L)) {
            return o;
        }
        int i = -1;
        try {
            Context context = com.bytedance.sdk.openadsdk.core.dw.getContext();
            if (context != null) {
                i = Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr("DeviceUtils", th.getMessage());
        }
        if (i < 0) {
            o = -1.0f;
        } else {
            o = Math.round((i / 255.0f) * 10.0f) / 10.0f;
        }
        sx = System.currentTimeMillis();
        return o;
    }

    public static int b() {
        if (t == -1 || x.getAndSet(false)) {
            t = com.bytedance.sdk.component.utils.o.nr(com.bytedance.sdk.openadsdk.core.dw.getContext());
        }
        return t;
    }

    public static void fx() {
        n.set(com.bytedance.sdk.component.utils.o.fx(com.bytedance.sdk.openadsdk.core.dw.getContext()));
        b();
        x();
        jk();
        u(0);
        u(1);
        jk.nr(false);
        sx.u((String) null);
    }

    public static boolean u() {
        if (!f5414a && SystemClock.elapsedRealtime() - jk >= 10000) {
            jk = SystemClock.elapsedRealtime();
            try {
                PowerManager powerManager = (PowerManager) com.bytedance.sdk.openadsdk.core.dw.getContext().getSystemService("power");
                if (powerManager != null) {
                    f5414a = powerManager.isInteractive();
                }
            } catch (Throwable unused) {
            }
        }
        return f5414a;
    }

    public static void iz(Context context) {
        com.bytedance.sdk.component.utils.gi.u(new fx(), context);
    }

    public static long nr() {
        return c;
    }

    public static boolean nr(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean pn(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness_mode") == 1;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void b(Context context) {
        if (!pn) {
            try {
                kj = new nr();
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
                intentFilter.addAction(com.huawei.openalliance.ad.constant.x.cm);
                context.getApplicationContext().registerReceiver(kj, intentFilter);
                pn = true;
            } catch (Throwable unused) {
            }
        }
        if (iz) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.k.u.u.u uVar = new com.bytedance.sdk.openadsdk.core.k.u.u.u(com.bytedance.sdk.openadsdk.core.dw.getContext(), com.bytedance.sdk.component.utils.jk.nr(), new u.InterfaceC0267u() { // from class: com.bytedance.sdk.openadsdk.core.y.t.1
            @Override // com.bytedance.sdk.openadsdk.core.k.u.u.u.InterfaceC0267u
            public void u(int i) {
                boolean zPn = t.pn(com.bytedance.sdk.openadsdk.core.dw.getContext());
                int i2 = t.nr;
                if (i2 == -1) {
                    t.nr = i;
                    return;
                }
                int i3 = i2 - i;
                t.nr = i;
                if (!zPn) {
                    if (i != -1) {
                        com.bytedance.sdk.openadsdk.core.qq.s.u(-1, i3 > 0 ? 1 : 2);
                    }
                    com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(true);
                } else if (Math.abs(i3) > 20) {
                    int i4 = i3 > 0 ? 1 : 2;
                    com.bytedance.sdk.openadsdk.core.k.u.fx.u().u(true);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - t.gi > 1000) {
                        com.bytedance.sdk.openadsdk.core.qq.s.u(-1, i4);
                    }
                    long unused2 = t.gi = jCurrentTimeMillis;
                }
            }
        });
        z = uVar;
        uVar.u();
        iz = true;
    }

    private static void nr(JSONObject jSONObject) {
        try {
            jSONObject.put("package_name", jp.a());
            jSONObject.put("version_code", jp.jk());
            jSONObject.put("version", jp.t());
        } catch (Exception unused) {
        }
    }

    public static void u(Context context) {
        if (b) {
            return;
        }
        try {
            PowerManager powerManager = (PowerManager) context.getSystemService("power");
            if (powerManager != null) {
                f5414a = powerManager.isScreenOn();
            }
        } catch (Throwable unused) {
        }
        try {
            qq = new b();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction(PushConsts.ACTION_BROADCAST_USER_PRESENT);
            context.getApplicationContext().registerReceiver(qq, intentFilter);
            b = true;
        } catch (Throwable unused2) {
        }
    }

    public static boolean fx(Context context) {
        try {
            return (context.getResources().getConfiguration().uiMode & 15) == 4;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static String fx(int i) {
        List<CellInfo> allCellInfo;
        int dbm;
        WifiInfo wifiInfoNr;
        int iFx = com.bytedance.sdk.component.utils.o.fx(com.bytedance.sdk.openadsdk.core.dw.getContext());
        com.bytedance.sdk.openadsdk.my.fx.fx.b bVarSx = com.bytedance.sdk.openadsdk.core.n.o().sx();
        if (iFx == 4) {
            if (i == 0) {
                try {
                    if (!bVarSx.b() || (wifiInfoNr = com.bytedance.sdk.openadsdk.core.sx.nr()) == null) {
                        return "unknown";
                    }
                    return wifiInfoNr.getRssi() + "dBm";
                } catch (Throwable unused) {
                }
            }
            return "unknown";
        }
        if (bVarSx.fx() && bVarSx.u() && i == 1) {
            try {
                if (com.bytedance.sdk.openadsdk.core.sx.l()) {
                    TelephonyManager telephonyManagerU = com.bytedance.sdk.openadsdk.core.sx.u();
                    int i2 = Build.VERSION.SDK_INT;
                    if (telephonyManagerU == null || (allCellInfo = telephonyManagerU.getAllCellInfo()) == null) {
                        return "unknown";
                    }
                    CellInfo cellInfo = allCellInfo.get(0);
                    if (cellInfo instanceof CellInfoGsm) {
                        dbm = ((CellInfoGsm) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoCdma) {
                        dbm = ((CellInfoCdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoLte) {
                        dbm = ((CellInfoLte) cellInfo).getCellSignalStrength().getDbm();
                    } else if (cellInfo instanceof CellInfoWcdma) {
                        dbm = ((CellInfoWcdma) cellInfo).getCellSignalStrength().getDbm();
                    } else if (i2 >= 29 && tg7.a(cellInfo)) {
                        dbm = ug7.a(cellInfo).getCellSignalStrength().getDbm();
                    } else if (i2 >= 29 && ts6.a(cellInfo)) {
                        dbm = ht6.a(cellInfo).getCellSignalStrength().getDbm();
                    }
                    if (Integer.MIN_VALUE == dbm) {
                        return "unknown";
                    }
                    return dbm + "dBm";
                }
            } catch (Throwable unused2) {
            }
        }
        return "unknown";
    }

    public static int u(Context context, boolean z2) {
        if (l != -1) {
            return l;
        }
        if (z2) {
            String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("dev06", 2592000000L);
            try {
                if (!TextUtils.isEmpty(strFx)) {
                    l = Integer.parseInt(strFx);
                }
            } catch (Exception unused) {
            }
            if (l != -1) {
                return l;
            }
        }
        if (fx(context)) {
            l = 3;
        } else if (nr(context)) {
            l = 2;
        } else {
            l = 1;
        }
        if (z2) {
            com.bytedance.sdk.openadsdk.core.fx.b.u().b("dev06", String.valueOf(l));
        }
        return l;
    }

    public static void u(JSONObject jSONObject) throws JSONException {
        if (s.nr()) {
            jSONObject.putOpt("os_new", "harmony");
            jSONObject.putOpt("harmonyos_api", s.pn());
            jSONObject.putOpt("harmonyos_version", s.iz());
            jSONObject.putOpt("harmonyos_release_type", s.x());
            jSONObject.putOpt("harmonyos_build_version", s.n());
            jSONObject.putOpt("pure_mode", Integer.valueOf(s.u(com.bytedance.sdk.openadsdk.core.dw.getContext()) ? 1 : 2));
        } else {
            jSONObject.putOpt("os_new", "android");
        }
        jSONObject.putOpt("rom_name", Build.BRAND);
    }

    public static String u(int i) {
        if (i == 0 && !TextUtils.isEmpty(mv) && !u(k, 60000L)) {
            return mv;
        }
        if (i == 1 && !TextUtils.isEmpty(s) && !u(my, 60000L)) {
            return s;
        }
        String strFx = fx(i);
        if (i == 0) {
            mv = strFx;
            k = System.currentTimeMillis();
        } else if (i == 1) {
            s = strFx;
            my = System.currentTimeMillis();
        }
        return strFx;
    }

    public static boolean u(long j, long j2) {
        return System.currentTimeMillis() - j > j2;
    }

    public static JSONObject u(int i, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", com.bytedance.sdk.openadsdk.core.n.o().c());
            jSONObject.put("name", com.bytedance.sdk.openadsdk.core.n.o().q());
            nr(jSONObject);
            com.bytedance.sdk.openadsdk.k.nr.u(jSONObject, i);
            jSONObject.put("is_paid_app", com.bytedance.sdk.openadsdk.core.n.o().qq());
            if (!com.bytedance.sdk.openadsdk.core.fx.b.u().x(i)) {
                jSONObject.put("network_speed", com.bytedance.sdk.openadsdk.core.gi.u.u());
            }
            jSONObject.put("apk_sign", com.bytedance.sdk.openadsdk.core.n.u.n());
            jSONObject.put("useful_open_sdk", com.bytedance.sdk.openadsdk.core.nr.u.nr.b.fx().nr());
            jSONObject.put("real_app_name", com.bytedance.sdk.openadsdk.core.n.u.nr(com.bytedance.sdk.openadsdk.core.dw.getContext()));
            jSONObject.put("app_cold_startup_time", com.bytedance.sdk.openadsdk.core.k.fx.pn().fx());
            jSONObject.put("sdk_init_timestamp", com.bytedance.sdk.openadsdk.core.k.fx.pn().b());
            if (z2) {
                jSONObject.put("session_ad_index", u.addAndGet(1L));
                if (com.bytedance.sdk.openadsdk.core.dw.nr().lk()) {
                    long jFx = com.bytedance.sdk.openadsdk.core.k.u.fx();
                    jSONObject.put("app_total_7_duration", com.bytedance.sdk.openadsdk.core.k.u.b() + jFx);
                    jSONObject.put("app_use_7_duration", jFx);
                    jSONObject.put("start_session", com.bytedance.sdk.openadsdk.core.k.u.pn());
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static void u(long j) {
        if (j == -1 || dw == j) {
            return;
        }
        dw = j;
        com.bytedance.sdk.openadsdk.core.fx.b.u().u("dev19", j);
    }
}
