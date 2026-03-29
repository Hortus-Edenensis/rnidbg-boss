package com.zenmen.palmchat.rtc.bean;

import androidx.annotation.Keep;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class RoomSDKInfo implements Serializable {
    public String bid;
    public long callSTime;
    public String groupId;
    public String roomId;
    public String roomToken;
    public int type;
    public ArrayList<RoomUserInfo> userList;
}
