package com.heytap.msp.mobad.api.ad;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.g.a;
import com.opos.mobad.ad.g.c;
import com.opos.mobad.ad.g.d;
import com.opos.mobad.ad.g.e;
import com.opos.mobad.ad.g.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class CustomSplashAd implements IBidding {
    private static final int INIT_DELAY_TIME = 50;
    private Context mContext;
    private volatile boolean mHasDestroyed = false;
    private final c mListener;
    private String mPosId;
    private a mSplashAdImpl;
    private final SplashAdParams mSplashAdParams;

    public CustomSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = new SplashAdListenerWrapper(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, null);
    }

    private e getISkipView() {
        List<View> list;
        SplashAdParams splashAdParams = this.mSplashAdParams;
        if (splashAdParams.splashSkipView == null || (list = splashAdParams.clickViews) == null || list.size() <= 0) {
            return null;
        }
        return new e() { // from class: com.heytap.msp.mobad.api.ad.CustomSplashAd.3
            @Override // com.opos.mobad.ad.g.e
            public List<View> getSkipClickViews() {
                return CustomSplashAd.this.mSplashAdParams.clickViews;
            }

            @Override // com.opos.mobad.ad.g.e
            public View getSplashSkipView() {
                return CustomSplashAd.this.mSplashAdParams.splashSkipView;
            }

            @Override // com.opos.mobad.ad.g.e
            public void onSkipCountDown(int i) {
                CustomSplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i);
            }
        };
    }

    private d getISplashBottomArea(final View view) {
        if (view != null) {
            return new d() { // from class: com.heytap.msp.mobad.api.ad.CustomSplashAd.2
                @Override // com.opos.mobad.ad.g.d
                public View getAppLogoView() {
                    return view;
                }
            };
        }
        return null;
    }

    private void initAndLoad(Context context, String str, SplashAdParams splashAdParams, final String str2) {
        this.mContext = context;
        this.mPosId = str;
        View view = splashAdParams.bottomArea;
        if (view != null && view.getParent() != null) {
            this.mListener.onAdFailed(10502, "The bottomArea view already has a parent..please not attachToRoot");
        } else if (initImplIfNeed()) {
            loadAdInter(str2);
        } else {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.heytap.msp.mobad.api.ad.CustomSplashAd.1
                @Override // java.lang.Runnable
                public void run() {
                    if (CustomSplashAd.this.mHasDestroyed) {
                        return;
                    }
                    if (CustomSplashAd.this.initImplIfNeed()) {
                        CustomSplashAd.this.loadAdInter(str2);
                    } else {
                        CustomSplashAd.this.mListener.onAdFailed(-1, "inter ad create fail");
                    }
                }
            }, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initImplIfNeed() {
        if (this.mSplashAdImpl != null) {
            return true;
        }
        if (this.mContext == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mSplashAdImpl != null) {
                return true;
            }
            a aVarA = ProxyManager.getInstance().a(this.mContext, this.mPosId, this.mListener, new f.a(this.mContext).a(getISplashBottomArea(this.mSplashAdParams.bottomArea)).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(true).a(getISkipView()).d(false).a());
            this.mSplashAdImpl = aVarA;
            return aVarA != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadAdInter(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout, arrayList);
    }

    public void destroyAd() {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.b();
        }
        this.mHasDestroyed = true;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            return aVar.f();
        }
        return 0;
    }

    public View getSplashView() {
        a aVar = this.mSplashAdImpl;
        if (aVar == null) {
            return null;
        }
        return aVar.g();
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.c(i);
        }
    }

    public CustomSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams, String str2) throws NullPointerException {
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null || TextUtils.isEmpty(str2)) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams or token is null.");
        }
        this.mListener = new SplashAdListenerWrapper(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, str2);
    }

    /* JADX INFO: compiled from: SearchBox */
    public class SplashAdListenerWrapper implements c {
        private IHotSplashListener mApiListener;

        public SplashAdListenerWrapper(IHotSplashListener iHotSplashListener) {
            this.mApiListener = iHotSplashListener;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdDismissed();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdShow(str);
            }
        }

        public void onZoomOut() {
        }

        public void onZoomOutPlayFinish() {
        }
    }
}
