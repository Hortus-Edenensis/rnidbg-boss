package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fs extends fp {
    boolean h;
    private final int j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private String o;

    public fs(lt ltVar) {
        super(ltVar);
        this.j = hashCode();
        this.k = false;
        this.l = false;
        this.h = false;
        this.m = false;
        this.n = false;
        this.o = String.valueOf(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Context context;
        fh.V("RealtimeAdMediator", "doOnShowSloganEnd");
        this.l = true;
        if (this.m) {
            fh.V("RealtimeAdMediator", "Ad fails to display or loading timeout, ad dismiss");
            I(com.huawei.openalliance.ad.constant.ai.y);
            a();
        } else {
            if (this.h) {
                return;
            }
            fh.V(u(), "doOnShowSloganEnd Ad has been loaded, but not shown yet");
            if (this.n && (context = this.e) != null) {
                com.huawei.openalliance.ad.ipc.g.V(context).Code("getNormalSplashAd", String.valueOf(this.C.Z()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.fs.5
                    @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                    public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.5.1
                            @Override // java.lang.Runnable
                            public void run() {
                                fs.this.B = (AdContentData) callResult.getData();
                                fs fsVar = fs.this;
                                AdContentData adContentData = fsVar.B;
                                String strU = fsVar.u();
                                if (adContentData == null) {
                                    fh.V(strU, "linked loaded, do not call play");
                                    fs.this.I(-6);
                                    fs.this.a();
                                } else {
                                    fh.V(strU, "linked loaded, display normal when slogan ends");
                                    fs fsVar2 = fs.this;
                                    fsVar2.Code(fsVar2.B, true);
                                    fs.this.Z(1202);
                                }
                            }
                        });
                    }
                }, AdContentData.class);
            } else if (this.B != null) {
                fh.V(u(), "show splash");
                Code(this.B, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        AdContentData adContentData;
        fh.V("RealtimeAdMediator", "doOnReachMinSloganShowTime");
        this.k = true;
        if (!this.h && (adContentData = this.B) != null) {
            Code(adContentData, true);
            return;
        }
        fh.V("RealtimeAdMediator", "doOnReachMinSloganShowTime adFailToDisplay: %s", Boolean.valueOf(this.m));
        if (this.m) {
            fh.V("RealtimeAdMediator", "ad fail to load when reach min slogan show time");
            I(com.huawei.openalliance.ad.constant.ai.y);
            a();
        }
    }

    @Override // com.huawei.hms.ads.ft
    public void I(boolean z) {
        lt ltVarH = h();
        if (ltVarH == null) {
            fh.I("RealtimeAdMediator", "splash view is null");
            SplashListener splashListener = this.g;
            if (splashListener != null) {
                splashListener.onAdDismissed();
            }
        }
        AdContentData adContentData = this.B;
        if (adContentData == null) {
            SplashListener splashListener2 = this.g;
            if (splashListener2 != null) {
                splashListener2.onAdError(com.huawei.openalliance.ad.constant.ai.u);
            }
            a();
            fh.I("RealtimeAdMediator", "ad is null");
            return;
        }
        if (adContentData.d() < com.huawei.openalliance.ad.utils.z.Code()) {
            fh.I("RealtimeAdMediator", "show ad, ad expire");
            SplashListener splashListener3 = this.g;
            if (splashListener3 != null) {
                splashListener3.onAdError(com.huawei.openalliance.ad.constant.ai.aj);
                return;
            }
            return;
        }
        fh.V("RealtimeAdMediator", "showAd, showSlogan: %s", Boolean.valueOf(z));
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.3
            @Override // java.lang.Runnable
            public void run() {
                fs.this.D();
            }
        });
        if (z) {
            ltVarH.Code(new mg() { // from class: com.huawei.hms.ads.fs.4
                @Override // com.huawei.hms.ads.mg
                public void Code() {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.w();
                        }
                    });
                }

                @Override // com.huawei.hms.ads.mg
                public void V() {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.4.2
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.v();
                        }
                    });
                }
            });
        } else {
            w();
        }
    }

    @Override // com.huawei.hms.ads.fp
    public String f() {
        return this.o;
    }

    @Override // com.huawei.hms.ads.ft
    public void q() {
        fh.V("RealtimeAdMediator", "start");
        lt ltVarH = h();
        if (ltVarH == null) {
            I(-4);
            a();
        } else {
            c();
            com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.1
                @Override // java.lang.Runnable
                public void run() {
                    fs.this.D();
                }
            });
            ltVarH.Code(new mg() { // from class: com.huawei.hms.ads.fs.2
                @Override // com.huawei.hms.ads.mg
                public void Code() {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.w();
                        }
                    });
                }

                @Override // com.huawei.hms.ads.mg
                public void V() {
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            fs.this.v();
                        }
                    });
                }
            });
            e();
        }
    }

    @Override // com.huawei.hms.ads.ft
    public void r() {
        fh.V("RealtimeAdMediator", "onAdFailToDisplay - reachMinSloganShowTime: %s sloganShowEnd: %s", Boolean.valueOf(this.k), Boolean.valueOf(this.l));
        this.m = true;
        if (this.k || this.l) {
            a();
        }
    }

    @Override // com.huawei.hms.ads.ft
    public AdContentData s() {
        return this.B;
    }

    public String u() {
        return "RealtimeAdMediator" + this.j;
    }

    @Override // com.huawei.hms.ads.fp
    public void Code(AdContentData adContentData, boolean z) {
        SplashLoadListener splashLoadListener;
        SplashLoadListener splashLoadListener2;
        fh.V("RealtimeAdMediator", "on content loaded");
        this.B = adContentData;
        if (adContentData == null) {
            I(com.huawei.openalliance.ad.constant.ai.u);
            r();
            if (z || (splashLoadListener2 = this.f) == null) {
                return;
            }
            splashLoadListener2.onAdFailed(com.huawei.openalliance.ad.constant.ai.u);
            return;
        }
        lt ltVarH = h();
        if (ltVarH == null) {
            I(com.huawei.openalliance.ad.constant.ai.w);
            r();
            if (z || (splashLoadListener = this.f) == null) {
                return;
            }
            splashLoadListener.onAdFailed(com.huawei.openalliance.ad.constant.ai.w);
            return;
        }
        if (!z) {
            fh.V("RealtimeAdMediator", "displayAfterLoaded false");
            SplashLoadListener splashLoadListener3 = this.f;
            if (splashLoadListener3 != null) {
                splashLoadListener3.onAdLoaded();
                return;
            }
            return;
        }
        dg dgVar = new dg(ltVarH.getContext());
        if (dgVar.Code()) {
            I(com.huawei.openalliance.ad.constant.ai.v);
            r();
            return;
        }
        if (this.B.l() != 12) {
            if (!this.k && !this.l) {
                fh.V("RealtimeAdMediator", "slogan hasn't reach min show time or end, show ad later");
                return;
            }
            if (dgVar.Code()) {
                I(com.huawei.openalliance.ad.constant.ai.v);
                r();
                return;
            }
            boolean zV = V(this.B);
            this.h = true;
            if (zV) {
                return;
            }
            V(com.huawei.openalliance.ad.constant.ai.w);
            return;
        }
        if (Z() == 1 && (I() instanceof com.huawei.openalliance.ad.inter.listeners.m)) {
            fh.V("RealtimeAdMediator", "on linked loaded, sloganShowEnd:" + this.l);
            if (!this.l) {
                com.huawei.openalliance.ad.inter.listeners.m mVar = (com.huawei.openalliance.ad.inter.listeners.m) I();
                com.huawei.openalliance.ad.inter.data.k kVarCode = jl.Code(this.B);
                fh.V(u(), "on content loaded, linkedAd loaded. ");
                this.F = System.currentTimeMillis();
                mVar.Code(kVarCode);
                this.L = this.B;
                this.n = true;
                B(200);
                return;
            }
        }
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fs.6
            @Override // java.lang.Runnable
            public void run() {
                fs.this.I(1200);
                fs.this.r();
            }
        });
    }

    @Override // com.huawei.hms.ads.ft
    public void V(boolean z) {
        if (z) {
            q();
            return;
        }
        fh.V("RealtimeAdMediator", "start load ad.");
        lt ltVarH = h();
        AdSlotParam adSlotParamB = b();
        if (ltVarH != null && adSlotParamB != null) {
            this.o = String.valueOf(102);
            Code(adSlotParamB);
            Code(adSlotParamB, d(), false);
        } else {
            SplashLoadListener splashLoadListener = this.f;
            if (splashLoadListener != null) {
                splashLoadListener.onAdFailed(-4);
            }
        }
    }
}
