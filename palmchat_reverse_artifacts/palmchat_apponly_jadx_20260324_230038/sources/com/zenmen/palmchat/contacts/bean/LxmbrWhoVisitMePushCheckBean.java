package com.zenmen.palmchat.contacts.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class LxmbrWhoVisitMePushCheckBean {
    private long toUid;
    private boolean unVipAllowPushFlag;
    private boolean vipAllowPushFlag;
    private int vipStatus;
    private int vipType;

    public long getToUid() {
        return this.toUid;
    }

    public int getVipStatus() {
        return this.vipStatus;
    }

    public int getVipType() {
        return this.vipType;
    }

    public boolean isUnVipAllowPushFlag() {
        return this.unVipAllowPushFlag;
    }

    public boolean isVipAllowPushFlag() {
        return this.vipAllowPushFlag;
    }

    public void setToUid(long j) {
        this.toUid = j;
    }

    public void setUnVipAllowPushFlag(boolean z) {
        this.unVipAllowPushFlag = z;
    }

    public void setVipAllowPushFlag(boolean z) {
        this.vipAllowPushFlag = z;
    }

    public void setVipStatus(int i) {
        this.vipStatus = i;
    }

    public void setVipType(int i) {
        this.vipType = i;
    }
}
