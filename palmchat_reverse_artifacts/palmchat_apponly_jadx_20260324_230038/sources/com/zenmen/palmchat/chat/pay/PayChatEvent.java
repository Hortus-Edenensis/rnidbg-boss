package com.zenmen.palmchat.chat.pay;

import androidx.annotation.Keep;
import com.zenmen.palmchat.Vo.MessageVo;
import defpackage.ds0;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes13.dex */
@Keep
public class PayChatEvent implements ds0.a {
    public MessageVo messageVo;

    public PayChatEvent(MessageVo messageVo) {
        this.messageVo = messageVo;
    }
}
