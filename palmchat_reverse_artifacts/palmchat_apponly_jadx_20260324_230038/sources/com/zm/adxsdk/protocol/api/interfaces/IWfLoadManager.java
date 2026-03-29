package com.zm.adxsdk.protocol.api.interfaces;

import com.zm.adxsdk.protocol.api.WfSlot;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IWfLoadManager {

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncInterstitialLoadListener extends InterstitialLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncNativeLoadListener extends NativeLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncRewardLoadListener extends RewardLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncSplashLoadListener extends SplashLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface InterstitialLoadListener extends WfLoadListener<IWfInterstitial>, WfCacheListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface NativeLoadListener extends WfLoadListener<IWfNative> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface RewardLoadListener extends WfLoadListener<IWfReward>, WfCacheListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SplashLoadListener extends WfLoadListener<IWfSplash>, WfCacheListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface WfAsyncLoadListener<T> extends WfLoadListener<T> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface WfCacheListener {
        void onMaterialCacheFailed(int i, String str);

        void onMaterialCached();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface WfLoadListener<T> {
        void onError(int i, String str);

        void onLoad(List<T> list);
    }

    void loadCache(WfSlot wfSlot, WfLoadListener wfLoadListener);

    void loadInterstitial(WfSlot wfSlot, InterstitialLoadListener interstitialLoadListener);

    void loadNative(WfSlot wfSlot, NativeLoadListener nativeLoadListener);

    void loadReward(WfSlot wfSlot, RewardLoadListener rewardLoadListener);

    void loadSplash(WfSlot wfSlot, SplashLoadListener splashLoadListener);
}
