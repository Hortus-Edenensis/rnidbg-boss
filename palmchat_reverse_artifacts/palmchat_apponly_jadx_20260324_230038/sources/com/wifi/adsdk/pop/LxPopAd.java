package com.wifi.adsdk.pop;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.wifi.adsdk.entity.LxAdAbsItem;
import com.wifi.adsdk.entity.LxAdBeanData;
import com.wifi.adsdk.listener.LxPopShowListener;
import com.wifi.adsdk.params.LxAdReqParams;
import com.wifi.adsdk.utils.CommonUtils;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes10.dex */
public class LxPopAd extends LxAdAbsItem {
    private LxAdPopView adPopView = null;
    private Context mContext;
    private LxPopShowListener showListener;

    public LxPopAd(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAdDialog(Activity activity) {
        new LxPopAdDialog(activity, this.adPopView).show();
    }

    private void showFail(int i, String str) {
        LxPopShowListener lxPopShowListener = this.showListener;
        if (lxPopShowListener != null) {
            lxPopShowListener.onRenderFail(i, str);
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
        LxAdPopView lxAdPopView = new LxAdPopView(this.mContext, lxAdBeanData, lxAdReqParams);
        this.adPopView = lxAdPopView;
        setLxAdBaseView(lxAdPopView);
    }

    public void setShowListener(LxPopShowListener lxPopShowListener) {
        this.showListener = lxPopShowListener;
        LxAdPopView lxAdPopView = this.adPopView;
        if (lxAdPopView != null) {
            lxAdPopView.setShowListener(lxPopShowListener);
        }
    }

    @Override // com.wifi.adsdk.entity.LxAdAbsItem, com.wifi.adsdk.render.IRender
    public void showPopAd(final Activity activity) {
        toShowEvent();
        if (activity == null || activity.isFinishing()) {
            showFail(10001, "activity show error");
        } else if (CommonUtils.isMainThread()) {
            showAdDialog(activity);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.wifi.adsdk.pop.LxPopAd.1
                @Override // java.lang.Runnable
                public void run() {
                    LxPopAd.this.showAdDialog(activity);
                }
            });
        }
    }
}
