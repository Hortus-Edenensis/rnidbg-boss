package com.bytedance.sdk.openadsdk.core.y;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.baidu.mapapi.SDKInitializer;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.TTRewardVideoAd;
import com.bytedance.sdk.openadsdk.core.activity.base.TTNativePageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity;
import com.bytedance.sdk.openadsdk.core.activity.base.TTWebPageActivity;
import com.bytedance.sdk.openadsdk.core.kj.jw;
import com.bytedance.sdk.openadsdk.core.kj.tk;
import com.bytedance.sdk.openadsdk.core.kj.tm;
import com.bytedance.sdk.openadsdk.core.kj.za;
import com.bytedance.sdk.openadsdk.core.kj.zx;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.framework.common.ContainerUtils;
import com.oplus.tblplayer.Constants;
import com.oplus.tblplayer.monitor.sdk.SysPerformanceCollector;
import com.qiniu.android.collect.ReportItem;
import com.qq.gdt.action.ActionUtils;
import com.wifi.ad.core.config.DeviceInfoUtil;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class jp {
    public static volatile String b = null;
    public static volatile int fx = 0;
    public static volatile long iz = 0;
    private static volatile boolean l = false;
    public static volatile int n = -1;
    public static volatile int nr = 0;
    public static volatile long pn = 0;
    private static long t = -1;
    public static volatile int u;
    public static volatile long x;
    private static final AtomicBoolean mv = new AtomicBoolean(false);
    private static volatile String s = "";
    private static volatile String k = null;
    private static volatile String my = null;
    private static volatile String o = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5411a = null;
    public static String jk = null;

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.y.jp$4, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class AnonymousClass4 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                String unused = jp.s = jp.my(new SSWebView(com.bytedance.sdk.openadsdk.core.dw.getContext()).getUserAgentString());
                com.bytedance.sdk.openadsdk.core.fx.b.u().b("sdk_local_web_ua", jp.s);
            } catch (Exception unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.y.jp$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public static class AnonymousClass5 implements FilenameFilter {
        private Pattern u = Pattern.compile("^cpu[0-9]+$");

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return this.u.matcher(str).matches();
        }
    }

    public static boolean a(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        JSONObject jSONObjectTq;
        if (bcVar == null || (jSONObjectTq = bcVar.tq()) == null) {
            return false;
        }
        try {
            int iOptInt = new JSONObject(jSONObjectTq.optString("compliance_data")).optJSONObject("ad").optInt("pricing_type");
            return iOptInt == 3 || iOptInt == 6;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("ToolUtils", "error:" + e.getMessage());
            return false;
        }
    }

    public static boolean b() {
        return (com.bytedance.sdk.openadsdk.core.n.o() == null || com.bytedance.sdk.openadsdk.core.n.o().u()) ? false : true;
    }

    public static String bg(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return (bcVar.pu() == null || TextUtils.isEmpty(bcVar.pu().fx())) ? !TextUtils.isEmpty(bcVar.j()) ? bcVar.j() : !TextUtils.isEmpty(bcVar.wf()) ? bcVar.wf() : "" : bcVar.pu().fx();
    }

    public static String bq(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return !TextUtils.isEmpty(bcVar.wf()) ? bcVar.wf() : !TextUtils.isEmpty(bcVar.ym()) ? bcVar.ym() : "";
    }

    public static int c() {
        if (n >= 0) {
            return n;
        }
        int iNr = com.bytedance.sdk.openadsdk.core.fx.b.u().nr("is_root", -1);
        n = iNr;
        return iNr;
    }

    public static void d() {
        String strJq = com.bytedance.sdk.openadsdk.core.dw.nr().jq();
        try {
            Matcher matcher = Pattern.compile("\\|\\|([a-zA-Z0-9.-]+)\\^").matcher(strJq);
            while (matcher.find()) {
                String strGroup = matcher.group(1);
                if (!TextUtils.isEmpty(strGroup)) {
                    com.bytedance.sdk.openadsdk.core.kj.bf.u.add(strGroup);
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(strJq)) {
            return;
        }
        Set<String> set = com.bytedance.sdk.openadsdk.core.kj.bf.u;
        if (set.isEmpty()) {
            set.add("empty");
        }
    }

    public static long dw() {
        try {
            if (!jp()) {
                return 0L;
            }
            StatFs statFs = new StatFs(com.bytedance.sdk.openadsdk.api.plugin.nr.u(com.bytedance.sdk.openadsdk.core.dw.getContext(), null).getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.k.nr("ToolUtils", th.getMessage());
            return 0L;
        }
    }

    public static boolean fx(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        if (nr(context)) {
            try {
                return context.getPackageManager().getPackageInfo(str, 0) != null;
            } catch (Throwable unused) {
                return false;
            }
        }
        if (com.bytedance.sdk.openadsdk.core.dw.nr().hc()) {
            return u(str);
        }
        return false;
    }

    public static void gi() {
        if (l) {
            return;
        }
        l = true;
        com.bytedance.sdk.component.t.x.u uVarU = com.bytedance.sdk.component.t.x.u.u();
        uVarU.u("open_sass_live", new com.bytedance.sdk.openadsdk.core.a.u.nr.t());
        uVarU.u("open_miniapp", new com.bytedance.sdk.openadsdk.core.a.u.nr.l());
        uVarU.u("open_landing_page", new com.bytedance.sdk.openadsdk.core.a.u.nr.jk());
        uVarU.u("download", new com.bytedance.sdk.openadsdk.core.a.u.nr.x());
        uVarU.u("open_scheme", new com.bytedance.sdk.openadsdk.core.a.u.nr.mv());
        uVarU.u("open_policy", new com.bytedance.sdk.openadsdk.core.a.u.nr.s());
        uVarU.u("end_card", new com.bytedance.sdk.openadsdk.core.a.u.nr.a());
        uVarU.u("common_popup", new com.bytedance.sdk.openadsdk.core.a.u.nr.u());
        uVarU.u("desc_popup", new com.bytedance.sdk.openadsdk.core.a.u.nr.nr());
        uVarU.u("permission_popup", new com.bytedance.sdk.openadsdk.core.a.u.nr.fx());
        uVarU.u("privacy_popup", new com.bytedance.sdk.openadsdk.core.a.u.nr.b());
        uVarU.u("registration_pop", new com.bytedance.sdk.openadsdk.core.a.u.nr.pn());
        uVarU.u("dislike_popup", new com.bytedance.sdk.openadsdk.core.a.u.nr.iz());
        uVarU.u("download_popup", new com.bytedance.sdk.openadsdk.core.a.u.nr.n());
        uVarU.u("reward_again", new com.bytedance.sdk.openadsdk.core.a.u.nr.sx());
        uVarU.u("reward_continue", new com.bytedance.sdk.openadsdk.core.a.u.nr.sx());
        uVarU.u("close_reward", new com.bytedance.sdk.openadsdk.core.a.u.nr.o());
        uVarU.u("report_event", new com.bytedance.sdk.openadsdk.core.a.u.nr.k());
        uVarU.u("report_stats", new com.bytedance.sdk.openadsdk.core.a.u.nr.my());
    }

    public static boolean iz(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        int iJk = jk(bcVar);
        return iJk == 3 || iJk == 4 || iJk == 9 || iJk == 7 || iJk == 8;
    }

    public static int jk(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        JSONObject jSONObjectTq;
        if (bcVar == null || (jSONObjectTq = bcVar.tq()) == null) {
            return 0;
        }
        return jSONObjectTq.optInt("ad_slot_type", 0);
    }

    private static boolean jp() {
        try {
            return "mounted".equals(com.bytedance.sdk.openadsdk.gi.fx.u());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String kj() {
        return m.nr(String.format("https://%s", "applog.bytedance.net/service/2/app_log_test/"));
    }

    public static String l(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        JSONObject jSONObjectTq = bcVar.tq();
        return jSONObjectTq != null ? jSONObjectTq.optString("origin_req_id", "") : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        try {
            s = my(WebSettings.getDefaultUserAgent(com.bytedance.sdk.openadsdk.core.dw.getContext()));
            com.bytedance.sdk.openadsdk.core.fx.b.u().b("sdk_local_web_ua", s);
            mv.set(false);
        } catch (Throwable unused) {
        }
    }

    public static String mv(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        JSONObject jSONObjectTq = bcVar.tq();
        return jSONObjectTq != null ? jSONObjectTq.optString("customer_id", "") : "";
    }

    public static int my(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        JSONObject jSONObjectTq = bcVar.tq();
        if (jSONObjectTq != null) {
            return jSONObjectTq.optInt("pricing", 0);
        }
        return 0;
    }

    public static boolean n(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        int iJk = jk(bcVar);
        return iJk == 3 || iJk == 4;
    }

    public static String nr(int i) {
        switch (i) {
            case 1:
                return "banner_ad";
            case 2:
                return "interaction";
            case 3:
            case 4:
                return WifiNestConst.NestTypeConst.NEST_SPLASH_AD;
            case 5:
            default:
                return "embeded_ad";
            case 6:
                return "stream";
            case 7:
                return "rewarded_video";
            case 8:
                return "fullscreen_interstitial_ad";
            case 9:
                return WifiNestConst.NestTypeConst.NEST_DRAW_AD;
        }
    }

    public static int o(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        JSONObject jSONObjectTq = bcVar.tq();
        if (jSONObjectTq != null) {
            return jSONObjectTq.optInt(OapsKey.KEY_PRICE, 0);
        }
        return 0;
    }

    private static String pb() {
        String string;
        long j;
        try {
            String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("sdk_local_web_ua", "");
            if (TextUtils.isEmpty(strFx)) {
                string = null;
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strFx);
                string = jSONObject.getString(ActionUtils.PAYMENT_AMOUNT);
                j = jSONObject.getLong("time");
                s = string;
            }
            if (TextUtils.isEmpty(string)) {
                m();
            } else if (System.currentTimeMillis() - j > 259200000 && mv.compareAndSet(false, true)) {
                if (com.bytedance.sdk.openadsdk.core.b.u.n()) {
                    new com.bytedance.sdk.openadsdk.core.b.nr("device_get_webua").u(5).nr(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.jp.2
                        @Override // java.lang.Runnable
                        public void run() {
                            jp.xg();
                        }
                    });
                } else {
                    xg();
                }
            }
        } catch (Throwable unused) {
        }
        return s;
    }

    public static int pn(int i) {
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return (i == 3 || i == 4 || i == 7 || i == 8) ? 5 : 3;
        }
        return 4;
    }

    public static boolean q() {
        try {
            if (!new File("/system/bin/su").exists()) {
                if (!new File("/system/xbin/su").exists()) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String qq() {
        return m.nr(Uri.parse(String.format("https://%s", sx(com.bytedance.sdk.openadsdk.core.dw.nr().gi()))).buildUpon().appendQueryParameter("datetime", new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(new Long(System.currentTimeMillis()).longValue()))).toString());
    }

    public static String sx(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = bcVar.pu();
        String strNr = pnVarPu != null ? pnVarPu.nr() : null;
        return TextUtils.isEmpty(strNr) ? bcVar.bq() : strNr;
    }

    public static int t(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        JSONObject jSONObjectTq;
        if (bcVar == null || (jSONObjectTq = bcVar.tq()) == null) {
            return 0;
        }
        return jSONObjectTq.optInt("rit", 0);
    }

    public static String u(int i) {
        switch (i) {
            case 1:
                return "embeded_ad_landingpage";
            case 2:
                return "banner_ad_landingpage";
            case 3:
                return "interaction_landingpage";
            case 4:
                return "splash_ad_landingpage";
            case 5:
                return "fullscreen_interstitial_ad_landingpage";
            case 6:
                return "draw_ad_landingpage";
            case 7:
                return "rewarded_video_landingpage";
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void wq() {
        List<String> listQb;
        com.bytedance.sdk.openadsdk.core.pb.t tVarNr = com.bytedance.sdk.openadsdk.core.dw.nr();
        if (com.bytedance.sdk.openadsdk.core.n.o().yd()) {
            com.bytedance.sdk.openadsdk.core.n.o().x(false);
            return;
        }
        if (tVarNr.wj() || (listQb = tVarNr.qb()) == null) {
            return;
        }
        int iEc = tVarNr.ec();
        for (int i = 0; i < iEc && i < listQb.size(); i++) {
            Uri uri = Uri.parse(listQb.get(i));
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            u(com.bytedance.sdk.openadsdk.core.dw.getContext(), intent, true);
        }
    }

    public static boolean x(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return false;
        }
        int iJk = jk(bcVar);
        return iJk == 5 || iJk == 1 || iJk == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void xg() {
        com.bytedance.sdk.component.jk.x.nr(new com.bytedance.sdk.component.jk.a("tt-webua") { // from class: com.bytedance.sdk.openadsdk.core.y.jp.3
            @Override // java.lang.Runnable
            public void run() {
                jp.m();
            }
        });
    }

    public static String z(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        Object obj;
        if (bcVar == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.kj.iz izVarHm = bcVar.hm();
        String strMv = izVarHm != null ? izVarHm.mv() : "";
        if (!TextUtils.isEmpty(strMv)) {
            return strMv;
        }
        com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = bcVar.pu();
        if (pnVarPu != null) {
            strMv = pnVarPu.b();
        }
        if (!TextUtils.isEmpty(strMv)) {
            return strMv;
        }
        Map<String, Object> mapSj = bcVar.sj();
        if (mapSj != null && (obj = mapSj.get("ad_package_name")) != null) {
            strMv = obj.toString();
        }
        return !TextUtils.isEmpty(strMv) ? strMv : bcVar.it();
    }

    public static boolean b(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar != null) {
            boolean z = jk(bcVar) == 5;
            if (tk.nr(bcVar) == 7 && z) {
                return true;
            }
        }
        return false;
    }

    public static double iz(String str) {
        return fx(fx(str));
    }

    public static String k(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        JSONObject jSONObjectTq = bcVar.tq();
        return jSONObjectTq != null ? jSONObjectTq.optString(ReportItem.RequestKeyRequestId, "") : "";
    }

    public static String n() {
        return UUID.randomUUID().toString();
    }

    public static Intent nr(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 33 && !launchIntentForPackage.hasCategory("android.intent.category.LAUNCHER")) {
            launchIntentForPackage.addCategory("android.intent.category.LAUNCHER");
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static boolean pn(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        int iJk = jk(bcVar);
        return (iJk == 9 || iJk == 8 || iJk == 7) && !TextUtils.isEmpty(zx.u(bcVar));
    }

    public static boolean q(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return true;
        }
        int iIz = com.bytedance.sdk.openadsdk.core.dw.nr().iz(t(bcVar));
        if (iIz == 1) {
            return com.bytedance.sdk.component.utils.o.b(com.bytedance.sdk.openadsdk.core.dw.getContext());
        }
        if (iIz == 2) {
            return com.bytedance.sdk.component.utils.o.pn(com.bytedance.sdk.openadsdk.core.dw.getContext()) || com.bytedance.sdk.component.utils.o.b(com.bytedance.sdk.openadsdk.core.dw.getContext()) || com.bytedance.sdk.component.utils.o.iz(com.bytedance.sdk.openadsdk.core.dw.getContext());
        }
        if (iIz != 3) {
            return iIz != 5 || com.bytedance.sdk.component.utils.o.b(com.bytedance.sdk.openadsdk.core.dw.getContext()) || com.bytedance.sdk.component.utils.o.iz(com.bytedance.sdk.openadsdk.core.dw.getContext());
        }
        return false;
    }

    public static double s(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return fx(bcVar.tq());
    }

    public static boolean u(Context context, String str) {
        Intent intentNr;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                if (nr(context)) {
                    if (!fx(context, str) || (intentNr = nr(context, str)) == null) {
                        return false;
                    }
                    intentNr.putExtra("START_ONLY_FOR_ANDROID", true);
                    com.bytedance.sdk.component.utils.nr.u(context, intentNr, null);
                    return true;
                }
                Intent intentNr2 = nr(context, str);
                if (intentNr2 == null) {
                    return false;
                }
                intentNr2.putExtra("START_ONLY_FOR_ANDROID", true);
                context.startActivity(intentNr2);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static String x() {
        return !TextUtils.isEmpty(s) ? s : pb();
    }

    public static String jk() {
        if (TextUtils.isEmpty(k) && com.bytedance.sdk.openadsdk.core.dw.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.dw.getContext().getPackageManager().getPackageInfo(a(), 0);
                k = String.valueOf(packageInfo.versionCode);
                my = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.u("ToolUtils", "ToolUtils getVersionCode throws exception :", th);
            }
        }
        return k;
    }

    public static boolean kj(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return bcVar != null && TextUtils.equals(bcVar.en(), bcVar.lk()) && bcVar.qf() == 3 && !TextUtils.isEmpty(z(bcVar));
    }

    public static String l() {
        if (!TextUtils.isEmpty(b) && !b.equals("0")) {
            return b;
        }
        String strFx = com.bytedance.sdk.openadsdk.core.fx.b.u().fx("total_memory", "0");
        b = strFx;
        return strFx;
    }

    public static int mv() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String my(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static String n(String str) {
        return u(str, false, 0);
    }

    public static long o() {
        if (pn > 0) {
            return pn;
        }
        long jNr = com.bytedance.sdk.openadsdk.core.fx.b.u().nr("internal_storage", 0L);
        pn = jNr;
        return jNr;
    }

    public static int s() {
        if (u > 0) {
            return u;
        }
        int iNr = com.bytedance.sdk.openadsdk.core.fx.b.u().nr("cpu_cnt", 0);
        u = iNr;
        return iNr;
    }

    public static String t() {
        if (TextUtils.isEmpty(my) && com.bytedance.sdk.openadsdk.core.dw.getContext() != null) {
            try {
                PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.dw.getContext().getPackageManager().getPackageInfo(a(), 0);
                k = String.valueOf(packageInfo.versionCode);
                my = packageInfo.versionName;
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.u("ToolUtils", "ToolUtils getVersionName throws exception :", th);
            }
        }
        return my;
    }

    public static long b(String str) {
        return u(fx(str));
    }

    public static String iz() {
        String strConcat;
        try {
            strConcat = System.getProperty("http.agent");
        } catch (Exception unused) {
            strConcat = "unKnow";
        }
        StringBuilder sb = new StringBuilder();
        if (strConcat == null) {
            return "";
        }
        int iLastIndexOf = strConcat.lastIndexOf(com.huawei.openalliance.ad.constant.x.aQ);
        if (iLastIndexOf != -1 && strConcat.length() > iLastIndexOf) {
            int i = iLastIndexOf + 1;
            String strSubstring = strConcat.substring(0, i);
            strConcat = strSubstring.concat(" " + Locale.getDefault().getLanguage() + "-" + Locale.getDefault().getCountry() + com.huawei.openalliance.ad.constant.x.aQ).concat(strConcat.substring(i));
        }
        int length = strConcat.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = strConcat.charAt(i2);
            if (cCharAt <= 31 || cCharAt >= 127) {
                sb.append(String.format("\\u%04x", Integer.valueOf(cCharAt)));
            } else {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }

    public static int k() {
        if (nr > 0) {
            return nr;
        }
        int iNr = com.bytedance.sdk.openadsdk.core.fx.b.u().nr("cpu_max_freq", 0);
        nr = iNr;
        return iNr;
    }

    public static long mv(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        Matcher matcher = Pattern.compile("/([^/]+)/video/tos/cn").matcher(str);
        if (matcher.find()) {
            String strGroup = matcher.group(1);
            if (TextUtils.isEmpty(strGroup)) {
                return 0L;
            }
            try {
                long j = Long.parseLong(strGroup, 16);
                return str.contains("v3-be-pack") ? j + 10800 : j;
            } catch (Exception unused) {
            }
        }
        return 0L;
    }

    public static long bq() {
        if (x > 0) {
            return x;
        }
        long jNr = com.bytedance.sdk.openadsdk.core.fx.b.u().nr("sdcard_storage", 0L);
        x = jNr;
        return jNr;
    }

    public static boolean c(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null || com.bytedance.sdk.openadsdk.core.kj.bg.b(bcVar)) {
            return false;
        }
        int iC = bcVar.c();
        return iC == 5 || iC == 4;
    }

    public static int pn(String str) {
        return nr(fx(str));
    }

    public static long sx() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return statFs.getBlockCountLong() * statFs.getBlockSizeLong();
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static boolean x(String str) {
        try {
            return Pattern.compile("[一-龥]").matcher(str).find();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String b(Context context, String str) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 4096);
                do {
                    try {
                        line = bufferedReader.readLine();
                        if (line == null) {
                            break;
                        }
                    } catch (Throwable unused) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception unused2) {
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Exception unused3) {
                            }
                        }
                        return null;
                    }
                } while (!line.contains(str));
                if (line == null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused4) {
                    }
                    try {
                        fileReader.close();
                    } catch (Exception unused5) {
                    }
                    return null;
                }
                String str2 = line.split("\\s+")[1];
                try {
                    bufferedReader.close();
                } catch (Exception unused6) {
                }
                try {
                    fileReader.close();
                } catch (Exception unused7) {
                }
                return str2;
            } catch (Throwable unused8) {
                bufferedReader = null;
            }
        } catch (Throwable unused9) {
            fileReader = null;
            bufferedReader = null;
        }
    }

    public static String a() {
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        if (com.bytedance.sdk.openadsdk.core.dw.getContext() != null) {
            try {
                o = com.bytedance.sdk.openadsdk.core.dw.getContext().getPackageName();
            } catch (Throwable th) {
                com.bytedance.sdk.component.utils.k.u("ToolUtils", "ToolUtils getPackageName throws exception :", th);
            }
        }
        return o;
    }

    public static long bg() {
        if (iz > 0) {
            return iz;
        }
        long jNr = com.bytedance.sdk.openadsdk.core.fx.b.u().nr("free_storage", 0L);
        iz = jNr;
        return jNr;
    }

    public static JSONObject dw(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        return bcVar.tq();
    }

    public static void fx() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            com.bytedance.sdk.component.utils.jk.u().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.y.jp.1
                @Override // java.lang.Runnable
                public void run() {
                    jp.wq();
                }
            });
        } else {
            wq();
        }
    }

    public static boolean l(String str) {
        long jMv = mv(str);
        return jMv != 0 && System.currentTimeMillis() - (jMv * 1000) > 0;
    }

    private static String o(String str) {
        if (TextUtils.isEmpty(str)) {
            f5411a = "empty";
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        if (!str.contains("api-access")) {
            f5411a = str;
            return "api-access.pangolin-sdk-toutiao1.com";
        }
        f5411a = null;
        return str;
    }

    public static long pn() {
        return t;
    }

    public static boolean nr(Context context, Intent intent, boolean z) {
        Boolean boolU;
        Uri data = intent.getData();
        if (data == null) {
            return false;
        }
        String strU = d.u(data);
        if (z && (boolU = d.u(strU, 86400000L)) != null) {
            return boolU.booleanValue();
        }
        boolean zNr = nr(context, intent);
        d.u(strU, Boolean.valueOf(zNr));
        return zNr;
    }

    public static String pn(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception unused) {
            return "";
        }
    }

    public static boolean qq(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return bcVar != null && bcVar.jn() == 1;
    }

    private static String sx(String str) {
        if (TextUtils.isEmpty(str)) {
            jk = "empty";
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        if (!str.contains("service/2/app_log")) {
            jk = str;
            return "log-api.pangolin-sdk-toutiao-b.com/service/2/app_log/";
        }
        jk = null;
        return str;
    }

    public static JSONObject fx(String str) {
        if (TextUtils.isEmpty(str) || str == null || str.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static int my() {
        if (fx > 0) {
            return fx;
        }
        int iNr = com.bytedance.sdk.openadsdk.core.fx.b.u().nr("cpu_min_freq", 0);
        fx = iNr;
        return iNr;
    }

    private static String bg(String str) {
        try {
            return Uri.parse(str).buildUpon().appendQueryParameter("aid", "1371").appendQueryParameter("device_platform", "android").appendQueryParameter("version_code", jk()).toString();
        } catch (Exception unused) {
            return str;
        }
    }

    public static JSONObject u(Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception unused) {
            }
        }
        return jSONObject;
    }

    public static String jk(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("KLLK")) {
            return str.replace("KLLK", "OPPO");
        }
        return str.contains("kllk") ? str.replace("kllk", "oppo") : "";
    }

    public static int[] t(String str) {
        if (TextUtils.isEmpty(str)) {
            return new int[0];
        }
        String[] strArrSplit = str.split(",");
        int[] iArr = new int[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            try {
                iArr[i] = Integer.parseInt(strArrSplit[i]);
            } catch (Exception unused) {
            }
        }
        return iArr;
    }

    public static String z() {
        return a() + ".openadsdk.permission.TT_PANGOLIN";
    }

    public static String a(String str) {
        return u(str, false, 1);
    }

    public static boolean fx(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        return bcVar != null && jk(bcVar) == 9;
    }

    private static double fx(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optDouble("pack_time", 0.0d);
        }
        return 0.0d;
    }

    public static boolean nr() {
        try {
            PackageInfo packageInfo = com.bytedance.sdk.openadsdk.core.dw.getContext().getPackageManager().getPackageInfo(com.bytedance.sdk.openadsdk.core.dw.getContext().getPackageName(), 0);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.ROOT);
            return simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())).compareTo(simpleDateFormat.format(Long.valueOf(packageInfo.firstInstallTime))) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x005c A[Catch: Exception -> 0x0058, DONT_GENERATE, TRY_LEAVE, TryCatch #3 {Exception -> 0x0058, blocks: (B:22:0x0054, B:25:0x005c), top: B:41:0x0054 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int fx(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        int i2 = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader2 = null;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            try {
                FileReader fileReader2 = new FileReader(SysPerformanceCollector.SYS_CPU_INFO_ROOT_PATH + i + SysPerformanceCollector.SYS_CPU_MAX_FREQ_FILE);
                try {
                    BufferedReader bufferedReader3 = new BufferedReader(fileReader2);
                    try {
                        int i3 = Integer.parseInt(bufferedReader3.readLine());
                        if (i3 > i2) {
                            i2 = i3;
                        }
                        try {
                            bufferedReader3.close();
                            fileReader2.close();
                        } catch (Exception unused) {
                        }
                        bufferedReader2 = bufferedReader3;
                        fileReader = fileReader2;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader3;
                        fileReader = fileReader2;
                        try {
                            com.bytedance.sdk.component.utils.k.nr("ToolUtils", th.getMessage());
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused2) {
                                    bufferedReader2 = bufferedReader;
                                }
                                bufferedReader2 = bufferedReader;
                            } else {
                                bufferedReader2 = bufferedReader;
                            }
                        } finally {
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception unused3) {
                                }
                            }
                            if (fileReader != null) {
                                fileReader.close();
                            }
                        }
                    }
                } catch (Throwable th3) {
                    BufferedReader bufferedReader4 = bufferedReader2;
                    th = th3;
                    fileReader = fileReader2;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th4) {
                bufferedReader = bufferedReader2;
                th = th4;
            }
        }
    }

    public static boolean u(String str) {
        boolean zExists = u("data", str).exists();
        return !zExists ? u("media", str).exists() : zExists;
    }

    public static Class iz(int i) {
        if (i == 2) {
            return TTNativePageActivity.class;
        }
        if (i == 3) {
            return TTVideoWebPageActivity.class;
        }
        if (i != 4) {
            return TTWebPageActivity.class;
        }
        return TTVideoScrollWebPageActivity.class;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005f A[Catch: Exception -> 0x005b, DONT_GENERATE, TRY_LEAVE, TryCatch #3 {Exception -> 0x005b, blocks: (B:24:0x0057, B:27:0x005f), top: B:43:0x0057 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(int i) {
        BufferedReader bufferedReader;
        Throwable th;
        FileReader fileReader;
        BufferedReader bufferedReader2;
        int i2 = 0;
        FileReader fileReader2 = null;
        BufferedReader bufferedReader3 = null;
        while (true) {
            i--;
            if (i < 0) {
                return i2;
            }
            try {
                fileReader = new FileReader(SysPerformanceCollector.SYS_CPU_INFO_ROOT_PATH + i + "/cpufreq/cpuinfo_min_freq");
                try {
                    bufferedReader2 = new BufferedReader(fileReader);
                } catch (Throwable th2) {
                    BufferedReader bufferedReader4 = bufferedReader3;
                    th = th2;
                    fileReader2 = fileReader;
                    bufferedReader = bufferedReader4;
                }
            } catch (Throwable th3) {
                bufferedReader = bufferedReader3;
                th = th3;
            }
            try {
                int i3 = Integer.parseInt(bufferedReader2.readLine());
                if (i3 < i2 || i2 == 0) {
                    i2 = i3;
                }
                try {
                    bufferedReader2.close();
                    fileReader.close();
                } catch (Exception unused) {
                }
                bufferedReader3 = bufferedReader2;
                fileReader2 = fileReader;
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = bufferedReader2;
                fileReader2 = fileReader;
                try {
                    com.bytedance.sdk.component.utils.k.nr("ToolUtils", th.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused2) {
                            bufferedReader3 = bufferedReader;
                        }
                        bufferedReader3 = bufferedReader;
                    } else {
                        bufferedReader3 = bufferedReader;
                    }
                } finally {
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    if (fileReader2 != null) {
                        fileReader2.close();
                    }
                }
            }
        }
    }

    private static boolean nr(Context context, Intent intent) {
        try {
            List<ResolveInfo> listU = jk.u(intent, 65536);
            if (listU != null) {
                if (listU.size() > 0) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private static File u(String str, String str2) {
        String str3 = System.getenv("EXTERNAL_STORAGE");
        if (str3 == null) {
            str3 = "/sdcard";
        }
        return new File(str3, "Android/" + str + "/" + str2);
    }

    public static int nr(String str) {
        str.hashCode();
        switch (str) {
            case "banner_ad":
                return 2;
            case "rewarded_video":
                return 7;
            case "fullscreen_interstitial_ad":
                return 5;
            case "splash_ad":
            case "cache_splash_ad":
                return 4;
            case "interaction":
                return 3;
            case "draw_ad":
                return 6;
            default:
                return 1;
        }
    }

    public static boolean u(Context context, Intent intent, boolean z) {
        if (intent == null || context == null || !nr(context)) {
            return false;
        }
        return nr(context, intent, z);
    }

    public static String gi(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        com.bytedance.sdk.openadsdk.core.kj.iz izVarHm;
        if (bcVar == null) {
            return null;
        }
        com.bytedance.sdk.openadsdk.core.kj.pn pnVarPu = bcVar.pu();
        String strB = pnVarPu != null ? pnVarPu.b() : null;
        if (TextUtils.isEmpty(strB) && (izVarHm = bcVar.hm()) != null) {
            strB = izVarHm.mv();
        }
        return TextUtils.isEmpty(strB) ? bcVar.it() : strB;
    }

    public static String nr(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return null;
        }
        try {
            return nr(jk(bcVar));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean u(Context context, Intent intent) {
        if (intent == null || context == null || !nr(context)) {
            return false;
        }
        return nr(context, intent, false);
    }

    private static int nr(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("ut", 0);
        }
        return 0;
    }

    public static long fx(Context context) {
        int i;
        try {
            i = context.getApplicationInfo().targetSdkVersion;
        } catch (Throwable unused) {
            i = -1;
        }
        return i;
    }

    public static Map<String, Object> nr(boolean z, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", bcVar.lk());
        map.put("load_time", Long.valueOf(j));
        if (!z) {
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static List<String> u() {
        ArrayList arrayList = new ArrayList();
        if (com.bytedance.sdk.openadsdk.core.dw.nr().pq() && com.bytedance.sdk.openadsdk.core.n.o().sx().nr()) {
            Intent intent = new Intent("android.intent.action.MAIN");
            if (Build.VERSION.SDK_INT >= 23) {
                Iterator<ResolveInfo> it = jk.u(intent, 131072).iterator();
                while (it.hasNext()) {
                    ActivityInfo activityInfo = it.next().activityInfo;
                    if (activityInfo != null) {
                        String str = activityInfo.packageName;
                        if (!TextUtils.isEmpty(str) && !arrayList.contains(str)) {
                            arrayList.add(str);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static long b(Context context) {
        int i = -1;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                i = context.getApplicationInfo().minSdkVersion;
            }
        } catch (Throwable unused) {
        }
        return i;
    }

    public static boolean nr(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.openadsdk.core.dw.getContext();
        }
        if (context != null) {
            return !(context.getApplicationInfo().targetSdkVersion >= 30 && Build.VERSION.SDK_INT >= 30 && context.checkSelfPermission("android.permission.QUERY_ALL_PACKAGES") != 0);
        }
        com.bytedance.sdk.component.utils.k.u("params context is null");
        return false;
    }

    public static String nr(long j, long j2) {
        return String.valueOf(((int) (Math.abs(j2 - j) / 86400000)) + 1);
    }

    public static int u(com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        int iDw = com.bytedance.sdk.openadsdk.core.dw.nr().dw();
        int iIntValue = 0;
        if (iDw != -1) {
            return (iDw == 0 || iDw != 1) ? 0 : 1;
        }
        try {
            tm tmVarX = tk.x(bcVar);
            za zaVarIz = tk.iz(bcVar);
            if (tmVarX != null) {
                String strIz = tmVarX.iz();
                if (!TextUtils.isEmpty(strIz)) {
                    iIntValue = Integer.valueOf(strIz).intValue();
                }
            } else if (zaVarIz != null) {
                String strL = zaVarIz.l();
                if (!TextUtils.isEmpty(strL)) {
                    iIntValue = Integer.valueOf(strL).intValue();
                }
            }
            return iIntValue;
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("tl", e.getMessage());
            return iIntValue;
        }
    }

    public static int nr(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        if (nrVar == null) {
            return 0;
        }
        try {
            return Integer.parseInt(nrVar.b());
        } catch (Exception unused) {
            return 0;
        }
    }

    public static String nr(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, String str) {
        jw jwVarKg;
        if (bcVar == null || (jwVarKg = bcVar.kg()) == null || jwVarKg.nr() != 1 || TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        if (str.indexOf(Constants.STRING_VALUE_UNSET) != -1) {
            sb.append(ContainerUtils.FIELD_DELIMITER);
        } else {
            sb.append(Constants.STRING_VALUE_UNSET);
        }
        sb.append("open_method=");
        if (!com.bytedance.sdk.openadsdk.core.nr.u.nr.b.fx().u()) {
            sb.append(2);
            return sb.toString();
        }
        sb.append(jwVarKg.iz());
        return sb.toString();
    }

    private static long u(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optLong(DeviceInfoUtil.UID_TAG, 0L);
        }
        return 0L;
    }

    public static String u(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, String str) {
        JSONObject jSONObjectTq = bcVar.tq();
        return jSONObjectTq != null ? jSONObjectTq.optString("rit", str) : str;
    }

    public static String u(com.bytedance.sdk.openadsdk.my.fx.fx.nr nrVar) {
        String strDecryptWithCBC;
        try {
            JSONObject jSONObject = new JSONObject(nrVar.dw());
            int iOptInt = jSONObject.optInt("cypher");
            String strOptString = jSONObject.optString("message");
            if (iOptInt == 3) {
                strDecryptWithCBC = com.bytedance.sdk.component.utils.u.fx(strOptString);
            } else if (iOptInt == 4) {
                com.bytedance.sdk.component.b.u uVarNr = kj.nr();
                strDecryptWithCBC = uVarNr == null ? "" : uVarNr.decryptWithCBC(strOptString);
                if (strDecryptWithCBC == null) {
                    strDecryptWithCBC = "";
                }
            } else {
                strDecryptWithCBC = null;
            }
            JSONArray jSONArrayOptJSONArray = new JSONObject(strDecryptWithCBC).optJSONArray("creatives");
            StringBuilder sb = new StringBuilder();
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    String strOptString2 = ((JSONObject) jSONArrayOptJSONArray.get(i)).optString("material_key");
                    if (i != 0) {
                        sb.append("," + strOptString2);
                    } else {
                        sb.append(strOptString2);
                    }
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return null;
        }
    }

    public static void nr(Intent intent) {
        if (intent == null) {
            return;
        }
        Uri data = intent.getData();
        if (data == null) {
            intent.addFlags(268435456);
        } else if (com.bytedance.sdk.openadsdk.core.dw.nr().sx(data.getScheme())) {
            intent.addFlags(805339136);
        } else {
            intent.addFlags(268435456);
        }
    }

    public static Map<String, Object> u(long j, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, com.bykv.vk.openvk.component.video.api.u uVar) {
        HashMap map = new HashMap();
        map.put("video_start_duration", Long.valueOf(j));
        if (bcVar != null) {
            if (!TextUtils.isEmpty(bcVar.lk())) {
                map.put("creative_id", bcVar.lk());
            }
            com.bykv.vk.openvk.component.video.api.fx.b bVarK = zx.k(bcVar);
            if (bVarK != null) {
                map.put("video_resolution", bVarK.a());
                map.put(WfConstant.EXTRA_KEY_VIDEO_SIZE, Long.valueOf(bVarK.pn()));
            }
        }
        u(map, uVar);
        return map;
    }

    public static Map<String, Object> u(boolean z, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, long j, long j2, String str) {
        HashMap map = new HashMap();
        map.put("creative_id", bcVar.lk());
        map.put("load_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.fx.b bVarK = zx.k(bcVar);
        if (bVarK != null) {
            map.put(WfConstant.EXTRA_KEY_VIDEO_SIZE, Long.valueOf(bVarK.pn()));
            map.put("video_resolution", bVarK.a());
            map.put("video_preload_size", Long.valueOf(Build.VERSION.SDK_INT >= 23 ? bVarK.my() : bVarK.pn()));
        }
        if (!z) {
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Long.valueOf(j2));
            if (TextUtils.isEmpty(str)) {
                str = "unknown";
            }
            map.put("error_message", str);
        }
        return map;
    }

    public static Map<String, Object> u(com.bytedance.sdk.openadsdk.core.kj.bc bcVar, long j, com.bykv.vk.openvk.component.video.api.u uVar) {
        HashMap map = new HashMap();
        map.put("creative_id", bcVar.lk());
        map.put("buffers_time", Long.valueOf(j));
        com.bykv.vk.openvk.component.video.api.fx.b bVarK = zx.k(bcVar);
        if (bVarK != null) {
            map.put(WfConstant.EXTRA_KEY_VIDEO_SIZE, Long.valueOf(bVarK.pn()));
            map.put("video_resolution", bVarK.a());
        }
        u(map, uVar);
        return map;
    }

    private static void u(Map<String, Object> map, com.bykv.vk.openvk.component.video.api.u uVar) {
        if (map.containsKey("video_resolution") || uVar == null) {
            return;
        }
        try {
            map.put("video_resolution", String.format(Locale.getDefault(), "%d×%d", Integer.valueOf(uVar.t()), Integer.valueOf(uVar.l())));
        } catch (Throwable unused) {
        }
    }

    public static String u(Context context) {
        Locale locale;
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                locale = context.getResources().getConfiguration().getLocales().get(0);
            } else {
                locale = Locale.getDefault();
            }
            return locale.getLanguage();
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.nr("ToolUtils", e.toString());
            return "";
        }
    }

    public static boolean u(boolean z, com.bytedance.sdk.openadsdk.core.kj.bc bcVar, String str) {
        if (z || bcVar == null) {
            return false;
        }
        try {
            com.bytedance.sdk.openadsdk.core.kj.my myVarKv = bcVar.kv();
            if (!(bcVar.hl() || (myVarKv != null && myVarKv.fx() == 2 && !myVarKv.u() && com.bytedance.sdk.openadsdk.core.nr.u().get("dpl_reject_by_dialog", false)))) {
                return false;
            }
            String strJf = bcVar.jf();
            if (TextUtils.isEmpty(strJf) && myVarKv != null && myVarKv.pn() == 1 && !TextUtils.isEmpty(myVarKv.b())) {
                strJf = myVarKv.b();
            }
            if (!TextUtils.isEmpty(strJf)) {
                com.bytedance.sdk.openadsdk.core.pb.u(strJf, bcVar, str);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String u(String str, boolean z) {
        return u(str, z, 0);
    }

    private static String u(String str, boolean z, int i) {
        String strMy = i == 0 ? com.bytedance.sdk.openadsdk.core.dw.nr().my() : o(com.bytedance.sdk.openadsdk.core.dw.nr().q());
        String str2 = "/ad_union_qa/sdk/get_ads";
        if (com.bytedance.sdk.openadsdk.tools.nr.u() && com.bytedance.sdk.openadsdk.core.n.o().kw() && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strMy = com.bytedance.sdk.openadsdk.core.n.o().f();
            str = "/ad_union_qa/sdk/get_ads";
        }
        if (com.bytedance.sdk.openadsdk.core.n.o().ju() != null && a().equals("com.pangolin_demo.toutiao") && TextUtils.equals(str, "/api/ad/union/sdk/get_ads/")) {
            strMy = com.bytedance.sdk.openadsdk.core.n.o().f();
        } else {
            str2 = str;
        }
        String strU = String.format("https://%s%s", strMy, str2);
        if (m.u()) {
            if (!z) {
                strU = m.nr(strU);
            }
            String strU2 = m.u("testIp.txt");
            if (strU2 != null) {
                strU = m.u(strU, strU2);
            }
        }
        return z ? bg(strU) : strU;
    }

    public static boolean u(long j, long j2) {
        long j3 = j2 - j;
        return j3 < 86400000 && j3 > -86400000 && u(j) == u(j2);
    }

    public static long u(long j) {
        return (j + ((long) TimeZone.getDefault().getOffset(j))) / 86400000;
    }

    public static Bundle u(int i, Bundle bundle) {
        int i2 = bundle.getInt("callback_extra_key_reward_amount");
        String string = bundle.getString("callback_extra_key_reward_name");
        int i3 = bundle.getInt("callback_extra_key_error_code");
        String string2 = bundle.getString("callback_extra_key_error_msg");
        float f = bundle.getFloat("callback_extra_key_reward_propose");
        boolean z = bundle.getBoolean("callback_extra_key_video_complete_reward");
        boolean z2 = bundle.getBoolean("callback_extra_key_is_server_verify");
        Bundle bundle2 = new Bundle();
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_CODE, i3);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_ERROR_MSG, string2);
        bundle2.putString(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_NAME, string);
        bundle2.putInt(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_AMOUNT, i2);
        bundle2.putFloat(TTRewardVideoAd.REWARD_EXTRA_KEY_REWARD_PROPOSE, f);
        bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_IS_SERVER_VERIFY, z2);
        if (i == 0) {
            bundle2.putBoolean(TTRewardVideoAd.REWARD_EXTRA_KEY_HAS_VIDEO_COMPLETE_REWARD, z);
        }
        return bundle2;
    }

    public static String u(int[] iArr) {
        if (iArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iArr.length; i++) {
            if (i < iArr.length - 1) {
                sb.append(iArr[i] + ",");
            } else {
                sb.append(iArr[i]);
            }
        }
        return sb.toString();
    }

    public static void u(Intent intent, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.dw.nr().db()) {
            intent.putExtra("multi_process_materialmeta", bcVar.et().toString());
            return;
        }
        String strDv = bcVar.dv();
        intent.putExtra("multi_process_materialmeta_key", strDv);
        if (com.bytedance.sdk.component.utils.bq.u(com.bytedance.sdk.openadsdk.core.dw.getContext())) {
            com.bytedance.sdk.openadsdk.core.c.u(strDv, bcVar, com.bytedance.sdk.openadsdk.core.kj.bc.class);
        } else {
            bf.u("sp_meta").put(strDv, com.bytedance.sdk.component.utils.u.nr(bcVar.et().toString()));
        }
    }

    public static int u(Class cls) {
        if (TTWebPageActivity.class.equals(cls)) {
            return 0;
        }
        if (TTNativePageActivity.class.equals(cls)) {
            return 2;
        }
        if (TTVideoWebPageActivity.class.equals(cls)) {
            return 3;
        }
        return TTVideoScrollWebPageActivity.class.equals(cls) ? 4 : 0;
    }

    public static void u(Map<String, Object> map, com.bytedance.sdk.openadsdk.core.kj.bc bcVar) {
        if (bcVar == null || map == null) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.dw.nr().db()) {
            map.put("multi_process_materialmeta", bcVar.et().toString());
            return;
        }
        String strDv = bcVar.dv();
        map.put("multi_process_materialmeta_key", strDv);
        if (com.bytedance.sdk.component.utils.bq.u(com.bytedance.sdk.openadsdk.core.dw.getContext())) {
            com.bytedance.sdk.openadsdk.core.c.u(strDv, bcVar, com.bytedance.sdk.openadsdk.core.kj.bc.class);
        } else {
            bf.u("sp_meta").put(strDv, com.bytedance.sdk.component.utils.u.nr(bcVar.et().toString()));
        }
    }

    public static com.bytedance.sdk.openadsdk.core.kj.bc u(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            String stringExtra = intent.getStringExtra("multi_process_materialmeta");
            if (!TextUtils.isEmpty(stringExtra)) {
                com.bytedance.sdk.openadsdk.core.kj.bc bcVarU = com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(stringExtra));
                if (bcVarU != null) {
                    return bcVarU;
                }
            }
        } catch (Exception e) {
            com.bytedance.sdk.component.utils.k.u("ToolUtils", "getMaterialMeta from intent failed", e);
        }
        String stringExtra2 = intent.getStringExtra("multi_process_materialmeta_key");
        com.bytedance.sdk.openadsdk.core.kj.bc bcVar = (com.bytedance.sdk.openadsdk.core.kj.bc) com.bytedance.sdk.openadsdk.core.c.nr(stringExtra2, com.bytedance.sdk.openadsdk.core.kj.bc.class);
        if (bcVar != null) {
            return bcVar;
        }
        com.bytedance.sdk.component.b.nr.fx fxVarU = bf.u("sp_meta");
        String strFx = com.bytedance.sdk.component.utils.u.fx(fxVarU.get(stringExtra2, ""));
        try {
            if (TextUtils.isEmpty(strFx)) {
                com.bytedance.sdk.component.utils.k.nr("ToolUtils", "getMaterialMeta from keva failed , md5" + stringExtra2);
                return null;
            }
            return com.bytedance.sdk.openadsdk.core.u.u(new JSONObject(strFx));
        } catch (Exception e2) {
            com.bytedance.sdk.component.utils.k.u("ToolUtils", "getMaterialMeta from keva failed", e2);
            return null;
        } finally {
            fxVarU.remove(stringExtra2);
        }
    }

    public static boolean u(String str, AtomicInteger atomicInteger) {
        if (TextUtils.isEmpty(str) || atomicInteger == null) {
            return true;
        }
        if (atomicInteger.get() == 1) {
            return false;
        }
        if (str.startsWith("bytedance") || str.startsWith("nativeapp")) {
            return true;
        }
        if (!(str.startsWith("https:") || str.startsWith("http:"))) {
            return true;
        }
        Set<String> set = com.bytedance.sdk.openadsdk.core.kj.bf.u;
        if (set.isEmpty()) {
            d();
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host) || set.isEmpty()) {
            return true;
        }
        for (String str2 : set) {
            if (!TextUtils.isEmpty(str2) && host.contains(str2)) {
                return true;
            }
        }
        return false;
    }
}
