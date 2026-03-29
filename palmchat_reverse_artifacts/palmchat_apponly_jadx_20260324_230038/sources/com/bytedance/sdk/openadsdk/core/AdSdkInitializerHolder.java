package com.bytedance.sdk.openadsdk.core;

import android.os.Build;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import defpackage.kl7;
import java.lang.reflect.InvocationTargetException;
import java.util.function.Function;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes7.dex */
public class AdSdkInitializerHolder {
    private static String MEDIATION_CLASS_NAME = "com.bytedance.sdk.gromore.init.DispatchAdSdkInitializerHolder";
    private static String PACKAGE_NAME = "com.byted.pangle";
    private static volatile Object mDispatchAdSdkInitializer;
    private static volatile fx mInitializer;

    private static Object getDispatchAdSdkInitializer(Bundle bundle, fx fxVar) {
        try {
            return Class.forName(MEDIATION_CLASS_NAME).getDeclaredMethod("getInstance", Bundle.class, fx.class).invoke(null, bundle, fxVar);
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    public static Object getNewInstance(Bundle bundle) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        if (mInitializer == null) {
            synchronized (AdSdkInitializerHolder.class) {
                if (mInitializer == null) {
                    mInitializer = new fx(bundle);
                    mDispatchAdSdkInitializer = getDispatchAdSdkInitializer(bundle, mInitializer);
                }
            }
        }
        int sdkVersion = bundle.getInt("api_sdk_version", 0);
        if (sdkVersion == 0 && (sdkVersion = getSdkVersion()) == 0) {
            return null;
        }
        kl7.b().c(sdkVersion);
        return sdkVersion < 6803 ? mDispatchAdSdkInitializer != null ? new com.bytedance.sdk.openadsdk.my.nr.nr.nr((Function) mDispatchAdSdkInitializer) : new com.bytedance.sdk.openadsdk.my.nr.nr.u(mInitializer) : mDispatchAdSdkInitializer != null ? mDispatchAdSdkInitializer : mInitializer;
    }

    private static int getSdkVersion() {
        try {
            String str = TTAdSdk.BRANCH;
            return TTAdSdk.class.getField("SDK_VERSION_CODE").getInt(null);
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.core.qq.s.u().u("init", th);
            return 0;
        }
    }

    public static boolean hasDispatchAdSdkInitializer() {
        return mDispatchAdSdkInitializer != null;
    }

    public static boolean isSdkInitSuccess() {
        if (mInitializer != null) {
            return mInitializer.u();
        }
        return false;
    }
}
