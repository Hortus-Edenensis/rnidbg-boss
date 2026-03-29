package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.inter.data.IInterstitialAd;
import com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener;
import com.huawei.hms.ads.reward.OnMetadataChangedListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class ab {
    private String B;
    private OnMetadataChangedListener C;
    private Bundle D;
    private Context I;
    private String L;
    private RewardAdListener S;
    private AdListener Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f6527a;
    private long b;
    private long c;
    private App d;
    private RewardVerifyConfig g;
    private VideoConfiguration h;
    private com.huawei.openalliance.ad.inter.listeners.i i;
    private Integer j;
    private b V = b.IDLE;
    private List<IInterstitialAd> e = new ArrayList();
    private IInterstitialAd f = null;
    private IInterstitialAdStatusListener k = new c(this);
    private INonwifiActionListener l = new INonwifiActionListener() { // from class: com.huawei.hms.ads.ab.1
        @Override // com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener
        public boolean Code(long j) {
            return false;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.INonwifiActionListener
        public boolean Code(com.huawei.openalliance.ad.inter.data.AppInfo appInfo, long j) {
            return false;
        }
    };

    /* JADX INFO: compiled from: SearchBox */
    public static class a implements Comparator<IInterstitialAd> {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
        public int compare(IInterstitialAd iInterstitialAd, IInterstitialAd iInterstitialAd2) {
            if (Code(iInterstitialAd.ah()) && !Code(iInterstitialAd2.ah())) {
                return -1;
            }
            if (Code(iInterstitialAd.ah()) && Code(iInterstitialAd2.ah())) {
                return (iInterstitialAd.ah().getPrice().floatValue() <= 0.0f || Float.compare(iInterstitialAd.ah().getPrice().floatValue(), iInterstitialAd2.ah().getPrice().floatValue()) >= 0) ? -1 : 1;
            }
            return 1;
        }

        private boolean Code(BiddingInfo biddingInfo) {
            return (biddingInfo == null || biddingInfo.getPrice() == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public enum b {
        IDLE,
        LOADING
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class c implements IInterstitialAdStatusListener {
        private WeakReference<ab> Code;

        public c(ab abVar) {
            this.Code = new WeakReference<>(abVar);
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClicked() {
            ab abVar = this.Code.get();
            if (abVar == null || abVar.Z == null) {
                return;
            }
            abVar.Z.onAdClicked();
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdClosed() {
            ab abVar = this.Code.get();
            if (abVar != null) {
                if (abVar.Z != null) {
                    abVar.Z.onAdClosed();
                }
                if (abVar.S != null) {
                    abVar.S.onRewardAdClosed();
                }
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdCompleted() {
            ab abVar = this.Code.get();
            if (abVar == null || abVar.S == null) {
                return;
            }
            abVar.S.onRewardAdCompleted();
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdError(int i, int i2) {
            ab abVar = this.Code.get();
            if (abVar != null) {
                if (abVar.Z != null) {
                    abVar.Z.onAdFailed(com.huawei.hms.ads.utils.b.Code(i));
                }
                if (abVar.S != null) {
                    abVar.S.onRewardAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
                }
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onAdShown() {
            ab abVar = this.Code.get();
            if (abVar != null) {
                if (abVar.Z != null) {
                    abVar.Z.onAdOpened();
                }
                if (abVar.S != null) {
                    abVar.S.onRewardAdOpened();
                }
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onLeftApp() {
            ab abVar = this.Code.get();
            if (abVar != null) {
                if (abVar.Z != null) {
                    abVar.Z.onAdLeave();
                }
                if (abVar.S != null) {
                    abVar.S.onRewardAdLeftApp();
                }
            }
        }

        @Override // com.huawei.hms.ads.inter.listeners.IInterstitialAdStatusListener
        public void onRewarded() {
            ab abVar = this.Code.get();
            if (abVar == null || abVar.S == null) {
                return;
            }
            abVar.S.onRewarded(new cg(abVar.f.S()));
        }
    }

    public ab(Context context) {
        this.I = context;
    }

    private boolean a() {
        if (!com.huawei.openalliance.ad.utils.z.Code(this.I)) {
            AdListener adListener = this.Z;
            if (adListener != null) {
                adListener.onAdFailed(5);
            }
            RewardAdListener rewardAdListener = this.S;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdFailedToLoad(5);
            }
            return false;
        }
        if (this.V == b.LOADING) {
            fh.V("InterstitialAdManager", "waiting for request finish");
            AdListener adListener2 = this.Z;
            if (adListener2 != null) {
                adListener2.onAdFailed(4);
            }
            RewardAdListener rewardAdListener2 = this.S;
            if (rewardAdListener2 != null) {
                rewardAdListener2.onRewardAdFailedToLoad(4);
            }
            return false;
        }
        if (!TextUtils.isEmpty(this.B)) {
            return true;
        }
        fh.I("InterstitialAdManager", "empty ad ids");
        AdListener adListener3 = this.Z;
        if (adListener3 != null) {
            adListener3.onAdFailed(1);
        }
        RewardAdListener rewardAdListener3 = this.S;
        if (rewardAdListener3 != null) {
            rewardAdListener3.onRewardAdFailedToLoad(1);
        }
        return false;
    }

    public IInterstitialAd Z() {
        for (IInterstitialAd iInterstitialAd : this.e) {
            if (iInterstitialAd != null && !iInterstitialAd.C()) {
                return iInterstitialAd;
            }
        }
        return null;
    }

    public final boolean B() {
        return this.V == b.LOADING;
    }

    public final AdListener Code() {
        return this.Z;
    }

    public final void D() {
        fh.V("InterstitialAdManager", bq.b.V);
        Code(this.I);
    }

    public final Bundle F() {
        Bundle bundle = this.D;
        return bundle == null ? new Bundle() : bundle;
    }

    public final boolean I() {
        return (com.huawei.openalliance.ad.utils.ag.Code(this.e) || Z() == null) ? false : true;
    }

    public BiddingInfo L() {
        IInterstitialAd iInterstitialAdZ = Z();
        return (iInterstitialAdZ == null || iInterstitialAdZ.ah() == null) ? new BiddingInfo() : iInterstitialAdZ.ah();
    }

    public final String V() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V(Map<String, List<IInterstitialAd>> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (List<IInterstitialAd> list : map.values()) {
            if (!com.huawei.openalliance.ad.utils.ag.Code(list)) {
                for (IInterstitialAd iInterstitialAd : list) {
                    if (iInterstitialAd.k() || !iInterstitialAd.V()) {
                        fh.V("InterstitialAdManager", "ad is invalid, content id:" + iInterstitialAd.d());
                    } else {
                        this.e.add(iInterstitialAd);
                    }
                }
            }
        }
        Collections.sort(this.e, new a());
        OnMetadataChangedListener onMetadataChangedListener = this.C;
        if (onMetadataChangedListener != null) {
            onMetadataChangedListener.onMetadataChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final int i) {
        fh.V("InterstitialAdManager", "onAdFailed, errorCode:" + i);
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ab.3
            @Override // java.lang.Runnable
            public void run() {
                ab.this.b = System.currentTimeMillis();
                if (ab.this.Z != null) {
                    ab.this.Z.onAdFailed(com.huawei.hms.ads.utils.b.Code(i));
                }
                if (ab.this.i != null) {
                    ab.this.i.Code(i);
                }
                if (ab.this.S != null) {
                    ab.this.S.onRewardAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
                }
                db.Code(ab.this.I, i, ab.this.L, 12, null, ab.this.f6527a, ab.this.b, ab.this.c);
            }
        });
    }

    public final void Code(Activity activity) {
        fh.V("InterstitialAdManager", "show activity");
        Code((Context) activity);
    }

    private void Code(Context context) {
        for (IInterstitialAd iInterstitialAd : this.e) {
            if (iInterstitialAd != null && !iInterstitialAd.C()) {
                this.f = iInterstitialAd;
                VideoConfiguration videoConfiguration = this.h;
                if (videoConfiguration != null) {
                    iInterstitialAd.setVideoConfiguration(videoConfiguration);
                }
                iInterstitialAd.Code(this.g);
                iInterstitialAd.setRewardAdListener(this.S);
                iInterstitialAd.setNonwifiActionListener(this.l);
                iInterstitialAd.show(context, this.k);
                return;
            }
        }
    }

    public final void Code(AdListener adListener) {
        this.Z = adListener;
    }

    public final void Code(AdParam adParam) {
        this.f6527a = System.currentTimeMillis();
        fh.V("InterstitialAdManager", com.huawei.openalliance.ad.constant.h.Code);
        if (a()) {
            AdSlotParam.a aVar = new AdSlotParam.a();
            Code(adParam, aVar);
            if (this.d != null && !com.huawei.openalliance.ad.utils.z.I(this.I)) {
                fh.I("InterstitialAdManager", "hms ver not support set appInfo.");
                Code(706);
                return;
            }
            com.huawei.openalliance.ad.utils.ai.Code(this.I.getApplicationContext(), aVar.V());
            this.V = b.LOADING;
            this.e.clear();
            BaseAdReqParam baseAdReqParam = new BaseAdReqParam();
            baseAdReqParam.Code(this.f6527a);
            je.Code(this.I, "interstitial_ad_load", aVar.S(), com.huawei.openalliance.ad.utils.ad.V(baseAdReqParam), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.ab.2
                @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                public void onRemoteCallResult(String str, CallResult<String> callResult) {
                    ab abVar;
                    int code;
                    ab.this.c = System.currentTimeMillis();
                    if (callResult.getCode() == 200) {
                        Map<String, List<AdContentData>> map = (Map) com.huawei.openalliance.ad.utils.ad.V(callResult.getData(), Map.class, List.class, AdContentData.class);
                        if (ab.this.i != null) {
                            ab.this.i.Code(map);
                        }
                        code = 204;
                        if (map != null && map.size() > 0) {
                            HashMap map2 = new HashMap(map.size());
                            for (Map.Entry<String, List<AdContentData>> entry : map.entrySet()) {
                                String key = entry.getKey();
                                List<AdContentData> value = entry.getValue();
                                if (value != null) {
                                    ArrayList arrayList = new ArrayList(value.size());
                                    for (AdContentData adContentData : value) {
                                        if (ab.this.L == null) {
                                            ab.this.L = adContentData.M();
                                        }
                                        arrayList.add(new com.huawei.hms.ads.inter.data.a(adContentData));
                                    }
                                    map2.put(key, arrayList);
                                }
                            }
                            if (!com.huawei.openalliance.ad.utils.al.Code(map2)) {
                                ab.this.V(map2);
                                if (!com.huawei.openalliance.ad.utils.ag.Code(ab.this.e)) {
                                    ab.this.Code(map2);
                                    ab.this.V = b.IDLE;
                                }
                            }
                        }
                        abVar = ab.this;
                    } else {
                        abVar = ab.this;
                        code = callResult.getCode();
                    }
                    abVar.Code(code);
                    ab.this.V = b.IDLE;
                }
            }, String.class);
        }
    }

    private void Code(AdParam adParam, AdSlotParam.a aVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.B);
        aVar.Code(arrayList).V(com.huawei.openalliance.ad.utils.q.I(this.I)).Code(this.I.getResources().getConfiguration().orientation != 1 ? 0 : 1).I(d.Z(this.I)).Z(d.B(this.I));
        Integer num = this.j;
        if (num != null) {
            aVar.S(num);
        }
        if (adParam != null) {
            RequestOptions requestOptionsCode = com.huawei.hms.ads.utils.c.Code(adParam.V());
            App app = requestOptionsCode.getApp();
            if (app != null) {
                this.d = app;
            }
            aVar.Code(requestOptionsCode).S(adParam.getGender()).V(adParam.getTargetingContentUrl()).Code(adParam.getKeywords()).Code(this.d).I(adParam.I()).C(adParam.C());
            if (adParam.Code() != null) {
                aVar.Code(adParam.Code());
            }
        }
    }

    public final void Code(VideoConfiguration videoConfiguration) {
        this.h = videoConfiguration;
    }

    public final void Code(OnMetadataChangedListener onMetadataChangedListener) {
        if (this.C != null) {
            fh.V("InterstitialAdManager", "Update ad metadata listener.");
        }
        this.C = onMetadataChangedListener;
    }

    public final void Code(RewardAdListener rewardAdListener) {
        if (this.S != null) {
            fh.V("InterstitialAdManager", "Update rewarded video listener.");
        }
        this.S = rewardAdListener;
    }

    public final void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.g = rewardVerifyConfig;
    }

    public void Code(com.huawei.openalliance.ad.inter.listeners.i iVar) {
        this.i = iVar;
    }

    public void Code(Integer num) {
        this.j = num;
    }

    public final void Code(String str) {
        this.B = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final Map<String, List<IInterstitialAd>> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("onAdsLoaded, size:");
        sb.append(map != null ? Integer.valueOf(map.size()) : null);
        fh.V("InterstitialAdManager", sb.toString());
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.ab.4
            @Override // java.lang.Runnable
            public void run() {
                ab.this.b = System.currentTimeMillis();
                if (ab.this.Z != null) {
                    ab.this.Z.onAdLoaded();
                }
                if (ab.this.S != null) {
                    ab.this.S.onRewardAdLoaded();
                }
                db.Code(ab.this.I, 200, ab.this.L, 12, map, ab.this.f6527a, ab.this.b, ab.this.c);
            }
        });
    }
}
