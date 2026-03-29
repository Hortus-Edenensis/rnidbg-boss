package com.wifi.adsdk;

import com.wifi.adsdk.listener.LxAdNativeFeedListener;
import com.wifi.adsdk.listener.LxAdPopListener;
import com.wifi.adsdk.listener.LxAdSplashListener;
import com.wifi.adsdk.listener.LxAdTempFeedListener;
import com.wifi.adsdk.params.LxAdReqParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface IAdNative {
    void loadNativeFeedAd(LxAdReqParams lxAdReqParams, LxAdNativeFeedListener lxAdNativeFeedListener);

    void loadPopAd(LxAdReqParams lxAdReqParams, LxAdPopListener lxAdPopListener);

    void loadSplashAd(LxAdReqParams lxAdReqParams, LxAdSplashListener lxAdSplashListener);

    void loadTempFeedAd(LxAdReqParams lxAdReqParams, LxAdTempFeedListener lxAdTempFeedListener);
}
