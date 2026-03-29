package com.huawei.openalliance.ad.inter.data;

import com.huawei.hms.ads.AdvertiserInfo;
import com.huawei.openalliance.ad.beans.metadata.MediaFile;
import com.huawei.openalliance.ad.beans.metadata.MetaData;
import com.huawei.openalliance.ad.constant.bi;
import com.huawei.openalliance.ad.utils.ag;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
public class n extends c implements h, Comparable {
    private p B;
    private boolean F;
    private boolean S;
    private boolean V;

    public n(AdContentData adContentData) {
        super(adContentData);
        this.V = false;
        this.S = false;
        this.F = false;
    }

    public boolean B() {
        return this.S;
    }

    public int C() {
        AdContentData adContentData = this.I;
        if (adContentData != null) {
            return adContentData.K();
        }
        return 0;
    }

    public String Code() {
        MetaData metaDataI_ = i_();
        if (metaDataI_ != null) {
            return metaDataI_.a();
        }
        return null;
    }

    public List<AdvertiserInfo> D() {
        if (this.I == null || !F()) {
            return null;
        }
        return this.I.aL();
    }

    public boolean F() {
        if (this.I != null) {
            return !ag.Code(r0.aL());
        }
        return false;
    }

    public void I(boolean z) {
        this.F = z;
    }

    public boolean L() {
        return this.F;
    }

    @Override // com.huawei.openalliance.ad.inter.data.h
    public p S() {
        MetaData metaDataI_;
        MediaFile mediaFileH;
        if (this.B == null && (metaDataI_ = i_()) != null && (mediaFileH = metaDataI_.h()) != null) {
            this.B = new p(mediaFileH, metaDataI_.k());
        }
        return this.B;
    }

    public boolean V() {
        p pVar = this.B;
        return pVar != null && "video/mp4".equals(pVar.b());
    }

    public boolean Z() {
        return this.V;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return ((obj instanceof n) && ((n) obj).C() <= C()) ? 1 : -1;
    }

    public void Code(boolean z) {
        this.V = z;
    }

    public boolean I() {
        p pVar = this.B;
        return pVar != null && ("image/jpeg".equals(pVar.b()) || bi.B.equals(this.B.b()) || bi.I.equals(this.B.b()) || "image/png".equals(this.B.b()));
    }
}
