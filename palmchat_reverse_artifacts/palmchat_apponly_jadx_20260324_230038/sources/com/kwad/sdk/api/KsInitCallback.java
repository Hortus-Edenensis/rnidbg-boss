package com.kwad.sdk.api;

import androidx.annotation.Keep;
import com.kwad.sdk.api.core.KsAdSdkApi;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@KsAdSdkApi
@Keep
public interface KsInitCallback {
    void onFail(int i, String str);

    void onSuccess();
}
