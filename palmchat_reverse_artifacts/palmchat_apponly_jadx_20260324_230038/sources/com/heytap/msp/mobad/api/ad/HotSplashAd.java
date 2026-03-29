package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.IHotSplashListener;
import com.heytap.msp.mobad.api.listener.IZoomOutSplashAdListener;
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
public class HotSplashAd implements IBidding {
    private static final int INIT_DELAY_TIME = 50;
    private static final String TAG = "HotSplashAd";
    private Context mContext;
    private boolean mHadShowed;
    private volatile boolean mHasDestroyed;
    private boolean mIsReady;
    private final c mListener;
    private String mPosId;
    private a mSplashAdImpl;
    private final SplashAdParams mSplashAdParams;

    /* JADX INFO: compiled from: SearchBox */
    public static class SplashAdListenerWrapper implements c {
        private IHotSplashListener mApiListener;
        private HotSplashAd mSplashAd;

        public SplashAdListenerWrapper(IHotSplashListener iHotSplashListener, HotSplashAd hotSplashAd) {
            this.mApiListener = iHotSplashListener;
            this.mSplashAd = hotSplashAd;
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
            this.mSplashAd.mIsReady = true;
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            this.mSplashAd.mHadShowed = true;
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener != null) {
                iHotSplashListener.onAdShow(str);
            }
        }

        public void onZoomOut() {
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener instanceof IZoomOutSplashAdListener) {
                ((IZoomOutSplashAdListener) iHotSplashListener).onZoomOut();
            }
        }

        public void onZoomOutPlayFinish() {
            IHotSplashListener iHotSplashListener = this.mApiListener;
            if (iHotSplashListener instanceof IZoomOutSplashAdListener) {
                ((IZoomOutSplashAdListener) iHotSplashListener).onZoomOutPlayFinish();
            }
        }
    }

    public HotSplashAd(Activity activity, String str, IZoomOutSplashAdListener iZoomOutSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        this((Context) activity, str, (IHotSplashListener) iZoomOutSplashAdListener, splashAdParams);
    }

    private e getISkipView() {
        List<View> list;
        SplashAdParams splashAdParams = this.mSplashAdParams;
        if (splashAdParams.splashSkipView == null || (list = splashAdParams.clickViews) == null || list.size() <= 0) {
            return null;
        }
        return new e() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.6
            @Override // com.opos.mobad.ad.g.e
            public List<View> getSkipClickViews() {
                return HotSplashAd.this.mSplashAdParams.clickViews;
            }

            @Override // com.opos.mobad.ad.g.e
            public View getSplashSkipView() {
                return HotSplashAd.this.mSplashAdParams.splashSkipView;
            }

            @Override // com.opos.mobad.ad.g.e
            public void onSkipCountDown(int i) {
                HotSplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i);
            }
        };
    }

    private d getISplashBottomArea(final View view) {
        if (view != null) {
            return new d() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.5
                @Override // com.opos.mobad.ad.g.d
                public View getAppLogoView() {
                    return view;
                }
            };
        }
        return null;
    }

    private void initAndLoad(Context context, String str, SplashAdParams splashAdParams, final Runnable runnable) {
        this.mContext = context;
        this.mPosId = str;
        View view = splashAdParams.bottomArea;
        if (view != null && view.getParent() != null) {
            this.mListener.onAdFailed(10502, "The bottomArea view already has a parent..please not attachToRoot");
        } else if (initImplIfNeed()) {
            runnable.run();
        } else {
            new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.4
                @Override // java.lang.Runnable
                public void run() {
                    if (HotSplashAd.this.mHasDestroyed) {
                        return;
                    }
                    if (HotSplashAd.this.initImplIfNeed()) {
                        runnable.run();
                    } else {
                        HotSplashAd.this.mListener.onAdFailed(-1, "inter ad create fail");
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
        return -101;
    }

    public SplashAdListenerWrapper getListenerWrapper(IHotSplashListener iHotSplashListener) {
        return new SplashAdListenerWrapper(iHotSplashListener, this);
    }

    public View getZoomOutView() {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            return aVar.j();
        }
        return null;
    }

    public boolean isSupportZoomOut() {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            return aVar.k();
        }
        return false;
    }

    public void loadAdTransport(String str) {
        this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout, str);
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

    public void showAd(Activity activity) {
        c cVar;
        String str;
        a aVar = this.mSplashAdImpl;
        if (aVar == null) {
            cVar = this.mListener;
            str = "inter ad create fail";
        } else if (!this.mIsReady) {
            cVar = this.mListener;
            str = "ad had not ready";
        } else if (!this.mHadShowed) {
            aVar.a(activity);
            return;
        } else {
            cVar = this.mListener;
            str = "splash had showed";
        }
        cVar.onAdFailed(-1, str);
    }

    public void zoomOutAnimationFinish() {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.i();
        }
    }

    public void zoomOutAnimationStart() {
        a aVar = this.mSplashAdImpl;
        if (aVar != null) {
            aVar.h();
        }
    }

    public HotSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams) throws NullPointerException {
        this.mIsReady = false;
        this.mHadShowed = false;
        this.mHasDestroyed = false;
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = getListenerWrapper(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.1
            @Override // java.lang.Runnable
            public void run() {
                HotSplashAd.this.loadAdInter(null);
            }
        });
    }

    public HotSplashAd(Context context, String str, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams, final String str2) throws NullPointerException {
        this.mIsReady = false;
        this.mHadShowed = false;
        this.mHasDestroyed = false;
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null || TextUtils.isEmpty(str2)) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = getListenerWrapper(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.3
            @Override // java.lang.Runnable
            public void run() {
                HotSplashAd.this.loadAdInter(str2);
            }
        });
    }

    public HotSplashAd(Context context, String str, final String str2, IHotSplashListener iHotSplashListener, SplashAdParams splashAdParams) throws NullPointerException {
        this.mIsReady = false;
        this.mHadShowed = false;
        this.mHasDestroyed = false;
        if (context == null || TextUtils.isEmpty(str) || iHotSplashListener == null || splashAdParams == null) {
            throw new NullPointerException("SplashAd Constructor param context or posId or iSplashAdListener or splashAdParams is null.");
        }
        this.mListener = getListenerWrapper(iHotSplashListener);
        this.mSplashAdParams = splashAdParams;
        initAndLoad(context, str, splashAdParams, new Runnable() { // from class: com.heytap.msp.mobad.api.ad.HotSplashAd.2
            @Override // java.lang.Runnable
            public void run() {
                HotSplashAd.this.loadAdTransport(str2);
            }
        });
    }
}
