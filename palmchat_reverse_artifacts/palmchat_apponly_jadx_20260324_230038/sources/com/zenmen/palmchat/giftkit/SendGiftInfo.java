package com.zenmen.palmchat.giftkit;

import androidx.annotation.Keep;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class SendGiftInfo {
    public String bizExt;
    public int count;
    public String giftName;
    public String guideMid;
    public boolean isHit;
    public boolean isIntimacyFreeGift;
    public long itemId;
    public long needLxBean;
    public int panelId;
    public String relatedId;
    public String roomId;
    public int sceneType;
    public boolean sendPackGift;
    public long timestamps;
    public List<String> toUserList;

    public SendGiftInfo(int i, int i2, String str, boolean z, long j, int i3, boolean z2, String str2, List<String> list, String str3, long j2, long j3, String str4, boolean z3, String str5) {
        this.panelId = i;
        this.sceneType = i2;
        this.roomId = str;
        this.sendPackGift = z;
        this.itemId = j;
        this.count = i3;
        this.isHit = z2;
        this.relatedId = str2;
        this.toUserList = list;
        this.bizExt = str3;
        this.timestamps = j2;
        this.needLxBean = j3;
        this.guideMid = str4;
        this.isIntimacyFreeGift = z3;
        this.giftName = str5;
    }

    public void reSendGift() {
        b.j().l(this.panelId, this.sceneType, this.roomId, this.sendPackGift, this.itemId, this.count, this.isHit, this.relatedId, this.toUserList, this.bizExt, this.timestamps, this.needLxBean, this.guideMid, this.isIntimacyFreeGift, this.giftName);
    }
}
