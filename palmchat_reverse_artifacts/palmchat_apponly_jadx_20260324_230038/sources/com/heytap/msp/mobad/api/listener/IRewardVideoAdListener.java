package com.heytap.msp.mobad.api.listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface IRewardVideoAdListener extends IRewardListener {
    void onAdClick(long j);

    void onAdFailed(int i, String str);

    @Deprecated
    void onAdFailed(String str);

    void onAdSuccess();

    void onLandingPageClose();

    void onLandingPageOpen();

    void onVideoPlayClose(long j);

    void onVideoPlayComplete();

    void onVideoPlayError(String str);

    void onVideoPlayStart();
}
