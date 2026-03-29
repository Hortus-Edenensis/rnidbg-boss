package com.kwad.sdk.export.proxy;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes9.dex */
public interface AdHttpResponseListener {
    boolean onReadProgress(long j, long j2);

    void onResponseEnd();

    void onResponseStart();
}
