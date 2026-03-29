package com.wifi.ad.core.strategy;

import androidx.annotation.NonNull;
import com.wifi.ad.core.data.NestAdData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH&J\u0016\u0010\u000e\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0010H&J\u001c\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0005H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0005H\u0016J\u001c\u0010\u0016\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0019\u001a\u00020\u00032\b\b\u0001\u0010\u0014\u001a\u00020\u0005H\u0016¨\u0006\u001a"}, d2 = {"Lcom/wifi/ad/core/strategy/IStrategyListener;", "", "onAdClicked", "", "nestAdData", "Lcom/wifi/ad/core/data/NestAdData;", "providerType", "", "onAdClose", "onAdExpose", "onAdFailed", "failedMsg", "code", "", "onAdLoaded", "adList", "", "onAdRewardVerify", "onAdStartRequest", "onAdVideoCached", "adData", "onAdVideoComplete", "onDislikeClicked", "reason", "onStart", "onVideoPreloadFailed", "core_release"}, k = 1, mv = {1, 1, 16})
public interface IStrategyListener {
    void onAdClicked(@NonNull NestAdData nestAdData, @NonNull String providerType);

    void onAdClose(NestAdData nestAdData, @NonNull String providerType);

    void onAdExpose(@NonNull NestAdData nestAdData, @NonNull String providerType);

    void onAdFailed(NestAdData nestAdData, String failedMsg, int code);

    void onAdLoaded(List<NestAdData> adList);

    void onAdRewardVerify(@NonNull NestAdData nestAdData, @NonNull String providerType);

    void onAdStartRequest(@NonNull String providerType);

    void onAdVideoCached(@NonNull NestAdData adData);

    void onAdVideoComplete(@NonNull NestAdData adData);

    void onDislikeClicked(@NonNull NestAdData nestAdData, String reason);

    void onStart(NestAdData nestAdData);

    void onVideoPreloadFailed(@NonNull NestAdData adData);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static void onAdStartRequest(IStrategyListener iStrategyListener, @NonNull String str) {
        }

        public static void onAdVideoCached(IStrategyListener iStrategyListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdVideoComplete(IStrategyListener iStrategyListener, @NonNull NestAdData nestAdData) {
        }

        public static void onVideoPreloadFailed(IStrategyListener iStrategyListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdClicked(IStrategyListener iStrategyListener, @NonNull NestAdData nestAdData, @NonNull String str) {
        }

        public static void onAdClose(IStrategyListener iStrategyListener, NestAdData nestAdData, @NonNull String str) {
        }

        public static void onAdExpose(IStrategyListener iStrategyListener, @NonNull NestAdData nestAdData, @NonNull String str) {
        }

        public static void onAdRewardVerify(IStrategyListener iStrategyListener, @NonNull NestAdData nestAdData, @NonNull String str) {
        }

        public static void onDislikeClicked(IStrategyListener iStrategyListener, @NonNull NestAdData nestAdData, String str) {
        }
    }
}
