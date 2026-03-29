package com.huawei.hms.ads.reward;

import com.huawei.hms.ads.annotation.GlobalApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public abstract class RewardAdStatusListener {

    /* JADX INFO: compiled from: SearchBox */
    @GlobalApi
    public interface ErrorCode {
        public static final int BACKGROUND = 3;
        public static final int INTERNAL = 0;
        public static final int NOT_LOADED = 2;
        public static final int REUSED = 1;
    }

    @GlobalApi
    public void onRewardAdClosed() {
    }

    @GlobalApi
    public void onRewardAdOpened() {
    }

    @GlobalApi
    public void onRewardAdFailedToShow(int i) {
    }

    @GlobalApi
    public void onRewarded(Reward reward) {
    }
}
