package com.zenmen.palmchat.gift.bean;

import androidx.annotation.Keep;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class GiftPanelBean {
    public int balance;
    public String desc;
    public boolean enable;
    public int giftId;
    public String giftName;
    public String giftPic;
    public String oneLocationPic;
    public boolean vip;

    public GiftPanelBean(int i, String str, boolean z, String str2, int i2) {
        this.giftName = str;
        this.giftId = i;
        this.enable = z;
        this.desc = str2;
        this.balance = i2;
    }
}
