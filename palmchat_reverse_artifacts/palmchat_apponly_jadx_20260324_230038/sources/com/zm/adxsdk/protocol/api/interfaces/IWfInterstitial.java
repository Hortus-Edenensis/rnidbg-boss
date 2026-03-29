package com.zm.adxsdk.protocol.api.interfaces;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfInterstitial extends IWfAdvert {
    boolean isReady();

    void setInterstitialInteractionListener(InterstitialInteractionListener interstitialInteractionListener);

    void showInterstitial(Context context);
}
