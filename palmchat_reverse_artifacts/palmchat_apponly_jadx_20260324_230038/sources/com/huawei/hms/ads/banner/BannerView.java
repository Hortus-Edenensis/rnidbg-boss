package com.huawei.hms.ads.banner;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.huawei.hms.ads.AdListener;
import com.huawei.hms.ads.AdParam;
import com.huawei.hms.ads.BannerAdSize;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.l;
import com.huawei.hms.ads.r;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.views.PPSBannerView;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public class BannerView extends FrameLayout implements IBannerView {
    private static final String Code = "BannerView";
    private r I;
    private PPSBannerView V;

    @GlobalApi
    public BannerView(Context context) {
        super(context);
        Code(context);
    }

    private void Code(Context context) {
        this.V = new PPSBannerView(context);
        addView(this.V, new FrameLayout.LayoutParams(-2, -2));
        this.I = new l(context, this.V);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void destroy() {
        this.V.S();
        this.I.Code();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public String getAdId() {
        return this.I.C();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public AdListener getAdListener() {
        return this.I.S();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public BannerAdSize getBannerAdSize() {
        return this.I.B();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    @Deprecated
    public BiddingInfo getBiddingInfo() {
        r rVar = this.I;
        return (rVar == null || rVar.Z() == null) ? new BiddingInfo() : this.I.Z();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public boolean isLoading() {
        return this.I.F();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void loadAd(AdParam adParam) {
        this.I.Code(adParam);
        this.I.Code(this);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void pause() {
        this.I.V();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void resume() {
        this.I.I();
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setAdId(String str) {
        this.I.Code(str);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setAdListener(AdListener adListener) {
        this.I.Code(adListener);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setBannerAdSize(BannerAdSize bannerAdSize) {
        this.I.Code(bannerAdSize);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setBannerRefresh(long j) {
        this.I.Code(j);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setContentBundle(String str) {
        this.I.V(str);
    }

    @Override // com.huawei.hms.ads.banner.IBannerView
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.I.Code(rewardVerifyConfig);
    }

    @GlobalApi
    public BannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Code(context);
        Code(attributeSet);
    }

    private void Code(AttributeSet attributeSet) {
        String str;
        String str2;
        String str3 = Code;
        fh.Code(str3, "initDefAttr");
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BannerView);
        try {
            if (typedArrayObtainStyledAttributes != null) {
                try {
                    String string = typedArrayObtainStyledAttributes.getString(R.styleable.BannerView_adId);
                    if (string != null && !string.isEmpty()) {
                        this.I.Code(string);
                    }
                    String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.BannerView_bannerSize);
                    if (string2 != null && !string2.isEmpty()) {
                        fh.Code(str3, "AdSize:%s", string2);
                        Code(string2);
                    }
                } catch (RuntimeException e) {
                    str = Code;
                    str2 = "initDefAttr " + e.getClass().getSimpleName();
                    fh.I(str, str2);
                } catch (Throwable th) {
                    str = Code;
                    str2 = "initDefAttr " + th.getClass().getSimpleName();
                    fh.I(str, str2);
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        } catch (Throwable th2) {
            typedArrayObtainStyledAttributes.recycle();
            throw th2;
        }
    }

    @GlobalApi
    public BannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Code(context);
        Code(attributeSet);
    }

    private void Code(String str) {
        r rVar;
        BannerAdSize bannerAdSize;
        str.hashCode();
        switch (str) {
            case "BANNER_SIZE_300_250":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_300_250;
                break;
            case "BANNER_SIZE_320_100":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_320_100;
                break;
            case "BANNER_SIZE_ADVANCED":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_ADVANCED;
                break;
            case "BANNER_SIZE_360_144":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_360_144;
                break;
            case "BANNER_SIZE_160_600":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_160_600;
                break;
            case "BANNER_SIZE_SMART":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_SMART;
                break;
            case "BANNER_SIZE_DYNAMIC":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_DYNAMIC;
                break;
            case "BANNER_SIZE_320_50":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_320_50;
                break;
            case "BANNER_SIZE_360_57":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_360_57;
                break;
            case "BANNER_SIZE_468_60":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_468_60;
                break;
            case "BANNER_SIZE_728_90":
                rVar = this.I;
                bannerAdSize = BannerAdSize.BANNER_SIZE_728_90;
                break;
            default:
                return;
        }
        rVar.Code(bannerAdSize);
    }
}
