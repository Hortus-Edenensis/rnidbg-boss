package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.IRewardVideoAdListener;
import com.heytap.msp.mobad.api.params.RewardVideoAdParams;
import com.opos.mobad.ad.f.a;
import com.opos.mobad.ad.f.b;
import com.opos.mobad.f.a.j;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class RewardVideoAd implements IBidding {
    public static final int REWARD_SCENE_AD_CLICK = 5;
    public static final int REWARD_SCENE_INSTALL_COMPLETE = 2;
    public static final int REWARD_SCENE_LAUNCH_APP = 3;
    public static final int REWARD_SCENE_NO = 0;
    public static final int REWARD_SCENE_PLAY_COMPLETE = 1;
    public static final int REWARD_SCENE_PLAY_INTERACTION = 4;
    private static final String TAG = "RewardVideoAd";
    private Context mContext;
    private RewardVideoAdListenerWrapper mListener;
    private String mPosId;
    private volatile a mRewardVideoAdImpl;

    public RewardVideoAd(Context context, String str, IRewardVideoAdListener iRewardVideoAdListener) {
        if (context == null || TextUtils.isEmpty(str) || iRewardVideoAdListener == null) {
            Log.e(TAG, "RewardVideoAd Constructor param context and posId and iRewardVideoAdListener can't be null.");
            return;
        }
        this.mContext = context;
        this.mPosId = str;
        this.mListener = getListenerWrapper(iRewardVideoAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mRewardVideoAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mRewardVideoAdImpl != null) {
                return true;
            }
            this.mRewardVideoAdImpl = ProxyManager.getInstance().a(this.mContext, this.mPosId, this.mListener);
            return this.mRewardVideoAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.b();
        }
        this.mContext = null;
        this.mPosId = null;
    }

    public void doNotifyReward() {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.g();
        }
    }

    public boolean doShowFallBack() {
        if (this.mRewardVideoAdImpl instanceof j) {
            return ((j) this.mRewardVideoAdImpl).f_();
        }
        return false;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mRewardVideoAdImpl != null) {
            return this.mRewardVideoAdImpl.f();
        }
        return 0;
    }

    public RewardVideoAdListenerWrapper getListenerWrapper(IRewardVideoAdListener iRewardVideoAdListener) {
        return new RewardVideoAdListenerWrapper(iRewardVideoAdListener);
    }

    @Deprecated
    public int getRewardScene() {
        return 1;
    }

    public boolean isReady() {
        if (this.mRewardVideoAdImpl != null) {
            return this.mRewardVideoAdImpl.d();
        }
        return false;
    }

    public void loadAd() {
        loadAd(null);
    }

    public void loadAdWithData(RewardVideoAdParams rewardVideoAdParams, String str) {
        loadInter(rewardVideoAdParams, str);
    }

    public void loadInter(RewardVideoAdParams rewardVideoAdParams, String str) {
        if (initImplIfNeed()) {
            if (rewardVideoAdParams != null) {
                this.mRewardVideoAdImpl.a((int) rewardVideoAdParams.fetchTimeout, str);
                return;
            } else {
                this.mRewardVideoAdImpl.a(str);
                return;
            }
        }
        RewardVideoAdListenerWrapper rewardVideoAdListenerWrapper = this.mListener;
        if (rewardVideoAdListenerWrapper != null) {
            rewardVideoAdListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        if (this.mRewardVideoAdImpl != null) {
            this.mRewardVideoAdImpl.c(i);
        }
    }

    public void showAd() {
        showAd(false);
    }

    private void loadInter(RewardVideoAdParams rewardVideoAdParams, List<String> list) {
        if (!initImplIfNeed()) {
            RewardVideoAdListenerWrapper rewardVideoAdListenerWrapper = this.mListener;
            if (rewardVideoAdListenerWrapper != null) {
                rewardVideoAdListenerWrapper.onAdFailed(-1, "inter ad create fail");
                return;
            }
            return;
        }
        if (rewardVideoAdParams != null) {
            if (list == null) {
                this.mRewardVideoAdImpl.a((int) rewardVideoAdParams.fetchTimeout);
                return;
            } else {
                this.mRewardVideoAdImpl.a((int) rewardVideoAdParams.fetchTimeout, list);
                return;
            }
        }
        a aVar = this.mRewardVideoAdImpl;
        if (list == null) {
            aVar.a();
        } else {
            aVar.a(list);
        }
    }

    public void loadAd(RewardVideoAdParams rewardVideoAdParams) {
        loadInter(rewardVideoAdParams, (List<String>) null);
    }

    public void showAd(boolean z) {
        if (initImplIfNeed()) {
            this.mRewardVideoAdImpl.a(z);
            return;
        }
        RewardVideoAdListenerWrapper rewardVideoAdListenerWrapper = this.mListener;
        if (rewardVideoAdListenerWrapper != null) {
            rewardVideoAdListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    public void loadAd(RewardVideoAdParams rewardVideoAdParams, String str) {
        if (!TextUtils.isEmpty(str)) {
            loadInter(rewardVideoAdParams, Arrays.asList(str));
            return;
        }
        RewardVideoAdListenerWrapper rewardVideoAdListenerWrapper = this.mListener;
        if (rewardVideoAdListenerWrapper != null) {
            rewardVideoAdListenerWrapper.onAdFailed(10701, "load error, please check you bidIds");
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class RewardVideoAdListenerWrapper implements b {
        private IRewardVideoAdListener mApiListener;

        public RewardVideoAdListenerWrapper(IRewardVideoAdListener iRewardVideoAdListener) {
            this.mApiListener = iRewardVideoAdListener;
        }

        @Override // com.opos.mobad.ad.f.b, com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            this.mApiListener.onAdClick(j);
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            IRewardVideoAdListener iRewardVideoAdListener = this.mApiListener;
            StringBuilder sb = new StringBuilder();
            sb.append("code=");
            sb.append(i);
            sb.append(",msg=");
            sb.append(str != null ? str : "");
            iRewardVideoAdListener.onAdFailed(sb.toString());
            this.mApiListener.onAdFailed(i, str);
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            this.mApiListener.onAdSuccess();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageClose() {
            this.mApiListener.onLandingPageClose();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onLandingPageOpen() {
            this.mApiListener.onLandingPageOpen();
        }

        @Override // com.opos.mobad.ad.k
        public void onReward(Object... objArr) {
            this.mApiListener.onReward(objArr);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayClose(long j) {
            this.mApiListener.onVideoPlayClose(j);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayComplete() {
            this.mApiListener.onVideoPlayComplete();
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayError(String str) {
            this.mApiListener.onVideoPlayError(str);
        }

        @Override // com.opos.mobad.ad.f.b
        public void onVideoPlayStart() {
            this.mApiListener.onVideoPlayStart();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
        }
    }
}
