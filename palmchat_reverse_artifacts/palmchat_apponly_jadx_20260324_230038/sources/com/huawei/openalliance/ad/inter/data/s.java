package com.huawei.openalliance.ad.inter.data;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.ads.BiddingInfo;
import com.huawei.hms.ads.ReportUrlListener;
import com.huawei.hms.ads.fh;
import com.huawei.hms.ads.jg;
import com.huawei.hms.ads.reward.RewardVerifyConfig;
import com.huawei.openalliance.ad.beans.metadata.AdSource;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.beans.metadata.PromoteInfo;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.z;
import java.util.Map;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class s implements j {
    private static final String Code = "UnifyAd";
    private MetaData I;
    private AdContentData V;
    private AppInfo Z;

    public s(AdContentData adContentData) {
        this.V = adContentData;
        this.I = adContentData.S();
    }

    @Override // com.huawei.openalliance.ad.inter.data.j
    public int Code() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0;
        }
        return adContentData.Z();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public AppInfo E() {
        AppInfo appInfo = this.Z;
        if (appInfo != null) {
            return appInfo;
        }
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        AppInfo appInfoY = adContentData.y();
        this.Z = appInfoY;
        return appInfoY;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean H() {
        boolean Z = jg.Z(V());
        if (!Z) {
            fh.V(Code, "native ad is not in whiteList, api call event report is not allowed.");
        }
        return Z;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int J() {
        return jg.a(V());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public RewardVerifyConfig P() {
        if (this.V == null) {
            return null;
        }
        RewardVerifyConfig.Builder builder = new RewardVerifyConfig.Builder();
        builder.setData(this.V.at());
        builder.setUserId(this.V.au());
        return builder.build();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String R() {
        AdSource adSourceCode;
        MetaData metaData = this.I;
        if (metaData == null || (adSourceCode = AdSource.Code(metaData.l())) == null) {
            return null;
        }
        return bc.V(adSourceCode.Code());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String T() {
        AdSource adSourceCode;
        MetaData metaData = this.I;
        if (metaData == null || (adSourceCode = AdSource.Code(metaData.l())) == null) {
            return null;
        }
        return bc.V(adSourceCode.V());
    }

    public String V() {
        AdContentData adContentData = this.V;
        if (adContentData != null) {
            return adContentData.v();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String W() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aG();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String X() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.aH();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int Y() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0;
        }
        return adContentData.aN();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean aa() {
        MetaData metaData = this.I;
        if (metaData == null) {
            return false;
        }
        return metaData.o();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String ac() {
        AdContentData adContentData = this.V;
        return adContentData != null ? adContentData.aP() : "";
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean ad() {
        AdContentData adContentData = this.V;
        return (adContentData == null || !adContentData.aQ() || TextUtils.isEmpty(this.V.aP())) ? false : true;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public PromoteInfo ag() {
        AdContentData adContentData = this.V;
        if (adContentData != null) {
            return adContentData.z();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public BiddingInfo ah() {
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String c() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return bc.V(metaData.Code());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String d() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.a();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String e() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.g();
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int f() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0;
        }
        return adContentData.l();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String g() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.b();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String h() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return bc.V(metaData.L());
        }
        return null;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long i() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0L;
        }
        return adContentData.e();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long j() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return 0L;
        }
        return adContentData.d();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public boolean k() {
        AdContentData adContentData = this.V;
        return adContentData == null || adContentData.d() < System.currentTimeMillis();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String l() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.ac();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String m() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.ad();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String n() {
        AdContentData adContentData = this.V;
        if (adContentData == null) {
            return null;
        }
        return adContentData.ae();
    }

    @Override // com.huawei.openalliance.ad.inter.data.j, com.huawei.openalliance.ad.inter.data.d
    public AdContentData q() {
        return this.V;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public String r() {
        return this.V.L();
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public long x() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.F();
        }
        return 500L;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public int y() {
        MetaData metaData = this.I;
        if (metaData != null) {
            return metaData.D();
        }
        return 50;
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(Context context) {
        if (this.V == null) {
            return;
        }
        V(context);
    }

    public void V(Context context) {
        if (context == null) {
            fh.I(Code, "context is null not call gotoWhyThisAdPage method");
        } else {
            z.Code(context, this.V);
        }
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(RewardVerifyConfig rewardVerifyConfig) {
        AdContentData adContentData = this.V;
        if (adContentData == null || rewardVerifyConfig == null) {
            return;
        }
        adContentData.q(rewardVerifyConfig.getData());
        this.V.r(rewardVerifyConfig.getUserId());
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void V(Map<String, Object> map, ReportUrlListener reportUrlListener) {
    }

    @Override // com.huawei.openalliance.ad.inter.data.d
    public void Code(Map<String, Object> map, ReportUrlListener reportUrlListener) {
    }
}
