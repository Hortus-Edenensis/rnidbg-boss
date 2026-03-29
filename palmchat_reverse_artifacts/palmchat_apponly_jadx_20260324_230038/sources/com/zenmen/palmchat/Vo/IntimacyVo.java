package com.zenmen.palmchat.Vo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class IntimacyVo {
    public String fuid;
    public String giftLabel;
    public String iconUrl;
    public int itemCount;
    public long itemId;
    public String itemName;
    public int realPrice;
    public String supportTitle;
    public int type;
    public float value;

    public QuickSendVo convert2QuickSendVo() {
        QuickSendVo quickSendVo = new QuickSendVo();
        quickSendVo.give = 0;
        quickSendVo.itemName = this.itemName;
        quickSendVo.supportTitle = this.supportTitle;
        quickSendVo.realPrice = this.realPrice;
        quickSendVo.itemId = this.itemId;
        quickSendVo.iconUrl = this.iconUrl;
        quickSendVo.isIntimacyFreeGift = true;
        return quickSendVo;
    }
}
