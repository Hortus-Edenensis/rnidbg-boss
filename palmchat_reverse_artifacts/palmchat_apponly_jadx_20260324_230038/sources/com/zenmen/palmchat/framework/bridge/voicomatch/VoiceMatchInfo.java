package com.zenmen.palmchat.framework.bridge.voicomatch;

import androidx.annotation.Keep;
import com.zenmen.palmchat.rtc.bean.RoomSDKInfo;
import com.zenmen.palmchat.rtc.bean.RoomUserInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class VoiceMatchInfo {
    public static final int ERROR_LOCATION_FAIL = -10088;
    public static final int ERROR_PERMISSION = -10089;
    public static final int NET_ERROR = -1;
    public static final int NET_ERROR_CONFIG = -2;
    public static final int NO_HIT_AB = 1020;
    public static final int NO_MONEY = 1022;
    public static final int PUNISH = 1021;
    public static final int TODAY_COUNT_LIMIT = 1023;
    public RoomSDKInfo chattinginfo;
    public int commentState;
    public String matchid;
    public List<SkuItem> skus;
    public String[] subTitle;
    public String[] title;
    public int errorCode = 0;
    public int currentLevel = 1;
    public int autoOpenIdMinutes = 1;
    public long startMatchTime = 0;
    public int from = 0;
    public int subPageFrom = 0;
    public VoiceMatchType voiceMatchType = VoiceMatchType.NORMAL;
    public boolean hasTriggerAutoOpenProfile = false;
    public boolean isVoiceMatch = true;
    public boolean isInvitedVideo = false;
    public boolean canInviteVideo = false;

    public int getAutoOpenIdMinutes() {
        return this.autoOpenIdMinutes;
    }

    public RoomUserInfo getMatchUserInfo() {
        ArrayList<RoomUserInfo> arrayList;
        RoomSDKInfo roomSDKInfo = this.chattinginfo;
        if (roomSDKInfo == null || (arrayList = roomSDKInfo.userList) == null || arrayList.size() <= 0) {
            return null;
        }
        return this.chattinginfo.userList.get(0);
    }

    public SkuItem getSkuItem(VoiceMatchType voiceMatchType) {
        List<SkuItem> list = this.skus;
        if (list == null) {
            return null;
        }
        for (SkuItem skuItem : list) {
            if (voiceMatchType.type == skuItem.id && (voiceMatchType != VoiceMatchType.SAME_CITY || skuItem.displayStatus)) {
                return skuItem;
            }
        }
        return null;
    }

    public boolean needRecharge() {
        return this.errorCode == 1022;
    }
}
