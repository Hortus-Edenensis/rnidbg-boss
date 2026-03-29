package com.huawei.hms.ads;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.instreamad.InstreamAd;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.inter.HiAd;
import com.huawei.openalliance.ad.inter.data.AdContentData;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class y extends InstreamAd {
    private Context I;
    private com.huawei.openalliance.ad.inter.data.n V;

    public y(Context context, com.huawei.openalliance.ad.inter.data.h hVar) {
        this.I = context;
        if (hVar instanceof com.huawei.openalliance.ad.inter.data.n) {
            this.V = (com.huawei.openalliance.ad.inter.data.n) hVar;
        }
    }

    private boolean I() {
        return this.V == null;
    }

    public com.huawei.openalliance.ad.inter.data.h Code() {
        return this.V;
    }

    public AdContentData V() {
        if (I()) {
            return null;
        }
        return this.V.q();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getAdSign() {
        return I() ? "2" : this.V.e();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getAdSource() {
        if (I()) {
            return null;
        }
        return this.V.h();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public List<AdvertiserInfo> getAdvertiserInfo() {
        if (I()) {
            return null;
        }
        return this.V.D();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public BiddingInfo getBiddingInfo() {
        return (I() || this.V.ah() == null) ? new BiddingInfo() : this.V.ah();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getCallToAction() {
        if (I()) {
            return null;
        }
        return com.huawei.hms.ads.utils.a.Code(this.I, this.V.E(), this.V.c());
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getDspLogo() {
        if (I()) {
            return null;
        }
        return this.V.T();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getDspName() {
        if (I()) {
            return null;
        }
        return this.V.R();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public long getDuration() {
        com.huawei.openalliance.ad.inter.data.p pVarS;
        if (I() || (pVarS = this.V.S()) == null) {
            return 0L;
        }
        return pVarS.d();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getTransparencyTplUrl() {
        return !I() ? this.V.ac() : "";
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public String getWhyThisAd() {
        if (I()) {
            return null;
        }
        return this.V.l();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean hasAdvertiserInfo() {
        if (I()) {
            return false;
        }
        return this.V.F();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isClicked() {
        if (I()) {
            return false;
        }
        return this.V.Z();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isExpired() {
        if (I()) {
            return true;
        }
        return this.V.k();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isImageAd() {
        if (I()) {
            return false;
        }
        return this.V.I();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isShown() {
        if (I()) {
            return false;
        }
        return this.V.B();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isTransparencyOpen() {
        return (I() || !this.V.ad() || TextUtils.isEmpty(this.V.ac())) ? false : true;
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public boolean isVideoAd() {
        if (I()) {
            return false;
        }
        return this.V.V();
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public void sendBiddingFailed(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, V(), getBiddingInfo().getLurl(), false);
        fh.V("InstreamAdImpl", "sendBiddingFailed result");
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public void sendBiddingSuccess(Map<String, Object> map, ReportUrlListener reportUrlListener) {
        if (getBiddingInfo() == null || HiAd.Code() == null) {
            return;
        }
        HiAd.Code().setReportUrlListener(reportUrlListener);
        HiAd.Code().sendBiddingInfo(map, V(), getBiddingInfo().getNurl(), true);
        fh.V("InstreamAdImpl", "sendBiddingSuccess result");
    }

    @Override // com.huawei.hms.ads.instreamad.InstreamAd
    public void setRewardVerifyConfig(RewardVerifyConfig rewardVerifyConfig) {
        if (I()) {
            return;
        }
        this.V.Code(rewardVerifyConfig);
    }
}
