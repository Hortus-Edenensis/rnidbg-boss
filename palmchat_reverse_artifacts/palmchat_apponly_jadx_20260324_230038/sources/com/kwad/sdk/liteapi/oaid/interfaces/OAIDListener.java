package com.kwad.sdk.liteapi.oaid.interfaces;

import androidx.annotation.Keep;
import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
@Keep
public interface OAIDListener {
    @WorkerThread
    void OnOAIDValid(String str);
}
