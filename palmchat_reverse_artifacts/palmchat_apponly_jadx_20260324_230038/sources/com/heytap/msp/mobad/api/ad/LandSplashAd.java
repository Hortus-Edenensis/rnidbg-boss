package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.ISplashAdListener;
import com.heytap.msp.mobad.api.params.SplashAdParams;
import com.opos.mobad.ad.g.b;
import com.opos.mobad.ad.g.c;
import com.opos.mobad.ad.g.f;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class LandSplashAd {
    private static final String TAG = "SplashAd";
    private Activity mActivity;
    private volatile b mLandSplashAdImpl;
    private SplashAdListenerWrapper mListener;
    private String mPosId;
    private SplashAdParams mSplashAdParams;

    public LandSplashAd(Activity activity, String str, ISplashAdListener iSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        this(activity, str, null, iSplashAdListener, splashAdParams);
    }

    private boolean initImplIfNeed() {
        if (this.mLandSplashAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mLandSplashAdImpl != null) {
                return true;
            }
            this.mLandSplashAdImpl = ProxyManager.getInstance().a(this.mActivity, this.mPosId, (c) this.mListener, new f.a(this.mActivity).b(this.mSplashAdParams.desc).a(this.mSplashAdParams.fetchTimeout).a(this.mSplashAdParams.showPreLoadPage).b(this.mSplashAdParams.isUseSurfaceView).a(this.mSplashAdParams.title).c(false).a());
            return this.mLandSplashAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mLandSplashAdImpl != null) {
            this.mLandSplashAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
        this.mSplashAdParams = null;
    }

    public LandSplashAd(Activity activity, String str, String str2, ISplashAdListener iSplashAdListener, SplashAdParams splashAdParams) throws NullPointerException {
        if (activity == null || TextUtils.isEmpty(str) || iSplashAdListener == null || splashAdParams == null) {
            Log.e(TAG, "SplashAd Constructor param activity or posId or iSplashAdListener or splashAdParams is null.");
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
        if (!initImplIfNeed()) {
            this.mListener.onAdFailed(-1, "inter ad create fail");
        } else if (TextUtils.isEmpty(str2)) {
            this.mLandSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout);
        } else {
            this.mLandSplashAdImpl.a((int) this.mSplashAdParams.fetchTimeout, str2);
        }
    }

    /* JADX INFO: compiled from: SearchBox */
    public static class SplashAdListenerWrapper implements c {
        private ISplashAdListener mApiListener;

        public SplashAdListenerWrapper(ISplashAdListener iSplashAdListener) {
            this.mApiListener = iSplashAdListener;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            this.mApiListener.onAdClick();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            this.mApiListener.onAdDismissed();
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            ISplashAdListener iSplashAdListener = this.mApiListener;
            StringBuilder sb = new StringBuilder();
            sb.append("code=");
            sb.append(i);
            sb.append(",msg=");
            sb.append(str != null ? str : "");
            iSplashAdListener.onAdFailed(sb.toString());
            this.mApiListener.onAdFailed(i, str);
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            this.mApiListener.onAdShow(str);
            this.mApiListener.onAdShow();
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
