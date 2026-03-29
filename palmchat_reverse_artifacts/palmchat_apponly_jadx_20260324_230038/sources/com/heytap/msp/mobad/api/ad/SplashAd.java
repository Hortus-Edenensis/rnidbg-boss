package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.ISplashAdListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.g.b;
import com.opos.mobad.ad.g.c;
import com.opos.mobad.ad.g.d;
import com.opos.mobad.ad.g.e;
import com.opos.mobad.ad.g.f;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class SplashAd {
    private static final int INIT_DELAY_TIME = 50;
    private static final String TAG = "SplashAd";
    private Activity mActivity;
    private volatile boolean mHasDestroyed = false;
    private SplashAdListenerWrapper mListener;
    private String mPosId;
    private volatile b mSplashAdImpl;
    private SplashAdParams mSplashAdParams;

    public SplashAd(Activity activity, String str, ISplashAdListener iSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        View view;
        if (activity == null || TextUtils.isEmpty(str) || iSplashAdListener == null || splashAdParams == null) {
            Log.e(TAG, "SplashAd Constructor param activity or posId or iSplashAdListener or splashAdParams is null");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        if (splashAdParams != null) {
            this.mSplashAdParams = splashAdParams;
        } else {
            this.mSplashAdParams = new SplashAdParams.Builder().build();
        }
        this.mListener = new SplashAdListenerWrapper(iSplashAdListener);
        if (splashAdParams != null && (view = splashAdParams.bottomArea) != null && view.getParent() != null) {
            this.mListener.onAdFailed(10502, "The bottomArea view already has a parent..please not attachToRoot");
        } else if (initImplIfNeed()) {
            this.mSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
        } else {
            new Handler(activity.getMainLooper()).postDelayed(new Runnable() { // from class: com.heytap.msp.mobad.api.ad.SplashAd.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SplashAd.this.mHasDestroyed) {
                        return;
                    }
                    if (SplashAd.this.initImplIfNeed()) {
                        SplashAd.this.mSplashAdImpl.a((int) SplashAd.this.mSplashAdParams.fetchTimeout);
                    } else {
                        SplashAd.this.mListener.onAdFailed(-1, "inter ad create fail");
                    }
                }
            }, 50L);
        }
    }

    private e getISkipView() {
        List<View> list;
        SplashAdParams splashAdParams = this.mSplashAdParams;
        if (splashAdParams.splashSkipView == null || (list = splashAdParams.clickViews) == null || list.size() <= 0) {
            return null;
        }
        return new e() { // from class: com.heytap.msp.mobad.api.ad.SplashAd.3
            @Override // com.opos.mobad.ad.g.e
            public List<View> getSkipClickViews() {
                return SplashAd.this.mSplashAdParams.clickViews;
            }

            @Override // com.opos.mobad.ad.g.e
            public View getSplashSkipView() {
                return SplashAd.this.mSplashAdParams.splashSkipView;
            }

            @Override // com.opos.mobad.ad.g.e
            public void onSkipCountDown(int i) {
                SplashAd.this.mSplashAdParams.splashSkipView.onSkipCountDown(i);
            }
        };
    }

    private d getISplashBottomArea(final View view) {
        if (view != null) {
            return new d() { // from class: com.heytap.msp.mobad.api.ad.SplashAd.2
                @Override // com.opos.mobad.ad.g.d
                public View getAppLogoView() {
                    return view;
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean initImplIfNeed() {
        if (this.mSplashAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mSplashAdImpl != null) {
                return true;
            }
            this.mSplashAdImpl = ProxyManager.getInstance().b(this.mActivity, this.mPosId, this.mListener, new f.a(this.mActivity).a(getISplashBottomArea(this.mSplashAdParams.bottomArea)).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(true).a(getISkipView()).a());
            return this.mSplashAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mSplashAdImpl != null) {
            this.mSplashAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
        this.mHasDestroyed = true;
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SplashAdListenerWrapper implements c {
        private ISplashAdListener mApiListener;

        public SplashAdListenerWrapper(ISplashAdListener iSplashAdListener) {
            this.mApiListener = iSplashAdListener;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            ISplashAdListener iSplashAdListener = this.mApiListener;
            if (iSplashAdListener != null) {
                iSplashAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            ISplashAdListener iSplashAdListener = this.mApiListener;
            if (iSplashAdListener != null) {
                iSplashAdListener.onAdDismissed();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            ISplashAdListener iSplashAdListener = this.mApiListener;
            if (iSplashAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iSplashAdListener.onAdFailed(sb.toString());
                this.mApiListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            ISplashAdListener iSplashAdListener = this.mApiListener;
            if (iSplashAdListener != null) {
                iSplashAdListener.onAdShow(str);
                this.mApiListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
        }

        public void onZoomOut() {
        }

        public void onZoomOutPlayFinish() {
        }
    }
}
