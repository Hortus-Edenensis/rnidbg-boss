package com.zm.fissionsdk.api.interfaces;

import com.zm.fissionsdk.api.FissionSlot;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface IFissionLoadManager {

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncDrawLoadListener extends DrawLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncInterstitialLoadListener extends InterstitialLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncNativeLoadListener extends NativeLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncRewardVideoLoadListener extends RewardVideoLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface AsyncSplashLoadListener extends SplashLoadListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface CacheListener {
        void onMaterialCacheFailed(int i, String str);

        void onMaterialCached();
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface DrawLoadListener extends FissionLoadListener<IFissionDraw> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface FissionLoadListener<T> {
        void onError(int i, String str);

        void onLoad(List<T> list);
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface InterstitialLoadListener extends FissionLoadListener<IFissionInterstitial>, CacheListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface NativeLoadListener extends FissionLoadListener<IFissionNative> {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface RewardVideoLoadListener extends FissionLoadListener<IFissionRewardVideo>, CacheListener {
    }

    /* JADX INFO: compiled from: SearchBox */
    public interface SplashLoadListener extends FissionLoadListener<IFissionSplash>, CacheListener {
    }

    void loadDraw(FissionSlot fissionSlot, DrawLoadListener drawLoadListener);

    void loadInterstitial(FissionSlot fissionSlot, InterstitialLoadListener interstitialLoadListener);

    void loadNative(FissionSlot fissionSlot, NativeLoadListener nativeLoadListener);

    void loadRewardVideo(FissionSlot fissionSlot, RewardVideoLoadListener rewardVideoLoadListener);

    void loadSplash(FissionSlot fissionSlot, SplashLoadListener splashLoadListener);
}
