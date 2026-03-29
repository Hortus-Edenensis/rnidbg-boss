package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleCreate {
    private String[] members;
    private String roomId;

    public String[] getMembers() {
        return this.members;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public void setMembers(String[] strArr) {
        this.members = strArr;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }
}
