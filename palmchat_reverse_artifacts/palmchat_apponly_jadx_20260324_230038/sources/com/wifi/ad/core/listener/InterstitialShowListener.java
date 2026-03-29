package com.wifi.ad.core.listener;

import androidx.annotation.NonNull;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J.\u0010\u000f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\u0013\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\u0014\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\u0015\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&J&\u0010\u0016\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u0005H&¨\u0006\u0017"}, d2 = {"Lcom/wifi/ad/core/listener/InterstitialShowListener;", "", "onAdClicked", "", "providerType", "", "adData", "requestId", "onAdClose", "onAdExposed", "onAdSkipClick", "onDownloadComplete", "onDownloadFailed", "onDownloadInstalled", "onDownloadPause", "onDownloadProgress", "progress", "", "onDownloadStart", "onVideoComplete", "onVideoError", "onVideoPause", "onVideoStart", "core_release"}, k = 1, mv = {1, 1, 16})
public interface InterstitialShowListener {
    void onAdClicked(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onAdClose(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onAdExposed(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onAdSkipClick(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onDownloadComplete(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onDownloadFailed(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onDownloadInstalled(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onDownloadPause(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onDownloadProgress(@NonNull String providerType, @NonNull String adData, int progress, @NonNull String requestId);

    void onDownloadStart(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onVideoComplete(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onVideoError(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onVideoPause(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);

    void onVideoStart(@NonNull String providerType, @NonNull String adData, @NonNull String requestId);
}
