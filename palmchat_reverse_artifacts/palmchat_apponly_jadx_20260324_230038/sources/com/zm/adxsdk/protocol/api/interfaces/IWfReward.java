package com.zm.adxsdk.protocol.api.interfaces;

import android.content.Context;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfReward extends IWfAdvert {
    boolean isReady();

    void setRewardInteractionListener(RewardInteractionListener rewardInteractionListener);

    void showReward(Context context);
}
