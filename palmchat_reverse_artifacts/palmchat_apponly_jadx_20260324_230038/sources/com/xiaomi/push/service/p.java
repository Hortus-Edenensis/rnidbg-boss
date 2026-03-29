package com.xiaomi.push.service;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C1401r;
import com.xiaomi.push.s;
import com.xiaomi.push.service.am;
import java.util.Locale;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11767a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f1005a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public p(String str, String str2, String str3, String str4, String str5, String str6, int i) {
        this.f1005a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.f11767a = i;
    }

    private static boolean b(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    public am.b a(XMPushService xMPushService) {
        am.b bVar = new am.b(xMPushService);
        a(bVar, xMPushService, xMPushService.m689b(), "c");
        return bVar;
    }

    public am.b a(am.b bVar, Context context, h hVar, String str) {
        bVar.f936a = context.getPackageName();
        bVar.f939b = this.f1005a;
        bVar.h = this.c;
        bVar.c = this.b;
        bVar.g = "5";
        bVar.d = "XMPUSH-PASS";
        bVar.f938a = false;
        s.a aVar = new s.a();
        aVar.a(HiAnalyticsConstant.BI_KEY_SDK_VER, 48).a("cpvn", BuildConfig.VERSION_NAME).a("cpvc", Integer.valueOf(BuildConfig.VERSION_CODE)).a(com.huawei.openalliance.ad.constant.w.v, b.a(context).b()).a("region", b.a(context).a()).a("miui_vn", com.xiaomi.push.j.c()).a("miui_vc", Integer.valueOf(com.xiaomi.push.j.a(context))).a("xmsf_vc", Integer.valueOf(com.xiaomi.push.g.a(context, "com.xiaomi.xmsf"))).a("android_ver", Integer.valueOf(Build.VERSION.SDK_INT)).a("n_belong_to_app", Boolean.valueOf(af.m703a(context))).a("systemui_vc", Integer.valueOf(com.xiaomi.push.g.a(context)));
        String strA = a(context);
        if (!TextUtils.isEmpty(strA)) {
            aVar.a("latest_country_code", strA);
        }
        String strD = com.xiaomi.push.j.d();
        if (!TextUtils.isEmpty(strD)) {
            aVar.a("device_ch", strD);
        }
        String strE = com.xiaomi.push.j.e();
        if (!TextUtils.isEmpty(strE)) {
            aVar.a("device_mfr", strE);
        }
        bVar.e = aVar.toString();
        String str2 = b(context) ? "1000271" : this.d;
        s.a aVar2 = new s.a();
        aVar2.a("appid", str2).a("locale", Locale.getDefault().toString()).a("sync", 1);
        if (m764a(context)) {
            aVar2.a("ab", str);
        }
        bVar.f = aVar2.toString();
        bVar.f935a = hVar;
        return bVar;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m764a(Context context) {
        return "com.xiaomi.xmsf".equals(context.getPackageName()) && a();
    }

    public static boolean a() {
        try {
            return C1401r.a(null, "miui.os.Build").getField("IS_ALPHA_BUILD").getBoolean(null);
        } catch (Exception unused) {
            return false;
        }
    }

    private static String a(Context context) {
        if ("com.xiaomi.xmsf".equals(context)) {
            if (!TextUtils.isEmpty(null)) {
                return null;
            }
            String strM648a = com.xiaomi.push.j.m648a("ro.miui.region");
            return TextUtils.isEmpty(strM648a) ? com.xiaomi.push.j.m648a("ro.product.locale.region") : strM648a;
        }
        return com.xiaomi.push.j.b();
    }
}
