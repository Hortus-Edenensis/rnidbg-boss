package com.wifi.adsdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.makeramen.roundedimageview.BuildConfig;
import com.wifi.adsdk.download.LxAdDLManager;
import com.wifi.adsdk.utils.LxAdSingleDataUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public final class LxAdSdk {
    private static ILxAd getAdManager(@NonNull Context context, LxAdConfig lxAdConfig) {
        return LxAdManager.getAdManager(context, lxAdConfig);
    }

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void init(@NonNull Context context, LxAdConfig lxAdConfig) {
        getAdManager(context, lxAdConfig);
        LxAdSingleDataUtil.getInstance(context);
        LxAdDLManager.getInstance(context).checkDownTimeOutAd();
    }

    public static void onDestroy() {
        getAdManager().onDestroy();
    }

    public static ILxAd getAdManager() {
        return LxAdManager.getAdManager();
    }
}
