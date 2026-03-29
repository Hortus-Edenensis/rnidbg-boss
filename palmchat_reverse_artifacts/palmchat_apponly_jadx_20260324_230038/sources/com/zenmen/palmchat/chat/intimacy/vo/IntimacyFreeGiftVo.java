package com.zenmen.palmchat.chat.intimacy.vo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.chat.gift.quicksend.QuickSendVo;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class IntimacyFreeGiftVo {
    public String giftLabel;
    public QuickSendVo giftVo;
    public String text;
    public int type = 0;

    public static IntimacyFreeGiftVo genTest() {
        IntimacyFreeGiftVo intimacyFreeGiftVo = new IntimacyFreeGiftVo();
        intimacyFreeGiftVo.text = "hahahahahhaha";
        intimacyFreeGiftVo.giftVo = QuickSendVo.getTestItem(false);
        return intimacyFreeGiftVo;
    }
}
