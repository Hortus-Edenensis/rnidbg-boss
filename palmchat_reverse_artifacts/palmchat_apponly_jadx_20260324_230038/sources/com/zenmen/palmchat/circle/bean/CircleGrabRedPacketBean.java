package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleGrabRedPacketBean {
    private CircleApplyGroupType addModeResult;
    private int expireStatus;
    private int receiveAll;
    private int receiveStatus;
    private String roomId;

    public CircleApplyGroupType getAddModeResult() {
        return this.addModeResult;
    }

    public String getRoomId() {
        String str = this.roomId;
        return str == null ? "" : str;
    }

    public boolean isExpire() {
        return this.expireStatus == 1;
    }

    public boolean isReceiveAll() {
        return this.receiveAll == 1;
    }

    public boolean isReceiveStatus() {
        return this.receiveStatus == 1;
    }

    public void setAddModeResult(CircleApplyGroupType circleApplyGroupType) {
        this.addModeResult = circleApplyGroupType;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
