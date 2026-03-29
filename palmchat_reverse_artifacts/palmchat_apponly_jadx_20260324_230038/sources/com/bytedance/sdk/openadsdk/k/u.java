package com.bytedance.sdk.openadsdk.k;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.a.b.pn;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.jk.t;
import com.bytedance.sdk.component.jk.x;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.iz;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.gi;
import com.bytedance.sdk.openadsdk.core.y.ja;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.ads.ex;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.cf7;
import defpackage.gm7;
import defpackage.ij7;
import defpackage.li7;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static String fx() {
        try {
            Function<SparseArray<Object>, Object> functionV = n.o().v();
            if (functionV == null) {
                return null;
            }
            Object objApply = functionV.apply(com.bytedance.sdk.openadsdk.my.b.u().u(8).u(String.class).u(0, "com.byted.pangle").nr());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    private static void nr(final Context context) {
        gm7.e(new cf7() { // from class: com.bytedance.sdk.openadsdk.k.u.1
            @Override // defpackage.cf7
            public boolean u(final Throwable th, final Thread thread) {
                try {
                    t.nr.x(com.bytedance.sdk.openadsdk.core.xg.u.u);
                    if (!u.nr(th, null)) {
                        return false;
                    }
                    x.nr(new a("tt_crash_handle") { // from class: com.bytedance.sdk.openadsdk.k.u.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ja.u().u(thread, th);
                        }
                    });
                    return true;
                } catch (Throwable unused) {
                    return false;
                }
            }

            @Override // defpackage.cf7
            public boolean u() {
                try {
                    return u.nr(null, Looper.getMainLooper().getThread());
                } catch (Throwable unused) {
                    return false;
                }
            }
        });
        boolean z = false;
        boolean z2 = new SecureRandom().nextInt(10) == 0;
        Context applicationContext = context.getApplicationContext();
        ij7 ij7Var = new ij7() { // from class: com.bytedance.sdk.openadsdk.k.u.2
            @Override // defpackage.ij7
            public String b() {
                return null;
            }

            @Override // defpackage.ij7
            public String fx() {
                return iz.u().b();
            }

            @Override // defpackage.ij7
            public List<String> iz() {
                return null;
            }

            @Override // defpackage.ij7
            public String nr() {
                String strFx = sx.fx();
                return TextUtils.isEmpty(strFx) ? "0" : strFx;
            }

            @Override // defpackage.ij7
            public Map<String, Integer> pn() {
                return null;
            }

            @Override // defpackage.ij7
            public Map<String, Object> u() {
                HashMap map = new HashMap();
                String strO = jk.o();
                if (TextUtils.isEmpty(strO)) {
                    strO = sx.fx();
                }
                if (!TextUtils.isEmpty(strO)) {
                    map.put("device_id", strO);
                }
                map.put(OapsKey.KEY_ACTIVE_CODE, pn.fx(context));
                map.put("aid", iz.u().iz());
                map.put("app_name", iz.u().x());
                String strT = jp.t();
                if (!TextUtils.isEmpty(strT)) {
                    map.put("app_version", strT);
                }
                String strJk = jp.jk();
                if (!TextUtils.isEmpty(strJk)) {
                    map.put("version_code", strJk);
                    try {
                        map.put("update_version_code", Integer.valueOf(strJk));
                    } catch (Exception e) {
                        map.put("update_version_code", 0);
                        e.getMessage();
                    }
                }
                map.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, "7.2.3.2");
                map.put("sdk_api_version", d.b);
                map.put("device_platform", "android");
                map.put("os", AnalyticsConstants.SDK_TYPE);
                String strNr = jk.nr();
                map.put(bt.ac, strNr);
                map.put("device_mode", strNr);
                map.put("rom", gi.u());
                map.put("cpu_abi", Build.CPU_ABI);
                map.put(bt.F, Build.BRAND);
                map.put("channel", d.pn());
                map.put("language", Locale.getDefault().getLanguage());
                map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
                try {
                    String strSubstring = Build.VERSION.RELEASE;
                    if (strSubstring != null && strSubstring.length() > 10) {
                        strSubstring = strSubstring.substring(0, 10);
                    }
                    map.put("os_version", strSubstring);
                } catch (Exception unused) {
                }
                map.put("openudid", jk.u());
                map.put("dpi", String.valueOf(y.n(context)));
                map.put("resolution", y.b(context) + "*" + y.pn(context));
                return map;
            }

            @Override // defpackage.ij7
            public Map<String, Object> x() {
                HashMap map = new HashMap();
                String strC = n.o().c();
                if (TextUtils.isEmpty(strC)) {
                    strC = String.valueOf(iz.u().iz());
                }
                map.put("host_appid", strC);
                map.put("sdk_version", "7.2.3.2");
                map.put(PluginConstants.KEY_PLUGIN_VERSION, "7.2.3.2");
                map.put("channel", d.pn());
                map.put("sdk_api_version", d.b);
                return map;
            }
        };
        boolean z3 = (dw.nr().la() & 2) == 0;
        if (z2 && (dw.nr().la() & 1) == 0) {
            z = true;
        }
        gm7.b(applicationContext, ij7Var, z3, z);
        com.bytedance.sdk.component.utils.jk.u().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.k.u.3
            @Override // java.lang.Runnable
            public void run() {
                if (!n.o().ja()) {
                    gm7.a();
                }
                if (com.bytedance.sdk.openadsdk.core.b.u.fx()) {
                    return;
                }
                boolean zKj = dw.nr().kj();
                boolean zU = u.u();
                if (zKj && zU) {
                    gm7.g(new li7() { // from class: com.bytedance.sdk.openadsdk.k.u.3.1
                    });
                }
            }
        }, 5000L);
    }

    public static void u(Context context) {
        nr(context);
    }

    public static boolean u() {
        int iIntValue;
        try {
            String strZx = dw.nr().zx();
            if (!TextUtils.isEmpty(strZx) && strZx.contains(com.huawei.openalliance.ad.constant.x.aQ)) {
                String[] strArrSplit = strZx.split(com.huawei.openalliance.ad.constant.x.aQ);
                if (strArrSplit.length != 2) {
                    return true;
                }
                String str = strArrSplit[0];
                String str2 = strArrSplit[1];
                Long lValueOf = -1L;
                try {
                    lValueOf = Long.valueOf(Long.valueOf(str).longValue() * 60 * 1000);
                    iIntValue = Integer.valueOf(str2).intValue();
                } catch (Exception e) {
                    e.getMessage();
                    iIntValue = -1;
                }
                if (lValueOf.longValue() >= 0 && iIntValue >= 0 && iIntValue <= 60) {
                    if (lValueOf.longValue() == 0 || iIntValue == 0 || lValueOf.longValue() / ((long) iIntValue) < 5000) {
                        return false;
                    }
                    String strNr = nr();
                    StringBuilder sb = new StringBuilder();
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (TextUtils.isEmpty(strNr)) {
                        sb.append(jCurrentTimeMillis);
                        u(sb.toString());
                        return true;
                    }
                    String[] strArrSplit2 = strNr.split(com.huawei.openalliance.ad.constant.x.aQ);
                    int length = strArrSplit2.length;
                    if (length >= iIntValue && length != 0) {
                        boolean z = jCurrentTimeMillis - Long.valueOf(strArrSplit2[0]).longValue() > lValueOf.longValue();
                        int i = length - iIntValue;
                        for (int i2 = i; i2 < length; i2++) {
                            String str3 = strArrSplit2[i2];
                            if (i2 != i && !TextUtils.isEmpty(str3)) {
                                sb.append(str3);
                                sb.append(com.huawei.openalliance.ad.constant.x.aQ);
                            }
                        }
                        sb.append(jCurrentTimeMillis);
                        u(sb.toString());
                        return z;
                    }
                    for (String str4 : strArrSplit2) {
                        sb.append(str4);
                        sb.append(com.huawei.openalliance.ad.constant.x.aQ);
                    }
                    sb.append(jCurrentTimeMillis);
                    u(sb.toString());
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean nr(Throwable th, Thread thread) {
        StackTraceElement[] stackTrace;
        if (n.o().ja()) {
            return false;
        }
        if (th != null) {
            stackTrace = th.getStackTrace();
        } else {
            stackTrace = thread != null ? thread.getStackTrace() : null;
        }
        String string = Arrays.toString(stackTrace);
        if (!(string.contains(BuildConfig.LIBRARY_PACKAGE_NAME) || string.contains("com.bytedance.sdk.component") || string.contains("com.bykv.vk") || string.contains("com.byted.csj.ext_impl") || string.contains("com.bytedance.adsdk") || string.contains("com.bytedance.msdk") || string.contains("com.bytedance.sdk.gromore") || string.contains("com.bytedance.sdk.openadsdk.mediation") || string.contains("bykvm"))) {
            return false;
        }
        Map<String, String> mapNr = com.bytedance.sdk.openadsdk.core.b.u().nr();
        if (mapNr != null) {
            if (string.contains("com.bytedance.sdk.openadsdk.core.nativeexpress")) {
                mapNr.put("express", ex.Code);
            }
            if (string.contains(com.bytedance.sdk.openadsdk.core.live.u.class.getPackage().getName()) || string.contains("com.bytedance.sdk.openadsdk.live") || string.contains("com.bykv.vk.openvk.live")) {
                mapNr.put("live_sdk", ex.Code);
            }
            if (!string.contains("com.bytedance.msdk") && !string.contains("com.bytedance.sdk.gromore") && !string.contains("com.bytedance.sdk.openadsdk.mediation") && !string.contains("bykvm")) {
                mapNr.put("mediation", ex.V);
            } else {
                mapNr.put("mediation", ex.Code);
            }
            String strFx = d.nr ? fx() : null;
            if (!TextUtils.isEmpty(strFx)) {
                mapNr.put("second_plugin_version", strFx);
            }
            gm7.f(com.bytedance.sdk.openadsdk.core.b.u().nr());
        }
        return true;
    }

    public static void u(String str) {
        com.bytedance.sdk.openadsdk.core.fx.b.u().nr("sp_apm_record", str);
    }

    public static String nr() {
        return com.bytedance.sdk.openadsdk.core.fx.b.u().fx("sp_apm_record", "");
    }
}
