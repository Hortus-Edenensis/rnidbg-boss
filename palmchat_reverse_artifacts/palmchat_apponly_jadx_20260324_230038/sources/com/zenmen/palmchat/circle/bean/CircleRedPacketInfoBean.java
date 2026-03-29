package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleRedPacketInfoBean {
    private int couponType;
    private String couponTypeTips;
    private int detailDisplay;
    private int expireStatus;
    private String headIconUrl;
    private String nickname;
    private int receiveAll;
    private String receiveContent;
    private int receiveDisplay;
    private int receiveStatus;
    private String specificNickname;
    private String specificUid;
    private String uid;

    public int getCouponType() {
        return this.couponType;
    }

    public String getCouponTypeTips() {
        return this.couponTypeTips;
    }

    public int getDetailDisplay() {
        return this.detailDisplay;
    }

    public int getExpireStatus() {
        return this.expireStatus;
    }

    public String getHeadIconUrl() {
        return this.headIconUrl;
    }

    public String getNickname() {
        return this.nickname;
    }

    public boolean getReceiveAll() {
        return this.receiveAll == 1;
    }

    public String getReceiveContent() {
        return this.receiveContent;
    }

    public int getReceiveDisplay() {
        return this.receiveDisplay;
    }

    public int getReceiveStatus() {
        return this.receiveStatus;
    }

    public int getRedPacketEmpty() {
        return this.receiveAll;
    }

    public String getSpecificNickname() {
        return this.specificNickname;
    }

    public String getSpecificUid() {
        return this.specificUid;
    }

    public String getUid() {
        return this.uid;
    }

    public boolean isExpire() {
        return this.expireStatus == 1;
    }

    public boolean isReceiveStatus() {
        return this.receiveStatus == 1;
    }

    public boolean isShowDetailDisplay() {
        return this.detailDisplay == 1;
    }

    public boolean isShowReceiveDisplay() {
        return this.receiveDisplay == 1;
    }

    public void setCouponType(int i) {
        this.couponType = i;
    }

    public void setCouponTypeTips(String str) {
        this.couponTypeTips = str;
    }

    public void setDetailDisplay(int i) {
        this.detailDisplay = i;
    }

    public void setExpireStatus(int i) {
        this.expireStatus = i;
    }

    public void setHeadIconUrl(String str) {
        this.headIconUrl = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setReceiveAll(int i) {
        this.receiveAll = i;
    }

    public void setReceiveContent(String str) {
        this.receiveContent = str;
    }

    public void setReceiveDisplay(int i) {
        this.receiveDisplay = i;
    }

    public void setReceiveStatus(int i) {
        this.receiveStatus = i;
    }

    public void setSpecificNickname(String str) {
        this.specificNickname = str;
    }

    public void setSpecificUid(String str) {
        this.specificUid = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
