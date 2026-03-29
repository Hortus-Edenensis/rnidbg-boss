package defpackage;

import android.content.ContentValues;
import com.zenmen.palmchat.Vo.ChatOneVo;
import com.zenmen.palmchat.Vo.RichMsgVo;
import im.youni.iccs.iprotobuf.domain.MessageProto;
import java.util.ArrayList;

/* JADX INFO: compiled from: SearchBox */
/* JADX INFO: loaded from: classes11.dex */
public class u30 extends o71 implements cs3 {
    @Override // defpackage.ln2
    public boolean a(MessageProto.Message message) {
        return message != null && message.getType() == 71 && message.getExType() == 0 && fu5.o(message) == 0;
    }

    @Override // defpackage.cs3
    public boolean c(ContentValues contentValues, MessageProto.Message message) {
        ChatOneVo chatOneVo;
        contentValues.put("msg_type", Integer.valueOf(message.getType()));
        RichMsgVo richMsgVo = (RichMsgVo) az2.a(message.getExtension(), RichMsgVo.class);
        if (richMsgVo == null || (chatOneVo = richMsgVo.chatOne) == null) {
            return true;
        }
        contentValues.put("message", chatOneVo.realContent);
        return true;
    }

    @Override // defpackage.o71, defpackage.ln2
    public void d(MessageProto.Message message) {
        super.d(message);
    }

    @Override // defpackage.o71, defpackage.ln2
    public void e(ArrayList<MessageProto.Message> arrayList) {
        super.e(arrayList);
    }

    @Override // defpackage.o71
    public boolean h() {
        return false;
    }
}
