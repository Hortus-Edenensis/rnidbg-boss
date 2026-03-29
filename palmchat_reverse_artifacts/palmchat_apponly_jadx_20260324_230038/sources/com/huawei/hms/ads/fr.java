package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.ipc.CallResult;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class fr extends fp {
    public fr(lt ltVar) {
        super(ltVar);
    }

    private void t() {
        com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fr.3
            @Override // java.lang.Runnable
            public void run() {
                fr.this.c();
            }
        }, 2000L);
    }

    @Override // com.huawei.hms.ads.fp
    public String f() {
        return String.valueOf(1);
    }

    @Override // com.huawei.hms.ads.ft
    public void q() {
        fh.V("CacheAdMediator", "start");
        lt ltVarH = h();
        if (ltVarH == null) {
            I(-4);
            a();
            return;
        }
        AdContentData adContentData = this.C.B() != 0 ? (AdContentData) com.huawei.openalliance.ad.utils.be.Code(new Callable<AdContentData>() { // from class: com.huawei.hms.ads.fr.1
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: Code, reason: merged with bridge method [inline-methods] */
            public AdContentData call() {
                Context context;
                AdSlotParam adSlotParamB = fr.this.b();
                if (adSlotParamB == null || (context = fr.this.e) == null) {
                    fh.I("CacheAdMediator", "adslot is null");
                    return null;
                }
                CallResult callResultCode = com.huawei.openalliance.ad.ipc.b.Code(context).Code("queryCacheSplashAd", com.huawei.openalliance.ad.utils.ad.V(adSlotParamB), String.class);
                fr.this.d = (String) callResultCode.getData();
                return (AdContentData) com.huawei.openalliance.ad.utils.ad.V((String) callResultCode.getData(), AdContentData.class, new Class[0]);
            }
        }, null) : null;
        this.B = adContentData;
        this.S = true;
        if (adContentData == null) {
            fh.V("CacheAdMediator", "show sloganView");
            ltVarH.Code(new mg() { // from class: com.huawei.hms.ads.fr.2
                @Override // com.huawei.hms.ads.mg
                public void Code() {
                    fh.V("CacheAdMediator", "on Slogan Reach Min Show Time");
                }

                @Override // com.huawei.hms.ads.mg
                public void V() {
                    fh.V("CacheAdMediator", "on Slogan Show End");
                    com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fr.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fr.this.I(com.huawei.openalliance.ad.constant.ai.x);
                            fr.this.a();
                        }
                    });
                }
            });
        } else {
            if (adContentData.l() == 12) {
                if (Z() != 1 || !(I() instanceof com.huawei.openalliance.ad.inter.listeners.m)) {
                    I(1200);
                    r();
                    t();
                    return;
                }
                com.huawei.openalliance.ad.inter.listeners.m mVar = (com.huawei.openalliance.ad.inter.listeners.m) I();
                com.huawei.openalliance.ad.inter.data.k kVarCode = jl.Code(adContentData);
                fh.V("CacheAdMediator", "on content find, linkedAd loaded. ");
                this.F = System.currentTimeMillis();
                mVar.Code(kVarCode);
                this.L = adContentData;
                t();
                B(200);
                return;
            }
            if (!V(adContentData)) {
                I(com.huawei.openalliance.ad.constant.ai.w);
                r();
            }
        }
        t();
    }

    @Override // com.huawei.hms.ads.ft
    public void r() {
        fh.V("CacheAdMediator", "onAdFailToDisplay");
        a();
    }

    @Override // com.huawei.hms.ads.ft
    public AdContentData s() {
        return null;
    }

    @Override // com.huawei.hms.ads.ft
    public void I(boolean z) {
    }

    @Override // com.huawei.hms.ads.ft
    public void V(boolean z) {
    }

    @Override // com.huawei.hms.ads.fp
    public void Code(AdContentData adContentData, boolean z) {
    }
}
