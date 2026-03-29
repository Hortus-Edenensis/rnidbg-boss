package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.lantern.auth.server.WkParams;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.fg;
import com.xiaomi.push.gd;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile m f11758a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private long f983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final Context f984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final SharedPreferences f985a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final boolean f991b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    private final boolean f992c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final AtomicInteger f987a = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private String f986a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f988a = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f989b = null;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private final AtomicInteger f990b = new AtomicInteger(0);
    private final AtomicInteger c = new AtomicInteger(0);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f982a = -1;
    private long b = -1;
    private final boolean d = m746g();

    /* JADX INFO: compiled from: SearchBox */
    public static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String b() {
            return "record_support_wifi_digest_reported_time";
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }
    }

    private m(Context context) {
        this.f984a = context;
        this.f992c = com.xiaomi.push.j.m651a(context);
        this.f991b = ah.a(context).a(gk.IntelligentHeartbeatSwitchBoolean.a(), true);
        SharedPreferences sharedPreferences = context.getSharedPreferences("hb_record", 0);
        this.f985a = sharedPreferences;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (sharedPreferences.getLong(a.c(), -1L) == -1) {
            sharedPreferences.edit().putLong(a.c(), jCurrentTimeMillis).apply();
        }
        long j = sharedPreferences.getLong(a.i(), -1L);
        this.f983a = j;
        if (j == -1) {
            this.f983a = jCurrentTimeMillis;
            sharedPreferences.edit().putLong(a.i(), jCurrentTimeMillis).apply();
        }
    }

    private void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f986a;
            if (str2 == null || !str2.startsWith("W-")) {
                if (this.d) {
                    this.f986a = "W-NETWORK_ID_WIFI_DEFAULT";
                } else {
                    this.f986a = null;
                }
            }
        } else {
            this.f986a = str;
        }
        int i = this.f985a.getInt(a.a(this.f986a), -1);
        long j = this.f985a.getLong(a.b(this.f986a), -1L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (i != -1) {
            if (j == -1) {
                this.f985a.edit().putLong(a.b(this.f986a), jCurrentTimeMillis + d()).apply();
            } else if (jCurrentTimeMillis > j) {
                this.f985a.edit().remove(a.a(this.f986a)).remove(a.b(this.f986a)).apply();
            }
        }
        this.f987a.getAndSet(0);
        if (TextUtils.isEmpty(this.f986a) || a() != -1) {
            this.f988a = false;
        } else {
            this.f988a = true;
        }
        com.xiaomi.channel.commonutils.logger.b.m74a(String.format("[HB] network changed, netid:%s, %s", this.f986a, Boolean.valueOf(this.f988a)));
    }

    private void e() {
        if (this.f985a.getBoolean(a.a(), false)) {
            return;
        }
        this.f985a.edit().putBoolean(a.a(), true).apply();
    }

    private void f() {
        int i = this.f982a;
        String strH = i != 0 ? i != 1 ? null : a.h() : a.g();
        if (TextUtils.isEmpty(strH)) {
            return;
        }
        if (this.f985a.getLong(a.i(), -1L) == -1) {
            this.f983a = System.currentTimeMillis();
            this.f985a.edit().putLong(a.i(), this.f983a).apply();
        }
        this.f985a.edit().putInt(strH, this.f985a.getInt(strH, 0) + 1).apply();
    }

    private void g() {
        int i;
        String[] strArrSplit;
        String[] strArrSplit2;
        if (m742c()) {
            String string = this.f985a.getString(a.f(), null);
            char c = 1;
            char c2 = 0;
            if (!TextUtils.isEmpty(string) && (strArrSplit = string.split("###")) != null) {
                int i2 = 0;
                while (i2 < strArrSplit.length) {
                    if (!TextUtils.isEmpty(strArrSplit[i2]) && (strArrSplit2 = strArrSplit[i2].split(":::")) != null && strArrSplit2.length >= 4) {
                        String str = strArrSplit2[c2];
                        String str2 = strArrSplit2[c];
                        String str3 = strArrSplit2[2];
                        String str4 = strArrSplit2[3];
                        HashMap map = new HashMap();
                        map.put("event", "change");
                        map.put(WkParams.MODEL, com.xiaomi.push.k.a());
                        map.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, str2);
                        map.put("net_name", str);
                        map.put("interval", str3);
                        map.put("timestamp", str4);
                        a("category_hb_change", null, map);
                        com.xiaomi.channel.commonutils.logger.b.m74a("[HB] report hb changed events.");
                    }
                    i2++;
                    c = 1;
                    c2 = 0;
                }
                this.f985a.edit().remove(a.f()).apply();
            }
            if (this.f985a.getBoolean(a.a(), false)) {
                long j = this.f985a.getLong(a.b(), 0L);
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - j > 1296000000) {
                    HashMap map2 = new HashMap();
                    map2.put("event", "support");
                    map2.put(WkParams.MODEL, com.xiaomi.push.k.a());
                    map2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                    a("category_hb_change", null, map2);
                    com.xiaomi.channel.commonutils.logger.b.m74a("[HB] report support wifi digest events.");
                    this.f985a.edit().putLong(a.b(), jCurrentTimeMillis).apply();
                }
            }
            if (m744e()) {
                int i3 = this.f985a.getInt(a.d(), 0);
                int i4 = this.f985a.getInt(a.e(), 0);
                if (i3 > 0 || i4 > 0) {
                    long j2 = this.f985a.getLong(a.c(), -1L);
                    String strValueOf = String.valueOf(235000);
                    String strValueOf2 = String.valueOf(j2);
                    String strValueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("interval", strValueOf);
                        jSONObject.put("c_short", String.valueOf(i3));
                        jSONObject.put("c_long", String.valueOf(i4));
                        jSONObject.put("count", String.valueOf(i3 + i4));
                        jSONObject.put(com.umeng.analytics.pro.f.p, strValueOf2);
                        jSONObject.put(com.umeng.analytics.pro.f.q, strValueOf3);
                        String string2 = jSONObject.toString();
                        HashMap map3 = new HashMap();
                        map3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", string2, map3);
                        com.xiaomi.channel.commonutils.logger.b.m74a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f985a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m745f()) {
                String strValueOf4 = String.valueOf(this.f983a);
                String strValueOf5 = String.valueOf(System.currentTimeMillis());
                int i5 = this.f985a.getInt(a.g(), 0);
                if (i5 > 0) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, "M");
                        jSONObject2.put("ptc", i5);
                        jSONObject2.put(com.umeng.analytics.pro.f.p, strValueOf4);
                        jSONObject2.put(com.umeng.analytics.pro.f.q, strValueOf5);
                        String string3 = jSONObject2.toString();
                        HashMap map4 = new HashMap();
                        map4.put("event", "ptc_event");
                        a("category_lc_ptc", string3, map4);
                        com.xiaomi.channel.commonutils.logger.b.m74a("[HB] report ping timeout count events of mobile network.");
                        this.f985a.edit().putInt(a.g(), 0).apply();
                        i = 0;
                    } catch (Throwable unused2) {
                        i = 0;
                        this.f985a.edit().putInt(a.g(), 0).apply();
                    }
                } else {
                    i = 0;
                }
                int i6 = this.f985a.getInt(a.h(), i);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, "W");
                        jSONObject3.put("ptc", i6);
                        jSONObject3.put(com.umeng.analytics.pro.f.p, strValueOf4);
                        jSONObject3.put(com.umeng.analytics.pro.f.q, strValueOf5);
                        String string4 = jSONObject3.toString();
                        HashMap map5 = new HashMap();
                        map5.put("event", "ptc_event");
                        a("category_lc_ptc", string4, map5);
                        com.xiaomi.channel.commonutils.logger.b.m74a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f985a.edit().putInt(a.h(), 0).apply();
                }
                this.f983a = System.currentTimeMillis();
                this.f985a.edit().putLong(a.i(), this.f983a).apply();
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m748a() {
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public void m752c() {
        if (m743d()) {
            this.f989b = this.f986a;
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public void m753d() {
        if (m743d()) {
            g();
            if (this.f988a) {
                this.f987a.getAndSet(0);
            }
        }
    }

    public static m a(Context context) {
        if (f11758a == null) {
            synchronized (m.class) {
                if (f11758a == null) {
                    f11758a = new m(context);
                }
            }
        }
        return f11758a;
    }

    private long c() {
        return this.f985a.getLong(a.j(), -1L);
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    private boolean m744e() {
        long j = this.f985a.getLong(a.c(), -1L);
        if (j == -1) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        return j > jCurrentTimeMillis || jCurrentTimeMillis - j >= 259200000;
    }

    private void c(String str) {
        if (a(str)) {
            this.f985a.edit().putInt(a.a(str), 235000).apply();
            this.f985a.edit().putLong(a.b(this.f986a), System.currentTimeMillis() + d()).apply();
        }
    }

    private long d() {
        return ah.a(this.f984a).a(gk.ShortHeartbeatEffectivePeriodMsLong.a(), 7776000000L);
    }

    private void d(String str) {
        String str2;
        String string;
        if (m742c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = "W";
            } else if (!str.startsWith("M-")) {
                return;
            } else {
                str2 = "M";
            }
            String strValueOf = String.valueOf(235000);
            String strValueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(strValueOf);
            sb.append(":::");
            sb.append(strValueOf2);
            String string2 = this.f985a.getString(a.f(), null);
            if (TextUtils.isEmpty(string2)) {
                string = sb.toString();
            } else {
                string = string2 + "###" + sb.toString();
            }
            this.f985a.edit().putString(a.f(), string).apply();
        }
    }

    public synchronized void a(com.xiaomi.push.av avVar) {
        if (m743d()) {
            String str = null;
            if (avVar != null) {
                if (avVar.a() == 0) {
                    String strM180b = avVar.m180b();
                    if (!TextUtils.isEmpty(strM180b) && !GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(strM180b)) {
                        str = "M-" + strM180b;
                    }
                    b(str);
                    this.f982a = 0;
                } else if (avVar.a() != 1 && avVar.a() != 6) {
                    b(null);
                    this.f982a = -1;
                } else {
                    b("WIFI-ID-UNKNOWN");
                    this.f982a = 1;
                }
            } else {
                b(null);
                this.f982a = -1;
            }
        }
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    private boolean m742c() {
        return m743d() && ah.a(this.f984a).a(gk.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && com.xiaomi.push.n.China.name().equals(b.a(this.f984a).a());
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    private boolean m745f() {
        if (this.f983a == -1) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.f983a;
        return j > jCurrentTimeMillis || jCurrentTimeMillis - j >= 259200000;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m751b() {
        if (m743d()) {
            f();
            if (this.f988a && !TextUtils.isEmpty(this.f986a) && this.f986a.equals(this.f989b)) {
                this.f987a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m74a("[HB] ping timeout count:" + this.f987a);
                if (m741a()) {
                    com.xiaomi.channel.commonutils.logger.b.m74a("[HB] change hb interval for net:" + this.f986a);
                    c(this.f986a);
                    this.f988a = false;
                    this.f987a.getAndSet(0);
                    d(this.f986a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public synchronized void m749a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (m743d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    private boolean m743d() {
        return this.f992c && (this.f991b || this.d || ((c() > System.currentTimeMillis() ? 1 : (c() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    public void a(int i) {
        this.f985a.edit().putLong(a.j(), System.currentTimeMillis() + ((long) (i * 1000))).apply();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public long m750b() {
        return this.b;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m741a() {
        return this.f987a.get() >= Math.max(ah.a(this.f984a).a(gk.IntelligentHeartbeatNATCountInt.a(), 3), 3);
    }

    private boolean b() {
        if (!TextUtils.isEmpty(this.f986a)) {
            if (this.f986a.startsWith("M-")) {
                if (!ah.a(this.f984a).a(gk.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) {
                    return true;
                }
            } else if (this.f986a.equals("W-NETWORK_ID_WIFI_DEFAULT") && !m746g()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public long m747a() {
        int iA;
        long jB = fg.b();
        if (this.f992c && !b() && ((ah.a(this.f984a).a(gk.IntelligentHeartbeatSwitchBoolean.a(), true) || c() >= System.currentTimeMillis()) && (iA = a()) != -1)) {
            jB = iA;
        }
        if (!TextUtils.isEmpty(this.f986a) && !"WIFI-ID-UNKNOWN".equals(this.f986a) && this.f982a == 1) {
            a(jB < 300000);
        }
        this.b = jB;
        com.xiaomi.channel.commonutils.logger.b.m74a("[HB] ping interval:" + jB);
        return jB;
    }

    private int a() {
        if (TextUtils.isEmpty(this.f986a)) {
            return -1;
        }
        try {
            return this.f985a.getInt(a.a(this.f986a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private void a(boolean z) {
        String strE;
        if (m742c()) {
            int iIncrementAndGet = (z ? this.f990b : this.c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(iIncrementAndGet);
            com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (iIncrementAndGet >= 5) {
                if (z) {
                    strE = a.d();
                } else {
                    strE = a.e();
                }
                int i = this.f985a.getInt(strE, 0) + iIncrementAndGet;
                this.f985a.edit().putInt(strE, i).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i);
                com.xiaomi.channel.commonutils.logger.b.m74a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                if (z) {
                    this.f990b.set(0);
                } else {
                    this.c.set(0);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(String str, String str2, Map<String, String> map) {
        String str3;
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c("hb_name");
        gjVar.a("hb_channel");
        gjVar.a(1L);
        gjVar.b(str2);
        gjVar.a(false);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(this.f984a.getPackageName());
        gjVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        p pVarM765a = q.m765a(this.f984a);
        if (pVarM765a == null || TextUtils.isEmpty(pVarM765a.f1005a)) {
            str3 = null;
        } else {
            String[] strArrSplit = pVarM765a.f1005a.split("@");
            if (strArrSplit.length > 0) {
                str3 = strArrSplit[0];
            }
        }
        map.put(Constant.MAP_KEY_UUID, str3);
        map.put(WkParams.MODEL, com.xiaomi.push.k.a());
        Context context = this.f984a;
        map.put("avc", String.valueOf(com.xiaomi.push.g.a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(BuildConfig.VERSION_CODE));
        map.put("cvc", String.valueOf(48));
        gjVar.a(map);
        gd gdVarA = gd.a(this.f984a);
        if (gdVarA != null) {
            gdVarA.a(gjVar, this.f984a.getPackageName());
        }
    }

    /* JADX INFO: renamed from: g, reason: collision with other method in class */
    private boolean m746g() {
        return ah.a(this.f984a).a(gk.IntelligentHeartbeatForUnsupportWifiDigestBoolean.a(), true);
    }
}
