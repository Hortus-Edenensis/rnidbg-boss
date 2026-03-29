package com.zm.fissionsdk.api.interfaces;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFissionInterstitial extends IFission {

    /* JADX INFO: compiled from: SearchBox */
    public interface InterstitialInteractionListener extends IFissionInteractionListener {
        void onClose();
    }

    void setInterstitialInteractionListener(InterstitialInteractionListener interstitialInteractionListener);

    void showInterstitial(Context context);
}
