package com.zenmen.palmchat.Vo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.framework.bridge.voicomatch.SkuItem;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class AudioMatchCmdVo {
    public int autoOpenIDMinutes;
    public String inviteUid;
    public boolean isTimeoutOpenID;
    public int level;
    public String marquee;
    public int mediaType;
    public String roomId;
    public String roomToken;
    public List<SkuItem> skus;
    public String[] subTitle;
    public String[] title;
    public ArrayList<RoomUserInfo> userList;
    public int xp;

    public RoomSDKInfo convert2RoomSDKInfo() {
        RoomSDKInfo roomSDKInfo = new RoomSDKInfo();
        roomSDKInfo.roomId = this.roomId;
        roomSDKInfo.roomToken = this.roomToken;
        roomSDKInfo.userList = this.userList;
        return roomSDKInfo;
    }
}
