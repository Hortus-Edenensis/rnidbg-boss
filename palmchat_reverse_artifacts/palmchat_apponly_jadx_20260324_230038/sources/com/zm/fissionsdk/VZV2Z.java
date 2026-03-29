package com.zm.fissionsdk;

import android.content.Context;
import com.zm.adxsdk.WfFileProvider;
import com.zm.adxsdk.protocol.api.WfConfig;
import com.zm.adxsdk.protocol.api.interfaces.IWfLoadManager;
import com.zm.adxsdk.protocol.api.interfaces.IWfReporter;
import com.zm.adxsdk.protocol.bridge.AdxSdkBridge;
import com.zm.adxsdk.protocol.bridge.IHostBridge;
import com.zm.adxsdk.protocol.variant.IWfSdk;
import com.zm.fda.FobEventClient;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class VZV2Z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f16728a = new AtomicBoolean(false);
    public static IWfReporter b;

    /* JADX INFO: compiled from: SearchBox */
    public interface zZZ2W {
        void onFailed(int i, String str);

        void onSuccess();
    }

    public static void a(Context context, WfConfig wfConfig, zZZ2W zzz2w) {
        W2zz2.a().a(zzz2w);
        if (f16728a.get()) {
            return;
        }
        f16728a.set(true);
        boolean zB = z2WWV.b(context);
        W2zz2 w2zz2A = W2zz2.a();
        if (zB) {
            WVVzW.a("WfSdk", "mainProcess do unity init");
            zzWWV.a().a(context, wfConfig);
        } else {
            WVVzW.a("WfSdk", "not mainProcess not do unity init");
        }
        boolean z = wfConfig != null && wfConfig.isSupportMultiProcess();
        if (!zB && !z) {
            WVVzW.a("WfSdk", "Not in main process and multi-process support not enabled");
            if (w2zz2A != null) {
                w2zz2A.onFailed(0, "Not in main process and multi-process support not enabled");
                return;
            }
            return;
        }
        WfFileProvider.a(context);
        if (wfConfig != null) {
            WVVzW.d = wfConfig.isDebug();
            boolean z2 = wfConfig.useFda() && zB;
            WVVzW.a("WfSdk", "supportFda", String.valueOf(z2));
            FobEventClient.setFuncOpen(context, z2);
            b = new ZW2Vz(wfConfig.getReporter(), z2);
            if (z2) {
                VZZzW.a().a(context, wfConfig);
            }
        }
        zV2WW zv2wwA = zV2WW.a();
        zv2wwA.a(wfConfig);
        zv2wwA.a(b);
        AdxSdkBridge.putService(IHostBridge.class, zv2wwA);
        IWfSdk iWfSdkA = ZWzVW.a().a(c(), d(), b);
        if (iWfSdkA != null) {
            iWfSdkA.init(context, wfConfig, w2zz2A);
        } else if (w2zz2A != null) {
            w2zz2A.onFailed(0, "wfSdk is null");
        }
    }

    public static void b(Context context) {
        a(context, null);
    }

    public static int c() {
        return z2zz2.f;
    }

    public static String d() {
        return z2zz2.g;
    }

    public static IWfLoadManager e() {
        return VVzVZ.b();
    }

    public static boolean f() {
        return zV2WW.a().b();
    }

    public static boolean g() {
        return W2zz2.a().b();
    }

    public static String b() {
        return WW2VZ.b().getPluginVersionName();
    }

    public static long a() {
        return WW2VZ.b().getPluginVersionCode();
    }

    public static boolean a(Context context) {
        return zzWWV.a().a(context);
    }

    public static void a(Context context, Map<String, Object> map) {
        zzWWV.a().a(context, map);
    }
}
