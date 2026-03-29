package com.heytap.msp.mobad.api.listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IHotSplashListener {
    void onAdClick();

    void onAdDismissed();

    void onAdFailed(int i, String str);

    void onAdReady();

    void onAdShow(String str);
}
