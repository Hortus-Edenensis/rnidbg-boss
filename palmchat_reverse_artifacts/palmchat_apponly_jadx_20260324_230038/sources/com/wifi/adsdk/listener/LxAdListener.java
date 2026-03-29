package com.wifi.adsdk.listener;

import com.wifi.adsdk.params.LxAdReqParams;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface LxAdListener {
    void onFailed(int i, String str, LxAdReqParams lxAdReqParams);

    void onPrepare(LxAdReqParams lxAdReqParams);

    void onSuccess(String str, int i, LxAdReqParams lxAdReqParams);
}
