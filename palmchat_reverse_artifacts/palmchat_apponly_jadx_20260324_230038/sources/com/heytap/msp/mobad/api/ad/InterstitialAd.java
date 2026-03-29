package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.IInterstitialAdListener;
import com.heytap.msp.mobad.api.params.InterstitialParams;
import com.opos.mobad.ad.d.a;
import com.opos.mobad.ad.d.b;
import com.opos.mobad.ad.d.e;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class InterstitialAd implements IBidding {
    private static final String TAG = "InterstitialAd";
    private Activity mActivity;
    private volatile a mInterstitialAdImpl;
    private InterstitialAdListenerWrapper mListenerWrapper;
    protected InterstitialParams mParams;
    protected String mPosId;

    /* JADX INFO: compiled from: SearchBox */
    public static class InterstitialAdListenerWrapper implements b {
        private IInterstitialAdListener mApiListner;

        public InterstitialAdListenerWrapper(IInterstitialAdListener iInterstitialAdListener) {
            this.mApiListner = iInterstitialAdListener;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            IInterstitialAdListener iInterstitialAdListener = this.mApiListner;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            IInterstitialAdListener iInterstitialAdListener = this.mApiListner;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdClose();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            IInterstitialAdListener iInterstitialAdListener = this.mApiListner;
            if (iInterstitialAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iInterstitialAdListener.onAdFailed(sb.toString());
            }
            IInterstitialAdListener iInterstitialAdListener2 = this.mApiListner;
            if (iInterstitialAdListener2 != null) {
                iInterstitialAdListener2.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            IInterstitialAdListener iInterstitialAdListener = this.mApiListner;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            IInterstitialAdListener iInterstitialAdListener = this.mApiListner;
            if (iInterstitialAdListener != null) {
                iInterstitialAdListener.onAdShow();
            }
        }
    }

    public InterstitialAd(Activity activity, String str) {
        this(activity, str, null);
    }

    private boolean initImplIfNeed() {
        if (this.mInterstitialAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        synchronized (this) {
            if (this.mInterstitialAdImpl != null) {
                return true;
            }
            e.b bVar = e.b.NORMAL;
            InterstitialParams interstitialParams = this.mParams;
            if (interstitialParams != null && interstitialParams.interstitialScene == InterstitialParams.InterstitialScene.INSTANT_EXIT) {
                bVar = e.b.INSTANT_EXIT;
            }
            this.mInterstitialAdImpl = ProxyManager.getInstance().a(this.mActivity, this.mPosId, new e.a().a(bVar).a(), this.mListenerWrapper);
            return this.mInterstitialAdImpl != null;
        }
    }

    public void destroyAd() {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.b();
        }
        this.mActivity = null;
        this.mPosId = null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        if (this.mInterstitialAdImpl != null) {
            return this.mInterstitialAdImpl.f();
        }
        return 0;
    }

    public InterstitialAdListenerWrapper getListenerWrapper() {
        return new InterstitialAdListenerWrapper(null);
    }

    public void loadAd() {
        loadInter((List<String>) null);
    }

    public void loadAdWithData(String str) {
        loadInter(str);
    }

    public void loadInter(String str) {
        if (initImplIfNeed()) {
            this.mInterstitialAdImpl.a(str);
        } else {
            this.mListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.b(i);
        }
    }

    public void setAdListener(IInterstitialAdListener iInterstitialAdListener) {
        if (iInterstitialAdListener == null) {
            this.mListenerWrapper.mApiListner = null;
        } else {
            this.mListenerWrapper.mApiListner = iInterstitialAdListener;
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        if (this.mInterstitialAdImpl != null) {
            this.mInterstitialAdImpl.c(i);
        }
    }

    public void showAd() {
        if (initImplIfNeed()) {
            this.mInterstitialAdImpl.a(this.mActivity);
        } else {
            this.mListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    public InterstitialAd(Activity activity, String str, InterstitialParams interstitialParams) {
        this.mListenerWrapper = getListenerWrapper();
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "InterstitialAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mActivity = activity;
        this.mPosId = str;
        this.mParams = interstitialParams;
        initImplIfNeed();
    }

    private void loadInter(List<String> list) {
        if (!initImplIfNeed()) {
            this.mListenerWrapper.onAdFailed(-1, "inter ad create fail");
        } else if (list == null) {
            this.mInterstitialAdImpl.a();
        } else {
            this.mInterstitialAdImpl.a(list);
        }
    }

    public void loadAd(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mListenerWrapper.onAdFailed(10701, "load error, please check you bidIds");
        } else {
            loadInter(Arrays.asList(str));
        }
    }

    public void closePopupWindow() {
    }

    public void showAsPopupWindow() {
    }
}
