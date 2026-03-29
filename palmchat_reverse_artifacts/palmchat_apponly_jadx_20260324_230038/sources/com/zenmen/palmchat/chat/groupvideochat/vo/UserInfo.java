package com.zenmen.palmchat.chat.groupvideochat.vo;

import com.zenmen.palmchat.rtc.bean.RoomUserInfo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
public class UserInfo {
    public String cid;
    public String icon;
    public int status;
    public String uid;

    public static RoomUserInfo convert(UserInfo userInfo) {
        RoomUserInfo roomUserInfo = new RoomUserInfo();
        roomUserInfo.nickName = "" + userInfo.uid;
        roomUserInfo.uid = userInfo.uid;
        roomUserInfo.headImg = userInfo.icon;
        roomUserInfo.status = userInfo.status;
        return roomUserInfo;
    }
}
