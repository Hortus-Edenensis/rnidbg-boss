package com.huawei.hms.ads.instreamad;

import com.huawei.hms.ads.annotation.GlobalApi;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public interface InstreamAdLoadListener {
    void onAdFailed(int i);

    void onAdLoaded(List<InstreamAd> list);
}
