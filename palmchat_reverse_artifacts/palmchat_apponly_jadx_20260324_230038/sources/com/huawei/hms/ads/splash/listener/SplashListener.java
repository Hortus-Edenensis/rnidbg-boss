package com.huawei.hms.ads.splash.listener;

import com.huawei.hms.ads.annotation.AllApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public interface SplashListener {
    void onAdDismissed();

    void onAdError(int i);

    void onAdShowStart();
}
