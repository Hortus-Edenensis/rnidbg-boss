package com.huawei.hms.ads.nativead;

import com.huawei.hms.ads.annotation.AllApi;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@AllApi
public interface IUnityNativeAdPresenter {
    int getMinEffectiveShowRatio();

    long getMinEffectiveShowTime();

    boolean onUnityAdClick();

    void onUnityAdClose(List<String> list);

    void onUnityAdPhyShow(long j, int i);

    void onUnityAdShow(Long l, Integer num, Integer num2);

    void onUnityAdShowStart();

    void onUnityGoWhyShowThis();

    void updateContent();
}
