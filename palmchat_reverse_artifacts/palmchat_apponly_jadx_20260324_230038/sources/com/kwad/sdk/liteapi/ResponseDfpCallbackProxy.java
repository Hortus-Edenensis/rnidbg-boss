package com.kwad.sdk.liteapi;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Keep
public interface ResponseDfpCallbackProxy {
    void onFailed(int i, String str);

    void onSuccess(String str, String str2);
}
