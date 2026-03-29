package com.huawei.hms.ads;

import com.huawei.hms.ads.nativead.NativeAd;
import com.huawei.hms.ads.nativead.NativeAdConfiguration;
import com.huawei.openalliance.ad.inter.data.VideoInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class cc {
    private NativeAd Code;
    private VideoInfo I;
    private VideoConfiguration V;

    public cc(NativeAd nativeAd) {
        NativeAdConfiguration nativeAdConfigurationAt;
        this.Code = nativeAd;
        if (nativeAd instanceof cb) {
            cb cbVar = (cb) nativeAd;
            this.I = cbVar.Code().C();
            com.huawei.openalliance.ad.inter.data.l lVarCode = cbVar.Code();
            if (!(lVarCode instanceof com.huawei.openalliance.ad.inter.data.l) || (nativeAdConfigurationAt = lVarCode.at()) == null) {
                return;
            }
            this.V = nativeAdConfigurationAt.getVideoConfiguration();
        }
    }

    public boolean Code() {
        return this.I != null;
    }

    public float I() {
        Float fG;
        VideoInfo videoInfo = this.I;
        if (videoInfo == null || (fG = videoInfo.g()) == null) {
            return 0.0f;
        }
        return fG.floatValue();
    }

    public boolean V() {
        VideoInfo videoInfo = this.I;
        return videoInfo != null && "n".equals(videoInfo.a());
    }

    public boolean Z() {
        VideoConfiguration videoConfiguration = this.V;
        return videoConfiguration != null && videoConfiguration.isCustomizeOperateRequested();
    }
}
