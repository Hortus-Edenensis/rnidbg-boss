package defpackage;

import com.zenmen.palmchat.Vo.ChatOneVo;
import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import defpackage.kn2;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class v30 extends u0 {
    @Override // defpackage.zi0
    public boolean a(MessageVo messageVo) {
        return false;
    }

    @Override // defpackage.mn2
    public boolean c(MessageVo messageVo) {
        return messageVo.mimeType == 71;
    }

    @Override // defpackage.zi0
    public kn2 d(MessageVo messageVo, kn2.a aVar) {
        return null;
    }

    @Override // defpackage.u0
    public MessageProto.Message i(MessageVo messageVo) {
        ChatOneVo chatOneVo;
        MessageProto.Message.Builder builder = super.i(messageVo).toBuilder();
        RichMsgVo richMsgVo = (RichMsgVo) az2.a(messageVo.extention, RichMsgVo.class);
        if (richMsgVo != null && (chatOneVo = richMsgVo.chatOne) != null) {
            builder.setBody(chatOneVo.lowrealContent);
        }
        return builder.build();
    }
}
