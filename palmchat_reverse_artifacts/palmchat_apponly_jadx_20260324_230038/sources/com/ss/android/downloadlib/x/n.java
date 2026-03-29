package com.ss.android.downloadlib.x;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.baidu.mapapi.SDKInitializer;
import com.cdo.oaps.ad.OapsKey;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.gdt.action.ActionUtils;
import com.ss.android.download.api.config.DownloadMarketInterceptor;
import com.ss.android.download.api.config.bg;
import com.ss.android.download.api.constant.BaseConstants;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadlib.activity.JumpKllkActivity;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.wifi.adsdk.utils.BLPlatform;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class n {
    private static final String u = "n";

    private static void a(Context context, com.ss.android.downloadlib.addownload.nr.pn pnVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.u(str, pnVar.u, BaseConstants.VIVO_MARKET_NEED_COMMENT);
        } catch (Exception unused) {
            com.ss.android.downloadlib.nr.u.u(u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
            nr(pnVar, jSONObject, 9, 8, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.nr.x b(@NonNull Context context, @NonNull String str) {
        try {
            Uri uri = Uri.parse("https://www.samsungapps.com/appquery/appDetail.as?appId=" + str);
            Intent intent = new Intent();
            intent.setClassName("com.sec.android.app.samsungapps", "com.sec.android.app.samsungapps.Main");
            intent.setData(uri);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.nr.x(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.nr.x(6, 14);
        }
    }

    private static void fx(Context context, com.ss.android.downloadlib.addownload.nr.pn pnVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.u(context, str, pnVar.u);
        } catch (Exception unused) {
            com.ss.android.downloadlib.nr.u.u(u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
            nr(pnVar, jSONObject, 14, 11, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static void iz(final Context context, final com.ss.android.downloadlib.addownload.nr.pn pnVar, final String str) {
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.x.n.6
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
                final JSONObject jSONObject = new JSONObject();
                try {
                    String strOptString = jSONObjectA.optString("s");
                    String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bw"), strOptString);
                    String strU2 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bx"), strOptString);
                    String strU3 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("by"), strOptString);
                    Uri.Builder builder = new Uri.Builder();
                    builder.scheme(BaseConstants.SCHEME_HTTPS).authority(strU).appendPath(strU2).appendQueryParameter(strU3, str);
                    com.ss.android.downloadlib.addownload.l.b().u("GET", builder.build().toString(), null, new bg() { // from class: com.ss.android.downloadlib.x.n.6.1
                        /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
                        @Override // com.ss.android.download.api.config.bg
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                        */
                        public void u(String str2) {
                            boolean z;
                            if (!TextUtils.isEmpty(str2)) {
                                String strFx = n.fx(str2);
                                if (!TextUtils.isEmpty(strFx)) {
                                    String strB = n.b(strFx);
                                    if (TextUtils.isEmpty(strB)) {
                                        z = false;
                                    } else {
                                        AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                                        n.nr(context, pnVar, str, strB);
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                return;
                            }
                            com.ss.android.downloadlib.nr.u.u(n.u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
                            n.nr(pnVar, jSONObject, 10, 9, BaseConstants.MARKET_PREFIX + str);
                        }

                        @Override // com.ss.android.download.api.config.bg
                        public void u(Throwable th) {
                            com.ss.android.downloadlib.nr.u.u(n.u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
                            mv.u(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : com.igexin.push.core.b.m);
                            n.nr(pnVar, jSONObject, 11, 9, BaseConstants.MARKET_PREFIX + str);
                        }
                    });
                } catch (Exception unused) {
                    n.nr(pnVar, jSONObject, 4, 9, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void n(final Context context, final com.ss.android.downloadlib.addownload.nr.pn pnVar, final String str) {
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.x.n.7
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
                String strOptString = jSONObjectA.optString("s");
                final JSONObject jSONObject = new JSONObject();
                String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("x"), strOptString);
                JSONObject jSONObject2 = new JSONObject();
                mv.u(jSONObject2, "t", "v");
                mv.u(jSONObject2, "p", str);
                byte[] bytes = jSONObject2.toString().getBytes();
                com.ss.android.downloadlib.addownload.l.b().u(strU, com.ss.android.downloadlib.addownload.l.sx().u(bytes, bytes.length), "application/octet-stream;tt-data=a", 0, new bg() { // from class: com.ss.android.downloadlib.x.n.7.1
                    @Override // com.ss.android.download.api.config.bg
                    public void u(String str2) {
                        AnonymousClass7 anonymousClass7 = AnonymousClass7.this;
                        n.nr(context, str, str2, pnVar, jSONObject);
                    }

                    @Override // com.ss.android.download.api.config.bg
                    public void u(Throwable th) {
                        com.ss.android.downloadlib.nr.u.u(n.u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
                        mv.u(jSONObject, "ttdownloader_message", th != null ? th.getMessage() : com.igexin.push.core.b.m);
                        n.nr(pnVar, jSONObject, 7, 5, BaseConstants.MARKET_PREFIX + str);
                    }
                });
            }
        });
    }

    private static void pn(final Context context, final com.ss.android.downloadlib.addownload.nr.pn pnVar, final String str) {
        com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.x.n.5
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.downloadlib.nr.u.u(n.u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
                JSONObject jSONObject = new JSONObject();
                try {
                    JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
                    Thread.sleep(jSONObjectA.optInt("m2_delay_millis", 1000));
                    com.ss.android.downloadlib.u.u.u.u().u(context, true);
                    com.ss.android.downloadlib.u.u.nr nrVar = new com.ss.android.downloadlib.u.u.nr();
                    nrVar.u = 1;
                    nrVar.nr = 0;
                    String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("v"), jSONObjectA.optString("s"));
                    nrVar.fx = String.format(strU, str);
                    com.ss.android.downloadlib.u.u.u.u().u(nrVar, (com.ss.android.downloadlib.u.u.b) null);
                    com.ss.android.downloadlib.u.u.u.u().nr();
                    n.nr(pnVar, jSONObject, -1, 2, String.format(strU, str));
                } catch (Throwable unused) {
                    n.nr(pnVar, jSONObject, 1, 2, BaseConstants.MARKET_PREFIX + str);
                }
            }
        });
    }

    private static void x(Context context, com.ss.android.downloadlib.addownload.nr.pn pnVar, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.u(str, pnVar.u);
        } catch (Exception unused) {
            com.ss.android.downloadlib.nr.u.u(u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
            nr(pnVar, jSONObject, 13, 10, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static com.ss.android.downloadlib.addownload.nr.x nr(Context context, com.ss.android.downloadlib.addownload.nr.pn pnVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra("p", str);
        intent.putExtra("id", pnVar.u);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.nr.x(7, "am_kllk2");
        } catch (Throwable unused) {
            nr(pnVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    public static boolean fx(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strJk = com.ss.android.socialbase.appdownloader.iz.pn.jk();
        if (mv.pn(com.ss.android.downloadlib.addownload.l.getContext(), strJk)) {
            intent.setPackage(strJk);
        }
        if (!mv.u(com.ss.android.downloadlib.addownload.l.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "start HM2");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.nr.x u(Context context, Uri uri) {
        Intent intent;
        if (!com.ss.android.socialbase.appdownloader.iz.pn.fx() && (context == null || uri == null || !BaseConstants.SCHEME_MARKET.equals(uri.getScheme()))) {
            return new com.ss.android.downloadlib.addownload.nr.x(6, 12);
        }
        try {
            String strJk = com.ss.android.socialbase.appdownloader.iz.pn.jk();
            if (com.ss.android.socialbase.appdownloader.iz.pn.o() && (TextUtils.isEmpty(strJk) || !mv.pn(context, strJk))) {
                strJk = com.huawei.openalliance.ad.constant.x.ad;
                Uri.Builder builderBuildUpon = uri.buildUpon();
                builderBuildUpon.scheme(BaseConstants.SCHEME_MARKET);
                intent = new Intent("android.intent.action.VIEW", builderBuildUpon.build());
            } else {
                intent = new Intent("android.intent.action.VIEW", uri);
            }
            if (!mv.u(context, intent)) {
                return new com.ss.android.downloadlib.addownload.nr.x(6, 13);
            }
            if (mv.pn(context, strJk) && !com.ss.android.socialbase.appdownloader.iz.pn.x()) {
                intent.setPackage(strJk);
            }
            if (com.ss.android.socialbase.downloader.n.u.fx().u("fix_jump_market")) {
                intent.addFlags(335544320);
            } else if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (com.ss.android.socialbase.downloader.n.u.fx().nr("test_jump_market_failed") == 1) {
                com.ss.android.downloadlib.pn.fx.u().u(false, "jump market error");
                return new com.ss.android.downloadlib.addownload.nr.x(6, 25);
            }
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.nr.x(5);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.nr.x(6, 14);
        }
    }

    private static com.ss.android.downloadlib.addownload.nr.x b(Context context, com.ss.android.downloadlib.addownload.nr.pn pnVar, String str) {
        Intent intent = new Intent(context, (Class<?>) JumpKllkActivity.class);
        intent.addFlags(268435456);
        intent.putExtra(CmcdConfiguration.KEY_DEADLINE, true);
        intent.putExtra("p", str);
        intent.putExtra("id", pnVar.u);
        if (Build.VERSION.SDK_INT >= 29) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_HEYTAP_PKG_INFO);
        } else if (mv.pn(context, BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO);
        } else if (mv.pn(context, BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO)) {
            intent.putExtra("bk", BaseConstants.KLLK_PROMOTION_COLOROS_PKG_INFO);
        } else {
            return u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        JSONObject jSONObject = new JSONObject();
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.nr.x(7, "am_kllk3");
        } catch (Throwable unused) {
            nr(pnVar, jSONObject, 1, 3, BaseConstants.MARKET_PREFIX + str);
            return u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(Context context, String str, String str2, @NonNull com.ss.android.downloadlib.addownload.nr.pn pnVar, @NonNull JSONObject jSONObject) {
        mv.u(jSONObject, "ttdownloader_type", (Object) 5);
        try {
            String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(new JSONObject(str2).optString("a"));
            if (!TextUtils.isEmpty(strU)) {
                TTDelegateActivity.u(str, pnVar.u, strU, jSONObject);
                return;
            }
            com.ss.android.downloadlib.nr.u.u(u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
            nr(pnVar, jSONObject, 5, 5, BaseConstants.MARKET_PREFIX + str);
        } catch (Exception unused) {
            com.ss.android.downloadlib.nr.u.u(u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
            nr(pnVar, jSONObject, 6, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static boolean fx(Context context, String str) {
        if (context == null) {
            return false;
        }
        try {
            Uri uri = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(uri);
            intent.addFlags(268435456);
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String fx(String str) {
        Matcher matcher = Pattern.compile("<input[\\s\\S]*>\\n").matcher(str);
        String strGroup = matcher.find() ? matcher.group() : "";
        if (!strGroup.equals(null) && strGroup.length() > 0) {
            for (String str2 : strGroup.split("\\n")) {
                if (str2.startsWith("<input")) {
                    for (String str3 : str2.split("\\s")) {
                        if (str3.startsWith(ActionUtils.PAYMENT_AMOUNT)) {
                            return str3.substring(7, str3.length() - 1);
                        }
                    }
                }
            }
        }
        return null;
    }

    public static boolean nr(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strJk = com.ss.android.socialbase.appdownloader.iz.pn.jk();
        if (mv.pn(com.ss.android.downloadlib.addownload.l.getContext(), strJk)) {
            intent.setPackage(strJk);
        }
        if (!mv.u(com.ss.android.downloadlib.addownload.l.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "start HM1");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.nr.x u(final Context context, Uri uri, com.ss.android.downloadlib.addownload.nr.pn pnVar) {
        com.ss.android.downloadad.api.u.nr nrVar;
        if (context != null && com.ss.android.downloadlib.nr.jk.u(uri)) {
            try {
                final Intent intent = new Intent("android.intent.action.VIEW", uri);
                if (!mv.u(context, intent)) {
                    return new com.ss.android.downloadlib.addownload.nr.x(6, 13);
                }
                String strJk = com.ss.android.socialbase.appdownloader.iz.pn.jk();
                if (mv.pn(context, strJk)) {
                    intent.setPackage(strJk);
                }
                intent.addFlags(335544320);
                if (com.ss.android.socialbase.downloader.n.u.fx().nr("test_jump_market_failed") == 1 && "local_test".equals(com.ss.android.downloadlib.addownload.l.jk().fx)) {
                    com.ss.android.downloadlib.pn.fx.u().u(false, "jump market error");
                    return new com.ss.android.downloadlib.addownload.nr.x(6, 25);
                }
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                long jOptLong = com.ss.android.downloadlib.addownload.l.a().optLong("market_jump_delay", 1000L);
                if (jOptLong > 0 && pnVar != null && (nrVar = pnVar.pn) != null && !nrVar.kw()) {
                    com.ss.android.downloadlib.n.u().nr().post(new Runnable() { // from class: com.ss.android.downloadlib.x.n.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.ss.android.downloadlib.addownload.l.fx().u(8, com.ss.android.downloadlib.addownload.l.getContext(), null, "浏览器跳转失败，正在前往应用商店", null, 0);
                        }
                    });
                }
                com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.x.n.2
                    @Override // java.lang.Runnable
                    public void run() {
                        context.startActivity(intent);
                    }
                }, jOptLong);
                return new com.ss.android.downloadlib.addownload.nr.x(5);
            } catch (Exception unused) {
                return new com.ss.android.downloadlib.addownload.nr.x(6, 14);
            }
        }
        return new com.ss.android.downloadlib.addownload.nr.x(6, 12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str) {
        List<String> pathSegments = Uri.parse(str).getPathSegments();
        if (pathSegments.size() > 0) {
            return pathSegments.get(pathSegments.size() - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(com.ss.android.downloadlib.addownload.nr.pn pnVar, JSONObject jSONObject, int i, int i2, String str) {
        mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
        mv.u(jSONObject, "ttdownloader_type", Integer.valueOf(i2));
        mv.u(jSONObject, "rmu", str);
        mv.u(jSONObject, com.ss.android.socialbase.appdownloader.iz.pn.jk(), Integer.valueOf(mv.nr(com.ss.android.downloadlib.addownload.l.getContext(), com.ss.android.socialbase.appdownloader.iz.pn.jk())));
        com.ss.android.downloadlib.b.u.u().nr("am_result", jSONObject, pnVar);
    }

    public static com.ss.android.downloadlib.addownload.nr.x nr(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.nr.x(4, 11);
        }
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.l.getContext();
        }
        Intent intentX = mv.x(context, str);
        if (intentX == null) {
            return new com.ss.android.downloadlib.addownload.nr.x(4, 22);
        }
        intentX.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intentX);
            return new com.ss.android.downloadlib.addownload.nr.x(3);
        } catch (Exception unused) {
            return new com.ss.android.downloadlib.addownload.nr.x(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.nr.x nr(String str, com.ss.android.downloadad.api.u.u uVar) {
        if (TextUtils.isEmpty(str)) {
            return new com.ss.android.downloadlib.addownload.nr.x(2, 21);
        }
        Context context = com.ss.android.downloadlib.addownload.l.getContext();
        String packageName = uVar.dw().getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            l.u().u(u, "tryOpenByUrl", "获取到跳转中转Activity的intent");
            Intent intentU = u(context, uVar, packageName, 2, str);
            if (intentU != null) {
                com.ss.android.downloadlib.addownload.nr.x xVarU = u(context, intentU, uVar, true, str);
                if (xVarU.getType() == 1) {
                    return xVarU;
                }
            }
        }
        Uri uri = Uri.parse(str);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.addFlags(268435456);
        intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        if (com.ss.android.socialbase.downloader.n.u.fx().u("fix_app_link_flag")) {
            intent.addFlags(67108864);
        }
        return u(context, intent, uVar, false, str);
    }

    public static com.ss.android.downloadlib.addownload.nr.x u(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.iz.pn.x() && mv.pn(context, "com.sec.android.app.samsungapps")) {
                return b(context, str);
            }
            return u(context, com.ss.android.download.api.fx.u.u(context, str));
        }
        return new com.ss.android.downloadlib.addownload.nr.x(6, 11);
    }

    public static com.ss.android.downloadlib.addownload.nr.x u(Context context, com.ss.android.downloadlib.addownload.nr.pn pnVar, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (com.ss.android.socialbase.appdownloader.iz.pn.x() && mv.pn(context, "com.sec.android.app.samsungapps")) {
                return b(context, str);
            }
            if (pnVar.nr.isAd() && pnVar.b.enableAM()) {
                JSONArray jSONArrayOptJSONArray = com.ss.android.downloadlib.addownload.l.a().optJSONArray("am_plans");
                if (com.ss.android.socialbase.appdownloader.iz.pn.pn() && com.ss.android.socialbase.appdownloader.iz.u.u(jSONArrayOptJSONArray, "am_3")) {
                    return nr(context, pnVar, str);
                }
                if (com.ss.android.socialbase.appdownloader.iz.pn.iz() && com.ss.android.socialbase.appdownloader.iz.u.u(jSONArrayOptJSONArray, "am_2")) {
                    pn(context, pnVar, str);
                    return new com.ss.android.downloadlib.addownload.nr.x(7, "am_m2");
                }
                if (com.ss.android.socialbase.appdownloader.iz.pn.b() && com.ss.android.socialbase.appdownloader.iz.u.u(jSONArrayOptJSONArray, "am_5")) {
                    n(context, pnVar, str);
                    return new com.ss.android.downloadlib.addownload.nr.x(7, "am_v1");
                }
                if (com.ss.android.socialbase.appdownloader.iz.pn.pn() && com.ss.android.socialbase.appdownloader.iz.u.u(jSONArrayOptJSONArray, "am_7")) {
                    DownloadController downloadController = pnVar.b;
                    if ((downloadController instanceof AdDownloadController) && ((AdDownloadController) downloadController).enableOppoAutoDownload()) {
                        return b(context, pnVar, str);
                    }
                }
                if (com.ss.android.socialbase.appdownloader.iz.pn.b() && com.ss.android.socialbase.appdownloader.iz.u.u(jSONArrayOptJSONArray, "am_8") && mv.u(mv.fx(context, BLPlatform.VIVO_APPSTORE_PN), BaseConstants.VIVO_V2_REQUIRED_MARKET_VERSION) >= 0) {
                    a(context, pnVar, str);
                    return new com.ss.android.downloadlib.addownload.nr.x(7, "am_v2");
                }
                if ((com.ss.android.socialbase.appdownloader.iz.pn.u() || com.ss.android.socialbase.appdownloader.iz.pn.nr()) && com.ss.android.socialbase.appdownloader.iz.u.u(jSONArrayOptJSONArray, "am_9")) {
                    iz(context, pnVar, str);
                    return new com.ss.android.downloadlib.addownload.nr.x(7, "am_hr");
                }
                if ((com.ss.android.socialbase.appdownloader.iz.pn.u() || com.ss.android.socialbase.appdownloader.iz.pn.nr()) && com.ss.android.socialbase.appdownloader.iz.u.u(jSONArrayOptJSONArray, "am_10")) {
                    x(context, pnVar, str);
                    return new com.ss.android.downloadlib.addownload.nr.x(7, "am_hr2");
                }
                DownloadController downloadController2 = pnVar.b;
                if ((downloadController2 instanceof AdDownloadController) && ((AdDownloadController) downloadController2).enableOppoAutoDownload() && ((AdDownloadController) pnVar.b).getDownloadMarketInterceptor() != null && pnVar.nr.getDownloadSettings().optInt("is_use_obm_convert", 0) == 1) {
                    fx(context, pnVar, str);
                    return new com.ss.android.downloadlib.addownload.nr.x(7, "am_kllk4");
                }
                return u(context, com.ss.android.download.api.fx.u.u(context, str));
            }
            return u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str));
        }
        return new com.ss.android.downloadlib.addownload.nr.x(6, 11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void nr(Context context, @NonNull com.ss.android.downloadlib.addownload.nr.pn pnVar, @NonNull String str, @NonNull String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            TTDelegateActivity.nr(str, pnVar.u, str2);
        } catch (Exception unused) {
            com.ss.android.downloadlib.nr.u.u(u(context, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVar, true);
            nr(pnVar, jSONObject, 12, 9, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void nr(@NonNull Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
        String strOptString = jSONObjectA.optString("s");
        String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bz"), strOptString);
        String strU2 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString(com.igexin.push.core.b.ac), strOptString);
        String strU3 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString(OapsKey.KEY_CALLBACK), strOptString);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.MARKET_SCHEME_HW_HONOR).authority(com.huawei.openalliance.ad.constant.x.ad);
        if (!TextUtils.isEmpty(strU)) {
            builder.appendQueryParameter(strU, str2);
        }
        if (!TextUtils.isEmpty(strU2) && !TextUtils.isEmpty(strU3)) {
            builder.appendQueryParameter(strU2, strU3);
        }
        if (nr(activity, builder.build())) {
            nr(pnVarPn, jSONObject, -1, 9, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.nr.u.u("am_hr", jSONObject, pnVarPn, true);
            return;
        }
        nr(pnVarPn, jSONObject, 2, 9, BaseConstants.MARKET_PREFIX + str);
        com.ss.android.downloadlib.nr.u.u(u((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
    }

    public static void nr(@NonNull Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        JSONObject jSONObject = new JSONObject();
        DownloadController downloadController = pnVarPn.b;
        if (downloadController instanceof AdDownloadController) {
            boolean zEnableOppoAutoDownload = ((AdDownloadController) downloadController).enableOppoAutoDownload();
            HashMap map = new HashMap();
            map.put("is_button", Boolean.valueOf(zEnableOppoAutoDownload));
            mv.u(jSONObject, "is_button", Boolean.valueOf(zEnableOppoAutoDownload));
            DownloadMarketInterceptor downloadMarketInterceptor = ((AdDownloadController) pnVarPn.b).getDownloadMarketInterceptor();
            if (downloadMarketInterceptor != null) {
                Map<String, Object> mapInterceptObmMarket = downloadMarketInterceptor.interceptObmMarket(map);
                if (mapInterceptObmMarket != null && mapInterceptObmMarket.get("convert_result") != null && Boolean.parseBoolean(mapInterceptObmMarket.get("convert_result").toString())) {
                    nr(pnVarPn, jSONObject, -1, 11, BaseConstants.MARKET_PREFIX + str);
                    com.ss.android.downloadlib.nr.u.u("am_kllk4", jSONObject, pnVarPn, true);
                    return;
                }
                nr(pnVarPn, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
                com.ss.android.downloadlib.nr.u.u(u((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
                return;
            }
            nr(pnVarPn, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.nr.u.u(u((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
            return;
        }
        nr(pnVarPn, jSONObject, 15, 11, BaseConstants.MARKET_PREFIX + str);
        com.ss.android.downloadlib.nr.u.u(u((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
    }

    public static boolean u(Context context, com.ss.android.downloadlib.addownload.nr.pn pnVar, String str, JSONObject jSONObject, boolean z, int i) {
        mv.u(jSONObject, "download_scene", Integer.valueOf(pnVar.bq()));
        com.ss.android.downloadlib.b.u.u().nr("market_click_open", jSONObject, pnVar);
        com.ss.android.downloadlib.addownload.nr.x xVarU = u(context, Uri.parse(str));
        String strU = mv.u(xVarU.nr(), "open_market");
        int type = xVarU.getType();
        if (type == 5) {
            com.ss.android.downloadlib.nr.u.u(strU, jSONObject, pnVar, true);
        } else {
            if (type == 6) {
                mv.u(jSONObject, SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(xVarU.u()));
                mv.u(jSONObject, "download_scene", Integer.valueOf(pnVar.bq()));
                com.ss.android.downloadlib.b.u.u().nr("market_open_failed", jSONObject, pnVar);
                return false;
            }
            if (type != 7) {
                return false;
            }
        }
        if (z) {
            com.ss.android.downloadlib.b.u.u().u(pnVar.u, i);
        }
        return true;
    }

    public static void u(Context context, String str, long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        try {
            JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
            String strOptString = jSONObjectA.optString("s");
            String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("aa"), strOptString);
            String strU2 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString(OapsKey.KEY_ACTIVE_CODE), strOptString);
            String strU3 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("af"), strOptString);
            boolean zU = com.ss.android.socialbase.appdownloader.iz.u.u(jSONObjectA, context, strU2);
            StringBuilder sb = new StringBuilder(String.format(strU, str, strU3, strU2));
            Intent intent = new Intent("android.intent.action.VIEW");
            String strJk = com.ss.android.socialbase.appdownloader.iz.pn.jk();
            if (mv.pn(context, strJk)) {
                intent.setPackage(strJk);
            }
            if (z) {
                sb.append(com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("ae"), strOptString));
            } else {
                intent.addFlags(335544320);
            }
            mv.u(jSONObject, "mf", Boolean.valueOf(zU));
            mv.u(jSONObject, RXScreenCaptureService.KEY_IFRAMERATE, Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            context.startActivity(intent);
            com.ss.android.downloadlib.nr.u.u("am_kllk2", jSONObject, pnVarPn, true);
            if (zU) {
                nr(pnVarPn, jSONObject, -1, 3, sb.toString());
            } else {
                nr(pnVarPn, jSONObject, 3, 3, sb.toString());
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.nr.u.u(u(com.ss.android.downloadlib.addownload.l.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
            nr(pnVarPn, jSONObject, 2, 3, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void u(final Context context, String str, long j, String str2, boolean z) {
        JSONObject jSONObject = new JSONObject();
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        try {
            JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
            String strOptString = jSONObjectA.optString("s");
            String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("br"), strOptString);
            String strU2 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bs_1"), strOptString);
            String strU3 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bs_2"), strOptString);
            String strU4 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bs_3"), strOptString);
            String strU5 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bt"), strOptString);
            String strU6 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bu"), strOptString);
            StringBuilder sb = new StringBuilder(String.format("https://", new Object[0]));
            sb.append(strU);
            sb.append(strU2);
            sb.append(strU3);
            sb.append(strU4);
            sb.append(strU5);
            sb.append(strU6);
            final Intent intent = new Intent("android.intent.action.VIEW");
            intent.setPackage(str2);
            if (z) {
                sb.append("pkg=" + str);
                sb.append("&dl=true");
            } else {
                intent.addFlags(335544320);
            }
            mv.u(jSONObject, CmcdConfiguration.KEY_DEADLINE, Boolean.valueOf(z));
            intent.setData(Uri.parse(sb.toString()));
            intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
            long jOptLong = com.ss.android.downloadlib.addownload.l.a().optLong("oppo_browser_jump_delay", 1000L);
            if (jOptLong > 0) {
                com.ss.android.downloadlib.n.u().nr().post(new Runnable() { // from class: com.ss.android.downloadlib.x.n.3
                    @Override // java.lang.Runnable
                    public void run() {
                        com.ss.android.downloadlib.addownload.l.fx().u(12, com.ss.android.downloadlib.addownload.l.getContext(), null, "正在前往浏览器下载", null, 0);
                    }
                });
            }
            com.ss.android.downloadlib.pn.u().u(new Runnable() { // from class: com.ss.android.downloadlib.x.n.4
                @Override // java.lang.Runnable
                public void run() {
                    context.startActivity(intent);
                }
            }, jOptLong);
            com.ss.android.downloadad.api.u.nr nrVar = pnVarPn.pn;
            if (nrVar != null) {
                nrVar.c(true);
            }
            com.ss.android.downloadlib.nr.u.u("am_kllk3", jSONObject, pnVarPn, true);
            nr(pnVarPn, jSONObject, -1, 7, sb.toString());
        } catch (Exception unused) {
            com.ss.android.downloadad.api.u.nr nrVar2 = pnVarPn.pn;
            if (nrVar2 != null) {
                nrVar2.c(false);
            }
            com.ss.android.downloadlib.nr.u.u(u(com.ss.android.downloadlib.addownload.l.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str), pnVarPn), pnVarPn, true);
            nr(pnVarPn, jSONObject, 2, 7, BaseConstants.MARKET_PREFIX + str);
        }
    }

    private static boolean u(@NonNull Activity activity, @NonNull String str, @NonNull HashMap<String, String> map) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(BaseConstants.MARKET_PREFIX + str));
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        intent.putExtra(RemoteMessageConst.MessageBody.PARAM, map);
        String strJk = com.ss.android.socialbase.appdownloader.iz.pn.jk();
        if (mv.pn(com.ss.android.downloadlib.addownload.l.getContext(), strJk)) {
            intent.setPackage(strJk);
        }
        if (!mv.u(com.ss.android.downloadlib.addownload.l.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "start v1");
            return false;
        }
    }

    public static void u(@NonNull Activity activity, String str, long j, String str2, String str3) {
        JSONObject jSONObject;
        int i;
        try {
            jSONObject = new JSONObject(str3);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        try {
            JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
            boolean zU = com.ss.android.socialbase.appdownloader.iz.u.u(jSONObjectA, activity, com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString(OapsKey.KEY_BG), jSONObjectA.optString("s")));
            HashMap<String, String> mapNr = mv.nr(new JSONObject(str2));
            if (zU && !mapNr.isEmpty() && u(activity, str, mapNr)) {
                nr(pnVarPn, jSONObject, -1, 5, BaseConstants.MARKET_PREFIX + str);
                com.ss.android.downloadlib.nr.u.u("am_v1", jSONObject, pnVarPn, true);
                return;
            }
            if (zU) {
                i = mapNr.isEmpty() ? 1 : 2;
            } else {
                i = 3;
            }
            nr(pnVarPn, jSONObject, i, 5, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.nr.u.u(u((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
        } catch (Exception unused2) {
            com.ss.android.downloadlib.nr.u.u(u(com.ss.android.downloadlib.addownload.l.getContext(), Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
            nr(pnVarPn, jSONObject, 4, 5, BaseConstants.MARKET_PREFIX + str);
        }
    }

    public static void u(@NonNull Activity activity, String str, long j, String str2) {
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
        String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString("bv"), jSONObjectA.optString("s"));
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(BaseConstants.SCHEME_MARKET).authority(BaseConstants.MARKET_URI_AUTHORITY_DETAIL).appendQueryParameter("id", str);
        if (!TextUtils.isEmpty(strU)) {
            builder.appendQueryParameter(strU, str2);
        }
        if (u(activity, builder.build())) {
            nr(pnVarPn, jSONObject, -1, 8, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.nr.u.u("am_v2", jSONObject, pnVarPn, true);
            return;
        }
        nr(pnVarPn, jSONObject, 2, 8, BaseConstants.MARKET_PREFIX + str);
        com.ss.android.downloadlib.nr.u.u(u((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
    }

    public static boolean u(@NonNull Activity activity, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri);
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        String strJk = com.ss.android.socialbase.appdownloader.iz.pn.jk();
        if (mv.pn(com.ss.android.downloadlib.addownload.l.getContext(), strJk)) {
            intent.setPackage(strJk);
        }
        if (!mv.u(com.ss.android.downloadlib.addownload.l.getContext(), intent)) {
            return false;
        }
        try {
            activity.startActivity(intent);
            return true;
        } catch (Exception e) {
            com.ss.android.downloadlib.pn.fx.u().u(e, "start v2");
            return false;
        }
    }

    public static com.ss.android.downloadlib.addownload.nr.x u(Context context, String str, com.ss.android.downloadad.api.u.u uVar) {
        Intent intentU = u(context, uVar, str, 1, (String) null);
        if (intentU != null) {
            l.u().u(u, "tryOpenByPackage", "成功构造了跳转中转Activity的intent");
            com.ss.android.downloadlib.addownload.nr.x xVarU = u(intentU, true, context, str, uVar);
            if (xVarU.getType() == 3) {
                return xVarU;
            }
        }
        Intent intentX = mv.x(context, str);
        if (intentX == null) {
            return new com.ss.android.downloadlib.addownload.nr.x(4, 22);
        }
        return u(intentX, false, context, str, uVar);
    }

    private static com.ss.android.downloadlib.addownload.nr.x u(Intent intent, boolean z, Context context, String str, com.ss.android.downloadad.api.u.u uVar) {
        if (Build.VERSION.SDK_INT >= 26 && com.ss.android.downloadlib.addownload.l.a().optInt("open_package_mode") == 1 && com.ss.android.downloadlib.addownload.l.l() != null && com.ss.android.downloadlib.addownload.l.l().u() && uVar.o() && !z) {
            TTDelegateActivity.nr(str, uVar);
            return new com.ss.android.downloadlib.addownload.nr.x(3);
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        try {
            context.startActivity(intent);
            return new com.ss.android.downloadlib.addownload.nr.x(3);
        } catch (Exception e) {
            if (z) {
                l.u().nr(u, "realTryOpenByPackage", "调起中转Activity出现异常，可能是没接转化SDK，回退普通调起" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.nr.x(8, 23);
            }
            l.u().nr(u, "realTryOpenByPackage", "包名调起失败了，抛出异常" + e.getMessage());
            return new com.ss.android.downloadlib.addownload.nr.x(4, 23);
        }
    }

    public static com.ss.android.downloadlib.addownload.nr.x u(String str, com.ss.android.downloadad.api.u.u uVar) {
        return u(com.ss.android.downloadlib.addownload.l.getContext(), str, uVar);
    }

    private static com.ss.android.downloadlib.addownload.nr.x u(Context context, Intent intent, com.ss.android.downloadad.api.u.u uVar, boolean z, String str) {
        if (context == null) {
            context = com.ss.android.downloadlib.addownload.l.getContext();
        }
        if (mv.nr(context, intent)) {
            if (com.ss.android.downloadlib.addownload.l.a().optInt("open_url_mode") == 0 && com.ss.android.downloadlib.addownload.l.l() != null && com.ss.android.downloadlib.addownload.l.l().u() && Build.VERSION.SDK_INT >= 26 && uVar.o() && !z) {
                TTDelegateActivity.u(str, uVar);
                return new com.ss.android.downloadlib.addownload.nr.x(1);
            }
            try {
                context.startActivity(intent);
                return new com.ss.android.downloadlib.addownload.nr.x(1);
            } catch (Exception e) {
                if (z) {
                    l.u().nr(u, "realTryOpenByUrl", "商店直投注入clickId优化url调起场景，抛出异常，没接转化SDK，回退普通调起" + e.getMessage());
                    return new com.ss.android.downloadlib.addownload.nr.x(9);
                }
                l.u().nr(u, "realTryOpenByUrl", "url调起失败了，抛出异常" + e.getMessage());
                return new com.ss.android.downloadlib.addownload.nr.x(2);
            }
        }
        return new com.ss.android.downloadlib.addownload.nr.x(2, 24);
    }

    public static com.ss.android.downloadlib.addownload.nr.x u(@NonNull com.ss.android.downloadad.api.u.nr nrVar, String str, String str2) {
        com.ss.android.downloadlib.addownload.nr.x xVarNr = nr(str, nrVar);
        return (com.ss.android.downloadlib.nr.iz.u(nrVar) && xVarNr.getType() == 2) ? u(str2, nrVar) : xVarNr;
    }

    public static void u(@NonNull Activity activity, String str, long j) {
        com.ss.android.downloadlib.addownload.nr.pn pnVarPn = com.ss.android.downloadlib.addownload.nr.iz.u().pn(j);
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObjectA = com.ss.android.downloadlib.addownload.l.a();
        String strOptString = jSONObjectA.optString("s");
        String strU = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString(com.igexin.push.core.b.ac), strOptString);
        String strU2 = com.ss.android.socialbase.appdownloader.iz.fx.u(jSONObjectA.optString(com.umeng.ccg.a.f11001a), strOptString);
        StringBuilder sb = new StringBuilder(BaseConstants.MARKET_PREFIX);
        if (!TextUtils.isEmpty(strU) && !TextUtils.isEmpty(strU2)) {
            sb.append(str);
            sb.append(ContainerUtils.FIELD_DELIMITER);
            sb.append(strU);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(strU2);
        }
        if (fx(activity, Uri.parse(sb.toString()))) {
            nr(pnVarPn, jSONObject, -1, 10, BaseConstants.MARKET_PREFIX + str);
            com.ss.android.downloadlib.nr.u.u("am_hr2", jSONObject, pnVarPn, true);
            return;
        }
        nr(pnVarPn, jSONObject, 2, 10, BaseConstants.MARKET_PREFIX + str);
        com.ss.android.downloadlib.nr.u.u(u((Context) activity, Uri.parse(BaseConstants.MARKET_PREFIX + str)), pnVarPn, true);
    }

    private static Intent u(Context context, com.ss.android.downloadad.api.u.u uVar, String str, int i, String str2) {
        if (!uVar.fx() || uVar.q() == null || uVar.q().getDownloadMode() != 2 || uVar.dw() == null || pn.u(uVar).u("app_link_market_open_add_info", 0) != 1) {
            return null;
        }
        String strFx = com.ss.android.downloadlib.addownload.a.fx(uVar.dw());
        String strB = com.ss.android.downloadlib.addownload.a.b(uVar.dw());
        Intent intent = new Intent();
        intent.setClassName(str, AdBaseConstants.MARKET_OPEN_BRIDGE_ACTIVITY);
        ResolveInfo resolveInfoResolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        if (TextUtils.isEmpty(strFx) || resolveInfoResolveActivity == null) {
            return null;
        }
        intent.putExtra(AdBaseConstants.MARKET_OPEN_CLICK_ID, strFx);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        if (!TextUtils.isEmpty(strB)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_EXTRA, strB);
        }
        if (i == 2 && !TextUtils.isEmpty(str2)) {
            intent.putExtra(AdBaseConstants.MARKET_OPEN_INTENT_OPEN_URL, str2);
        }
        return intent;
    }
}
