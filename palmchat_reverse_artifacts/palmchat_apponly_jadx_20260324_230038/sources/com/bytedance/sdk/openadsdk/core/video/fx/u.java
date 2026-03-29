package com.bytedance.sdk.openadsdk.core.video.fx;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.android.metrics.ActionType;
import com.bytedance.android.metrics.EnterFromMerge;
import com.bytedance.android.metrics.EnterMethod;
import com.bytedance.sdk.component.iz.my;
import com.bytedance.sdk.component.iz.qq;
import com.bytedance.sdk.component.jk.a;
import com.bytedance.sdk.component.utils.fx;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.openadsdk.core.d;
import com.bytedance.sdk.openadsdk.core.dw;
import com.bytedance.sdk.openadsdk.core.iz;
import com.bytedance.sdk.openadsdk.core.kj.bc;
import com.bytedance.sdk.openadsdk.core.kj.m;
import com.bytedance.sdk.openadsdk.core.kj.xg;
import com.bytedance.sdk.openadsdk.core.sx;
import com.bytedance.sdk.openadsdk.core.y.gi;
import com.bytedance.sdk.openadsdk.core.y.jk;
import com.bytedance.sdk.openadsdk.core.y.jp;
import com.bytedance.sdk.openadsdk.core.y.y;
import com.bytedance.sdk.openadsdk.gi.x;
import com.bytedance.sdk.openadsdk.n.nr;
import com.umeng.analytics.pro.bt;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import defpackage.f43;
import defpackage.g43;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class u {
    private static String fx(int i) {
        return i != 120 ? i != 160 ? i != 240 ? i != 320 ? i != 480 ? i != 640 ? "mdpi" : "xxxhdpi" : "xxhdpi" : "xhdpi" : "hdpi" : "mdpi" : "ldpi";
    }

    public static EnterFromMerge nr(int i) {
        return i == 7 ? EnterFromMerge.AD_UNION_EXCITATION : i == 8 ? EnterFromMerge.AD_UNION_INSERT : i == 5 ? EnterFromMerge.AD_UNION_FEED : i == 9 ? EnterFromMerge.AD_UNION_DRAW : EnterFromMerge.NO_VALUE;
    }

    public static void u(final String str, final bc bcVar, final long j) {
        x.nr(new a("csj_live_log_event") { // from class: com.bytedance.sdk.openadsdk.core.video.fx.u.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    xg xgVarMd = bcVar.md();
                    String strUu = bcVar.uu();
                    if (TextUtils.isEmpty(strUu) && xgVarMd != null) {
                        strUu = xgVarMd.nr();
                    }
                    if (TextUtils.isEmpty(strUu)) {
                        return;
                    }
                    String strIz = xgVarMd != null ? xgVarMd.iz() : null;
                    if (TextUtils.isEmpty(strIz)) {
                        strIz = bcVar.xx();
                    }
                    JSONObject jSONObjectB = f43.b(new g43().h(Long.parseLong(strUu)).b(xgVarMd != null ? xgVarMd.u() : "").g(strIz).e(u.nr(jp.jk(bcVar))).f(u.u(jp.jk(bcVar))).a(ActionType.CLICK).d(j).c(), u.u(dw.getContext()));
                    jSONObjectB.put("tob_extra", bcVar.ap());
                    iz.nr(str, jSONObjectB);
                } catch (Throwable th) {
                    k.u("TTLiveVideoUtil", "Throwable : ", th);
                }
            }
        });
    }

    public static Map<String, String> u(Context context) {
        HashMap map = new HashMap();
        map.put("device_id", sx.fx());
        map.put("sdk_version", d.b);
        map.put("os", AnalyticsConstants.SDK_TYPE);
        map.put("os_version", Build.VERSION.RELEASE);
        map.put("device_model", jk.nr());
        map.put("resolution", y.pn(context) + "x" + y.b(context));
        map.put("language", Locale.getDefault().getLanguage());
        map.put(bt.M, String.valueOf(nr()));
        map.put(bt.Q, o.x(context));
        map.put("openudid", jk.u());
        map.put("aid", "1371");
        map.put(bt.s, com.bytedance.sdk.openadsdk.core.n.u.pn());
        map.put("app_version", com.bytedance.sdk.openadsdk.core.n.u.b());
        map.put("package", jp.a());
        map.put("region", Locale.getDefault().getCountry());
        map.put("tz_name", Calendar.getInstance().getTimeZone().getID());
        map.put("tz_offset", String.valueOf(Calendar.getInstance().getTimeZone().getOffset(System.currentTimeMillis()) / 1000));
        map.put("rom", u());
        String str = Build.MANUFACTURER;
        map.put(bt.H, str);
        ArrayList<String> arrayListU = fx.u(context, "MD5");
        if (arrayListU != null && !arrayListU.isEmpty()) {
            map.put("sig_hash", str);
        }
        map.put("display_density", fx(y.n(context)));
        map.put("os_api", String.valueOf(Build.VERSION.SDK_INT));
        map.put("density_dpi", String.valueOf(y.n(context)));
        map.put(bt.F, Build.BRAND);
        map.put("build_serial", jk.t());
        map.put("version_code", jp.jk());
        map.put("udid", jk.n());
        map.put("cpu_abi", Build.CPU_ABI);
        map.put("oaid", jk.fx(false));
        return map;
    }

    public static void nr(bc bcVar) {
        if (bcVar != null && u(bcVar)) {
            String strN = m.n(bcVar);
            String strA = m.a(bcVar);
            if (!TextUtils.isEmpty(strN)) {
                nr.u(strN).to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.video.fx.u.2
                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onSuccess(my myVar) {
                    }

                    @Override // com.bytedance.sdk.component.iz.qq
                    public void onFailed(int i, String str, Throwable th) {
                    }
                });
            }
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            nr.u(strA).to(new qq() { // from class: com.bytedance.sdk.openadsdk.core.video.fx.u.3
                @Override // com.bytedance.sdk.component.iz.qq
                public void onSuccess(my myVar) {
                }

                @Override // com.bytedance.sdk.component.iz.qq
                public void onFailed(int i, String str, Throwable th) {
                }
            });
        }
    }

    private static int nr() {
        int rawOffset = TimeZone.getDefault().getRawOffset() / 3600000;
        if (rawOffset < -12) {
            rawOffset = -12;
        }
        if (rawOffset > 12) {
            return 12;
        }
        return rawOffset;
    }

    public static EnterMethod u(int i) {
        if (i == 5) {
            return EnterMethod.LIVE_CARD;
        }
        if (i != 7 && i != 8 && i != 9) {
            return EnterMethod.NO_VALUE;
        }
        return EnterMethod.LIVE_CELL;
    }

    public static boolean u(bc bcVar) {
        return d.b() && m.u(bcVar);
    }

    private static String u() {
        StringBuilder sb = new StringBuilder();
        try {
            if (gi.my()) {
                sb.append("MIUI-");
            } else if (gi.bq()) {
                sb.append("FLYME-");
            } else {
                String strDw = gi.dw();
                if (gi.u(strDw)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strDw)) {
                    sb.append(strDw);
                    sb.append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }
}
