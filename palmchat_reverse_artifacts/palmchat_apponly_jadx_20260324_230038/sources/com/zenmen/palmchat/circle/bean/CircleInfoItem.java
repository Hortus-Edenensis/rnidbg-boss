package com.zenmen.palmchat.circle.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class CircleInfoItem {
    private String defaultRoomName;
    private int inRoom;
    private int memberNum;
    private String roomIcon;
    private String roomName;

    public String getDefaultRoomName() {
        return this.defaultRoomName;
    }

    public int getInRoom() {
        return this.inRoom;
    }

    public int getMemberNum() {
        return this.memberNum;
    }

    public String getRoomIcon() {
        return this.roomIcon;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setDefaultRoomName(String str) {
        this.defaultRoomName = str;
    }

    public void setInRoom(int i) {
        this.inRoom = i;
    }

    public void setMemberNum(int i) {
        this.memberNum = i;
    }

    public void setRoomIcon(String str) {
        this.roomIcon = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }
}
