package com.kwad.components.offline.api;

import androidx.annotation.WorkerThread;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface InitCallBack {
    @WorkerThread
    void onError(int i);

    @WorkerThread
    void onSuccess(boolean z);
}
