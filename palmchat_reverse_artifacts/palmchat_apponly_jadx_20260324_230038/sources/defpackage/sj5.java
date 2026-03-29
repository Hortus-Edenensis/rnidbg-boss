package defpackage;

import com.zenmen.palmchat.Vo.MessageVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import com.zenmen.palmchat.chat.ChatItem;
import com.zenmen.square.mvp.model.bean.SquareFeedShareCard;
import defpackage.kn2;
import im.youni.iccs.iprotobuf.domain.MessageProto;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class sj5 extends u0 {
    public static MessageVo n(ChatItem chatItem, SquareFeedShareCard squareFeedShareCard) {
        MessageVo messageVoG = u0.g(chatItem);
        messageVoG.mimeType = 34;
        messageVoG.data1 = String.valueOf(1);
        RichMsgVo richMsgVo = new RichMsgVo();
        richMsgVo.squareShareFeed = squareFeedShareCard;
        messageVoG.extention = az2.c(richMsgVo);
        messageVoG.text = "对方发送了一张动态卡片信息，请升级app后查看";
        return messageVoG;
    }

    @Override // defpackage.zi0
    public boolean a(MessageVo messageVo) {
        return false;
    }

    @Override // defpackage.mn2
    public boolean c(MessageVo messageVo) {
        return messageVo.mimeType == 34;
    }

    @Override // defpackage.zi0
    public kn2 d(MessageVo messageVo, kn2.a aVar) {
        return null;
    }

    @Override // defpackage.u0
    public MessageProto.Message i(MessageVo messageVo) {
        return super.i(messageVo);
    }
}
