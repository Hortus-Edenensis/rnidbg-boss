package com.zm.adxsdk.protocol.api.interfaces;

import android.view.ViewGroup;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfSplash extends IWfAdvert {
    boolean isReady();

    void setSplashInteractionListener(SplashInteractionListener splashInteractionListener);

    void showSplash(ViewGroup viewGroup);
}
