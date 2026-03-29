package com.beizi.fusion;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes6.dex */
public interface RewardedVideoAdListener extends a {
    void onRewarded();

    void onRewardedVideoAdClosed();

    void onRewardedVideoAdFailedToLoad(int i);

    void onRewardedVideoAdLoaded();

    void onRewardedVideoAdShown();

    void onRewardedVideoCacheSuccess();

    void onRewardedVideoClick();

    void onRewardedVideoComplete();

    void onRewardedVideoPlayError();
}
