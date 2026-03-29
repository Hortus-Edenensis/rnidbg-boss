package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.IInterstitialVideoAdListener;
import com.opos.mobad.ad.d.c;
import com.opos.mobad.ad.d.d;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class InterstitialVideoAd implements IBidding {
    private static final String TAG = "InterstitialVideoAd";
    private Activity mActivity;
    private volatile c mInstance;
    private ListenerWrapper mListener;
    private String mPosId;

    /* JADX INFO: compiled from: SearchBox */
    public static class ListenerWrapper implements d {
        private IInterstitialVideoAdListener mListener;

        public ListenerWrapper(IInterstitialVideoAdListener iInterstitialVideoAdListener) {
            this.mListener = iInterstitialVideoAdListener;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.mListener;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.mListener;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdClose();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.mListener;
            if (iInterstitialVideoAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iInterstitialVideoAdListener.onAdFailed(sb.toString());
                this.mListener.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.mListener;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.mListener;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onAdShow();
            }
        }

        @Override // com.opos.mobad.ad.d.d
        public void onVideoPlayComplete() {
            IInterstitialVideoAdListener iInterstitialVideoAdListener = this.mListener;
            if (iInterstitialVideoAdListener != null) {
                iInterstitialVideoAdListener.onVideoPlayComplete();
            }
        }
    }

    public InterstitialVideoAd(Activity activity, String str, IInterstitialVideoAdListener iInterstitialVideoAdListener) {
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "InterstitialAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        this.mListener = new ListenerWrapper(iInterstitialVideoAdListener);
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mInstance != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mInstance != null) {
                return true;
            }
            this.mInstance = ProxyManager.getInstance().a(this.mActivity, this.mPosId, this.mListener);
            return this.mInstance != null;
        }
    }

    public void destroyAd() {
        if (this.mInstance != null) {
            this.mInstance.b();
        }
        this.mActivity = null;
        this.mPosId = null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mInstance != null) {
            return this.mInstance.f();
        }
        return 0;
    }

    public void loadAd() {
        if (initImplIfNeed()) {
            this.mInstance.a();
            return;
        }
        ListenerWrapper listenerWrapper = this.mListener;
        if (listenerWrapper != null) {
            listenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    public void loadAdWithData(String str) {
        if (initImplIfNeed()) {
            this.mInstance.a(str);
        } else {
            this.mListener.onAdFailed(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        if (this.mInstance != null) {
            this.mInstance.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        if (this.mInstance != null) {
            this.mInstance.b(i);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        if (this.mInstance != null) {
            this.mInstance.c(i);
        }
    }

    public void showAd() {
        if (initImplIfNeed()) {
            this.mInstance.a(this.mActivity);
            return;
        }
        ListenerWrapper listenerWrapper = this.mListener;
        if (listenerWrapper != null) {
            listenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }
}
