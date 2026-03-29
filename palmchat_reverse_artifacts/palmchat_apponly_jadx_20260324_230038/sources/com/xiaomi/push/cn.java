package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class cn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f11476a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static cr f208a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f209a;

    public static void a(Context context, fa faVar) {
        if (m266a(context)) {
            if (f208a == null) {
                f208a = new cr(context);
            }
            faVar.a(f208a);
            a("startStats");
        }
    }

    public static void b(Context context, fa faVar) {
        cr crVar = f208a;
        if (crVar != null) {
            faVar.b(crVar);
            f208a = null;
            a("stopStats");
        }
    }

    private static synchronized void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = f209a;
            if (str2 == null || !str2.startsWith("W-")) {
                f209a = null;
            }
        } else {
            f209a = str;
        }
        a("updateNetId new networkId = " + str + ", finally netId = " + f209a);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m266a(Context context) {
        return ck.a(context);
    }

    public static void a(Context context, String str, int i) {
        if (!m266a(context)) {
            a("onDisconnection shouldSampling = false");
            return;
        }
        cq.a(context, str, au.b(context), System.currentTimeMillis(), i, com.xiaomi.push.service.m.a(context).m750b(), a(context), a(), f11476a);
        a("onDisconnection");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m265a(Context context) {
        if (!m266a(context)) {
            a("onReconnection shouldSampling = false");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        f11476a = a(context);
        cq.a(context, jCurrentTimeMillis);
        a("onReconnection connectedNetworkType = " + f11476a);
    }

    public static void a(Context context, String str) {
        if (!m266a(context)) {
            a("onWifiChanged shouldSampling = false");
            return;
        }
        a("onWifiChanged wifiDigest = " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b("W-" + str);
    }

    private static int a(Context context) {
        String str;
        try {
            av avVarM168a = au.m168a();
            if (avVarM168a != null) {
                if (avVarM168a.a() == 0) {
                    String strM180b = avVarM168a.m180b();
                    if (TextUtils.isEmpty(strM180b) || GrsBaseInfo.CountryCodeSource.UNKNOWN.equalsIgnoreCase(strM180b)) {
                        str = null;
                    } else {
                        str = "M-" + strM180b;
                    }
                    b(str);
                    return 0;
                }
                if (avVarM168a.a() != 1 && avVarM168a.a() != 6) {
                    b(null);
                    return -1;
                }
                b("WIFI-ID-UNKNOWN");
                return 1;
            }
            b(null);
            return -1;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("DisconnectStatsHelper getNetType occurred error: " + e.getMessage());
            b(null);
            return -1;
        }
    }

    private static synchronized String a() {
        return f209a;
    }

    public static void a(String str) {
        ck.a("Push-DiscntStats", str);
    }
}
