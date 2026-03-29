package com.kwad.components.core.request;

import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.core.response.model.AdResultData;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface l<T extends AdResultData> {
    @WorkerThread
    void b(@NonNull T t);

    @WorkerThread
    void onError(int i, String str);
}
