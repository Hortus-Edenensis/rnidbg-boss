package com.wifi.ad.core.listener;

import androidx.annotation.NonNull;
import com.wifi.ad.core.data.NestAdData;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\r\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000e\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u0010\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H&¨\u0006\u0013"}, d2 = {"Lcom/wifi/ad/core/listener/PopShowListener;", "", "onAdClicked", "", "providerType", "", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "onAdClose", "onAdExpose", "onAdSkipClick", "onDownloadComplete", "onDownloadFailed", "onDownloadInstalled", "onDownloadStart", "onVideoComplete", "onVideoError", "onVideoPause", "onVideoStart", "core_release"}, k = 1, mv = {1, 1, 16})
public interface PopShowListener {
    void onAdClicked(@NonNull String providerType, @NonNull NestAdData adData);

    void onAdClose(@NonNull String providerType, @NonNull NestAdData adData);

    void onAdExpose(@NonNull String providerType, @NonNull NestAdData adData);

    void onAdSkipClick(@NonNull String providerType, @NonNull NestAdData adData);

    void onDownloadComplete(@NonNull String providerType, @NonNull NestAdData adData);

    void onDownloadFailed(@NonNull String providerType, @NonNull NestAdData adData);

    void onDownloadInstalled(@NonNull String providerType, @NonNull NestAdData adData);

    void onDownloadStart(@NonNull String providerType, @NonNull NestAdData adData);

    void onVideoComplete(@NonNull String providerType, @NonNull NestAdData adData);

    void onVideoError(@NonNull String providerType, @NonNull NestAdData adData);

    void onVideoPause(@NonNull String providerType, @NonNull NestAdData adData);

    void onVideoStart(@NonNull String providerType, @NonNull NestAdData adData);
}
