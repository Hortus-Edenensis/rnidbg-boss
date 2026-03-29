package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.opos.acs.st.STManager;
import com.wifi.adsdk.utils.LxAdMiuiDevice;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes12.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f11653a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static Map<String, n> f846a = null;
    private static int b = -1;

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m650a() {
        return a() == 1;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m654b() {
        return a() == 2;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public static boolean m655c() {
        if (b < 0) {
            b = !m657e() ? 1 : 0;
        }
        return b > 0;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public static boolean m656d() {
        return !n.China.name().equalsIgnoreCase(a(b()).name());
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public static boolean m657e() {
        String strA = "";
        try {
            strA = q.a(LxAdMiuiDevice.PROP_VERSION, "");
        } catch (Exception unused) {
        }
        return !TextUtils.isEmpty(strA);
    }

    public static int a() {
        if (f11653a == 0) {
            try {
                int i = 1;
                if (!((TextUtils.isEmpty(m648a(LxAdMiuiDevice.PROP_VERSION)) && TextUtils.isEmpty(m648a("ro.miui.ui.version.name"))) ? false : true)) {
                    i = 2;
                }
                f11653a = i;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a("get isMIUI failed", th);
                f11653a = 0;
            }
            com.xiaomi.channel.commonutils.logger.b.b("isMIUI's value is: " + f11653a);
        }
        return f11653a;
    }

    public static String b() {
        String strA = q.a("ro.miui.region", "");
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oppo.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.oppo.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.vendor.oplus.regionmark", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a(com.huawei.openalliance.ad.utils.n.Code, "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.csc.countryiso_code", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = m653b(q.a("ro.product.country.region", ""));
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("gsm.vivo.countrycode", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.oem.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("ro.product.locale.region", "");
        }
        if (TextUtils.isEmpty(strA)) {
            strA = q.a("persist.sys.country", "");
        }
        if (!TextUtils.isEmpty(strA)) {
            com.xiaomi.channel.commonutils.logger.b.m74a("get region from system, region = " + strA);
        }
        if (!TextUtils.isEmpty(strA)) {
            return strA;
        }
        String country = Locale.getDefault().getCountry();
        com.xiaomi.channel.commonutils.logger.b.m74a("locale.default.country = " + country);
        return country;
    }

    public static String d() {
        return m648a("ro.build.characteristics");
    }

    public static String e() {
        return m648a("ro.product.manufacturer");
    }

    public static String c() {
        return m648a("ro.miui.ui.version.name");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m647a() {
        int iA = C1401r.a();
        return (!m650a() || iA <= 0) ? "" : iA < 2 ? "alpha" : iA < 3 ? "development" : "stable";
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m648a(String str) {
        try {
            try {
                return (String) aw.a("android.os.SystemProperties", "get", str, "");
            } catch (Exception e) {
                com.xiaomi.channel.commonutils.logger.b.d("fail to get property. " + e);
                return null;
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m651a(Context context) {
        return context != null && m652a(context.getPackageName());
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m652a(String str) {
        return "com.xiaomi.xmsf".equals(str);
    }

    public static n a(String str) {
        n nVarB = b(str);
        return nVarB == null ? n.Global : nVarB;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static void m649a() {
        if (f846a != null) {
            return;
        }
        HashMap map = new HashMap();
        f846a = map;
        map.put("CN", n.China);
        Map<String, n> map2 = f846a;
        n nVar = n.Europe;
        map2.put("FI", nVar);
        f846a.put("SE", nVar);
        f846a.put("NO", nVar);
        f846a.put("FO", nVar);
        f846a.put("EE", nVar);
        f846a.put("LV", nVar);
        f846a.put("LT", nVar);
        f846a.put("BY", nVar);
        f846a.put("MD", nVar);
        f846a.put("UA", nVar);
        f846a.put("PL", nVar);
        f846a.put("CZ", nVar);
        f846a.put("SK", nVar);
        f846a.put("HU", nVar);
        f846a.put("DE", nVar);
        f846a.put("AT", nVar);
        f846a.put("CH", nVar);
        f846a.put("LI", nVar);
        f846a.put("GB", nVar);
        f846a.put("IE", nVar);
        f846a.put("NL", nVar);
        f846a.put("BE", nVar);
        f846a.put("LU", nVar);
        f846a.put("FR", nVar);
        f846a.put("RO", nVar);
        f846a.put("BG", nVar);
        f846a.put("RS", nVar);
        f846a.put("MK", nVar);
        f846a.put("AL", nVar);
        f846a.put("GR", nVar);
        f846a.put("SI", nVar);
        f846a.put("HR", nVar);
        f846a.put("IT", nVar);
        f846a.put("SM", nVar);
        f846a.put("MT", nVar);
        f846a.put("ES", nVar);
        f846a.put(AssistPushConsts.MSG_VALUE_PAYLOAD, nVar);
        f846a.put("AD", nVar);
        f846a.put("CY", nVar);
        f846a.put("DK", nVar);
        f846a.put("IS", nVar);
        f846a.put("UK", nVar);
        f846a.put("EL", nVar);
        f846a.put("RU", n.Russia);
        f846a.put(STManager.REGION_OF_IN, n.India);
    }

    private static n b(String str) {
        m649a();
        return f846a.get(str.toUpperCase());
    }

    public static int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode;
        } catch (Exception unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static String m653b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] strArrSplit = str.split("-");
        return strArrSplit.length > 0 ? strArrSplit[0] : str;
    }

    public static int a(Context context) {
        String strM648a = m648a(LxAdMiuiDevice.PROP_VERSION);
        if (TextUtils.isEmpty(strM648a) || !TextUtils.isDigitsOnly(strM648a)) {
            return 0;
        }
        return Integer.parseInt(strM648a);
    }

    public static String a(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.toString() + " " + a(intent.getExtras());
    }

    public static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder("Bundle[");
        if (bundle == null) {
            sb.append(com.igexin.push.core.b.m);
        } else {
            boolean z = true;
            for (String str : bundle.keySet()) {
                if (!z) {
                    sb.append(", ");
                }
                sb.append(str);
                sb.append('=');
                Object obj = bundle.get(str);
                if (obj instanceof int[]) {
                    sb.append(Arrays.toString((int[]) obj));
                } else if (obj instanceof byte[]) {
                    sb.append(Arrays.toString((byte[]) obj));
                } else if (obj instanceof boolean[]) {
                    sb.append(Arrays.toString((boolean[]) obj));
                } else if (obj instanceof short[]) {
                    sb.append(Arrays.toString((short[]) obj));
                } else if (obj instanceof long[]) {
                    sb.append(Arrays.toString((long[]) obj));
                } else if (obj instanceof float[]) {
                    sb.append(Arrays.toString((float[]) obj));
                } else if (obj instanceof double[]) {
                    sb.append(Arrays.toString((double[]) obj));
                } else if (obj instanceof String[]) {
                    sb.append(Arrays.toString((String[]) obj));
                } else if (obj instanceof CharSequence[]) {
                    sb.append(Arrays.toString((CharSequence[]) obj));
                } else if (obj instanceof Parcelable[]) {
                    sb.append(Arrays.toString((Parcelable[]) obj));
                } else if (obj instanceof Bundle) {
                    sb.append(a((Bundle) obj));
                } else {
                    sb.append(obj);
                }
                z = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
