package com.zenmen.palmchat.redpacket.data;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class VoucherRedPacketConfig {
    private float availableAmount;
    private float couponAmount;
    private List<CouponList> couponList;
    private int couponMaxNums;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class CouponList {
        private String couponName;
        private int couponType;

        public CouponList(int i, String str) {
            this.couponType = i;
            this.couponName = str;
        }

        public String getCouponName() {
            return this.couponName;
        }

        public int getCouponType() {
            return this.couponType;
        }

        public void setCouponName(String str) {
            this.couponName = str;
        }

        public void setCouponType(int i) {
            this.couponType = i;
        }
    }

    public float getAvailableAmount() {
        return this.availableAmount;
    }

    public float getCouponAmount() {
        return this.couponAmount;
    }

    public List<CouponList> getCouponList() {
        return this.couponList;
    }

    public int getCouponMaxNums() {
        return this.couponMaxNums;
    }

    public void setAvailableAmount(float f) {
        this.availableAmount = f;
    }

    public void setCouponAmount(float f) {
        this.couponAmount = f;
    }

    public void setCouponList(List<CouponList> list) {
        this.couponList = list;
    }

    public void setCouponMaxNums(int i) {
        this.couponMaxNums = i;
    }
}
