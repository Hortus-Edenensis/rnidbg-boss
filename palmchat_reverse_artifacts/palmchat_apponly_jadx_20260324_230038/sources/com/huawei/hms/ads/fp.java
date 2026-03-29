package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.dynamic.ObjectWrapper;
import com.huawei.hms.ads.ji;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.hms.ads.splash.R;
import com.huawei.hms.ads.splash.SplashAdDisplayListener;
import com.huawei.hms.ads.splash.SplashView;
import com.huawei.hms.ads.splash.listener.SplashListener;
import com.huawei.hms.ads.splash.listener.SplashLoadListener;
import com.huawei.hms.ads.uiengine.IRemoteCreator;
import com.huawei.hms.ads.uiengine.d;
import com.huawei.openalliance.ad.beans.inner.AnalysisEventReport;
import com.huawei.openalliance.ad.beans.inner.BaseAdReqParam;
import com.huawei.openalliance.ad.beans.inner.SplashAdReqParam;
import com.huawei.openalliance.ad.beans.metadata.DelayInfo;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.bq;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import com.huawei.openalliance.ad.inter.data.MaterialClickInfo;
import com.huawei.openalliance.ad.ipc.CallResult;
import com.huawei.openalliance.ad.ipc.RemoteCallResultCallback;
import com.huawei.openalliance.ad.utils.i;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public abstract class fp implements ft {
    private static long M;
    protected AdContentData B;
    protected eh C;
    protected WeakReference<lv> I;
    private jq K;
    protected AdContentData L;
    protected com.huawei.openalliance.ad.constant.b Z;
    protected RewardVerifyConfig b;
    protected int c;
    protected String d;
    protected Context e;
    protected SplashLoadListener f;
    protected SplashListener g;
    private WeakReference<lt> k;
    private com.huawei.openalliance.ad.inter.listeners.b l;
    private SplashView.SplashAdLoadListener m;
    private com.huawei.openalliance.ad.inter.listeners.a v;
    private SplashAdDisplayListener w;
    private CountDownTimer x;
    private String y;
    private hb j = new gp();
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    protected boolean S = false;
    private boolean q = false;
    private final String r = "load_timeout_" + hashCode();
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private long z = 0;
    private long A = -1;
    protected long F = 0;
    private int E = 0;
    protected boolean D = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected DelayInfo f6563a = new DelayInfo();
    private boolean G = false;
    private boolean H = false;
    private boolean J = false;
    private long N = 0;
    private boolean O = false;

    /* JADX INFO: renamed from: com.huawei.hms.ads.fp$2, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass2 implements RemoteCallResultCallback<String> {
        final /* synthetic */ int Code;

        public AnonymousClass2(int i) {
            this.Code = i;
        }

        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
        public void onRemoteCallResult(String str, final CallResult<String> callResult) {
            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fp.2.1
                @Override // java.lang.Runnable
                public void run() {
                    fp.this.d = (String) callResult.getData();
                    final AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.ad.V((String) callResult.getData(), AdContentData.class, new Class[0]);
                    if (adContentData != null) {
                        fp.this.F = System.currentTimeMillis();
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        fp.this.S(anonymousClass2.Code);
                        fp.this.B = adContentData;
                        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.fp.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                fp fpVar = fp.this;
                                fpVar.Code(fpVar.e, adContentData, anonymousClass22.Code);
                            }
                        });
                        if (fp.this.V(adContentData)) {
                            return;
                        } else {
                            fp.this.I(com.huawei.openalliance.ad.constant.ai.w);
                        }
                    } else {
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        fp.this.I(anonymousClass22.Code);
                    }
                    fp.this.r();
                }
            });
        }
    }

    /* JADX INFO: renamed from: com.huawei.hms.ads.fp$4, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass4 implements Runnable {
        final /* synthetic */ AdSlotParam Code;
        final /* synthetic */ boolean I;
        final /* synthetic */ SplashAdReqParam V;

        /* JADX INFO: renamed from: com.huawei.hms.ads.fp$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: SearchBox */
        public class AnonymousClass1 implements RemoteCallResultCallback<String> {

            /* JADX INFO: renamed from: com.huawei.hms.ads.fp$4$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SearchBox */
            public class RunnableC04191 implements Runnable {
                final /* synthetic */ long Code;
                final /* synthetic */ CallResult V;

                public RunnableC04191(long j, CallResult callResult) {
                    this.Code = j;
                    this.V = callResult;
                }

                @Override // java.lang.Runnable
                public void run() {
                    fp.this.f6563a.D(com.huawei.openalliance.ad.utils.z.Code() - this.Code);
                    fp.this.d = (String) this.V.getData();
                    AdContentData adContentData = (AdContentData) com.huawei.openalliance.ad.utils.ad.V((String) this.V.getData(), AdContentData.class, new Class[0]);
                    if (adContentData != null) {
                        fp.this.y = adContentData.M();
                    }
                    if (adContentData == null) {
                        com.huawei.openalliance.ad.ipc.g.V(fp.this.e).Code("getSpareSplashAd", String.valueOf(fp.this.C.Z()), new RemoteCallResultCallback<String>() { // from class: com.huawei.hms.ads.fp.4.1.1.1
                            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                            public void onRemoteCallResult(String str, final CallResult<String> callResult) {
                                com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fp.4.1.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        fp.this.d = (String) callResult.getData();
                                        AdContentData adContentData2 = (AdContentData) com.huawei.openalliance.ad.utils.ad.V((String) callResult.getData(), AdContentData.class, new Class[0]);
                                        if (adContentData2 != null) {
                                            AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                            fp.this.Code(adContentData2, com.huawei.openalliance.ad.constant.ai.u, anonymousClass4.I);
                                        } else {
                                            AnonymousClass4 anonymousClass42 = AnonymousClass4.this;
                                            fp.this.Code((AdContentData) null, anonymousClass42.I);
                                        }
                                    }
                                });
                            }
                        }, String.class);
                        return;
                    }
                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                    fp.this.Code(adContentData, anonymousClass4.I);
                    com.huawei.openalliance.ad.utils.c.Code(fp.this.e, adContentData);
                    jh.Code(fp.this.e).V();
                }
            }

            public AnonymousClass1() {
            }

            @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
            public void onRemoteCallResult(String str, CallResult<String> callResult) {
                fh.V("AdMediator", "onDownloaded");
                fp fpVar = fp.this;
                fpVar.f6563a.Code(fpVar.z, System.currentTimeMillis());
                synchronized (fp.this) {
                    fh.V("AdMediator", "onDownloaded, loadingTimeout:" + fp.this.n);
                    fp fpVar2 = fp.this;
                    if (!fpVar2.S) {
                        fpVar2.S = true;
                    }
                    if (callResult.getCode() != 200) {
                        fp.this.f6563a.V(Integer.valueOf(callResult.getCode()));
                    }
                    if (fp.this.n) {
                        fp.this.f6563a.I(-2);
                        fp.this.q = true;
                    } else {
                        fp.this.n = true;
                        com.huawei.openalliance.ad.utils.bj.Code(fp.this.r);
                        fh.V("AdMediator", "cancel loadTimeoutTask");
                        fp fpVar3 = fp.this;
                        fpVar3.f6563a.Z(fpVar3.z, System.currentTimeMillis());
                        com.huawei.openalliance.ad.utils.bj.Code(new RunnableC04191(com.huawei.openalliance.ad.utils.z.Code(), callResult));
                    }
                    if (fp.this.q) {
                        fp.this.Z((AdContentData) com.huawei.openalliance.ad.utils.ad.V(callResult.getData(), AdContentData.class, new Class[0]));
                    }
                }
            }
        }

        public AnonymousClass4(AdSlotParam adSlotParam, SplashAdReqParam splashAdReqParam, boolean z) {
            this.Code = adSlotParam;
            this.V = splashAdReqParam;
            this.I = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = fp.this.e;
            if (context == null) {
                return;
            }
            je.Code(context, com.huawei.openalliance.ad.constant.x.cr, this.Code, com.huawei.openalliance.ad.utils.ad.V(this.V), new AnonymousClass1(), String.class);
        }
    }

    /* JADX INFO: renamed from: com.huawei.hms.ads.fp$5, reason: invalid class name */
    /* JADX INFO: compiled from: SearchBox */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (fp.this) {
                fh.V("AdMediator", "on load task timeout, loadingTimeout: %s", Boolean.valueOf(fp.this.n));
                if (!fp.this.n) {
                    fp.this.n = true;
                    com.huawei.openalliance.ad.ipc.g.V(fp.this.e).Code("getSpareSplashAd", String.valueOf(fp.this.C.Z()), new RemoteCallResultCallback<AdContentData>() { // from class: com.huawei.hms.ads.fp.5.1
                        @Override // com.huawei.openalliance.ad.ipc.RemoteCallResultCallback
                        public void onRemoteCallResult(String str, final CallResult<AdContentData> callResult) {
                            com.huawei.openalliance.ad.utils.bj.Code(new Runnable() { // from class: com.huawei.hms.ads.fp.5.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AdContentData adContentData = (AdContentData) callResult.getData();
                                    if (adContentData != null) {
                                        fp.this.Code(adContentData, -2, true);
                                    } else {
                                        fp.this.I(-2);
                                        fp.this.g();
                                    }
                                }
                            });
                        }
                    }, AdContentData.class);
                }
            }
        }
    }

    public fp(lt ltVar) {
        this.k = new WeakReference<>(ltVar);
        this.c = ltVar.getAdType();
        Context applicationContext = ltVar.getContext().getApplicationContext();
        this.e = applicationContext;
        this.C = eh.Code(applicationContext);
        t();
    }

    private void t() {
        com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.fp.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    fp fpVar = fp.this;
                    fpVar.K = new jq(fpVar.e);
                    fp.this.K.Code();
                    d dVarV = h.V();
                    if (dVarV != null) {
                        dVarV.Code(fp.this.c, (Bundle) null);
                    }
                } catch (Throwable th) {
                    fh.V("AdMediator", "inform err: %s", th.getClass().getSimpleName());
                }
            }
        });
    }

    private String u() {
        return com.huawei.openalliance.ad.utils.bg.Code(h());
    }

    private void v() {
        long jCode = this.A;
        if (jCode <= 0) {
            jCode = com.huawei.openalliance.ad.utils.z.Code();
        }
        this.B.Z(jCode);
    }

    private void w() {
        CountDownTimer countDownTimer = new CountDownTimer(2000L, 500L) { // from class: com.huawei.hms.ads.fp.7
            @Override // android.os.CountDownTimer
            public void onFinish() {
                fh.V("AdMediator", "onFinish");
                fp fpVar = fp.this;
                if (fpVar.Z != com.huawei.openalliance.ad.constant.b.LOADED) {
                    fpVar.I(-10);
                    fp.this.r();
                }
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j) {
                fh.Code("AdMediator", "onTick = %s", Long.valueOf(j));
            }
        };
        this.x = countDownTimer;
        countDownTimer.start();
    }

    private boolean x() {
        return this.s;
    }

    private String y() {
        AdContentData adContentData;
        if (!this.H || (adContentData = this.B) == null || 3 == adContentData.aF() || this.B.aV() == null) {
            return null;
        }
        return this.B.aV().Code();
    }

    private void z() {
        fh.Code("AdMediator", "onAdEnd");
        try {
            if (this.J) {
                fh.V("AdMediator", "already end");
                return;
            }
            fh.V("AdMediator", "onAdEnd");
            this.J = true;
            jq jqVar = this.K;
            if (jqVar != null) {
                jqVar.V();
            }
            d dVarV = h.V();
            if (dVarV != null) {
                dVarV.V(this.c, (Bundle) null);
            }
        } catch (Throwable th) {
            fh.V("AdMediator", "end err: %s", th.getClass().getSimpleName());
        }
    }

    @Override // com.huawei.hms.ads.ft
    public void C() {
        Code(11, "feedback hasShowFinish", Long.valueOf(this.F));
        lv lvVarI = i();
        if (lvVarI != null) {
            lvVarI.D();
        }
    }

    public abstract void Code(AdContentData adContentData, boolean z);

    public void D() {
        Context context = this.e;
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("resetDisplayDateAndCount", null, null, null);
        }
    }

    @Override // com.huawei.hms.ads.ft
    public void F() {
        this.f6563a.I(this.z, System.currentTimeMillis());
    }

    @Override // com.huawei.hms.ads.ft
    public void L() {
        if (this.u) {
            return;
        }
        this.u = true;
        jk.Code(this.e, this.B);
        hb hbVar = this.j;
        if (hbVar != null) {
            hbVar.L();
        }
    }

    public void S() {
        com.huawei.openalliance.ad.inter.listeners.a aVar = this.v;
        if (aVar != null) {
            aVar.V();
        }
        SplashAdDisplayListener splashAdDisplayListener = this.w;
        if (splashAdDisplayListener != null) {
            splashAdDisplayListener.onAdClick();
        }
        com.huawei.openalliance.ad.utils.bf.V(this.e);
    }

    @Override // com.huawei.hms.ads.ft
    public com.huawei.openalliance.ad.constant.b V() {
        return this.Z;
    }

    public int Z() {
        return this.E;
    }

    @Override // com.huawei.hms.ads.ft
    public void a() {
        fh.V("AdMediator", "notifyAdDismissed");
        if (this.o) {
            fh.V("AdMediator", "ad already dismissed");
            return;
        }
        this.o = true;
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.l;
        if (bVar != null) {
            bVar.V();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.m;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdDismissed();
        }
        SplashListener splashListener = this.g;
        if (splashListener != null) {
            splashListener.onAdDismissed();
        }
        AdContentData adContentData = this.B;
        if (adContentData != null && adContentData.aF() != 3) {
            jn.Code(this.e).Code(this.B, -10);
        }
        lv lvVarI = i();
        if (lvVarI != null) {
            lvVarI.destroyView();
        }
    }

    public AdSlotParam b() {
        lt ltVarH = h();
        if (ltVarH == null) {
            return null;
        }
        AdSlotParam adSlotParam = ltVarH.getAdSlotParam();
        if (adSlotParam != null) {
            this.f6563a.Code(adSlotParam.Code());
        }
        return adSlotParam;
    }

    public void c() {
        AdSlotParam adSlotParamB = b();
        if (adSlotParamB == null) {
            Code((AdContentData) null, true);
        } else {
            Code(adSlotParamB);
            Code(adSlotParamB, d(), true);
        }
    }

    public SplashAdReqParam d() {
        SplashAdReqParam splashAdReqParam = new SplashAdReqParam();
        splashAdReqParam.I(f());
        splashAdReqParam.Code(this.z);
        BaseAdReqParam baseAdReqParamCode = com.huawei.openalliance.ad.utils.c.Code(this.e);
        if (baseAdReqParamCode != null) {
            splashAdReqParam.V(baseAdReqParamCode.I());
            splashAdReqParam.Code(baseAdReqParamCode.V());
        }
        return splashAdReqParam;
    }

    public void e() {
        int iB = this.C.b();
        fh.V("AdMediator", "startAdLoadTimeoutTask - max load time: %d", Integer.valueOf(iB));
        com.huawei.openalliance.ad.utils.bj.Code(new AnonymousClass5(), this.r, iB);
    }

    public abstract String f();

    public void g() {
        a();
    }

    public lt h() {
        return this.k.get();
    }

    public lv i() {
        WeakReference<lv> weakReference = this.I;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.huawei.hms.ads.ft
    public boolean j() {
        return this.B == null;
    }

    @Override // com.huawei.hms.ads.ft
    public AdContentData m() {
        return this.B;
    }

    @Override // com.huawei.hms.ads.ft
    public void n() {
        fh.V("AdMediator", "onDisplayTimeUp hasShowFinish: %s", Boolean.valueOf(this.G));
        if (this.G) {
            return;
        }
        this.G = true;
        com.huawei.openalliance.ad.utils.bf.V(this.e);
        a();
    }

    @Override // com.huawei.hms.ads.ft
    public String o() {
        AdContentData adContentData = this.B;
        if (adContentData != null) {
            return adContentData.aa();
        }
        return null;
    }

    @Override // com.huawei.hms.ads.ft
    public BiddingInfo p() {
        if (this.B == null) {
            return new BiddingInfo();
        }
        BiddingInfo.a aVar = new BiddingInfo.a();
        aVar.Code(this.B.aW()).Code(this.B.aX()).V(this.B.aY()).I(this.B.aZ());
        return aVar.Code();
    }

    private void F(int i) {
        if (this.L != null) {
            Code(this.e, i, this.y, f(), this.L);
            com.huawei.openalliance.ad.inter.listeners.b bVar = this.l;
            if (bVar instanceof com.huawei.openalliance.ad.inter.listeners.m) {
                bVar.Code(-6);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i) {
        if (i == -6) {
            Code(this.e, i, this.y, f(), this.L);
        } else {
            Code(this.e, i, this.y, f(), this.B);
        }
        B(i);
    }

    @Override // com.huawei.hms.ads.ft
    public void B() {
        Code(10, "onWhyThisAd hasShowFinish", Long.valueOf(this.F));
        lv lvVarI = i();
        if (lvVarI != null) {
            lvVarI.F();
        }
    }

    @Override // com.huawei.hms.ads.ft
    public void C(int i) {
        lt ltVarH = h();
        if (ltVarH != null) {
            ltVarH.I(i);
        }
    }

    public com.huawei.openalliance.ad.inter.listeners.b I() {
        return this.l;
    }

    @Override // com.huawei.hms.ads.ft
    public void V(int i) {
        Context context;
        fh.V("AdMediator", "toShowSpare");
        if (!this.B.aq() && (context = this.e) != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("getSpareSplashAd", String.valueOf(this.C.Z()), new AnonymousClass2(i), String.class);
        } else {
            I(i);
            r();
        }
    }

    public void Z(int i) {
        F(i);
    }

    private void C(AdContentData adContentData) {
        if (this.j == null) {
            return;
        }
        if (adContentData != null && adContentData.l() == 9) {
            this.j.Code(ia.Code(0.0f, true, hz.STANDALONE));
        } else if (adContentData != null) {
            if (adContentData.l() == 4 || adContentData.l() == 2) {
                this.j.L();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z(AdContentData adContentData) {
        if (this.S && this.q && this.e != null) {
            fh.V("AdMediator", "reportSplashCostTime");
            this.q = false;
            this.f6563a.Code(f());
            this.f6563a.V(this.z, this.F);
            db.Code(this.e, this.y, this.c, adContentData, this.f6563a);
        }
    }

    public void B(int i) {
        this.q = true;
        this.f6563a.I(i);
        Z(this.B);
    }

    public lv Code(AdContentData adContentData, lt ltVar) {
        if (adContentData == null) {
            return null;
        }
        lv lvVarV = ltVar.V(adContentData.l());
        if (lvVarV == null) {
            return lvVarV;
        }
        lvVarV.setAdContent(adContentData);
        lvVarV.setAdMediator(this);
        int iAr = adContentData.ar() > 0 ? adContentData.ar() : 0;
        if (adContentData.l() == 2 || adContentData.l() == 4) {
            lvVarV.Code((adContentData.as() >= 2000 ? adContentData.as() : this.C.V()) + iAr, 0, 0);
        }
        if (9 == adContentData.l()) {
            lvVarV.Code(0, this.C.I(), iAr);
        }
        Code(lvVarV, adContentData, ltVar);
        return lvVarV;
    }

    @Override // com.huawei.hms.ads.ft
    public void I(int i) {
        fh.V("AdMediator", "ad failed:" + i);
        if (this.p) {
            fh.V("AdMediator", "ad is already failed");
            return;
        }
        this.p = true;
        this.F = System.currentTimeMillis();
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.l;
        if (bVar != null) {
            bVar.Code(i);
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.m;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdFailedToLoad(com.huawei.hms.ads.utils.b.Code(i));
        }
        V(this.B, h());
        com.huawei.openalliance.ad.utils.bf.V(this.e);
        z();
        S(i);
    }

    @Override // com.huawei.hms.ads.ft
    public void V(long j) {
        this.z = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(AdContentData adContentData) {
        if (adContentData == null) {
            return;
        }
        adContentData.n();
        Context context = this.e;
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("updateContentOnAdLoad", com.huawei.openalliance.ad.utils.ad.V(adContentData), null, null);
        }
    }

    private void Z(boolean z) {
        this.s = z;
    }

    @Override // com.huawei.hms.ads.ft
    public void I(AdContentData adContentData) {
        final String string;
        if (adContentData == null) {
            return;
        }
        try {
            if (com.huawei.openalliance.ad.utils.z.I() || com.huawei.openalliance.ad.utils.z.a(this.e)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("content_id", adContentData.a());
                jSONObject.put("templateId", adContentData.aE());
                jSONObject.put("slotid", adContentData.L());
                jSONObject.put("apiVer", adContentData.aF());
                jSONObject.put("unique_id", adContentData.aa());
                string = jSONObject.toString();
            } else {
                string = adContentData.a();
            }
            com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.fp.8
                @Override // java.lang.Runnable
                public void run() {
                    com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.fp.8.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.huawei.openalliance.ad.ipc.g.V(fp.this.e).Code(com.huawei.openalliance.ad.constant.s.r, string, null, null);
                        }
                    });
                }
            });
        } catch (Throwable th) {
            fh.V("AdMediator", "onMaterialLoadFailed err: %s", th.getClass().getSimpleName());
        }
    }

    private void V(AdContentData adContentData, lt ltVar) {
        if (ltVar == null) {
            fh.V("AdMediator", "splashView is null, don't report splash start mode");
            return;
        }
        if (ltVar.S()) {
            db.Code(0, this.z, ltVar.getContext(), this.N, adContentData);
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = M;
            if (j != 0) {
                this.N = jCurrentTimeMillis - j;
            }
            M = jCurrentTimeMillis;
            db.Code(1, this.z, ltVar.getContext(), this.N, adContentData);
        }
        fh.V("AdMediator", "rptSplStaPatten, mode: %s, adStartLoadTime: %s, timeInterval: %s", Boolean.valueOf(ltVar.S()), Long.valueOf(this.z), Long.valueOf(this.N));
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(int i) {
        this.E = i;
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(int i, int i2) {
        lv lvVarI = i();
        if (lvVarI != null) {
            lvVarI.Code(i, i2);
        }
        if (this.G) {
            return;
        }
        this.G = true;
        com.huawei.openalliance.ad.utils.bf.V(this.e);
        jk.Code(this.e, this.B, i, i2, (List<String>) null);
        Code(Long.valueOf(this.F), 3, false);
        a();
    }

    private void Code(int i, int i2, kr krVar, Long l, MaterialClickInfo materialClickInfo, int i3) {
        Code(l, 1, true);
        ji jiVar = new ji();
        jiVar.B(y());
        jk.Code(this.e, this.B, i, i2, krVar.Z(), Integer.valueOf(i3), materialClickInfo, com.huawei.openalliance.ad.utils.b.Code(h()), com.huawei.openalliance.ad.utils.bg.V(h()), jiVar);
        if (this.G) {
            fh.V("AdMediator", "onDoActionSucc hasShowFinish");
            return;
        }
        this.G = true;
        com.huawei.openalliance.ad.utils.bf.V(this.e);
        S();
    }

    private void Code(int i, String str, Long l) {
        Code(l, i, false);
        if (this.G) {
            fh.V("AdMediator", str);
        } else {
            this.G = true;
            com.huawei.openalliance.ad.utils.bf.V(this.e);
        }
    }

    public boolean V(AdContentData adContentData) {
        fh.V("AdMediator", "showAdContent");
        if (this.b != null) {
            fh.V("AdMediator", "set verifyConfig.");
            adContentData.q(this.b.getData());
            adContentData.r(this.b.getUserId());
        }
        this.D = true;
        lt ltVarH = h();
        if (ltVarH == null) {
            return false;
        }
        fh.V("AdMediator", "showAdContent, getTemplateIdV3 = %s", adContentData.aE());
        if (!com.huawei.openalliance.ad.utils.bc.Code(adContentData.aE()) || com.huawei.openalliance.ad.utils.c.Code(this.e, adContentData.aV(), adContentData.L(), 1)) {
            this.H = true;
            if (!(ltVarH instanceof PPSSplashView)) {
                fh.I("AdMediator", "not PPSSplashView");
                return false;
            }
            IRemoteCreator iRemoteCreatorCode = h.Code(this.e);
            if (iRemoteCreatorCode == null) {
                fh.V("AdMediator", "Creator is null");
                return false;
            }
            cl clVar = new cl(ltVarH.getContext(), this, adContentData);
            Bundle bundle = new Bundle();
            bundle.putInt("audioFocusType", ltVarH.getAudioFocusType());
            PPSSplashView pPSSplashView = (PPSSplashView) ltVarH;
            bundle.putInt(bq.f.S, pPSSplashView.getMediaNameResId());
            bundle.putInt(bq.f.C, pPSSplashView.getLogoResId());
            bundle.putString("content", this.d);
            fh.Code("AdMediator", "contentJson : %s", this.d);
            AdSlotParam adSlotParamB = b();
            if (adSlotParamB != null) {
                bundle.putInt(bq.f.V, adSlotParamB.V());
                bundle.putInt(bq.f.B, adSlotParamB.f() != null ? adSlotParamB.f().intValue() : 1);
            }
            try {
                View view = (View) ObjectWrapper.unwrap(iRemoteCreatorCode.newSplashTemplateView(bundle, clVar));
                if (view == null) {
                    fh.I("AdMediator", "templateView is null;");
                    return false;
                }
                this.j = null;
                ltVarH.Code(view);
                iRemoteCreatorCode.bindData(ObjectWrapper.wrap(view), this.d);
                w();
            } catch (Throwable th) {
                fh.I("AdMediator", "create splashTemplateView err: %s", th.getClass().getSimpleName());
                return false;
            }
        } else {
            this.I = null;
            lv lvVarCode = Code(adContentData, ltVarH);
            if (lvVarCode == null) {
                return false;
            }
            hb hbVar = this.j;
            if (hbVar != null) {
                hbVar.Z();
            }
            C(adContentData);
            ltVarH.Code(lvVarCode, ltVarH.V(adContentData));
            lvVarCode.V();
            this.I = new WeakReference<>(lvVarCode);
        }
        return true;
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(long j) {
        this.A = j;
    }

    private void Code(Context context, int i, String str, String str2, AdContentData adContentData) {
        List<String> listCode;
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        if (adContentData == null) {
            adContentData = new AdContentData();
        }
        adContentData.d(this.c);
        analysisEventReport.Code(adContentData);
        fh.V("AdMediator", "reportSplashAdLoadFailedEvent, uniqueId: %s", adContentData.aa());
        analysisEventReport.Code(i);
        analysisEventReport.I(str);
        analysisEventReport.d(adContentData.aE());
        analysisEventReport.e(adContentData.L());
        analysisEventReport.c(adContentData.a());
        analysisEventReport.I(adContentData.aF());
        try {
            analysisEventReport.V(Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            fh.Code("AdMediator", "setShowMode error%s", e.getClass().getSimpleName());
        }
        if (b() != null && (listCode = b().Code()) != null && !listCode.isEmpty()) {
            fh.Code("AdMediator", "setSlotId: %s", listCode.get(0));
            analysisEventReport.Z(listCode.get(0));
        }
        if (context != null) {
            com.huawei.openalliance.ad.ipc.g.V(context).Code("rptSplashFailedEvt", com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(Context context, AdContentData adContentData, int i) {
        if (context == null) {
            return;
        }
        AnalysisEventReport analysisEventReport = new AnalysisEventReport();
        analysisEventReport.Code(adContentData);
        analysisEventReport.Code(i);
        if (adContentData != null) {
            fh.V("AdMediator", "reportStartSpareAdEvent, uniqueId: %s", adContentData.aa());
            analysisEventReport.d(adContentData.aE());
            analysisEventReport.e(adContentData.L());
            analysisEventReport.c(adContentData.a());
            analysisEventReport.I(adContentData.aF());
        }
        com.huawei.openalliance.ad.ipc.g.V(context).Code("rptStartSpareSplashAd", com.huawei.openalliance.ad.utils.ad.V(analysisEventReport), null, null);
    }

    private void Code(lv lvVar, AdContentData adContentData, lt ltVar) {
        if (adContentData == null || lvVar == null || this.j == null) {
            fh.I("AdMediator", "there is no splash ad or adView is null");
            return;
        }
        fh.V("AdMediator", "initOmsdkResource");
        this.j.Code(this.e, adContentData, ltVar, true);
        lvVar.Code(this.j);
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        this.b = rewardVerifyConfig;
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(SplashAdDisplayListener splashAdDisplayListener) {
        this.w = splashAdDisplayListener;
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(SplashView.SplashAdLoadListener splashAdLoadListener) {
        this.m = splashAdLoadListener;
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(SplashListener splashListener) {
        this.g = splashListener;
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(SplashLoadListener splashLoadListener) {
        this.f = splashLoadListener;
    }

    public void Code(AdSlotParam adSlotParam) {
        this.y = com.huawei.openalliance.ad.utils.z.B();
        Context context = this.e;
        adSlotParam.I(context == null ? null : com.huawei.openalliance.ad.inter.g.Code(context).I());
        adSlotParam.V(this.y);
        adSlotParam.Code(this.c);
    }

    public void Code(AdSlotParam adSlotParam, SplashAdReqParam splashAdReqParam, boolean z) {
        com.huawei.openalliance.ad.utils.i.Code(new AnonymousClass4(adSlotParam, splashAdReqParam, z), i.a.SPLASH_NET, false);
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(final AdContentData adContentData) {
        com.huawei.openalliance.ad.utils.i.Code(new Runnable() { // from class: com.huawei.hms.ads.fp.3
            @Override // java.lang.Runnable
            public void run() {
                if (fp.this.H && 3 != adContentData.aF()) {
                    ei.Code(fp.this.e).Code(adContentData.L(), System.currentTimeMillis());
                }
                fp.this.B(adContentData);
            }
        });
        lt ltVarH = h();
        if (ltVarH != null) {
            int iC = adContentData.c();
            ltVarH.Code(adContentData.c(), !this.H);
            ltVarH.B();
            if (!this.H) {
                ltVarH.Code(adContentData, this.C.D());
                ltVarH.Code(jg.C(adContentData.v()), jg.S(adContentData.v()), adContentData.av(), 1 == iC, ltVarH.V(adContentData));
            }
            ltVarH.Code(adContentData);
        }
        this.Z = com.huawei.openalliance.ad.constant.b.LOADED;
        CountDownTimer countDownTimer = this.x;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        fh.V("AdMediator", "ad loaded, render start.");
        this.F = System.currentTimeMillis();
        com.huawei.openalliance.ad.inter.listeners.b bVar = this.l;
        if (bVar != null) {
            bVar.Code();
        }
        SplashView.SplashAdLoadListener splashAdLoadListener = this.m;
        if (splashAdLoadListener != null) {
            splashAdLoadListener.onAdLoaded();
        }
        SplashListener splashListener = this.g;
        if (splashListener != null) {
            splashListener.onAdShowStart();
        }
        v();
        L();
        if (!this.C.m()) {
            Code((Long) null, (Integer) null, (Integer) null, false);
        }
        V(adContentData, ltVarH);
        B(200);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Code(final AdContentData adContentData, final int i, boolean z) {
        if (adContentData != null) {
            fh.V("AdMediator", "use spare ad");
            this.S = true;
            this.y = adContentData.M();
            this.F = System.currentTimeMillis();
            S(i);
            adContentData.S(true);
            com.huawei.openalliance.ad.utils.i.I(new Runnable() { // from class: com.huawei.hms.ads.fp.6
                @Override // java.lang.Runnable
                public void run() {
                    fp fpVar = fp.this;
                    fpVar.Code(fpVar.e, adContentData, i);
                }
            });
            Code(adContentData, z);
        }
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(AdContentData adContentData, long j, int i) {
        String str;
        z();
        if (!this.C.m()) {
            fh.I("AdMediator", "onAdShowEnd - use old adshow event");
            return;
        }
        fh.V("AdMediator", "onAdShowEnd duration: %d showRatio: %d", Long.valueOf(j), Integer.valueOf(i));
        jk.Code(this.e, adContentData, j, i);
        if (adContentData != null) {
            MetaData metaDataS = adContentData.S();
            if (metaDataS != null) {
                if (j < metaDataS.F() || i < metaDataS.D()) {
                    fh.I("AdMediator", "duration or show ratio is invalid for showId %s", adContentData.D());
                    return;
                } else {
                    Code(Long.valueOf(j), Integer.valueOf(i), (Integer) null, false);
                    return;
                }
            }
            str = "onAdShowEnd - metaData is null";
        } else {
            str = "onAdShowEnd - content record is null";
        }
        fh.I("AdMediator", str);
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(com.huawei.openalliance.ad.inter.listeners.a aVar) {
        this.v = aVar;
    }

    @Override // com.huawei.hms.ads.ft
    public void Code(com.huawei.openalliance.ad.inter.listeners.b bVar) {
        this.l = bVar;
    }

    private void Code(Long l, int i, boolean z) {
        Code(l != null ? Long.valueOf(System.currentTimeMillis() - l.longValue()) : null, (Integer) 100, Integer.valueOf(i), z);
    }

    public void Code(Long l, Integer num, Integer num2, boolean z) {
        AdContentData adContentData = this.B;
        boolean zCode = com.huawei.openalliance.ad.utils.c.Code(adContentData != null ? adContentData.V() : null, num2);
        if (x() && (!zCode || Code())) {
            fh.I("AdMediator", "show event already reported before, ignore this");
            return;
        }
        String strU = u();
        AdContentData adContentData2 = this.B;
        if (adContentData2 != null) {
            fh.Code("AdMediator", "slotId: %s, contentId: %s, slot pos: %s", adContentData2.L(), this.B.a(), strU);
        }
        ji.a aVar = new ji.a();
        if (z) {
            aVar.V(Long.valueOf(com.huawei.openalliance.ad.utils.z.Code()));
        }
        if (!com.huawei.openalliance.ad.utils.bc.Code(strU)) {
            aVar.B(strU);
        }
        Object objH = h();
        aVar.Code(l).Code(num).V(num2).V(y()).I(com.huawei.openalliance.ad.utils.b.Code(objH));
        if (objH instanceof View) {
            aVar.Code(ky.Code((View) objH));
        }
        jk.Code(this.e, this.B, aVar.Code());
        if (zCode) {
            Code(true);
        }
        if (x()) {
            return;
        }
        Z(true);
        com.huawei.openalliance.ad.inter.listeners.a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.Code();
        }
        SplashAdDisplayListener splashAdDisplayListener = this.w;
        if (splashAdDisplayListener != null) {
            splashAdDisplayListener.onAdShowed();
        }
        hb hbVar = this.j;
        if (hbVar != null) {
            hbVar.D();
        }
    }

    public void Code(boolean z) {
        this.t = z;
    }

    public boolean Code() {
        return this.t;
    }

    @Override // com.huawei.hms.ads.ft
    public boolean Code(int i, int i2, AdContentData adContentData, Long l, MaterialClickInfo materialClickInfo, int i3) {
        fh.V("AdMediator", "onTouch");
        boolean z = true;
        this.O = true;
        Context context = h() instanceof View ? ((View) h()).getContext() : this.e;
        kr krVarCode = ks.Code(context, adContentData, new HashMap(0));
        if (krVarCode.Code()) {
            if (18 == i3 && (context instanceof Activity)) {
                ((Activity) context).overridePendingTransition(R.anim.hiad_open, R.anim.hiad_close);
            }
            Code(i, i2, krVarCode, l, materialClickInfo, i3);
        } else {
            z = false;
        }
        com.huawei.openalliance.ad.inter.d.Code(this.e).Code(false);
        return z;
    }
}
