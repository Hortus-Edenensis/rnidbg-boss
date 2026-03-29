package com.wifi.adsdk.listener;

import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.pop.LxPopAd;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface LxAdPopListener extends LxAdBaseListener {
    void onSuccess(List<LxPopAd> list, LxAdReqParams lxAdReqParams);
}
