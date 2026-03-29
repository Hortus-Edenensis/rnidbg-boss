package com.zm.fissionsdk.api.interfaces;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFissionRewardVideo extends IFission {

    /* JADX INFO: compiled from: SearchBox */
    public interface RewardVideoInteractionListener extends IFissionInteractionListener {
        void onClose();

        void onRewardVerify(boolean z, int i, Bundle bundle);

        void onVideoComplete();

        void onVideoError();
    }

    void setRewardInteractionListener(RewardVideoInteractionListener rewardVideoInteractionListener);

    void showReward(Context context);
}
