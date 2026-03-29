package com.zenmen.palmchat.notification;

import androidx.annotation.Keep;
import com.zenmen.palmchat.notification.NotificationChannelManager;
import com.zenmen.palmchat.thirdpush.PushTokenManager;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class StrictConfig {
    public boolean enable;
    public boolean enablePush;
    public String manufacturer;
    public boolean tmpChatEnable;

    public boolean canNotify(NotificationChannelManager.MessageType messageType) {
        if (messageType == NotificationChannelManager.MessageType.MSG || !this.enablePush) {
            return true;
        }
        return true ^ isStrict();
    }

    public boolean isStrict() {
        PushTokenManager.PushType pushType;
        String str;
        return this.enable && (pushType = PushTokenManager.c) != null && (str = this.manufacturer) != null && str.contains(pushType.value);
    }

    public boolean isTmpChatStrict() {
        return this.tmpChatEnable && isStrict();
    }
}
