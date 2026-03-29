package com.beizi.fusion;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface NativeUnifiedAdListener extends a {
    void onAdClick();

    void onAdFailed(int i);

    void onAdLoaded(NativeUnifiedAdResponse nativeUnifiedAdResponse);

    void onAdShown();
}
