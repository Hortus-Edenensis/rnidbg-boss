package com.huawei.hms.ads;

import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public interface ft {
    void B();

    void C();

    void C(int i);

    void Code(int i);

    void Code(int i, int i2);

    void Code(long j);

    void Code(RewardVerifyConfig rewardVerifyConfig);

    void Code(SplashAdDisplayListener splashAdDisplayListener);

    void Code(SplashView.SplashAdLoadListener splashAdLoadListener);

    void Code(SplashListener splashListener);

    void Code(SplashLoadListener splashLoadListener);

    void Code(AdContentData adContentData);

    void Code(AdContentData adContentData, long j, int i);

    void Code(com.huawei.openalliance.ad.inter.listeners.a aVar);

    void Code(com.huawei.openalliance.ad.inter.listeners.b bVar);

    boolean Code(int i, int i2, AdContentData adContentData, Long l, MaterialClickInfo materialClickInfo, int i3);

    void F();

    void I(int i);

    void I(AdContentData adContentData);

    void I(boolean z);

    void L();

    com.huawei.openalliance.ad.constant.b V();

    void V(int i);

    void V(long j);

    void V(boolean z);

    void a();

    boolean j();

    AdContentData m();

    void n();

    String o();

    BiddingInfo p();

    void q();

    void r();

    AdContentData s();
}
