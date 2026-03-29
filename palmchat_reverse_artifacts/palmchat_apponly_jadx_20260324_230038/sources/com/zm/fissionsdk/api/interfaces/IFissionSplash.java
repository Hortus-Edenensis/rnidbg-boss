package com.zm.fissionsdk.api.interfaces;

import android.view.ViewGroup;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFissionSplash extends IFission {

    /* JADX INFO: compiled from: SearchBox */
    public interface SplashInteractionListener extends IFissionInteractionListener {
        void onClose();

        void onPresent();

        void onSkip();
    }

    boolean isReady();

    void setSplashInteractionListener(SplashInteractionListener splashInteractionListener);

    void showSplash(ViewGroup viewGroup);
}
