package com.zm.adxsdk.protocol.api.interfaces;

import android.os.Bundle;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface RewardInteractionListener extends IInteractionListener {
    void onClose();

    void onReward(int i);

    void onRewardVerify(boolean z);

    void onRewardVerify(boolean z, int i, Bundle bundle);

    void onTaskTemplateShow();

    void onVideoComplete();

    void onVideoError();
}
