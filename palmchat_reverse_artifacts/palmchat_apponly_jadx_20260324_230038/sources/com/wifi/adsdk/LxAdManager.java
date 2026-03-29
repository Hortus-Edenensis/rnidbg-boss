package com.wifi.adsdk;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.wifi.adsdk.LxAdConfig;
import com.wifi.adsdk.download.LxAdDLManager;
import com.wifi.adsdk.sensor.LxAdSensorUtil;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdManager implements ILxAd {
    private static volatile LxAdManager manager;
    private LxAdConfig config;
    private Context context;

    private LxAdManager(@NonNull Context context, LxAdConfig lxAdConfig) {
        Log.d("", "LxAd LxAdManager start");
        if (context == null) {
            throw new NullPointerException("context cannot be null");
        }
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        lxAdConfig = lxAdConfig == null ? new LxAdConfig.Builder(applicationContext).build() : lxAdConfig;
        this.config = lxAdConfig;
        AdAllInitConfig.initAllConfig(lxAdConfig.getAppId(), lxAdConfig.getToken(), lxAdConfig.getDebugUrl());
    }

    public static LxAdManager getAdManager(@NonNull Context context, LxAdConfig lxAdConfig) {
        if (manager == null) {
            synchronized (LxAdManager.class) {
                if (manager == null) {
                    manager = new LxAdManager(context, lxAdConfig);
                }
            }
        }
        return manager;
    }

    @Override // com.wifi.adsdk.ILxAd
    public IAdNative createAdNative() {
        return new LxAdNative(this.context, this.config);
    }

    public LxAdConfig getConfig() {
        return this.config;
    }

    public Context getContext() {
        return this.context;
    }

    @Override // com.wifi.adsdk.ILxAd
    public void onDestroy() {
        LxAdSensorUtil.onDestroy();
        LxAdDLManager.getInstance(this.context).onDestroy();
    }

    public static LxAdManager getAdManager() {
        if (manager != null) {
            return manager;
        }
        throw new NullPointerException("WifiAdSdk has not been init yet");
    }
}
