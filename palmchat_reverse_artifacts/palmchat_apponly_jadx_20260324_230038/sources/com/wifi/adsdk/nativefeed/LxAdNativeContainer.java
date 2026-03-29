package com.wifi.adsdk.nativefeed;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.wifi.adsdk.AdAllInitConfig;
import com.wifi.adsdk.entity.LxAdBaseView;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.listener.LxNativeDownListener;
import com.wifi.adsdk.listener.LxNativeFeedShowListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.LxAdLog;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxAdNativeContainer extends LxAdBaseView {
    private boolean adDestroy;
    private int adShowDelay;

    public LxAdNativeContainer(Context context, LxAdBeanData lxAdBeanData, LxAdReqParams lxAdReqParams) {
        super(context, lxAdBeanData, lxAdReqParams);
        this.adShowDelay = -1;
        this.adDestroy = false;
    }

    private int getAdShowConfig() {
        LxAdBeanData lxAdBeanData = this.mAdItem;
        if (lxAdBeanData == null || TextUtils.isEmpty(lxAdBeanData.getApiId())) {
            return 0;
        }
        return AdAllInitConfig.getNativeDelayPp(this.mAdItem.getApiId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startDelayTimeCheck() {
        if (this.adDestroy || this.isShowAd) {
            return;
        }
        postDelayed(new Runnable() { // from class: com.wifi.adsdk.nativefeed.LxAdNativeContainer.1
            /* JADX WARN: Removed duplicated region for block: B:11:0x0059  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                boolean z;
                Rect rect = new Rect();
                if (!LxAdNativeContainer.this.getGlobalVisibleRect(rect) || rect.height() <= 0 || LxAdNativeContainer.this.getMeasuredHeight() <= 0) {
                    z = false;
                } else {
                    final float fHeight = (rect.height() * 100.0f) / LxAdNativeContainer.this.getMeasuredHeight();
                    LxAdLog.d("showEventReplace native scaleHeight " + fHeight);
                    if (fHeight >= LxAdNativeContainer.this.adShowDelay) {
                        LxAdNativeContainer.this.mainHandler.post(new Runnable() { // from class: com.wifi.adsdk.nativefeed.LxAdNativeContainer.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                LxAdNativeContainer.this.showEventReplace("信息流自渲染广告adShowDelay满足：" + LxAdNativeContainer.this.adShowDelay + " scaleHeight " + fHeight);
                            }
                        });
                        z = true;
                    }
                }
                if (z) {
                    return;
                }
                LxAdNativeContainer.this.startDelayTimeCheck();
            }
        }, 100L);
    }

    public void feedAdClick(String str, int i) {
        LxAdLog.d("LxAdNativeContainer feedAdClick ");
        clickEventReplace(str, i);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.srcWidth = getWidth();
            this.srcHeight = getHeight();
            LxAdLog.d("LxAdNativeContainer onLayout srcWidth " + this.srcWidth + " srcHeight " + this.srcHeight);
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void readyToShowEvent() {
        if (this.adShowDelay == -1) {
            int adShowConfig = getAdShowConfig();
            this.adShowDelay = adShowConfig;
            if (adShowConfig == 0) {
                showEventReplace("信息流自渲染adShowDelay为0正常展示");
            } else {
                startDelayTimeCheck();
            }
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdBaseView
    public void sensorClick() {
        boolean localVisibleRect = getLocalVisibleRect(new Rect());
        LxAdLog.d("LxAdSensorUtil LxAdNativeContainer sensorClick result " + localVisibleRect);
        if (localVisibleRect) {
            clickEventReplace("2", 3);
        }
    }

    public void setDownLoadListener(LxNativeDownListener lxNativeDownListener) {
        this.nativeDownListener = lxNativeDownListener;
    }

    public void setShowListener(LxNativeFeedShowListener lxNativeFeedShowListener) {
        this.showListener = lxNativeFeedShowListener;
    }
}
