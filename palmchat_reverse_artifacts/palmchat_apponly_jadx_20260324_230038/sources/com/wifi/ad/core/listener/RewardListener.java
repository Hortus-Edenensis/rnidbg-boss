package com.wifi.ad.core.listener;

import androidx.annotation.NonNull;
import com.wifi.ad.core.data.NestAdData;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u001e\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\n2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0012\u0010\u0015\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0016"}, d2 = {"Lcom/wifi/ad/core/listener/RewardListener;", "Lcom/wifi/ad/core/listener/BaseListener;", "onAdClicked", "", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "onAdClose", "onAdExpose", "onAdFailed", "errorCode", "", "message", "onAdLoaded", "providerType", "adList", "", "onAdRewardVerify", "onAdShow", "onAdVideoCached", "onAdVideoComplete", "onStart", "onVideoPreloadFailed", "core_release"}, k = 1, mv = {1, 1, 16})
public interface RewardListener extends BaseListener {
    void onAdClicked(@NonNull NestAdData adData);

    void onAdClose(@NonNull NestAdData adData);

    void onAdExpose(@NonNull NestAdData adData);

    @Override // com.wifi.ad.core.listener.BaseListener
    void onAdFailed(String errorCode, String message);

    @Override // com.wifi.ad.core.listener.BaseListener
    void onAdLoaded(String providerType, List<NestAdData> adList);

    void onAdRewardVerify(@NonNull NestAdData adData);

    void onAdShow(@NonNull NestAdData adData);

    void onAdVideoCached(@NonNull NestAdData adData);

    void onAdVideoComplete(@NonNull NestAdData adData);

    @Override // com.wifi.ad.core.listener.BaseListener
    void onStart();

    void onVideoPreloadFailed(@NonNull NestAdData adData);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static void onStart(RewardListener rewardListener) {
        }

        public static void onAdClicked(RewardListener rewardListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdClose(RewardListener rewardListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdExpose(RewardListener rewardListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdShow(RewardListener rewardListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdVideoCached(RewardListener rewardListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdVideoComplete(RewardListener rewardListener, @NonNull NestAdData nestAdData) {
        }

        public static void onVideoPreloadFailed(RewardListener rewardListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdFailed(RewardListener rewardListener, String str, String str2) {
        }

        public static void onAdLoaded(RewardListener rewardListener, String str, List<NestAdData> list) {
        }
    }
}
