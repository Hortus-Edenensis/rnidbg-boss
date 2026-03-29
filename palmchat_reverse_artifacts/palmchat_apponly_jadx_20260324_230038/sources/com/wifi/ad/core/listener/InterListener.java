package com.wifi.ad.core.listener;

import androidx.annotation.NonNull;
import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u001c\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0012\u0010\u000b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/wifi/ad/core/listener/InterListener;", "", "onAdClicked", "", "providerType", "", "onAdClose", "onAdExpose", "onAdFailed", "failedMsg", "onAdFailedAll", "onAdLoaded", "onAdStartRequest", "core_release"}, k = 1, mv = {1, 1, 16})
public interface InterListener {
    void onAdClicked(@NonNull String providerType);

    void onAdClose(@NonNull String providerType);

    void onAdExpose(@NonNull String providerType);

    void onAdFailed(@NonNull String providerType, String failedMsg);

    void onAdFailedAll();

    void onAdLoaded(@NonNull String providerType);

    void onAdStartRequest(@NonNull String providerType);

    /* JADX INFO: compiled from: SearchBox */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public static final class DefaultImpls {
        public static void onAdFailedAll(InterListener interListener) {
        }

        public static void onAdClicked(InterListener interListener, @NonNull String str) {
        }

        public static void onAdClose(InterListener interListener, @NonNull String str) {
        }

        public static void onAdExpose(InterListener interListener, @NonNull String str) {
        }

        public static void onAdLoaded(InterListener interListener, @NonNull String str) {
        }

        public static void onAdStartRequest(InterListener interListener, @NonNull String str) {
        }

        public static void onAdFailed(InterListener interListener, @NonNull String str, String str2) {
        }
    }
}
