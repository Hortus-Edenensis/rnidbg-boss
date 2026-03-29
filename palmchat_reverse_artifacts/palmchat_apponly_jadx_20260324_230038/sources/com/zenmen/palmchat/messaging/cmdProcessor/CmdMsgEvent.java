package com.zenmen.palmchat.messaging.cmdProcessor;

import androidx.annotation.Keep;
import defpackage.ds0;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
@Keep
public class CmdMsgEvent implements ds0.a {
    public MessageProto.Message msg;

    private CmdMsgEvent(MessageProto.Message message) {
        this.msg = message;
    }

    public static CmdMsgEvent produceEvent(MessageProto.Message message) {
        return new CmdMsgEvent(message);
    }
}
