package com.wifi.ad.core.listener;

import kotlin.Metadata;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/wifi/ad/core/listener/FeedBannerLoadListener;", "", "onAdFailed", "", "errorCode", "", "message", "requestId", "onAdLoad", "providerType", "onStart", "core_release"}, k = 1, mv = {1, 1, 16})
public interface FeedBannerLoadListener {
    void onAdFailed(String errorCode, String message, String requestId);

    void onAdLoad(String providerType, String requestId);

    void onStart(String requestId);
}
