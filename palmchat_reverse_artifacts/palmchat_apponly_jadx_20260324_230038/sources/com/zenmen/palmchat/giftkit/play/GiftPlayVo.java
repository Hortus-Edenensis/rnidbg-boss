package com.zenmen.palmchat.giftkit.play;

import androidx.annotation.Keep;
import defpackage.pu1;
import java.io.File;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class GiftPlayVo implements Serializable {
    public long comboNumber;
    public String fromUserAvatarUrl;
    public String fromUserId;
    public String fromUserName;
    public int giftMessageType;
    public String iconUrl;
    public long itemCount;
    public long itemId;
    public String itemName;
    public int priceLevel;
    public String relatedId;
    public String showIconUrl;
    public String toUserAvatarUrl;
    public String toUserId;
    public String toUserName;

    public String getGiftAnimationLocalPath() {
        return getGiftAnimationLocalPath(this.itemId);
    }

    public static String getGiftAnimationLocalPath(long j) {
        return pu1.q + File.separator + j + ".svga";
    }
}
