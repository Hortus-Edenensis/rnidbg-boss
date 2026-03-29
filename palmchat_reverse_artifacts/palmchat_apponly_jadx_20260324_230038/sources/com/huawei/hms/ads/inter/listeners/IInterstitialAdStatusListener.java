package com.huawei.hms.ads.inter.listeners;

import com.huawei.hms.ads.annotation.GlobalApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public interface IInterstitialAdStatusListener {
    void onAdClicked();

    void onAdClosed();

    void onAdCompleted();

    void onAdError(int i, int i2);

    void onAdShown();

    void onLeftApp();

    void onRewarded();
}
