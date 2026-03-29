package com.wifi.adsdk.listener;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface LxNativeDownListener {
    void onDownloadFail(int i, String str);

    void onDownloadFinish();

    void onDownloadPause();

    void onDownloadProcess(int i);

    void onDownloadStart();

    void onInstall();
}
