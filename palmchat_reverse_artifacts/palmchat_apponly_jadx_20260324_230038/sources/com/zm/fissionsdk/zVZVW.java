package com.zm.fissionsdk;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.zm.adxsdk.protocol.api.interfaces.IWfAdvert;
import com.zm.adxsdk.protocol.api.interfaces.IWfReward;
import com.zm.adxsdk.protocol.api.interfaces.RewardInteractionListener;
import com.zm.fissionsdk.api.interfaces.IFissionRewardVideo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public class zVZVW extends WVZZZ implements IFissionRewardVideo {
    public IWfReward b;

    /* JADX INFO: compiled from: SearchBox */
    public class zZZ2W implements RewardInteractionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IFissionRewardVideo.RewardVideoInteractionListener f16759a;

        public zZZ2W(IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener) {
            this.f16759a = rewardVideoInteractionListener;
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onClick(View view) {
            IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener = this.f16759a;
            if (rewardVideoInteractionListener != null) {
                rewardVideoInteractionListener.onClick(view);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.RewardInteractionListener
        public void onClose() {
            IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener = this.f16759a;
            if (rewardVideoInteractionListener != null) {
                rewardVideoInteractionListener.onClose();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.RewardInteractionListener
        public void onRewardVerify(boolean z) {
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShow() {
            IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener = this.f16759a;
            if (rewardVideoInteractionListener != null) {
                rewardVideoInteractionListener.onShow();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.IInteractionListener
        public void onShowFailed(int i, String str) {
            IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener = this.f16759a;
            if (rewardVideoInteractionListener != null) {
                rewardVideoInteractionListener.onShowFailed(i, str);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.RewardInteractionListener
        public void onVideoComplete() {
            IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener = this.f16759a;
            if (rewardVideoInteractionListener != null) {
                rewardVideoInteractionListener.onVideoComplete();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.RewardInteractionListener
        public void onVideoError() {
            IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener = this.f16759a;
            if (rewardVideoInteractionListener != null) {
                rewardVideoInteractionListener.onVideoError();
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.RewardInteractionListener
        public void onRewardVerify(boolean z, int i, Bundle bundle) {
            IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener = this.f16759a;
            if (rewardVideoInteractionListener != null) {
                rewardVideoInteractionListener.onRewardVerify(z, i, bundle);
            }
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.RewardInteractionListener
        public void onTaskTemplateShow() {
        }

        @Override // com.zm.adxsdk.protocol.api.interfaces.RewardInteractionListener
        public void onReward(int i) {
        }
    }

    public zVZVW(IWfAdvert iWfAdvert) {
        super(iWfAdvert);
        if (iWfAdvert instanceof IWfReward) {
            this.b = (IWfReward) iWfAdvert;
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRewardVideo
    public void setRewardInteractionListener(IFissionRewardVideo.RewardVideoInteractionListener rewardVideoInteractionListener) {
        IWfReward iWfReward = this.b;
        if (iWfReward != null) {
            iWfReward.setRewardInteractionListener(new zZZ2W(rewardVideoInteractionListener));
        }
    }

    @Override // com.zm.fissionsdk.api.interfaces.IFissionRewardVideo
    public void showReward(Context context) {
        IWfReward iWfReward = this.b;
        if (iWfReward != null) {
            iWfReward.showReward(context);
        }
    }
}
