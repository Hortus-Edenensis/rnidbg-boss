package com.wifi.adsdk.splash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.wifi.adsdk.entity.LxAdAbsItem;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.listener.LxSplashShowListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.CommonUtils;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxSplashAd extends LxAdAbsItem {
    private LxAdSplashView adSplashView = null;
    private Context mContext;
    private LxSplashShowListener showListener;

    public LxSplashAd(Context context) {
        this.mContext = context;
    }

    private boolean isVerticalView() {
        int imgHeight = getImgHeight();
        int imgWidth = getImgWidth();
        return (imgHeight == 0 && imgWidth == 0) || imgHeight > imgWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAd(ViewGroup viewGroup) {
        if (this.adSplashView == null) {
            showFail(10002, "adItem is null");
            return;
        }
        try {
            viewGroup.addView(this.adSplashView, new ViewGroup.LayoutParams(-1, -1));
            this.adSplashView.addParentView();
        } catch (Exception e) {
            showFail(10003, "showAd Exception " + e.toString());
        }
    }

    private void showFail(int i, String str) {
        LxSplashShowListener lxSplashShowListener = this.showListener;
        if (lxSplashShowListener != null) {
            lxSplashShowListener.onRenderFail(i, str);
        }
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getBtnText() {
        return null;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public String getDigest() {
        return null;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getInstallPSs() {
        return null;
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem, com.wifi.adsdk.render.ILxAdItem
    public View getVideoView(Context context) {
        return null;
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem
    public void setAdBeanData(LxAdBeanData lxAdBeanData, LxAdReqParams lxAdReqParams) {
        this.adItem = lxAdBeanData;
        this.reqParams = lxAdReqParams;
        LxAdSplashView lxAdSplashView = new LxAdSplashView(this.mContext, lxAdBeanData, lxAdReqParams);
        this.adSplashView = lxAdSplashView;
        setLxAdBaseView(lxAdSplashView);
    }

    public void setShowListener(LxSplashShowListener lxSplashShowListener) {
        this.showListener = lxSplashShowListener;
        LxAdSplashView lxAdSplashView = this.adSplashView;
        if (lxAdSplashView != null) {
            lxAdSplashView.setShowListener(lxSplashShowListener);
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem, com.wifi.adsdk.render.IRender
    public void showSplash(final ViewGroup viewGroup) {
        toShowEvent();
        if (viewGroup == null) {
            showFail(10001, "splash parent is null");
        } else if (CommonUtils.isMainThread()) {
            showAd(viewGroup);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.adsdk.splash.LxSplashAd.1
                @Override // java.lang.Runnable
                public void run() {
                    LxSplashAd.this.showAd(viewGroup);
                }
            });
        }
    }

    public void pauseVideo() {
    }

    public void releaseVideo() {
    }

    public void resumeVideo() {
    }

    public void startVideo() {
    }

    public void stopVideo() {
    }
}
