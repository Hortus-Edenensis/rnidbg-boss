package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.response.model.BaseResultData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public abstract class o<R extends f, T extends BaseResultData> implements g<R, T> {
    @Override // com.kwad.sdk.core.network.g
    public void onStartRequest(@NonNull R r) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onSuccess(@NonNull R r, @NonNull T t) {
    }

    @Override // com.kwad.sdk.core.network.g
    public void onError(@NonNull R r, int i, String str) {
    }
}
