package com.huawei.hms.ads;

import com.huawei.hms.ads.annotation.AllApi;
import com.huawei.openalliance.ad.annotations.DataKeep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes8.dex */
@DataKeep
@AllApi
public class BiddingInfo {
    private String cur;
    private String lurl;
    private String nurl;

    @com.huawei.openalliance.ad.annotations.a
    private Float price;

    /* JADX INFO: compiled from: SearchBox */
    public static final class a {
        private String Code;
        private String I;

        @com.huawei.openalliance.ad.annotations.a
        private Float V;
        private String Z;

        public a Code(Float f) {
            this.V = f;
            return this;
        }

        public a I(String str) {
            this.Z = str;
            return this;
        }

        public a V(String str) {
            this.I = str;
            return this;
        }

        public String toString() {
            return "BiddingInfo{cur = " + this.Code + ", nurl = '" + this.I + ", lurl = " + this.Z + '}';
        }

        public a Code(String str) {
            this.Code = str;
            return this;
        }

        public BiddingInfo Code() {
            return new BiddingInfo(this);
        }
    }

    @AllApi
    public BiddingInfo() {
    }

    @AllApi
    public BiddingInfo(a aVar) {
        if (aVar != null) {
            this.cur = aVar.Code;
            this.price = aVar.V;
            this.nurl = aVar.I;
            this.lurl = aVar.Z;
        }
    }

    public boolean Code() {
        return getPrice() == null && getCur() == null && getNurl() == null && getLurl() == null;
    }

    @AllApi
    public String getCur() {
        return this.cur;
    }

    @AllApi
    public String getLurl() {
        return this.lurl;
    }

    @AllApi
    public String getNurl() {
        return this.nurl;
    }

    @AllApi
    public Float getPrice() {
        return this.price;
    }

    public String toString() {
        return "BiddingInfo{cur = " + this.cur + ", nurl = " + this.nurl + ", lurl = " + this.lurl + '}';
    }
}
