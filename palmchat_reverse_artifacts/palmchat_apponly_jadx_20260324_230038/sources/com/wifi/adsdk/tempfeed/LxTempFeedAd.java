package com.wifi.adsdk.tempfeed;

import android.content.Context;
import android.view.View;
import com.wifi.adsdk.entity.LxAdAbsItem;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.listener.LxTempFeedShowListener;
import com.wifi.adsdk.params.LxAdReqParams;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxTempFeedAd extends LxAdAbsItem {
    private LxTempFeedView feedView;
    private Context mContext;
    private LxTempFeedShowListener showListener;

    public LxTempFeedAd(Context context) {
        this.mContext = context;
    }

    private void showFail(int i, String str) {
        LxTempFeedShowListener lxTempFeedShowListener = this.showListener;
        if (lxTempFeedShowListener != null) {
            lxTempFeedShowListener.onRenderFail(i, str);
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

    @Override // com.wifi.adsdk.entity.LxAdAbsItem, com.wifi.adsdk.render.ILxAdItem
    public View getExpressView(Context context) {
        return this.feedView;
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
        LxTempFeedView lxTempFeedView = new LxTempFeedView(this.mContext, lxAdBeanData, lxAdReqParams);
        this.feedView = lxTempFeedView;
        setLxAdBaseView(lxTempFeedView);
    }

    public void setShowListener(LxTempFeedShowListener lxTempFeedShowListener) {
        this.showListener = lxTempFeedShowListener;
        LxTempFeedView lxTempFeedView = this.feedView;
        if (lxTempFeedView != null) {
            lxTempFeedView.setShowListener(lxTempFeedShowListener);
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem, com.wifi.adsdk.render.IRender
    public void showTempAd() {
        toShowEvent();
        LxTempFeedView lxTempFeedView = this.feedView;
        if (lxTempFeedView != null) {
            lxTempFeedView.adShow();
        } else {
            showFail(10001, "feedView is null");
        }
    }
}
