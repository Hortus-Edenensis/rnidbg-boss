package com.huawei.hms.ads.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.VideoConfiguration;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.cg;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.k;
import com.huawei.hms.ads.utils.c;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.RewardItem;
import com.huawei.openalliance.ad.inter.data.i;
import com.huawei.openalliance.ad.inter.data.q;
import com.huawei.openalliance.ad.inter.listeners.g;
import com.huawei.openalliance.ad.inter.listeners.h;
import com.huawei.openalliance.ad.inter.r;
import com.huawei.openalliance.ad.utils.ag;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public class RewardAd {
    private String B;
    private Reward C;
    private q D;
    private VideoConfiguration F;
    private Context I;
    private r L;
    private RewardVerifyConfig S;
    private OnMetadataChangedListener V;
    private RewardAdListener b;
    private String c;
    private String d;
    private int f;
    private boolean Z = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Bundle f6603a = new Bundle();
    private boolean e = false;
    private boolean g = true;

    /* JADX INFO: compiled from: SearchBox */
    public class a implements com.huawei.openalliance.ad.inter.listeners.q {
        private RewardAdListener I;
        private RewardAdLoadListener V;

        public a(RewardAdLoadListener rewardAdLoadListener, RewardAdListener rewardAdListener) {
            this.V = rewardAdLoadListener;
            this.I = rewardAdListener;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.q
        public void Code(int i) {
            RewardAd.this.Z = false;
            RewardAdLoadListener rewardAdLoadListener = this.V;
            if (rewardAdLoadListener != null) {
                rewardAdLoadListener.onRewardAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.q
        public void Code(Map<String, List<i>> map) {
            RewardAdListener rewardAdListener;
            RewardAd.this.Z = true;
            List<i> list = map.get(RewardAd.this.B);
            if (ag.Code(list)) {
                RewardAdLoadListener rewardAdLoadListener = this.V;
                if (rewardAdLoadListener != null) {
                    rewardAdLoadListener.onRewardAdFailedToLoad(3);
                }
                rewardAdListener = this.I;
                if (rewardAdListener == null) {
                    return;
                }
            } else {
                i iVar = list.get(0);
                if (iVar instanceof q) {
                    RewardAd.this.D = (q) iVar;
                    RewardAd.this.D.V(RewardAd.this.g);
                    RewardAd rewardAd = RewardAd.this;
                    rewardAd.C = new cg(rewardAd.D.S());
                    RewardAdLoadListener rewardAdLoadListener2 = this.V;
                    if (rewardAdLoadListener2 != null) {
                        rewardAdLoadListener2.onRewardedLoaded();
                    }
                    RewardAdListener rewardAdListener2 = this.I;
                    if (rewardAdListener2 != null) {
                        rewardAdListener2.onRewardAdLoaded();
                    }
                    if (RewardAd.this.V != null) {
                        RewardAd.this.V.onMetadataChanged();
                        return;
                    }
                    return;
                }
                RewardAdLoadListener rewardAdLoadListener3 = this.V;
                if (rewardAdLoadListener3 != null) {
                    rewardAdLoadListener3.onRewardAdFailedToLoad(3);
                }
                rewardAdListener = this.I;
                if (rewardAdListener == null) {
                    return;
                }
            }
            rewardAdListener.onRewardAdFailedToLoad(3);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public class b implements g, h {
        private RewardAdListener I;
        private RewardAdStatusListener V;

        public b(RewardAdStatusListener rewardAdStatusListener, RewardAdListener rewardAdListener) {
            this.V = rewardAdStatusListener;
            this.I = rewardAdListener;
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void B() {
            RewardItem rewardItemS = RewardAd.this.D.S();
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewarded(rewardItemS != null ? new cg(rewardItemS) : Reward.DEFAULT);
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewarded(new cg(rewardItemS));
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.h
        public void C() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdStarted();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code() {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdOpened();
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdOpened();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void I() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdCompleted();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.h
        public void S() {
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdLeftApp();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Z() {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdClosed();
            }
            RewardAdListener rewardAdListener = this.I;
            if (rewardAdListener != null) {
                rewardAdListener.onRewardAdClosed();
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void Code(int i, int i2) {
            RewardAdStatusListener rewardAdStatusListener = this.V;
            if (rewardAdStatusListener != null) {
                rewardAdStatusListener.onRewardAdFailedToShow(0);
            }
        }

        @Override // com.huawei.openalliance.ad.inter.listeners.g
        public void V() {
        }
    }

    private RewardAd(Context context) {
        if (context != null) {
            this.I = context.getApplicationContext();
        }
    }

    private void V() {
        this.Z = false;
        this.D = null;
    }

    @GlobalApi
    public static RewardAd createRewardAdInstance(Context context) {
        return new RewardAd(context);
    }

    @GlobalApi
    public void destroy() {
    }

    @GlobalApi
    public BiddingInfo getBiddingInfo() {
        q qVar = this.D;
        return (qVar == null || qVar.ah() == null) ? new BiddingInfo() : this.D.ah();
    }

    @GlobalApi
    public String getData() {
        return this.c;
    }

    @GlobalApi
    public Bundle getMetadata() {
        return this.f6603a;
    }

    @GlobalApi
    public Reward getReward() {
        return this.C;
    }

    @GlobalApi
    public RewardAdListener getRewardAdListener() {
        return this.b;
    }

    @GlobalApi
    public String getUserId() {
        return this.d;
    }

    @GlobalApi
    public boolean isLoaded() {
        return this.Z;
    }

    @GlobalApi
    public void loadAd(AdParam adParam, RewardAdLoadListener rewardAdLoadListener) {
        k.Code().Code(this.I);
        V();
        Code(adParam);
        this.L.Code(new a(rewardAdLoadListener, null));
        this.L.Code(this.f, false);
    }

    @GlobalApi
    public void pause() {
    }

    @GlobalApi
    public void resume() {
    }

    @GlobalApi
    public void sendBiddingFailed(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, Code(), getBiddingInfo().getLurl(), false);
        fh.Code("RewardAd", "sendBiddingFailed result");
    }

    @GlobalApi
    public void sendBiddingSuccess(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, Code(), getBiddingInfo().getNurl(), true);
        fh.Code("RewardAd", "sendBiddingSuccess result");
    }

    @GlobalApi
    public void setData(String str) {
        this.c = str;
    }

    @GlobalApi
    public void setImmersive(boolean z) {
        this.e = z;
    }

    @GlobalApi
    public void setMobileDataAlertSwitch(boolean z) {
        this.g = z;
    }

    @GlobalApi
    public void setOnMetadataChangedListener(OnMetadataChangedListener onMetadataChangedListener) {
        this.V = onMetadataChangedListener;
    }

    @GlobalApi
    public void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.b = rewardAdListener;
    }

    @GlobalApi
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.S = rewardVerifyConfig;
    }

    @GlobalApi
    public void setUserId(String str) {
        this.d = str;
    }

    @GlobalApi
    public void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.F = videoConfiguration;
    }

    @GlobalApi
    @Deprecated
    public void show() {
        Code(this.I);
    }

    @GlobalApi
    public RewardAd(Context context, String str) {
        this.B = str;
        this.I = context.getApplicationContext();
        this.L = new r(context, TextUtils.isEmpty(str) ? null : new String[]{str});
        this.f = com.huawei.openalliance.ad.utils.q.I(context);
    }

    public AdContentData Code() {
        q qVar = this.D;
        if (qVar != null) {
            return qVar.q();
        }
        return null;
    }

    @GlobalApi
    public void destroy(Context context) {
    }

    @GlobalApi
    public void loadAd(String str, AdParam adParam) {
        this.B = str;
        k.Code().Code(this.I);
        V();
        r rVar = new r(this.I, TextUtils.isEmpty(str) ? null : new String[]{str});
        this.L = rVar;
        rVar.Code(new a(null, this.b));
        Code(adParam);
        this.L.Code(this.f, false);
    }

    @GlobalApi
    public void pause(Context context) {
    }

    @GlobalApi
    public void resume(Context context) {
    }

    @GlobalApi
    public void show(Activity activity) {
        Code(activity);
    }

    @GlobalApi
    public void show(Activity activity, RewardAdStatusListener rewardAdStatusListener) {
        show(activity, rewardAdStatusListener, true);
    }

    @GlobalApi
    public void show(Activity activity, RewardAdStatusListener rewardAdStatusListener, boolean z) {
        int i;
        q qVar = this.D;
        if (qVar == null) {
            i = 2;
        } else {
            if (!qVar.C()) {
                RewardVerifyConfig rewardVerifyConfig = this.S;
                if (rewardVerifyConfig != null) {
                    this.D.Code(rewardVerifyConfig);
                    this.D.V(this.S.getUserId());
                    this.D.Code(this.S.getData());
                }
                b bVar = new b(rewardAdStatusListener, null);
                this.D.Code((h) bVar);
                this.D.Code(this.F);
                this.D.Code(activity, (g) bVar);
                return;
            }
            i = 1;
        }
        Code(rewardAdStatusListener, i);
    }

    private void Code(Context context) {
        q qVar;
        if (!this.Z || (qVar = this.D) == null) {
            return;
        }
        qVar.V(this.d);
        this.D.Code(this.c);
        this.D.Code(this.F);
        b bVar = new b(null, this.b);
        this.D.Code((h) bVar);
        this.D.Code(context, bVar);
    }

    private void Code(AdParam adParam) {
        if (adParam == null || this.L == null) {
            return;
        }
        this.L.Code(c.Code(adParam.V()));
        this.L.Code(adParam.getKeywords());
        this.L.Code(adParam.getGender());
        this.L.V(adParam.getTargetingContentUrl());
        this.L.I(adParam.I());
        this.L.Code(adParam.C());
        this.L.Code(adParam.Code());
        HiAd.getInstance(this.I).setCountryCode(adParam.Z());
    }

    private void Code(RewardAdStatusListener rewardAdStatusListener, int i) {
        if (rewardAdStatusListener != null) {
            rewardAdStatusListener.onRewardAdFailedToShow(i);
        }
    }
}
