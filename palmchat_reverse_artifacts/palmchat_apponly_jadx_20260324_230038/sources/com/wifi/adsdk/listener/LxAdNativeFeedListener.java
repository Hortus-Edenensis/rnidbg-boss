package com.wifi.adsdk.listener;

import com.wifi.adsdk.nativefeed.LxNativeFeedAd;
import com.wifi.adsdk.params.LxAdReqParams;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface LxAdNativeFeedListener extends LxAdBaseListener {
    void onSuccess(List<LxNativeFeedAd> list, LxAdReqParams lxAdReqParams);
}
