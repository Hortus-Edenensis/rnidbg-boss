package com.zenmen.palmchat.Vo;

import androidx.annotation.Keep;
import com.zenmen.palmchat.chat.ChatBubble;
import com.zenmen.palmchat.contacts.ContactInfoItem;
import defpackage.fg6;
import defpackage.v4;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class ChatBubbleVo {
    public String bubbleId;
    public String bubbleTextColor;
    public int bubbleType;
    public Extra rev;
    public Extra send;
    public int vipStatus = 0;
    public int vipType = 0;

    /* JADX INFO: compiled from: SearchBox */
    @Keep
    public static class Extra {
        public String bubbleUrl;
    }

    public static ChatBubbleVo fromResponse(ChatBubble chatBubble) {
        if (chatBubble == null) {
            return null;
        }
        ChatBubbleVo chatBubbleVo = new ChatBubbleVo();
        chatBubbleVo.bubbleId = chatBubble.id;
        chatBubbleVo.bubbleTextColor = chatBubble.fontColor;
        if (chatBubble.send != null) {
            Extra extra = new Extra();
            chatBubbleVo.send = extra;
            extra.bubbleUrl = chatBubble.send.url;
        }
        if (chatBubble.rev != null) {
            Extra extra2 = new Extra();
            chatBubbleVo.rev = extra2;
            extra2.bubbleUrl = chatBubble.rev.url;
        }
        chatBubbleVo.bubbleType = chatBubble.useType;
        ContactInfoItem contactInfoItemF = v4.f();
        if (contactInfoItemF != null) {
            chatBubbleVo.vipStatus = fg6.g(contactInfoItemF.getExt());
            chatBubbleVo.vipType = fg6.p(contactInfoItemF.getExt());
        }
        return chatBubbleVo;
    }
}
