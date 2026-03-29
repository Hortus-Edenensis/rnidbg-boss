package com.huawei.openalliance.ad.beans.inner;

import com.huawei.openalliance.ad.annotations.DataKeep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
public class NativeAdReqParam extends BaseAdReqParam {
    private List<String> cacheContentIds;
    private boolean enableDirectCacheVideo;
    private boolean enableDirectReturnVideoAd;
    private boolean enableVideoDownloadInMobileNetwork;
    private String extraInfo;
    private int linkedVideoMode = 0;

    public void Code(List<String> list) {
        this.cacheContentIds = list;
    }

    public void I(String str) {
        this.extraInfo = str;
    }

    public void V(boolean z) {
        this.enableDirectReturnVideoAd = z;
    }

    public void Code(boolean z) {
        this.enableVideoDownloadInMobileNetwork = z;
    }

    public void I(boolean z) {
        this.enableDirectCacheVideo = z;
    }
}
