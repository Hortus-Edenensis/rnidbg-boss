package com.huawei.hms.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.reward.OnMetadataChangedListener;
import com.huawei.hms.ads.reward.RewardAdListener;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@GlobalApi
public class InterstitialAd {
    private final ab Code;

    @GlobalApi
    public InterstitialAd(Context context) {
        this.Code = new ab(context);
    }

    private AdContentData Code() {
        if (this.Code.Z() != null) {
            return this.Code.Z().q();
        }
        return null;
    }

    @GlobalApi
    public final String getAdId() {
        return this.Code.V();
    }

    @GlobalApi
    public final AdListener getAdListener() {
        return this.Code.Code();
    }

    @GlobalApi
    public final Bundle getAdMetadata() {
        return this.Code.F();
    }

    @GlobalApi
    public final BiddingInfo getBiddingInfo() {
        return this.Code.L();
    }

    @GlobalApi
    public final boolean isLoaded() {
        return this.Code.I();
    }

    @GlobalApi
    public final boolean isLoading() {
        return this.Code.B();
    }

    @GlobalApi
    public final void loadAd(AdParam adParam) {
        this.Code.Code(adParam);
    }

    @GlobalApi
    public void sendBiddingFailed(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, Code(), getBiddingInfo().getLurl(), false);
        fh.V("InterstitialAd", "sendBiddingFailed result");
    }

    @GlobalApi
    public void sendBiddingSuccess(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, Code(), getBiddingInfo().getNurl(), true);
        fh.V("InterstitialAd", "sendBiddingSuccess result");
    }

    @GlobalApi
    public final void setAdId(String str) {
        this.Code.Code(str);
    }

    @GlobalApi
    public final void setAdListener(AdListener adListener) {
        this.Code.Code(adListener);
    }

    @GlobalApi
    public final void setAdMetadataListener(OnMetadataChangedListener onMetadataChangedListener) {
        this.Code.Code(onMetadataChangedListener);
    }

    @GlobalApi
    public final void setRewardAdListener(RewardAdListener rewardAdListener) {
        this.Code.Code(rewardAdListener);
    }

    @GlobalApi
    public final void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        this.Code.Code(rewardVerifyConfig);
    }

    @GlobalApi
    public final void setVideoConfiguration(VideoConfiguration videoConfiguration) {
        this.Code.Code(videoConfiguration);
    }

    @GlobalApi
    @Deprecated
    public final void show() {
        this.Code.D();
    }

    @GlobalApi
    public final void show(Activity activity) {
        this.Code.Code(activity);
    }
}
