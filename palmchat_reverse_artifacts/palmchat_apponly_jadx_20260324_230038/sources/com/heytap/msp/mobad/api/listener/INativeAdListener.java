package com.heytap.msp.mobad.api.listener;

import com.heytap.msp.mobad.api.params.INativeAdData;
import com.heytap.msp.mobad.api.params.NativeAdError;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface INativeAdListener {
    void onAdError(NativeAdError nativeAdError, INativeAdData iNativeAdData);

    void onAdFailed(NativeAdError nativeAdError);

    void onAdSuccess(List<INativeAdData> list);
}
