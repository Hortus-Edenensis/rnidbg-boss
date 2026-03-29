package com.wifi.ad.core.listener;

import androidx.annotation.NonNull;
import com.wifi.ad.core.data.NestAdData;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016J\u001c\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/listener/SplashShowListener;", "", "onAdClicked", "", "providerType", "", "adData", "Lcom/wifi/ad/core/data/NestAdData;", "onAdExpose", "onAdFailedAll", "onAdSkip", "core_release"}, k = 1, mv = {1, 1, 16})
public interface SplashShowListener {
    void onAdClicked(@NonNull String providerType, @NonNull NestAdData adData);

    void onAdExpose(@NonNull String providerType, @NonNull NestAdData adData);

    void onAdFailedAll(@NonNull NestAdData adData);

    void onAdSkip(@NonNull String providerType, @NonNull NestAdData adData);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static void onAdFailedAll(SplashShowListener splashShowListener, @NonNull NestAdData nestAdData) {
        }

        public static void onAdClicked(SplashShowListener splashShowListener, @NonNull String str, @NonNull NestAdData nestAdData) {
        }

        public static void onAdExpose(SplashShowListener splashShowListener, @NonNull String str, @NonNull NestAdData nestAdData) {
        }

        public static void onAdSkip(SplashShowListener splashShowListener, @NonNull String str, @NonNull NestAdData nestAdData) {
        }
    }
}
