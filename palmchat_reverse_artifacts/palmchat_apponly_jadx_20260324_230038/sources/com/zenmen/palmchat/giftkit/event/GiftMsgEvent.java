package com.zenmen.palmchat.giftkit.event;

import androidx.annotation.Keep;
import defpackage.ds0;
import java.util.List;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class GiftMsgEvent implements ds0.a {
    public String bizData;
    public String guideMid;
    public int panelId;
    public String roomId;
    public List<String> toUserList;

    public GiftMsgEvent(int i, String str, List<String> list, String str2, String str3) {
        this.panelId = i;
        this.roomId = str;
        this.toUserList = list;
        this.bizData = str2;
        this.guideMid = str3;
    }
}
