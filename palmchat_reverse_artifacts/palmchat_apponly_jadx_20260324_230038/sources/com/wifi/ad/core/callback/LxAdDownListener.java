package com.wifi.ad.core.callback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface LxAdDownListener {
    void deleteDownApp(String str);

    void onError(int i, String str, String str2);

    void onFinish(String str);

    void onInstalled(String str);

    void onProgress(int i, String str);

    void onResume(String str);

    void onStart(String str);

    void onStartInstall();

    void onStop(String str);
}
