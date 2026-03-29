package com.wifi.adsdk.listener;

import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.tempfeed.LxTempFeedAd;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public interface LxAdTempFeedListener extends LxAdBaseListener {
    void onSuccess(List<LxTempFeedAd> list, LxAdReqParams lxAdReqParams);
}
