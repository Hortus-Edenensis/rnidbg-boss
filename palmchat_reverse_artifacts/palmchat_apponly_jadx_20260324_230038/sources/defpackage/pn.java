package defpackage;

import a.a.a.a.a.a.f;
import a.a.a.a.b.a;
import a.a.a.a.b.c;
import a.a.b.a.d.d;
import a.a.b.a.d.g;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.huawei.hms.ads.ContentClassification;
import com.igexin.push.core.b;
import com.kuaishou.weapon.p0.t;
import com.lantern.auth.server.WkParams;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.umeng.analytics.pro.bt;
import com.zm.adxsdk.protocol.api.interfaces.WfConstant;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b!\u0010\"J%\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001d\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u001f¨\u0006#"}, d2 = {"Lpn;", "", "Landroid/content/Context;", "context", "Lqn;", "userConfig", "Landroid/app/Activity;", "activity", "", "d", "(Landroid/content/Context;Lqn;Landroid/app/Activity;)V", "e", "(Landroid/content/Context;Landroid/app/Activity;)V", "f", "(Landroid/content/Context;)V", "c", "(Landroid/content/Context;Lqn;)V", "a", "Lqn;", "()Lqn;", "setConfig", "(Lqn;)V", b.Y, "", t.l, ContentClassification.AD_CONTENT_CLASSIFICATION_J, "()J", "setInitTime", "(J)V", "initTime", "", "Z", "hasPost", "<init>", "()V", "convert_release"}, k = 1, mv = {1, 4, 0})
public final class pn {

    /* JADX INFO: renamed from: c, reason: from kotlin metadata */
    public static boolean hasPost;
    public static final pn d = new pn();

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public static qn config = new qn();

    /* JADX INFO: renamed from: b, reason: from kotlin metadata */
    public static long initTime = -1;

    public final qn a() {
        return config;
    }

    public final long b() {
        return initTime;
    }

    public final void c(Context context, qn userConfig) throws Throwable {
        Intrinsics.checkNotNullParameter("Convert:BDConvert", "tag");
        Intrinsics.checkNotNullParameter("BDConvert init", "msg");
        if (d.a().getEnableLog()) {
            Log.d("Convert:BDConvert", "BDConvert init");
        }
        initTime = System.currentTimeMillis();
        if (config.getAutoSendLaunchEvent()) {
            f(context);
        }
    }

    public final void d(Context context, qn userConfig, Activity activity) throws Throwable {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(userConfig, "userConfig");
        Intrinsics.checkNotNullParameter(activity, "activity");
        config = userConfig;
        if (initTime != -1) {
            Intrinsics.checkNotNullParameter("Convert:BDConvert", "tag");
            Intrinsics.checkNotNullParameter("BDConvert 重复初始化", "msg");
            if (d.a().getEnableLog()) {
                Log.d("Convert:BDConvert", "BDConvert 重复初始化");
                return;
            }
            return;
        }
        c(context, userConfig);
        if (userConfig.getPlaySessionEnable()) {
            g gVar = g.e;
            Intrinsics.checkNotNullParameter(activity, "activity");
            Application application = activity.getApplication();
            g.a aVar = g.d;
            application.registerActivityLifecycleCallbacks(aVar);
            aVar.onActivityResumed(activity);
            gVar.a(60000L);
        }
    }

    public final void e(Context context, Activity activity) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (initTime == -1) {
            d(context, config, activity);
            return;
        }
        Intrinsics.checkNotNullParameter("Convert:BDConvert", "tag");
        Intrinsics.checkNotNullParameter("BDConvert 重复初始化", "msg");
        if (d.a().getEnableLog()) {
            Log.d("Convert:BDConvert", "BDConvert 重复初始化");
        }
    }

    public final void f(Context context) throws Throwable {
        String strName;
        String string;
        Intrinsics.checkNotNullParameter(context, "context");
        if (hasPost) {
            Intrinsics.checkNotNullParameter("Convert:BDConvert", "tag");
            Intrinsics.checkNotNullParameter("already sendLaunchEvent", "msg");
            if (d.a().getEnableLog()) {
                Log.d("Convert:BDConvert", "already sendLaunchEvent");
                return;
            }
            return;
        }
        hasPost = true;
        Intrinsics.checkNotNullParameter("Convert:BDConvert", "tag");
        Intrinsics.checkNotNullParameter("sendLaunchEvent", "msg");
        pn pnVar = d;
        if (pnVar.a().getEnableLog()) {
            Log.d("Convert:BDConvert", "sendLaunchEvent");
        }
        Context context2 = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(context2, "appContext");
        Intrinsics.checkNotNullParameter(context2, "context");
        if (a.a.b.a.b.b.f1073a == null) {
            try {
                a.a.a.a.b.b bVarA = a.b.a(context2, new c(new f(false, null, null, null, 15), true));
                a.a.b.a.b.b.d = System.currentTimeMillis();
                Intrinsics.checkNotNullParameter(context2, "context");
                new Thread(new a.a.b.a.b.a(context2)).start();
                String packageName = context2.getPackageName();
                String string2 = context2.getPackageManager().getApplicationInfo(packageName, 128).metaData.getString("hume_convert.AppConvert.sdk.version");
                Intrinsics.checkNotNullParameter(context2, "context");
                String str = a.a.b.a.d.a.f1079a;
                if (TextUtils.isEmpty(str)) {
                    try {
                        pnVar.a().b();
                        String string3 = Settings.Secure.getString(context2.getContentResolver(), "android_id");
                        Intrinsics.checkNotNullExpressionValue(string3, "Settings.Secure.getStrin…ttings.Secure.ANDROID_ID)");
                        try {
                            a.a.b.a.d.a.f1079a = string3;
                        } catch (Exception unused) {
                        }
                        str = string3;
                    } catch (Exception unused2) {
                    }
                }
                a.a.b.a.c.a.b<String, String> bVarA2 = a.a.b.a.d.b.b.a(context2);
                JSONObject jSONObject = (JSONObject) bVarA.h.getValue();
                a.a.b.a.d.c cVarA = d.f1082a.a(context2);
                Intrinsics.checkNotNullParameter("Convert:Event", "tag");
                Intrinsics.checkNotNullParameter("click_id fetch", "msg");
                if (d.a().getEnableLog()) {
                    Log.d("Convert:Event", "click_id fetch");
                }
                String str2 = cVarA.b;
                if (str2 == null) {
                    str2 = "";
                }
                jSONObject.put(AdBaseConstants.MARKET_OPEN_CLICK_ID, str2);
                a.a.b.a.d.f fVar = cVarA.e;
                if (fVar == null) {
                    strName = null;
                } else {
                    Intrinsics.checkNotNull(fVar);
                    strName = fVar.name();
                }
                if (strName == null) {
                    strName = "";
                }
                jSONObject.put("click_id_source", strName);
                String str3 = cVarA.c;
                if (str3 == null) {
                    str3 = "";
                }
                jSONObject.put("click_id_nature", str3);
                jSONObject.put(WkParams.MODEL, Build.MODEL);
                jSONObject.put(bt.F, Build.BRAND);
                jSONObject.put("os_version", "" + Build.VERSION.SDK_INT);
                jSONObject.put("os_name", "android");
                jSONObject.put("sdk_version", string2);
                String str4 = cVarA.d;
                jSONObject.put("app_channel", str4 != null ? str4 : "");
                jSONObject.put(WfConstant.EXTRA_KEY_APP_PKG, packageName);
                try {
                    PackageInfo packageInfo = context2.getPackageManager().getPackageInfo(context2.getPackageName(), 0);
                    jSONObject.put("app_version", packageInfo.versionName);
                    jSONObject.put("app_install_time", String.valueOf(packageInfo.firstInstallTime));
                } catch (PackageManager.NameNotFoundException unused3) {
                }
                jSONObject.put("open_udid", str);
                Intrinsics.checkNotNull(bVarA2);
                jSONObject.put("app_unique_id_source", bVarA2.f1077a);
                jSONObject.put("app_unique_id", bVarA2.b);
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    ArrayList<NetworkInterface> list = Collections.list(NetworkInterface.getNetworkInterfaces());
                    Intrinsics.checkNotNullExpressionValue(list, "Collections.list(Network…e.getNetworkInterfaces())");
                    for (NetworkInterface networkInterface : list) {
                        ArrayList<InetAddress> list2 = Collections.list(networkInterface.getInetAddresses());
                        Intrinsics.checkNotNullExpressionValue(list2, "Collections.list(networkInterface.inetAddresses)");
                        JSONArray jSONArray = new JSONArray();
                        for (InetAddress inetAddress : list2) {
                            if (inetAddress instanceof Inet6Address) {
                                jSONArray.put(inetAddress.getHostAddress());
                            }
                        }
                        jSONObject2.put(networkInterface.getName(), jSONArray);
                    }
                    string = jSONObject2.toString();
                    Intrinsics.checkNotNullExpressionValue(string, "jsonObject.toString()");
                } catch (Exception unused4) {
                    string = "{}";
                }
                jSONObject.put("ipv6", string);
                jSONObject.put("oaid", a.a.b.a.b.b.c);
                jSONObject.put("u_t", new JSONObject());
                a.a.b.a.b.b.f1073a = jSONObject;
            } catch (Exception e) {
                e.printStackTrace();
                String msg = "create common params failed" + e.getMessage();
                Intrinsics.checkNotNullParameter("Convert:Event", "tag");
                Intrinsics.checkNotNullParameter(msg, "msg");
                if (d.a().getEnableLog()) {
                    Log.d("Convert:Event", msg);
                }
            }
        }
        if (a.a.b.a.b.b.f1073a == null) {
            a.a.b.a.b.b.f1073a = new JSONObject();
        }
        Intrinsics.checkNotNullParameter("launch_app", "label");
        Intrinsics.checkNotNullParameter("3", "eventVersion");
        a.a.b.a.b.b bVar = new a.a.b.a.b.b("launch_app");
        bVar.g = "3";
        bVar.h = null;
        bVar.a("Convert:EventReporterV3");
        a.a.b.a.b.d dVar = a.a.b.a.b.d.b;
        if (a.a.b.a.b.b.b != -1) {
            dVar.a();
        } else {
            new Timer().schedule(new a.a.b.a.b.c(), 500L);
        }
    }
}
