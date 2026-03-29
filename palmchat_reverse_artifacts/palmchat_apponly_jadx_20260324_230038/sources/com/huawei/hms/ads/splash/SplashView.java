package com.huawei.hms.ads.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jc;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.parameter.AdSlotParam;
import com.huawei.openalliance.ad.constant.h;
import com.huawei.openalliance.ad.utils.ag;
import com.huawei.openalliance.ad.utils.ai;
import com.huawei.openalliance.ad.views.PPSSplashView;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public class SplashView extends PPSSplashView {
    private SplashAdDisplayListener D;
    private SplashAdLoadListener F;

    @GlobalApi
    public SplashView(Context context) {
        super(context);
    }

    private void F() {
        Integer numF;
        if (isLoading()) {
            SplashAdLoadListener splashAdLoadListener = this.F;
            if (splashAdLoadListener != null) {
                splashAdLoadListener.onAdFailedToLoad(4);
                return;
            }
            return;
        }
        jc splashPresenter = getSplashPresenter();
        if (splashPresenter.V()) {
            AdSlotParam adSlotParam = getAdSlotParam();
            if (!splashPresenter.S() || adSlotParam == null || (numF = adSlotParam.F()) == null || numF.intValue() != 0) {
                if (adSlotParam != null) {
                    ai.Code(getContext().getApplicationContext(), adSlotParam.B());
                }
                getSplashPresenter().Code();
            } else {
                List<String> listCode = adSlotParam.Code();
                splashPresenter.Code(!ag.Code(listCode) ? listCode.get(0) : null, 1);
                splashPresenter.F();
            }
        }
    }

    private void setAdLoadListener(SplashAdLoadListener splashAdLoadListener) {
        this.F = splashAdLoadListener;
        getSplashPresenter().Code(splashAdLoadListener);
        if (getAdMediator() != null) {
            getAdMediator().Code(splashAdLoadListener);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.lt
    public void Code(int i) {
        super.Code(i);
        getAdMediator().Code(this.F);
        getAdMediator().Code(this.D);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.me
    @GlobalApi
    public void destroyView() {
        super.destroyView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public boolean isLoaded() {
        return super.isLoaded();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public boolean isLoading() {
        return super.isLoading();
    }

    @GlobalApi
    public void load(String str, int i, AdParam adParam, SplashAdLoadListener splashAdLoadListener) {
        this.C = System.currentTimeMillis();
        fh.V("SplashView", h.Code);
        setAdLoadListener(splashAdLoadListener);
        AdSlotParam.a aVar = new AdSlotParam.a();
        SplashAd.Code(getContext(), str, i, adParam, aVar);
        super.setAdSlotParam(aVar.S());
        F();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.me
    @GlobalApi
    public void pauseView() {
        super.pauseView();
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView, com.huawei.hms.ads.me
    @GlobalApi
    public void resumeView() {
        super.resumeView();
    }

    @GlobalApi
    public void setAdDisplayListener(SplashAdDisplayListener splashAdDisplayListener) {
        this.D = splashAdDisplayListener;
        if (getAdMediator() != null) {
            getAdMediator().Code(this.D);
        }
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setAudioFocusType(int i) {
        super.setAudioFocusType(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogo(View view) {
        super.setLogo(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogoBitmap(Bitmap bitmap) {
        super.setLogoBitmap(bitmap);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogoResId(int i) {
        super.setLogoResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setMediaNameResId(int i) {
        super.setMediaNameResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setMediaNameString(String str) {
        super.setMediaNameString(str);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        super.setRewardVerifyConfig(rewardVerifyConfig);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setSloganResId(int i) {
        super.setSloganResId(i);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setSloganView(View view) {
        super.setSloganView(view);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setWideSloganResId(int i) {
        super.setWideSloganResId(i);
    }

    @GlobalApi
    public SplashView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.huawei.openalliance.ad.views.PPSSplashView
    @GlobalApi
    public void setLogo(View view, int i) {
        super.setLogo(view, i);
    }

    @GlobalApi
    public SplashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX INFO: compiled from: SearchBox */
    @GlobalApi
    public static abstract class SplashAdLoadListener {
        @GlobalApi
        public void onAdDismissed() {
        }

        @GlobalApi
        public void onAdLoaded() {
        }

        @GlobalApi
        public void onAdFailedToLoad(int i) {
        }
    }
}
