package com.zenmen.palmchat.giftkit.event;

import androidx.annotation.Keep;
import com.zenmen.palmchat.giftkit.SendGiftInfo;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class GiftSendResultEvent implements ds0.a {
    public long balance;
    public String errorMsg;
    public boolean isHit;
    public long itemId;
    public long needLxBean;
    public int panelId;
    public int ret;
    public int sceneType;
    public SendGiftInfo sendGiftInfo;
    public int sendNum;
    public boolean sendPackGift;
    public int toUidsCount;

    public GiftSendResultEvent() {
    }

    public GiftSendResultEvent(int i, int i2, boolean z, boolean z2, long j, long j2, int i3, int i4, long j3, int i5, String str, SendGiftInfo sendGiftInfo) {
        this.panelId = i;
        this.sceneType = i2;
        this.sendPackGift = z;
        this.isHit = z2;
        this.itemId = j;
        this.balance = j2;
        this.toUidsCount = i3;
        this.sendNum = i4;
        this.needLxBean = j3;
        this.ret = i5;
        this.errorMsg = str;
        this.sendGiftInfo = sendGiftInfo;
    }
}
