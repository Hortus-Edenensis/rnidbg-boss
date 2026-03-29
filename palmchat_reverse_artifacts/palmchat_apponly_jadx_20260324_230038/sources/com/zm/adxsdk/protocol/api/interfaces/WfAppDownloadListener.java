package com.zm.adxsdk.protocol.api.interfaces;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes4.dex */
public interface WfAppDownloadListener {
    void onDownloadActive(long j, long j2);

    void onDownloadDelete();

    void onDownloadFail(int i, String str);

    void onDownloadFinish();

    void onDownloadPause(long j, long j2);

    void onDownloadStart();

    void onInstall();
}
