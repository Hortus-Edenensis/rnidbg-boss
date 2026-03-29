package com.zenmen.palmchat.chat.gift;

import androidx.annotation.Keep;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ShowChatGiftPanelEvent implements ds0.a {
    public ContactInfoItem contactInfoItem;
    public MessageVo messageVo;

    public ShowChatGiftPanelEvent(MessageVo messageVo, ContactInfoItem contactInfoItem) {
        this.messageVo = messageVo;
        this.contactInfoItem = contactInfoItem;
    }
}
