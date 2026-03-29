package com.zenmen.palmchat.rtc.bean;

import androidx.annotation.Keep;
import com.zenmen.palmchat.c;
import defpackage.v4;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class VoipCmdMsg {
    public static final int TYPE_ACCEPT = 2;
    public static final int TYPE_BUSY = 9;
    public static final int TYPE_CALL = 1;
    public static final int TYPE_CANCEL = 4;
    public static final int TYPE_GROUP_STATE = 7;
    public static final int TYPE_HANGUP = 6;
    public static final int TYPE_KICK = 8;
    public static final int TYPE_REFUSE = 3;
    public static final int TYPE_TIME_OUT = 5;
    public long callSTime;
    public RoomUserInfo caller;
    public long createTime;
    public long duration;
    public int exType;
    public String groupId;
    public int mediaType;
    public String roomId;
    public int roomStatus;
    public String roomToken;
    public int subType;
    public ArrayList<RoomUserInfo> userList;

    public String getTargetUid() {
        String strE = v4.e(c.b());
        if (!strE.equals(this.caller.uid)) {
            return this.caller.uid;
        }
        ArrayList<RoomUserInfo> arrayList = this.userList;
        if (arrayList != null && arrayList.size() > 0) {
            for (RoomUserInfo roomUserInfo : this.userList) {
                if (!strE.equals(roomUserInfo.uid)) {
                    return roomUserInfo.uid;
                }
            }
        }
        return null;
    }
}
