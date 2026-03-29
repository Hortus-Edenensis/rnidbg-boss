package com.wifi.adsdk.listener;

import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.splash.LxSplashAd;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface LxAdSplashListener extends LxAdBaseListener {
    void onSuccess(List<LxSplashAd> list, LxAdReqParams lxAdReqParams);
}
