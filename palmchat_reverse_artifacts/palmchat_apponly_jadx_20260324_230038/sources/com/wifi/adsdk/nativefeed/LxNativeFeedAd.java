package com.wifi.adsdk.nativefeed;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.wifi.ad.core.data.NestAdData;
import com.wifi.ad.core.p001const.WifiNestConst;
import com.wifi.adsdk.entity.LxAdAbsItem;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.listener.LxNativeDownListener;
import com.wifi.adsdk.listener.LxNativeFeedShowListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.CheckDoubleClick;
import com.wifi.adsdk.utils.LxAdLog;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxNativeFeedAd extends LxAdAbsItem {
    public LxAdNativeContainer lxAdNativeContainer;
    private Context mContext;
    private LxNativeFeedShowListener showListener;

    public LxNativeFeedAd(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemClick(int i) {
        LxAdNativeContainer lxAdNativeContainer = this.lxAdNativeContainer;
        if (lxAdNativeContainer != null) {
            lxAdNativeContainer.feedAdClick("0", i);
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem
    public void adRemoveDone() {
        super.adRemoveDone();
        LxAdLog.d("LxNativeFeedAd  adRemoveDone ");
    }

    public void clickFromOther(String str) {
        LxAdLog.d("interactive clickFromOther clickFrom " + str);
        LxAdNativeContainer lxAdNativeContainer = this.lxAdNativeContainer;
        if (lxAdNativeContainer != null) {
            lxAdNativeContainer.feedAdClick(str, 2);
        }
    }

    public LxAdNativeContainer createLxAdNativeContainer(NestAdData nestAdData) {
        View videoView;
        if (this.mContext != null) {
            LxAdNativeContainer lxAdNativeContainer = this.lxAdNativeContainer;
            if (lxAdNativeContainer != null) {
                lxAdNativeContainer.adDestroy();
                this.lxAdNativeContainer = null;
            }
            this.lxAdNativeContainer = new LxAdNativeContainer(this.mContext, this.adItem, this.reqParams);
            LxAdLog.d("LxNativeFeedAd createLxAdNativeContainer lxAdNativeContainer " + this.lxAdNativeContainer);
            setLxAdBaseView(this.lxAdNativeContainer);
            if (nestAdData != null && (videoView = this.lxAdNativeContainer.getVideoView()) != null) {
                videoView.setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.nativefeed.LxNativeFeedAd.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (CheckDoubleClick.isFastDoubleClick()) {
                            return;
                        }
                        LxAdLog.d("getVideoView contentNativeVideoLayout clcik");
                        LxNativeFeedAd.this.lxAdNativeContainer.feedAdClick("0", 4);
                    }
                });
                nestAdData.setAdView(videoView);
            }
        }
        return this.lxAdNativeContainer;
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
        return null;
    }

    @Override // com.wifi.adsdk.render.ILxAdItem
    public List<String> getInstallPSs() {
        return null;
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem, com.wifi.adsdk.render.ILxAdItem
    @Nullable
    public View getVideoView(@NonNull Context context) {
        return super.getVideoView(context);
    }

    public void registerViewAndActionFeedAd(View view, List<View> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setOnClickListener(new View.OnClickListener() { // from class: com.wifi.adsdk.nativefeed.LxNativeFeedAd.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    LxNativeFeedAd.this.itemClick(WifiNestConst.OtherConst.TAG_AD_BUTTON.equals(view2.getTag()) ? 2 : 1);
                }
            });
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem
    public void setAdBeanData(LxAdBeanData lxAdBeanData, LxAdReqParams lxAdReqParams) {
        this.adItem = lxAdBeanData;
        this.reqParams = lxAdReqParams;
    }

    public void setDownLoadListener(LxNativeDownListener lxNativeDownListener) {
        LxAdNativeContainer lxAdNativeContainer = this.lxAdNativeContainer;
        if (lxAdNativeContainer != null) {
            lxAdNativeContainer.setDownLoadListener(lxNativeDownListener);
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem
    public void setShowAct(Activity activity) {
        super.setShowAct(activity);
    }

    public void setShowListener(LxNativeFeedShowListener lxNativeFeedShowListener) {
        this.showListener = lxNativeFeedShowListener;
        LxAdNativeContainer lxAdNativeContainer = this.lxAdNativeContainer;
        if (lxAdNativeContainer != null) {
            lxAdNativeContainer.setShowListener(lxNativeFeedShowListener);
        }
    }
}
