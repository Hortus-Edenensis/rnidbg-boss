package com.heytap.msp.mobad.api.ad;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.heytap.msp.mobad.api.ProxyManager;
import com.heytap.msp.mobad.api.listener.IBannerAdListener;
import com.opos.mobad.ad.a.b;
import com.opos.mobad.ad.a.c;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class BannerAd implements IBidding {
    private static final String TAG = "BannerAd";
    private Activity mActivity;
    private b mBannerAdImpl;
    private BannerAdListenerWrapper mListenerWrapper;
    private String mPosId;

    /* JADX INFO: compiled from: SearchBox */
    public static class BannerAdListenerWrapper implements c {
        private IBannerAdListener mApiBannerAdListener;

        public BannerAdListenerWrapper(IBannerAdListener iBannerAdListener) {
            this.mApiBannerAdListener = iBannerAdListener;
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdClick(long j) {
            IBannerAdListener iBannerAdListener = this.mApiBannerAdListener;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdClick();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdClose() {
            IBannerAdListener iBannerAdListener = this.mApiBannerAdListener;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdClose();
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdFailed(int i, String str) {
            IBannerAdListener iBannerAdListener = this.mApiBannerAdListener;
            if (iBannerAdListener != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("code=");
                sb.append(i);
                sb.append(",msg=");
                sb.append(str != null ? str : "");
                iBannerAdListener.onAdFailed(sb.toString());
            }
            IBannerAdListener iBannerAdListener2 = this.mApiBannerAdListener;
            if (iBannerAdListener2 != null) {
                iBannerAdListener2.onAdFailed(i, str);
            }
        }

        @Override // com.opos.mobad.ad.b.a
        public void onAdReady() {
            IBannerAdListener iBannerAdListener = this.mApiBannerAdListener;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdReady();
            }
        }

        @Override // com.opos.mobad.ad.m.b
        public void onAdShow(String str) {
            IBannerAdListener iBannerAdListener = this.mApiBannerAdListener;
            if (iBannerAdListener != null) {
                iBannerAdListener.onAdShow();
            }
        }
    }

    public BannerAd(Activity activity, String str) {
        if (activity == null || TextUtils.isEmpty(str)) {
            Log.e(TAG, "BannerAd Constructor param activity and posId can't be null.");
            return;
        }
        this.mListenerWrapper = getListenerWrapper();
        this.mActivity = activity;
        this.mPosId = str;
        initImplIfNeed();
    }

    private boolean initImplIfNeed() {
        if (this.mBannerAdImpl != null) {
            return true;
        }
        if (this.mActivity == null || TextUtils.isEmpty(this.mPosId)) {
            return false;
        }
        b bVarA = ProxyManager.getInstance().a(this.mActivity, this.mPosId, this.mListenerWrapper);
        this.mBannerAdImpl = bVarA;
        return bVarA != null;
    }

    public void destroyAd() {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.b();
        }
        this.mBannerAdImpl = null;
        this.mActivity = null;
        this.mPosId = null;
    }

    public void doBannerSizeChange(int i, int i2) {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    public View getAdView() {
        if (initImplIfNeed()) {
            return this.mBannerAdImpl.g();
        }
        BannerAdListenerWrapper bannerAdListenerWrapper = this.mListenerWrapper;
        if (bannerAdListenerWrapper == null) {
            return null;
        }
        bannerAdListenerWrapper.onAdFailed(-1, "inter ad create fail");
        return null;
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public int getECPM() {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            return bVar.f();
        }
        return 0;
    }

    public BannerAdListenerWrapper getListenerWrapper() {
        return new BannerAdListenerWrapper(null);
    }

    public void loadAd() {
        loadAdInter((List<String>) null);
    }

    public void loadAdInter(String str) {
        if (initImplIfNeed()) {
            this.mBannerAdImpl.a(str);
            return;
        }
        BannerAdListenerWrapper bannerAdListenerWrapper = this.mListenerWrapper;
        if (bannerAdListenerWrapper != null) {
            bannerAdListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    public void loadAdWithData(String str) {
        loadAdInter(str);
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankLoss(int i, String str, int i2) {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.a(i, str, i2);
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void notifyRankWin(int i) {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public void setAdListener(IBannerAdListener iBannerAdListener) {
        BannerAdListenerWrapper bannerAdListenerWrapper = this.mListenerWrapper;
        if (bannerAdListenerWrapper != null) {
            bannerAdListenerWrapper.mApiBannerAdListener = iBannerAdListener;
        }
    }

    @Override // com.heytap.msp.mobad.api.ad.IBidding
    public void setBidECPM(int i) {
        b bVar = this.mBannerAdImpl;
        if (bVar != null) {
            bVar.c(i);
        }
    }

    private void loadAdInter(List<String> list) {
        if (initImplIfNeed()) {
            if (list == null) {
                this.mBannerAdImpl.a();
                return;
            } else {
                this.mBannerAdImpl.a(list);
                return;
            }
        }
        BannerAdListenerWrapper bannerAdListenerWrapper = this.mListenerWrapper;
        if (bannerAdListenerWrapper != null) {
            bannerAdListenerWrapper.onAdFailed(-1, "inter ad create fail");
        }
    }

    public void loadAd(String str) {
        if (!TextUtils.isEmpty(str)) {
            loadAdInter(Arrays.asList(str));
            return;
        }
        BannerAdListenerWrapper bannerAdListenerWrapper = this.mListenerWrapper;
        if (bannerAdListenerWrapper != null) {
            bannerAdListenerWrapper.onAdFailed(10701, "load error, please check you bidIds");
        }
    }
}
