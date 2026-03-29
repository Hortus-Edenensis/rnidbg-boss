package com.zenmen.palmchat.chat.specialattention;

import android.text.TextUtils;
import androidx.annotation.Keep;
import com.zenmen.palmchat.AppContext;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.bo0;
import defpackage.by5;
import defpackage.zg5;
import java.io.Serializable;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class NotificationUpdateInfo implements Serializable {
    public static final int TYPE_FEED = 2;
    public static final int TYPE_MSG = 1;
    public static final int TYPE_ONLINE_STATUS = 0;
    public String des;
    public boolean isOnline;
    public String jumpUrl;
    public long time;
    public int type = -1;
    public String uid;
    public int unRead;

    public NotificationUpdateInfo(String str) {
        this.uid = str;
    }

    public String getDesForShow() {
        int i = this.type;
        if (i == 0) {
            SpecialAttentionConfig specialAttentionConfigG = zg5.g();
            return this.isOnline ? specialAttentionConfigG.getOnlineDes() : specialAttentionConfigG.getOfflineDes();
        }
        if (i != 1) {
            return i == 2 ? TextUtils.isEmpty(this.des) ? "新动态" : this.des : "当前在线";
        }
        return "新消息：" + this.des;
    }

    public String getIconUrl() {
        ContactInfoItem contactInfoItemL;
        if (this.uid == null || (contactInfoItemL = bo0.r().l(this.uid)) == null) {
            return null;
        }
        return contactInfoItemL.getIconURL();
    }

    public String getTimeForShow() {
        return "连信·" + by5.d(this.time, AppContext.getContext());
    }

    public String getTitleForShow() {
        ContactInfoItem contactInfoItemL;
        return "[特别关注]" + ((this.uid == null || (contactInfoItemL = bo0.r().l(this.uid)) == null) ? "" : contactInfoItemL.getNameForShow());
    }

    public boolean needUpdateUi(NotificationUpdateInfo notificationUpdateInfo) {
        if (notificationUpdateInfo == null) {
            return false;
        }
        if (this.type == 1 && notificationUpdateInfo.type == 1) {
            if (this.time == notificationUpdateInfo.time && getDesForShow().equals(notificationUpdateInfo.getDesForShow())) {
                return false;
            }
        } else if (this.time == notificationUpdateInfo.time) {
            return false;
        }
        return true;
    }
}
