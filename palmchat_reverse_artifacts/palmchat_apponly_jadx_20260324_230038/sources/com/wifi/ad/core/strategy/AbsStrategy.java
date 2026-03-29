package com.wifi.ad.core.strategy;

import android.content.Context;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.constant.h;
import com.wifi.ad.core.config.AdParams;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.helper.ActivityPacker;
import com.wifi.ad.core.listener.BaseListener;
import com.wifi.ad.core.listener.DislikeListener;
import com.wifi.ad.core.listener.RewardListener;
import com.wifi.ad.core.monitor.WkAdConfigManager;
import com.wifi.ad.core.utils.AdRandomUtil;
import com.wifi.ad.core.utils.WifiLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H&J\u0018\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010+\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0018\u0010,\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J \u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020*2\u0006\u00100\u001a\u000201H\u0016J\u0016\u00102\u001a\u00020\u001f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020(04H\u0016J\u0018\u00105\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00106\u001a\u00020\u001f2\u0006\u0010)\u001a\u00020*H\u0016J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u00108\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J\u001a\u00109\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020(2\b\u0010:\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020(H\u0016J\u0010\u0010<\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(H\u0016J\u0018\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010*J\u000e\u0010A\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010B\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010D\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0019J\u000e\u0010E\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006F"}, d2 = {"Lcom/wifi/ad/core/strategy/AbsStrategy;", "Lcom/wifi/ad/core/strategy/IStrategyListener;", "()V", "dislikeListener", "Lcom/wifi/ad/core/listener/DislikeListener;", "getDislikeListener", "()Lcom/wifi/ad/core/listener/DislikeListener;", "setDislikeListener", "(Lcom/wifi/ad/core/listener/DislikeListener;)V", "dislikeListenerYWF", "getDislikeListenerYWF", "setDislikeListenerYWF", "interactionListener", "Lcom/wifi/ad/core/data/NestAdData$AdInteractionListener;", "getInteractionListener", "()Lcom/wifi/ad/core/data/NestAdData$AdInteractionListener;", "setInteractionListener", "(Lcom/wifi/ad/core/data/NestAdData$AdInteractionListener;)V", bq.f.s, "Lcom/wifi/ad/core/listener/BaseListener;", "getListener", "()Lcom/wifi/ad/core/listener/BaseListener;", "setListener", "(Lcom/wifi/ad/core/listener/BaseListener;)V", "rewardListener", "Lcom/wifi/ad/core/listener/RewardListener;", "getRewardListener", "()Lcom/wifi/ad/core/listener/RewardListener;", "setRewardListener", "(Lcom/wifi/ad/core/listener/RewardListener;)V", h.Code, "", "packer", "Lcom/wifi/ad/core/helper/ActivityPacker;", "adParams", "Lcom/wifi/ad/core/config/AdParams;", "sence", "Lcom/wifi/ad/core/strategy/LoadScene;", "onAdClicked", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "providerType", "", "onAdClose", "onAdExpose", "onAdFailed", "nestAdData", "failedMsg", "code", "", "onAdLoaded", "adList", "", "onAdRewardVerify", "onAdStartRequest", "onAdVideoCached", "onAdVideoComplete", "onDislikeClicked", "reason", "onStart", "onVideoPreloadFailed", "requestConfig", "context", "Landroid/content/Context;", "appId", "setAdDislikeListener", "setAdDislikeListenerYWF", "setAdInteractionListener", "setAdRewardListener", "setLoadListener", "core_release"}, k = 1, mv = {1, 1, 16})
public abstract class AbsStrategy implements IStrategyListener {
    private DislikeListener dislikeListener;
    private DislikeListener dislikeListenerYWF;
    private NestAdData.AdInteractionListener interactionListener;
    public BaseListener listener;
    private RewardListener rewardListener;

    public final DislikeListener getDislikeListener() {
        return this.dislikeListener;
    }

    public final DislikeListener getDislikeListenerYWF() {
        return this.dislikeListenerYWF;
    }

    public final NestAdData.AdInteractionListener getInteractionListener() {
        return this.interactionListener;
    }

    public final BaseListener getListener() {
        BaseListener baseListener = this.listener;
        if (baseListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException(bq.f.s);
        }
        return baseListener;
    }

    public final RewardListener getRewardListener() {
        return this.rewardListener;
    }

    public abstract void loadAd(ActivityPacker packer, AdParams adParams, LoadScene sence);

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdClicked(NestAdData adData, String providerType) {
        WifiLog.d("AbsStrategy onAdClicked()");
        NestAdData.AdInteractionListener adInteractionListener = this.interactionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdClicked(adData);
        }
        if (adData.getWinner()) {
            WifiLog.d("AbsStrategy onAdClicked() 1");
            RewardListener rewardListener = this.rewardListener;
            if (rewardListener != null) {
                rewardListener.onAdClicked(adData);
            }
        }
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdClose(NestAdData adData, String providerType) {
        if (adData.getWinner()) {
            WifiLog.d("AbsStrategy onAdClose()");
            RewardListener rewardListener = this.rewardListener;
            if (rewardListener != null) {
                rewardListener.onAdClose(adData);
            }
        }
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdExpose(NestAdData adData, String providerType) {
        WifiLog.d("AbsStrategy onAdExpose()");
        NestAdData.AdInteractionListener adInteractionListener = this.interactionListener;
        if (adInteractionListener != null) {
            adInteractionListener.onAdExposed(adData);
        }
        if (adData.getWinner()) {
            WifiLog.d("AbsStrategy onAdExpose() 1");
            RewardListener rewardListener = this.rewardListener;
            if (rewardListener != null) {
                rewardListener.onAdExpose(adData);
            }
        }
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdRewardVerify(NestAdData nestAdData, String providerType) {
        if (nestAdData.getWinner()) {
            WifiLog.d("AbsStrategy onAdRewardVerify()");
            RewardListener rewardListener = this.rewardListener;
            if (rewardListener != null) {
                rewardListener.onAdRewardVerify(nestAdData);
            }
        }
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdVideoCached(NestAdData adData) {
        WifiLog.d("AbsStrategy onAdVideoCached()");
        RewardListener rewardListener = this.rewardListener;
        if (rewardListener != null) {
            rewardListener.onAdVideoCached(adData);
        }
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdVideoComplete(NestAdData adData) {
        if (adData.getWinner()) {
            WifiLog.d("AbsStrategy onAdVideoComplete()");
            RewardListener rewardListener = this.rewardListener;
            if (rewardListener != null) {
                rewardListener.onAdVideoComplete(adData);
            }
        }
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onDislikeClicked(NestAdData nestAdData, String reason) {
        WifiLog.d("AbsStrategy onDislikeClicked() reason=" + reason);
        DislikeListener dislikeListener = this.dislikeListener;
        if (dislikeListener != null) {
            dislikeListener.onDislikeClicked(nestAdData, reason);
        }
        if (nestAdData.getWinner()) {
            WifiLog.d("AbsStrategy onDislikeClicked()");
            RewardListener rewardListener = this.rewardListener;
            if (rewardListener != null) {
                rewardListener.onAdClose(nestAdData);
            }
        }
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onVideoPreloadFailed(NestAdData adData) {
        WifiLog.d("AbsStrategy onVideoPreloadFailed()");
        RewardListener rewardListener = this.rewardListener;
        if (rewardListener != null) {
            rewardListener.onVideoPreloadFailed(adData);
        }
    }

    public final void requestConfig(Context context, String appId) {
        new WkAdConfigManager(context).requestConfig(0, AdRandomUtil.INSTANCE.getRequestId(), "", appId);
    }

    public final void setAdDislikeListener(DislikeListener listener) {
        this.dislikeListener = listener;
    }

    public final void setAdDislikeListenerYWF(DislikeListener listener) {
        this.dislikeListenerYWF = listener;
    }

    public final void setAdInteractionListener(NestAdData.AdInteractionListener listener) {
        this.interactionListener = listener;
    }

    public final void setAdRewardListener(RewardListener listener) {
        this.rewardListener = listener;
    }

    public final void setDislikeListener(DislikeListener dislikeListener) {
        this.dislikeListener = dislikeListener;
    }

    public final void setDislikeListenerYWF(DislikeListener dislikeListener) {
        this.dislikeListenerYWF = dislikeListener;
    }

    public final void setInteractionListener(NestAdData.AdInteractionListener adInteractionListener) {
        this.interactionListener = adInteractionListener;
    }

    public final void setListener(BaseListener baseListener) {
        this.listener = baseListener;
    }

    public final void setLoadListener(BaseListener listener) {
        this.listener = listener;
    }

    public final void setRewardListener(RewardListener rewardListener) {
        this.rewardListener = rewardListener;
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdLoaded(List<NestAdData> adList) {
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdStartRequest(String providerType) {
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onStart(NestAdData nestAdData) {
    }

    @Override // com.wifi.ad.core.strategy.IStrategyListener
    public void onAdFailed(NestAdData nestAdData, String failedMsg, int code) {
    }
}
