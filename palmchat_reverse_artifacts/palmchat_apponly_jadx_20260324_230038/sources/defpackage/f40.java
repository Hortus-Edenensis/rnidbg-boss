package defpackage;

import com.zenmen.palmchat.Vo.ChatRiskVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.kotlin.common.SPUtil;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class f40 {

    /* JADX INFO: compiled from: SearchBox */
    public static class a extends a41 {
        @Override // defpackage.ln2
        public boolean a(MessageProto.Message message) {
            return f40.b(message);
        }

        @Override // defpackage.a41, defpackage.ln2
        public void d(MessageProto.Message message) {
            f40.c(message);
        }
    }

    public static boolean b(MessageProto.Message message) {
        return message.getType() == 51 && fu5.o(message) == 1;
    }

    public static void c(MessageProto.Message message) {
        d(message);
    }

    public static void d(MessageProto.Message message) {
        RichMsgVo richMsgVo;
        ChatRiskVo chatRiskVo;
        if (message == null || message.getExtension() == null || (richMsgVo = (RichMsgVo) az2.a(message.getExtension(), RichMsgVo.class)) == null || (chatRiskVo = richMsgVo.risk) == null || chatRiskVo.uid == null) {
            return;
        }
        SPUtil.f14322a.t(SPUtil.SCENE.CHAT_RISK, k86.a("key_chat_risk_item" + richMsgVo.risk.uid), message.getExtension());
    }
}
