package com.zenmen.palmchat.chat.pay;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class PayChatInfo {
    public boolean needChatPay;
    public boolean needShowText;
    public String popupContent;
    public boolean senderNeedPay;
    public String sysContent;

    public boolean isNeedShowPayInfo() {
        return this.needShowText;
    }

    public boolean needChatPay() {
        return this.needChatPay;
    }

    public boolean needPayOnSendMsg() {
        return this.senderNeedPay;
    }
}
