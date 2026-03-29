package com.zenmen.palmchat.chat.gift.quicksend;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class QuickSendVo {
    public int give;
    public String iconUrl;
    public String intimacyGuideMid;
    public boolean isIntimacyFreeGift;
    public int itemCount;
    public long itemId;
    public String itemName;
    public long realPrice;
    public String supportTitle;

    public static QuickSendVo getTestItem(boolean z) {
        QuickSendVo quickSendVo = new QuickSendVo();
        if (z) {
            quickSendVo.give = 1;
            quickSendVo.itemName = "name";
            quickSendVo.supportTitle = "test";
            quickSendVo.realPrice = 0L;
            quickSendVo.itemId = 52104L;
            quickSendVo.itemCount = 4;
        } else {
            quickSendVo.give = 0;
            quickSendVo.itemName = "name";
            quickSendVo.supportTitle = null;
            quickSendVo.realPrice = 52L;
            quickSendVo.itemId = 30101L;
        }
        quickSendVo.iconUrl = "https://pics7.baidu.com/feed/a8773912b31bb05165ce88a887a274b948ede0aa.jpeg@f_auto?token=6e9d27f251e6392cd1713862c2689c62";
        return quickSendVo;
    }

    public boolean isPack() {
        return this.give == 1;
    }
}
